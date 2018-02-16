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

## 项目所采用的技术

### 开发环境

* 操作系统：Windows8.1（计划迁移到linux服务器，敬请期待...）
* IDE：eclipse
* Java版本：1.8
* 数据库：mysql5.6.36
* 服务器：tomcat8

### 后台框架：

* spring-4.2.1	轻量级的IOC和AOP的容器框架
* struts-2.3.16	表示层框架，负责匹配请求，处理请求，返回视图
* mybatis-3.3.1	建立与数据库的会话
* druid-1.1.16	为监控而生的数据库连接池
* shiro-1.2.1	优秀的权限管理框架
* ehcache-2.5.0	缓存框架

### 前台框架

* jquery-1.8.3	最基础的前台框架
* bootstrap-2.3.1	用于网站整体的布局
* select2-3.4	可查询的下拉列表
* jquery-validate-1.11.0	强大的表单校验工具
* jquery-zTree-3.5.12	流行的树形控件
* treeTable	树形表格
* My97DatePicker	优雅的时间选择控件

## 数据库ER图
![image](https://github.com/MrQuJL/permission-management-system/raw/master/pms-imgs/er.png)

## 数据库表设计
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

## 项目的约定
* 项目的后台包结构：
	com.company.projectName.common 通用的类
	com.company.projectName.interceptor 自定义拦截器
	com.company.projectName.security shiro相关安全管理
	com.company.projectName.moduleName.action 业务控制类
	com.company.projectName.moduleName.dto 业务bean
	com.company.projectName.moduleName.entity 实体类
	com.company.projectName.moduleName.mapper mapper映射
	com.company.projectName.moduleName.service 服务类
	com.company.projectName.test 测试类
	com.company.projectName.util 工具类

* 项目的前台页面结构:
	webapp/index.jsp 引导页面，通过后台跳转到登陆页面
	webapp/jsAndCss/js 一些js文件
	webapp/jsAndCss/css 一些css文件
	webapp/jsAndCss/img 一些图片文件
	webapp/WEB-INF/pages 放页面

## 项目中遇到的一些问题

* 现象：引用了jstl标签库的uri但是报如下错误：Can not find the tag library descriptor for "http://java.sun.com/jsp/jstl/core"
	原因：maven中没有添加jstl相关依赖
	解决：在maven中添加jstl依赖jar包
	、、、
	<dependency>
		<groupId>jstl</groupId>
		<artifactId>jstl</artifactId>
		<version>1.2</version>
	</dependency>
	、、、
	扩展：jstl 1.2 的uri写法：http://java.sun.com/jsp/jstl/core
	      jstl 1.2 的uri写法：http://java.sun.com/jstl/core




## 项目的收获



