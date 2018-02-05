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
			$("#inputForm").validate({
				submitHandler: function(form){
					var ids = [], nodes = tree.getCheckedNodes(true);
					for(var i=0; i<nodes.length; i++) {
						ids.push(nodes[i].id);
					}
					$("#menuIds").val(ids);
					var ids2 = [], nodes2 = tree2.getCheckedNodes(true);
					for(var i=0; i<nodes2.length; i++) {
						ids2.push(nodes2[i].id);
					}
					$("#deptIds").val(ids2);
					loading('正在提交，请稍等...');
					form.submit();
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
			// 不选择父节点
			// tree.setting.check.chkboxType = { "Y" : "ps", "N" : "s" };
			// 默认选择节点
			var ids = "".split(",");
			for(var i=0; i<ids.length; i++) {
				var node = tree.getNodeByParam("id", ids[i]);
				try{tree.checkNode(node, true, false);}catch(e){}
			}
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
			// 不选择父节点
			// tree2.setting.check.chkboxType = { "Y" : "ps", "N" : "s" };
			// 默认选择节点
			var ids2 = "".split(",");
			for(var i=0; i<ids2.length; i++) {
				var node = tree2.getNodeByParam("id", ids2[i]);
				try{tree2.checkNode(node, true, false);}catch(e){}
			}
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
			// 不选择父节点
			// tree2.setting.check.chkboxType = { "Y" : "ps", "N" : "s" };
			// 默认选择节点
			var ids3 = "".split(",");
			for(var i=0; i<ids3.length; i++) {
				var node = tree3.getNodeByParam("id", ids3[i]);
				try{tree3.checkNode(node, true, false);}catch(e){}
			}
			// 默认展开全部节点
			tree3.expandAll(true);
			
		});
	</script>
	<script type="text/javascript">top.$.jBox.closeTip();</script>
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
	<form id="inputForm" class="form-horizontal" action="#" method="post">
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