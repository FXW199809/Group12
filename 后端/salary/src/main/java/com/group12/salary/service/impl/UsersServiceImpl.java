package com.group12.salary.service.impl;

import com.group12.salary.dao.*;
import com.group12.salary.model.*;
import com.group12.salary.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UserDAOMapper userDao;
    @Autowired
    private RoleDAOMapper roleDao;
    @Autowired
    private RightDAOMapper rightDao;
    @Autowired
    private UserRoleDAOMapper userRoleDao;
    @Autowired
    private UserRightDAOMapper userRightDao;

    //根据用户id查找用户
    public UserDAO findByUserID(String userId){
        return userDao.selectByPrimaryKey(userId);
    }

    //根据用户id查找用户角色
    public Set<String> findRole(String userId){
        Set<String> roleNameSet = new HashSet<>();
        UserRoleDAO userRoleList = userRoleDao.selectByUserID(userId);
        RoleDAO role = roleDao.selectByPrimaryKey(userRoleList.getRoleId());
        roleNameSet.add(role.getRoleName());
        return roleNameSet;
    }

    //根据用户名查找用户权限
    public Set<String> findRight(String userid){
        Set<String> rightNameSet = new HashSet<>();
        UserRightDAO userRightDAOList = userRightDao.selectByUserID(userid);
        RightDAO right = rightDao.selectByPrimaryKey(userRightDAOList.getRightId());
        rightNameSet.add(right.getRightName());
        return rightNameSet;
    }
    //省略set方法
}
