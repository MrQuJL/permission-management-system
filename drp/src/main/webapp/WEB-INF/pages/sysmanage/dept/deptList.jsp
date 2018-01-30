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
				<th>机构名称</th>
				<th>所属区域</th>
				<th>机构编码</th>
				<th>机构类型</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="treeTableList">
			
			<tr id="1" pId="0">
				<td><a href="#">湖南省总公司</a></td>
				<td>湖南省</td>
				<td>100000</td>
				<td>公司</td>
				<td></td>
				<td>
					<a href="officeAdd.html">修改</a>
					<a href="#" onclick="return confirmx('要删除该机构及所有子机构项吗？', this.href)">删除</a>
					<a href="officeAdd.html">添加下级机构</a>
				</td>
			</tr>
		
			<tr id="2" pId="1">
				<td><a href="#">公司领导</a></td>
				<td>湖南省</td>
				<td>100001</td>
				<td>部门</td>
				<td></td>
				<td>
					<a href="officeAdd.html">修改</a>
					<a href="#" onclick="return confirmx('要删除该机构及所有子机构项吗？', this.href)">删除</a>
					<a href="officeAdd.html">添加下级机构</a>
				</td>
			</tr>
		
			<tr id="3" pId="1">
				<td><a href="#">综合部</a></td>
				<td>湖南省</td>
				<td>100002</td>
				<td>部门</td>
				<td></td>
				<td>
					<a href="officeAdd.html">修改</a>
					<a href="#" onclick="return confirmx('要删除该机构及所有子机构项吗？', this.href)">删除</a>
					<a href="officeAdd.html">添加下级机构</a>
				</td>
			</tr>
		
			
		
			<tr id="7" pId="1">
				<td><a href="#">长沙市分公司</a></td>
				<td>长沙市</td>
				<td>200000</td>
				<td>公司</td>
				<td></td>
				<td>
					<a href="officeAdd.html">修改</a>
					<a href="#" onclick="return confirmx('要删除该机构及所有子机构项吗？', this.href)">删除</a>
					<a href="officeAdd.html">添加下级机构</a>
				</td>
			</tr>
		
			<tr id="8" pId="7">
				<td><a href="#">公司领导</a></td>
				<td>长沙市</td>
				<td>200001</td>
				<td>部门</td>
				<td></td>
				<td>
					<a href="officeAdd.html">修改</a>
					<a href="#" onclick="return confirmx('要删除该机构及所有子机构项吗？', this.href)">删除</a>
					<a href="officeAdd.html">添加下级机构</a>
				</td>
			</tr>
		
			<tr id="9" pId="7">
				<td><a href="#">综合部</a></td>
				<td>长沙市</td>
				<td>200002</td>
				<td>部门</td>
				<td></td>
				<td>
					<a href="officeAdd.html">修改</a>
					<a href="#" onclick="return confirmx('要删除该机构及所有子机构项吗？', this.href)">删除</a>
					<a href="officeAdd.html">添加下级机构</a>
				</td>
			</tr>
		
			
		
			<tr id="12" pId="7">
				<td><a href="#">芙蓉区分公司</a></td>
				<td>芙蓉区</td>
				<td>201000</td>
				<td>公司</td>
				<td></td>
				<td>
					<a href="officeAdd.html">修改</a>
					<a href="#" onclick="return confirmx('要删除该机构及所有子机构项吗？', this.href)">删除</a>
					<a href="officeAdd.html">添加下级机构</a>
				</td>
			</tr>
		
			<tr id="13" pId="12">
				<td><a href="#">公司领导</a></td>
				<td>芙蓉区</td>
				<td>201001</td>
				<td>部门</td>
				<td></td>
				<td>
					<a href="officeAdd.html">修改</a>
					<a href="#" onclick="return confirmx('要删除该机构及所有子机构项吗？', this.href)">删除</a>
					<a href="officeAdd.html">添加下级机构</a>
				</td>
			</tr>
		
			<tr id="14" pId="12">
				<td><a href="#">综合部</a></td>
				<td>芙蓉区</td>
				<td>201002</td>
				<td>部门</td>
				<td></td>
				<td>
					<a href="officeAdd.html">修改</a>
					<a href="#" onclick="return confirmx('要删除该机构及所有子机构项吗？', this.href)">删除</a>
					<a href="officeAdd.html">添加下级机构</a>
				</td>
			</tr>
			
		</tbody>
	</table>
</body>
</html>