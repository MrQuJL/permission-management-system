# 权限管理系统（Permission-Management-System）

## 项目背景
> 一个系统它主要分为两大模块：业务功能模块+系统功能模块。权限管理系统其实并不是一套完整的系统，准确的说权限管理只是一个系统功能模块，这个系统能够实现什么功能还是需要业务模块的支持。但是这个权限管理却是每一个系统必不可少的一部分，所以，我决定通过自己所学的知识来完成这个权限管理功能模块。

## 项目目标
* 用户管理：用户能够通过创建的用户访问系统，操作系统的一些基本功能
* 角色管理：角色是权限的集合，在该系统中拥有角色就拥有了菜单，部门，区域这些资源的操作权限
* 菜单管理：管理用户在页面上看到的菜单选项和一些按钮
* 区域管理：也是一种资源权限，某角色拥有某个区域，它就可以使用这个区域范围内的一些功能
* 部门管理：每一个用户都有一个所属的部门
* 字典管理：存储一些系统中常用的字典值，例如：性别，区域类型...
* 日志管理：记录系统中的一些敏感性操作，在系统出现故障或非法入侵的时候提供帮助

## 项目的约定
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


## 项目表结构设计
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

## 项目所采用的框架
项目的后台架构：spring+struts2+mybatis



## 项目中遇到的一些问题

## 项目的收获






项目功能的完成顺序：
	菜单的维护
	部门的维护
	区域的维护
	角色的维护
	用户的维护
	字典的维护
	日志的维护



