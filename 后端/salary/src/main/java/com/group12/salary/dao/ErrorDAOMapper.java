package com.group12.salary.dao;

import com.group12.salary.model.ErrorDAO;
import com.group12.salary.model.ErrorDAOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErrorDAOMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_error
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	long countByExample(ErrorDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_error
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int deleteByExample(ErrorDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_error
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_error
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int insert(ErrorDAO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_error
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int insertSelective(ErrorDAO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_error
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	List<ErrorDAO> selectByExample(ErrorDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_error
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	ErrorDAO selectByPrimaryKey(Long id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_error
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByExampleSelective(@Param("record") ErrorDAO record, @Param("example") ErrorDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_error
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByExample(@Param("record") ErrorDAO record, @Param("example") ErrorDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_error
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByPrimaryKeySelective(ErrorDAO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_error
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByPrimaryKey(ErrorDAO record);
}