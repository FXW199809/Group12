package com.group12.salary.controller;

import com.group12.salary.dao.SalaryDAOMapper;
import com.group12.salary.model.SalaryDAO;
import com.group12.salary.model.SalaryDAOExample;
import com.group12.salary.config.MapperTools;
import org.apache.ibatis.session.SqlSession;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;


@RestController
public class GetStaffController {

	//查询员工
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping("/getStaffSearch")
	@RequiresRoles("财务管理员")
	public @ResponseBody List<SalaryDAO> getStaffSearch(String UserId) throws IOException {
		SqlSession sqlSession = MapperTools.getSqlSession();
		SalaryDAOMapper salaryDAOMapper = sqlSession.getMapper(SalaryDAOMapper.class);

		SalaryDAOExample salaryDAOExample = new SalaryDAOExample();
		SalaryDAOExample.Criteria criteria = salaryDAOExample.createCriteria();

		criteria.andUserIdEqualTo(UserId).andStatusEqualTo(1);
		List<SalaryDAO> salaryDAOList = salaryDAOMapper.selectByExample(salaryDAOExample);
		//关闭sqlsession,避免资源浪费
		sqlSession.close();
	    return salaryDAOList;
    }

    //���ܹ���ʵ�֣���ʾԱ�����ʱ�
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping("/getStaffGather")
	@RequiresRoles("财务管理员")
	public List<SalaryDAO> getStaffGather() throws IOException {
		SqlSession sqlSession = MapperTools.getSqlSession();

		SalaryDAOMapper salaryDAOMapper = sqlSession.getMapper(SalaryDAOMapper.class);
		SalaryDAOExample salaryDAOExample = new SalaryDAOExample();
		SalaryDAOExample.Criteria criteria = salaryDAOExample.createCriteria();
		//查询已经审核过的工资
		criteria.andStatusEqualTo(1);
		List<SalaryDAO> salaryDAOList = salaryDAOMapper.selectByExample(salaryDAOExample);

		sqlSession.close();
		return salaryDAOList;
	}

}
