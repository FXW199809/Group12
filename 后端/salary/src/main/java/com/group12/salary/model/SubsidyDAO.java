package com.group12.salary.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class SubsidyDAO implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_subsidy.id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private Long id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_subsidy.user_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private String userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_subsidy.name
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_subsidy.food
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private BigDecimal food;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_subsidy.coal
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private BigDecimal coal;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_subsidy.transport
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private BigDecimal transport;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_subsidy.subsidy1
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private BigDecimal subsidy1;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_subsidy.subsidy2
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private BigDecimal subsidy2;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_subsidy.subsidy_total
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private BigDecimal subsidyTotal;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_subsidy.submit_user_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private String submitUserId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_subsidy.submit_date
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private Date submitDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_subsidy.status
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private int status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_subsidy
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_subsidy.id
	 * @return  the value of t_subsidy.id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public Long getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_subsidy.id
	 * @param id  the value for t_subsidy.id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_subsidy.user_id
	 * @return  the value of t_subsidy.user_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_subsidy.user_id
	 * @param userId  the value for t_subsidy.user_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_subsidy.name
	 * @return  the value of t_subsidy.name
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_subsidy.name
	 * @param name  the value for t_subsidy.name
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_subsidy.food
	 * @return  the value of t_subsidy.food
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public BigDecimal getFood() {
		return food;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_subsidy.food
	 * @param food  the value for t_subsidy.food
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setFood(BigDecimal food) {
		this.food = food;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_subsidy.coal
	 * @return  the value of t_subsidy.coal
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public BigDecimal getCoal() {
		return coal;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_subsidy.coal
	 * @param coal  the value for t_subsidy.coal
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setCoal(BigDecimal coal) {
		this.coal = coal;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_subsidy.transport
	 * @return  the value of t_subsidy.transport
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public BigDecimal getTransport() {
		return transport;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_subsidy.transport
	 * @param transport  the value for t_subsidy.transport
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setTransport(BigDecimal transport) {
		this.transport = transport;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_subsidy.subsidy1
	 * @return  the value of t_subsidy.subsidy1
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public BigDecimal getSubsidy1() {
		return subsidy1;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_subsidy.subsidy1
	 * @param subsidy1  the value for t_subsidy.subsidy1
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setSubsidy1(BigDecimal subsidy1) {
		this.subsidy1 = subsidy1;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_subsidy.subsidy2
	 * @return  the value of t_subsidy.subsidy2
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public BigDecimal getSubsidy2() {
		return subsidy2;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_subsidy.subsidy2
	 * @param subsidy2  the value for t_subsidy.subsidy2
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setSubsidy2(BigDecimal subsidy2) {
		this.subsidy2 = subsidy2;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_subsidy.subsidy_total
	 * @return  the value of t_subsidy.subsidy_total
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public BigDecimal getSubsidyTotal() {
		return subsidyTotal;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_subsidy.subsidy_total
	 * @param subsidyTotal  the value for t_subsidy.subsidy_total
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setSubsidyTotal(BigDecimal subsidyTotal) {
		this.subsidyTotal = subsidyTotal;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_subsidy.submit_user_id
	 * @return  the value of t_subsidy.submit_user_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public String getSubmitUserId() {
		return submitUserId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_subsidy.submit_user_id
	 * @param submitUserId  the value for t_subsidy.submit_user_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setSubmitUserId(String submitUserId) {
		this.submitUserId = submitUserId == null ? null : submitUserId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_subsidy.submit_date
	 * @return  the value of t_subsidy.submit_date
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public Date getSubmitDate() {
		return submitDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_subsidy.submit_date
	 * @param submitDate  the value for t_subsidy.submit_date
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_subsidy.status
	 * @return  the value of t_subsidy.status
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_subsidy.status
	 * @param status2  the value for t_subsidy.status
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setStatus(int status2) {
		this.status = status2;
	}
}