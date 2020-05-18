package com.group12.salary.service;

import com.group12.salary.model.UserRole;;
public interface UserRoleService {
	int add(UserRole userRole);
	int update(UserRole userRole);
	int delete(long userRoleId);
	UserRole findByUserId(long userRoleId);
}
