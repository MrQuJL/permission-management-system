pms权限管理系统:
功能模块：
	* 用户管理
	* 角色管理
	* 菜单管理
	* 区域管理
	* 部门管理（机构管理和区域管理有时候可以放在一起）
	* 字典管理
	* 日志管理

项目表结构：
	* 用户表
	* 用户-角色对应关系表
	* 角色表
	* 角色-部门对应关系表
	* 部门表
	* 角色-区域对应关系表
	* 区域表
	* 角色-菜单对应关系表
	* 菜单表
	* 字典表
	* 日志表

项目的后台架构：spring+struts2+mybatis

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

项目功能的完成顺序：
	菜单的维护
	部门的维护
	区域的维护
	角色的维护
	用户的维护
	字典的维护
	日志的维护
