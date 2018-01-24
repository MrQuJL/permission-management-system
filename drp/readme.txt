drp分销系统:
功能模块：
1)系统功能
	* 用户管理
	* 角色管理
	* 菜单管理
	* 区域管理
	* 部门管理（机构管理和区域管理有时候可以放在一起）
	* 字典管理
	* 日志管理
2)业务功能
	* 客户管理
	* 商品管理
	* 供应商管理
	* 采购单管理
	* 采购单明细管理
	* 销售单管理
	* 销售单明细管理

项目表结构：
1)系统功能部分
	* 用户表
	* 角色表
	* 部门表
	* 区域表
	* 菜单表
	* 字典表
	* 日志表
2)业务功能部分
	* 客户表
	* 商品表
	* 供应商表
	* 采购单主表
	* 采购单明细表
	* 销售单主表
	* 销售单明细表

项目的后台架构：spring+struts2+mybatis

项目的前台页面：待完善...

项目的后台包结构：
	com.company.projectName.util
	com.company.projectName.common
	com.company.projectName.test
	com.company.projectName.moduleName.entity
	com.company.projectName.moduleName.mapper
	com.company.projectName.moduleName.service
	com.company.projectName.moduleName.action
项目的前台页面结构:
	webapp/index.jsp 引导页面，通过后台跳转到登陆页面
	webapp/jsAndCss/js 一些js文件
	webapp/jsAndCss/css 一些css文件
	webapp/jsAndCss/img 一些图片文件
	webapp/WEB-INF/pages 放页面
	
