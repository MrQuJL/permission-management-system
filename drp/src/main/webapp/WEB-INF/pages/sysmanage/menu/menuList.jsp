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
    	function updateSort() {
			loading('正在提交，请稍等...');
	    	$("#listForm").attr("action", "#");
	    	$("#listForm").submit();
    	}
	</script>
	<script type="text/javascript">top.$.jBox.closeTip();</script>
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
				<!--
				<tr id="27" pId="0">
					<td nowrap><i class="icon- hide"></i><a href="#">我的面板</a></td>
					<td title=""></td>
					<td style="text-align:center;">
						
						<input type="hidden" name="ids" value="27"/>
						<input name="sorts" type="text" value="10" style="width:50px;margin:0;padding:0;text-align:center;">
						
					</td>
					<td>显示</td>
					<td title=""></td>
					<td nowrap>
						<a href="menuAdd.html">修改</a>
						<a href="#" onclick="return confirmx('要删除该菜单及所有子菜单项吗？', this.href)">删除</a>
						<a href="menuAdd.html">添加下级菜单</a>
					</td>
				</tr>
				-->
				<c:forEach items="${menuList}" var="menu">
					<tr id="${menu.id}" pId="${menu.parentId}">
						<td nowrap>
							<i class="icon-${not empty menu.icon?menu.icon:'hide'}"></i>
							<a href="${ctx}/sysmgr/gotoMenuEdit.action?id=${menu.id}">${menu.name}</a>
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
							<a href="javascript:menuMgr.delMenu(${menu.id})">删除</a>
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