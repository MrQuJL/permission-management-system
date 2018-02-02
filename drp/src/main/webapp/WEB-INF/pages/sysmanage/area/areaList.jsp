<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<title>区域管理</title>
	
<meta charset="utf-8" />
<meta name="renderer" content="webkit">
<%@ include file="/WEB-INF/pages/include/head.jsp"%>
	<script type="text/javascript">
		$(function() {
			$("#treeTable").treeTable({expandLevel : 5});
		});

	</script>
	<script type="text/javascript">top.$.jBox.closeTip();</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="javascript:void(0);">区域列表</a></li>
		<li><a href="${ctx}/sysmgr/gotoAreaEdit.action?editFlag=1">区域添加</a></li>
	</ul>

	<table id="treeTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>区域名称</th>
				<th>排序</th>
				<th>编码</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="treeTableList">
			
			<c:forEach items="${areaList}" var="area">
				<tr id="${area.id}" pId="${area.parentId}">
					<td><a href="#">${area.name}</a></td>
					<td>${area.sort}</td>
					<td>${area.code}</td>
					<td>${area.remarks}</td>
					<td>
						<a href="${ctx}/sysmgr/gotoAreaEdit.action?editFlag=2&areaId=${area.id}">修改</a>
						<a href="#" onclick="">删除</a>
						<a href="${ctx}/sysmgr/gotoAreaEdit.action?editFlag=1&areaId=${area.id}">添加下级区域</a>
					</td>
				</tr>
			</c:forEach>
				
		</tbody>
	</table>

</body>
</html>