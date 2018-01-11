create database drp;
use drp;

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

create table product(
	product_id varchar(8) primary key,
	product_name varchar(30) not null,
	quantity decimal(18,2) not null,
	avg_buy_price decimal(18,2) not null
)

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

create table purchase_master(
	purchase_id varchar(8) primary key,
	purchase_date datetime,
	supplier_id varchar(8),
	subtotal decimal(18,2)
)

create table purchase_detail(
	purchase_id varchar(8) not null,
	product_id varchar(8) not null,
	purchase_quantity decimal(18,0) not null,
	purchase_unit_price decimal(18,2) not null,
	purchase_amount decimal(18,2) not null,
	constraint pk_purchase_product primary key(purchase_id, product_id)
)

create table delivery_master(
	delivery_id varchar(8) primary key,
	delivery_date datetime not null,
	customer_id varchar(8) not null,
	delivery_address varchar(100) not null,
	subtotal decimal(18,2) not null
)

create table delivery_detail(
	delivery_id varchar(8) not null,
	product_id varchar(8) not null,
	sales_quantity decimal(18,0) not null,
	sales_unit_price decimal(18,2) not null,
	sales_amount decimal(18,2) not null,
	constraint pk_deliver_product primary key(delivery_id, product_id)
)
