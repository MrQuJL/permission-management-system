<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<%
String path = request.getContextPath();
%>
<!doctype html>
<html>
<head>
	<title>部门管理</title>
	
<meta charset="utf-8" />
<%@ include file="/WEB-INF/pages/include/head.jsp" %>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#treeTable").treeTable({expandLevel : 5});
		});
	</script>
	<script type="text/javascript">top.$.jBox.closeTip();</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="javascript:void(0);">部门列表</a></li>
		<li><a href="${ctx}/sysmgr/gotoDeptEdit.action?editFlag=1">部门添加</a></li>
	</ul>

	<table id="treeTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>名称</th>
				<th>编号</th>
				<th>负责人</th>
				<th>电话</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="treeTableList">
			
			<c:forEach items="${deptList}" var="dept">
				<tr id="${dept.id}" pId="${dept.parentId}">
					<td><a href="${ctx}/sysmgr/gotoDeptEdit.action?editFlag=2&deptId=${dept.id}">${dept.name}</a></td>
					<td>${dept.code}</td>
					<td>${dept.master}</td>
					<td>${dept.phone}</td>
					<td>${dept.remarks}</td>
					<td>
						<a href="${ctx}/sysmgr/gotoDeptEdit.action?editFlag=2&deptId=${dept.id}">修改</a>
						<a href="#" onclick="">删除</a>
						<a href="#">添加下级部门</a>
					</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
	<script type="text/javascript">
		
	</script>
</body>
</html>