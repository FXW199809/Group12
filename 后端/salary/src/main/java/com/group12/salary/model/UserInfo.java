package com.group12.salary.model;

public class UserInfo {
    private UserDAO userDAO;
    private UserRightDAO userRightDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void setUserRightDAO(UserRightDAO userRightDAO) {
        this.userRightDAO = userRightDAO;
    }
}
