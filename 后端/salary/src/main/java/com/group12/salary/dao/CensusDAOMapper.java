package com.group12.salary.dao;

import com.group12.salary.model.CensusDAO;
import com.group12.salary.model.CensusDAOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CensusDAOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_census
     *
     * @mbg.generated Wed Jun 03 23:05:18 GMT+08:00 2020
     */
    long countByExample(CensusDAOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_census
     *
     * @mbg.generated Wed Jun 03 23:05:18 GMT+08:00 2020
     */
    int deleteByExample(CensusDAOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_census
     *
     * @mbg.generated Wed Jun 03 23:05:18 GMT+08:00 2020
     */
    int deleteByPrimaryKey(Long censusId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_census
     *
     * @mbg.generated Wed Jun 03 23:05:18 GMT+08:00 2020
     */
    int insert(CensusDAO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_census
     *
     * @mbg.generated Wed Jun 03 23:05:18 GMT+08:00 2020
     */
    int insertSelective(CensusDAO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_census
     *
     * @mbg.generated Wed Jun 03 23:05:18 GMT+08:00 2020
     */
    List<CensusDAO> selectByExample(CensusDAOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_census
     *
     * @mbg.generated Wed Jun 03 23:05:18 GMT+08:00 2020
     */
    CensusDAO selectByPrimaryKey(Long censusId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_census
     *
     * @mbg.generated Wed Jun 03 23:05:18 GMT+08:00 2020
     */
    int updateByExampleSelective(@Param("record") CensusDAO record, @Param("example") CensusDAOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_census
     *
     * @mbg.generated Wed Jun 03 23:05:18 GMT+08:00 2020
     */
    int updateByExample(@Param("record") CensusDAO record, @Param("example") CensusDAOExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_census
     *
     * @mbg.generated Wed Jun 03 23:05:18 GMT+08:00 2020
     */
    int updateByPrimaryKeySelective(CensusDAO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_census
     *
     * @mbg.generated Wed Jun 03 23:05:18 GMT+08:00 2020
     */
    int updateByPrimaryKey(CensusDAO record);
}