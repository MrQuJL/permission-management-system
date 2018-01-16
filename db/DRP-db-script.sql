create database drp;
use drp;

# 业务功能部分的表
# 客户信息表
create table customer(
	customer_id varchar(8) primary key,
	customer_simple_name varchar(20) not null,
	customer_name varchar(60),
	owner varchar(30),
	title varchar(30),
	telephone varchar(20),
	mobilephone varchar(20),
	fax varchar(20),
	customer_address varchar(100),
	delivery_address varchar(100),
	invoice_address varchar(100)	
)
# 商品表
create table product(
	product_id varchar(8) primary key,
	product_name varchar(30) not null,
	quantity decimal(18,2) not null,
	avg_buy_price decimal(18,2) not null
)
# 供应商信息表
create table supplier(
	supplier_id varchar(8) primary key,
	supplier_simple_name varchar(20) not null,
	supplier_name varchar(60),
	owner varchar(30),
	title varchar(30),
	telephone varchar(20),
	mobilephone varchar(20),
	fax varchar(20),
	company_address varchar(100),
	factory_address varchar(100)
)
# 采购单主表
create table purchase_master(
	purchase_id varchar(8) primary key,
	purchase_date datetime,
	supplier_id varchar(8),
	subtotal decimal(18,2)
)
# 采购单明细表
create table purchase_detail(
	purchase_id varchar(8) not null,
	product_id varchar(8) not null,
	purchase_quantity decimal(18,0) not null,
	purchase_unit_price decimal(18,2) not null,
	purchase_amount decimal(18,2) not null,
	constraint pk_purchase_product primary key(purchase_id, product_id)
)
# 销售单主表
create table delivery_master(
	delivery_id varchar(8) primary key,
	delivery_date datetime not null,
	customer_id varchar(8) not null,
	delivery_address varchar(100) not null,
	subtotal decimal(18,2) not null
)
# 销售单明细表
create table delivery_detail(
	delivery_id varchar(8) not null,
	product_id varchar(8) not null,
	sales_quantity decimal(18,0) not null,
	sales_unit_price decimal(18,2) not null,
	sales_amount decimal(18,2) not null,
	constraint pk_deliver_product primary key(delivery_id, product_id)
)

