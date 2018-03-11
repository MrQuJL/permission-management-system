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
* My97DatePicker	时间选择控件

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

* 项目包结构展示<br/>
![image](https://github.com/MrQuJL/permission-management-system/raw/master/pms-imgs/项目包结构一览.png)
![image](https://github.com/MrQuJL/permission-management-system/raw/master/pms-imgs/action和dto的包结构.png)
![image](https://github.com/MrQuJL/permission-management-system/raw/master/pms-imgs/entity的包结构.png)
![image](https://github.com/MrQuJL/permission-management-system/raw/master/pms-imgs/mapper的包结构.png)
![image](https://github.com/MrQuJL/permission-management-system/raw/master/pms-imgs/service及其实现类的包结构.png)
![image](https://github.com/MrQuJL/permission-management-system/raw/master/pms-imgs/配置文件命名.png)

* 项目的前台页面结构:
	> webapp/index.jsp &nbsp;&nbsp;引导页面，通过后台跳转到登陆页面<br/>
	webapp/jsAndCss/js &nbsp;&nbsp;一些js文件<br/>
	webapp/jsAndCss/css &nbsp;&nbsp;一些css文件<br/>
	webapp/jsAndCss/img &nbsp;&nbsp;一些图片文件<br/>
	webapp/WEB-INF/pages &nbsp;&nbsp;放页面<br/>


## 界面
![image](https://github.com/MrQuJL/permission-management-system/raw/master/pms-imgs/index.png)

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

1. 用户访问系统资源进行身份认证的时候，用户名和密码输入成功即将进入主页面，但是，浏览器却显示出了无权访问的页面
	> 原因：因为我把跳转到主页面设定为了一个新的请求，所以该请求又经过了身份验证和权限检验这两个拦截器，该请求成功通过了身份认证拦截器，但是在进行权限验证的时候由于在菜单表中并没有配置进入主页面的请求对应的权限，导致即使登录成功也无法进入主页面
	
	> 解决：在权限验证拦截器中修改业务逻辑，对含有主页面的请求放行
	
	> 教训：在设置资源的访问权限的时候要具体问题具体分析，结合项目的请求的执行流程来处理业务逻辑

2. shiro-spring-1.3.2版本没办法与shiro-core-1.2.3版本集成，shiro-ehcache-1.2.2没办法与shiro-core-1.2.2版本集成
	> 原因：shiro-core版本过高，其他依赖的jar包无法很好的兼容

	> 解决：更换成shiro-core-1.2.1之后，完美解决

	> 教训：在使用一些框架或者组件的时候尽量不要使用最新的版本，建议使用最稳定的版本。一句俗话说的好：最好的，不一定最合适，最合适的，才是真正最好的

3. 在访问未经过shiro授权的资源的时候，没有出现预先写好的拒绝访问页面
	> 原因：用ajax异步提交的该请求，shiro没有对ajax请求有很好的集成

	> 解决：用jquery的ajax的error函数来显示相应的错误信息

	> 扩展：将请求修改为表单的submit同步进行提交，成功显示出了预先写好的拒绝访问页面

4. 在junit中测试菜单的修改功能时出现异常，但是在服务器上运行却没有问题
	> 原因：在获取updateBy（修改人id）时是在shiro的SecurityManager环境中获取的，但是junit的单机测试环境并没有使用SecurityManager，所以获取不到相应的字段，导致后台报错

	> 解决：手动设置updateBy字段的值

	> 教训：在测试某些功能的时候，可能需要依赖服务器开启时所提供的环境，单机测试的时候要注意手动设置一些属性。

5. 前台无法使用$.each()对后台传过来的json字符串进行解析
	> 原因：如题，后台传过来的是一个json字符串，对于字符串要先通过JSON.parse(str)解析成js对象，然后才能通过$.each()进行遍历
	
	> 解决：在通过$.each()遍历的之前先通过JSON.parse("json字符串")解析一下，然后在遍历该js对象

	> 扩展：关于json类型字符串的转化问题，可以参考我的这篇博文-[JSON.parse()和JSON.stringify()](http://blog.csdn.net/a909301740/article/details/78809251)

6. 在进入菜单编辑页面时，没有加载菜单树zTree
	> 原因：加载菜单树的请求需要依赖页面加载过来的菜单id，但是由于是异步的请求，并没有等待页面加载完毕就向服务器发出了请求，因此菜单id始终没有获取到，导致菜单树一直加载不出来

	> 解决：设置ajax的请求为同步 async:false

7. 查询指定id的所有子孙区域的时候报并发修改异常 ConcurrentModificationException
	> 原因：使用forEach遍历的过程中仍不断的向list集合中添加数据，造成了并发修改异常

	> 解决：记录一开始查询出的直接子区域的size，使用普通for循环递归遍历查找孙子区域

8. 在一个集合中剔除存在于另一个集合中的元素时contains判断无效
	> 原因：contains方法默认是调用对象的equals方法来判断对象是否存在于容器中，如果不重写equals的话默认使用Object的equals方法来判断，而Object的equals方法实现如下：
	```java
	public boolean equals (Object obj) {
	    return (this == obj);
	}
	```

	> 解决：重写对象的hashCode和equals方法即可，重写 hashCode 方法是为了根据元素自身的特性确定它的哈希值从而确定它在集合中的存储位置，覆盖 equals 方法是为了在发生哈希冲突的时候，确定两个元素是否是同一个元素。

9. 用eclipse打开项目时，项目的图标上出现红色错误标示的几种原因（**欢迎补充**）
	> 原因：Eclipse的编译版本和项目的jdk版本不匹配
	
	> 解决：修改项目和windows的properties的Java Compiler 即编译的jre环境

	> 原因：项目属性的Project Facets设置的java版本有误，应该为jdk1.8

	> 解决：修改为项目所使用的JDK1.8

	> 扩展：Window -> Show View -> Markers 视图可以查看项目中的错误或者警告的详细提示信息

10. tomcat一启动项目就报错，几种可能的原因（**欢迎补充**）
	> 原因：org.apache.ibatis.builder.BuilderException: Error parsing Mapper XML - 使用mybatis时mapper.xml配置文件中定义了两个同名的sql片段
	
	> 解决：修改其中的一个sql片段的name

	> 原因：因为没有为index.jsp页面添加jsp的头部，导致项目一启动就报错

	> 解决：添加jsp头部（即page指令）
	```jsp
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	```

11. 为某个用户增加了一些角色，发现界面上的菜单出现了重复的现象
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

20. 查询用户的个人信息的时候，要把用户的id也查出来，放到页面的hidden域中，在修改用户信息的时候为保证前后台数据的一致性通过此id再次查询用户信息（而不是直接使用页面上的数据）并通过jquer操作DOM元素赋值到相应的输入框中

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

24. 在编写SQL的时候注意：尽量不要使用某个数据库特有的语句，这会有助于后期数据库的迁移

27. mybatis的mapper在处理多个简单类型的输入参数时使用0,1,param1,param2作为占位符获取相应的参数，而不要直接使用参数名称

31. 增加和修改字典共用一套业务逻辑公用一套页面，根据有无id来区分是新增还是修改，如果是修改则在后台先查询一下该字典的详细信息，然后通过ServletActionContext放到session里面，如果是新增则将session里面相应的key置为空，跳转到编辑页面的时候如果是修改则通过EL表达式获取相应的值，填充到相应的输入框中

33. 在删除像字典，菜单，用户...这样的非映射表时，通常采用逻辑删除，即只修改一个字段del_flag为1而不做物理删除（delete），这样做有利于数据的恢复

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

47. 自己定义的拦截器一般放在struts2默认的拦截器的前面，如果放在后面，struts2默认的拦截器栈里面的19个拦截器就会先拦截，如果一次请求未通过自定义拦截器设定的规则，那么就白白浪费了系统的性能

48. shiro简介
	shiro是apache下面的一个开源框架，他实现了用户身份认证，权限授权 ，加密等功能，组成了一个系统级的安全认证框架

51. shiro的开发环境搭建
	* shiro的核心包 &nbsp;&nbsp;&nbsp;  shiro-core-1.2.1.jar
	* shiro与web整合的包 &nbsp;&nbsp;&nbsp;  shiro-web-1.2.1.jar
	* shiro与spring整合的包 &nbsp;&nbsp;&nbsp;  shiro-spring-1.2.1.jar
	* shiro与ehcache整合的包 &nbsp;&nbsp;&nbsp;  ehcache-core-2.5.0.jar  shiro-ehcache-1.2.1.jar

54. shiro在用户认证之后就会把用户的身份信息放入它自己的session里面，在进行用户授权的时候它就会直接去session里面去（缓存起来，提高检索效率）

60. **业务上的一点注意事项：添加菜单之后还要为系统管理员拥有的角色添加对该菜单的权限，而不直接给当前用户拥有的角色授权，这样该用户即使添加了这个菜单，想要使用该菜单仍然要通过系统管理员进行二次授权才可以使用，保障了系统的安全**

61. 删除菜单之前还要判断当前菜单是否有子菜单，如果有则不能删除该菜单，这里不采用递归删除其所有子菜单的原因是为了防止用户的二次误操作导致数据丢失 *（要站在用户的角度看待问题，试想：用户不小心点击了删除按钮，弹出提示框：当前菜单下还有子菜单，您确定要删除当前菜单及其子菜单吗？用户又一个不小心，点了确定... 虽然作为软件开发商，我们已经给出了提示信息，责任已经尽到了，但是，用户心里还是会有些不愉快的，下次系统维护或升级就肯定不会再找我们了，所以，这里当判断当前菜单有子菜单时就干脆不让用户删除）*

68. 在修改菜单的父级菜单的时候，当前菜单以及所有子菜单（包括孙子菜单）都禁止显示，不能把当前菜单挂在它的子菜单下面，否则会产生死循环，数据库会有大量的垃圾数据， **树形结构都要预防死循环**

77. 为了在修改菜单的时候避免当前菜单和它的子菜单作为父级菜单显示出来，需要在后台加载数据的时候对它自己以及它的子菜单进行过滤，在service层查询出当前菜单的所有子孙菜单，然后在action中循环剔除子孙菜单

79. 使用ListIterator迭代list集合的过程中可以删除元素

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

85. @Deprecated注解用来注释那些已经过时的方法（不推荐使用的方法），往往还要在注释里面给使用者推荐一个取而代之的方法，在本项目中，DeptUtils的sortDeptList方法和MenuUtils的sortMenuList方法都用重新封装的一个TreeUtils来取代，调用其中的泛型方法sortTreeList来完成树形结构的排序

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
	useGeneratedKeys = "true"	使用生成的主键
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
		因为部门id要与部门表进行关联，所以必须要确保用户表的dept_id和部门表的dept_id之间的一致性，就要给用户表的dept_id添加外键，这样才能确保数据的一致性，**但是我在设计这张表时并没有添加外键**，因为有了外键，在向主表添加记录的时候，数据库会去从表中查询一次，这就会影响主表数据的插入速度，影响系统的性能，影响用户的体验，所以就没有添加外键，**但是同时为了数据的一致性，我把确认部门id是否在部门表中存在这一步操作放到了业务逻辑层由java代码来控制，这样就提高了数据的插入速度减轻了数据库服务器的压力，提高了用户的体验，profit++**

100. 获取checkbox的值，思路：利用name属性获取checkboxs对象，然后循环判断checked属性（true为选中，false为未选中），创建数组，选中的push进数组，未选中的不做处理,实现：
	
	var id_array=new Array();  
	$('input[name="id"]:checked').each(function(){  
		id_array.push($(this).val());//向数组中添加元素  
	});  
	var idstr=id_array.join(',');//将数组元素连接起来以构建一个字符串  
	alert(idstr);
	

101. 日志功能分析：
日志一般是通过某些事件（添加，删除，修改...）触发的，所以日志不存在手动添加功能，而需要通过切面来向日志表里添加数据，同时日志也不能修改，日志是用来查询历史记录的，可以在日志记录达到一定量的时候覆盖，而不要提供对外删除日志的接口（除非用户有这方面的需求）。

102. 在该项目中日志的实现思路如下：
	* 日志的几个要素：什么人，什么时候，在哪，做了什么事情，造成了什么后果
	* 使用aspectJ，导入aop，aopaliance，aspectJ，spring-aspects包
	* 注册aspectJ的自动代理<aop:aspectj-autoproxy />
	* *注：日志的实现方式多样，可以用AOP也可以用拦截器*

103. mybatis如果想在控制台打印执行过程的SQL语句，需要在在主配置文件中添加如下配置：

	<setting name="logImpl" value="STDOUT_LOGGING"/>
	

## 致谢
感谢您对项目的关注，如果项目中有任何错误或不妥，欢迎指正，我将不胜感激。<br/>
项目持续更新中...<br/>
更多精彩内容，敬请关注[曲健磊的博客](http://blog.csdn.net/a909301740 "曲健磊的博客")
