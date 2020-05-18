package com.group12.salary.controller;

import com.group12.salary.config.MapperTools;
import com.group12.salary.dao.UserDAOMapper;
import com.group12.salary.model.UserDAO;
import com.group12.salary.model.UserDAOExample;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class LoginController {
    /*private final UserDao userDao;
    public LoginController(UserDao userDao){
        this.userDao=userDao;
    }*/
    /*@RequestMapping("/login")
    public int login(String userID, String password) throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();

        UserDAOMapper userDAOMapper = sqlSession.getMapper(UserDAOMapper.class);

        //后面这里写判断用户名密码的程序

        UserDAOExample userDAOExample = new UserDAOExample();
        UserDAOExample.Criteria criteria = userDAOExample.createCriteria();
       *//* criteria.andUserIdEqualTo(userID);*//*
        criteria.andNameEqualTo(name);
        List<UserDAO> userDAOList = userDAOMapper.selectByExample(userDAOExample);
        for (int i = 0; i < userDAOList.size(); i++) {
            System.out.println(userDAOList.get(i).getPassword());
            if(userDAOList.get(i).getPassword().equals(password)){
                return 200;
            }
        }
        return 404;
        *//*User queryUser=userDao.queryUserByName(user.getName(),user.getPassword());
        if(queryUser==null){
            return 404;
        }else{
            return 200;
        }*//*
    }*/
    @RequestMapping(value="/login",produces = "application/json;charset=utf-8")
    public int login(String name, String password) throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();

        UserDAOMapper userDAOMapper = sqlSession.getMapper(UserDAOMapper.class);

        //后面这里写判断用户名密码的程序

        UserDAOExample userDAOExample = new UserDAOExample();
        UserDAOExample.Criteria criteria = userDAOExample.createCriteria();
        /* criteria.andUserIdEqualTo(userID);*/
        criteria.andNameEqualTo(name);
        List<UserDAO> userDAOList = userDAOMapper.selectByExample(userDAOExample);
        for (int i = 0; i < userDAOList.size(); i++) {
            System.out.println(userDAOList.get(i).getPassword());
            if(userDAOList.get(i).getPassword().equals(password)){
                return 200;
            }
        }
        return 404;
        /*User queryUser=userDao.queryUserByName(user.getName(),user.getPassword());
        if(queryUser==null){
            return 404;
        }else{
            return 200;
        }*/
    }


}
