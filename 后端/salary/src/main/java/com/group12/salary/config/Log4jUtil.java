package com.group12.salary.config;

import org.apache.log4j.Logger;
import org.slf4j.MDC;

//log4j的工具类
public class Log4jUtil {
    public void init(String tableName, String columnName, String changeId, String beforeValue, String afterValue, String userID, String operationType){
        MDC.clear();
        Logger logger = Logger.getLogger(Log4jUtil.class);
        MDC.put("name", tableName);
        MDC.put("column_name", columnName);
        MDC.put("change_id", changeId);
        MDC.put("before_value", beforeValue);
        MDC.put("after_value", afterValue);
        MDC.put("user_id", userID);
        MDC.put("operation_type", operationType);
        logger.info("插入数据库日志");
    }
}
