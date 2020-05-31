package com.group12.salary.dao;

import com.group12.salary.model.GroupRoleDAO;
import com.group12.salary.model.GroupRoleDAOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupRoleDAOMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_group_role
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	long countByExample(GroupRoleDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_group_role
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int deleteByExample(GroupRoleDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_group_role
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int deleteByPrimaryKey(Long groupRoleId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_group_role
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int insert(GroupRoleDAO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_group_role
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int insertSelective(GroupRoleDAO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_group_role
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	List<GroupRoleDAO> selectByExample(GroupRoleDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_group_role
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	GroupRoleDAO selectByPrimaryKey(Long groupRoleId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_group_role
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByExampleSelective(@Param("record") GroupRoleDAO record, @Param("example") GroupRoleDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_group_role
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByExample(@Param("record") GroupRoleDAO record, @Param("example") GroupRoleDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_group_role
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByPrimaryKeySelective(GroupRoleDAO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_group_role
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByPrimaryKey(GroupRoleDAO record);
}