<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<title>角色管理</title>
	
<meta charset="utf-8" />
<meta name="renderer" content="webkit">
<%@ include file="/WEB-INF/pages/include/head.jsp" %>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="roleList.html">角色列表</a></li>
		<li><a href="roleAdd.html">角色添加</a></li>
	</ul>
<script type="text/javascript">top.$.jBox.closeTip();</script>

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<tr><th>角色名称</th><th>所属机构</th><th>数据范围</th><th>操作</th></tr>
		
			<tr>
				<td><a href="#">普通用户</a></td>
				<td>湖南省总公司</td>
				<td>仅本人数据</td>
				<td>
					<a href="roleAssign.html">分配</a>
					<a href="roleAdd.html">修改</a>
					<a href="#" onclick="return confirmx('确认要删除该角色吗？', this.href)">删除</a>
				</td>	
			</tr>
		
			<tr>
				<td><a href="#">本部门管理员</a></td>
				<td>湖南省总公司</td>
				<td>所在部门数据</td>
				<td>
					<a href="roleAssign.html">分配</a>
					<a href="roleAdd.html">修改</a>
					<a href="#" onclick="return confirmx('确认要删除该角色吗？', this.href)">删除</a>
				</td>	
			</tr>
		
			<tr>
				<td><a href="#">部门管理员</a></td>
				<td>湖南省总公司</td>
				<td>所在部门及以下数据</td>
				<td>
					<a href="roleAssign.html">分配</a>
					<a href="roleAdd.html">修改</a>
					<a href="#" onclick="return confirmx('确认要删除该角色吗？', this.href)">删除</a>
				</td>	
			</tr>
		
			<tr>
				<td><a href="#">公司管理员</a></td>
				<td>公司领导</td>
				<td>所在公司及以下数据</td>
				<td>
					<a href="roleAssign.html">分配</a>
					<a href="roleAdd.html">修改</a>
					<a href="#" onclick="return confirmx('确认要删除该角色吗？', this.href)">删除</a>
				</td>	
			</tr>
		
			<tr>
				<td><a href="#">本公司管理员</a></td>
				<td>公司领导</td>
				<td>所在公司数据</td>
				<td>
					<a href="roleAssign.html">分配</a>
					<a href="roleAdd.html">修改</a>
					<a href="#" onclick="return confirmx('确认要删除该角色吗？', this.href)">删除</a>
				</td>	
			</tr>
		
			<tr>
				<td><a href="#">系统管理员</a></td>
				<td>公司领导</td>
				<td>所有数据</td>
				<td>
					<a href="roleAssign.html">分配</a>
					<a href="roleAdd.html">修改</a>
					<a href="#" onclick="return confirmx('确认要删除该角色吗？', this.href)">删除</a>
				</td>	
			</tr>
		
			<tr>
				<td><a href="#">长沙市管理员</a></td>
				<td>公司领导</td>
				<td>按明细设置</td>
				<td>
					<a href="roleAssign.html">分配</a>
					<a href="roleAdd.html">修改</a>
					<a href="#" onclick="return confirmx('确认要删除该角色吗？', this.href)">删除</a>
				</td>	
			</tr>
		
	</table>
</body>
</html>