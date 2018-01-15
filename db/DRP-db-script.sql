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



