package com.group12.salary.dao;

import com.group12.salary.model.ChangeDAO;
import com.group12.salary.model.ChangeDAOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChangeDAOMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_change
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	long countByExample(ChangeDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_change
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int deleteByExample(ChangeDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_change
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_change
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int insert(ChangeDAO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_change
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int insertSelective(ChangeDAO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_change
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	List<ChangeDAO> selectByExample(ChangeDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_change
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	ChangeDAO selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_change
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByExampleSelective(@Param("record") ChangeDAO record, @Param("example") ChangeDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_change
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByExample(@Param("record") ChangeDAO record, @Param("example") ChangeDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_change
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByPrimaryKeySelective(ChangeDAO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_change
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByPrimaryKey(ChangeDAO record);
}