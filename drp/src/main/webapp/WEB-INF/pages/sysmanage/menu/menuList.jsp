<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<title>菜单管理</title>
<meta charset="utf-8" />
<meta name="renderer" content="webkit">
<%@ include file="/WEB-INF/pages/include/head.jsp" %>
<link href="static/treeTable/themes/vsStyle/treeTable.min.css" rel="stylesheet" type="text/css" />
<script src="static/treeTable/jquery.treeTable.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(function() {
			$("#treeTable").treeTable({expandLevel : 3}).show();
		});
		var menuMgr = {
			// 确认是否有子菜单
			confirmHasSubMenu : function(menuId) {
				$.ajax({
					type : "post",
					url : "${ctx}/sysmgr/confirmHasSubMenu.action",
					data : {"menuId" : menuId},
					dataType : "json",
					success : function(data) {
						if (data.message == "yes") { // 有子菜单不能删除
							alert("当前菜单还有子菜单，若想删除该菜单，请先手动删除其下面的子菜单!");
						} else { // 没有子菜单，可以删除
							if (confirm("您确定要删除当前菜单?")) {
								menuMgr.delMenu(menuId);
							}
						}
					}
				});
			},
			// 删除菜单
			delMenu : function(menuId) {
				$.ajax({
					type : "post",
					url : "${ctx}/sysmgr/delMenu.action",
					data : {"menuId" : menuId},
					dataType : "json",
					success : function(data) {
						alert(data.message);
						location.reload();
					}
				});
			}
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="javascript:void(0);">菜单列表</a></li>
		<li><a href="${ctx}/sysmgr/gotoMenuEdit.action?editFlag=1">菜单添加</a></li>
	</ul>
	
	<form id="listForm" method="post">
		<table id="treeTable" class="table table-striped table-bordered table-condensed hide">
			<thead>
				<tr>
					<th>名称</th>
					<th>链接</th>
					<th style="text-align:center;">排序</th>
					<th>可见</th>
					<th>权限标识</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${menuList}" var="menu">
					<tr id="${menu.id}" pId="${menu.parentId}">
						<td nowrap>
							<i class="${not empty menu.icon?menu.icon:'hide'}"></i>
							<a href="${ctx}/sysmgr/gotoMenuEdit.action?editFlag=2&menuId=${menu.id}">${menu.name}</a>
						</td>
						<td title="${menu.href}">${menu.href}</td>
						<td style="text-align:center;">
							${menu.sort}
						</td>
						<td>
							<c:choose>
								<c:when test="${menu.isShow==1}">
									显示
								</c:when>
								<c:otherwise>不显示</c:otherwise>
							</c:choose>
						</td>
						<td title="${menu.permission}">${menu.permission}</td>
						<td nowrap>
							<a href="${ctx}/sysmgr/gotoMenuEdit.action?editFlag=2&menuId=${menu.id}">修改</a>
							<a href="javascript:menuMgr.confirmHasSubMenu(${menu.id})">删除</a>
							<a href="${ctx}/sysmgr/gotoMenuEdit.action?editFlag=1&parentId=${menu.id}">添加下级菜单</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="form-actions pagination-left">
			<input id="btnSubmit" class="btn btn-primary" type="button" value="保存排序" onclick="updateSort();"/>
		</div>
	 </form>
</body>
</html>