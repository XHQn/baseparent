/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : unifiedauth

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2022-12-06 16:28:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bs_city
-- ----------------------------
DROP TABLE IF EXISTS `bs_city`;
CREATE TABLE `bs_city` (
  `id` varchar(40) NOT NULL,
  `name` varchar(255) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bs_city
-- ----------------------------
INSERT INTO `bs_city` VALUES ('1084825908823904256', '北京', null);

-- ----------------------------
-- Table structure for bs_month
-- ----------------------------
DROP TABLE IF EXISTS `bs_month`;
CREATE TABLE `bs_month` (
  `month` varchar(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bs_month
-- ----------------------------
INSERT INTO `bs_month` VALUES ('01');
INSERT INTO `bs_month` VALUES ('02');
INSERT INTO `bs_month` VALUES ('03');
INSERT INTO `bs_month` VALUES ('04');
INSERT INTO `bs_month` VALUES ('05');
INSERT INTO `bs_month` VALUES ('06');
INSERT INTO `bs_month` VALUES ('07');
INSERT INTO `bs_month` VALUES ('08');
INSERT INTO `bs_month` VALUES ('09');
INSERT INTO `bs_month` VALUES ('10');
INSERT INTO `bs_month` VALUES ('11');
INSERT INTO `bs_month` VALUES ('12');

-- ----------------------------
-- Table structure for bs_permission
-- ----------------------------
DROP TABLE IF EXISTS `bs_permission`;
CREATE TABLE `bs_permission` (
  `id` varchar(40) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `company_id` varchar(255) NOT NULL,
  `administrator_name` varchar(255) NOT NULL,
  `management_module` text,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bs_permission
-- ----------------------------

-- ----------------------------
-- Table structure for bs_user
-- ----------------------------
DROP TABLE IF EXISTS `bs_user`;
CREATE TABLE `bs_user` (
  `id` varchar(40) NOT NULL COMMENT 'ID',
  `mobile` varchar(40) NOT NULL COMMENT '手机号码',
  `username` varchar(255) NOT NULL COMMENT '用户名称',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `openid` varchar(255) DEFAULT NULL,
  `enable_state` int(11) DEFAULT '1' COMMENT '启用状态 0是禁用，1是启用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `department_id` varchar(40) DEFAULT NULL COMMENT '部门ID',
  `time_of_entry` datetime DEFAULT NULL COMMENT '入职时间',
  `form_of_employment` int(11) DEFAULT NULL COMMENT '聘用形式',
  `work_number` varchar(20) DEFAULT NULL COMMENT '工号',
  `form_of_management` varchar(8) DEFAULT NULL COMMENT '管理形式',
  `working_city` varchar(16) DEFAULT NULL COMMENT '工作城市',
  `correction_time` datetime DEFAULT NULL COMMENT '转正时间',
  `in_service_status` int(11) DEFAULT NULL COMMENT '在职状态 1.在职  2.离职',
  `company_id` varchar(40) DEFAULT NULL COMMENT '企业ID',
  `company_name` varchar(40) DEFAULT NULL,
  `department_name` varchar(40) DEFAULT NULL,
  `level` varchar(40) DEFAULT NULL COMMENT '用户级别：saasAdmin，coAdmin，user',
  `staff_photo` mediumtext,
  `time_of_dimission` datetime DEFAULT NULL COMMENT '离职时间',
  `stationid` varchar(40) DEFAULT NULL COMMENT '岗位id',
  `stationname` varchar(255) DEFAULT NULL COMMENT '岗位名称',
  `firstid` varchar(40) DEFAULT NULL COMMENT '一级id',
  `firstclass` varchar(255) DEFAULT NULL COMMENT '一级类别',
  `secondid` varchar(40) DEFAULT NULL,
  `secondclass` varchar(255) DEFAULT NULL COMMENT '二级类别',
  `thirdid` varchar(40) DEFAULT NULL COMMENT '三级id',
  `thirdclass` varchar(255) DEFAULT NULL COMMENT '三级类别',
  `displayname` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_user_phone` (`mobile`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bs_user
-- ----------------------------
INSERT INTO `bs_user` VALUES ('1307871054101757952', '13800000002', '秘书1(区委办)', 'c8b7722b1139bb9b346409e503302e82', null, '1', null, '1307870719920590848', '2020-09-21 08:00:00', '1', '001', null, null, '2020-09-21 00:00:00', null, '1307867739750158336', null, '秘书科', 'user', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `bs_user` VALUES ('1346652709335339008', '13100000001', '管理员', '555458ba63855b01279540737c9a19c9', null, '1', null, null, '2021-01-06 00:00:00', null, null, null, null, null, null, '1307867739750158336', null, null, 'coAdmin', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `bs_user` VALUES ('1572839166844563456', '13800000000', '管理员', '421692925d239f141b21f5e3381a3760', null, '1', null, null, null, null, null, null, null, null, null, '1307867739750158336', null, null, 'user', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `bs_user` VALUES ('1573113052911853568', '13800000003', '秘书1(政府办)', '14af10ffa3798486632a79cbbf469376', null, '1', null, '1572852261235081216', null, null, null, null, null, null, null, '1307867739750158336', null, '秘书科', 'user', null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for bs_user_last
-- ----------------------------
DROP TABLE IF EXISTS `bs_user_last`;
CREATE TABLE `bs_user_last` (
  `id` varchar(40) NOT NULL COMMENT 'ID',
  `mobile` varchar(40) NOT NULL COMMENT '手机号码',
  `username` varchar(255) NOT NULL COMMENT '用户名称',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `openid` varchar(255) DEFAULT NULL,
  `enable_state` int(11) DEFAULT '1' COMMENT '启用状态 0是禁用，1是启用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `department_id` varchar(40) DEFAULT NULL COMMENT '部门ID',
  `time_of_entry` datetime DEFAULT NULL COMMENT '入职时间',
  `form_of_employment` int(11) DEFAULT NULL COMMENT '聘用形式',
  `work_number` varchar(20) DEFAULT NULL COMMENT '工号',
  `form_of_management` varchar(8) DEFAULT NULL COMMENT '管理形式',
  `working_city` varchar(16) DEFAULT NULL COMMENT '工作城市',
  `correction_time` datetime DEFAULT NULL COMMENT '转正时间',
  `in_service_status` int(11) DEFAULT NULL COMMENT '在职状态 1.在职  2.离职',
  `company_id` varchar(40) DEFAULT NULL COMMENT '企业ID',
  `company_name` varchar(40) DEFAULT NULL,
  `department_name` varchar(40) DEFAULT NULL,
  `level` varchar(40) DEFAULT NULL COMMENT '用户级别：saasAdmin，coAdmin，user',
  `staff_photo` mediumtext,
  `time_of_dimission` datetime DEFAULT NULL COMMENT '离职时间',
  `stationid` varchar(40) DEFAULT NULL COMMENT '岗位id',
  `stationname` varchar(255) DEFAULT NULL COMMENT '岗位名称',
  `firstid` varchar(40) DEFAULT NULL COMMENT '一级id',
  `firstclass` varchar(255) DEFAULT NULL COMMENT '一级类别',
  `secondid` varchar(40) DEFAULT NULL,
  `secondclass` varchar(255) DEFAULT NULL COMMENT '二级类别',
  `thirdid` varchar(40) DEFAULT NULL COMMENT '三级id',
  `thirdclass` varchar(255) DEFAULT NULL COMMENT '三级类别',
  `displayname` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_user_phone` (`mobile`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of bs_user_last
-- ----------------------------

-- ----------------------------
-- Table structure for co_company
-- ----------------------------
DROP TABLE IF EXISTS `co_company`;
CREATE TABLE `co_company` (
  `id` varchar(32) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `renewal_date` datetime DEFAULT NULL,
  `expiration_date` datetime DEFAULT NULL,
  `company_area` varchar(255) DEFAULT NULL,
  `company_address` varchar(255) DEFAULT NULL,
  `business_license_id` varchar(255) DEFAULT NULL,
  `legal_representative` varchar(255) DEFAULT NULL,
  `company_phone` varchar(255) DEFAULT NULL,
  `mailbox` varchar(255) DEFAULT NULL,
  `company_size` varchar(255) DEFAULT NULL,
  `industry` varchar(255) DEFAULT NULL,
  `remarks` text,
  `audit_state` varchar(10) DEFAULT NULL,
  `state` tinyint(4) DEFAULT NULL,
  `balance` double DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `database_url` varchar(255) DEFAULT NULL,
  `database_name` varchar(255) DEFAULT NULL,
  `database_user_name` varchar(255) DEFAULT NULL,
  `database_user_password` varchar(255) DEFAULT NULL,
  `database_state` tinyint(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of co_company
-- ----------------------------

-- ----------------------------
-- Table structure for co_department
-- ----------------------------
DROP TABLE IF EXISTS `co_department`;
CREATE TABLE `co_department` (
  `id` varchar(40) NOT NULL,
  `company_id` varchar(255) NOT NULL COMMENT '企业ID',
  `pid` varchar(255) DEFAULT NULL COMMENT '父级部门ID',
  `name` varchar(255) DEFAULT NULL COMMENT '部门名称',
  `code` varchar(255) DEFAULT NULL COMMENT '部门编码',
  `manager` varchar(40) DEFAULT NULL COMMENT '部门负责人',
  `introduce` text COMMENT '介绍',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `manager_id` varchar(255) DEFAULT NULL COMMENT '负责人ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of co_department
-- ----------------------------
INSERT INTO `co_department` VALUES ('1307870622071672832', '1307867739750158336', '', '区委办', '001', null, null, null, null);
INSERT INTO `co_department` VALUES ('1307870719920590848', '1307867739750158336', '1307870622071672832', '秘书科(区委办)', '001001', '秘书', '秘书科', null, null);
INSERT INTO `co_department` VALUES ('1307870862724059136', '1307867739750158336', '1307870622071672832', '城管局', '001002', '城管局', '城管局', null, null);
INSERT INTO `co_department` VALUES ('1572852197129338880', '1307867739750158336', '', '政府办', '002', null, null, null, null);
INSERT INTO `co_department` VALUES ('1572852261235081216', '1307867739750158336', '1572852197129338880', '秘书科(政府办)', '002001', null, null, null, null);

-- ----------------------------
-- Table structure for co_transaction_record
-- ----------------------------
DROP TABLE IF EXISTS `co_transaction_record`;
CREATE TABLE `co_transaction_record` (
  `id` varchar(40) NOT NULL,
  `company_id` varchar(255) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `type` int(11) NOT NULL,
  `amount` double NOT NULL,
  `balance` double NOT NULL,
  `note` text,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of co_transaction_record
-- ----------------------------

-- ----------------------------
-- Table structure for pe_permission
-- ----------------------------
DROP TABLE IF EXISTS `pe_permission`;
CREATE TABLE `pe_permission` (
  `id` varchar(40) NOT NULL COMMENT '主键',
  `description` text COMMENT '权限描述',
  `name` varchar(255) DEFAULT NULL COMMENT '权限名称',
  `type` tinyint(4) DEFAULT NULL COMMENT '权限类型 1为菜单 2为功能 3为API',
  `pid` varchar(40) DEFAULT '0' COMMENT '主键',
  `code` varchar(20) DEFAULT NULL,
  `en_visible` int(11) DEFAULT NULL COMMENT '企业可见性 0：不可见，1：可见',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of pe_permission
-- ----------------------------
INSERT INTO `pe_permission` VALUES ('1', '3', 'SAAS企业管理', '1', '0', 'saas-clients', '0');
INSERT INTO `pe_permission` VALUES ('1063313020819738624', '查看部门的按钮', '查看部门', '2', '1', 'point-dept', '0');
INSERT INTO `pe_permission` VALUES ('1063315016368918528', '用户管理菜单', '账号管理', '1', '0', 'employees', '1');
INSERT INTO `pe_permission` VALUES ('1063315194329042944', '用户删除按钮', '用户删除按钮', '2', '1063315016368918528', 'point-user-delete', '1');
INSERT INTO `pe_permission` VALUES ('1063322760811515904', '删除api', '删除用户api', '3', '1063315194329042944', 'API-USER-DELETE', '1');
INSERT INTO `pe_permission` VALUES ('1063327833876729856', '组织架构菜单', '组织架构', '1', '0', 'departments', '1');
INSERT INTO `pe_permission` VALUES ('1063328114689576960', '角色管理菜单', '角色管理', '1', '0', 'settings', '1');
INSERT INTO `pe_permission` VALUES ('1063328310592933888', '用户添加按钮', '用户添加按钮', '2', '1063315016368918528', 'POINT-USER-ADD', '1');
INSERT INTO `pe_permission` VALUES ('1063328532492587008', '用户修改按钮', '用户修改按钮', '2', '1063315016368918528', 'POINT-USER-UPDATE', '1');
INSERT INTO `pe_permission` VALUES ('1064104257952813056', null, '权限管理', '1', '0', 'permissions', '1');
INSERT INTO `pe_permission` VALUES ('1146308691438043136', null, '社保', '1', '0', 'social_securitys', '1');
INSERT INTO `pe_permission` VALUES ('1151424682926747648', '考勤', '考勤', '1', '0', 'attendances', '1');
INSERT INTO `pe_permission` VALUES ('1151747519034093568', '工资模块', '工资', '1', '0', 'salarys', '1');
INSERT INTO `pe_permission` VALUES ('1156085524669272064', '员工自助', '员工自助', '1', '0', 'user', '1');
INSERT INTO `pe_permission` VALUES ('1280383967981842432', '111', '111', '2', '1280383700351692800', '111', '1');
INSERT INTO `pe_permission` VALUES ('1282859337507250176', '字典表菜单', '字典表', '1', '0', 'dic', '1');
INSERT INTO `pe_permission` VALUES ('1304605738725388288', '123123123123', '123', '2', '1304600119037505536', '123', '1');
INSERT INTO `pe_permission` VALUES ('1304605804416577536', '123', '12312', '3', '1304600119037505536', '1231', '1');
INSERT INTO `pe_permission` VALUES ('1307871701991702528', '人员管理菜单', '人员管理', '1', '0', 'employees', '1');
INSERT INTO `pe_permission` VALUES ('1307893500838166528', '文件管理', '文件管理', '1', '0', 'meetFile', '1');
INSERT INTO `pe_permission` VALUES ('1307893895752859648', '会议管理', '会议管理', '1', '0', 'meetMeeting', '1');
INSERT INTO `pe_permission` VALUES ('1307894118457819136', '议题管理', '议题管理', '1', '0', 'meetTopics', '1');
INSERT INTO `pe_permission` VALUES ('1307894284833275904', '笔记管理', '笔记管理', '1', '0', 'noteList', '1');
INSERT INTO `pe_permission` VALUES ('1307894458653622272', '签到管理', '签到管理', '1', '0', 'signIn', '1');
INSERT INTO `pe_permission` VALUES ('1316634650514919424', '参会人员管理', '参会人员', '1', '0', 'meetPerson', '1');
INSERT INTO `pe_permission` VALUES ('1317308197394558976', '文件管理', '文件管理', '1', '0', 'attFile', '1');
INSERT INTO `pe_permission` VALUES ('1317308336951635968', '设备管理', '设备管理', '1', '0', 'meetDevice', '1');
INSERT INTO `pe_permission` VALUES ('1318385647534276608', '便签管理', '便签管理', '1', '0', 'meetNote', '1');
INSERT INTO `pe_permission` VALUES ('1324260815379447808', '会议资料', '会议资料', '1', '0', 'meetTopicsFile', '1');
INSERT INTO `pe_permission` VALUES ('1324557890826645504', 'welink组织', 'welink组织', '1', '0', 'welinkDepartment', '1');
INSERT INTO `pe_permission` VALUES ('1324558039657328640', 'welink人员', 'welink人员', '1', '0', 'welinkUser', '1');
INSERT INTO `pe_permission` VALUES ('1324626543756554240', '签到管理', '签到管理', '1', '0', 'signIn', '1');
INSERT INTO `pe_permission` VALUES ('1325649047157555200', '议题人员', '议题人员', '1', '0', 'meetPersonTopics', '1');
INSERT INTO `pe_permission` VALUES ('1328513938307952640', '通知公告', '通知公告', '1', '0', 'msgNotice', '1');
INSERT INTO `pe_permission` VALUES ('1336485953723731968', '已读消息', '已读消息', '1', '0', 'msgRead', '1');
INSERT INTO `pe_permission` VALUES ('1336486135093825536', '接收消息', '接收消息', '1', '0', 'msgReceiver', '1');
INSERT INTO `pe_permission` VALUES ('1336486242916798464', '消息发送', '消息发送', '1', '0', 'msgSend', '1');
INSERT INTO `pe_permission` VALUES ('1346653834050539520', '课程栏目', '课程栏目', '1', '0', 'studyingChannel', '1');
INSERT INTO `pe_permission` VALUES ('1346654261907296256', '课程内容', '课程内容', '1', '0', 'studyingInfo', '1');
INSERT INTO `pe_permission` VALUES ('1382569964367597568', '人员分组管理', '人员分组', '1', '0', 'meetGroup', '1');
INSERT INTO `pe_permission` VALUES ('1572056908882903040', '管理会议室', '会议室管理', '1', '0', 'meetConferenceRoom', '1');

-- ----------------------------
-- Table structure for pe_permission_api
-- ----------------------------
DROP TABLE IF EXISTS `pe_permission_api`;
CREATE TABLE `pe_permission_api` (
  `id` varchar(40) NOT NULL COMMENT '主键ID',
  `api_level` varchar(2) DEFAULT NULL COMMENT '权限等级，1为通用接口权限，2为需校验接口权限',
  `api_method` varchar(255) DEFAULT NULL COMMENT '请求类型',
  `api_url` varchar(255) DEFAULT NULL COMMENT '链接',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of pe_permission_api
-- ----------------------------
INSERT INTO `pe_permission_api` VALUES ('1063322760811515904', '1', 'delete', '/sys/user/delete');
INSERT INTO `pe_permission_api` VALUES ('1304605804416577536', '', '', '');

-- ----------------------------
-- Table structure for pe_permission_menu
-- ----------------------------
DROP TABLE IF EXISTS `pe_permission_menu`;
CREATE TABLE `pe_permission_menu` (
  `id` varchar(40) NOT NULL COMMENT '主键ID',
  `menu_icon` varchar(20) DEFAULT NULL COMMENT '权限代码',
  `menu_order` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of pe_permission_menu
-- ----------------------------
INSERT INTO `pe_permission_menu` VALUES ('1', 'abc5', '14');
INSERT INTO `pe_permission_menu` VALUES ('1063315016368918528', 'menu-user', '1');
INSERT INTO `pe_permission_menu` VALUES ('1063327833876729856', '2', '2');
INSERT INTO `pe_permission_menu` VALUES ('1063328114689576960', '3', '3');
INSERT INTO `pe_permission_menu` VALUES ('1064104257952813056', null, null);
INSERT INTO `pe_permission_menu` VALUES ('1146308691438043136', null, null);
INSERT INTO `pe_permission_menu` VALUES ('1151424682926747648', null, null);
INSERT INTO `pe_permission_menu` VALUES ('1151747519034093568', null, null);
INSERT INTO `pe_permission_menu` VALUES ('1156085524669272064', null, null);
INSERT INTO `pe_permission_menu` VALUES ('1282859337507250176', '5', '5');
INSERT INTO `pe_permission_menu` VALUES ('1307871701991702528', 'menu-user', '9');
INSERT INTO `pe_permission_menu` VALUES ('1307893500838166528', 'menu-user', '8');
INSERT INTO `pe_permission_menu` VALUES ('1307893895752859648', 'menu-user', '3');
INSERT INTO `pe_permission_menu` VALUES ('1307894118457819136', 'menu-user', '4');
INSERT INTO `pe_permission_menu` VALUES ('1307894284833275904', 'menu-user', '6');
INSERT INTO `pe_permission_menu` VALUES ('1307894458653622272', 'menu-user', '7');
INSERT INTO `pe_permission_menu` VALUES ('1316634650514919424', 'menu-user', '4');
INSERT INTO `pe_permission_menu` VALUES ('1317308197394558976', 'menu-user', '7');
INSERT INTO `pe_permission_menu` VALUES ('1317308336951635968', 'menu-user', '6');
INSERT INTO `pe_permission_menu` VALUES ('1318385647534276608', 'menu-user', '5');
INSERT INTO `pe_permission_menu` VALUES ('1324260815379447808', 'menu-user', '3');
INSERT INTO `pe_permission_menu` VALUES ('1324557890826645504', 'menu-user', '1');
INSERT INTO `pe_permission_menu` VALUES ('1324558039657328640', 'menu-user', '2');
INSERT INTO `pe_permission_menu` VALUES ('1324626543756554240', 'menu-user', '1');
INSERT INTO `pe_permission_menu` VALUES ('1325649047157555200', null, '1');
INSERT INTO `pe_permission_menu` VALUES ('1328513938307952640', 'menu-user', '1');
INSERT INTO `pe_permission_menu` VALUES ('1336485953723731968', 'menu-user', '1');
INSERT INTO `pe_permission_menu` VALUES ('1336486135093825536', 'menu-user', '2');
INSERT INTO `pe_permission_menu` VALUES ('1336486242916798464', 'menu-user', '3');
INSERT INTO `pe_permission_menu` VALUES ('1346653834050539520', 'menu-user', '1');
INSERT INTO `pe_permission_menu` VALUES ('1346654261907296256', 'menu-user', '1');
INSERT INTO `pe_permission_menu` VALUES ('1382569964367597568', 'menu-user', null);
INSERT INTO `pe_permission_menu` VALUES ('1572056908882903040', 'menu-user', '1');
INSERT INTO `pe_permission_menu` VALUES ('2', 'def', '2');

-- ----------------------------
-- Table structure for pe_permission_modular
-- ----------------------------
DROP TABLE IF EXISTS `pe_permission_modular`;
CREATE TABLE `pe_permission_modular` (
  `id` varchar(40) NOT NULL COMMENT '主键ID',
  `modular_icon` varchar(20) DEFAULT NULL COMMENT '权限代码',
  `modular_order` varchar(20) DEFAULT NULL,
  `modular_title` varchar(100) DEFAULT NULL,
  `modular_content` text,
  `modular_sub` varchar(0) DEFAULT NULL,
  `modular_width_ratio` float DEFAULT NULL,
  `modular_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of pe_permission_modular
-- ----------------------------

-- ----------------------------
-- Table structure for pe_permission_point
-- ----------------------------
DROP TABLE IF EXISTS `pe_permission_point`;
CREATE TABLE `pe_permission_point` (
  `id` varchar(40) NOT NULL COMMENT '主键ID',
  `point_class` varchar(20) DEFAULT NULL COMMENT '按钮类型',
  `point_icon` varchar(20) DEFAULT NULL COMMENT '按钮icon',
  `point_status` int(11) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of pe_permission_point
-- ----------------------------
INSERT INTO `pe_permission_point` VALUES ('1063313020819738624', 'dept', 'dept', '1');
INSERT INTO `pe_permission_point` VALUES ('1063315194329042944', 'point-user-delete', 'point-user-delete', '1');
INSERT INTO `pe_permission_point` VALUES ('1063328310592933888', 'POINT-USER-ADD', 'POINT-USER-ADD', '1');
INSERT INTO `pe_permission_point` VALUES ('1063328532492587008', 'POINT-USER-UPDATE', 'POINT-USER-UPDATE', '1');
INSERT INTO `pe_permission_point` VALUES ('1280383967981842432', '11', '11', '11');
INSERT INTO `pe_permission_point` VALUES ('1304605738725388288', '123', '123', '123');

-- ----------------------------
-- Table structure for pe_role
-- ----------------------------
DROP TABLE IF EXISTS `pe_role`;
CREATE TABLE `pe_role` (
  `id` varchar(40) NOT NULL COMMENT '主键ID',
  `name` varchar(40) DEFAULT NULL COMMENT '权限名称',
  `description` varchar(255) DEFAULT NULL COMMENT '说明',
  `company_id` varchar(40) DEFAULT NULL COMMENT '企业id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `UK_k3beff7qglfn58qsf2yvbg41i` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of pe_role
-- ----------------------------
INSERT INTO `pe_role` VALUES ('1062944989845262336', '人事经理', '负责整合人事部门', '1');
INSERT INTO `pe_role` VALUES ('1064098829009293312', '系统管理员', '管理整合平台，可以操作企业所有功能', '1');
INSERT INTO `pe_role` VALUES ('1064098935443951616', '人事专员', '只能操作员工菜单', '1');
INSERT INTO `pe_role` VALUES ('1064099035536822272', '薪资专员', '绩效管理', '1');
INSERT INTO `pe_role` VALUES ('1064099035536822276', '员工', '员工', '1');
INSERT INTO `pe_role` VALUES ('1281509469660471296', '第一小组', '第一小组角色', '2');
INSERT INTO `pe_role` VALUES ('1288399274679808000', 'asdfasdf', null, '1');
INSERT INTO `pe_role` VALUES ('1307871156526661632', '会议管理角色', '会议管理角色', '1307867739750158336');
INSERT INTO `pe_role` VALUES ('1346653321930215424', '政法委管理员', '政法委管理员角色', '1346651694448066560');
INSERT INTO `pe_role` VALUES ('1572841072165875712', '管理员', '管理员', '1307867739750158336');

-- ----------------------------
-- Table structure for pe_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `pe_role_permission`;
CREATE TABLE `pe_role_permission` (
  `role_id` varchar(40) NOT NULL COMMENT '角色ID',
  `permission_id` varchar(40) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`role_id`,`permission_id`) USING BTREE,
  KEY `FK74qx7rkbtq2wqms78gljv87a0` (`permission_id`) USING BTREE,
  KEY `FKee9dk0vg99shvsytflym6egxd` (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of pe_role_permission
-- ----------------------------
INSERT INTO `pe_role_permission` VALUES ('1062944989845262336', '1063315016368918528');
INSERT INTO `pe_role_permission` VALUES ('1062944989845262336', '1063315194329042944');
INSERT INTO `pe_role_permission` VALUES ('1062944989845262336', '1063322760811515904');
INSERT INTO `pe_role_permission` VALUES ('1062944989845262336', '1063327833876729856');
INSERT INTO `pe_role_permission` VALUES ('1062944989845262336', '1063328310592933888');
INSERT INTO `pe_role_permission` VALUES ('1062944989845262336', '1063328532492587008');
INSERT INTO `pe_role_permission` VALUES ('1062944989845262336', '1304600119037505536');
INSERT INTO `pe_role_permission` VALUES ('1064099035536822276', '1156085524669272064');
INSERT INTO `pe_role_permission` VALUES ('1281509469660471296', '1063315016368918528');
INSERT INTO `pe_role_permission` VALUES ('1281509469660471296', '1063315194329042944');
INSERT INTO `pe_role_permission` VALUES ('1281509469660471296', '1063322760811515904');
INSERT INTO `pe_role_permission` VALUES ('1281509469660471296', '1063328310592933888');
INSERT INTO `pe_role_permission` VALUES ('1281509469660471296', '1063328532492587008');
INSERT INTO `pe_role_permission` VALUES ('1307871156526661632', '1307893895752859648');
INSERT INTO `pe_role_permission` VALUES ('1307871156526661632', '1307894118457819136');
INSERT INTO `pe_role_permission` VALUES ('1307871156526661632', '1307894284833275904');
INSERT INTO `pe_role_permission` VALUES ('1307871156526661632', '1316634650514919424');
INSERT INTO `pe_role_permission` VALUES ('1307871156526661632', '1318385647534276608');
INSERT INTO `pe_role_permission` VALUES ('1307871156526661632', '1324260815379447808');
INSERT INTO `pe_role_permission` VALUES ('1307871156526661632', '1325649047157555200');
INSERT INTO `pe_role_permission` VALUES ('1307871156526661632', '1336485953723731968');
INSERT INTO `pe_role_permission` VALUES ('1307871156526661632', '1336486135093825536');
INSERT INTO `pe_role_permission` VALUES ('1307871156526661632', '1336486242916798464');
INSERT INTO `pe_role_permission` VALUES ('1307871156526661632', '1382569964367597568');
INSERT INTO `pe_role_permission` VALUES ('1307871156526661632', '1572056908882903040');
INSERT INTO `pe_role_permission` VALUES ('1346653321930215424', '1307893895752859648');
INSERT INTO `pe_role_permission` VALUES ('1346653321930215424', '1336486242916798464');
INSERT INTO `pe_role_permission` VALUES ('1346653321930215424', '1346653834050539520');
INSERT INTO `pe_role_permission` VALUES ('1346653321930215424', '1346654261907296256');
INSERT INTO `pe_role_permission` VALUES ('1572841072165875712', '1063315016368918528');
INSERT INTO `pe_role_permission` VALUES ('1572841072165875712', '1063315194329042944');
INSERT INTO `pe_role_permission` VALUES ('1572841072165875712', '1063322760811515904');
INSERT INTO `pe_role_permission` VALUES ('1572841072165875712', '1063327833876729856');
INSERT INTO `pe_role_permission` VALUES ('1572841072165875712', '1063328114689576960');
INSERT INTO `pe_role_permission` VALUES ('1572841072165875712', '1063328310592933888');
INSERT INTO `pe_role_permission` VALUES ('1572841072165875712', '1063328532492587008');
INSERT INTO `pe_role_permission` VALUES ('1572841072165875712', '1307893895752859648');
INSERT INTO `pe_role_permission` VALUES ('1572841072165875712', '1307894118457819136');
INSERT INTO `pe_role_permission` VALUES ('1572841072165875712', '1316634650514919424');
INSERT INTO `pe_role_permission` VALUES ('1572841072165875712', '1317308336951635968');
INSERT INTO `pe_role_permission` VALUES ('1572841072165875712', '1382569964367597568');
INSERT INTO `pe_role_permission` VALUES ('1572841072165875712', '1572056908882903040');

-- ----------------------------
-- Table structure for pe_user
-- ----------------------------
DROP TABLE IF EXISTS `pe_user`;
CREATE TABLE `pe_user` (
  `id` varchar(40) NOT NULL COMMENT 'ID',
  `mobile` varchar(40) NOT NULL COMMENT '手机号码',
  `username` varchar(255) NOT NULL COMMENT '用户名称',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `role` varchar(255) DEFAULT NULL,
  `enable_state` int(11) DEFAULT '1' COMMENT '启用状态 0是禁用，1是启用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `department_id` varchar(40) DEFAULT NULL COMMENT '部门ID',
  `time_of_entry` datetime DEFAULT NULL COMMENT '入职时间',
  `form_of_employment` int(11) DEFAULT NULL COMMENT '聘用形式',
  `work_number` varchar(20) DEFAULT NULL COMMENT '工号',
  `form_of_management` varchar(8) DEFAULT NULL COMMENT '管理形式',
  `working_city` varchar(16) DEFAULT NULL COMMENT '工作城市',
  `correction_time` datetime DEFAULT NULL COMMENT '转正时间',
  `in_service_status` int(11) DEFAULT NULL COMMENT '在职状态 1.在职  2.离职',
  `company_id` varchar(40) DEFAULT NULL COMMENT '企业ID',
  `company_name` varchar(40) DEFAULT NULL,
  `department_name` varchar(40) DEFAULT NULL,
  `role_ids` text,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `idx_user_phone` (`mobile`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of pe_user
-- ----------------------------

-- ----------------------------
-- Table structure for pe_user_role
-- ----------------------------
DROP TABLE IF EXISTS `pe_user_role`;
CREATE TABLE `pe_user_role` (
  `role_id` varchar(40) NOT NULL COMMENT '角色ID',
  `user_id` varchar(40) NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`role_id`,`user_id`) USING BTREE,
  KEY `FK74qx7rkbtq2wqms78gljv87a1` (`role_id`) USING BTREE,
  KEY `FKee9dk0vg99shvsytflym6egx1` (`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of pe_user_role
-- ----------------------------
INSERT INTO `pe_user_role` VALUES ('1062944989845262336', '1063705989926227968');
INSERT INTO `pe_user_role` VALUES ('1062944989845262336', '1066370498633486336');
INSERT INTO `pe_user_role` VALUES ('1062944989845262336', '1071632760222810112');
INSERT INTO `pe_user_role` VALUES ('1062944989845262336', '1074238801330704384');
INSERT INTO `pe_user_role` VALUES ('1064098829009293312', '1063705989926227968');
INSERT INTO `pe_user_role` VALUES ('1064098829009293312', '1071632760222810112');
INSERT INTO `pe_user_role` VALUES ('1064098829009293312', '1074238801330704384');
INSERT INTO `pe_user_role` VALUES ('1064098935443951616', '1063705989926227968');
INSERT INTO `pe_user_role` VALUES ('1064098935443951616', '1071632760222810112');
INSERT INTO `pe_user_role` VALUES ('1064098935443951616', '1074238801330704384');
INSERT INTO `pe_user_role` VALUES ('1064099035536822272', '1063705989926227968');
INSERT INTO `pe_user_role` VALUES ('1064099035536822272', '1071632760222810112');
INSERT INTO `pe_user_role` VALUES ('1064099035536822272', '1074238801330704384');
INSERT INTO `pe_user_role` VALUES ('1064099035536822276', '1063705989926227968');
INSERT INTO `pe_user_role` VALUES ('1064099035536822276', '1071632760222810112');
INSERT INTO `pe_user_role` VALUES ('1064099035536822276', '1074238801330704384');
INSERT INTO `pe_user_role` VALUES ('1281509469660471296', '1281509388131590144');
INSERT INTO `pe_user_role` VALUES ('1307871156526661632', '1307871054101757952');
INSERT INTO `pe_user_role` VALUES ('1307871156526661632', '1552535575638728704');
INSERT INTO `pe_user_role` VALUES ('1307871156526661632', '1572772394669842432');
INSERT INTO `pe_user_role` VALUES ('1307871156526661632', '1573113052911853568');
INSERT INTO `pe_user_role` VALUES ('1346653321930215424', '1346653149846310912');
INSERT INTO `pe_user_role` VALUES ('1572841072165875712', '1572839166844563456');
