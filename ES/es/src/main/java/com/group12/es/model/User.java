package com.group12.es.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "salary",indexStoreType = "t_user")
@Setter
@Getter
public class User {
    @Id
    private String userId;
    private String name;
    private String idCard;
    private String email;
    private String telephone;
    private String bankCard;
    private String departmentId;
    private String title;
    private Integer workingAge;
    private String degree;
    private String nation;
    private String origin;

    public User(){
        super();
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public void setWorkingAge(Integer workingAge) {
        this.workingAge = workingAge;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getOrigin() {
        return origin;
    }

    public String getNation() {
        return nation;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getDegree() {
        return degree;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public Integer getWorkingAge() {
        return workingAge;
    }

    public String getBankCard() {
        return bankCard;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getTitle() {
        return title;
    }

    public String getUserId() {
        return userId;
    }
}
