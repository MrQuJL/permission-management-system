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
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="javascript:void(0);">区域列表</a></li>
		<li><a href="${ctx}/sysmgr/gotoAreaEdit.action?editFlag=1">区域添加</a></li>
	</ul>

<script type="text/javascript">top.$.jBox.closeTip();</script>

	<table id="treeTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>区域名称</th><th>区域编码</th><th>区域类型</th><th>备注</th><th>操作</th></tr></thead>
		<tbody id="treeTableList">
			
				<tr id="1" pId="0">
					<td><a href="#">中国</a></td>
					<td>086</td>
					<td>国家</td>
					<td></td>
					<td>
						<a href="areaAdd.html">修改</a>
						<a href="#" onclick="return confirmx('要删除该区域及所有子区域项吗？', this.href)">删除</a>
						<a href="areaAdd.html">添加下级区域</a>
					</td>
				</tr>
			
				<tr id="2" pId="1">
					<td><a href="#">湖南省</a></td>
					<td>430000</td>
					<td>省份、直辖市</td>
					<td></td>
					<td>
						<a href="areaAdd.html">修改</a>
						<a href="#" onclick="return confirmx('要删除该区域及所有子区域项吗？', this.href)">删除</a>
						<a href="areaAdd.html">添加下级区域</a>
					</td>
				</tr>
			
				<tr id="3" pId="2">
					<td><a href="#">长沙市</a></td>
					<td>430100</td>
					<td>地市</td>
					<td></td>
					<td>
						<a href="areaAdd.html">修改</a>
						<a href="#" onclick="return confirmx('要删除该区域及所有子区域项吗？', this.href)">删除</a>
						<a href="areaAdd.html">添加下级区域</a>
					</td>
				</tr>
			
				<tr id="4" pId="3">
					<td><a href="#">芙蓉区</a></td>
					<td>430102</td>
					<td>区县</td>
					<td></td>
					<td>
						<a href="areaAdd.html">修改</a>
						<a href="#" onclick="return confirmx('要删除该区域及所有子区域项吗？', this.href)">删除</a>
						<a href="areaAdd.html">添加下级区域</a>
					</td>
				</tr>
			
		</tbody>
	</table>

</body>
</html>