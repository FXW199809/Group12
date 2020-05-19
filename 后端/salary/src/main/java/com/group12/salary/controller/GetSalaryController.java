package com.group12.salary.controller;

import com.group12.salary.dao.UserDAOMapper;
import com.group12.salary.model.UserDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.InputStream;


/**
 * @RequestMapping("/getStaffSearch")
 * 当前端调用getSalarySearch时会转到当前的Controller
 * 运行当前类里的方法
 *
 */

@Controller
@RequestMapping("/getSalarySearch")
@RequiresRoles("院系管理员")
public class GetSalaryController {
    public UserDAO getSalarySearch(String UserId){
		/*
		SalaryDAO UserDAO = UserDaoService.selectByUserId(UserId);*/
        //加载配置文件
        InputStream inputStream = GetSalaryController.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取实现接口的代理对象
        UserDAOMapper userDAOMapper = sqlSession.getMapper(UserDAOMapper.class);

		/*UserDAOExample salaryDAOExample = new UserDAOExample();
		UserDAOExample.Criteria criteria = userDAOExample.createCriteria();
		criteria.andUserIdEqualTo(UserId).andUserIdIsNotNull();*/
        UserDAO userDAO = userDAOMapper.selectByPrimaryKey(UserId);

        return userDAO;
    }
}