# 系统功能部分的表
# 用户表
create table drp_sys_user (
  id int(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  company_id int(32) NOT NULL COMMENT '归属公司',
  office_id int(32) NOT NULL COMMENT '归属部门',
  login_name varchar(100) NOT NULL COMMENT '登录名',
  password varchar(100) NOT NULL COMMENT '密码',
  no varchar(100) DEFAULT NULL COMMENT '工号',
  name varchar(100) NOT NULL COMMENT '姓名',
  email varchar(200) DEFAULT NULL COMMENT '邮箱',
  phone varchar(200) DEFAULT NULL COMMENT '电话',
  mobile varchar(200) DEFAULT NULL COMMENT '手机',
  create_by varchar(64) NOT NULL COMMENT '创建者',
  create_date datetime NOT NULL COMMENT '创建时间',
  update_by varchar(64) NOT NULL COMMENT '更新者',
  update_date datetime NOT NULL COMMENT '更新时间',
  remarks varchar(255) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (id)
)



/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 60011
Source Host           : localhost:3306
Source Database       : drp

Target Server Type    : MYSQL
Target Server Version : 60011
File Encoding         : 65001

Date: 2018-01-16 11:11:46
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `drp_sys_area`
-- ----------------------------
DROP TABLE IF EXISTS `drp_sys_area`;
CREATE TABLE `drp_sys_area` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` int(32) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `code` varchar(100) DEFAULT NULL COMMENT '区域编码',
  `type` char(1) DEFAULT NULL COMMENT '区域类型',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_area_parent_id` (`parent_id`),
  KEY `sys_area_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='区域表';

-- ----------------------------
-- Records of drp_sys_area
-- ----------------------------
INSERT INTO `drp_sys_area` VALUES ('1', '0', '0,', '中国', '10', '086', '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', '', '0');
INSERT INTO `drp_sys_area` VALUES ('2', '1', '0,1,', '湖南省', '20', '430000', '2', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', '', '0');
INSERT INTO `drp_sys_area` VALUES ('3', '2', '0,1,2,', '长沙市', '30', '430100', '3', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', '', '0');
INSERT INTO `drp_sys_area` VALUES ('4', '3', '0,1,2,3,', '芙蓉区', '40', '430102', '4', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', '', '0');

-- ----------------------------
-- Table structure for `drp_sys_dict`
-- ----------------------------
DROP TABLE IF EXISTS `drp_sys_dict`;
CREATE TABLE `drp_sys_dict` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `value` varchar(100) NOT NULL COMMENT '数据值',
  `label` varchar(100) NOT NULL COMMENT '标签名',
  `type` varchar(100) NOT NULL COMMENT '类型',
  `description` varchar(100) NOT NULL COMMENT '描述',
  `sort` decimal(10,0) NOT NULL COMMENT '排序（升序）',
  `parent_id` varchar(64) DEFAULT '0' COMMENT '父级编号',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_dict_value` (`value`),
  KEY `sys_dict_label` (`label`),
  KEY `sys_dict_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of drp_sys_dict
-- ----------------------------
INSERT INTO `drp_sys_dict` VALUES ('1', '0', '正常', 'del_flag', '删除标记', '10', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('2', '1', '删除', 'del_flag', '删除标记', '20', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('3', '1', '显示', 'show_hide', '显示/隐藏', '10', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('4', '0', '隐藏', 'show_hide', '显示/隐藏', '20', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('5', '1', '是', 'yes_no', '是/否', '10', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('6', '0', '否', 'yes_no', '是/否', '20', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('17', '1', '国家', 'sys_area_type', '区域类型', '10', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('18', '2', '省份、直辖市', 'sys_area_type', '区域类型', '20', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('19', '3', '地市', 'sys_area_type', '区域类型', '30', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('20', '4', '区县', 'sys_area_type', '区域类型', '40', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('21', '1', '公司', 'sys_office_type', '机构类型', '60', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('22', '2', '部门', 'sys_office_type', '机构类型', '70', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('23', '3', '小组', 'sys_office_type', '机构类型', '80', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('24', '4', '其它', 'sys_office_type', '机构类型', '90', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('28', '1', '一级', 'sys_office_grade', '机构等级', '10', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('29', '2', '二级', 'sys_office_grade', '机构等级', '20', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('30', '3', '三级', 'sys_office_grade', '机构等级', '30', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('31', '4', '四级', 'sys_office_grade', '机构等级', '40', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('32', '1', '所有数据', 'sys_data_scope', '数据范围', '10', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('33', '2', '所在公司及以下数据', 'sys_data_scope', '数据范围', '20', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('34', '3', '所在公司数据', 'sys_data_scope', '数据范围', '30', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('35', '4', '所在部门及以下数据', 'sys_data_scope', '数据范围', '40', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('36', '5', '所在部门数据', 'sys_data_scope', '数据范围', '50', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('37', '8', '仅本人数据', 'sys_data_scope', '数据范围', '90', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('38', '9', '按明细设置', 'sys_data_scope', '数据范围', '100', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('39', '1', '系统管理', 'sys_user_type', '用户类型', '10', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('40', '2', '部门经理', 'sys_user_type', '用户类型', '20', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('41', '3', '普通用户', 'sys_user_type', '用户类型', '30', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('67', '1', '操作日志', 'sys_log_type', '日志类型', '30', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('68', '2', '异常日志', 'sys_log_type', '日志类型', '40', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('96', '1', '男', 'sex', '性别', '10', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('97', '2', '女', 'sex', '性别', '20', '0', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');

-- ----------------------------
-- Table structure for `drp_sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `drp_sys_log`;
CREATE TABLE `drp_sys_log` (
  `id` varchar(64) NOT NULL COMMENT '编号',
  `type` char(1) DEFAULT '1' COMMENT '日志类型',
  `title` varchar(255) DEFAULT '' COMMENT '日志标题',
  `create_by` varchar(64) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `remote_addr` varchar(255) DEFAULT NULL COMMENT '操作IP地址',
  `user_agent` varchar(255) DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(255) DEFAULT NULL COMMENT '请求URI',
  `method` varchar(5) DEFAULT NULL COMMENT '操作方式',
  `params` text COMMENT '操作提交的数据',
  `exception` text COMMENT '异常信息',
  PRIMARY KEY (`id`),
  KEY `sys_log_create_by` (`create_by`),
  KEY `sys_log_request_uri` (`request_uri`(191)),
  KEY `sys_log_type` (`type`),
  KEY `sys_log_create_date` (`create_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志表';

-- ----------------------------
-- Records of drp_sys_log
-- ----------------------------

-- ----------------------------
-- Table structure for `drp_sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `drp_sys_menu`;
CREATE TABLE `drp_sys_menu` (
  `id` int(64) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` int(64) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `href` varchar(2000) DEFAULT NULL COMMENT '链接',
  `target` varchar(20) DEFAULT NULL COMMENT '目标',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `is_show` char(1) NOT NULL COMMENT '是否在菜单中显示',
  `permission` varchar(200) DEFAULT NULL COMMENT '权限标识',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_menu_parent_id` (`parent_id`),
  KEY `sys_menu_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of drp_sys_menu
-- ----------------------------
INSERT INTO `drp_sys_menu` VALUES ('1', '0', '0,', '功能菜单', '0', null, null, null, '1', null, '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('2', '1', '0,1,', '系统设置', '20', null, null, null, '1', null, '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('3', '2', '0,1,2,', '系统设置', '20', null, null, null, '1', null, '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('4', '3', '0,1,2,3,', '菜单管理', '10', '/sys/menu/', null, 'list-alt', '1', null, '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('5', '4', '0,1,2,3,4,', '查看', '30', null, null, null, '0', 'sys:menu:view', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('6', '4', '0,1,2,3,4,', '修改', '40', null, null, null, '0', 'sys:menu:edit', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('7', '3', '0,1,2,3,', '角色管理', '20', '/sys/role/', null, 'lock', '1', null, '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('8', '7', '0,1,2,3,7,', '查看', '30', null, null, null, '0', 'sys:role:view', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('9', '7', '0,1,2,3,7,', '修改', '40', null, null, null, '0', 'sys:role:edit', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('10', '3', '0,1,2,3,', '字典管理', '30', '/sys/dict/', null, 'th-list', '1', null, '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('11', '10', '0,1,2,3,10,', '查看', '30', null, null, null, '0', 'sys:dict:view', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('12', '10', '0,1,2,3,10,', '修改', '40', null, null, null, '0', 'sys:dict:edit', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('13', '2', '0,1,2,', '机构用户', '10', null, null, null, '1', null, '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('14', '13', '0,1,2,13,', '区域管理', '30', '/sys/area/', null, 'th', '1', null, '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('15', '14', '0,1,2,13,14,', '查看', '30', null, null, null, '0', 'sys:area:view', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('16', '14', '0,1,2,13,14,', '修改', '40', null, null, null, '0', 'sys:area:edit', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('17', '13', '0,1,2,13,', '机构管理', '20', '/sys/office/', null, 'th-large', '1', null, '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('18', '17', '0,1,2,13,17,', '查看', '30', null, null, null, '0', 'sys:office:view', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('19', '17', '0,1,2,13,17,', '修改', '40', null, null, null, '0', 'sys:office:edit', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('20', '13', '0,1,2,13,', '用户管理', '10', '/sys/user/index', null, 'user', '1', null, '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('21', '20', '0,1,2,13,20,', '查看', '30', null, null, null, '0', 'sys:user:view', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('22', '20', '0,1,2,13,20,', '修改', '40', null, null, null, '0', 'sys:user:edit', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('27', '1', '0,1,', '我的面板', '10', null, null, null, '1', null, '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('28', '27', '0,1,27,', '个人信息', '10', null, null, null, '1', null, '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('29', '28', '0,1,27,28,', '个人信息', '20', '/sys/user/info', null, 'user', '1', null, '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('30', '28', '0,1,27,28,', '修改密码', '30', '/sys/user/changePwd', '', 'lock', '1', '', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', '', '0');
INSERT INTO `drp_sys_menu` VALUES ('67', '2', '0,1,2,', '日志查询', '30', null, null, null, '1', null, '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('68', '67', '0,1,2,67,', '日志查询', '10', '/sys/log', null, 'pencil', '1', 'sys:log:view', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('84', '67', '0,1,2,67,', '连接池监视', '20', '/../druid', null, null, '1', null, '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');

-- ----------------------------
-- Table structure for `drp_sys_office`
-- ----------------------------
DROP TABLE IF EXISTS `drp_sys_office`;
CREATE TABLE `drp_sys_office` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` int(32) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `area_id` varchar(64) NOT NULL COMMENT '归属区域',
  `code` varchar(100) DEFAULT NULL COMMENT '区域编码',
  `type` char(1) NOT NULL COMMENT '机构类型',
  `grade` char(1) NOT NULL COMMENT '机构等级',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `zip_code` varchar(100) DEFAULT NULL COMMENT '邮政编码',
  `master` varchar(100) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `fax` varchar(200) DEFAULT NULL COMMENT '传真',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `useable` varchar(5) DEFAULT NULL COMMENT '是否启用',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_office_parent_id` (`parent_id`),
  KEY `sys_office_del_flag` (`del_flag`),
  KEY `sys_office_type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='机构表';

-- ----------------------------
-- Records of drp_sys_office
-- ----------------------------
INSERT INTO `drp_sys_office` VALUES ('1', '0', '0,', '湖南省总公司', '10', '2', '100000', '1', '1', '', '', '', '', '', '', '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', '', '0');
INSERT INTO `drp_sys_office` VALUES ('2', '1', '0,1,', '公司领导', '10', '2', '100001', '2', '1', null, null, null, null, null, null, '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_office` VALUES ('3', '1', '0,1,', '综合部', '20', '2', '100002', '2', '1', null, null, null, null, null, null, '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_office` VALUES ('4', '1', '0,1,', '市场部', '30', '2', '100003', '2', '1', null, null, null, null, null, null, '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_office` VALUES ('5', '1', '0,1,', '技术部', '40', '2', '100004', '2', '1', null, null, null, null, null, null, '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_office` VALUES ('6', '1', '0,1,', '研发部', '50', '2', '100005', '2', '1', null, null, null, null, null, null, '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_office` VALUES ('7', '1', '0,1,', '长沙市分公司', '20', '3', '200000', '1', '2', '', '', '', '', '', '', '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', '', '0');
INSERT INTO `drp_sys_office` VALUES ('8', '7', '0,1,7,', '公司领导', '10', '3', '200001', '2', '2', null, null, null, null, null, null, '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_office` VALUES ('9', '7', '0,1,7,', '综合部', '20', '3', '200002', '2', '2', null, null, null, null, null, null, '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_office` VALUES ('10', '7', '0,1,7,', '市场部', '30', '3', '200003', '2', '2', null, null, null, null, null, null, '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_office` VALUES ('11', '7', '0,1,7,', '技术部', '40', '3', '200004', '2', '2', null, null, null, null, null, null, '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_office` VALUES ('12', '7', '0,1,7,', '芙蓉区分公司', '0', '4', '201000', '1', '3', '', '', '', '', '', '', '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', '', '0');
INSERT INTO `drp_sys_office` VALUES ('13', '12', '0,1,7,12,', '公司领导', '10', '4', '201001', '2', '3', null, null, null, null, null, null, '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_office` VALUES ('14', '12', '0,1,7,12,', '综合部', '20', '4', '201002', '2', '3', null, null, null, null, null, null, '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_office` VALUES ('15', '12', '0,1,7,12,', '市场部', '30', '4', '201003', '2', '3', null, null, null, null, null, null, '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_office` VALUES ('16', '12', '0,1,7,12,', '技术部', '40', '4', '201004', '2', '3', null, null, null, null, null, null, '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');

-- ----------------------------
-- Table structure for `drp_sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `drp_sys_role`;
CREATE TABLE `drp_sys_role` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `office_id` int(32) DEFAULT NULL COMMENT '归属机构',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `data_scope` char(1) DEFAULT NULL COMMENT '数据范围',
  `is_sys` varchar(64) DEFAULT NULL COMMENT '是否系统数据',
  `useable` varchar(64) DEFAULT NULL COMMENT '是否可用',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_role_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of drp_sys_role
-- ----------------------------
INSERT INTO `drp_sys_role` VALUES ('1', '2', '系统管理员', '1', '1', '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', '', '0');
INSERT INTO `drp_sys_role` VALUES ('2', '2', '公司管理员', '2', '1', '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', '', '0');
INSERT INTO `drp_sys_role` VALUES ('3', '2', '本公司管理员', '3', '1', '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', '', '0');
INSERT INTO `drp_sys_role` VALUES ('4', '1', '部门管理员', '4', null, '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_role` VALUES ('5', '1', '本部门管理员', '5', null, '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_role` VALUES ('6', '1', '普通用户', '8', null, '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_role` VALUES ('7', '2', '长沙市管理员', '9', '1', '1', '1', '2015-07-10 08:00:00', '1', '2015-07-10 08:00:00', '', '0');

-- ----------------------------
-- Table structure for `drp_sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `drp_sys_role_menu`;
CREATE TABLE `drp_sys_role_menu` (
  `role_id` int(32) NOT NULL COMMENT '角色编号',
  `menu_id` int(32) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单';

-- ----------------------------
-- Records of drp_sys_role_menu
-- ----------------------------
INSERT INTO `drp_sys_role_menu` VALUES ('1', '1');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '2');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '3');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '4');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '5');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '6');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '7');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '8');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '9');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '10');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '11');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '12');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '13');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '14');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '15');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '16');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '17');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '18');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '19');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '20');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '21');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '22');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '27');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '28');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '29');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '30');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '67');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '68');
INSERT INTO `drp_sys_role_menu` VALUES ('1', '84');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '1');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '2');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '3');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '4');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '5');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '6');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '7');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '8');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '9');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '10');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '11');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '12');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '13');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '14');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '15');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '16');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '17');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '18');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '19');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '20');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '21');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '22');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '27');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '28');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '29');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '30');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '67');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '68');
INSERT INTO `drp_sys_role_menu` VALUES ('2', '84');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '1');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '2');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '3');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '4');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '5');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '6');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '7');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '8');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '9');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '10');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '11');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '12');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '13');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '14');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '15');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '16');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '17');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '18');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '19');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '20');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '21');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '22');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '27');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '28');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '29');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '30');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '67');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '68');
INSERT INTO `drp_sys_role_menu` VALUES ('3', '84');

