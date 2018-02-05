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
		<li class="active"><a href="javascript:void(0);">角色列表</a></li>
		<li><a href="${ctx}/sysmgr/gotoRoleEdit.action?editFlag=1">角色添加</a></li>
	</ul>

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<tr>
			<th>名称</th>
			<th>描述</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${roleList}" var="role">
			<tr>
				<td><a href="${ctx}/sysmgr/gotoRoleEdit.action?editFlag=2&roleId=${role.id}">${role.name}</a></td>
				<td>${role.remarks}</td>
				<td>
					<a href="${ctx}/sysmgr/gotoRoleEdit.action?editFlag=2&roleId=${role.id}">修改</a>
					<a href="javascript:roleMgr.delRole(${role.id});">删除</a>
					<a href="${ctx}/sysmgr/gotoRoleEdit.action?editFlag=1">添加</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<script type="text/javascript">
		var roleMgr = {
			delRole : function(roleId) {
				if (confirm("您确定要删除该角色吗？")) {
					loading("正在提交，请稍后...");
					$.ajax({
						type : "post",
						url : "${ctx}/sysmgr/delRole.action",
						data : {"roleId" : roleId},
						dataType : "json",
						success : function(data){
							alert(data.message);
							top.$.jBox.closeTip();
							location.reload();
						}
					});
				}
			}
		}
	</script>
</body>
</html>