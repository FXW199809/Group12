package com.group12.salary.config;

import com.group12.salary.model.ChangeDAO;
import com.group12.salary.model.DeductDAO;
import com.group12.salary.model.ErrorDAO;
import com.group12.salary.model.SubsidyDAO;
import jxl.Sheet;
import jxl.Workbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadExcel {
    /**
     * 工具类MultipartFileToFile
     * @param file
     * @return
     * @throws Exception
     */
    public static File multipartFileToFile(MultipartFile file) throws Exception {

        File toFile = null;
        if (file.equals("") || file.getSize() <= 0) {
            file = null;
        } else {
            InputStream ins = null;
            ins = file.getInputStream();
            toFile = new File(file.getOriginalFilename());
            inputStreamToFile(ins, toFile);
            ins.close();
        }
        return toFile;
    }
    //获取流文件
    private static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除本地临时文件
     * @param file
     */
    public static void delteTempFile(File file) {
        if (file != null) {
            File del = new File(file.toURI());
            del.delete();
        }
    }

    public static List<SubsidyDAO> ReadSubsidyExcel(MultipartFile file) {
        List<SubsidyDAO> list = new ArrayList<SubsidyDAO> ();
        try {
            Workbook rwb = Workbook.getWorkbook(multipartFileToFile(file));
            Sheet rs = rwb.getSheet(0);// 或者rwb.getSheet(0)
            int clos = rs.getColumns();// 得到所有的列
            int rows = rs.getRows();// 得到所有的行
            System.out.println(clos + " rows:" + rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    // 第一个是列数，第二个是行数
                    //String userId = rs.getCell(j++, i).getContents();// 默认最左边编号也算一列
                    //if (userId == null || "".equals(userId))userId = "0";
                    // 所以这里得j++
                    long id = Long.parseLong(rs.getCell(j++, i).getContents());
                    String userid = rs.getCell(j++, i).getContents();
                    String name = rs.getCell(j++, i).getContents();
                    BigDecimal food = new BigDecimal(rs.getCell(j++, i).getContents());
                    BigDecimal coal = new BigDecimal(rs.getCell(j++, i).getContents());
                    BigDecimal transport = new BigDecimal(rs.getCell(j++, i).getContents());
                    BigDecimal subsidy1 = new BigDecimal(rs.getCell(j++, i).getContents());
                    BigDecimal subsidy2 = new BigDecimal(rs.getCell(j++, i).getContents());
                    BigDecimal subsidyTotal = new BigDecimal(rs.getCell(j++, i).getContents());
                    String subsidyUserId = rs.getCell(j++, i).getContents();
                    Date submitDate = new Date();
                    int status = 0;
                    SubsidyDAO subsidyDAO = new SubsidyDAO();
                    subsidyDAO.setId(id);
                    subsidyDAO.setUserId(userid);
                    subsidyDAO.setName(name);
                    subsidyDAO.setFood(food);
                    subsidyDAO.setCoal(coal);
                    subsidyDAO.setTransport(transport);
                    subsidyDAO.setSubsidy1(subsidy1);
                    subsidyDAO.setSubsidy2(subsidy2);
                    subsidyDAO.setSubsidyTotal(subsidyTotal);
                    subsidyDAO.setSubmitUserId(subsidyUserId);
                    subsidyDAO.setSubmitDate(submitDate);
                    subsidyDAO.setStatus(status);
                    list.add(subsidyDAO);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static List<DeductDAO> ReadDeductExcel(MultipartFile file) {
        List<DeductDAO> list = new ArrayList<DeductDAO> ();
        try {
            Workbook rwb = Workbook.getWorkbook(multipartFileToFile(file));
            Sheet rs = rwb.getSheet(0);// 或者rwb.getSheet(0)
            int clos = rs.getColumns();// 得到所有的列
            int rows = rs.getRows();// 得到所有的行
            System.out.println(clos + " rows:" + rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    // 第一个是列数，第二个是行数
                    //String userId = rs.getCell(j++, i).getContents();// 默认最左边编号也算一列
                    //if (userId == null || "".equals(userId))userId = "0";
                    // 所以这里得j++
                    long id = Long.parseLong(rs.getCell(j++, i).getContents());
                    String userid = rs.getCell(j++, i).getContents();
                    String name = rs.getCell(j++, i).getContents();
                    BigDecimal room = new BigDecimal(rs.getCell(j++, i).getContents());
                    BigDecimal waterElectric = new BigDecimal(rs.getCell(j++, i).getContents());
                    BigDecimal children = new BigDecimal(rs.getCell(j++, i).getContents());
                    BigDecimal advance = new BigDecimal(rs.getCell(j++, i).getContents());
                    BigDecimal other = new BigDecimal(rs.getCell(j++, i).getContents());
                    BigDecimal deductTotal = new BigDecimal(rs.getCell(j++, i).getContents());
                    String subsidyUserId = rs.getCell(j++, i).getContents();
                    Date submitDate = new Date();
                    int status = 0;
                    DeductDAO deductDAO = new DeductDAO();
                    deductDAO.setId(id);
                    deductDAO.setUserId(userid);
                    deductDAO.setName(name);
                    deductDAO.setRoom(room);
                    deductDAO.setWaterElectric(waterElectric);
                    deductDAO.setChildren(children);
                    deductDAO.setAdvance(advance);
                    deductDAO.setOther(other);
                    deductDAO.setDeductTotal(deductTotal);
                    deductDAO.setSubmitUserId(subsidyUserId);
                    deductDAO.setSubmitDate(submitDate);
                    deductDAO.setStatus(status);
                    list.add(deductDAO);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static List<ErrorDAO> ReadErrorExcel(MultipartFile file) {
        List<ErrorDAO> list = new ArrayList<ErrorDAO> ();
        try {
            Workbook rwb = Workbook.getWorkbook(multipartFileToFile(file));
            Sheet rs = rwb.getSheet(0);// 或者rwb.getSheet(0)
            int clos = rs.getColumns();// 得到所有的列
            int rows = rs.getRows();// 得到所有的行
            System.out.println(clos + " rows:" + rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    // 第一个是列数，第二个是行数
                    //String userId = rs.getCell(j++, i).getContents();// 默认最左边编号也算一列
                    //if (userId == null || "".equals(userId))userId = "0";
                    // 所以这里得j++
                    long id = Long.parseLong(rs.getCell(j++, i).getContents());
                    String userid = rs.getCell(j++, i).getContents();
                    String name = rs.getCell(j++, i).getContents();
                    String item = rs.getCell(j++, i).getContents();
                    BigDecimal wrongData = new BigDecimal(rs.getCell(j++, i).getContents());
                    BigDecimal revisedData = new BigDecimal(rs.getCell(j++, i).getContents());
                    String subsidyUserId = rs.getCell(j++, i).getContents();
                    Date submitDate = new Date();
                    int status = 0;
                    ErrorDAO errorDAO = new ErrorDAO();
                    errorDAO.setId(id);
                    errorDAO.setUserId(userid);
                    errorDAO.setName(name);
                    errorDAO.setItem(item);
                    errorDAO.setWrongData(wrongData);
                    errorDAO.setRevisedData(revisedData);
                    errorDAO.setSubmitUserId(subsidyUserId);
                    errorDAO.setSubmitDate(submitDate);
                    errorDAO.setStatus(status);
                    list.add(errorDAO);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static List<ChangeDAO> ReadChangeExcel(MultipartFile file) {
        List<ChangeDAO> list = new ArrayList<ChangeDAO> ();
        try {
            Workbook rwb = Workbook.getWorkbook(multipartFileToFile(file));
            Sheet rs = rwb.getSheet(0);// 或者rwb.getSheet(0)
            int clos = rs.getColumns();// 得到所有的列
            int rows = rs.getRows();// 得到所有的行
            System.out.println(clos + " rows:" + rows);
            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < clos; j++) {
                    // 第一个是列数，第二个是行数
                    //String userId = rs.getCell(j++, i).getContents();// 默认最左边编号也算一列
                    //if (userId == null || "".equals(userId))userId = "0";
                    // 所以这里得j++
                    long id = Long.parseLong(rs.getCell(j++, i).getContents());
                    String userid = rs.getCell(j++, i).getContents();
                    String name = rs.getCell(j++, i).getContents();
                    BigDecimal beforeMoney = new BigDecimal(rs.getCell(j++, i).getContents());
                    BigDecimal afterMoney = new BigDecimal(rs.getCell(j++, i).getContents());
                    String subsidyUserId = rs.getCell(j++, i).getContents();
                    Date submitDate = new Date();
                    int status = 0;
                    ChangeDAO changeDAO = new ChangeDAO();
                    changeDAO.setId(id);
                    changeDAO.setUserId(userid);
                    changeDAO.setName(name);
                    changeDAO.setBeforeMoney(beforeMoney);
                    changeDAO.setAfterMoney(afterMoney);
                    changeDAO.setSubmitUserId(subsidyUserId);
                    changeDAO.setSubmitDate(submitDate);
                    changeDAO.setStatus(status);
                    list.add(changeDAO);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