-- ----------------------------
-- Table structure for `drp_sys_role_office`
-- ----------------------------
DROP TABLE IF EXISTS `drp_sys_role_office`;
CREATE TABLE `drp_sys_role_office` (
  `role_id` int(32) NOT NULL COMMENT '角色编号',
  `office_id` int(32) NOT NULL COMMENT '机构编号',
  PRIMARY KEY (`role_id`,`office_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-机构';

-- ----------------------------
-- Records of drp_sys_role_office
-- ----------------------------
INSERT INTO `drp_sys_role_office` VALUES ('7', '7');
INSERT INTO `drp_sys_role_office` VALUES ('7', '8');
INSERT INTO `drp_sys_role_office` VALUES ('7', '9');
INSERT INTO `drp_sys_role_office` VALUES ('7', '10');
INSERT INTO `drp_sys_role_office` VALUES ('7', '11');
INSERT INTO `drp_sys_role_office` VALUES ('7', '12');
INSERT INTO `drp_sys_role_office` VALUES ('7', '13');
INSERT INTO `drp_sys_role_office` VALUES ('7', '14');
INSERT INTO `drp_sys_role_office` VALUES ('7', '15');
INSERT INTO `drp_sys_role_office` VALUES ('7', '16');
INSERT INTO `drp_sys_role_office` VALUES ('7', '17');
INSERT INTO `drp_sys_role_office` VALUES ('7', '18');
INSERT INTO `drp_sys_role_office` VALUES ('7', '19');
INSERT INTO `drp_sys_role_office` VALUES ('7', '20');
INSERT INTO `drp_sys_role_office` VALUES ('7', '21');
INSERT INTO `drp_sys_role_office` VALUES ('7', '22');
INSERT INTO `drp_sys_role_office` VALUES ('7', '23');
INSERT INTO `drp_sys_role_office` VALUES ('7', '24');
INSERT INTO `drp_sys_role_office` VALUES ('7', '25');
INSERT INTO `drp_sys_role_office` VALUES ('7', '26');

-- ----------------------------
-- Table structure for `drp_sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `drp_sys_user`;
CREATE TABLE `drp_sys_user` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `company_id` int(32) NOT NULL COMMENT '归属公司',
  `office_id` int(32) NOT NULL COMMENT '归属部门',
  `login_name` varchar(100) NOT NULL COMMENT '登录名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `no` varchar(100) DEFAULT NULL COMMENT '工号',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(200) DEFAULT NULL COMMENT '手机',
  `login_ip` varchar(100) DEFAULT NULL COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `login_flag` varchar(64) DEFAULT NULL COMMENT '是否可登录',
  `create_by` varchar(64) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_user_office_id` (`office_id`),
  KEY `sys_user_login_name` (`login_name`),
  KEY `sys_user_company_id` (`company_id`),
  KEY `sys_user_update_date` (`update_date`),
  KEY `sys_user_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of drp_sys_user
-- ----------------------------
INSERT INTO `drp_sys_user` VALUES ('1', '1', '2', 'admin', 'e81780321b66f5c0da6bb22620492e6bea7eff01a62d291e3600dbfb', '0001', '系统超级管理员', 'colin@163.com', '', '18888888888', '0:0:0:0:0:0:0:1', '2015-07-20 19:59:47', '1', '1', '2015-07-10 08:00:00', '1', '2015-07-20 17:27:40', '最高管理员', '0');

-- ----------------------------
-- Table structure for `drp_sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `drp_sys_user_role`;
CREATE TABLE `drp_sys_user_role` (
  `user_id` int(32) NOT NULL COMMENT '用户编号',
  `role_id` int(32) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色';

-- ----------------------------
-- Records of drp_sys_user_role
-- ----------------------------
INSERT INTO `drp_sys_user_role` VALUES ('1', '1');
INSERT INTO `drp_sys_user_role` VALUES ('1', '2');
