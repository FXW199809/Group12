package com.group12.salary.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

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
    public String login(String userid, String password) throws IOException {
       /* SqlSession sqlSession = MapperTools.getSqlSession();

        UserDAOMapper userDAOMapper = sqlSession.getMapper(UserDAOMapper.class);

        //后面这里写判断用户名密码的程序

        UserDAOExample userDAOExample = new UserDAOExample();
        UserDAOExample.Criteria criteria = userDAOExample.createCriteria();
        // criteria.andUserIdEqualTo(userID);
        criteria.andNameEqualTo(name);
        List<UserDAO> userDAOList = userDAOMapper.selectByExample(userDAOExample);
        for (int i = 0; i < userDAOList.size(); i++) {
            System.out.println(userDAOList.get(i).getPassword());
            if(userDAOList.get(i).getPassword().equals(password)){
                return 200;
            }

        }
        return 404;*/
        /*User queryUser=userDao.queryUserByName(user.getName(),user.getPassword());
        if(queryUser==null){
            return 404;
        }else{
            return 200;
        }*/
        UsernamePasswordToken token = new UsernamePasswordToken(userid,password);
        System.out.println(token);
        Subject subject = SecurityUtils.getSubject();
        try{
            //判断登陆
            subject.login(token);
        }catch (Exception e){
            e.printStackTrace();
            return "/";
        }
        if(subject.hasRole("用户")){
            return "/Normalmain";
        }else if(subject.hasRole("财务管理员")){
            return "/HelloWorld";
        }else if(subject.hasRole("院系管理员")){
            return "/Yuanximain";
        }else {
            return "/";
        }
    }


}
