﻿# 权限管理系统（Permission-Management-System）

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
	> com.company.projectName.common &nbsp;&nbsp;通用的类<br/>
	com.company.projectName.interceptor &nbsp;&nbsp;自定义拦截器<br/>
	com.company.projectName.security &nbsp;&nbsp;shiro相关安全管理<br/>
	com.company.projectName.moduleName.action &nbsp;&nbsp;业务控制类<br/>
	com.company.projectName.moduleName.dto &nbsp;&nbsp;业务bean<br/>
	com.company.projectName.moduleName.entity &nbsp;&nbsp;实体类<br/>
	com.company.projectName.moduleName.mapper &nbsp;&nbsp;mapper映射<br/>
	com.company.projectName.moduleName.service &nbsp;&nbsp;服务类<br/>
	com.company.projectName.test &nbsp;&nbsp;测试类<br/>
	com.company.projectName.util &nbsp;&nbsp;工具类<br/>

* 项目的前台页面结构:
	> webapp/index.jsp &nbsp;&nbsp;引导页面，通过后台跳转到登陆页面<br/>
	webapp/jsAndCss/js &nbsp;&nbsp;一些js文件<br/>
	webapp/jsAndCss/css &nbsp;&nbsp;一些css文件<br/>
	webapp/jsAndCss/img &nbsp;&nbsp;一些图片文件<br/>
	webapp/WEB-INF/pages &nbsp;&nbsp;放页面<br/>

* 项目的配置文件命名：
	> applicationContext.xml &nbsp;&nbsp;spring的主配置文件<br/>
	applicationContext-shiro.xml &nbsp;&nbsp;放置shiro的过滤器以及SecurityManager环境<br/>
	ehcache.xml &nbsp;&nbsp;ehcache的配置文件<br/>
	ehcache.xsd &nbsp;&nbsp;ehcache标签的定义<br/>
	jdbc.properties &nbsp;&nbsp;与数据库相关的配置文件，例如：用户名，密码...<br/>
	log4j.properties &nbsp;&nbsp;日志相关的输出配置<br/>
	mybatis-cfg.xml &nbsp;&nbsp;mybatis的主配置文件<br/>
	struts-sysmgr.xml &nbsp;&nbsp;与系统管理相关的struts2的配置文件<br/>
	struts.properties &nbsp;&nbsp;与struts2相关的系统常量的配置<br/>
	struts.xml &nbsp;&nbsp;struts2的主配置文件<br/>
	shiro-permission.ini &nbsp;&nbsp;测试shiro的权限管理时的配置文件<br/>
	shiro-realm.ini &nbsp;&nbsp;测试shiro的realm<br/>
	shiro.ini &nbsp;&nbsp;模拟测试shiro的数据源<br/>

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

17. 用eclipse打开项目时，项目的图标上出现红色错误标示的几种原因（**欢迎补充**）
	> 原因：Eclipse的编译版本和项目的jdk版本不匹配
	
	> 解决：修改项目和windows的properties的Java Compiler 即编译的jre环境

	> 原因：项目属性的Project Facets设置的java版本有误，应该为jdk1.8

	> 解决：修改为项目所使用的JDK1.8

	> 扩展：Window -> Show View -> Markers 视图可以查看项目中的错误或者警告的详细提示信息

18. tomcat一启动项目就报错，几种可能的原因（**欢迎补充**）
	> 原因：org.apache.ibatis.builder.BuilderException: Error parsing Mapper XML - 使用mybatis时mapper.xml配置文件中定义了两个同名的sql片段
	
	> 解决：修改其中的一个sql片段的name

19. 为某个用户增加了一些角色，发现界面上的菜单出现了重复的现象
	> 原因：每个角色所拥有的菜单列表可能有重叠的情况，在根据用户查询他所拥有的角色，在根据查询到的角色去查询相应的菜单列表时就出现了重复

	> 解决：查询完用户拥有的菜单列表的时，进行去重

	> 扩展：list集合去重的一种方法：
	```java
	// 获取某个用户的所有角色的菜单列表
	List<Menu> list = this.menuService.getMenuListByUserId(UserUtils.getCurrentUserId());
	// 通过HashSet可以去除多个角色中重复的菜单，使用Linked是为了保证有序
	this.menuList = new ArrayList<Menu>(new LinkedHashSet<Menu>(list));
	```

## 项目的收获

1. 因为WEB-INF文件夹下的页面无法通过url地址栏直接访问，所以可以将所有的页面放到WEB-INF文件夹下保护起来，通过后台的跳转来返回页面

2. 登录成功后一定要重定向到主页面，不能转发，转发的话一按F5刷新就会提示重新登录（用户体验不好）
	```xml
	<!-- 登录 -->
	<action name="login" class="com.lyu.pms.sysmanage.action.LoginAction" method="login">
		<result name="main" type="redirect">/main.action</result>
		<result name="loginPage" type="dispatcher">/WEB-INF/pages/login.jsp</result>
	</action>

	<!-- 重定向到主页面的请求 -->
	<action name="main" class="com.lyu.pms.sysmanage.action.LoginAction" method="main">
		<result name="mainPage" type="dispatcher">/WEB-INF/pages/main/main.jsp</result>
	</action>
	```

