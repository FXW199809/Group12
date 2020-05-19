package com.group12.salary.controller;

import com.group12.salary.config.MapperTools;
import com.group12.salary.dao.UserDAOMapper;
import com.group12.salary.dao.UserRightDAOMapper;
import com.group12.salary.dao.UserRoleMapper;
import com.group12.salary.model.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class manageController {
    @RequestMapping("/getUserInfoList")
    @RequiresRoles("财务管理员")
    public List<UserInfo> getUserInfoList() throws IOException {
        SqlSession sqlSession = MapperTools.getSqlSession();
        //查询所有user
        UserDAOMapper userDAOMapper = sqlSession.getMapper(UserDAOMapper.class);
        UserDAOExample UserDAOExample = new UserDAOExample();
        UserDAOExample.Criteria criteria = UserDAOExample.createCriteria();
        criteria.andUserIdIsNotNull();
        List<UserDAO> UserDAOList = userDAOMapper.selectByExample(UserDAOExample);
        //查询所有user_right
        UserRightDAOMapper userRightDAOMapper = sqlSession.getMapper(UserRightDAOMapper.class);
        UserRightDAOExample UserRightDAOExample = new UserRightDAOExample();
        UserRightDAOExample.Criteria criteria1 = UserRightDAOExample.createCriteria();
        criteria1.andUserIdIsNotNull();
        List<UserRightDAO> UserRightDAOList = userRightDAOMapper.selectByExample(UserRightDAOExample);
        //合并user_list
        sqlSession.close();
        List<UserInfo> UserInfoList = new ArrayList<>();
        for(int i=0;i< UserDAOList.size();i++){
            UserInfo userInfo = new UserInfo();
            UserDAO userDAO = UserDAOList.get(i);
            //本程序中user只对应一个right
            UserRightDAO userRightDAO = userRightDAOMapper.selectByUserID(userDAO.getUserId()).get(0);
            userInfo.setUserDAO(userDAO);
            userInfo.setUserRightDAO(userRightDAO);
            UserInfoList.set(i,userInfo);
        }
        return UserInfoList;
    }
    @RequestMapping("/addUser")
    @RequiresRoles("财务管理员")
    public boolean addUser(String userid,String password,String name,String bankCard,String departmentId,String title,Integer workingAge,long right)throws IOException{
        SqlSession sqlSession = MapperTools.getSqlSession();
        UserDAOMapper userDAOMapper = sqlSession.getMapper(UserDAOMapper.class);
        UserDAO userDAO = new UserDAO();
        userDAO.setUserId(userid);
        userDAO.setPassword(password);
        userDAO.setName(name);
        userDAO.setBankCard(bankCard);
        userDAO.setDepartmentId(departmentId);
        userDAO.setTitle(title);
        userDAO.setWorkingAge(workingAge);
        userDAOMapper.insert(userDAO);

        UserRightDAOMapper userRightDAOMapper = sqlSession.getMapper(UserRightDAOMapper.class);
        UserRightDAO userRightDAO = new UserRightDAO();
        userRightDAO.setRightId(right);
        userRightDAO.setUserId(userid);
        userRightDAOMapper.insert(userRightDAO);

        UserRoleMapper userRoleMapper = sqlSession.getMapper(UserRoleMapper.class);
        UserRole userRole = new UserRole();
        userRole.setRoleId(right);
        userRole.setUserId(userid);
        userRoleMapper.insert(userRole);

        sqlSession.commit();
        sqlSession.close();
        return true;
    };

    @RequestMapping("/deleteUser")
    @RequiresRoles("财务管理员")
    public boolean deleteUser(String userid) throws IOException{
        SqlSession sqlSession = MapperTools.getSqlSession();
        UserDAOMapper userDAOMapper = sqlSession.getMapper(UserDAOMapper.class);

        userDAOMapper.deleteByPrimaryKey(userid);

        sqlSession.commit();
        sqlSession.close();
        return true;
    }

    @RequestMapping("/updateUser")
    @RequiresRoles("财务管理员")
    public boolean updateUser(String userid,String password,String name,String bankCard,String departmentId,String title,Integer workingAge,long right)throws IOException{
        SqlSession sqlSession = MapperTools.getSqlSession();
        UserDAOMapper userDAOMapper = sqlSession.getMapper(UserDAOMapper.class);
        UserDAO userDAO = new UserDAO();
        userDAO.setUserId(userid);
        userDAO.setPassword(password);
        userDAO.setName(name);
        userDAO.setBankCard(bankCard);
        userDAO.setDepartmentId(departmentId);
        userDAO.setTitle(title);
        userDAO.setWorkingAge(workingAge);
        userDAOMapper.updateByPrimaryKey(userDAO);

        UserRightDAOMapper userRightDAOMapper = sqlSession.getMapper(UserRightDAOMapper.class);
        UserRightDAO userRightDAO = new UserRightDAO();
        userRightDAO.setRightId(right);
        userRightDAO.setUserId(userid);
        userRightDAOMapper.updateByPrimaryKey(userRightDAO);

        UserRoleMapper userRoleMapper = sqlSession.getMapper(UserRoleMapper.class);
        UserRole userRole = new UserRole();
        userRole.setRoleId(right);
        userRole.setUserId(userid);
        userRoleMapper.updateByPrimaryKey(userRole);

        sqlSession.commit();
        sqlSession.close();
        return true;
    };
}
