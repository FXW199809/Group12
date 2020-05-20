package com.group12.salary.controller;
import com.group12.salary.config.MapperTools;
import com.group12.salary.dao.SalaryDAOMapper;
import com.group12.salary.dao.UserDAOMapper;
import com.group12.salary.model.SalaryDAO;
import com.group12.salary.model.SalaryDAOExample;
import com.group12.salary.model.UserDAO;
import com.group12.salary.model.UserDAOExample;
import org.apache.ibatis.session.SqlSession;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;




@RestController
public class Checkbydepartment_idController  {
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/getUserSalaryList")
    public List<SalaryDAO> getSalaryList() throws IOException

    {
        /**
         * 这里要用shiro获取userDAO，但是暂时没有shiro,所以用下面两行代替

        UserDAO userDAO = new UserDAO();
        userDAO.setUserId("11");
*/
        UserDAO userDAO = (UserDAO) SecurityUtils.getSubject();//这句能获取当前登陆的用户
            SqlSession sqlSession = MapperTools.getSqlSession();
            SalaryDAOMapper salaryDAOMapper =sqlSession.getMapper(SalaryDAOMapper.class);
        UserDAOMapper userDAOMapper = sqlSession.getMapper(UserDAOMapper.class);

        UserDAOExample userDAOExample = new UserDAOExample();
        UserDAOExample.Criteria criteria1 = userDAOExample.createCriteria();
        criteria1.andUserIdEqualTo(userDAO.getUserId());
        //获取userId对应的user
        List<UserDAO> userDAOList = userDAOMapper.selectByExample(userDAOExample);
        //找到院系编号
        String departmentId = userDAOList.get(0).getDepartmentId();

        //清除原本的数据
        userDAOExample.clear();

        //找到对应院系的用户
        criteria1.andDepartmentIdEqualTo(departmentId);
        userDAOList = userDAOMapper.selectByExample(userDAOExample);

        List<SalaryDAO> salaryDAOList;
        SalaryDAOExample salaryDAOExample =new SalaryDAOExample();
        SalaryDAOExample.Criteria criteria=salaryDAOExample.createCriteria();

        //获取所有工资信息
        for (int i = 0; i < userDAOList.size(); i++) {
            criteria.andUserIdEqualTo(userDAOList.get(i).getUserId());
        }
         salaryDAOList = salaryDAOMapper.selectByExample(salaryDAOExample);
            sqlSession.close();


            return salaryDAOList;
        }

    }


