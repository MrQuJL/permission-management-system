<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<title>用户信息页面</title>
	<meta charset="utf-8" />
	<meta name="renderer" content="webkit">
	<%@ include file="/WEB-INF/pages/include/head.jsp" %>
	<script type="text/javascript">
		$(function() {
			$("#userInfoChangeForm").validate({
				submitHandler: function(form){
					loading('......');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("......");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
		var userInfoMgr = {
			init : function() {
				$.ajax({
					type : "post",
					url : "${ctx}/sysmgr/getUserInfoById.action",
					data : {},
					dataType : "json",
					success : function(data) {
						alert(JSON.stringify(data));
						data = JSON.parse(data.jsonObj);
						$("#deptName").html(data.name);
						$("#loginName").html(data.loginName);
						
						$("#userName").val(data.userName);
						$("#userNo").val(data.userNo);
						$("#email").val(data.email);
						$("#phone").val(data.phone);
						$("#mobile").val(data.mobile);
						$("#remarks").val(data.remarks);
					}
				});
			}
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="javascript:void(0);">个人信息</a></li>
		<li><a href="${ctx}/sysmgr/changePwd.action">修改密码</a></li>
	</ul><br/>
	<form id="userInfoChangeForm" class="form-horizontal" action="#" method="post">
	<script type="text/javascript">top.$.jBox.closeTip();</script>
		<input type = "hidden" id = "userId" name = "userId"/>
		
		<div class="control-group">
			<label class="control-label">所属部门:</label>
			<div class="controls">
				<label class="lbl" id="deptName"></label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">登陆名称:</label>
			<div class="controls">
				<!-- <input id="loginName" name="loginName" class="required" readonly="readonly" type="text"  maxlength="50"/> -->
				<label class="lbl" id="loginName"></label>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用户名称:</label>
			<div class="controls">
				<input id="userName" name="userName" class="required" type="text" value="" maxlength="50"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">工号:</label>
			<div class="controls">
				<input id="userNo" name="userNo" class="required" type="text"  maxlength="50"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">邮箱:</label>
			<div class="controls">
				<input id="email" name="email" class="email" type="text" value="" maxlength="50"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电话:</label>
			<div class="controls">
				<input id="phone" name="phone" type="text" value="" maxlength="50"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">手机:</label>
			<div class="controls">
				<input id="mobile" name="mobile" type="text" value="" maxlength="50"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<textarea id="remarks" name="remarks" maxlength="200" class="input-xlarge" rows="3"></textarea>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">用户角色:</label>
			<div class="controls">
				<label class="lbl">公司管理员,系统管理员</label>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>
		</div>
	</form>
	<%-- 页面加载完毕，就初始化组件信息 --%>
	<script type="text/javascript">
		$(document).ready(function() {
			userInfoMgr.init();
		});
	</script>
</body>
</html>