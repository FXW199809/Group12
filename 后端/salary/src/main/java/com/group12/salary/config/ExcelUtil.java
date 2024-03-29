package com.group12.salary.config;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
public class ExcelUtil {

    private FileOutputStream fos;
    private static int NUM = 10000;// 一个sheet的记录数
    private static String level1 = "1";
    private static String level2 = "2";
    private static String level3 = "3";
    private static String level4 = "4";

    /**
     * @param title
     *            每个Sheet里的顶部大标题
     * @param column
     *            单个sheet里每行数据的列对应的对象属性名称
     *            column ="rule_name,cityName,specName,ivrName,contactGroup,specName,RulestCont".split(",");
     * @param data
     *            数据
     * @param fileName
     *            文件名
     */
    public void getOutputFile(String[] title, String[] column, List<Map<String,Object>> data, String fileName, String filePath) {
        if (title == null || title.equals("")) {
            System.out.println("Excel表格 标题(表头)为空");
        }
        if (column == null || column.equals("")) {
            System.out.println("没有定义取值字段集合");
        }
        if (data == null || data.equals("")) {
            System.out.println("没有定义导出数据集合");
        }
        if (fileName == null || fileName.equals("")) {
            System.out.println("没有定义输出文件名");
        }
        //System.out.println("cuiwhvyuer111");
        HSSFWorkbook workbook = null;

        try {

            fos = new FileOutputStream(filePath + "/" + fileName + ".xls");

            workbook = new HSSFWorkbook();// 创建Excel
            HSSFSheet sheet = null; // 工作表
            HSSFRow row = null; // 行
            HSSFCell cell = null; // 行--列

            Iterator it = data.iterator();
            int i = 0;

            // 字体
            HSSFFont font = workbook.createFont();
            //8表示黑色
            font.setColor((short) 8);
            font.setFontHeightInPoints((short) 10);
            //设置加粗
            font.setBold(true);

            // 父告警标题样式
            HSSFCellStyle pStyle = workbook.createCellStyle();
            pStyle.setFont(font);

            // 子告警标题样式
            // HSSFCellStyle sStyle = workbook.createCellStyle();
            // sStyle.setFont(font);
            // sStyle.setFillBackgroundColor((short) 0x3399CC);

            // 告警样式
            HSSFCellStyle level1Style = workbook.createCellStyle();
            HSSFPalette palette = workbook.getCustomPalette();
            palette.setColorAtIndex((short) 9, (byte) (0xFF), (byte) (0x00),
                    (byte) (0x00));
            palette.setColorAtIndex((short) 10, (byte) (0xFF), (byte) (0xA5),
                    (byte) (0x00));
            palette.setColorAtIndex((short) 11, (byte) (0xFF), (byte) (0xFF),
                    (byte) (0x00));
            palette.setColorAtIndex((short) 12, (byte) (0x41), (byte) (0x69),
                    (byte) (0xE1));
            level1Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            //level1Style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            level1Style.setFillForegroundColor((short) 9);
            HSSFCellStyle level2Style = workbook.createCellStyle();
            level2Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            //level2Style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            level2Style.setFillForegroundColor((short) 10);
            HSSFCellStyle level3Style = workbook.createCellStyle();
            level3Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            //level3Style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            level3Style.setFillForegroundColor((short) 11);
            HSSFCellStyle level4Style = workbook.createCellStyle();
            level4Style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            //level4Style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            level4Style.setFillForegroundColor((short) 12);


            sheet = workbook.createSheet("Sheet0"); // 工作簿
            row = sheet.createRow(0);

            // 在每一页的第一行输入标题
            for (int j = 0; j < title.length; j++) {
                cell = row.createCell(j);
                cell.setCellValue(new HSSFRichTextString(title[j]));
                cell.setCellStyle(pStyle);
            }

            //转换日期格式
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");


            // 逐行添加数据
            int k = 0;
            while (it.hasNext()) {
                if (i / NUM > k) { // 每50000条记录分一页
                    k = i / NUM;
                    sheet = workbook.createSheet("Sheet" + k);
                    row = sheet.createRow(0);
                    for (int j = 0; j < title.length; j++) {
                        cell = row.createCell(j);
                        cell.setCellValue(new HSSFRichTextString(title[i]));
                    }
                }

                Map dataMap = (Map) it.next();
                row = sheet.createRow(i - NUM * k + 1);

                // 输出数据
                for (int j = 0; j < column.length; j++) {
                    cell = row.createCell(j);
                    // 按字段取值
                    String columnName = column[j];	//取值的key
                    System.out.println(columnName);

                    //这里不能用“==”，只能用equals，不知道为什么
                    if(columnName.equals("yearMonthDate")){
                        cell.setCellValue(simpleDateFormat.format(dataMap.get(columnName)));
                        //System.out.println("111");
                    }else{
                        cell.setCellValue(new HSSFRichTextString(String.valueOf(dataMap.get(columnName))));
                        //System.out.println("222");
                    }
                    String value = String.valueOf(dataMap.get(columnName));
                    if (value.equalsIgnoreCase("null") && !value.equals("0")) {
                        String level = String.valueOf(dataMap.get(columnName)
                                + "_level");
                        if (!level.equalsIgnoreCase("null") && !level.equalsIgnoreCase("")) {
                            if (level1.equals(level)) {
                                cell.setCellStyle(level1Style);
                            } else if (level2.equals(level)) {
                                cell.setCellStyle(level2Style);
                            } else if (level3.equals(level)) {
                                cell.setCellStyle(level3Style);
                            } else if (level4.equals(level)) {
                                cell.setCellStyle(level4Style);
                            }
                        } else {
                            cell.setCellStyle(level1Style);
                        }
                    }
                }
                i++;
            }
            // 写入流
            workbook.write(fos);
            fos.flush();
            fos.close();
            System.out.println("Excel 文件导出完成");
        } catch (Exception e) {
            System.out.println("Excel导出错误: ");
            e.printStackTrace();
        }

    }
}
