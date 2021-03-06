package com.group12.salary.dao;

import com.group12.salary.model.DepartmentDAO;
import com.group12.salary.model.DepartmentDAOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartmentDAOMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_department
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	long countByExample(DepartmentDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_department
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int deleteByExample(DepartmentDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_department
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int deleteByPrimaryKey(String departmentId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_department
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int insert(DepartmentDAO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_department
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int insertSelective(DepartmentDAO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_department
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	List<DepartmentDAO> selectByExample(DepartmentDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_department
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	DepartmentDAO selectByPrimaryKey(String departmentId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_department
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByExampleSelective(@Param("record") DepartmentDAO record, @Param("example") DepartmentDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_department
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByExample(@Param("record") DepartmentDAO record, @Param("example") DepartmentDAOExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_department
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByPrimaryKeySelective(DepartmentDAO record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table t_department
	 * @mbg.generated  Sat May 30 16:46:21 GMT+08:00 2020
	 */
	int updateByPrimaryKey(DepartmentDAO record);
}