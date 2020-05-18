package com.group12.salary.model;

import java.io.Serializable;

public class UserGroupDAO implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user_group.user_group_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private Long userGroupId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user_group.group_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private Long groupId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_user_group.user_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private String userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_user_group
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user_group.user_group_id
	 * @return  the value of t_user_group.user_group_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public Long getUserGroupId() {
		return userGroupId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user_group.user_group_id
	 * @param userGroupId  the value for t_user_group.user_group_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setUserGroupId(Long userGroupId) {
		this.userGroupId = userGroupId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user_group.group_id
	 * @return  the value of t_user_group.group_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public Long getGroupId() {
		return groupId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user_group.group_id
	 * @param groupId  the value for t_user_group.group_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_user_group.user_id
	 * @return  the value of t_user_group.user_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_user_group.user_id
	 * @param userId  the value for t_user_group.user_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}
}