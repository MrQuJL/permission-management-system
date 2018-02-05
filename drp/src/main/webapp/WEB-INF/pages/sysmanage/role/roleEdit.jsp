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
	<script type="text/javascript">
		$(document).ready(function(){
			$("#name").focus();
			$("#saveRoleForm").validate({
				submitHandler: function(form){
					// 序列化表单数据
					var jsonObj = {};
					var obj = $("#saveRoleForm").serializeArray();
					$.each(obj,function(i,item){
						jsonObj[item.name] = item.value;
					});
					jsonObj = JSON.stringify(jsonObj);
					
					// 使用数组来接收选中的节点
					var menuIds = [], nodes = tree.getCheckedNodes(true);
					for(var i=0; i<nodes.length; i++) {
						menuIds.push(nodes[i].id);
					}
					menuIds = JSON.stringify(menuIds);
					console.log(menuIds);
					
					var deptIds = [], nodes2 = tree2.getCheckedNodes(true);
					for(var i=0; i<nodes2.length; i++) {
						deptIds.push(nodes2[i].id);
					}
					deptIds = JSON.stringify(deptIds);
					console.log(deptIds);
					
					var areaIds = [], nodes3 = tree3.getCheckedNodes(true);
					for(var i=0; i<nodes3.length; i++) {
						areaIds.push(nodes3[i].id);
					}
					areaIds = JSON.stringify(areaIds);
					console.log(areaIds);
					
					loading('正在提交，请稍等...');
					
					$.ajax({
						type : "post",
						url : "${ctx}/sysmgr/saveRole.action",
						data : {"menuIds" : menuIds, "deptIds" : deptIds, "areaIds" : areaIds, "jsonObj" : jsonObj},
						dataType : "json",
						success : function(data){
							alert(data.message);
							top.$.jBox.closeTip();
						}
					});
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});

			var setting = {check:{enable:true,nocheckInherit:true},view:{selectedMulti:false},
					data:{simpleData:{enable:true}},callback:{beforeClick:function(id, node){
						tree.checkNode(node, !node.checked, true, true);
						return false;
					}}};
			
			// 用户-菜单
			var zNodes=[
				<c:forEach items="${menuList}" var="menu">
					{id:"${menu.id}", pId:"${menu.parentId}", name:"${menu.name}"},
				</c:forEach>
		    ];
			// 初始化树结构
			var tree = $.fn.zTree.init($("#menuTree"), setting, zNodes);
			// 默认选择节点
			<c:forEach items="${role.menuList}" var="menu">
				var node = tree.getNodeByParam("id", "${menu.id}");
				try{tree.checkNode(node, true, false);}catch(e){}
			</c:forEach>
			// 默认展开全部节点
			tree.expandAll(true);
			
			// 用户-部门
			var zNodes2=[
				<c:forEach items="${deptList}" var="dept">
					{id:"${dept.id}", pId:"${dept.parentId}", name:"${dept.name}"},
				</c:forEach>
		    ];
			// 初始化树结构
			var tree2 = $.fn.zTree.init($("#deptTree"), setting, zNodes2);
			// 默认选择节点
			<c:forEach items="${role.deptList}" var="dept">
				var node = tree2.getNodeByParam("id", "${dept.id}");
				try{tree.checkNode(node, true, false);}catch(e){}
			</c:forEach>
			// 默认展开全部节点
			tree2.expandAll(true);
			
			// 用户-区域
			var zNodes3=[
				<c:forEach items="${areaList}" var="area">
					{id:"${area.id}", pId:"${area.parentId}", name:"${area.name}"},
				</c:forEach>
		    ];
			// 初始化树结构
			var tree3 = $.fn.zTree.init($("#areaTree"), setting, zNodes3);
			// 默认选择节点
			<c:forEach items="${role.areaList}" var="area">
				var node = tree3.getNodeByParam("id", "${area.id}");
				try{tree.checkNode(node, true, false);}catch(e){}
			</c:forEach>
			// 默认展开全部节点
			tree3.expandAll(true);
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sysmgr/gotoRoleList.action">角色列表</a></li>
		<li class="active"><a href="javascript:void(0);">角色
			<c:choose>
				<c:when test="${editFlag == 1}">添加</c:when>
				<c:otherwise>修改</c:otherwise>
			</c:choose>
		</a></li>
	</ul><br/>
	<form id="saveRoleForm" class="form-horizontal" action="#" method="post">
		<input id="id" name="id" type="hidden" value="${role.id}"/>

		<div class="control-group">
			<label class="control-label">角色名称:</label>
			<div class="controls">
				<input id="name" name="name" class="required" type="text" value="${role.name}" maxlength="50"/>
				<span class="help-inline"><span style="color:red">*</span> </span>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">角色授权:</label>
			<div class="controls">
				<div id="menuTree" class="ztree" style="margin-top:3px;float:left;"></div>
				<div id="deptTree" class="ztree" style="margin-left:50px;margin-top:3px;float:left;"></div>
				<div id="areaTree" class="ztree" style="margin-left:50px;margin-top:3px;float:left;"></div>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<textarea id="remarks" name="remarks" maxlength="200" class="input-xlarge" rows="3">${role.remarks}</textarea>
			</div>
		</div>
		
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form>
</body>
</html>