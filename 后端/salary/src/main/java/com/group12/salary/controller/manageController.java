package com.group12.salary.controller;

import com.group12.salary.config.MapperTools;
import com.group12.salary.dao.*;
import com.group12.salary.model.*;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class manageController {
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/getUserInfoList")
    //@RequiresRoles("财务管理员")
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

        List<UserInfo> UserInfoList = new ArrayList<>();
        for(int i=0;i< UserDAOList.size();i++){
            UserInfo userInfo = new UserInfo();
            UserDAO userDAO = UserDAOList.get(i);
            //本程序中user只对应一个right
            if (null != userRightDAOMapper.selectByUserID(userDAO.getUserId())&&userRightDAOMapper.selectByUserID(userDAO.getUserId()).size()!=0){
                UserRightDAO userRightDAO = userRightDAOMapper.selectByUserID(userDAO.getUserId()).get(0);
                //权限名
                RightDAOMapper rightDAOMapper = sqlSession.getMapper(RightDAOMapper.class);
                RightDAOExample RightDAOExample = new RightDAOExample();
                RightDAOExample.Criteria criteria3 = RightDAOExample.createCriteria();
                criteria3.andRightIdEqualTo(userRightDAO.getRightId());
                List<RightDAO> rightDAOList = rightDAOMapper.selectByExample(RightDAOExample);
                userInfo.setRight_name(rightDAOList.get(0).getRightName());
            }

            userInfo.setBankCard(userDAO.getBankCard());
            userInfo.setEmail(userDAO.getEmail());
            userInfo.setName(userDAO.getName());
            userInfo.setPassword(userDAO.getPassword());
            userInfo.setTelephone(userDAO.getTelephone());
            userInfo.setTitle(userDAO.getTitle());
            userInfo.setUserId(userDAO.getUserId());
            userInfo.setWorking_age(userDAO.getWorkingAge());
            //院系名
            DepartmentDAOMapper departmentDAOMapper = sqlSession.getMapper(DepartmentDAOMapper.class);
            DepartmentDAOExample DepartmentDAOExample = new DepartmentDAOExample();
            DepartmentDAOExample.Criteria criteria2 = DepartmentDAOExample.createCriteria();
            criteria2.andDepartmentIdEqualTo(userDAO.getDepartmentId());
            List<DepartmentDAO> departmentDAOList = departmentDAOMapper.selectByExample(DepartmentDAOExample);
            userInfo.setDepartment_name(departmentDAOList.get(0).getDepartmentName());

            UserInfoList.add(userInfo);
        }
        sqlSession.close();
        return UserInfoList;
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping(value = "/addUser")
    //@RequiresRoles("财务管理员")
    public boolean addUser(String userid,String password,String name,String bankCard,String departmentId,String title,Integer workingAge,String right_name)throws IOException{
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
        userDAO.setEmail(null);
        userDAO.setTelephone(null);
        userDAOMapper.insert(userDAO);

        //rightId
        RightDAOMapper rightDAOMapper = sqlSession.getMapper(RightDAOMapper.class);
        RightDAOExample RightDAOExample = new RightDAOExample();
        RightDAOExample.Criteria criteria = RightDAOExample.createCriteria();
        criteria.andRightNameEqualTo(right_name);
        List<RightDAO> rightDAOList = rightDAOMapper.selectByExample(RightDAOExample);
        Long rightid = rightDAOList.get(0).getRightId();
        UserRightDAOMapper userRightDAOMapper = sqlSession.getMapper(UserRightDAOMapper.class);
        UserRightDAO userRightDAO = new UserRightDAO();
        userRightDAO.setRightId(rightid);
        userRightDAO.setUserId(userid);
        userRightDAO.setRightType(false);
        userRightDAOMapper.insert(userRightDAO);

        UserRoleMapper userRoleMapper = sqlSession.getMapper(UserRoleMapper.class);
        UserRole userRole = new UserRole();
        userRole.setRoleId(rightid);
        userRole.setUserId(userid);
        userRoleMapper.insert(userRole);

        sqlSession.commit();
        sqlSession.close();
        return true;
    };
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/deleteUser")
    //@RequiresRoles("财务管理员")
    public boolean deleteUser(String userid) throws IOException{
        SqlSession sqlSession = MapperTools.getSqlSession();
        //先删除userid关联表中的数据
        UserRightDAOMapper userRightDAOMapper = sqlSession.getMapper(UserRightDAOMapper.class);
        UserRightDAOExample UserRightDAOExample = new UserRightDAOExample();
        UserRightDAOExample.Criteria criteria = UserRightDAOExample.createCriteria();
        criteria.andUserIdEqualTo(userid);
        userRightDAOMapper.deleteByExample(UserRightDAOExample);

        UserRoleMapper userRoleMapper = sqlSession.getMapper(UserRoleMapper.class);
        UserRoleExample UserRoleExample = new UserRoleExample();
        UserRoleExample.Criteria criteria2 = UserRoleExample.createCriteria();
        criteria2.andUserIdEqualTo(userid);
        userRoleMapper.deleteByExample(UserRoleExample);

        SalaryDAOMapper salaryDAOMapper = sqlSession.getMapper(SalaryDAOMapper.class);
        SalaryDAOExample salaryDAOExample = new SalaryDAOExample();
        SalaryDAOExample.Criteria criteria3 = salaryDAOExample.createCriteria();
        criteria3.andUserIdEqualTo(userid);
        salaryDAOMapper.deleteByExample(salaryDAOExample);

        UserDAOMapper userDAOMapper = sqlSession.getMapper(UserDAOMapper.class);
        userDAOMapper.deleteByPrimaryKey(userid);

        sqlSession.commit();
        sqlSession.close();
        return true;
    }
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/updateUser")
    //@RequiresRoles("财务管理员")
    public boolean updateUser(String userid,String password,String name,String email,String telephone,String bankCard,String departmentName,String title,Integer workingAge,String right_name)throws IOException{
        SqlSession sqlSession = MapperTools.getSqlSession();
        UserDAOMapper userDAOMapper = sqlSession.getMapper(UserDAOMapper.class);
        UserDAO userDAO = new UserDAO();
        userDAO.setUserId(userid);
        userDAO.setPassword(password);
        userDAO.setName(name);
        userDAO.setBankCard(bankCard);

        //departmentId
        DepartmentDAOMapper departmentDAOMapper = sqlSession.getMapper(DepartmentDAOMapper.class);
        DepartmentDAOExample DepartmentDAOExample = new DepartmentDAOExample();
        DepartmentDAOExample.Criteria criteria2 = DepartmentDAOExample.createCriteria();
        criteria2.andDepartmentNameEqualTo(departmentName);
        List<DepartmentDAO> departmentDAOList = departmentDAOMapper.selectByExample(DepartmentDAOExample);
        userDAO.setDepartmentId(departmentDAOList.get(0).getDepartmentId());
        //userDAO.setDepartmentId(departmentId);
        userDAO.setTitle(title);
        userDAO.setEmail(email);
        userDAO.setTelephone(telephone);
        userDAO.setWorkingAge(workingAge);
        userDAOMapper.updateByPrimaryKey(userDAO);
        //rightId
        RightDAOMapper rightDAOMapper = sqlSession.getMapper(RightDAOMapper.class);
        RightDAOExample RightDAOExample = new RightDAOExample();
        RightDAOExample.Criteria criteria = RightDAOExample.createCriteria();
        criteria.andRightNameEqualTo(right_name);
        List<RightDAO> rightDAOList = rightDAOMapper.selectByExample(RightDAOExample);
        Long rightid = rightDAOList.get(0).getRightId();

        UserRightDAOMapper userRightDAOMapper = sqlSession.getMapper(UserRightDAOMapper.class);
        UserRightDAO userRightDAO = new UserRightDAO();
        userRightDAO.setRightId(rightid);
        userRightDAO.setUserId(userid);
        userRightDAO.setRightType(false);
        userRightDAOMapper.updateByPrimaryKey(userRightDAO);

        UserRoleMapper userRoleMapper = sqlSession.getMapper(UserRoleMapper.class);
        UserRole userRole = new UserRole();
        userRole.setRoleId(rightid);
        userRole.setUserId(userid);
        userRoleMapper.updateByPrimaryKey(userRole);

        sqlSession.commit();
        sqlSession.close();
        return true;
    };
}
