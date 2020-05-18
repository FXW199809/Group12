package com.group12.salary.service.impl;

import com.group12.salary.dao.UserRoleMapper;
import com.group12.salary.model.UserRole;
import com.group12.salary.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service

public class UserRoleServiceImpl implements UserRoleService {
	@Resource
	private UserRoleMapper mapper;
	public int add(UserRole userRole) {

		return mapper.insert(userRole);
	}

	public int update(UserRole userRole) {
		
		return mapper.updateByPrimaryKey(userRole);
	}

	public int delete(long userRoleId) {
		
		return mapper.deleteByPrimaryKey(userRoleId);
	}

	public UserRole findByUserId(long userRoleId) {
		// TODO Auto-generated method stub
		return mapper.selectByPrimaryKey(userRoleId);
	}


}