3. 在用户登录错误时虽然我们可以精确的定位出是用户名错误还是密码错误，但是我们一般不直接告诉用户是用户名错误还是密码错误，目的是为了防止恶意软件暴力破解。

4. webapp目录下面只留一个index.jsp页面来重定向到后台的toLogin请求，做为引导页面，index.jsp的内容如下：
	```jsp
	<% response.sendRedirect(request.getContextPath() + "/toLogin.action"); %>
	```

5. 将登陆的action配置与系统模块分离开来，用两个文件struts.xml, struts-sysmgr.xml来分别维护登录模块和系统功能模块

6. 页面引入的js文件过多，为了简化页面，把这些script标签再放到一个jsp页面里面，引入这个jsp页面，在本项目中是这样引入的：
	```jsp
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
	<%@ taglib prefix="sys" tagdir="/WEB-INF/tags" %>

	<c:set var="ctx" value="${pageContext.request.contextPath}" />
	<c:set var="ctxJsAndcss" value="${ctx}/jsAndCss" />

	<script src="${ctxJsAndcss}/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>
	<link href="${ctxJsAndcss}/bootstrap/2.3.1/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
	<script src="${ctxJsAndcss}/bootstrap/2.3.1/js/bootstrap.min.js" type="text/javascript"></script>
	...
	<link href="${ctxJsAndcss}/common/common.css" type="text/css" rel="stylesheet" />
	<script src="${ctxJsAndcss}/common/common.js" type="text/javascript"></script>
	```

7. 在使用jsp的include标签引入文件时一定要使用绝对路径，否则，在页面来回切换的时候会由于相对路径的问题找不到js和css文件，正例：
	```jsp
	<%-- 在web应用中webapp就是根目录 "/" --%>
	<%@ include file="/WEB-INF/pages/include/head.jsp" %>
	```

8. 在个人信息和修改密码这样同一个页面的两个选项卡之间进行切换的时候，切换到一个选项卡的时候，将当前这个选项卡的点击事件remove掉，防止用户频繁点击，造成不必要的系统开销

