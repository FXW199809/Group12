package com.group12.salary.service;

import com.group12.salary.model.UserRoleDAO;
public interface UserRoleService {
	int add(UserRoleDAO userRole);
	int update(UserRoleDAO userRole);
	int delete(long userRoleId);
	UserRoleDAO findByUserId(long userRoleId);
}
