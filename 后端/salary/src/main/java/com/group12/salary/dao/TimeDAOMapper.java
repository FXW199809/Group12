package com.group12.salary.dao;

import com.group12.salary.model.TimeDAO;
import com.group12.salary.model.TimeDAOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TimeDAOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_time
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    long countByExample(TimeDAOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_time
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    int deleteByExample(TimeDAOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_time
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_time
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    int insert(TimeDAO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_time
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    int insertSelective(TimeDAO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_time
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    List<TimeDAO> selectByExample(TimeDAOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_time
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    TimeDAO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_time
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    int updateByExampleSelective(@Param("record") TimeDAO record, @Param("example") TimeDAOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_time
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    int updateByExample(@Param("record") TimeDAO record, @Param("example") TimeDAOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_time
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    int updateByPrimaryKeySelective(TimeDAO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_time
     *
     * @mbg.generated Wed Jun 10 10:14:28 GMT+08:00 2020
     */
    int updateByPrimaryKey(TimeDAO record);
}