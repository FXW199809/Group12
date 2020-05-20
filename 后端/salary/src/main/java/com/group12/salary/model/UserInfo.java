package com.group12.salary.model;

public class UserInfo {
    private String userId;
    private String name;
    private String password;
    private String email;
    private String telephone;
    private String BankCard;
    private String department_name;
    private String title;
    private Integer working_age;
    private String right_name;

    public void setBankCard(String bankCard) {
        BankCard = bankCard;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRight_name(String right_name) {
        this.right_name = right_name;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setWorking_age(Integer working_age) {
        this.working_age = working_age;
    }

    public String getBankCard() {
        return BankCard;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getRight_name() {
        return right_name;
    }

    public String getTitle() {
        return title;
    }

    public String getUserId() {
        return userId;
    }

    public Integer getWorking_age() {
        return working_age;
    }
}