9. 几种常见的加密算法：
	* 可逆加密算法：
		* 对称加密：发送方和接收方使用相同把密钥来加密和解密，密钥需要在网络上传输，不安全，但是速度快。主要有 **AES, DES, 3DES**...
		* 非对称加密：使用一对密钥：公钥和私钥。当一方使用公钥加密的时候，另一方只能使用私钥才能解密，反之亦然。公钥可以在网络上传播，而私钥只掌握在其中一方，即私钥保密，公钥公开。主要有：**RSA, DSA, ECC**...
		* 编码方式：BASE64：将3个字节转换为4个字符。HEX：将1个字节转换为2个字符。
	* 不可逆加密算法：
		* 线性散列算法：MD5, SHA1, HMAC

	> 更多关于对称非对称加密算法的解释可以参考-[几种常见加密算法解析及使用](http://blog.csdn.net/qq_26420489/article/details/53395472 "几种常见加密算法解析及使用")

10. 项目中密码加密的流程：
	> 1. 生成一个随机数
	> 2. 用可逆的加密算法Hex加密随机数
	> 3. 将随机数和密码用sha1不可逆算法加密
	> 4. 将第三步得到的字符串值用可逆的加密算法加密
	> 5. 将第2步和第四步的值拼凑

11. 在UserRealm中验证用户登录的流程：
	> 1. 先判断用户名是否存在
	> 2. 如果用户名存在，取出存在数据库中加密的密码，跟传入后台的密码（加密后）进行比对
	> 3. 比对成功，则用户认证通过

12. 修改密码的流程：
	> 1. 用户输入旧密码和两次新密码
	> 2. 前台判断新旧密码长度是否符合要求
	> 3. 判断两次输入的新密码是否相同
	> 4. 后台查询输入的旧密码是否是当前用户的密码
	> 5. 如果旧密码正确，则任然要检测新密码是否符合要求
	> 6. 新密码符合要求则将密码加密后修改数据库中对应的记录
	> 7. 返回给前台提示信息

13. 前台无论提交的是同步的请求还是异步的ajax请求，都要写全路径名，例：
	```java
	${ctx}/sysmgr/getDictListPage.action
	```
	ctx为之前定义的request域的上下文：
	```jsp
	<c:set var="ctx" value="${pageContext.request.contextPath}" />
	```

14. 前台用ajax提交，后台通过json返回的时候要设置result的type设为json

15. 为了减少后台传送无用的数据到前台，在返回json数据的result标签里面使用<param name="includeProperties">message</param>来指定发往前台的数据，用逗号分隔

16. 系统分为社交系统和应用系统
	* 社交系统是自己可以注册账号使用的
	* 应用系统必须是管理员创建账号，不能自己注册（本系统）

17. 用户修改个人信息的时候只能修改非关键信息或者是管理员填充的非关键信息，不能修改类似部门名称，角色名称，用户工号这样的关键信息

18. 显示用户的个人信息的时候不仅有user表的数据，还有dept表的部门名称，以及role表的角色名称，要进行pms_sys_user, pms_sys_dept, pms_sys_user_role, pms_sys_role四表关联查询，并且要使用mybatis的resultMap来接收查询结果，mapper.xml中的SQL如下：
	```xml
	<!-- 用户resultMap，包括用户的角色列表 -->
	<resultMap type="userDto" id="userDtoResultMap">
		<id column="user_id" property="userId"></id>
		<result column="dept_name" property="name" />
		<result column="dept_id" property="deptId" />
		<result column="login_name" property="loginName" />
		<result column="user_name" property="userName" />
		<result column="user_no" property="userNo" />
		<result column="email" property="email" />
		<result column="user_no" property="userNo" />
		<result column="phone" property="phone" />
		<result column="mobile" property="mobile" />
		<result column="remarks" property="remarks" />
		<collection property="roleList" ofType="role">
			<result column="role_name" property="name" />
		</collection>
	</resultMap>
	
	<!-- 通过userId获得用户对象包括部门名称，角色... -->
	<select id="getUserInfoById" resultMap="userDtoResultMap" parameterType="long">
		SELECT a.name dept_name, b.user_id, b.dept_id, b.login_name, b.user_name,
		b.user_no, b.email, b.phone, b.mobile, b.remarks, d.name role_name
		FROM pms_sys_dept a, pms_sys_user b,
		pms_sys_user_role c, pms_sys_role d
		WHERE a.id = b.dept_id AND b.user_id = c.user_id 
		AND c.role_id = d.id AND b.user_id = #{userId} AND d.del_flag = 0
	</select>
	```

19. 项目中使用阿里的fastjson来进行json字符串与java bean之间的转换，用法如下：
	```java
	// 解析前台传来的json字符串
	Clazz clazz = JSON.parseObject(jsonObj, Clazz.class);
	// 将一个java对象obj转换成json格式的字符串
	String jsonStr = JSON.toJSONString(obj);
	// 将集合对象userList转换成json格式的字符串
	String jsonArrayStr = JSONArray.toJSONString(userList);
	```

20. 查询用户的个人信息的时候，要把用户的id也查出来，放到页面的hidden域中，在修改用户信息的时候通过此id再次查询用户信息（而不是直接使用页面上的数据）并通过jquer操作DOM元素赋值到相应的输入框中

21. 通过$.serializeArray函数先把前台的表单对象先序列化成json数组再通过$.each函数取出数组中的每一个对象，把对象的name和value赋值给一个空的对象，然后调用JSON.stringify(obj)把该js对象转化成json格式的字符串，发往后台，后台通过一个String类型的变量接收，前台写法如下：
	```js
	var jsonObj = {};
	var formArray = $("#userInfoChangeForm").serializeArray();
	$.each(formArray,function(i, item) {
		jsonObj[item.name] = item.value;
	});
	jsonObj = JSON.stringify(jsonObj);
	```
详细用法参考我的这篇博文[JQuery的serialize()与serializeArray()与each()](http://blog.csdn.net/a909301740/article/details/78809567 "JQuery的serialize()与serializeArray()与each()")

22. 修改完用户的信息之后要再查询一下，这个查询动作要写在jquery的ajax的complete函数里面，如果写在ajax调用以外的地方，那么查询出来的就有可能不是更新之后的数据因为ajax请求是异步的，后面的语句不会等待ajax请求结束才执行，而是与ajax一起执行，这样虽然数据库中的数据可能是修改之后的，但是页面上的数据却是修改之前的，不利于良好的用户交互。

23. 字典可以节省数据库的资源，所以就有了字典管理这个功能模块

24. 在编写SQL的时候注意：尽量不要使用某个数据库特有的语句，这会有助于后期数据库的迁移

25. 设计一个功能的时候首先要考虑页面，然后是表结构

26. 完成一个功能的步骤：
	* 建表
	* 建bean
	* 建dao/mapper
	* 建service
	* 编写action
	* 写页面
	* 写js

27. mybatis的mapper在处理多个简单类型的输入参数时使用0,1,param1,param2作为占位符获取相应的参数，而不要直接使用参数名称

28. log4j的日志设debug级别可以查看mybatis的SQL的执行日志

29. 页面设计：查询和新增按钮一般放在一起，修改和删除按钮一般放在一起

30. 字典列表页面一加载，就把所有的字典类型信息加载到select控件里



## 致谢
感谢您对本项目的关注，如果项目中有任何错误或不妥，欢迎指正，我将不胜感激。<br/>
项目持续更新中...<br/>
更多精彩内容，敬请关注[曲健磊的博客](http://blog.csdn.net/a909301740 "曲健磊的博客")

