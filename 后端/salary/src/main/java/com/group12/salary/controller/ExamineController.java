package com.group12.salary.controller;


import com.group12.salary.config.MapperTools;
import com.group12.salary.dao.*;
import com.group12.salary.model.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * 审批
 */
@RestController
public class ExamineController {

    @RequestMapping("/getSalaryList")
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
    @RequestMapping("/getDeductList")
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
    @RequestMapping("/getSubsidyList")
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
    @RequestMapping("/getChangeList")
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
    @RequestMapping("/getErrorList")
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

    @RequestMapping("/updateSalaryStatus")
    public boolean updateSalaryStatus(long id, int status) throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();
        SalaryDAOMapper salaryDAOMapper = sqlSession.getMapper(SalaryDAOMapper.class);

        SalaryDAO salaryDAO = salaryDAOMapper.selectByPrimaryKey(id);
        salaryDAO.setStatus(status);

        salaryDAOMapper.updateByPrimaryKey(salaryDAO);

        sqlSession.commit();
        sqlSession.close();
        return true;
    }
    @RequestMapping("/updateErrorStatus")
    public boolean updateErrorStatus(long id, int status) throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();
        ErrorDAOMapper errorDAOMapper = sqlSession.getMapper(ErrorDAOMapper.class);

        ErrorDAO errorDAO = errorDAOMapper.selectByPrimaryKey(id);
        errorDAO.setStatus(status);

        errorDAOMapper.updateByPrimaryKey(errorDAO);

        sqlSession.commit();
        sqlSession.close();
        return true;
    }
    @RequestMapping("/updateChangeStatus")
    public boolean updateChangeStatus(long id, int status) throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();
        ChangeDAOMapper changeDAOMapper = sqlSession.getMapper(ChangeDAOMapper.class);

        ChangeDAO changeDAO = changeDAOMapper.selectByPrimaryKey(id);
        changeDAO.setStatus(status);

        changeDAOMapper.updateByPrimaryKey(changeDAO);

        sqlSession.commit();
        sqlSession.close();
        return true;
    }
    @RequestMapping("/updateSubsidyStatus")
    public boolean updateSubsidyStatus(long id, int status) throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();
        SubsidyDAOMapper subsidyDAOMapper = sqlSession.getMapper(SubsidyDAOMapper.class);

        SubsidyDAO subsidyDAO = subsidyDAOMapper.selectByPrimaryKey(id);
        subsidyDAO.setStatus(status);

        subsidyDAOMapper.updateByPrimaryKey(subsidyDAO);

        sqlSession.commit();
        sqlSession.close();
        return true;
    }
    @RequestMapping("/updateDeductStatus")
    public boolean updateDeductStatus(long id, int status) throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();
        DeductDAOMapper deductDAOMapper = sqlSession.getMapper(DeductDAOMapper.class);

        DeductDAO deductDAO = deductDAOMapper.selectByPrimaryKey(id);
        deductDAO.setStatus(status);

        deductDAOMapper.updateByPrimaryKey(deductDAO);

        sqlSession.commit();
        sqlSession.close();
        return true;
    }
}
