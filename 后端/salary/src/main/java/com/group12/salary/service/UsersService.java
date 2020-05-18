package com.group12.salary.service;

import com.group12.salary.model.UserDAO;

import java.util.Set;

public interface UsersService {

    public UserDAO findByUserID(String user_id);
    public Set<String> findRole(String user_id);
    public Set<String> findRight(String user_id);

}
