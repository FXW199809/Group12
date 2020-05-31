package com.group12.salary.dao;

import com.group12.salary.model.UserGroupDAO;
import com.group12.salary.model.UserGroupDAOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserGroupDAOMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_group
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	long countByExample(UserGroupDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_group
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int deleteByExample(UserGroupDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_group
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int deleteByPrimaryKey(Long userGroupId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_group
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int insert(UserGroupDAO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_group
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int insertSelective(UserGroupDAO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_group
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	List<UserGroupDAO> selectByExample(UserGroupDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_group
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	UserGroupDAO selectByPrimaryKey(Long userGroupId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_group
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByExampleSelective(@Param("record") UserGroupDAO record, @Param("example") UserGroupDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_group
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByExample(@Param("record") UserGroupDAO record, @Param("example") UserGroupDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_group
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByPrimaryKeySelective(UserGroupDAO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_user_group
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByPrimaryKey(UserGroupDAO record);
}