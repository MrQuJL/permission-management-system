/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : drp

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2018-02-03 16:35:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `drp_customer`
-- ----------------------------
DROP TABLE IF EXISTS `drp_customer`;
CREATE TABLE `drp_customer` (
  `customer_id` varchar(8) NOT NULL,
  `customer_simple_name` varchar(20) NOT NULL,
  `customer_name` varchar(60) DEFAULT NULL,
  `owner` varchar(30) DEFAULT NULL,
  `title` varchar(30) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `mobilephone` varchar(20) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `customer_address` varchar(100) DEFAULT NULL,
  `delivery_address` varchar(100) DEFAULT NULL,
  `invoice_address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drp_customer
-- ----------------------------

-- ----------------------------
-- Table structure for `drp_delivery_detail`
-- ----------------------------
DROP TABLE IF EXISTS `drp_delivery_detail`;
CREATE TABLE `drp_delivery_detail` (
  `delivery_id` varchar(8) NOT NULL,
  `product_id` varchar(8) NOT NULL,
  `sales_quantity` decimal(18,0) NOT NULL,
  `sales_unit_price` decimal(18,2) NOT NULL,
  `sales_amount` decimal(18,2) NOT NULL,
  PRIMARY KEY (`delivery_id`,`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drp_delivery_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `drp_delivery_master`
-- ----------------------------
DROP TABLE IF EXISTS `drp_delivery_master`;
CREATE TABLE `drp_delivery_master` (
  `delivery_id` varchar(8) NOT NULL,
  `delivery_date` datetime NOT NULL,
  `customer_id` varchar(8) NOT NULL,
  `delivery_address` varchar(100) NOT NULL,
  `subtotal` decimal(18,2) NOT NULL,
  PRIMARY KEY (`delivery_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drp_delivery_master
-- ----------------------------

-- ----------------------------
-- Table structure for `drp_product`
-- ----------------------------
DROP TABLE IF EXISTS `drp_product`;
CREATE TABLE `drp_product` (
  `product_id` varchar(8) NOT NULL,
  `product_name` varchar(30) NOT NULL,
  `quantity` decimal(18,2) NOT NULL,
  `avg_buy_price` decimal(18,2) NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drp_product
-- ----------------------------

-- ----------------------------
-- Table structure for `drp_purchase_detail`
-- ----------------------------
DROP TABLE IF EXISTS `drp_purchase_detail`;
CREATE TABLE `drp_purchase_detail` (
  `purchase_id` varchar(8) NOT NULL,
  `product_id` varchar(8) NOT NULL,
  `purchase_quantity` decimal(18,0) NOT NULL,
  `purchase_unit_price` decimal(18,2) NOT NULL,
  `purchase_amount` decimal(18,2) NOT NULL,
  PRIMARY KEY (`purchase_id`,`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drp_purchase_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `drp_purchase_master`
-- ----------------------------
DROP TABLE IF EXISTS `drp_purchase_master`;
CREATE TABLE `drp_purchase_master` (
  `purchase_id` varchar(8) NOT NULL,
  `purchase_date` datetime DEFAULT NULL,
  `supplier_id` varchar(8) DEFAULT NULL,
  `subtotal` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`purchase_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drp_purchase_master
-- ----------------------------

-- ----------------------------
-- Table structure for `drp_supplier`
-- ----------------------------
DROP TABLE IF EXISTS `drp_supplier`;
CREATE TABLE `drp_supplier` (
  `supplier_id` varchar(8) NOT NULL,
  `supplier_simple_name` varchar(20) NOT NULL,
  `supplier_name` varchar(60) DEFAULT NULL,
  `owner` varchar(30) DEFAULT NULL,
  `title` varchar(30) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  `mobilephone` varchar(20) DEFAULT NULL,
  `fax` varchar(20) DEFAULT NULL,
  `company_address` varchar(100) DEFAULT NULL,
  `factory_address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of drp_supplier
-- ----------------------------

-- ----------------------------
-- Table structure for `drp_sys_area`
-- ----------------------------
DROP TABLE IF EXISTS `drp_sys_area`;
CREATE TABLE `drp_sys_area` (
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
  KEY `sys_area_parent_id` (`parent_id`),
  KEY `sys_area_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='区域表';

-- ----------------------------
-- Records of drp_sys_area
-- ----------------------------
INSERT INTO `drp_sys_area` VALUES ('1', '0', '中国', '10', '086', '1', '2018-02-01 08:00:00', '1', '2018-02-01 08:00:00', '', '0');
INSERT INTO `drp_sys_area` VALUES ('9', '1', '山东', '10', '', '1', '2018-02-01 22:07:23', '1', '2018-02-01 22:07:23', '', '0');
INSERT INTO `drp_sys_area` VALUES ('10', '1', '浙江', '20', '', '1', '2018-02-01 22:07:38', '1', '2018-02-01 22:07:38', '', '0');
INSERT INTO `drp_sys_area` VALUES ('11', '9', '烟台', '10', '', '1', '2018-02-01 22:07:54', '1', '2018-02-01 22:07:54', '', '0');
INSERT INTO `drp_sys_area` VALUES ('12', '9', '济南', '20', '', '1', '2018-02-01 22:08:14', '1', '2018-02-01 22:08:14', '', '0');
INSERT INTO `drp_sys_area` VALUES ('13', '10', '杭州', '10', '121', '1', '2018-02-01 22:08:28', '1', '2018-02-02 14:39:23', '', '0');
INSERT INTO `drp_sys_area` VALUES ('16', '1', '小光222', '12', '102', '1', '2018-02-02 11:17:26', '10', '2018-02-02 17:52:39', '这是测试数据ssrrf', '0');
INSERT INTO `drp_sys_area` VALUES ('17', '16', 'lala', '12', '1234', '1', '2018-02-02 14:01:33', '1', '2018-02-02 14:01:33', '1212', '1');
INSERT INTO `drp_sys_area` VALUES ('18', '9', '济南', '12', '12', '1', '2018-02-02 14:02:38', '1', '2018-02-02 14:02:38', '4434', '0');
INSERT INTO `drp_sys_area` VALUES ('19', '16', 'shubiao', '56', '12', '1', '2018-02-02 14:37:03', '1', '2018-02-02 14:37:03', 'er', '1');
INSERT INTO `drp_sys_area` VALUES ('20', '9', '临沂', '4545', '1231313', '10', '2018-02-02 15:49:28', '10', '2018-02-02 15:49:28', '1212', '0');
INSERT INTO `drp_sys_area` VALUES ('21', '20', '兰山', '343', '1212', '10', '2018-02-02 15:49:40', '10', '2018-02-02 15:50:08', '1111', '0');
INSERT INTO `drp_sys_area` VALUES ('22', '16', '1212', '0', '', '1', '2018-02-02 17:57:45', '1', '2018-02-02 17:57:45', '', '0');

-- ----------------------------
-- Table structure for `drp_sys_dept`
-- ----------------------------
DROP TABLE IF EXISTS `drp_sys_dept`;
CREATE TABLE `drp_sys_dept` (
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
  KEY `sys_office_parent_id` (`parent_id`),
  KEY `sys_office_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='机构表';

-- ----------------------------
-- Records of drp_sys_dept
-- ----------------------------
INSERT INTO `drp_sys_dept` VALUES ('1', '0', '山东省总公司', '10', '100000', '', '', '', '', '', '1', '2018-01-30 08:00:00', '', '0');
INSERT INTO `drp_sys_dept` VALUES ('2', '1', '公司领导', '10', '100001', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `drp_sys_dept` VALUES ('3', '1', '综合部', '20', '100002', null, null, null, null, null, '1', '2018-01-30 07:00:00', null, '0');
INSERT INTO `drp_sys_dept` VALUES ('4', '1', '市场部', '30', '100003', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `drp_sys_dept` VALUES ('5', '1', '技术部', '40', '100004', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `drp_sys_dept` VALUES ('6', '1', '研发部', '50', '100005', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `drp_sys_dept` VALUES ('7', '1', '烟台市分公司', '20', '200000', '', '', '', '', '', '1', '2018-01-30 08:00:00', '', '0');
INSERT INTO `drp_sys_dept` VALUES ('8', '7', '公司领导', '10', '200001', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `drp_sys_dept` VALUES ('9', '7', '综合部', '20', '200002', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `drp_sys_dept` VALUES ('10', '7', '市场部', '30', '200003', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `drp_sys_dept` VALUES ('11', '7', '技术部', '40', '200004', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `drp_sys_dept` VALUES ('12', '7', '牟平区分公司', '0', '201000', '', '', '', '', '', '1', '2018-01-30 08:00:00', '', '0');
INSERT INTO `drp_sys_dept` VALUES ('13', '12', '公司领导', '10', '201001', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `drp_sys_dept` VALUES ('14', '12', '综合部', '20', '201002', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `drp_sys_dept` VALUES ('15', '12', '市场部', '30', '201003', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `drp_sys_dept` VALUES ('16', '12', '技术部', '40', '201004', null, null, null, null, null, '1', '2018-01-30 08:00:00', null, '0');
INSERT INTO `drp_sys_dept` VALUES ('28', '6', '小卖铺2', '12121', 'd', 'd', 'df', 'df', 'df', 'df', '11', '2018-01-31 18:20:39', 'vcbcvbcv', '1');
INSERT INTO `drp_sys_dept` VALUES ('29', '12', '小卖铺1号', '12', 'd', 'd', 'df', 'df', 'df', 'df', '1', '2018-01-31 17:58:50', 'df', '1');
INSERT INTO `drp_sys_dept` VALUES ('30', '1', '123', '12', '', '', '', '', '', '', '11', '2018-01-31 23:53:06', '', '1');
INSERT INTO `drp_sys_dept` VALUES ('31', '30', 'sdfsdf', '34', '3', '2', '', '', '', '', '11', '2018-01-31 23:53:30', '', '1');
INSERT INTO `drp_sys_dept` VALUES ('32', '0', '浙江省总公司', '12', '', '', '', '', '', '', '11', '2018-02-01 14:06:28', '', '0');
INSERT INTO `drp_sys_dept` VALUES ('33', '32', '杭州小卖铺', '12', '', '', '', '', '', '', '1', '2018-02-01 15:09:44', '', '0');
INSERT INTO `drp_sys_dept` VALUES ('34', '33', '杂货摊一号', '12', '', '', '', '', '', '', '1', '2018-02-02 10:37:04', '', '1');

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
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_dict_value` (`value`),
  KEY `sys_dict_label` (`label`),
  KEY `sys_dict_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
-- Records of drp_sys_dict
-- ----------------------------
INSERT INTO `drp_sys_dict` VALUES ('1', '0', '正常', 'del_flag', '删除标记', '10', '0', '1', '2015-07-10 08:00:00', 'test', '0');
INSERT INTO `drp_sys_dict` VALUES ('2', '1', '删除', 'del_flag', '删除标记', '20', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('3', '1', '显示', 'show_hide', '显示/隐藏', '10', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('4', '0', '隐藏', 'show_hide', '显示/隐藏', '20', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('5', '1', '是', 'yes_no', '是/否', '10', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('6', '0', '否', 'yes_no', '是/否', '20', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('17', '1', '国家', 'sys_area_type', '区域类型', '10', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('18', '2', '省份、直辖市', 'sys_area_type', '区域类型', '20', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('19', '3', '地市', 'sys_area_type', '区域类型', '30', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('20', '4', '区县', 'sys_area_type', '区域类型', '40', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('21', '1', '公司', 'sys_office_type', '机构类型', '60', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('22', '2', '部门', 'sys_office_type', '机构类型', '70', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('23', '3', '小组', 'sys_office_type', '机构类型', '80', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('24', '4', '其它', 'sys_office_type', '机构类型', '90', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('28', '1', '一级', 'sys_office_grade', '机构等级', '10', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('29', '2', '二级', 'sys_office_grade', '机构等级', '20', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('30', '3', '三级', 'sys_office_grade', '机构等级', '30', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('31', '4', '四级', 'sys_office_grade', '机构等级', '40', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('32', '1', '所有数据', 'sys_data_scope', '数据范围', '10', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('33', '2', '所在公司及以下数据', 'sys_data_scope', '数据范围', '20', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('34', '3', '所在公司数据', 'sys_data_scope', '数据范围', '30', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('35', '4', '所在部门及以下数据', 'sys_data_scope', '数据范围', '40', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('36', '5', '所在部门数据', 'sys_data_scope', '数据范围', '50', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('37', '8', '仅本人数据', 'sys_data_scope', '数据范围', '90', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('38', '9', '按明细设置', 'sys_data_scope', '数据范围', '100', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('39', '1', '系统管理', 'sys_user_type', '用户类型', '10', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('40', '2', '部门经理', 'sys_user_type', '用户类型', '20', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('41', '3', '普通用户', 'sys_user_type', '用户类型', '30', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('67', '1', '操作日志', 'sys_log_type', '日志类型', '30', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('68', '2', '异常日志', 'sys_log_type', '日志类型', '40', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('96', '1', '男', 'sex', '性别', '10', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('97', '2', '女', 'sex', '性别', '20', '0', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_dict` VALUES ('98', '11', '22', '33', '44', '55', null, '1', '2017-04-19 15:32:11', '66', '1');
INSERT INTO `drp_sys_dict` VALUES ('99', '1212', '111', 'dfdfef', '描述1', '101', '0', '1', '2018-01-21 09:37:16', '备注221212', '1');
INSERT INTO `drp_sys_dict` VALUES ('100', '12', '12', '12', '12', '1212211221', '0', '1', '2018-01-21 09:21:26', '12', '1');
INSERT INTO `drp_sys_dict` VALUES ('101', 'new', 'wew', 'wew', 'ewew', '34343434', '0', '1', '2018-01-21 09:37:38', 'ewewe', '1');
INSERT INTO `drp_sys_dict` VALUES ('102', '121', '1212', '1212', '1212', '1212', '0', '1', '2018-01-22 09:26:28', '12121', '0');

-- ----------------------------
-- Table structure for `drp_sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `drp_sys_menu`;
CREATE TABLE `drp_sys_menu` (
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
  KEY `sys_menu_parent_id` (`parent_id`),
  KEY `sys_menu_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of drp_sys_menu
-- ----------------------------
INSERT INTO `drp_sys_menu` VALUES ('1', '0', '功能菜单', '0', '', '', '', '1', '', '1', '2016-11-28 21:17:24', '', '0');
INSERT INTO `drp_sys_menu` VALUES ('2', '1', '系统设置', '20', null, null, null, '1', null, '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('3', '2', '系统设置', '20', '', '', '', '1', '', '1', '2016-11-23 16:06:14', '', '0');
INSERT INTO `drp_sys_menu` VALUES ('4', '3', '菜单管理', '10', '/sysmgr/gotoMenuList', null, 'icon-list-alt', '1', null, '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('5', '4', '查看', '30', null, null, null, '0', 'sys:menu:view', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('6', '4', '修改', '40', null, null, null, '0', 'sys:menu:edit', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('7', '3', '角色管理', '20', '/sysmgr/gotoRoleList', '', 'icon-lock', '1', '', '1', '2016-11-29 17:09:58', '', '0');
INSERT INTO `drp_sys_menu` VALUES ('8', '7', '查看', '30', null, null, null, '0', 'sys:role:view', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('9', '7', '修改', '40', null, null, null, '0', 'sys:role:edit', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('10', '3', '字典管理', '30', '/sysmgr/gotoDictList', null, 'icon-th-list', '1', null, '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('11', '10', '查看', '30', null, null, null, '0', 'dict:query', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('12', '10', '修改', '40', null, null, null, '0', 'sys:dict:edit', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('13', '2', '机构用户', '10', null, null, null, '1', null, '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('14', '13', '区域管理', '30', '/sysmgr/gotoAreaList', '', 'icon-th', '1', '', '1', '2016-11-28 22:39:55', '', '0');
INSERT INTO `drp_sys_menu` VALUES ('15', '14', '查看', '30', null, null, null, '0', 'sys:area:view', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('16', '14', '修改', '40', null, null, null, '0', 'sys:area:edit', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('17', '13', '机构管理', '20', '/sysmgr/gotoDeptList', '', 'icon-th-large', '1', '', '1', '2016-11-28 22:40:19', '', '0');
INSERT INTO `drp_sys_menu` VALUES ('18', '17', '查看', '30', null, null, null, '0', 'sys:office:view', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('19', '17', '修改', '40', null, null, null, '0', 'sys:office:edit', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('20', '13', '用户管理', '10', '/sysmgr/gotoUserList', '', 'icon-user', '1', '', '1', '2016-12-01 17:17:01', '', '0');
INSERT INTO `drp_sys_menu` VALUES ('21', '20', '查看', '30', null, null, null, '0', 'sys:user:view', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('22', '20', '修改', '40', null, null, null, '0', 'sys:user:edit', '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('27', '1', '我的面板', '10', null, null, null, '1', null, '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('28', '27', '个人信息', '10', '/sysmgr/getUserInfoById', null, null, '1', null, '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('29', '28', '个人信息', '20', '/sysmgr/userInfo', null, 'icon-user', '1', null, '1', '2015-07-10 08:00:00', null, '0');
INSERT INTO `drp_sys_menu` VALUES ('30', '28', '修改密码', '30', '/sysmgr/changePwd', '', 'icon-lock', '1', '', '1', '2016-11-28 22:40:46', '', '0');
INSERT INTO `drp_sys_menu` VALUES ('33', '1', '修改后的菜单', '110', 'updated href', 'tttt', 'icon-bookmark', '0', 'qjl:mgr:test', '1', '2018-01-28 22:55:05', 'chrmk', '1');
INSERT INTO `drp_sys_menu` VALUES ('34', '7', 'qw', '30', 'qw', 'qw', 'icon-comment', '0', 'qw', '11', '2018-01-28 22:51:41', 'qw', '1');
INSERT INTO `drp_sys_menu` VALUES ('35', '1', '测试菜单21212', '13', 'eee', 'eee', 'icon-cog', '0', 'eee', '1', '2018-01-28 22:55:14', 'test hello', '1');
INSERT INTO `drp_sys_menu` VALUES ('36', '1', '测试修改了del_flag之后', '11', 'df', 'df', 'icon-calendar', '0', 'df', '1', '2018-01-28 22:56:17', 'df', '1');
INSERT INTO `drp_sys_menu` VALUES ('37', '1', 'dfdf', '12', 'dfd', 'dfdf', 'icon-calendar', '0', 'sdf', '1', '2018-01-29 11:21:18', 'sdf', '1');
INSERT INTO `drp_sys_menu` VALUES ('38', '37', '下下df', '12', 'df', 'df', 'icon-exclamation-sign', '', 'kjl', '1', '2018-01-29 11:22:00', 'kljkj', '1');
INSERT INTO `drp_sys_menu` VALUES ('39', '37', 'nmnnm', '22', 'bnmmnb', 'bnm', 'icon-ban-circle', '', 'sys:qwe', '1', '2018-01-29 11:28:28', 'qweqw', '1');
INSERT INTO `drp_sys_menu` VALUES ('40', '28', 'ddfdsf', '12', 'sfd', 'sdf', 'icon-bookmark', '0', '12', '11', '2018-01-29 16:40:05', '12', '1');
INSERT INTO `drp_sys_menu` VALUES ('41', '27', '1212', '121', '121', '12', 'icon-asterisk', '0', 'df', '1', '2018-01-29 22:30:56', 'sdf', '1');
INSERT INTO `drp_sys_menu` VALUES ('42', '41', '覆盖', '22', 'df', 'df', 'icon-book', '0', 'd', '1', '2018-01-29 20:24:47', 'df', '1');
INSERT INTO `drp_sys_menu` VALUES ('43', '27', 'test', '12', 'dfsd', 'sdf', 'icon-exclamation-sign', '0', 'sdf', '11', '2018-02-01 13:18:34', 'sdf', '1');
INSERT INTO `drp_sys_menu` VALUES ('44', '1', 'dir', '12', 'df', 'df', 'icon-camera', '', '1', '1', '2018-01-30 13:47:25', '1', '1');
INSERT INTO `drp_sys_menu` VALUES ('45', '43', 'dsf', '23', 'dfs', 'fs', 'icon-certificate', '0', '12', '1', '2018-01-30 16:32:09', '1', '1');
INSERT INTO `drp_sys_menu` VALUES ('46', '43', 'gf', '12', 'fdg', 'dfg', 'icon-ban-circle', '', 're', '11', '2018-01-30 15:44:32', 'd', '1');
INSERT INTO `drp_sys_menu` VALUES ('47', '0', 'sfd', '12', 'sdf', 'dsf', 'icon-bookmark', '', '', '11', '2018-02-01 14:03:54', '', '1');
INSERT INTO `drp_sys_menu` VALUES ('48', '47', 'qwqwqw', '34', 'qwqw', 'ss', 'icon-ban-circle', '0', '', '11', '2018-02-01 14:04:31', '', '1');
INSERT INTO `drp_sys_menu` VALUES ('49', '48', '121', '12', 'sd', 'sd', 'icon-bullhorn', '', '12', '1', '2018-02-02 11:39:08', '121', '1');
INSERT INTO `drp_sys_menu` VALUES ('50', '1', 'hello', '12', '1212', '121', 'icon-asterisk', '', 'dd', '11', '2018-02-03 16:34:03', 'd', '0');

-- ----------------------------
-- Table structure for `drp_sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `drp_sys_role`;
CREATE TABLE `drp_sys_role` (
  `id` int(32) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `update_by` varchar(64) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_role_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of drp_sys_role
-- ----------------------------
INSERT INTO `drp_sys_role` VALUES ('1', '超级系统管理员', '1', '2016-12-05 22:09:56', '', '0');
INSERT INTO `drp_sys_role` VALUES ('23', '总公司管理员', '1', '2016-12-05 22:10:32', '', '0');
INSERT INTO `drp_sys_role` VALUES ('24', '沧州分公司管理员', '9', '2016-12-05 22:14:52', '', '0');

-- ----------------------------
-- Table structure for `drp_sys_role_area`
-- ----------------------------
DROP TABLE IF EXISTS `drp_sys_role_area`;
CREATE TABLE `drp_sys_role_area` (
  `role_id` int(32) NOT NULL COMMENT '角色编号',
  `area_id` int(32) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`role_id`,`area_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单';

-- ----------------------------
-- Records of drp_sys_role_area
-- ----------------------------
INSERT INTO `drp_sys_role_area` VALUES ('1', '1');
INSERT INTO `drp_sys_role_area` VALUES ('1', '9');
INSERT INTO `drp_sys_role_area` VALUES ('1', '10');
INSERT INTO `drp_sys_role_area` VALUES ('1', '11');
INSERT INTO `drp_sys_role_area` VALUES ('1', '12');
INSERT INTO `drp_sys_role_area` VALUES ('1', '13');
INSERT INTO `drp_sys_role_area` VALUES ('1', '14');
INSERT INTO `drp_sys_role_area` VALUES ('23', '1');
INSERT INTO `drp_sys_role_area` VALUES ('23', '9');
INSERT INTO `drp_sys_role_area` VALUES ('23', '11');
INSERT INTO `drp_sys_role_area` VALUES ('23', '12');
INSERT INTO `drp_sys_role_area` VALUES ('24', '1');
INSERT INTO `drp_sys_role_area` VALUES ('24', '10');
INSERT INTO `drp_sys_role_area` VALUES ('24', '13');
INSERT INTO `drp_sys_role_area` VALUES ('24', '14');

-- ----------------------------
-- Table structure for `drp_sys_role_dept`
-- ----------------------------
DROP TABLE IF EXISTS `drp_sys_role_dept`;
CREATE TABLE `drp_sys_role_dept` (
  `role_id` int(32) NOT NULL COMMENT '角色编号',
  `dept_id` int(32) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`role_id`,`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单';

-- ----------------------------
-- Records of drp_sys_role_dept
-- ----------------------------
INSERT INTO `drp_sys_role_dept` VALUES ('1', '1');
INSERT INTO `drp_sys_role_dept` VALUES ('1', '22');
INSERT INTO `drp_sys_role_dept` VALUES ('1', '23');
INSERT INTO `drp_sys_role_dept` VALUES ('1', '24');
INSERT INTO `drp_sys_role_dept` VALUES ('1', '25');
INSERT INTO `drp_sys_role_dept` VALUES ('1', '26');
INSERT INTO `drp_sys_role_dept` VALUES ('1', '27');
INSERT INTO `drp_sys_role_dept` VALUES ('23', '1');
INSERT INTO `drp_sys_role_dept` VALUES ('23', '22');
INSERT INTO `drp_sys_role_dept` VALUES ('23', '23');
INSERT INTO `drp_sys_role_dept` VALUES ('23', '24');
INSERT INTO `drp_sys_role_dept` VALUES ('23', '25');
INSERT INTO `drp_sys_role_dept` VALUES ('24', '1');
INSERT INTO `drp_sys_role_dept` VALUES ('24', '26');
INSERT INTO `drp_sys_role_dept` VALUES ('24', '27');

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
INSERT INTO `drp_sys_role_menu` VALUES ('23', '1');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '2');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '3');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '4');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '5');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '6');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '7');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '8');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '9');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '10');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '11');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '12');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '13');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '14');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '15');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '16');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '17');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '18');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '19');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '20');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '21');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '22');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '27');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '28');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '29');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '30');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '67');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '68');
INSERT INTO `drp_sys_role_menu` VALUES ('23', '84');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '1');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '2');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '3');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '4');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '5');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '6');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '7');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '8');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '9');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '10');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '11');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '12');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '13');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '14');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '15');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '16');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '17');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '18');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '19');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '20');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '21');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '22');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '27');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '28');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '29');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '30');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '67');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '68');
INSERT INTO `drp_sys_role_menu` VALUES ('24', '84');

