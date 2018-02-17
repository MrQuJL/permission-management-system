# 权限管理系统（Permission-Management-System）

## 项目背景
> 一个系统它主要分为两大模块：业务功能模块+系统功能模块。权限管理系统其实并不是一套完整的系统，准确的说权限管理只是一个系统功能模块，一个系统能够实现什么功能还是需要业务模块的支持。但是这个权限管理却是每一个系统必不可少的一部分，所以，我决定通过自己所学的知识来完成这个权限管理功能模块。

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
* 项目的构建工具：Maven

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

## 项目的约定
* 项目的后台包结构：
	> com.company.projectName.common 通用的类<br/>
	com.company.projectName.interceptor 自定义拦截器<br/>
	com.company.projectName.security shiro相关安全管理<br/>
	com.company.projectName.moduleName.action 业务控制类<br/>
	com.company.projectName.moduleName.dto 业务bean<br/>
	com.company.projectName.moduleName.entity 实体类<br/>
	com.company.projectName.moduleName.mapper mapper映射<br/>
	com.company.projectName.moduleName.service 服务类<br/>
	com.company.projectName.test 测试类<br/>
	com.company.projectName.util 工具类<br/>

* 项目的前台页面结构:
	> webapp/index.jsp 引导页面，通过后台跳转到登陆页面<br/>
	webapp/jsAndCss/js 一些js文件<br/>
	webapp/jsAndCss/css 一些css文件<br/>
	webapp/jsAndCss/img 一些图片文件<br/>
	webapp/WEB-INF/pages 放页面<br/>

* 项目的配置文件命名：
	> applicationContext.xml spring的主配置文件<br/>
	applicationContext-shiro.xml 放置shiro的过滤器以及SecurityManager环境<br/>
	ehcache.xml ehcache的配置文件<br/>
	ehcache.xsd ehcache标签的定义<br/>
	jdbc.properties 与数据库相关的配置文件，例如：用户名，密码...<br/>
	log4j.properties 日志相关的输出配置<br/>
	mybatis-cfg.xml mybatis的主配置文件<br/>
	struts-sysmgr.xml 与系统管理相关的struts2的配置文件<br/>
	struts.properties 与struts2相关的系统常量的配置<br/>
	struts.xml struts2的主配置文件<br/>
	shiro-permission.ini 测试shiro的权限管理时的配置文件<br/>
	shiro-realm.ini 测试shiro的realm<br/>
	shiro.ini 模拟测试shiro的数据源<br/>

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

## 项目中遇到的一些问题

1. 引用了jstl标签库的uri但是报如下错误：Can not find the tag library descriptor for "http://java.sun.com/jsp/jstl/core"
	> 原因：maven中没有添加jstl相关依赖

	> 解决：在maven中添加jstl依赖jar包

	> 扩展：jstl 1.2 的uri写法：http://java.sun.com/jsp/jstl/core
	      jstl 1.1 的uri写法：http://java.sun.com/jstl/core

2. jsp页面出现如下错误：The superclass "javax.servlet.http.HttpServlet" was not found on the Java Build Path
	> 原因：maven没有添加jsp-api相关的依赖

	> 解决：在maven中添加jsp-api的依赖

3. 查询某功能列表时，一直处于查询状态（后台一直没反应）
	> 原因：mapper.xml中的查询语句出错
	
	> 解决：修改查询语句
	
	> 教训：mapper.xml中写的SQL一定要现在navicat上测试一下，确保正确再写入mapper

4. 前台传入空的字段，mapper中使用了动态SQL标签判断非空才执行相应语句，但是仍然执行了语句
	> 原因：判断条件使用了数据库中字段

	> 解决：修改判断字段为 java bean 的字段

5. 用户访问系统资源进行身份认证的时候，用户名和密码输入成功即将进入主页面，但是，浏览器却显示出了无权访问的页面
	> 原因：因为我把跳转到主页面设定为了一个新的请求，所以该请求又经过了身份验证和权限检验这两个拦截器，该请求成功通过了身份认证拦截器，但是在进行权限验证的时候由于在菜单表中并没有配置进入主页面的请求对应的权限，导致即使登录成功也无法进入主页面
	
	> 解决：在权限验证拦截器中修改业务逻辑，对含有主页面的请求放行
	
	> 教训：在设置资源的访问权限的时候要具体问题具体分析，结合项目的请求的执行流程来处理业务逻辑

6. shiro-spring-1.3.2版本没办法与shiro-core-1.2.3版本集成，shiro-ehcache-1.2.2没办法与shiro-core-1.2.2版本集成
	> 原因：shiro-core版本过高，其他依赖的jar包无法很好的兼容

	> 解决：更换成shiro-core-1.2.1之后，完美解决

	> 教训：在使用一些框架或者组件的时候尽量不要使用最新的版本，建议使用最稳定的版本。一句俗话说的好：最好的，不一定最合适，最合适的，才是真正最好的

