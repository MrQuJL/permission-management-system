/*
Navicat MySQL Data Transfer

Source Server         : 39.107.70.197_3306
Source Server Version : 50639
Source Host           : 39.107.70.197:3306
Source Database       : pms

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2018-03-18 21:09:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `pms_sys_area`
-- ----------------------------
DROP TABLE IF EXISTS `pms_sys_area`;
CREATE TABLE `pms_sys_area` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` int(32) NOT NULL COMMENT '父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `code` varchar(100) DEFAULT NULL COMMENT '区域编码',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_area_parent_id` (`parent_id`) USING BTREE,
  KEY `sys_area_del_flag` (`del_flag`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8 COMMENT='区域表';

-- ----------------------------
-- Records of pms_sys_area
-- ----------------------------
INSERT INTO `pms_sys_area` VALUES ('1', '0', '中国', '10', '086', '1', '2018-02-01 08:00:00', '1', '2018-02-01 08:00:00', '', '0');
INSERT INTO `pms_sys_area` VALUES ('9', '1', '山东省', '10', '009', '1', '2018-02-01 22:07:23', '1', '2018-03-03 14:37:11', '', '0');
INSERT INTO `pms_sys_area` VALUES ('10', '1', '浙江省', '204', '123', '1', '2018-02-01 22:07:38', '1', '2018-03-03 14:33:48', '', '0');
INSERT INTO `pms_sys_area` VALUES ('11', '9', '烟台市', '10', '', '1', '2018-02-01 22:07:54', '1', '2018-03-03 14:44:10', '', '0');
INSERT INTO `pms_sys_area` VALUES ('13', '10', '杭州', '10', '121', '1', '2018-02-01 22:08:28', '1', '2018-02-02 14:39:23', '', '1');
INSERT INTO `pms_sys_area` VALUES ('16', '1', '广东省', '12', '102', '1', '2018-02-02 11:17:26', '1', '2018-03-03 14:27:00', '', '0');
INSERT INTO `pms_sys_area` VALUES ('18', '9', '济南市', '12', '12', '1', '2018-02-02 14:02:38', '1', '2018-03-03 14:39:51', '', '1');
INSERT INTO `pms_sys_area` VALUES ('20', '9', '临沂市', '4545', '1231312112', '10', '2018-02-02 15:49:28', '1', '2018-03-03 16:24:37', '', '0');
INSERT INTO `pms_sys_area` VALUES ('21', '20', '兰山', '343', '1212', '10', '2018-02-02 15:49:40', '10', '2018-02-02 15:50:08', '', '1');
INSERT INTO `pms_sys_area` VALUES ('22', '16', '1212', '0', '121', '1', '2018-02-02 17:57:45', '1', '2018-02-12 18:25:47', '', '1');
INSERT INTO `pms_sys_area` VALUES ('26', '10', 'f', '12', '12', '13', '2018-02-09 12:01:15', '13', '2018-02-09 12:01:15', '1212', '1');
INSERT INTO `pms_sys_area` VALUES ('27', '10', '杭州', '12', '1234', '1', '2018-02-11 22:50:54', '1', '2018-02-11 22:50:54', '1', '1');
INSERT INTO `pms_sys_area` VALUES ('33', '10', '杭州市', '10', '12', '1', '2018-02-11 23:02:47', '1', '2018-03-03 16:38:44', '1111', '0');
INSERT INTO `pms_sys_area` VALUES ('39', '10', '杭州', '12', '12345', '13', '2018-02-12 11:29:25', '13', '2018-02-12 11:29:25', '1', '1');
INSERT INTO `pms_sys_area` VALUES ('40', '16', '某某市', '12', '111', '1', '2018-02-15 14:00:19', '1', '2018-03-03 16:27:21', '12', '0');
INSERT INTO `pms_sys_area` VALUES ('41', '20', '兰山', '11', '22', '1', '2018-02-15 14:14:24', '1', '2018-02-15 14:14:24', '1', '1');

-- ----------------------------
-- Table structure for `pms_sys_dept`
-- ----------------------------
DROP TABLE IF EXISTS `pms_sys_dept`;
CREATE TABLE `pms_sys_dept` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` int(32) NOT NULL COMMENT '父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `code` varchar(100) DEFAULT NULL COMMENT '区域编码',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `master` varchar(100) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `fax` varchar(200) DEFAULT NULL COMMENT '传真',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_office_parent_id` (`parent_id`) USING BTREE,
  KEY `sys_office_del_flag` (`del_flag`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COMMENT='机构表';

-- ----------------------------
-- Records of pms_sys_dept
-- ----------------------------
INSERT INTO `pms_sys_dept` VALUES ('1', '0', '山东省总公司', '10', '100000', '', '', '', '', '', '1', '2018-01-30 08:00:00', '', '0');
INSERT INTO `pms_sys_dept` VALUES ('2', '1', '公司领导', '10', '100001', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `pms_sys_dept` VALUES ('3', '1', '综合部', '20', '100002', null, null, null, null, null, '1', '2018-01-30 07:00:00', null, '0');
INSERT INTO `pms_sys_dept` VALUES ('4', '1', '市场部', '30', '100003', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `pms_sys_dept` VALUES ('5', '1', '技术部', '40', '100004', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `pms_sys_dept` VALUES ('6', '1', '研发部', '50', '100005', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `pms_sys_dept` VALUES ('7', '1', '烟台市分公司', '20', '200000', '', '', '', '', '', '1', '2018-01-30 08:00:00', '', '0');
INSERT INTO `pms_sys_dept` VALUES ('8', '7', '公司领导', '10', '200001', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `pms_sys_dept` VALUES ('9', '7', '综合部', '20', '200002', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `pms_sys_dept` VALUES ('10', '7', '市场部', '30', '200003', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `pms_sys_dept` VALUES ('11', '7', '技术部', '40', '200004', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `pms_sys_dept` VALUES ('12', '7', '牟平区分公司', '0', '201000', '', '', '', '', '', '1', '2018-01-30 08:00:00', '', '0');
INSERT INTO `pms_sys_dept` VALUES ('13', '12', '公司领导', '10', '201001', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `pms_sys_dept` VALUES ('14', '12', '综合部', '20', '201002', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `pms_sys_dept` VALUES ('15', '12', '市场部', '30', '201003', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `pms_sys_dept` VALUES ('16', '12', '技术部', '40', '201004', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `pms_sys_dept` VALUES ('32', '0', '浙江省总公司', '12', '', '', '', '', '', '', '11', '2018-02-01 14:06:28', '', '0');
INSERT INTO `pms_sys_dept` VALUES ('33', '32', '杭州市分公司', '12', '3306', '浙江省杭州市', '曲健磊', '', '', '', '1', '2018-03-03 14:25:33', '', '0');
INSERT INTO `pms_sys_dept` VALUES ('34', '12', '测试王五', '12', '', '', '', '', '', '', '13', '2018-02-08 22:14:58', '', '1');
INSERT INTO `pms_sys_dept` VALUES ('35', '1', '临沂市', '12', '', '', '', '', '', '', '13', '2018-02-09 12:02:15', '', '1');
INSERT INTO `pms_sys_dept` VALUES ('36', '32', '杭州一店', '12', '12', '12', '12', '12', '12', '12', '1', '2018-02-11 23:03:22', '12', '1');
INSERT INTO `pms_sys_dept` VALUES ('47', '32', '杭州二店', '12', '121', 'd', 'df', '33434', '3434', '343', '1', '2018-02-12 10:33:01', '', '1');
INSERT INTO `pms_sys_dept` VALUES ('48', '32', 'sdf', '10', 'df', 'd', '曲健磊', '1212121212', '1212', '11', '1', '2018-02-15 14:14:57', '121', '1');
INSERT INTO `pms_sys_dept` VALUES ('49', '32', '杭州二店', '12', '11', '', '', '', '', '', '1', '2018-02-15 14:28:02', '', '1');
INSERT INTO `pms_sys_dept` VALUES ('50', '0', '江苏省总公司', '12', '', '', '', '', '', '', '1', '2018-03-03 15:18:44', '', '0');
INSERT INTO `pms_sys_dept` VALUES ('51', '50', '南京市分公司', '134', '12', '', 'qqqq', '2232323', '', '', '1', '2018-03-03 16:51:05', '', '0');

-- ----------------------------
-- Table structure for `pms_sys_dict`
-- ----------------------------
DROP TABLE IF EXISTS `pms_sys_dict`;
CREATE TABLE `pms_sys_dict` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `value` varchar(100) NOT NULL COMMENT '数据值',
  `label` varchar(100) NOT NULL COMMENT '标签名',
  `type` varchar(100) NOT NULL COMMENT '类型',
  `description` varchar(100) NOT NULL COMMENT '描述',
  `sort` decimal(10,0) NOT NULL COMMENT '排序（升序）',
  `parent_id` varchar(64) DEFAULT '0' COMMENT '父级编号',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_dict_value` (`value`) USING BTREE,
  KEY `sys_dict_label` (`label`) USING BTREE,
  KEY `sys_dict_del_flag` (`del_flag`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of pms_sys_dict
-- ----------------------------
INSERT INTO `pms_sys_dict` VALUES ('2', '1', '删除', 'del_flag', '删除标记', '20', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('3', '1', '显示', 'show_hide', '显示/隐藏', '10', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('4', '0', '隐藏', 'show_hide', '显示/隐藏', '20', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('5', '1', '是', 'yes_no', '是/否', '10', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('6', '0', '否', 'yes_no', '是/否', '20', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('17', '1', '国家', 'sys_area_type', '区域类型', '10', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('18', '2', '省份、直辖市', 'sys_area_type', '区域类型', '20', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('19', '3', '地市', 'sys_area_type', '区域类型', '30', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('20', '4', '区县', 'sys_area_type', '区域类型', '40', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('21', '1', '公司', 'sys_office_type', '机构类型', '60', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('22', '2', '部门', 'sys_office_type', '机构类型', '70', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('23', '3', '小组', 'sys_office_type', '机构类型', '80', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('24', '4', '其它', 'sys_office_type', '机构类型', '90', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('28', '1', '一级', 'sys_office_grade', '机构等级', '10', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('29', '2', '二级', 'sys_office_grade', '机构等级', '20', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('30', '3', '三级', 'sys_office_grade', '机构等级', '30', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('31', '4', '四级', 'sys_office_grade', '机构等级', '40', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('32', '1', '所有数据', 'sys_data_scope', '数据范围', '10', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('33', '2', '所在公司及以下数据', 'sys_data_scope', '数据范围', '20', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('34', '3', '所在公司数据', 'sys_data_scope', '数据范围', '30', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('35', '4', '所在部门及以下数据', 'sys_data_scope', '数据范围', '40', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('36', '5', '所在部门数据', 'sys_data_scope', '数据范围', '50', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('37', '8', '仅本人数据', 'sys_data_scope', '数据范围', '90', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('38', '9', '按明细设置', 'sys_data_scope', '数据范围', '100', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('39', '1', '系统管理', 'sys_user_type', '用户类型', '10', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('40', '2', '部门经理', 'sys_user_type', '用户类型', '20', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('41', '3', '普通用户', 'sys_user_type', '用户类型', '30', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('67', '1', '操作日志', 'sys_log_type', '日志类型', '30', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('68', '2', '异常日志', 'sys_log_type', '日志类型', '40', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('96', '1', '男', 'sex', '性别', '10', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('97', '2', '女', 'sex', '性别', '20', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `pms_sys_dict` VALUES ('98', '11', '22', '33', '44', '55', null, '1', '2017-04-19 15:32:11', '66', '1');
INSERT INTO `pms_sys_dict` VALUES ('99', '1212', '111', 'dfdfef', '描述1', '101', '0', '1', '2018-01-21 09:37:16', '备注221212', '1');
INSERT INTO `pms_sys_dict` VALUES ('100', '12', '12', '12', '12', '1212211221', '0', '1', '2018-01-21 09:21:26', '12', '1');
INSERT INTO `pms_sys_dict` VALUES ('101', 'new', 'wew', 'wew', 'ewew', '34343434', '0', '1', '2018-01-21 09:37:38', 'ewewe', '1');
INSERT INTO `pms_sys_dict` VALUES ('102', '121', '1212', '1212', '1212', '1212', '0', '1', '2018-01-22 09:26:28', '12121', '0');
INSERT INTO `pms_sys_dict` VALUES ('103', '12', '11', '1', '1212', '12', '0', '1', '2018-02-15 14:13:51', '111', '1');

-- ----------------------------
-- Table structure for `pms_sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `pms_sys_log`;
CREATE TABLE `pms_sys_log` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `type` varchar(30) DEFAULT NULL,
  `title` varchar(255) DEFAULT '' COMMENT '日志标题',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_date` date DEFAULT NULL,
  `dept_id` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sys_log_create_by` (`create_by`) USING BTREE,
  KEY `sys_log_type` (`type`) USING BTREE,
  KEY `sys_log_create_date` (`create_date`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4877 DEFAULT CHARSET=utf8 COMMENT='日志表';

-- ----------------------------
-- Records of pms_sys_log
-- ----------------------------
INSERT INTO `pms_sys_log` VALUES ('4819', '操作日志', 'saveDept', '曲健磊', '2018-02-12', '1');
INSERT INTO `pms_sys_log` VALUES ('4820', '操作日志', 'saveArea', '王五', '2018-02-12', '32');
INSERT INTO `pms_sys_log` VALUES ('4821', '操作日志', 'delArea', '王五', '2018-02-12', '32');
INSERT INTO `pms_sys_log` VALUES ('4822', '操作日志', 'updateArea', '王五', '2018-02-12', '32');
INSERT INTO `pms_sys_log` VALUES ('4823', '操作日志', 'delDept', '曲健磊', '2018-02-12', '1');
INSERT INTO `pms_sys_log` VALUES ('4824', '操作日志', 'delDept', '曲健磊', '2018-02-12', '1');
INSERT INTO `pms_sys_log` VALUES ('4825', '操作日志', 'saveUserInfo', '曲健磊', '2018-02-12', '1');
INSERT INTO `pms_sys_log` VALUES ('4826', '操作日志', 'updateDept', '曲健磊', '2018-02-12', '1');
INSERT INTO `pms_sys_log` VALUES ('4827', '操作日志', 'updateArea', '曲健磊', '2018-02-12', '1');
INSERT INTO `pms_sys_log` VALUES ('4828', '操作日志', 'updateArea', '曲健磊', '2018-02-12', '1');
INSERT INTO `pms_sys_log` VALUES ('4829', '操作日志', 'updateRole', '曲健磊', '2018-02-12', '1');
INSERT INTO `pms_sys_log` VALUES ('4830', '操作日志', 'saveArea', '曲健磊', '2018-02-15', '1');
INSERT INTO `pms_sys_log` VALUES ('4831', '操作日志', 'delArea', '曲健磊', '2018-02-15', '1');
INSERT INTO `pms_sys_log` VALUES ('4832', '操作日志', 'delArea', '曲健磊', '2018-02-15', '1');
INSERT INTO `pms_sys_log` VALUES ('4833', '操作日志', 'saveDict', '曲健磊', '2018-02-15', '1');
INSERT INTO `pms_sys_log` VALUES ('4834', '操作日志', 'delDictById', '曲健磊', '2018-02-15', '1');
INSERT INTO `pms_sys_log` VALUES ('4835', '操作日志', 'saveArea', '曲健磊', '2018-02-15', '1');
INSERT INTO `pms_sys_log` VALUES ('4836', '操作日志', 'saveDept', '曲健磊', '2018-02-15', '1');
INSERT INTO `pms_sys_log` VALUES ('4837', '操作日志', 'delArea', '曲健磊', '2018-02-15', '1');
INSERT INTO `pms_sys_log` VALUES ('4838', '操作日志', 'delDept', '曲健磊', '2018-02-15', '1');
INSERT INTO `pms_sys_log` VALUES ('4839', '操作日志', 'saveDept', '曲健磊', '2018-02-15', '1');
INSERT INTO `pms_sys_log` VALUES ('4840', '操作日志', 'delDept', '曲健磊', '2018-02-15', '1');
INSERT INTO `pms_sys_log` VALUES ('4841', '操作日志', 'saveRole', '曲健磊', '2018-02-15', '1');
INSERT INTO `pms_sys_log` VALUES ('4842', '操作日志', 'saveUserInfo', '曲健磊', '2018-02-15', '1');
INSERT INTO `pms_sys_log` VALUES ('4843', '操作日志', 'saveUserInfo', '曲健磊', '2018-02-17', '1');
INSERT INTO `pms_sys_log` VALUES ('4844', '操作日志', 'saveUserInfo', '曲健磊', '2018-02-17', '1');
INSERT INTO `pms_sys_log` VALUES ('4845', '操作日志', 'saveUserInfo', '曲健磊', '2018-02-17', '1');
INSERT INTO `pms_sys_log` VALUES ('4846', '操作日志', 'saveUserInfo', '曲健磊', '2018-02-17', '1');
INSERT INTO `pms_sys_log` VALUES ('4847', '操作日志', 'saveUserInfo', 'shubiao', '2018-02-17', '12');
INSERT INTO `pms_sys_log` VALUES ('4848', '操作日志', 'updateRole', '曲健磊', '2018-02-18', '1');
INSERT INTO `pms_sys_log` VALUES ('4849', '操作日志', 'saveUserInfo', '曲健磊', '2018-02-18', '1');
INSERT INTO `pms_sys_log` VALUES ('4850', '操作日志', 'saveUserInfo', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4851', '操作日志', 'saveUserInfo', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4852', '操作日志', 'updateDept', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4853', '操作日志', 'updateArea', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4854', '操作日志', 'updateArea', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4855', '操作日志', 'updateArea', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4856', '操作日志', 'updateArea', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4857', '操作日志', 'saveUserInfo', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4858', '操作日志', 'updateArea', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4859', '操作日志', 'updateArea', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4860', '操作日志', 'updateArea', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4861', '操作日志', 'updateArea', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4862', '操作日志', 'delArea', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4863', '操作日志', 'updateArea', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4864', '操作日志', 'saveDept', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4865', '操作日志', 'saveDept', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4866', '操作日志', 'updateDept', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4867', '操作日志', 'updateDept', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4868', '操作日志', 'updateDept', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4869', '操作日志', 'updateArea', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4870', '操作日志', 'updateArea', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4871', '操作日志', 'updateArea', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4872', '操作日志', 'updateArea', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4873', '操作日志', 'updateArea', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4874', '操作日志', 'updateDept', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4875', '操作日志', 'updateArea', '曲健磊', '2018-03-03', '1');
INSERT INTO `pms_sys_log` VALUES ('4876', '操作日志', 'updateDept', '曲健磊', '2018-03-03', '1');

-- ----------------------------
-- Table structure for `pms_sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `pms_sys_menu`;
CREATE TABLE `pms_sys_menu` (
  `id` int(64) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` int(64) NOT NULL COMMENT '父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `href` varchar(2000) DEFAULT NULL COMMENT '链接',
  `target` varchar(20) DEFAULT NULL COMMENT '目标',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `is_show` char(1) NOT NULL COMMENT '是否在菜单中显示',
  `permission` varchar(200) DEFAULT NULL COMMENT '权限标识',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_menu_parent_id` (`parent_id`) USING BTREE,
  KEY `sys_menu_del_flag` (`del_flag`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of pms_sys_menu
-- ----------------------------
INSERT INTO `pms_sys_menu` VALUES ('1', '0', '功能菜单', '0', '', '', '', '1', '', '1', '2018-02-10 21:17:24', '', '0');
INSERT INTO `pms_sys_menu` VALUES ('2', '1', '系统设置', '20', null, null, null, '1', null, '1', '2018-02-10 08:00:00', null, '0');
INSERT INTO `pms_sys_menu` VALUES ('3', '2', '系统设置', '20', '', '', '', '1', '', '1', '2018-02-10 16:06:14', '', '0');
INSERT INTO `pms_sys_menu` VALUES ('4', '3', '菜单管理', '10', '/sysmgr/gotoMenuList', null, 'icon-list-alt', '1', null, '1', '2018-02-10 08:00:00', null, '0');
INSERT INTO `pms_sys_menu` VALUES ('5', '4', '查看', '30', null, null, null, '0', 'sys:menu:view', '1', '2018-02-10 08:00:00', null, '0');
INSERT INTO `pms_sys_menu` VALUES ('6', '4', '修改', '40', null, null, null, '0', 'sys:menu:edit', '1', '2018-02-10 08:00:00', null, '0');
INSERT INTO `pms_sys_menu` VALUES ('7', '3', '角色管理', '20', '/sysmgr/gotoRoleList', '', 'icon-lock', '1', '', '1', '2018-02-10 17:09:58', '', '0');
INSERT INTO `pms_sys_menu` VALUES ('8', '7', '查看', '30', null, null, null, '0', 'sys:role:view', '1', '2018-02-10 08:00:00', null, '0');
INSERT INTO `pms_sys_menu` VALUES ('9', '7', '修改', '40', null, null, null, '0', 'sys:role:edit', '1', '2018-02-10 08:00:00', null, '0');
INSERT INTO `pms_sys_menu` VALUES ('10', '3', '字典管理', '30', '/sysmgr/gotoDictList', null, 'icon-th-list', '1', null, '1', '2018-02-10 08:00:00', null, '0');
INSERT INTO `pms_sys_menu` VALUES ('11', '10', '查看', '30', null, null, null, '0', 'sys:dict:view', '1', '2018-02-10 08:00:00', null, '0');
INSERT INTO `pms_sys_menu` VALUES ('12', '10', '修改', '40', null, null, null, '0', 'sys:dict:edit', '1', '2018-02-10 08:00:00', null, '0');
INSERT INTO `pms_sys_menu` VALUES ('13', '2', '机构用户', '10', null, null, null, '1', null, '1', '2018-02-10 08:00:00', null, '0');
INSERT INTO `pms_sys_menu` VALUES ('14', '13', '区域管理', '30', '/sysmgr/gotoAreaList', '', 'icon-th', '1', '', '1', '2018-02-10 22:39:55', '', '0');
INSERT INTO `pms_sys_menu` VALUES ('15', '14', '查看', '30', null, null, null, '0', 'sys:area:view', '1', '2018-02-10 08:00:00', null, '0');
INSERT INTO `pms_sys_menu` VALUES ('16', '14', '修改', '40', null, null, null, '0', 'sys:area:edit', '1', '2018-02-10 08:00:00', null, '0');
INSERT INTO `pms_sys_menu` VALUES ('17', '13', '机构管理', '20', '/sysmgr/gotoDeptList', '', 'icon-th-large', '1', '', '1', '2018-02-10 22:40:19', '', '0');
INSERT INTO `pms_sys_menu` VALUES ('18', '17', '查看', '30', null, null, null, '0', 'sys:dept:view', '1', '2018-02-10 08:00:00', null, '0');
INSERT INTO `pms_sys_menu` VALUES ('19', '17', '修改', '40', null, null, null, '0', 'sys:dept:edit', '1', '2018-02-10 08:00:00', null, '0');
INSERT INTO `pms_sys_menu` VALUES ('20', '13', '用户管理', '10', '/sysmgr/gotoUserList', '', 'icon-user', '1', '', '1', '2018-02-10 17:17:01', '', '0');
INSERT INTO `pms_sys_menu` VALUES ('21', '20', '查看', '30', null, null, null, '0', 'sys:user:view', '1', '2018-02-10 08:00:00', null, '0');
INSERT INTO `pms_sys_menu` VALUES ('22', '20', '修改', '40', null, null, null, '0', 'sys:user:edit', '1', '2018-02-10 08:00:00', null, '0');
INSERT INTO `pms_sys_menu` VALUES ('27', '1', '我的面板', '10', null, null, null, '1', null, '1', '2018-02-10 08:00:00', null, '0');
INSERT INTO `pms_sys_menu` VALUES ('28', '27', '个人信息', '10', '/sysmgr/getUserInfoById', null, null, '1', null, '1', '2018-02-10 08:00:00', null, '0');
INSERT INTO `pms_sys_menu` VALUES ('29', '28', '个人信息', '20', '/sysmgr/userInfo', null, 'icon-user', '1', null, '1', '2018-02-10 08:00:00', null, '0');
INSERT INTO `pms_sys_menu` VALUES ('30', '28', '修改密码', '30', '/sysmgr/changePwd', '', 'icon-lock', '1', '', '1', '2018-02-10 22:40:46', '', '0');
INSERT INTO `pms_sys_menu` VALUES ('31', '1', '测试', '12', '1212', '121', 'icon-ban-circle', '', '121', '13', '2018-02-09 12:03:18', '121', '1');
INSERT INTO `pms_sys_menu` VALUES ('32', '2', '日志查询', '10', '', '', '', '1', '', '1', '2018-02-11 09:15:52', '', '0');
INSERT INTO `pms_sys_menu` VALUES ('33', '32', '日志查询', '12', '/sysmgr/gotoLogList', '', 'icon-calendar', '1', 'sys:log:view', '1', '2018-02-11 09:16:49', 'test log', '0');
INSERT INTO `pms_sys_menu` VALUES ('34', '32', '连接池查询', '20', 'sys', '', 'icon-inbox', '', '22', '1', '2018-02-11 09:28:23', 'dd', '1');
INSERT INTO `pms_sys_menu` VALUES ('35', '32', '连接池查询', '23', 'sysmgr/conPool', '', 'icon-info-sign', '1', 'ss', '1', '2018-02-11 09:35:50', '1', '1');

-- ----------------------------
-- Table structure for `pms_sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `pms_sys_role`;
CREATE TABLE `pms_sys_role` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_role_del_flag` (`del_flag`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of pms_sys_role
-- ----------------------------
INSERT INTO `pms_sys_role` VALUES ('1', '超级系统管理员', '1', '2018-02-05 15:35:22', 'this is supperadmin', '0');
INSERT INTO `pms_sys_role` VALUES ('23', '总公司管理员', '1', '2016-12-05 22:10:32', 'this is normal user', '0');
INSERT INTO `pms_sys_role` VALUES ('24', '烟台分公司管理员', '1', '2018-02-12 18:26:43', 'this is workerv', '0');
INSERT INTO `pms_sys_role` VALUES ('27', '小卖部44', '1', '2018-02-05 15:36:08', '12232323', '1');
INSERT INTO `pms_sys_role` VALUES ('28', '牟平区分公司管理员', '1', '2018-02-18 16:11:04', '', '0');

-- ----------------------------
-- Table structure for `pms_sys_role_area`
-- ----------------------------
DROP TABLE IF EXISTS `pms_sys_role_area`;
CREATE TABLE `pms_sys_role_area` (
  `role_id` int(32) NOT NULL COMMENT '角色编号',
  `area_id` int(32) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`role_id`,`area_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单';

-- ----------------------------
-- Records of pms_sys_role_area
-- ----------------------------
INSERT INTO `pms_sys_role_area` VALUES ('1', '1');
INSERT INTO `pms_sys_role_area` VALUES ('1', '9');
INSERT INTO `pms_sys_role_area` VALUES ('1', '10');
INSERT INTO `pms_sys_role_area` VALUES ('1', '11');
INSERT INTO `pms_sys_role_area` VALUES ('1', '16');
INSERT INTO `pms_sys_role_area` VALUES ('1', '20');
INSERT INTO `pms_sys_role_area` VALUES ('1', '33');
INSERT INTO `pms_sys_role_area` VALUES ('1', '40');
INSERT INTO `pms_sys_role_area` VALUES ('23', '1');
INSERT INTO `pms_sys_role_area` VALUES ('23', '9');
INSERT INTO `pms_sys_role_area` VALUES ('23', '11');
INSERT INTO `pms_sys_role_area` VALUES ('24', '1');
INSERT INTO `pms_sys_role_area` VALUES ('24', '10');
INSERT INTO `pms_sys_role_area` VALUES ('28', '1');
INSERT INTO `pms_sys_role_area` VALUES ('28', '9');
INSERT INTO `pms_sys_role_area` VALUES ('28', '11');
INSERT INTO `pms_sys_role_area` VALUES ('28', '20');

-- ----------------------------
-- Table structure for `pms_sys_role_dept`
-- ----------------------------
DROP TABLE IF EXISTS `pms_sys_role_dept`;
CREATE TABLE `pms_sys_role_dept` (
  `role_id` int(32) NOT NULL COMMENT '角色编号',
  `dept_id` int(32) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`role_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单';

-- ----------------------------
-- Records of pms_sys_role_dept
-- ----------------------------
INSERT INTO `pms_sys_role_dept` VALUES ('1', '1');
INSERT INTO `pms_sys_role_dept` VALUES ('1', '2');
INSERT INTO `pms_sys_role_dept` VALUES ('1', '3');
INSERT INTO `pms_sys_role_dept` VALUES ('1', '4');
INSERT INTO `pms_sys_role_dept` VALUES ('1', '5');
INSERT INTO `pms_sys_role_dept` VALUES ('1', '6');
INSERT INTO `pms_sys_role_dept` VALUES ('1', '7');
INSERT INTO `pms_sys_role_dept` VALUES ('1', '8');
INSERT INTO `pms_sys_role_dept` VALUES ('1', '9');
INSERT INTO `pms_sys_role_dept` VALUES ('1', '10');
INSERT INTO `pms_sys_role_dept` VALUES ('1', '11');
INSERT INTO `pms_sys_role_dept` VALUES ('1', '12');
INSERT INTO `pms_sys_role_dept` VALUES ('1', '13');
INSERT INTO `pms_sys_role_dept` VALUES ('1', '14');
INSERT INTO `pms_sys_role_dept` VALUES ('1', '15');
INSERT INTO `pms_sys_role_dept` VALUES ('1', '16');
INSERT INTO `pms_sys_role_dept` VALUES ('1', '32');
INSERT INTO `pms_sys_role_dept` VALUES ('1', '33');
INSERT INTO `pms_sys_role_dept` VALUES ('1', '50');
INSERT INTO `pms_sys_role_dept` VALUES ('1', '51');
INSERT INTO `pms_sys_role_dept` VALUES ('23', '1');
INSERT INTO `pms_sys_role_dept` VALUES ('23', '2');
INSERT INTO `pms_sys_role_dept` VALUES ('23', '3');
INSERT INTO `pms_sys_role_dept` VALUES ('23', '4');
INSERT INTO `pms_sys_role_dept` VALUES ('23', '5');
INSERT INTO `pms_sys_role_dept` VALUES ('23', '6');
INSERT INTO `pms_sys_role_dept` VALUES ('23', '50');
INSERT INTO `pms_sys_role_dept` VALUES ('23', '51');
INSERT INTO `pms_sys_role_dept` VALUES ('24', '1');
INSERT INTO `pms_sys_role_dept` VALUES ('24', '7');
INSERT INTO `pms_sys_role_dept` VALUES ('24', '12');
INSERT INTO `pms_sys_role_dept` VALUES ('24', '13');
INSERT INTO `pms_sys_role_dept` VALUES ('24', '14');
INSERT INTO `pms_sys_role_dept` VALUES ('24', '15');
INSERT INTO `pms_sys_role_dept` VALUES ('24', '16');
INSERT INTO `pms_sys_role_dept` VALUES ('24', '50');
INSERT INTO `pms_sys_role_dept` VALUES ('24', '51');
INSERT INTO `pms_sys_role_dept` VALUES ('28', '1');
INSERT INTO `pms_sys_role_dept` VALUES ('28', '7');
INSERT INTO `pms_sys_role_dept` VALUES ('28', '12');
INSERT INTO `pms_sys_role_dept` VALUES ('28', '13');
INSERT INTO `pms_sys_role_dept` VALUES ('28', '14');
INSERT INTO `pms_sys_role_dept` VALUES ('28', '15');
INSERT INTO `pms_sys_role_dept` VALUES ('28', '16');
INSERT INTO `pms_sys_role_dept` VALUES ('28', '50');
INSERT INTO `pms_sys_role_dept` VALUES ('28', '51');

-- ----------------------------
-- Table structure for `pms_sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `pms_sys_role_menu`;
CREATE TABLE `pms_sys_role_menu` (
  `role_id` int(32) NOT NULL COMMENT '角色编号',
  `menu_id` int(32) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单';

-- ----------------------------
-- Records of pms_sys_role_menu
-- ----------------------------
INSERT INTO `pms_sys_role_menu` VALUES ('1', '1');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '2');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '3');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '4');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '5');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '6');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '7');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '8');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '9');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '10');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '11');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '12');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '13');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '14');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '15');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '16');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '17');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '18');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '19');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '20');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '21');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '22');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '27');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '28');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '29');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '30');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '32');
INSERT INTO `pms_sys_role_menu` VALUES ('1', '33');
INSERT INTO `pms_sys_role_menu` VALUES ('23', '1');
INSERT INTO `pms_sys_role_menu` VALUES ('23', '2');
INSERT INTO `pms_sys_role_menu` VALUES ('23', '3');
INSERT INTO `pms_sys_role_menu` VALUES ('23', '4');
INSERT INTO `pms_sys_role_menu` VALUES ('23', '5');
INSERT INTO `pms_sys_role_menu` VALUES ('23', '6');
INSERT INTO `pms_sys_role_menu` VALUES ('23', '7');
INSERT INTO `pms_sys_role_menu` VALUES ('23', '8');
INSERT INTO `pms_sys_role_menu` VALUES ('23', '9');
INSERT INTO `pms_sys_role_menu` VALUES ('23', '10');
INSERT INTO `pms_sys_role_menu` VALUES ('23', '11');
INSERT INTO `pms_sys_role_menu` VALUES ('23', '12');
INSERT INTO `pms_sys_role_menu` VALUES ('23', '27');
INSERT INTO `pms_sys_role_menu` VALUES ('23', '28');
INSERT INTO `pms_sys_role_menu` VALUES ('23', '29');
INSERT INTO `pms_sys_role_menu` VALUES ('23', '30');
INSERT INTO `pms_sys_role_menu` VALUES ('24', '1');
INSERT INTO `pms_sys_role_menu` VALUES ('24', '2');
INSERT INTO `pms_sys_role_menu` VALUES ('24', '13');
INSERT INTO `pms_sys_role_menu` VALUES ('24', '14');
INSERT INTO `pms_sys_role_menu` VALUES ('24', '15');
INSERT INTO `pms_sys_role_menu` VALUES ('24', '16');
INSERT INTO `pms_sys_role_menu` VALUES ('24', '17');
INSERT INTO `pms_sys_role_menu` VALUES ('24', '18');
INSERT INTO `pms_sys_role_menu` VALUES ('24', '19');
INSERT INTO `pms_sys_role_menu` VALUES ('24', '20');
INSERT INTO `pms_sys_role_menu` VALUES ('24', '21');
INSERT INTO `pms_sys_role_menu` VALUES ('24', '22');
INSERT INTO `pms_sys_role_menu` VALUES ('24', '27');
INSERT INTO `pms_sys_role_menu` VALUES ('24', '28');
INSERT INTO `pms_sys_role_menu` VALUES ('24', '29');
INSERT INTO `pms_sys_role_menu` VALUES ('24', '30');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '1');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '2');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '3');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '4');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '5');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '6');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '7');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '8');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '9');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '10');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '11');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '12');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '13');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '14');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '15');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '16');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '17');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '18');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '19');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '20');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '21');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '22');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '27');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '28');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '29');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '30');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '32');
INSERT INTO `pms_sys_role_menu` VALUES ('28', '33');

-- ----------------------------
-- Table structure for `pms_sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `pms_sys_user`;
CREATE TABLE `pms_sys_user` (
  `user_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `dept_id` int(32) NOT NULL COMMENT '归属部门',
  `login_name` varchar(100) NOT NULL COMMENT '登录名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `user_no` varchar(100) DEFAULT NULL COMMENT '工号',
  `user_name` varchar(100) NOT NULL COMMENT '姓名',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(200) DEFAULT NULL COMMENT '手机',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`user_id`),
  KEY `sys_user_office_id` (`dept_id`) USING BTREE,
  KEY `sys_user_login_name` (`login_name`) USING BTREE,
  KEY `sys_user_update_date` (`update_date`) USING BTREE,
  KEY `sys_user_del_flag` (`del_flag`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of pms_sys_user
-- ----------------------------
INSERT INTO `pms_sys_user` VALUES ('1', '1', 'admin', '2836451e5a7c6fae6996b79c5665dfabf3429a4e16eb3eb25ef4f1db', '001', '曲健磊', 'lyu_qujianlei@163.com', '15753506293', '15753506293', '1', '2016-12-02 15:58:08', '备注1', '0');
INSERT INTO `pms_sys_user` VALUES ('9', '7', 'xiaoyanggao', '1f1673d5440280ae288fd594d73894d34f6dfa99a9ad55f398e87ce9', '002', 'xiaoyanggao', '', '', '', '1', '2016-12-05 22:11:49', '', '0');
INSERT INTO `pms_sys_user` VALUES ('10', '12', 'shubiao', '0d25aba2782d514bf4a4934ab29c2095da7db9ae03ff6ca07c64c7f6', '003', 'shubiao', '123@qq.com', '121212', '1212', '1', '2016-12-05 22:12:17', '我是鼠标', '0');
INSERT INTO `pms_sys_user` VALUES ('11', '12', 'arry', 'b37fd06fe1ba32525a273af95993bf6f466a5d283f06ff5775339f22', '004', 'arry', 'df@dfdsf.com', '23', '323', '1', '2016-12-05 22:33:06', 'hello everyone', '0');
INSERT INTO `pms_sys_user` VALUES ('12', '1', 'zhaosi', '7592246f2a14246ba40f3a30dc938c60cfd1f5f15ef993032815af73', '0009', '赵四', '123@qq.com', '7171717', '454545', '11', '2018-02-07 13:25:32', '1212', '1');
INSERT INTO `pms_sys_user` VALUES ('13', '32', 'www', '91bfc37b3d5ee8808e2bf0728f4b5081758bf67cbaacfb65bd82dfd6', '0003', '王五', 'df@ss', '1212121212', '323', '1', '2018-02-07 16:59:39', 'dsf', '0');
INSERT INTO `pms_sys_user` VALUES ('14', '33', 'asd', '63716d286095dafbc9c45e442ba485fa575b590e7718a6a1ad425d14', '00003', 'zhangzhang', '', '', '', '1', '2018-02-09 17:17:57', '', '1');

-- ----------------------------
-- Table structure for `pms_sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `pms_sys_user_role`;
CREATE TABLE `pms_sys_user_role` (
  `user_id` int(32) NOT NULL COMMENT '用户编号',
  `role_id` int(32) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色';

-- ----------------------------
-- Records of pms_sys_user_role
-- ----------------------------
INSERT INTO `pms_sys_user_role` VALUES ('1', '1');
INSERT INTO `pms_sys_user_role` VALUES ('1', '23');
INSERT INTO `pms_sys_user_role` VALUES ('1', '24');
INSERT INTO `pms_sys_user_role` VALUES ('1', '28');
INSERT INTO `pms_sys_user_role` VALUES ('9', '23');
INSERT INTO `pms_sys_user_role` VALUES ('10', '1');
INSERT INTO `pms_sys_user_role` VALUES ('11', '28');
INSERT INTO `pms_sys_user_role` VALUES ('13', '24');
INSERT INTO `pms_sys_user_role` VALUES ('13', '28');
