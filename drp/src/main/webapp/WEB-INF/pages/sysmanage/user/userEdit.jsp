<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<title>用户管理</title>
<meta charset="utf-8" />
<meta name="renderer" content="webkit">
<%@ include file="/WEB-INF/pages/include/head.jsp" %>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#value").focus();
			$("#userSaveChangeForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					var obj = $("#userSaveChangeForm").serializeArray();
					var jsonObj = {};
					$.each(obj, function(i, item) {
						if (item.name != "deptName" && item.name != "role") {
							jsonObj[item.name] = item.value;
						}
					});
					jsonObj = JSON.stringify(jsonObj);
					alert(jsonObj);
					
					var roleIds = new Array();
					$('input[name="role"]:checked').each(function(){  
						roleIds.push($(this).val());//向数组中添加元素
					});  
					//var idstr=roleIds.join(',');//将数组元素连接起来以构建一个字符串  
					roleIds = JSON.stringify(roleIds);
					
					$.ajax({
						type : "post",
						url : "${ctx}/sysmgr/saveUserInfo.action",
						data : {"jsonObj" : jsonObj, "roleIds" : roleIds},
						dataType : "json",
						success : function(data) {
							top.$.jBox.closeTip();
							alert(data.message);
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
		});
		var userMgr = {
			// 删除用户
			delUser :function() {
				
			}
		};
	</script>
	<script type="text/javascript">
		var setting = {
			view: {
				dblClickExpand: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeClick: beforeClick,
				onClick: onClick
			}
		};

		// 点击之前会触发的事件
		function beforeClick(treeId, treeNode) {
			
		};
		
		// 选中某个菜单项后会触发的操作
		function onClick(e, treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("deptTree");
			
			nodes = zTree.getSelectedNodes();
			var parentName = "";
			var parentId = "";
			
			nodes.sort(function compare(a,b){return a.id-b.id;});
			for (var i=0, l=nodes.length; i<l; i++) {
				parentName += nodes[i].name + ",";
				parentId += nodes[i].id + ",";
			}
			if (parentName.length > 0 ) parentName = parentName.substring(0, parentName.length-1);
			$("#deptName").attr("value", parentName);
			
			if (parentId.length > 0 ) parentId = parentId.substring(0, parentId.length-1);
			$("#deptId").attr("value", parentId);
			
			hideDept();
		};
		
		function showDept() {
			var parent = $("#deptName");
			var parentOffset = $("#deptName").offset();
			$("#deptContent").css({left:parentOffset.left + "px",
				top:parentOffset.top + parent.outerHeight() + "px"}).slideToggle("fast");
			$("html").bind("click", onBodyDown);
		};
		
		function hideDept() {
			$("#deptContent").slideToggle("fast");
			$("html").unbind("click", onBodyDown);
		};
		
		function onBodyDown(event) {
			if (!(event.target.id == "deptButton" || event.target.id == "deptName" ||
				event.target.id == "deptContent" || $(event.target).parents("#deptContent").length>0)) {
				hideDept();
			}
		};
		
		$(document).ready(function(){
			// 页面一刷新就加载zTree
			$.ajax({
				type : "post",
				url : "${ctx}/sysmgr/loadDeptTree.action",
				// 设为同步的，否则数据加载完成了无法赋值给页面
				async : false,
				dataType : "json",
				success : function(data) {
					var deptArray = JSON.parse(data.jsonObj);
					var deptTree = $.fn.zTree.init($("#deptTree"), setting, deptArray);
					deptTree.expandAll(true);
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sysmgr/gotoUserList.action">用户列表</a></li>
		<li class="active"><a href="javascript:void(0);">用户
			<c:choose>
				<c:when test="${editFlag == 1}">新增</c:when>
				<c:otherwise>修改</c:otherwise>
			</c:choose>
		</a></li>
	</ul><br/>
	<form id="userSaveChangeForm" class="form-horizontal" action="#" method="post">
		<input id="id" name="userId" type="hidden" value="${user.id}"/>
		
		<div class="control-group">
			<label class="control-label">部门名称:</label>
			<div class="controls">
				<div class="input-append">
					<input id="deptId" name="deptId" class="" type="hidden" value="${deptDto.parentId}"/>
					<input id="deptName" name="deptName" class="required" readonly="readonly" type="text" value="${deptDto.parentName}"/>
					<a id="deptBtn" href="javascript:showDept();" class="btn">
						&nbsp;<i class="icon-search"></i>&nbsp;
					</a>&nbsp;&nbsp;
				</div>
				
				<!-- zTree -->
				<div id="deptContent" class="deptContent" style="display:none; position:absolute;">
					<ul id="deptTree" class="ztree" style="margin-top:0; 
						background-color:rgb(243,243,243); width:260px;">
					</ul>
				</div>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">工号:</label>
			<div class="controls">
				<input id="userNo" name="userNo" class="required" type="text" value="${user.value}" maxlength="50"/>
				<span class="help-inline"><span style="color:red">*</span> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">姓名:</label>
			<div class="controls">
				<input id="userName" name="userName" class="required" type="text" value="${user.label}" maxlength="50"/>
				<span class="help-inline"><span style="color:red">*</span> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">登录名:</label>
			<div class="controls">
				<input id="loginName" name="loginName" class="required abc" type="text" value="${user.type}" maxlength="50"/>
				<span class="help-inline"><span style="color:red">*</span> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">邮箱:</label>
			<div class="controls">
				<input id="email" name="email" type="text" value="${user.description}" maxlength="50"/>
				<span class="help-inline"><span style="color:red"></span> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电话:</label>
			<div class="controls">
				<input id="phone" name="phone" class="digits" type="text" value="${user.sort}" maxlength="11"/>
				<span class="help-inline"><span style="color:red"></span> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">手机:</label>
			<div class="controls">
				<input id="mobile" name="mobile" type="text" value="${user.value}" maxlength="50"/>
				<span class="help-inline"><span style="color:red"></span> </span>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">角色:</label>
			<div class="controls">
				<c:forEach items="${roleList}" var="role">
					<label>
			      		<input name="role" type="checkbox" value="${role.id}"> ${role.name}
			    	</label>
				</c:forEach>
			</div>
	  	</div>
		
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<textarea id="remarks" name="remarks" maxlength="200" class="input-xlarge" rows="3">${user.remarks}</textarea>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form>
</body>
</html>