7. 使用shiro做的权限控制，在输入完用户名和密码时进行登录，但是任然被拦在了登录页面
	> 原因：shiro的过滤链配置错误

	> 解决：main.action为登录成功的请求，已经在successUrl里面配置了main.action就不要在过滤链里面再配，正确配置如下：
	```xml
	<bean id="shiroFilter" class="org.apache.shiro.spring.web.ShiroFilterFactoryBean">
		<property name="securityManager" ref="securityManager"></property>
		<!-- loginUrl为登录页面，并不是登录请求 -->
		<property name="loginUrl" value="/toLogin.action"></property>
		<!-- successUrl为登录成功后的页面 -->
		<property name="successUrl" value="/main.action"></property>
		<property name="filterChainDefinitions">
			<value>
				<!-- 静态资源可以匿名访问 -->
				/jsAndCss/** = anon
				<!-- 登录的请求为匿名（这个都拦截那这系统就没法进了） -->
				/login.action = anon
				<!-- 所有的请求都需要认证，放在最后 -->
				/** = authc
			</value>
		</property>
	</bean>
	```

8. 在访问未经过shiro授权的资源的时候，没有出现预先写好的拒绝访问页面
	> 原因：用ajax异步提交的该请求，shiro没有对ajax请求有很好的集成

	> 解决：用jquery的ajax的error函数来显示相应的错误信息

	> 扩展：将请求修改为表单的submit同步进行提交，成功显示出了预先写好的拒绝访问页面

9. 访问未授权的资源将不会跳转到unauthorizedUrl所指定的拒绝访问页面，而是在浏览器显示一堆异常
	> 原因：没有配置shiro的perms过滤器
	
	> 解决：在shiro的filterChainDefinitions属性中增加如下配置：/sysmgr/getDictListPage.action = perms[dict:query]

10. 在junit中测试菜单的修改功能时出现异常，但是在服务器上运行却没有问题
	> 原因：在获取updateBy（修改人id）时是在shiro的SecurityManager环境中获取的，但是junit的单机测试环境并没有使用SecurityManager，所以获取不到相应的字段，导致后台报错

	> 解决：手动设置updateBy字段的值

	> 教训：在测试某些功能的时候，可能需要依赖服务器开启时所提供的环境，单机测试的时候要注意手动设置一些属性。

11. 在查询返回的dto对象中没有获取到某个属性
	> 原因：在mapper.xml的SQL中没有为相应的字段添加别名导致mybatis无法完成该属性的映射

	> 解决：在查询语句中为该字段添加别名

12. 前台无法使用$.each()对后台传过来的json字符串进行解析
	> 原因：如题，后台传过来的是一个json字符串，对于字符串要先通过JSON.parse(str)解析成js对象，然后才能通过$.each()进行遍历
	
	> 解决：在通过$.each()遍历的之前先通过JSON.parse("json字符串")解析一下，然后在遍历该js对象

	> 扩展：关于json类型字符串的转化问题，可以参考我的这篇博文-[JSON.parse()和JSON.stringify()](http://blog.csdn.net/a909301740/article/details/78809251)

13. 在进入菜单编辑页面时，没有加载菜单树zTree
	> 原因：加载菜单树的请求需要依赖页面加载过来的菜单id，但是由于是异步的请求，并没有等待页面加载完毕就向服务器发出了请求，因此菜单id始终没有获取到，导致菜单树一直加载不出来

	> 解决：设置ajax的请求为同步 async:false

14. 添加部门的时候无法添加成功
	> 原因：由于没有选择父级部门，导致后台的parentId属性为null，而对应的数据库中的parent_id字段不能为空，所以数据添加失败

	> 解决：不选择父级部门，则将parentId的属性值设为0，表示该部门为顶级部门

15. 查询指定id的所有子孙区域的时候报并发修改异常 ConcurrentModificationException
	> 原因：使用forEach遍历的过程中仍不断的向list集合中添加数据，造成了并发修改异常

	> 解决：记录一开始查询出的直接子区域的size，使用普通for循环递归遍历查找孙子区域

16. 在一个集合中剔除存在于另一个集合中的元素时contains判断无效
	> 原因：contains方法默认是调用对象的equals方法来判断对象是否存在于容器中，如果不重写equals的话默认使用Object的equals方法来判断，而Object的equals方法实现如下：
	```java
	public boolean equals(Object obj) {
		return (this == obj);
	}
	```

	> 解决：重写对象的hashCode和equals方法即可

17. 用eclipse打开项目时，项目的图标上出现红色错误标示的几种原因（欢迎补充）
	> 原因：Eclipse的编译版本和项目的jdk版本不匹配
	
	> 解决：修改项目和windows的properties的Java Compiler 即编译的jre环境

	> 原因：项目属性的Project Facets设置的java版本有误，应该为jdk1.8

	> 解决：修改为项目所使用的JDK1.8

	> 扩展：Window -> Show View -> Markers 视图可以查看项目中的错误或者警告的详细提示信息

18. tomcat一启动项目就报错，几种可能的原因（欢迎补充）
	> 原因：org.apache.ibatis.builder.BuilderException: Error parsing Mapper XML - 使用mybatis时mapper.xml配置文件中定义了两个同名的sql片段
	
	> 解决：修改其中的一个sql片段的name

## 项目的收获




项目持续更新中...<br/>
更多精彩内容，敬请关注[曲健磊的博客](http://blog.csdn.net/a909301740 "曲健磊的博客")
