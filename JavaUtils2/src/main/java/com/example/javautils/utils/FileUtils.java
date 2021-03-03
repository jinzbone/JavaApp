package com.utils;

import java.io.File;
import java.io.UnsupportedEncodingException;

public class FileUtils {
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
