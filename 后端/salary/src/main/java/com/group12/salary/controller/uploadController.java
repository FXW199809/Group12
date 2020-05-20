package com.group12.salary.controller;

import com.group12.salary.config.MapperTools;
import com.group12.salary.config.ReadExcel;
import com.group12.salary.dao.ChangeDAOMapper;
import com.group12.salary.dao.DeductDAOMapper;
import com.group12.salary.dao.ErrorDAOMapper;
import com.group12.salary.dao.SubsidyDAOMapper;
import com.group12.salary.model.ChangeDAO;
import com.group12.salary.model.DeductDAO;
import com.group12.salary.model.ErrorDAO;
import com.group12.salary.model.SubsidyDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class uploadController {
    /**
     * 导出补贴模板
     * @throws IOException
     */
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/downloadSubsidyExcel")
    @RequiresRoles("院系管理员")
    @ResponseBody
    public boolean downloadSubsidyExcel(HttpServletResponse response,HttpServletRequest request) {
        //方法一：直接下载路径下的文件模板
        try {
            //获取要下载的模板名称
            String fileName = "补贴清单表模板.xls";
            //设置要下载的文件的名称
            response.setHeader("Content-disposition", "attachment;fileName=" + fileName);
            //通知客服文件的MIME类型
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            //获取文件的路径
            String filePath = getClass().getResource("/templates/" + fileName).getPath();
            FileInputStream input = new FileInputStream(filePath);
            OutputStream out = response.getOutputStream();
            byte[] b = new byte[2048];
            int len;
            while ((len = input.read(b)) != -1) {
                out.write(b, 0, len);
            }
            //修正 Excel在“xxx.xlsx”中发现不可读取的内容。是否恢复此工作薄的内容？如果信任此工作簿的来源，请点击"是"
            response.setHeader("Content-Length", String.valueOf(input.getChannel().size()));
            input.close();
            //return Response.ok("应用导入模板下载完成");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            //logger.error("getApplicationTemplate :", ex);
            //return Response.ok("应用导入模板下载失败！");
            return false;
        }
    }
    /**
     * 导出扣款模板
     * @throws IOException
     */
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/downloadDeductExcel")
    @RequiresRoles("院系管理员")
    @ResponseBody
    public boolean downloadDeductExcel(HttpServletResponse response,HttpServletRequest request) {
        //方法一：直接下载路径下的文件模板
        try {
            //获取要下载的模板名称
            String fileName = "扣款清单表模板.xls";
            //设置要下载的文件的名称
            response.setHeader("Content-disposition", "attachment;fileName=" + fileName);
            //通知客服文件的MIME类型
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            //获取文件的路径
            String filePath = getClass().getResource("/templates/" + fileName).getPath();
            FileInputStream input = new FileInputStream(filePath);
            OutputStream out = response.getOutputStream();
            byte[] b = new byte[2048];
            int len;
            while ((len = input.read(b)) != -1) {
                out.write(b, 0, len);
            }
            //修正 Excel在“xxx.xlsx”中发现不可读取的内容。是否恢复此工作薄的内容？如果信任此工作簿的来源，请点击"是"
            response.setHeader("Content-Length", String.valueOf(input.getChannel().size()));
            input.close();
            //return Response.ok("应用导入模板下载完成");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            //logger.error("getApplicationTemplate :", ex);
            //return Response.ok("应用导入模板下载失败！");
            return false;
        }
    }
    /**
     * 导出职工工资变动表模板
     * @throws IOException
     */
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/downloadChangeExcel")
    //@RequiresRoles("院系管理员")
    @ResponseBody
    public boolean downloadChangeExcel(HttpServletResponse response,HttpServletRequest request) {
        //方法一：直接下载路径下的文件模板
        try {
            //获取要下载的模板名称
            String fileName = "职工工资变动表模板.xls";
            //设置要下载的文件的名称
            response.setHeader("Content-disposition", "attachment;fileName=" + fileName);
            //通知客服文件的MIME类型
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            //获取文件的路径
            String filePath = getClass().getResource("/templates/" + fileName).getPath();
            FileInputStream input = new FileInputStream(filePath);
            OutputStream out = response.getOutputStream();
            byte[] b = new byte[2048];
            int len;
            while ((len = input.read(b)) != -1) {
                out.write(b, 0, len);
            }
            //修正 Excel在“xxx.xlsx”中发现不可读取的内容。是否恢复此工作薄的内容？如果信任此工作簿的来源，请点击"是"
            response.setHeader("Content-Length", String.valueOf(input.getChannel().size()));
            input.close();
            //return Response.ok("应用导入模板下载完成");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            //logger.error("getApplicationTemplate :", ex);
            //return Response.ok("应用导入模板下载失败！");
            return false;
        }
    }
    /**
     * 导出错误信息表模板
     * @throws IOException
     */
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/downloadErrorExcel")
    @RequiresRoles("院系管理员")
    @ResponseBody
    public boolean downloadErrorExcel(HttpServletResponse response,HttpServletRequest request) {
        //方法一：直接下载路径下的文件模板
        try {
            //获取要下载的模板名称
            String fileName = "错误信息表模板.xls";
            //设置要下载的文件的名称
            response.setHeader("Content-disposition", "attachment;fileName=" + fileName);
            //通知客服文件的MIME类型
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            //获取文件的路径
            String filePath = getClass().getResource("/templates/" + fileName).getPath();
            FileInputStream input = new FileInputStream(filePath);
            OutputStream out = response.getOutputStream();
            byte[] b = new byte[2048];
            int len;
            while ((len = input.read(b)) != -1) {
                out.write(b, 0, len);
            }
            //修正 Excel在“xxx.xlsx”中发现不可读取的内容。是否恢复此工作薄的内容？如果信任此工作簿的来源，请点击"是"
            response.setHeader("Content-Length", String.valueOf(input.getChannel().size()));
            input.close();
            //return Response.ok("应用导入模板下载完成");
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            //logger.error("getApplicationTemplate :", ex);
            //return Response.ok("应用导入模板下载失败！");
            return false;
        }
    }

    /**
     * 上传文件
     */
    /*
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/uploadSubsidy")
    @RequiresRoles("院系管理员")
    @ResponseBody
    public boolean uploadSubsidy(HttpServletRequest request,@RequestParam("SubsidyExcelFile") MultipartFile file) throws IOException {
        //String fileName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
        List<SubsidyDAO> list = ReadExcel.ReadSubsidyExcel(file);
        SqlSession sqlSession = MapperTools.getSqlSession();
        SubsidyDAOMapper subsidyDAOMapper = sqlSession.getMapper(SubsidyDAOMapper.class);
        for(int i=0;i<list.size();i++){
            if(null == list.get(i)){
                return false;
            }
            else {
                subsidyDAOMapper.insert(list.get(i));
            }
        }
        sqlSession.commit();
        sqlSession.close();
        return true;
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/uploadDeduct")
    @RequiresRoles("院系管理员")
    @ResponseBody
    public boolean uploadDeduct(HttpServletRequest request,@RequestParam("DeductExcelFile") MultipartFile file) throws IOException {
        //String fileName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
        List<DeductDAO> list = ReadExcel.ReadDeductExcel(file);
        SqlSession sqlSession = MapperTools.getSqlSession();
        DeductDAOMapper deductDAOMapper = sqlSession.getMapper(DeductDAOMapper.class);
        for(int i=0;i<list.size();i++){
            if(null == list.get(i)){
                return false;
            }
            else {
                deductDAOMapper.insert(list.get(i));
            }
        }
        sqlSession.commit();
        sqlSession.close();
        return true;
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/uploadError")
    @RequiresRoles("院系管理员")
    @ResponseBody
    public boolean uploadError(HttpServletRequest request,@RequestParam("ErrorExcelFile") MultipartFile file) throws IOException {
        //String fileName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
        List<ErrorDAO> list = ReadExcel.ReadErrorExcel(file);
        SqlSession sqlSession = MapperTools.getSqlSession();
        ErrorDAOMapper errorDAOMapper = sqlSession.getMapper(ErrorDAOMapper.class);
        for(int i=0;i<list.size();i++){
            if(null == list.get(i)){
                return false;
            }
            else {
                errorDAOMapper.insert(list.get(i));
            }
        }
        sqlSession.commit();
        sqlSession.close();
        return true;
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/uploadChange")
    @RequiresRoles("院系管理员")
    @ResponseBody
    public boolean uploadChange(HttpServletRequest request,@RequestParam("ChangeExcelFile") MultipartFile file) throws IOException {
        //String fileName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
        List<ChangeDAO> list = ReadExcel.ReadChangeExcel(file);
        SqlSession sqlSession = MapperTools.getSqlSession();
        ChangeDAOMapper changeDAOMapper = sqlSession.getMapper(ChangeDAOMapper.class);
        for(int i=0;i<list.size();i++){
            if(null == list.get(i)){
                return false;
            }
            else {
                changeDAOMapper.insert(list.get(i));
            }
        }
        sqlSession.commit();
        sqlSession.close();
        return true;
    }*/
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/uploadSubsidy")
    //@RequiresRoles("院系管理员")
    @ResponseBody
    public boolean uploadSubsidy(String id,String userid,String name,String food,String coal ,String transport,String subsidy1,String subsidy2,String subsidyTotal,String submitUserId) throws IOException {
        if(null != userid && null != id){
            SqlSession sqlSession = MapperTools.getSqlSession();
            SubsidyDAOMapper subsidyDAOMapper = sqlSession.getMapper(SubsidyDAOMapper.class);
            SubsidyDAO subsidyDAO = new SubsidyDAO();
            Long i = new Long(id);
            subsidyDAO.setId(i);
            subsidyDAO.setUserId(userid);
            subsidyDAO.setName(name);
            BigDecimal f =new BigDecimal(food);
            subsidyDAO.setFood(f);
            BigDecimal c =new BigDecimal(coal);
            subsidyDAO.setCoal(c);
            BigDecimal t =new BigDecimal(transport);
            subsidyDAO.setTransport(t);
            BigDecimal s1 =new BigDecimal(subsidy1);
            subsidyDAO.setSubsidy1(s1);
            BigDecimal s2 =new BigDecimal(subsidy2);
            subsidyDAO.setSubsidy2(s2);
            BigDecimal s =new BigDecimal(subsidyTotal);;
            subsidyDAO.setSubsidyTotal(s);
            subsidyDAO.setSubmitUserId(submitUserId);
            Date date = new Date();
            subsidyDAO.setSubmitDate(date);
            subsidyDAO.setStatus(0);
            subsidyDAOMapper.insert(subsidyDAO);

            sqlSession.commit();
            sqlSession.close();
            return true;
        }
        else{
            return false;
        }
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/uploadDeduct")
    //@RequiresRoles("院系管理员")
    @ResponseBody
    public boolean uploadDeduct(String id,String userid,String name, String room, String waterElectric ,String children, String advance,String other, String deductTotal,String submitUserId) throws IOException {
        if(null != userid && null != id){
            SqlSession sqlSession = MapperTools.getSqlSession();
            DeductDAOMapper deductDAOMapper = sqlSession.getMapper(DeductDAOMapper.class);
            DeductDAO deductDAO = new DeductDAO();
            Long i = new Long(id);
            deductDAO.setId(i);
            deductDAO.setUserId(userid);
            deductDAO.setName(name);
            BigDecimal r =new BigDecimal(room);
            deductDAO.setRoom(r);
            BigDecimal w =new BigDecimal(waterElectric);
            deductDAO.setWaterElectric(w);
            BigDecimal c =new BigDecimal(children);
            deductDAO.setChildren(c);
            BigDecimal a =new BigDecimal(advance);
            deductDAO.setAdvance(a);
            BigDecimal o =new BigDecimal(other);
            deductDAO.setOther(o);
            BigDecimal d =new BigDecimal(deductTotal);
            deductDAO.setDeductTotal(d);
            deductDAO.setSubmitUserId(submitUserId);
            Date date = new Date();
            deductDAO.setSubmitDate(date);
            deductDAO.setStatus(0);
            deductDAOMapper.insert(deductDAO);

            sqlSession.commit();
            sqlSession.close();
            return true;
        }
        else{
            return false;
        }
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/uploadError")
    //@RequiresRoles("院系管理员")
    @ResponseBody
    public boolean uploadError(String id,String userid,String name,String item,String wrongData,String revisedData ,String submitUserId) throws IOException {
        if(null != userid && null != id){
            SqlSession sqlSession = MapperTools.getSqlSession();
            ErrorDAOMapper errorDAOMapper = sqlSession.getMapper(ErrorDAOMapper.class);
            ErrorDAO errorDAO = new ErrorDAO();
            Long i = new Long(id);
            errorDAO.setId(i);
            errorDAO.setUserId(userid);
            errorDAO.setName(name);
            errorDAO.setItem(item);
            BigDecimal w =new BigDecimal(wrongData);
            errorDAO.setWrongData(w);
            BigDecimal r =new BigDecimal(revisedData);
            errorDAO.setRevisedData(r);
            errorDAO.setSubmitUserId(submitUserId);
            Date date = new Date();
            errorDAO.setSubmitDate(date);
            errorDAO.setStatus(0);
            errorDAOMapper.insert(errorDAO);

            sqlSession.commit();
            sqlSession.close();
            return true;
        }
        else{
            return false;
        }
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/uploadChange")
    //@RequiresRoles("院系管理员")
    @ResponseBody
    public boolean uploadChange(String id,String userid,String name,String beforeMoney,String afterMoney,String submitUserId) throws IOException {
        if(null != userid && null != id){
            SqlSession sqlSession = MapperTools.getSqlSession();
            ChangeDAOMapper changeDAOMapper = sqlSession.getMapper(ChangeDAOMapper.class);
            ChangeDAO changeDAO = new ChangeDAO();
            Long i = new Long(id);
            changeDAO.setId(i);
            changeDAO.setUserId(userid);
            changeDAO.setName(name);
            BigDecimal b =new BigDecimal(beforeMoney);
            changeDAO.setBeforeMoney(b);
            BigDecimal a =new BigDecimal(afterMoney);
            changeDAO.setAfterMoney(a);
            changeDAO.setSubmitUserId(submitUserId);
            Date date = new Date();
            changeDAO.setSubmitDate(date);
            changeDAO.setStatus(0);
            changeDAOMapper.insert(changeDAO);

            sqlSession.commit();
            sqlSession.close();
            return true;
        }
        else{
            return false;
        }
    }
}
