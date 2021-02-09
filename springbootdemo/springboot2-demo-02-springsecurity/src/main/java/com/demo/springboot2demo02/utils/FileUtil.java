package com.demo.springboot2demo02.utils;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class FileUtil {

    /**
     * @Description: 文件上传，并保存在resources文件夹
     * @Author: zhangjing
     * @Date:
     * @Version 1.0
     */
    public static Map<String, Object> localUpload(MultipartFile file) {
        Map<String, Object> resultMap=new HashMap<>();
        try {
            //原文件名加上时间戳作为上传后保存的文件名
            String fileName=System.currentTimeMillis()+file.getOriginalFilename();
            //指定目标文件名，此处将文件保存在项目的resource目录下，也可以保存在本地的其他目录下
            String destFileName=System.getProperty("user.dir")
                    +File.separator+"src"
                    +File.separator+"main"
                    +File.separator+"resources"
                    +File.separator+"upload"
                    +File.separator+fileName;
            //新建目标文件
            File destFile = new File(destFileName);
            //创建目标文件的存储路径
            destFile.getParentFile().mkdirs();
            //将前端接收的文件转化为目标文件
            file.transferTo(destFile);
            //将上传后的文件名和存储路径返回
            resultMap.put("fileName",fileName);
            resultMap.put("path",destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    /**
     * @Description: 文件下载，提供resources文件夹下的文件下载功能
     * @Author: zhangjing
     * @Date:
     * @Version 1.0
     */
    public static ResponseEntity<FileSystemResource> export() throws UnsupportedEncodingException {
        // 1-获取要下载的文件
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
    // 要下载的文件
    public static File getFile() {
        //resources文件夹中保存要下载的文件名
        String fileName = "test.txt";
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
