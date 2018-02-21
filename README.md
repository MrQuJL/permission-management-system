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
	    <!-- 访问未经授权页面时显示的页面 -->
	    <property name="unauthorizedUrl" value="/refusePage.jsp" />
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
	public boolean equals (Object obj) {
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
	> 2. 用Hex对随机数编码
	> 3. 将随机数和密码用sha1不可逆算法加密
	> 4. 将第三步得到的字符串值用Hex进行编码
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
	    FROM pms_sys_dept a, pms_sys_user b, pms_sys_user_role c, pms_sys_role d
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
	详细用法参考我的这篇博文-[JQuery的serialize()与serializeArray()与each()](http://blog.csdn.net/a909301740/article/details/78809567 "JQuery的serialize()与serializeArray()与each()")

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

30. 字典列表页面一加载，就把所有的字典类型信息加载到select控件里（发送一个请求）
	```jsp
	<%-- 通过forEach标签来遍历 --%>
	<c:forEach items="${dictTypeList}" var="dictType">
	    <option value="${dictType}">${dictType}</option>
	</c:forEach>
	```

31. 增加和修改字典共用一套业务逻辑公用一套页面，根据有无id来区分是新增还是修改，如果是修改则在后台先查询一下该字典的详细信息，然后通过ServletActionContext放到session里面，如果是新增则将session里面相应的key置为空，跳转到编辑页面的时候如果是修改则通过EL表达式获取相应的值，填充到相应的输入框中

32. 在保存字典的时候要通过编辑页面的隐藏域hidden上是否有dictId来判断是insert还是update

33. 在删除像字典，菜单，用户...这样的非映射表时，通常采用逻辑删除，即只修改一个字段del_flag为1而不做物理删除（delete）

34. 为了良好的用户体验，删除之后也要重新查询一下数据

35. 一个轻量级的分页组件的封装思路（本项目中使用的是mybatis的pageHelper）：
	* 在后台编写数据库工具方言，屏蔽数据库分页方法的差异(mybatis已经完成)
	* 在后台编写分页的工具类，屏蔽翻页动作带来的查询差异(mybatis已经完成)
	* 在后台编写分页条的java代码，方便页面统一生成分页条，减少页面代码重复

36. 常用的几款数据库的方言差异：
	```
	# mysql: limit
	# beginrow从0开始,pagesize表示一页多少条记录
	SELECT * FROM TABLE A LIMIT beginrow, pagesize

	# oracle: rownum
	SELECT B.* FROM 
	(SELECT rownum rn a.* FROM table a) B
	WHERE B.rn BETWEEN beginrow AND endrow

	# sqlserver: top
	SELECT TOP 100 id, name, sex FROM TABLE
	```

37. 从Connection里面可以获得数据库的类型
	```java
	// 可以在连接里面获取数据库的类型:
	Connection con = DriverManager.getConnection(url, "admin", "123");
	DatabaseMetaData dm = con.getMetaData();
	String dbName = dm.getDatabaseProductName();
	String version = dm.getDatabaseProductVersion();
	```

38. 通过PageInfo和前台分页查询的js函数名来组装分页条
	```java
	package com.lyu.pms.common.util;
	import com.github.pagehelper.PageInfo;

	/**
	 * 类名称: 分页工具类
	 * 类描述: 生成页面上的分页条
	 * 全限定性类名: com.lyu.pms.common.dto.PageUtils
	 * @author 曲健磊
	 * @date 2018年1月22日 上午10:53:21
	 * @version V1.0
	 */
	public class PageUtils {
	    /**
	     * 根据前台组件生成分页条
	     * @param 
	     * @return
	     */
	    public static String pageStr (PageInfo<?> pageInfo,String queryMethod) {
	        StringBuffer sb = new StringBuffer("<ul>");
	        //判断当前页是不是首页
	        if (pageInfo.isIsFirstPage() || pageInfo.getPrePage() == 0) {
	            sb.append("<li class=\"disabled\"><a href=\"javascript:\">&#171; 上一页</a></li>");
	        } else {
	            sb.append("<li><a href=\"javascript:"+queryMethod+"(");
	            sb.append(pageInfo.getPrePage()).append(",");
	            sb.append(pageInfo.getPageSize()).append(")\">&#171; 上一页</a></li>");
		    }

	        for (int i = 0; i < pageInfo.getNavigatepageNums().length; i++) {
		        int pageNum = pageInfo.getNavigatepageNums()[i];
		        if (pageInfo.getPageNum() == pageNum) {
			        sb.append("<li class=\"active\"><a href=\"javascript:\">");
			        sb.append(pageNum).append("</a></li>");
		        } else {
		            sb.append("<li><a href=\"javascript:"+queryMethod+"(");
		            sb.append(pageNum).append(", ");
		            sb.append(pageInfo.getPageSize()).append(")\">");
		            sb.append(pageNum).append("</a></li>");
	            }
	        }

	        //判断是否是尾页
	        if (pageInfo.isIsLastPage() || pageInfo.getNextPage() == 0) {
	            sb.append("<li class=\"disabled\"><a href=\"javascript:\">下一页 &#187;</a></li>");
	        } else {
	            sb.append("<li><a href=\"javascript:"+queryMethod+"(");
	            sb.append(pageInfo.getNextPage()).append(",");
	            sb.append(pageInfo.getPageSize()).append(")\">下一页 &#187;</a></li>");
	        }

	        sb.append("<li class=\"disabled controls\"><a href=\"javascript:void(0);\">当前第 ");
	        sb.append("<input type=\"text\" maxLength=\"6\" value=\"");
	        sb.append(pageInfo.getPageNum());
	        sb.append("\" onkeypress=\"var e=window.event||this;var c=e.keyCode||e.which;if(c==13)"+queryMethod+"(this.value,");
	        sb.append(pageInfo.getPageSize()).append(");\" onclick=\"this.select();\"/>");
	        sb.append(" 页 / 共 ");
	        sb.append(pageInfo.getPages());
	        sb.append(" 页， 共 ");
	        sb.append(pageInfo.getTotal());
	        sb.append(" 条</a></li></ul>");

	        return sb.toString();
	    }
	}
	```

39. 总结一下StringBuffer和StringBuilder的区别：
	* **可变性**：<br/>
	String被final修饰，而且底层的char类型的数组也被final修饰，所以String不可变
	StringBuffer和StringBuilder都继承自AbstractStringBuilder，它们的底层也是char
	类型的数组，但是没有被final修饰，所以都是可变的<br/><br/>
	* **线程安全性**：<br/>
	String对象不可变，也可以理解为常量，所以是线程安全的<br/>
	StringBuffer对方法加了同步锁，所以线程安全<br/>
	StringBuilder没有对方法加同步锁，所以线程不安全<br/><br/>
	* **性能**：<br/>
	每次改变String类型的变量时（例如：+）都会生成一个新的对象，性能较低
	StringBuffer每次都是改变自身的char数组所以不会生成新对象，性能比较好
	StringBuilder和StringBuffer相比方法没有加同步锁，所以性能相对快一些，
	但是，却要冒线程不安全的风险，所以还是推荐StringBuffer

40. 分页查询的流程：
	* 前台向后台传递查询条件，页数，每页的记录数
	* action调用service方法获取PageInfo对象
	* 从PageInfo中获取dictList对象
	* 通过封装的分页条工具类，根据pageInfo的相关信息封装分页条
	* 将上面两部分内容转化成json字符串发往前台
	* 前台通过jquery操作DOM填充页面

41. 权限管理的概念：
	> 定义：权限管理实现用户对系统访问的控制，按照既定的规则或者策略控制用户访问被授权的资源
	> 内容：权限管理包括用户认证和用户授权两个部分

42. 权限管理 -> 用户认证：
	* 概念：用户访问系统，需要验证用户的正确性和合法性
	* 认证的几种方式：
		* 用户名和密码
		* 证书
		* 指纹
		* 二维码
		* 刷脸登录
	* 认证的流程(以用户名和密码认证为例):
		* 访问系统资源（如果是匿名访问资源可以省略验证）
		* 验证用户是否存在
		* 验证密码是否正确
		* 验证通过就可以访问系统资源
		* ![image](https://github.com/MrQuJL/permission-management-system/raw/master/pms-imgs/用户认证流程图.png)
	* 用户认证的几个基本对象概念:
		* subject 主体 可以理解为用户也可以是其他系统或者访问系统的其他对象
		* principle 身份信息 就是主体的标示或者编码（用户名）
		* credential 凭证信息 比如：密码，证书，指纹，人脸...

43. 权限管理 -> 用户授权：
	* 概念：简单理解就是访问控制，用户认证通过后，系统对资源进行授权给用户，用户才能访问
	* 授权的流程：
		* 分配权限
		* 用户通过认证以后，即将访问系统资源
		* 要去查询该用户是否有访问该资源的权限
		* 如果有则访问，无则拒绝
		* ![image](https://github.com/MrQuJL/permission-management-system/raw/master/pms-imgs/用户授权流程图.png)
	* 授权的两种类型：
		* 基于角色的访问授权控制（粗粒度）
		* 基于资源的访问授权控制（细粒度）

44. 最小化授权原则：
	> 因为系统中的资源变化是最小的，而且资源如果有变化可以通过授权分配给用户，不需要修改业务代码，所以一般的权限管理都是基于资源的访问进行授权控制

45. 权限管理实现 -> 解决方案:
	1. 粗粒度权限管理（按钮级别权限管理）
		* 概念：对资源类型的权限管理比如：菜单，url，按钮...

		* 实现：用基于url的拦截方式进行系统级别的处理（不会侵入到业务中去）
		比如：filter，interceptor，springAOP（前置通知）
		
		* 基于url的拦截方式用拦截器来实现（需要两个拦截器：认证拦截器，授权拦截器）

			* 认证拦截器：loginInterceptor
				a: 定义身份信息对象principle<br/>
				b: 在用户确认登录以后，将用户身份信息放到session<br/>
				c: 编写登录拦截器，遇到除了匿名访问之外的url，判断session里面是否存在用户身份信息，如果有则认证成功，放行，否则跳转到登录页面或者拒绝访问页面<br/>
				d: 配置拦截器<br/>

			* 授权拦截器：AuthorizationInterceptor
				a: 在登录的LoginAction用户身份验证通过以后，从数据库获取该用户的授权信息<br/>
				b: 编写授权拦截器，通过认证拦截器以后，进入授权拦截器，从session取出此次授权资源信息，查询此次访问的资源是否在用户的权限范围之内，若果是，放行，否则，转到拒绝访问页面<br/>
				c: 配置拦截器<br/>

	2. 细粒度权限管理
		* 概念：不仅对资源类型进行权限管理，还对资源实例进行管理，
		比如：本不能员工只能查看本部门信息，不能查看其它部门信息
		
		* 细粒度级别的权限管理，因为没有共性，所以不能进行系统级别
		的处理，只能放在业务逻辑中单独处理

46. 在系统内部可以通过单点登录访问另外一个系统的资源，所以在菜单表里面设置一个target字段，用来指明此次连接的目的地，设置href字段则是用来表示资源的uri

47. 自己定义的拦截器一般放在struts2默认的拦截器的前面，如果放在后面，struts2默认的拦截器栈里面的19个拦截器就会先拦截，如果一次请求未通过自定义拦截器设定的规则，那么就白白浪费了系统的性能

48. shiro简介
	shiro是apache下面的一个开源框架，他实现了用户身份认证，权限授权 ，加密等功能，组成了一个系统级的安全认证框架

49. shiro的优势
	shiro是将安全认证相关的功能抽取出来组成一个框架，使用简单，灵活，可以非常快速的完成认证，授权等功能开发，降低系统集成难度，使用广泛，不仅可以运行在web应用，也可以在非web应用上使用，而且还支持分布式集群方式

50. shiro的构成以及相关的概念	
	* Subject:主体，它在shiro里面是一个接口，外部系统通过subject进行认证授权，subject其实是通过Security Manager来完成身份认证的操作

	* SecurityManager:安全管理器，是shiro的核心，管理所有的subject，它是通过Authenticator进行身份认证，通过Authorizer进行授权，通过sessionManager进行会话管理，SecurityManger也是一个接口 ，继承了	Authenticator，Authorizer，sessionManager三个接口

	* Authenticator 认证器，用来对用户身份进行认证，它也是一个接口

	* Authorizer 	授权器，用户通过认证器认证以后，在访问资源时，需要通过授权器判断此用户是否有操作权限

	* SessionManager 会话管理，不依赖于web容器的session,所以shiro能在非web系统中应用	

	* realm  :认证和授权需要通过realm获取用户的权限数据，相当于数据源

	* CacheManager:缓存管理，将用户的权限数据存储在缓存，提高系统性能(Ehcache)

	* ![image](https://github.com/MrQuJL/permission-management-system/raw/master/pms-imgs/shiro-framework.jpg)

51. shiro的开发环境搭建
	* shiro的核心包 &nbsp;&nbsp;&nbsp;  shiro-core-1.2.1.jar
	* shiro与web整合的包 &nbsp;&nbsp;&nbsp;  shiro-web-1.2.1.jar
	* shiro与spring整合的包 &nbsp;&nbsp;&nbsp;  shiro-spring-1.2.1.jar
	* shiro与ehcache整合的包 &nbsp;&nbsp;&nbsp;  ehcache-core-2.5.0.jar  shiro-ehcache-1.2.1.jar

52. shiro的身份认证流程
	* 主体subject登录
	* SecurityManager调用Authenticator来进行认证
	* Authenticator调用默认的realm（相当于一个数据源）来访问数据进行验证
	* 在realm里面会返回一个能够认证通过的AuthenticationInfo认证信息
	* 认证通过则进入系统，否则抛出异常
	* ![image](https://github.com/MrQuJL/permission-management-system/raw/master/pms-imgs/shiro认证流程.png)

53. shiro的授权流程
	* 主体subject登录
	* SecurityManager来对主体的登录进行认证
	* SecurityManager调用Authenticator来进行认证
	* 认证通过进行授权
	* SecurityManager调用Authorier来进行授权
	* 授权成功访问系统资源
	* ![image](https://github.com/MrQuJL/permission-management-system/raw/master/pms-imgs/shiro授权流程.png)

	> 注：自定义realm需要继承AuthorizingRealm实现doGetAuthorizationInfo和doGetAuthenticationInfo方法来完成认证

54. shiro在用户认证之后就会把用户的身份信息放入它自己的session里面，在进行用户授权的时候它就会直接去session里面去（缓存起来，提高检索效率）

55. 知识点：Arrays.asList("role1","role2")获得的list的长度是不能变的，当向其中add或remove元素的时候就会抛出异常，因为获得的这个list是Arrays类的一个内部类当调用add或remove方法的时候其实是调用的他的父类AbstractList的add和remove方法，而调用这两个方法是会直接抛出异常：UnsupportedOperationException

56. shiro与web项目进行整合-通过spring的DelegatingFilterProxy代理来生成shiro过滤器
	```xml
	<!-- shiro的过滤器 -->
	<filter>
	    <filter-name>shiroFilter</filter-name>
	    <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
	    <init-param>
	        <!--  这个参数为true表示由web容器来控制filter的生命周期 -->
	        <!--  如果让spring管理就设置为false -->
	        <param-name>targetFilterLifecycle</param-name>
	        <param-value>true</param-value>
	    </init-param>
	    <init-param>
	        <param-name>targetBeanName</param-name>
	        <!-- 默认就是shiroFilter -->
	        <param-value>shiroFilter</param-value>
	    </init-param>
	</filter>
	<filter-mapping>
	    <filter-name>shiroFilter</filter-name>
	    <url-pattern>/*</url-pattern>
	</filter-mapping>
	```

57. 在spring的配置文件中注册ShiroFilterFactoryBean
	```xml
	<!-- web.xml配置的过滤器对应的bean -->
	<bean id="shiroFilter" class="org.apache.shiro.spring.web.ShiroFilterFactoryBean">
	    <property name="securityManager" ref="securityManager"></property>
	    <property name="loginUrl" value="/toLogin.action"></property>
	    <property name="successUrl" value="/main.action"></property>
	    <property name="unauthorizedUrl" value="/refusePage.jsp" />
		 
	    <property name="filterChainDefinitions">
	        <value>
	            /jsAndCss/** = anon
	            /login.action = anon
	            /sysmgr/getDictListPage.action = perms[dict:query]
	            <!-- /sysmgr/changePwd.action = perms[user:chpwd] -->
	            /** = authc
	        </value>
	    </property>
	</bean>
	
	<!--  安全管理器SecurityManager -->
	<bean id="securityManager" class="org.apache.shiro.web.mgt.DefaultWebSecurityManager">
	    <property name="realm" ref="userRealm"></property>
	    <property name="cacheManager" ref="cacheManager" />
	    <property name="sessionManager" ref="sessionManager" />
	</bean>
	
	<!--  自定义的realm -->
	<bean id="userRealm" class="com.lyu.pms.security.UserRealm">
	    <!-- 注入凭证匹配器 -->
	    <property name="credentialsMatcher" ref="credentialsMatcher"></property>
	</bean>
	
	<!--  注册凭证匹配器 -->
	<bean id="credentialsMatcher" class="org.apache.shiro.authc.credential.HashedCredentialsMatcher">
	    <property name="hashAlgorithmName" value="SHA-1" />
	    <property name="hashIterations" value="1024" />
	</bean>
	
	<!--  定义缓存管理器 -->
	<bean id="cacheManager" class="org.apache.shiro.cache.ehcache.EhCacheManager">
	    <property name="cacheManagerConfigFile" value="classpath:ehcache.xml" />
	</bean>
	
	<!--  定义会话管理器 -->
	<bean id="sessionManager" class="org.apache.shiro.web.session.mgt.DefaultWebSessionManager">
	    <!-- session的失效时间 -->
	    <property name="globalSessionTimeout" value="3600000" />
	    <!--  定时清理失效的会话 -->
	    <property name="sessionValidationInterval" value="1800000" />		
	</bean>
	```

58. 引入shiro的标签，在前台也对请求加以控制 <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 像下面这样把需要权限的按钮包起来：
	```xml
	<shiro:hasPermission name="[dict:query]">
	    <input id="btnSubmit" class="btn btn-primary" type="button" onclick="dictMgr.getDictListPage(1, 10);" value="查询"/>
	</shiro:hasPermission>
	```

59. 关于session的时间单位：
	* web容器tomcat中的session设置的时间单位是分钟

	* servlet中的session的时间单位是秒

	* shiro中的session时间的单位是毫秒

60. **业务上的一点注意事项：添加菜单之后还要为系统管理员拥有的角色添加对该菜单的权限，而不直接给当前用户拥有的角色授权，这样该用户即使添加了这个菜单，想要使用该菜单仍然要通过系统管理员进行二次授权才可以使用，保障了系统的安全**

61. 删除菜单之前还要判断当前菜单是否有子菜单，如果有则不能删除该菜单，这里不采用递归删除其所有子菜单的原因是为了防止用户的二次误操作导致数据丢失 *（要站在用户的角度看待问题，试想：用户不小心点击了删除按钮，弹出提示框：当前菜单下还有子菜单，您确定要删除当前菜单及其子菜单吗？用户又一个不小心，点了确定... 虽然作为软件开发商，我们已经给出了提示信息，责任已经尽到了，但是，用户心里还是会有些不愉快的，下次系统维护或升级就肯定不会再找我们了，所以，这里当判断当前菜单有子菜单时就干脆不让用户删除）*

62. 删除菜单之后还要删除所有角色-菜单对应表里面对该菜单的记录

63. 由于上述两个功能在同一个方法中，在一个方法中多次访问数据库，需使用事务进行控制

64. 菜单表中的链接字段（href）在本项目中只有三级菜单才有权限标示字段，只有"第四级"按钮才有值，所以有的菜单要输入链接，有的要输入权限标示，有些什么都不需要输入

65. 查询出指定id的菜单以及它的父级菜单的名称 <br/>
	知识点：连接查询，左连接
	```
	SELECT A.id, A.parent_id, A.name, A.sort, A.href, A.target, A.icon, A.is_show,
	A.permission, A.update_by, A.update_date, A.remarks, A.del_flag, B.name parentName
	FROM pms_sys_menu A LEFT JOIN pms_sys_menu B
	ON A.parent_id = B.id WHERE A.id = 1
	```

66. 在javaScript或者jQuery中字符串比较没有equals()方法，要比较两个字符串是否相等可以直接用==或者is()进行判断
	```js
	"a"=="a"

	$("#a").val().is("a")
	```

67.  **增加用户体验** :用户在选择父级菜单的时候，在菜单树展开的时候，需要定位一下上一次选择的是哪一个菜单

68. 在修改菜单的父级菜单的时候，当前菜单以及所有子菜单（包括孙子菜单）都禁止显示，不能把当前菜单挂在它的子菜单下面，否则会产生死循环，数据库会有大量的垃圾数据， **树形结构都要预防死循环**

69. js数组定义格式：
	```js
	var arr1 = new Array();
	var arr2 = new Array("菜单","部门","区域");
	var arr3 = ["菜单","部门","区域"];
	```
70. 向js数组中添加元素和删除元素使用push和pop函数

71. js事件冒泡和事件捕获（事件触发的两种方式）：
	* 捕获（从上到下）：document --> html --> body --> div --> input
	* 冒泡（从下到上）: input --> div --> body --> html --> document

72. js事件对象（event）详细信息：
	* type表示的是被触发事件的类型
	* target表示的是事件的目标
	* bubbles：表示事件是否冒泡
	* cancelable：表示是否可以取消事件的默认行为
	* currentTarget：表示事件处理程序当前正在处理事件的那个元素
	* defaultPrevented：表示是否调用了preventDefault()
	* detail：表示的是与事件相关的细节信息
	* eventPhase：调用事件处理处理程序的阶段：1表示捕获阶段、2表示处于目标、3表示冒泡阶段

73. 与js事件对象有关的两个函数：
	* 阻止事件传播		event.stopPropargation();
	* 阻止事件默认行为	event.preventDefault();

74. js绑定事件与解绑事件：
	```js
	// 绑定事件（btn为DOM元素）
	btn.addEventListener('click' ,addevFn1 , false); //false:冒泡，true:捕获
	function addevFn1() {
	    alert("我是绑定的事件");
	};

	// 解绑事件
	btn.removeEventListener("mouseover" , addevFn1, false)
	```

75. IE8及以下的添加和删除监听事件方法：（注：IE9及以上的就用上面的方法）
	```js
	// 绑定事件
	btn.attachEvent("onclick" ,addevFn2);
	function addevFn2(){
	    alert("我是IE8及以下的添加监听事件方法");
	};

	// 解绑事件
	btn.detachEvent("onclick" , addevFn2);	
	```

76. **用户体验** ：用户在选择完菜单后要隐藏掉菜单选择框

77. 为了在修改菜单的时候避免当前菜单和它的子菜单作为父级菜单显示出来，需要在后台加载数据的时候对它自己以及它的子菜单进行过滤，在service层查询出当前菜单的所有子孙菜单，然后在action中循环剔除子孙菜单

78. js中的location对象简介：
	* Location 对象包含有关当前 URL 的信息。

	* Location 对象是 Window 对象的一个部分，可通过 window.location 属性来访问。

	* Location 对象属性:
		* hash		设置或返回从井号 (#) 开始的 URL（锚）。
		* host		设置或返回主机名和当前 URL 的端口号。
		* hostname	设置或返回当前 URL 的主机名。
		* href		设置或返回完整的 URL。
		* pathname	设置或返回当前 URL 的路径部分。
		* port		设置或返回当前 URL 的端口号。
		* protocol	设置或返回当前 URL 的协议。
		* search	设置或返回从问号 (?) 开始的 URL（查询部分）。

	* Location 对象函数:
		* assign()	加载新的文档。
		* reload()	重新加载当前文档。
		* replace()	用新的文档替换当前文档。

79. 使用ListIterator迭代list集合的过程中可以删除元素

80. jquery-validate的一点学习心得：
	* 记得导入jquery.js和jquery.validate.min.js文件
	* 调用validate方法进行校验$("#表单id").validate()
	* 可以通过对象的方式向validate方法中传递参数$("#表单id").validate({...})
	* submitHandler是一个在表单提交(点击type为"submit"的按钮)的时候调用的一个回调函数，它会取消提交表单的默认行为，在函数内部可以通过调用form.submit()方法来提交
	* errorPlacement（错误信息显示的位置）<br/>
	默认情况是：error.appendTo(element.parent());即把错误信息放在验证的元素后面。<br/>
		```js
		errorPlacement: function(error, element) {
			error.appendTo(element.parent());
		}
		```
		error --> 错误信息(默认用label标签包裹)<br/>
		element --> 出现错误信息的元素（input）<br/>
		错误提示的默认css类名是"error"(即label的默认类名)<br/>
	* errorContainer:错误信息存放的容器，可以在有错误信息的时候显示，没有错误信息的时候隐藏
	* 用法示例：
		```js
		$(function() {
		    $("#name").focus();
		    $("#saveMenuForm").validate({
		        submitHandler: function(form){
		            form.submit();
		        },
		        errorContainer: "#messageBox",
		        errorPlacement: function(error, element) {
		            $("#messageBox").text("输入有误，请先更正。");
		            error.appendTo(element.parent());
		        }
		    });
		});
		```

81. 由于菜单，部门，区域都具备树形结构的特征，所以提取共性封装一个树形节点对象来为他们继承，主要有：id，pId，name这三个属性

82. 在使用zTree的时候可以直接将后台传过来的数据作为zTree的初始化参数：
	```js
	success : function(data) {
	    var menuArray = JSON.parse(data.jsonObj);
	    $.fn.zTree.init($("#menuTree"), setting, menuArray);
	}
	```

83. zTree展开指定层级节点的代码：
	```js
	var nodes = menuTree.getNodesByParam("level",2); // 这里的2代表展开三级，不包含顶级节点
	for(var i=0; i<nodes.length; i++){
	    menuTree.expandNode(nodes[i],true,false,true,false);
	    // 第一个参数：需要 展开 / 折叠 的节点数据
	    // 第二个参数：true表示展开节点，false表示折叠节点
	    // 第三个参数：true表示全部子孙节点进行与该节点相同的操作，false表示只影响当前节点
	    // 第四个参数：true 表示 展开 / 折叠 操作后，通过设置焦点保证此焦点进入可视区域内
	    // 第五个参数：true 表示执行此方法时触发 beforeExpand / onExpand 或 beforeCollapse / onCollapse 事件回调函数
	}
	```
	更多关于zTree的API说明，详见：[zTree API 文档](http://www.treejs.cn/v3/api.php "zTree API 文档")

84. treeTable的层次展开设置:
	```js
	$("#treeTable").treeTable({expandLevel : 2});
	```

85. @Deprecated注解用来注释那些已经过时的方法（不推荐使用的方法），往往还要在注释里面给使用者推荐一个取而代之的方法，在本项目中，DeptUtils的sortDeptList方法和MenuUtils的sortMenuList方法都用重新封装的一个TreeUtils来取代，调用其中的泛型方法sortTreeList来完成树形结构的排序

86. code字段的作用：根据编码统计某个部门或者区域的支出以及销售额...

87. js中的history对象：History 对象包含用户（在浏览器窗口中）访问过的 URL
	* back()	加载 history 列表中的前一个 URL。
	* forward()	加载 history 列表中的下一个 URL。
	* go()		加载 history 列表中的某个具体页面。

		```js
		history.go(-1); // 相当于浏览器的回退
		history.back(); // 同上一步
		```

88. 实现主页菜单动态加载思路：
	* 要结合实现菜单的组件，js代码控制，后台数据的输出
	* a: 菜单有几级
	* b: 前台什么组件实现，要符合组件的css结构才能控制
	* c: js代码怎么控制数据的加载，是ajax异步还是全部一次性加载
	* d: 在登录页面进入主页的时候，要加载到哪一级

89. 进入修改页面的时候只把当前用户拥有的资源权限（菜单，部门，区域）显示出来

90. 将角色删除之后要将角色菜单映射表，角色部门映射表，角色区域映射表中的数据删除，而且映射表一般不会做逻辑删除，都是做物理删除

91. 配置文件不要分的过细，分的过细维护起来麻烦，通常系统功能分一个配置文件放，业务功能分一个配置文件放，就不要再细分模块了，软件的维护成本占25%~30%

92. 为角色分配权限的时候只能分配当前用户所拥有的权限

93. 在一个服务类里面做多次数据库的操作要用事务来控制
	* 注册事务管理器
	* 开启事务注解驱动
	* 在相应的方法上加上注解：

		```java
		@Transactional(isolation=Isolation.DEFAULT,propagation = Propagation.REQUIRED)
		...
		```

94. 修改角色：
	* 树生成之后要默认选中此角色拥有的节点
	* 修改角色时还要查询该角色所拥有的菜单树资源，部门树资源，区域树资源
	* 对于映射表的记录先删除再添加
	* 删除的时候要先删从表再删主表
	* 批量修改时，没有选择任何资源，则后台要进行非空判断

95. JSP由以下部分组成：
	* html标签
	* java代码
	* jsp标签

		```jsp
		<c:forEach items="" var=""></c:forEach>
		<c:choose>
		    <c:when test=""></c:when>
		</c:choose>
		```
	* jsp指令

		```jsp
		<%@ page="" %>
		<%@ include="" %>
		<%@ taglib="" %>
		```
	* jsp动作:

		```jsp
		jsp:include (会先解析要包含的页面，解析后和主页面合并一起显示)
		jsp:forward
		jsp:useBean
		...
		jsp:setProperty
		```

96. 向角色表添加一条记录后，通过mybatis返回的主键向角色-菜单，角色-部门，角色-区域映射表中添加数据，并通过spring的声明式事务进行控制

97. mybatis添加记录返回主键需要在insert标签上设置这三个属性：
	```java
	useGeneratedKeys = "true" 使用生成的主键
	keyProperty = "id"		  pojo类对应的属性
	keyColumn = "id"		  数据库表对应的字段
	```

98. **业务上的注意事项** ：
	* 录入用户信息的时候，不录入密码，使用默认密码
	* 在为用户分配角色的时候，要注意最小化授权，用最少的角色分配给该用户所需要的权限
	* 超级管理员账号不可以删除，自己不能删除自己，所显示的用户只能是当前用户所在部门里有权限看到的用户（像淘汰子节点一样）
	* 用户只跟部门挂钩，不要和其他的字段有关联
	* 系统表一般是不经常改动的表，为了存取的方便，一般要放到缓存组件里

99. 该系统数据库表设计与三大范式之间的关系：
	* 第一范式：表中的字段都是原子的不可拆分的
	* 第二范式：就是要求有主键，并且要求其他字段都要依赖于主键
		* 为什么要有主键？没有主键就没有唯一性，没有唯一性就无法唯一确定一条记录，无法确定一条记录说明这个表设计的不合理，所以需要主键。
		* 其他字段为什么要依赖于主键？不依赖于主键就无法定位到他们，其他字段组成的这行记录和主键表示的是同一个东西，而主键是唯一的，所以他们只要依赖于主键，就使这条记录成了唯一的。
		* **但是，我在设计角色-菜单，角色-部门，角色-区域这些多对多关系的映射表的时候就没有遵守第二范式，没有给这些表添加主键，因为一个角色它一般对应了多个菜单，多个部门，多个区域，记录一般是不唯一的，所以就没有添加主键**
	* 第三范式：在第二范式的基础上消除传递依赖<br/>
		就拿用户表来说，用户属于某个部门，所以用户表中就需要有以一个部门id字段，那么需不需要部门名称这个字段呢？<br/>
		不需要，因为加上这个字段的话数据就冗余了，因为我们可以通过部门id关联到部门表从而查询到部门名称，所以不需要添加部门名称。
		因为部门id要与部门表进行关联，所以必须要确保用户表的dept_id和部门表的dept_id之间的一致性，就要给用户表的dept_id添加外键，这样才能确保数据的一致性，但是我在设计这张表时并没有添加外键，因为有了外键，在向主表添加记录的时候，数据库会去从表中查询一次，这就会影响主表数据的插入速度，影响系统的性能，影响用户的体验，所以就没有添加外键，但是同时为了数据的一致性，我把确认部门id是否在部门表中存在这一步操作放到了业务逻辑层由java代码来控制，这样就提高了数据的插入速度减轻了数据库服务器的压力，提高了用户的体验，profit++

100. 获取checkbox的值，思路：利用name属性获取checkboxs对象，然后循环判断checked属性（true为选中，false为未选中），创建数组，选中的push进数组，未选中的不做处理,实现：
	```js
	var id_array=new Array();  
	$('input[name="id"]:checked').each(function(){  
		id_array.push($(this).val());//向数组中添加元素  
	});  
	var idstr=id_array.join(',');//将数组元素连接起来以构建一个字符串  
	alert(idstr);
	```

101. 日志功能分析：
日志一般是通过某些事件（添加，删除，修改...）触发的，所以日志不存在手动添加功能，而需要通过切面来向日志表里添加数据，同时日志也不能修改，日志是用来查询历史记录的，可以在日志记录达到一定量的时候覆盖，而不要提供对外删除日志的接口（除非用户有这方面的需求）。

102. 在该项目中日志的实现思路如下：
	* 日志的几个要素：什么人，什么时候，在哪，做了什么事情，造成了什么后果
	* 使用aspectJ，导入aop，aopaliance，aspectJ，spring-aspects包
	* 注册aspectJ的自动代理<aop:aspectj-autoproxy />
	* *注：日志的实现方式多样，可以用AOP也可以用拦截器*

103. mybatis如果想在控制台打印执行过程的SQL语句，需要在在主配置文件中添加如下配置：

	```xml
	<setting name="logImpl" value="STDOUT_LOGGING"/>
	```

## 致谢
感谢您对项目的关注，如果项目中有任何错误或不妥，欢迎指正，我将不胜感激。<br/>
项目持续更新中...<br/>
更多精彩内容，敬请关注[曲健磊的博客](http://blog.csdn.net/a909301740 "曲健磊的博客")
