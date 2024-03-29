package com.group12.salary.dao;

import com.group12.salary.model.RightDAO;
import com.group12.salary.model.RightDAOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RightDAOMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_right
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	long countByExample(RightDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_right
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int deleteByExample(RightDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_right
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int deleteByPrimaryKey(Long rightId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_right
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int insert(RightDAO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_right
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int insertSelective(RightDAO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_right
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	List<RightDAO> selectByExample(RightDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_right
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	RightDAO selectByPrimaryKey(Long rightId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_right
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByExampleSelective(@Param("record") RightDAO record, @Param("example") RightDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_right
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByExample(@Param("record") RightDAO record, @Param("example") RightDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_right
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByPrimaryKeySelective(RightDAO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_right
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByPrimaryKey(RightDAO record);
}