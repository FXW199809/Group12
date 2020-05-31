package com.group12.salary.service.impl;

import com.group12.salary.dao.UserRoleDAOMapper;
import com.group12.salary.model.UserRoleDAO;
import com.group12.salary.model.UserRoleDAO;
import com.group12.salary.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service

public class UserRoleServiceImpl implements UserRoleService {
	@Resource
	private UserRoleDAOMapper mapper;
	public int add(UserRoleDAO userRole) {

		return mapper.insert(userRole);
	}

	public int update(UserRoleDAO userRole) {
		
		return mapper.updateByPrimaryKey(userRole);
	}

	public int delete(long userRoleId) {
		
		return mapper.deleteByPrimaryKey(userRoleId);
	}

	public UserRoleDAO findByUserId(long userRoleId) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(userRoleId);
	}


}
