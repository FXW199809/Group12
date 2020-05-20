package com.group12.salary.controller;


import com.group12.salary.config.Log4jUtil;
import com.group12.salary.config.MapperTools;
import com.group12.salary.dao.*;
import com.group12.salary.model.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * 审批
 */
@RestController
public class ExamineController {
    Log4jUtil log4jUtil = new Log4jUtil();
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/getSalaryList")
    @RequiresRoles("财务管理员")
    public List<SalaryDAO> getSalaryList() throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();
        SalaryDAOMapper salaryDAOMapper = sqlSession.getMapper(SalaryDAOMapper.class);
        SalaryDAOExample salaryDAOExample = new SalaryDAOExample();
        SalaryDAOExample.Criteria criteria = salaryDAOExample.createCriteria();
        criteria.andStatusEqualTo(0);
        List<SalaryDAO> salaryDAOList = salaryDAOMapper.selectByExample(salaryDAOExample);
        sqlSession.close();
        return salaryDAOList;
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/getDeductList")
    @RequiresRoles("财务管理员")
    public List<DeductDAO> getDeductList() throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();
        DeductDAOMapper deductDAOMapper = sqlSession.getMapper(DeductDAOMapper.class);

        DeductDAOExample deductDAOExample = new DeductDAOExample();
        DeductDAOExample.Criteria criteria = deductDAOExample.createCriteria();
        criteria.andStatusEqualTo(0);

        List<DeductDAO> deductDAOList = deductDAOMapper.selectByExample(deductDAOExample);
        sqlSession.close();
        return deductDAOList;
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/getSubsidyList")
    @RequiresRoles("财务管理员")
    public List<SubsidyDAO> getSubsidyList() throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();
        SubsidyDAOMapper subsidyDAOMapper = sqlSession.getMapper(SubsidyDAOMapper.class);

        SubsidyDAOExample subsidyDAOExample = new SubsidyDAOExample();
        SubsidyDAOExample.Criteria criteria = subsidyDAOExample.createCriteria();
        criteria.andStatusEqualTo(0);

        List<SubsidyDAO> subsidyDAOList = subsidyDAOMapper.selectByExample(subsidyDAOExample);
        sqlSession.close();
        return subsidyDAOList;
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/getChangeList")
    @RequiresRoles("财务管理员")
    public List<ChangeDAO> getChangeList() throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();
        ChangeDAOMapper changeDAOMapper = sqlSession.getMapper(ChangeDAOMapper.class);

        ChangeDAOExample changeDAOExample = new ChangeDAOExample();
        ChangeDAOExample.Criteria criteria = changeDAOExample.createCriteria();
        criteria.andStatusEqualTo(0);

        List<ChangeDAO> changeDAOList = changeDAOMapper.selectByExample(changeDAOExample);
        sqlSession.close();
        return changeDAOList;
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/getErrorList")
    @RequiresRoles("财务管理员")
    public List<ErrorDAO> getErrorList() throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();
        ErrorDAOMapper errorDAOMapper = sqlSession.getMapper(ErrorDAOMapper.class);

        ErrorDAOExample errorDAOExample = new ErrorDAOExample();
        ErrorDAOExample.Criteria criteria = errorDAOExample.createCriteria();
        criteria.andStatusEqualTo(0);

