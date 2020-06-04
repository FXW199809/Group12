package com.group12.salary.controller;

import com.group12.salary.config.MapperTools;
import com.group12.salary.dao.UserDAOMapper;
import com.group12.salary.model.UserDAO;
import com.group12.salary.model.UserDAOExample;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class UpdatePassController {

    /*@RequestMapping("/change")
    public int UpdatePass(String userID,String password) throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();

        UserDAOMapper userDAOMapper = sqlSession.getMapper(UserDAOMapper.class);
        UserDAO userDAO=new UserDAO();
       // UserDAOExample userDAOExample = new UserDAOExample();
        //UserDAOExample.Criteria criteria = userDAOExample.createCriteria();
       // criteria.andUserIdEqualTo(userID);
        //List<UserDAO> userDAOList = userDAOMapper.selectByExample(userDAOExample);
       *//* for (int i = 0; i < userDAOList.size(); i++) {

            if(userDAOList.get(i).getUserId().equals(userID)){
                userDAOMapper.updateByPrimaryKeySelective(userDAO);
                return 200;
            }
        }
        return 404;*//*

        userDAO= userDAOMapper.selectByPrimaryKey(userID);

        userDAO.setPassword(password);

        userDAOMapper.updateByPrimaryKey(userDAO);
        sqlSession.commit();
        sqlSession.close();
        return 200;

    }*/
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/change")
    public int UpdatePass(String userID,String oldPassword,String newPassword,String ckPassword) throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();

        UserDAOMapper userDAOMapper = sqlSession.getMapper(UserDAOMapper.class);
        UserDAO userDAO = new UserDAO();
        userDAO = userDAOMapper.selectByPrimaryKey(userID);
        if (oldPassword.equals(userDAO.getPassword()) && (ckPassword.equals(newPassword))) {//修改密码的前提是用户输入的id和原密码正确

            userDAO.setPassword(newPassword);
            userDAOMapper.updateByPrimaryKey(userDAO);
            sqlSession.commit();
            sqlSession.close();
            return 200;
        }else{
            return 404;
        }


    }

}
