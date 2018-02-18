<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<!doctype html>
<html>
<head>
	<meta http-equiv='Content-Type' content='text/html;charset=utf-8'>
	<title>用户信息页面</title>
	<meta name='keywords' content='权限管理'>
	<meta name='description' content='菜单，部门，区域等资源权限于一体的按钮级权限管理系统'>
	<%@ include file="/WEB-INF/pages/include/head.jsp" %>
	<script type="text/javascript">
		// 封装了一些对用户操作的函数
		var userInfoMgr = {
			// 加载用户的个人信息
			init : function() {
				loading("正在加载用户个人信息...");
				$.ajax({
					type : "post",
					url : "${ctx}/sysmgr/getUserInfoById.action",
					data : {},
					dataType : "json",
					success : function(data) {
						data = JSON.parse(data.jsonObj);
						$("#deptName").html(data.name);
						$("#loginName").html(data.loginName);
						$("#userId").val(data.userId);
						$("#userName").val(data.userName);
						$("#userNo").val(data.userNo);
						$("#email").val(data.email);
						$("#phone").val(data.phone);
						$("#mobile").val(data.mobile);
						$("#remarks").val(data.remarks);
						
						var roleList = data.roleList;
						var roleContent = "";
						for (var i = 0; i < roleList.length; i++) {
							if (i != roleList.length - 1) {
								roleContent = roleContent + roleList[i].name + ","; 
							} else {
								roleContent = roleContent + roleList[i].name; 
							}
						}
						$("#roleList").text(roleContent);
						
						top.$.jBox.closeTip();
					}
				});
			},
			// 保存(修改)用户的个人信息
			saveUserInfo : function() {
				// 1.将表单中的所有元素通过$.each函数封装成一个json字符串
				var jsonObj = {};
				var formArray = $("#userInfoChangeForm").serializeArray();
				$.each(formArray,function(i, item) {
					if (item.name != "userNo") {
						jsonObj[item.name] = item.value;
					}
				});
				jsonObj = JSON.stringify(jsonObj);
				// 2.通过ajax异步发往后台
				$.ajax({
					type : "post",
					url : "${ctx}/sysmgr/saveUserInfo.action",
					data : {"jsonObj" : jsonObj},
					dataType : "json",
					success : function(data) {
						alert(data.message);							
					},
					complete : function() {
						// 修改完了用户信息之后重新加载一下用户数据
						userInfoMgr.init();
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
				<input id="userNo" name="userNo" readonly class="required" type="text"  maxlength="50"/>
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
				<label class="lbl" id="roleList"></label>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="button" onclick="userInfoMgr.saveUserInfo();" value="保 存"/>
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