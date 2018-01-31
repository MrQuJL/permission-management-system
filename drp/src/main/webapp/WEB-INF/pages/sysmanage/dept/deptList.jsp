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
						<a href="javascript:deptMgr.confirmHasSubDept(${dept.id});">删除</a>
						<a href="#">添加下级部门</a>
					</td>
				</tr>
			</c:forEach>
			
		</tbody>
	</table>
	<script type="text/javascript">
		var deptMgr = {
			confirmHasSubDept : function(deptId) {
				$.ajax({
					type : "post",
					url : "${ctx}/sysmgr/confirmHasSubDept.action",
					data : {"deptId" : deptId},
					dataType : "json",
					success : function(data) {
						if (data.message == "yes") { // 有子部门，不能删除
							alert("该部门下面有子部门，前先删除其下的子部门，再来删除该部门！");
						} else { // 没有子部门可以删除
							deptMgr.delDept(deptId);
						}
					}
				});
			},
			delDept : function(deptId) {
				if (confirm("该部门下面没有子部门，您确定要删除该部门吗？")) {
					alert("模拟删除成功了该部门!");
				}
			}
		}
	</script>
</body>
</html>