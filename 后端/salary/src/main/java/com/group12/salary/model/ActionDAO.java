package com.group12.salary.model;

import java.io.Serializable;

public class ActionDAO implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_action.id
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_action.type
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_action.path
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    private String path;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_action.eId
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    private String eid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_action.className
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    private String classname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_action.sTme
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    private String stme;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_action.eTme
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    private String etme;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_action.val
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    private String val;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_action.uuid
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    private String uuid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_action
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_action.id
     *
     * @return the value of t_action.id
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_action.id
     *
     * @param id the value for t_action.id
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_action.type
     *
     * @return the value of t_action.type
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_action.type
     *
     * @param type the value for t_action.type
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_action.path
     *
     * @return the value of t_action.path
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    public String getPath() {
        return path;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_action.path
     *
     * @param path the value for t_action.path
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_action.eId
     *
     * @return the value of t_action.eId
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    public String getEid() {
        return eid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_action.eId
     *
     * @param eid the value for t_action.eId
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    public void setEid(String eid) {
        this.eid = eid == null ? null : eid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_action.className
     *
     * @return the value of t_action.className
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    public String getClassname() {
        return classname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_action.className
     *
     * @param classname the value for t_action.className
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_action.sTme
     *
     * @return the value of t_action.sTme
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    public String getStme() {
        return stme;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_action.sTme
     *
     * @param stme the value for t_action.sTme
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    public void setStme(String stme) {
        this.stme = stme == null ? null : stme.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_action.eTme
     *
     * @return the value of t_action.eTme
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    public String getEtme() {
        return etme;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_action.eTme
     *
     * @param etme the value for t_action.eTme
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    public void setEtme(String etme) {
        this.etme = etme == null ? null : etme.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_action.val
     *
     * @return the value of t_action.val
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    public String getVal() {
        return val;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_action.val
     *
     * @param val the value for t_action.val
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    public void setVal(String val) {
        this.val = val == null ? null : val.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_action.uuid
     *
     * @return the value of t_action.uuid
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_action.uuid
     *
     * @param uuid the value for t_action.uuid
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }
}