        List<ErrorDAO> errorDAOList = errorDAOMapper.selectByExample(errorDAOExample);
        sqlSession.close();
        return errorDAOList;
    }

    //括号里面是接口路径，long id, int status是前端传进来的参数
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/updateSalaryStatus")
    @RequiresRoles("财务管理员")
    public boolean updateSalaryStatus(long id, int status) throws IOException {
        UserDAO userDAO = (UserDAO) SecurityUtils.getSubject();//这句能获取当前登陆的用户
        //获取sqlSession，只有获取了sqlSession之后才能直接调用接口的方法
        //上面的操作也叫mapper接口代理
        //这里的接口是接口类
        SqlSession sqlSession = MapperTools.getSqlSession();
        SalaryDAOMapper salaryDAOMapper = sqlSession.getMapper(SalaryDAOMapper.class);

        //新建salaryDAO实体类，根据主键查询（selectByPrimaryKey(id)）
        SalaryDAO salaryDAO = salaryDAOMapper.selectByPrimaryKey(id);

        int beforeValue = salaryDAO.getStatus();

        //更新实体类，设置Status属性为status
        salaryDAO.setStatus(status);

        //再次调用接口中的方法updateByPrimaryKey(salaryDAO)，将更改后的salaryDao作为参数，更新数据库
        salaryDAOMapper.updateByPrimaryKey(salaryDAO);

        //提交sqlSession,使更改生效（更新删除插入都需要提交，因为改变了数据库）
        sqlSession.commit();
        //插入日志
        log4jUtil.init("t_salary", "status", String.valueOf(salaryDAO.getId()), String.valueOf(beforeValue), String.valueOf(status), userDAO.getUserId(), "update");

        //关闭sqlSession，避免资源浪费
        sqlSession.close();
        return true;
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/updateErrorStatus")
    @RequiresRoles("财务管理员")
    public boolean updateErrorStatus(long id, int status) throws IOException {
        UserDAO userDAO = (UserDAO) SecurityUtils.getSubject();//这句能获取当前登陆的用户
        SqlSession sqlSession = MapperTools.getSqlSession();
        ErrorDAOMapper errorDAOMapper = sqlSession.getMapper(ErrorDAOMapper.class);

        ErrorDAO errorDAO = errorDAOMapper.selectByPrimaryKey(id);
        int beforeValue = errorDAO.getStatus();
        errorDAO.setStatus(status);

        errorDAOMapper.updateByPrimaryKey(errorDAO);

        sqlSession.commit();
        //插入日志
        log4jUtil.init("t_error", "status", String.valueOf(errorDAO.getId()), String.valueOf(beforeValue), String.valueOf(status), userDAO.getUserId(), "update");

        sqlSession.close();
        return true;
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/updateChangeStatus")
    @RequiresRoles("财务管理员")
    public boolean updateChangeStatus(long id, int status) throws IOException {
        UserDAO userDAO = (UserDAO) SecurityUtils.getSubject();//这句能获取当前登陆的用户
        SqlSession sqlSession = MapperTools.getSqlSession();
        ChangeDAOMapper changeDAOMapper = sqlSession.getMapper(ChangeDAOMapper.class);

        ChangeDAO changeDAO = changeDAOMapper.selectByPrimaryKey(id);
        int beforeValue = changeDAO.getStatus();
        changeDAO.setStatus(status);

        changeDAOMapper.updateByPrimaryKey(changeDAO);

        sqlSession.commit();
        //插入日志
        log4jUtil.init("t_change", "status", String.valueOf(changeDAO.getId()), String.valueOf(beforeValue), String.valueOf(status), userDAO.getUserId(), "update");

        sqlSession.close();
        return true;
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/updateSubsidyStatus")
    @RequiresRoles("财务管理员")
    public boolean updateSubsidyStatus(long id, int status) throws IOException {
        UserDAO userDAO = (UserDAO) SecurityUtils.getSubject();//这句能获取当前登陆的用户
        SqlSession sqlSession = MapperTools.getSqlSession();
        SubsidyDAOMapper subsidyDAOMapper = sqlSession.getMapper(SubsidyDAOMapper.class);

        SubsidyDAO subsidyDAO = subsidyDAOMapper.selectByPrimaryKey(id);
        int beforeValue = subsidyDAO.getStatus();
        subsidyDAO.setStatus(status);

        subsidyDAOMapper.updateByPrimaryKey(subsidyDAO);

        //提交事务，更新数据库
        sqlSession.commit();
        //插入日志
        log4jUtil.init("t_subsidy", "status", String.valueOf(subsidyDAO.getId()), String.valueOf(beforeValue), String.valueOf(status), userDAO.getUserId(), "update");
        sqlSession.close();
        return true;
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/updateDeductStatus")
    @RequiresRoles("财务管理员")
    public boolean updateDeductStatus(long id, int status) throws IOException {
        UserDAO userDAO = (UserDAO) SecurityUtils.getSubject();//这句能获取当前登陆的用户
        SqlSession sqlSession = MapperTools.getSqlSession();
        DeductDAOMapper deductDAOMapper = sqlSession.getMapper(DeductDAOMapper.class);

        DeductDAO deductDAO = deductDAOMapper.selectByPrimaryKey(id);
        int beforeValue = deductDAO.getStatus();
        deductDAO.setStatus(status);

        deductDAOMapper.updateByPrimaryKey(deductDAO);

        sqlSession.commit();
        //插入日志
        log4jUtil.init("t_deduct", "status", String.valueOf(deductDAO.getId()), String.valueOf(beforeValue), String.valueOf(status), userDAO.getUserId(), "update");
        sqlSession.close();
        return true;
    }
}