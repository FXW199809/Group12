package com.group12.salary.model;

import java.io.Serializable;

public class GroupDAO implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_group.group_id
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	private Long groupId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_group.group_name
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	private String groupName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_group.parent_group_id
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	private Long parentGroupId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_group.description
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	private String description;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_group
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_group.group_id
	 * @return  the value of t_group.group_id
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public Long getGroupId() {
		return groupId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_group.group_id
	 * @param groupId  the value for t_group.group_id
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_group.group_name
	 * @return  the value of t_group.group_name
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_group.group_name
	 * @param groupName  the value for t_group.group_name
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName == null ? null : groupName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_group.parent_group_id
	 * @return  the value of t_group.parent_group_id
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public Long getParentGroupId() {
		return parentGroupId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_group.parent_group_id
	 * @param parentGroupId  the value for t_group.parent_group_id
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public void setParentGroupId(Long parentGroupId) {
		this.parentGroupId = parentGroupId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_group.description
	 * @return  the value of t_group.description
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_group.description
	 * @param description  the value for t_group.description
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}
}