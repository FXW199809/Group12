package com.group12.salary.controller;
import com.group12.salary.dao.UserDAOMapper;
import com.group12.salary.model.UserDAO;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;



@Controller
@RequestMapping(value = "/ChangeInfo")
    public class UpdateController{
    public boolean ChangeInfo(String email, String telephone, String bank_card)
            throws IOException
    {
            //加载配置文件
            InputStream inputStream = UpdateController.class.getClassLoader().getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //获取实现接口的代理对象
            UserDAOMapper userDAOMapper = sqlSession.getMapper(UserDAOMapper.class);
            //获取当前登陆的用户
            UserDAO userDAO = (UserDAO) SecurityUtils.getSubject();
            //修改数据库信息

            //userDAO.getUserId();
            userDAO.setEmail("email");
            userDAO.setBankCard("telephone");
            userDAO.setTelephone("bank_card");
            //userDAOMapper.updateByPrimaryKey();
            userDAOMapper.updateByPrimaryKey(userDAO);
            //提交事务
            sqlSession.commit();
            //关闭数据库
            sqlSession.close();

            return true;
        }



}

