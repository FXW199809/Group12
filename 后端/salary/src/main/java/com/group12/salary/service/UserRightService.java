package com.group12.salary.service;

import com.group12.salary.model.UserRightDAO;

public interface UserRightService {
	int add(UserRightDAO userRight);
	int update(UserRightDAO userRight);
	int delete(long userRightId);
	UserRightDAO findByUserId(long userRightId);
}
