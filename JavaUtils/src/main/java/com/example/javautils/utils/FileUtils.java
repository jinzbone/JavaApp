package com.example.javautils.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class FileUtils {

    /**
     * @Title: 下载文件（在windows和linux下都运行正常）
     * @Description:
     * @Author: zhangjing
     */
    public void downLoadFile(HttpServletResponse response) throws Exception {
        String fileName = "新建 Microsoft Excel 工作表.xlsx";

        // 重点在这里 windows和Linux环境下的区别，下面这种形式都可以
        ClassPathResource resource = new ClassPathResource("template\\" + fileName);

        if (resource == null) {
            System.out.println("文件不存在");
            throw new Exception("文件不存在");
        }

        ServletOutputStream sos = null;
        InputStream inputStream = null;
        try {
            fileName = URLDecoder.decode(fileName, "UTF-8");

            response.reset();

            response.setContentType("application/x-msdownload");

            // 添加请求头，避免下载中文乱码
            fileName = new String(fileName.getBytes("gbk"), "iso-8859-1");
            response.addHeader("Content-Disposition", "attachment; filename=" + fileName);

            inputStream = resource.getInputStream();

            sos = response.getOutputStream();
            int i;
            while ((i = inputStream.read()) != -1) {
                sos.write(i);
            }
            sos.flush();
        } catch (Exception e) {
        } finally {
            closeStream(sos, inputStream);
        }
    }
    private void closeStream(ServletOutputStream sos, InputStream inputStream) {
        try {
            if (sos != null) {
                sos.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @Title: 下载文件（在windows正常，在linux会报错，下载0kb）
     * @Description:
     * @Author: zhangjing
     */
    public ResponseEntity<FileSystemResource> export() throws UnsupportedEncodingException {
        File file = getFile();
        if (file == null) {
            return null;
        }
        System.out.println(file.getName());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        // 如果文件是中文名需要进行转码
        headers.add("Content-Disposition", "attachment; filename=" + new String(file.getName().getBytes("UTF-8"), "iso-8859-1"));
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new FileSystemResource(file));
    }
    public File getFile() {
        //resources文件夹中保存要下载的文件名
        String fileName = "新建 Microsoft Excel 工作表.xlsx";
        //指定目标文件名，此处将文件保存在项目的resource目录下，也可以保存在本地的其他目录下
        String destFileName = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "main"
                + File.separator + "resources"
                + File.separator + fileName;
        //新建目标文件
        System.out.println(destFileName);
        File destFile = new File(destFileName);
        return destFile;
    }
}
