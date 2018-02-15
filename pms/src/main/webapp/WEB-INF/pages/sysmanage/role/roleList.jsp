<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<!doctype html>
<html>
<head>
	<meta http-equiv='Content-Type' content='text/html;charset=utf-8'>
	<title>角色管理</title>
	<meta name='keywords' content='权限管理'>
	<meta name='description' content='菜单，部门，区域等资源权限于一体的按钮级权限管理系统'>
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