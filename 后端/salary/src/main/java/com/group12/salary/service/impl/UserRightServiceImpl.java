package com.group12.salary.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.group12.salary.dao.UserRightDAOMapper;
import com.group12.salary.model.UserRightDAO;
import com.group12.salary.service.UserRightService;
@Service
@Transactional
public class UserRightServiceImpl implements UserRightService {
	@Resource
	private UserRightDAOMapper mapper;
	public int add(UserRightDAO userRight) {
		
		return mapper.insert(userRight);
	}

	public int update(UserRightDAO userRight) {
		
		return mapper.updateByPrimaryKey(userRight);
	}

	public int delete(long userRightId) {
		
		return mapper.deleteByPrimaryKey(userRightId);
	}

	public UserRightDAO findByUserId(long userRightId) {
		
		return mapper.selectByPrimaryKey(userRightId);
	}

}
