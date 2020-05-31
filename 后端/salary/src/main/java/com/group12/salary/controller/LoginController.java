package com.group12.salary.controller;

import com.group12.salary.config.MapperTools;
import com.group12.salary.dao.RightDAOMapper;
import com.group12.salary.dao.UserDAOMapper;
import com.group12.salary.dao.UserRightDAOMapper;
import com.group12.salary.dao.UserRoleDAOMapper;
import com.group12.salary.model.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class LoginController {
    /*private final UserDao userDao;
    public LoginController(UserDao userDao){
        this.userDao=userDao;
    }*/
    /*@RequestMapping("/login")
    public String login(String userID, String password) throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();

        UserDAOMapper userDAOMapper = sqlSession.getMapper(UserDAOMapper.class);

       //UserRoleMapper userRoleMapper=sqlSession.getMapper(UserRoleMapper.class);
        //后面这里写判断用户名密码的程序

        UserDAOExample userDAOExample = new UserDAOExample();
        UserDAOExample.Criteria criteria = userDAOExample.createCriteria();
        criteria.andUserIdEqualTo(userID);
        *//*criteria.andNameEqualTo(name);*//*

        //UserRoleExample userRoleExample=new UserRoleExample();
        //UserRoleExample.Criteria criteria=userRoleExample.createCriteria();
       // criteria.andUserIdEqualTo(userID);

        List<UserDAO> userDAOList = userDAOMapper.selectByExample(userDAOExample);
        for (int i = 0; i < userDAOList.size(); i++) {
            System.out.println(userDAOList.get(i).getPassword());
            if(userDAOList.get(i).getPassword().equals(password)){



                return "200";
            }
        }
        //return 404;
        *//*User queryUser=userDao.queryUserByName(user.getName(),user.getPassword());
        if(queryUser==null){
            return 404;
        }else{
            return 200;
        }*//*
        return "404";
    }*/
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(value="/login",produces = "application/json;charset=utf-8")
    public String login(String name, String password,String title) throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();

        UserDAOMapper userDAOMapper = sqlSession.getMapper(UserDAOMapper.class);

        //后面这里写判断用户名密码的程序

        UserDAOExample userDAOExample = new UserDAOExample();
        UserDAOExample.Criteria criteria = userDAOExample.createCriteria();
        /* criteria.andUserIdEqualTo(userID);*/
        criteria.andNameEqualTo(name);
        List<UserDAO> userDAOList = userDAOMapper.selectByExample(userDAOExample);
        //查询所有user_right
        UserRightDAOMapper userRightDAOMapper = sqlSession.getMapper(UserRightDAOMapper.class);
        UserRightDAOExample UserRightDAOExample = new UserRightDAOExample();
        UserRightDAOExample.Criteria criteria1 = UserRightDAOExample.createCriteria();
        criteria1.andUserIdIsNotNull();
        List<UserRightDAO> UserRightDAOList = userRightDAOMapper.selectByExample(UserRightDAOExample);
        for (int i = 0; i < userDAOList.size(); i++) {
            System.out.println(userDAOList.get(i).getPassword());
            if(userDAOList.get(i).getPassword().equals(password)){
                UserDAO userDAO=userDAOList.get(i);
                //本程序中user只对应一个right
                if (null != userRightDAOMapper.selectByUserID(userDAO.getUserId())) {
                    UserRightDAO userRightDAO = userRightDAOMapper.selectByUserID(userDAO.getUserId());
                    //权限名
                    RightDAOMapper rightDAOMapper = sqlSession.getMapper(RightDAOMapper.class);
                    RightDAOExample RightDAOExample = new RightDAOExample();
                    RightDAOExample.Criteria criteria3 = RightDAOExample.createCriteria();
                    criteria3.andRightIdEqualTo(userRightDAO.getRightId());
                    List<RightDAO> rightDAOList = rightDAOMapper.selectByExample(RightDAOExample);
                    String rightName = rightDAOList.get(0).getRightName();
                    if (rightName.equals("上传")) {
                        return "院系";
                    } else if (rightName.equals("管理")) {
                        return "财务";
                    } else {
                        return "用户";
                    }
                }
                // return 200;
            }
        }
        //return 404;
        return "dl";

        /*User queryUser=userDao.queryUserByName(user.getName(),user.getPassword());
        if(queryUser==null){
            return 404;
        }else{
            return 200;
        }*/
    }


}
