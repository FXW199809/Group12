-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.0.27-community-nt - MySQL Community Edition (GPL)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 salary 的数据库结构
CREATE DATABASE IF NOT EXISTS `salary` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `salary`;

-- 导出  表 salary.t_change 结构
CREATE TABLE IF NOT EXISTS `t_change` (
  `id` bigint(8) NOT NULL auto_increment COMMENT '记录标识',
  `user_id` varchar(8) collate utf8_bin NOT NULL COMMENT '职工号',
  `name` varchar(20) collate utf8_bin NOT NULL COMMENT '姓名',
  `before_money` decimal(19,2) NOT NULL COMMENT '改动前工资',
  `after_money` decimal(19,2) NOT NULL COMMENT '改动后工资',
  `submit_user_id` varchar(8) collate utf8_bin NOT NULL COMMENT '申请人职工号',
  `submit_date` date NOT NULL COMMENT '提交日期',
  `status` int(11) NOT NULL COMMENT '审批状态：0：未审批1：已通过2：已驳回',
  PRIMARY KEY  (`id`),
  KEY `fk__user_id_t_change` (`user_id`),
  CONSTRAINT `fk__user_id_t_change` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='职工工资变动通知单表';

-- 正在导出表  salary.t_change 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `t_change` DISABLE KEYS */;
INSERT INTO `t_change` (`id`, `user_id`, `name`, `before_money`, `after_money`, `submit_user_id`, `submit_date`, `status`) VALUES
	(1, '20171101', '张三', 2990.00, 2009.00, '19970129', '2020-05-20', 0);
/*!40000 ALTER TABLE `t_change` ENABLE KEYS */;

-- 导出  表 salary.t_deduct 结构
CREATE TABLE IF NOT EXISTS `t_deduct` (
  `id` bigint(8) NOT NULL auto_increment COMMENT '记录标识',
  `user_id` varchar(8) collate utf8_bin NOT NULL COMMENT '职工号',
  `name` varchar(20) collate utf8_bin NOT NULL COMMENT '姓名',
  `room` decimal(19,2) NOT NULL COMMENT '房费',
  `water_electric` decimal(19,2) NOT NULL COMMENT '水电费',
  `children` decimal(19,2) NOT NULL COMMENT '托儿费',
  `advance` decimal(19,2) NOT NULL COMMENT '借支扣款',
  `other` decimal(19,2) NOT NULL COMMENT '其它扣款',
  `deduct_total` decimal(19,2) NOT NULL COMMENT '扣款总计',
  `submit_user_id` varchar(8) collate utf8_bin NOT NULL COMMENT '申请人职工号',
  `submit_date` date NOT NULL COMMENT '提交日期',
  `status` int(11) NOT NULL COMMENT '审批状态：0：未审批1：已通过2：已驳回',
  PRIMARY KEY  (`id`),
  KEY `fk_user_id_t_deduct` (`user_id`),
  CONSTRAINT `fk_user_id_t_deduct` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='扣款清单表';

-- 正在导出表  salary.t_deduct 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_deduct` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_deduct` ENABLE KEYS */;

-- 导出  表 salary.t_department 结构
CREATE TABLE IF NOT EXISTS `t_department` (
  `department_id` varchar(2) collate utf8_bin NOT NULL COMMENT '院系编号',
  `department_name` varchar(20) collate utf8_bin NOT NULL COMMENT '院系名称',
  PRIMARY KEY  (`department_id`),
  UNIQUE KEY `uk_department_name` (`department_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='院系表';

-- 正在导出表  salary.t_department 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `t_department` DISABLE KEYS */;
INSERT INTO `t_department` (`department_id`, `department_name`) VALUES
	('03', '化学'),
	('02', '数学'),
	('11', '计科'),
	('01', '财务');
/*!40000 ALTER TABLE `t_department` ENABLE KEYS */;

-- 导出  表 salary.t_error 结构
CREATE TABLE IF NOT EXISTS `t_error` (
  `id` bigint(8) NOT NULL auto_increment COMMENT '记录标识',
  `user_id` varchar(8) collate utf8_bin NOT NULL COMMENT '职工号',
  `name` varchar(20) collate utf8_bin NOT NULL COMMENT '姓名',
  `item` varchar(100) collate utf8_bin NOT NULL COMMENT '事项',
  `wrong_data` decimal(19,2) NOT NULL COMMENT '错误数据',
  `revised_data` decimal(19,2) NOT NULL COMMENT '修正数据',
  `submit_user_id` varchar(8) collate utf8_bin NOT NULL COMMENT '申请人职工号',
  `submit_date` date NOT NULL COMMENT '提交日期',
  `status` int(11) NOT NULL COMMENT '审批状态：0：未审批1：已通过2：已驳回',
  PRIMARY KEY  (`id`),
  KEY `fk__user_id_t_error` (`user_id`),
  CONSTRAINT `fk__user_id_t_error` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='出错信息表';

-- 正在导出表  salary.t_error 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_error` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_error` ENABLE KEYS */;

-- 导出  表 salary.t_group 结构
CREATE TABLE IF NOT EXISTS `t_group` (
  `group_id` bigint(8) NOT NULL auto_increment COMMENT '组编号',
  `group_name` varchar(64) collate utf8_bin NOT NULL COMMENT '组名',
  `parent_group_id` bigint(8) NOT NULL COMMENT '父级组编号',
  `description` varchar(200) collate utf8_bin default NULL COMMENT '组描述',
  PRIMARY KEY  (`group_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='组表';

-- 正在导出表  salary.t_group 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_group` ENABLE KEYS */;

-- 导出  表 salary.t_group_right 结构
CREATE TABLE IF NOT EXISTS `t_group_right` (
  `group_right_id` bigint(8) NOT NULL auto_increment COMMENT '记录标识',
  `group_id` bigint(8) NOT NULL COMMENT '组编号',
  `right_id` bigint(8) NOT NULL COMMENT '权限编号',
  `right_type` tinyint(1) NOT NULL COMMENT '权限类型（0：可访问，1：可授权)',
  PRIMARY KEY  (`group_right_id`),
  KEY `fk_group_id_t_group_right` (`group_id`),
  KEY `fk_right_id_t_group_right` (`right_id`),
  CONSTRAINT `fk_group_id_t_group_right` FOREIGN KEY (`group_id`) REFERENCES `t_group` (`group_id`),
  CONSTRAINT `fk_right_id_t_group_right` FOREIGN KEY (`right_id`) REFERENCES `t_right` (`right_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='组权限表';

-- 正在导出表  salary.t_group_right 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_group_right` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_group_right` ENABLE KEYS */;

-- 导出  表 salary.t_group_role 结构
CREATE TABLE IF NOT EXISTS `t_group_role` (
  `group_role_id` bigint(8) NOT NULL auto_increment COMMENT '记录标识',
  `group_id` bigint(8) NOT NULL COMMENT '组编号',
  `role_id` bigint(8) NOT NULL COMMENT '角色编号',
  PRIMARY KEY  (`group_role_id`),
  KEY `fk_group_id_t_group_role` (`group_id`),
  KEY `fk_role_id_t_group_role` (`role_id`),
  CONSTRAINT `fk_group_id_t_group_role` FOREIGN KEY (`group_id`) REFERENCES `t_group` (`group_id`),
  CONSTRAINT `fk_role_id_t_group_role` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='组角色表';

-- 正在导出表  salary.t_group_role 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_group_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_group_role` ENABLE KEYS */;

-- 导出  表 salary.t_operation_log 结构
CREATE TABLE IF NOT EXISTS `t_operation_log` (
  `log_id` bigint(20) NOT NULL auto_increment COMMENT '日志编号',
  `table_name` varchar(50) collate utf8_bin NOT NULL COMMENT '表名',
  `column_name` varchar(50) collate utf8_bin NOT NULL COMMENT '列名',
  `change_id` varchar(50) collate utf8_bin NOT NULL COMMENT '被修改的行号',
  `before_value` varchar(50) collate utf8_bin default NULL COMMENT '修改前的值',
  `after_value` varchar(50) collate utf8_bin default NULL COMMENT '修改后的值',
  `user_id` varchar(8) collate utf8_bin NOT NULL COMMENT '操作者编号',
  `operation_datetime` datetime NOT NULL COMMENT '操作时间',
  `operation_type` varchar(50) collate utf8_bin NOT NULL COMMENT '操作类型：1：增加2：修改3：删除',
  PRIMARY KEY  (`log_id`),
  KEY `fk_user_id_t_operation_log` (`user_id`),
  CONSTRAINT `fk_user_id_t_operation_log` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='操作日志表';

-- 正在导出表  salary.t_operation_log 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_operation_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_operation_log` ENABLE KEYS */;

-- 导出  表 salary.t_right 结构
CREATE TABLE IF NOT EXISTS `t_right` (
  `right_id` bigint(8) NOT NULL auto_increment COMMENT '权限编号',
  `right_name` varchar(64) collate utf8_bin NOT NULL COMMENT '权限名',
  `parent_right_id` bigint(8) NOT NULL COMMENT '父级权限编号',
  `description` varchar(200) collate utf8_bin default NULL COMMENT '权限描述',
  PRIMARY KEY  (`right_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='权限表';

-- 正在导出表  salary.t_right 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `t_right` DISABLE KEYS */;
INSERT INTO `t_right` (`right_id`, `right_name`, `parent_right_id`, `description`) VALUES
	(1, '登陆', 0, NULL),
	(2, '管理', 1, NULL),
	(3, '上传', 1, NULL);
/*!40000 ALTER TABLE `t_right` ENABLE KEYS */;

-- 导出  表 salary.t_role 结构
CREATE TABLE IF NOT EXISTS `t_role` (
  `role_id` bigint(8) NOT NULL auto_increment COMMENT '角色编号',
  `role_name` varchar(64) collate utf8_bin NOT NULL COMMENT '角色名',
  `parent_role_id` bigint(8) NOT NULL COMMENT '父级角色编号',
  `description` varchar(200) collate utf8_bin default NULL COMMENT '角色描述',
  PRIMARY KEY  (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色表';

-- 正在导出表  salary.t_role 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` (`role_id`, `role_name`, `parent_role_id`, `description`) VALUES
	(1, '用户', 0, NULL),
	(2, '财务管理员', 0, NULL),
	(3, '院系管理员', 0, NULL);
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;

-- 导出  表 salary.t_role_right 结构
CREATE TABLE IF NOT EXISTS `t_role_right` (
  `role_right_id` bigint(8) NOT NULL auto_increment COMMENT '记录标识',
  `role_id` bigint(8) NOT NULL COMMENT '角色编号',
  `right_id` bigint(8) NOT NULL COMMENT '权限编号',
  `right_type` tinyint(1) NOT NULL COMMENT '权限类型（0：可访问，1：可授权)',
  PRIMARY KEY  (`role_right_id`),
  KEY `fk_right_id_t_role_right` (`right_id`),
  KEY `fk_role_id_t_role_right` (`role_id`),
  CONSTRAINT `fk_right_id_t_role_right` FOREIGN KEY (`right_id`) REFERENCES `t_right` (`right_id`),
  CONSTRAINT `fk_role_id_t_role_right` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='角色权限表';

-- 正在导出表  salary.t_role_right 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_role_right` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_role_right` ENABLE KEYS */;

-- 导出  表 salary.t_salary 结构
CREATE TABLE IF NOT EXISTS `t_salary` (
  `id` bigint(8) NOT NULL auto_increment COMMENT '记录标识',
  `year_month_date` date NOT NULL COMMENT '时间(年月）',
  `user_id` varchar(8) collate utf8_bin NOT NULL COMMENT '职工号',
  `name` varchar(20) collate utf8_bin NOT NULL COMMENT '姓名',
  `base_salary` decimal(19,2) NOT NULL COMMENT '基本工资',
  `job_salary` decimal(19,2) NOT NULL COMMENT '职务工资',
  `working_age_salary` decimal(19,2) NOT NULL COMMENT '工龄工资',
  `food` decimal(19,2) NOT NULL COMMENT '副食补贴',
  `coal` decimal(19,2) NOT NULL COMMENT '煤油补贴',
  `transport` decimal(19,2) NOT NULL COMMENT '交通补贴',
  `subsidy1` decimal(19,2) NOT NULL COMMENT '备补1',
  `subsidy2` decimal(19,2) NOT NULL COMMENT '备补2',
  `sum_salary` decimal(19,2) NOT NULL COMMENT '应发工资',
  `room` decimal(19,2) NOT NULL COMMENT '房费',
  `water_electric` decimal(19,2) NOT NULL COMMENT '水电费',
  `children` decimal(19,2) NOT NULL COMMENT '托儿费',
  `advance` decimal(19,2) NOT NULL COMMENT '借支扣款',
  `other` decimal(19,2) NOT NULL COMMENT '其它扣款',
  `deduct_total` decimal(19,2) NOT NULL COMMENT '扣款总计',
  `take_home_salary` decimal(19,2) NOT NULL COMMENT '实发工资',
  `status` int(11) NOT NULL COMMENT '审批状态：0：未审批1：已通过2：已驳回',
  PRIMARY KEY  (`id`),
  KEY `fk__user_id_t_salary` (`user_id`),
  CONSTRAINT `fk__user_id_t_salary` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='个人月工资表';

-- 正在导出表  salary.t_salary 的数据：~1 rows (大约)
/*!40000 ALTER TABLE `t_salary` DISABLE KEYS */;
INSERT INTO `t_salary` (`id`, `year_month_date`, `user_id`, `name`, `base_salary`, `job_salary`, `working_age_salary`, `food`, `coal`, `transport`, `subsidy1`, `subsidy2`, `sum_salary`, `room`, `water_electric`, `children`, `advance`, `other`, `deduct_total`, `take_home_salary`, `status`) VALUES
	(1, '2020-05-20', '20171101', '张三', 2000.00, 200.00, 200.00, 0.00, 0.00, 0.00, 0.00, 0.00, 2400.00, 100.00, 0.00, 0.00, 0.00, 0.00, 100.00, 2300.00, 1);
/*!40000 ALTER TABLE `t_salary` ENABLE KEYS */;

-- 导出  表 salary.t_subsidy 结构
CREATE TABLE IF NOT EXISTS `t_subsidy` (
  `id` bigint(8) NOT NULL auto_increment COMMENT '记录标识',
  `user_id` varchar(8) collate utf8_bin NOT NULL COMMENT '职工号',
  `name` varchar(20) collate utf8_bin NOT NULL COMMENT '姓名',
  `food` decimal(19,2) NOT NULL COMMENT '副食补贴',
  `coal` decimal(19,2) NOT NULL COMMENT '煤油补贴',
  `transport` decimal(19,2) NOT NULL COMMENT '交通补贴',
  `subsidy1` decimal(19,2) NOT NULL COMMENT '备补1',
  `subsidy2` decimal(19,2) NOT NULL COMMENT '备补2',
  `subsidy_total` decimal(19,2) NOT NULL COMMENT '补贴总计',
  `submit_user_id` varchar(8) collate utf8_bin NOT NULL COMMENT '申请人职工号',
  `submit_date` date NOT NULL COMMENT '提交日期',
  `status` int(11) NOT NULL COMMENT '审批状态：0：未审批1：已通过2：已驳回',
  PRIMARY KEY  (`id`),
  KEY `fk__user_id_t_subsidy` (`user_id`),
  CONSTRAINT `fk__user_id_t_subsidy` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='补贴清单表';

-- 正在导出表  salary.t_subsidy 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_subsidy` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_subsidy` ENABLE KEYS */;

-- 导出  表 salary.t_user 结构
CREATE TABLE IF NOT EXISTS `t_user` (
  `user_id` varchar(8) collate utf8_bin NOT NULL COMMENT '职工号',
  `password` varchar(16) collate utf8_bin NOT NULL COMMENT '密码',
  `name` varchar(20) collate utf8_bin NOT NULL COMMENT '姓名',
  `email` varchar(50) collate utf8_bin default NULL COMMENT '邮箱',
  `telephone` varchar(11) collate utf8_bin default NULL COMMENT '手机号',
  `bank_card` varchar(30) collate utf8_bin NOT NULL COMMENT '银行卡',
  `department_id` varchar(2) collate utf8_bin NOT NULL COMMENT '院系编号',
  `title` varchar(8) collate utf8_bin NOT NULL COMMENT '职称',
  `working_age` int(11) NOT NULL COMMENT '工龄',
  `degree` varchar(8) collate utf8_bin NOT NULL COMMENT '最高学位',
  `nation` varchar(20) collate utf8_bin NOT NULL COMMENT '民族',
  `origin` varchar(20) collate utf8_bin NOT NULL COMMENT '籍贯',
  `id_card` varchar(18) collate utf8_bin NOT NULL COMMENT '身份证号',
  PRIMARY KEY  (`user_id`),
  KEY `fk_department_id` (`department_id`),
  CONSTRAINT `fk_department_id` FOREIGN KEY (`department_id`) REFERENCES `t_department` (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';

-- 正在导出表  salary.t_user 的数据：~5 rows (大约)
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` (`user_id`, `password`, `name`, `email`, `telephone`, `bank_card`, `department_id`, `title`, `working_age`, `degree`, `nation`, `origin`, `id_card`) VALUES
	('19970129', '123456kk', 'pyzy', '11234', '223211231', '456346543', '11', '高级教授', 3, '', '', '', ''),
	('19990519', 'zhangjuan', '李华', NULL, NULL, '123454321', '11', '高级教授', 2, '', '', '', ''),
	('20171101', 'newpass', '张三', NULL, NULL, '1234123412341234', '01', '教授', 3, '', '', '', ''),
	('20190122', '12345633', '李浩', '214324@qwe.com', '12343546121', '1234567891111111111', '03', '助教', 2, '学士', '汉族', 'nullnull', '123564723124213333'),
	('20200202', 'psw20202020', '心心', '888765@23.com', '1234563', '1234521234', '11', '普通教师', 1, '', '', '', '');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;

-- 导出  表 salary.t_user_group 结构
CREATE TABLE IF NOT EXISTS `t_user_group` (
  `user_group_id` bigint(8) NOT NULL auto_increment COMMENT '记录标识',
  `group_id` bigint(8) NOT NULL COMMENT '组编号',
  `user_id` varchar(8) collate utf8_bin NOT NULL COMMENT '用户编号',
  PRIMARY KEY  (`user_group_id`),
  KEY `fk_group_id_t_user_group` (`group_id`),
  KEY `fk_user_id_t_user_group` (`user_id`),
  CONSTRAINT `fk_group_id_t_user_group` FOREIGN KEY (`group_id`) REFERENCES `t_group` (`group_id`),
  CONSTRAINT `fk_user_id_t_user_group` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户组表';

-- 正在导出表  salary.t_user_group 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `t_user_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_user_group` ENABLE KEYS */;

-- 导出  表 salary.t_user_right 结构
CREATE TABLE IF NOT EXISTS `t_user_right` (
  `user_right_id` bigint(8) NOT NULL auto_increment COMMENT '记录标识',
  `user_id` varchar(8) collate utf8_bin NOT NULL COMMENT '用户编号',
  `right_id` bigint(8) NOT NULL COMMENT '权限编号',
  `right_type` tinyint(1) NOT NULL COMMENT '权限类型（0：可访问，1：可授权)',
  PRIMARY KEY  (`user_right_id`),
  KEY `fk_right_id_t_user_right` (`right_id`),
  KEY `fk_user_id_t_user_right` (`user_id`),
  CONSTRAINT `fk_right_id_t_user_right` FOREIGN KEY (`right_id`) REFERENCES `t_right` (`right_id`),
  CONSTRAINT `fk_user_id_t_user_right` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户权限表';

-- 正在导出表  salary.t_user_right 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `t_user_right` DISABLE KEYS */;
INSERT INTO `t_user_right` (`user_right_id`, `user_id`, `right_id`, `right_type`) VALUES
	(1, '20171101', 1, 0),
	(2, '19970129', 2, 0),
	(4, '20200202', 2, 0),
	(6, '19990519', 3, 0),
	(12, '20190122', 2, 0);
/*!40000 ALTER TABLE `t_user_right` ENABLE KEYS */;

-- 导出  表 salary.t_user_role 结构
CREATE TABLE IF NOT EXISTS `t_user_role` (
  `user_role_id` bigint(8) NOT NULL auto_increment COMMENT '记录标识',
  `user_id` varchar(8) collate utf8_bin NOT NULL COMMENT '用户编号',
  `role_id` bigint(8) NOT NULL COMMENT '角色编号',
  PRIMARY KEY  (`user_role_id`),
  KEY `fk_user_id_t_user_role` (`user_id`),
  KEY `fk_role_id_t_user_role` (`role_id`),
  CONSTRAINT `fk_role_id_t_user_role` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`role_id`),
  CONSTRAINT `fk_user_id_t_user_role` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户角色表';

-- 正在导出表  salary.t_user_role 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `t_user_role` DISABLE KEYS */;
INSERT INTO `t_user_role` (`user_role_id`, `user_id`, `role_id`) VALUES
	(1, '20171101', 1),
	(2, '19970129', 2),
	(4, '20200202', 2),
	(6, '19990519', 3),
	(12, '20190122', 2);
/*!40000 ALTER TABLE `t_user_role` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
