package com.example.demo.server.controller;

import com.example.demo.common.CommonReturnType;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.URLDecoder;

@RestController
@RequestMapping("file")
public class FileController {

    @RequestMapping(value = "export", method = RequestMethod.GET)
    public CommonReturnType export() throws IOException {
        File outFile = null;
        String fileName = "导出文件.xlsx";
        //导出文件路径，要存在target路径下，才能被访问到
        String realPath = this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
        try{
            realPath = URLDecoder.decode(realPath, "utf-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        String dstFileName = realPath + "static/" + fileName;
        if (System.getProperty("os.name").contains("Windows") && dstFileName.charAt(0)=='/'){
            dstFileName = dstFileName.substring(1);
        }
        System.out.println("文件路径："+dstFileName);
        // 根据导出文件路径，新建文件
        outFile = new File(dstFileName);
        if (outFile.exists()){
            outFile.delete();
        }
        if (!outFile.getParentFile().exists()){
            boolean mkdir = outFile.getParentFile().mkdirs();
            if (!mkdir){
                return CommonReturnType.error("文件目录创建失败，请重试！");
            }
        }

        // 往文件里写入文件流，并保存
        Workbook workbook = new XSSFWorkbook();
        String sheetName = "Sheet 1";
        XSSFSheet sheet = (XSSFSheet) workbook.createSheet(sheetName);

        Row row1 = sheet.createRow(0);
        Cell row11 = row1.createCell(0);
        row11.setCellValue("导出文件测试字符串");

        FileOutputStream fileOutputStream = new FileOutputStream(dstFileName);
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        workbook.close();

        return CommonReturnType.ok(fileName);
    }
}
