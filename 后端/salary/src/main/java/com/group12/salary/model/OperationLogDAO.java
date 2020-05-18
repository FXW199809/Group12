package com.group12.salary.model;

import java.io.Serializable;
import java.util.Date;

public class OperationLogDAO implements Serializable {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_operation_log.log_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private Long logId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_operation_log.table_name
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private String tableName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_operation_log.column_name
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private String columnName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_operation_log.change_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private String changeId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_operation_log.before_value
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private String beforeValue;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_operation_log.after_value
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private String afterValue;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_operation_log.user_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private String userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_operation_log.operation_datetime
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private Date operationDatetime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column t_operation_log.operation_type
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private Byte operationType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table t_operation_log
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_operation_log.log_id
	 * @return  the value of t_operation_log.log_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public Long getLogId() {
		return logId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_operation_log.log_id
	 * @param logId  the value for t_operation_log.log_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setLogId(Long logId) {
		this.logId = logId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_operation_log.table_name
	 * @return  the value of t_operation_log.table_name
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_operation_log.table_name
	 * @param tableName  the value for t_operation_log.table_name
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName == null ? null : tableName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_operation_log.column_name
	 * @return  the value of t_operation_log.column_name
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public String getColumnName() {
		return columnName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_operation_log.column_name
	 * @param columnName  the value for t_operation_log.column_name
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName == null ? null : columnName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_operation_log.change_id
	 * @return  the value of t_operation_log.change_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public String getChangeId() {
		return changeId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_operation_log.change_id
	 * @param changeId  the value for t_operation_log.change_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setChangeId(String changeId) {
		this.changeId = changeId == null ? null : changeId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_operation_log.before_value
	 * @return  the value of t_operation_log.before_value
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public String getBeforeValue() {
		return beforeValue;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_operation_log.before_value
	 * @param beforeValue  the value for t_operation_log.before_value
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setBeforeValue(String beforeValue) {
		this.beforeValue = beforeValue == null ? null : beforeValue.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_operation_log.after_value
	 * @return  the value of t_operation_log.after_value
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public String getAfterValue() {
		return afterValue;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_operation_log.after_value
	 * @param afterValue  the value for t_operation_log.after_value
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setAfterValue(String afterValue) {
		this.afterValue = afterValue == null ? null : afterValue.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_operation_log.user_id
	 * @return  the value of t_operation_log.user_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_operation_log.user_id
	 * @param userId  the value for t_operation_log.user_id
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_operation_log.operation_datetime
	 * @return  the value of t_operation_log.operation_datetime
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public Date getOperationDatetime() {
		return operationDatetime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_operation_log.operation_datetime
	 * @param operationDatetime  the value for t_operation_log.operation_datetime
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setOperationDatetime(Date operationDatetime) {
		this.operationDatetime = operationDatetime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column t_operation_log.operation_type
	 * @return  the value of t_operation_log.operation_type
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public Byte getOperationType() {
		return operationType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column t_operation_log.operation_type
	 * @param operationType  the value for t_operation_log.operation_type
	 * @mbg.generated  Sat May 02 09:47:09 GMT+08:00 2020
	 */
	public void setOperationType(Byte operationType) {
		this.operationType = operationType;
	}
}