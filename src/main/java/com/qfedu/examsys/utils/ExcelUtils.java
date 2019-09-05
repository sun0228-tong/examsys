package com.qfedu.examsys.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Name ExcelUtils
 * @Author Yama
 * @Date 2019/8/28 15:38
 * @Version V1.0
 */
public class ExcelUtils {

    public static List<Map<String, Object>> readExcel(String filename, InputStream inputStream) throws IOException {
        List<Map<String, Object>> list = new ArrayList<>();

        boolean ret = isXLs(filename);

        Workbook workbook = null;
        if (ret == true) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            workbook = new XSSFWorkbook(inputStream);
        }

        Sheet sheet = workbook.getSheetAt(0);
        // 标题
        Row row = sheet.getRow(0);
        // 获取 row 里最后一个单元格编号
        short lastCellNum = row.getLastCellNum();

        // 获取最后一行的行号
        int lastRowNum = sheet.getLastRowNum();

        for (int i = 1; i <= lastRowNum; i++) {
            Map<String, Object> map = new HashMap<>();
            Row row1 = sheet.getRow(i);
            for (int j = 0; j < lastCellNum; j++) {
                Cell cell = row1.getCell(j);
                if (cell == null) {
                    continue;
                }
                cell.setCellType(CellType.STRING);
                map.put(row.getCell(j).getStringCellValue(), cell.getStringCellValue());
            }
            list.add(map);
        }
        return list;
    }

    // 判断EXCEL文件的后缀，如果是xls后缀，返回true,xlsx 返回 false
    private static boolean isXLs(String filename) {
        // 正则表达式中（？i）表示不区分大小写
        if(filename.matches("^.+\\.(?i)(xls)$")) {
            return true;
        } else {
            return false;
        }

    }
}
