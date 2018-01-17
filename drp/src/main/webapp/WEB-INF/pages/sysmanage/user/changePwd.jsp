<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<title>修改密码</title>
<meta charset="utf-8" />
<meta name="renderer" content="webkit">

<%@ include file="/WEB-INF/pages/include/head.jsp" %>
<script type="text/javascript">var ctx = '', ctxStatic='/static';</script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#oldPassword").focus();
			$("#userChangePwdForm").validate({
				rules: {
				},
				messages: {
					confirmNewPassword: {equalTo: "输入与上面相同的密码"}
				},
				submitHandler: function(form){
					var oldPassword = $("#oldPassword").val();
					var newPassword = $("#newPassword").val();
					loading('正在提交，请稍等...');
					/* form.submit(); */
					// 用ajax提交
					$.ajax({
						type : "post",
						url : '${ctx}/sysmgr/saveChangePwd.action',
						data : {"oldPassword" : oldPassword, "newPassword" : newPassword},
						success : function(data) {
							// 干掉正在提交的等待框
							top.$.jBox.closeTip();
							alert(data.message);
						}
					});
					form.reset();
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
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sysmgr/userInfo.action">个人信息</a></li>
		<li class="active"><a href="javascript:void(0);">修改密码</a></li>
	</ul><br/>
	<form id="userChangePwdForm" class="form-horizontal" action="#" method="post">
		<input id="id" name="id" type="hidden" value="1"/>

		<div class="control-group">
			<label class="control-label">旧密码:</label>
			<div class="controls">
				<input id="oldPassword" name="oldPassword" type="password" value="" maxlength="50" minlength="3" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">新密码:</label>
			<div class="controls">
				<input id="newPassword" name="newPassword" type="password" value="" maxlength="50" minlength="3" class="required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">确认新密码:</label>
			<div class="controls">
				<input id="confirmNewPassword" name="confirmNewPassword" type="password" value="" maxlength="50" minlength="3" class="required" equalTo="#newPassword"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>
		</div>
	</form>
</body>
</html>