-- ----------------------------
-- Table structure for `drp_sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `drp_sys_user`;
CREATE TABLE `drp_sys_user` (
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
  KEY `sys_user_office_id` (`dept_id`),
  KEY `sys_user_login_name` (`login_name`),
  KEY `sys_user_update_date` (`update_date`),
  KEY `sys_user_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of drp_sys_user
-- ----------------------------
INSERT INTO `drp_sys_user` VALUES ('1', '1', 'admin', '2836451e5a7c6fae6996b79c5665dfabf3429a4e16eb3eb25ef4f1db', '001', '曲健磊', 'lyu_qujianlei@163.com', '13567890987', '15434567890', '1', '2016-12-02 15:58:08', '备注dxvxcv', '0');
INSERT INTO `drp_sys_user` VALUES ('9', '7', 'xiaoyanggao', '1f1673d5440280ae288fd594d73894d34f6dfa99a9ad55f398e87ce9', '002', 'xiaoyanggao', '', '', '', '1', '2016-12-05 22:11:49', '', '0');
INSERT INTO `drp_sys_user` VALUES ('10', '12', 'shubiao', '0d25aba2782d514bf4a4934ab29c2095da7db9ae03ff6ca07c64c7f6', '003', 'shubiao', '', '', '', '1', '2016-12-05 22:12:17', '', '0');
INSERT INTO `drp_sys_user` VALUES ('11', '12', 'arry', 'b37fd06fe1ba32525a273af95993bf6f466a5d283f06ff5775339f22', 'arry', 'arry', 'df@dfdsf.com', '23', '323', '1', '2016-12-05 22:33:06', 'df', '0');

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
INSERT INTO `drp_sys_user_role` VALUES ('9', '23');
INSERT INTO `drp_sys_user_role` VALUES ('10', '24');
INSERT INTO `drp_sys_user_role` VALUES ('11', '1');
