<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<!doctype html>
<html>
<head>
	<meta http-equiv='Content-Type' content='text/html;charset=utf-8'>
	<title>字典管理</title>
	<meta name='keywords' content='权限管理'>
	<meta name='description' content='菜单，部门，区域等资源权限于一体的按钮级权限管理系统'>
	<%@ include file="/WEB-INF/pages/include/head.jsp" %>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#value").focus();
			$("#dictSaveChangeForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					var obj = $("#dictSaveChangeForm").serializeArray();
					var jsonObj = {};
					$.each(obj, function(i, item) {
						jsonObj[item.name] = item.value;
					});
					jsonObj = JSON.stringify(jsonObj);
					$.ajax({
						type : "post",
						url : "${ctx}/sysmgr/saveDict.action",
						data : {"jsonObj" : jsonObj},
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
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sysmgr/gotoDictList.action">字典列表</a></li>
		<li class="active"><a href="javascript:void(0);">字典编辑</a></li>
	</ul><br/>
	<form id="dictSaveChangeForm" class="form-horizontal" action="#" method="post">
		<input id="id" name="id" type="hidden" value="${dict.id}"/>

		<div class="control-group">
			<label class="control-label">键值:</label>
			<div class="controls">
				<input id="value" name="value" class="required" type="text" value="${dict.value}" maxlength="50"/>
				<span class="help-inline"><span style="color:red">*</span> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">标签:</label>
			<div class="controls">
				<input id="label" name="label" class="required" type="text" value="${dict.label}" maxlength="50"/>
				<span class="help-inline"><span style="color:red">*</span> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">类型:</label>
			<div class="controls">
				<input id="type" name="type" class="required abc" type="text" value="${dict.type}" maxlength="50"/>
				<span class="help-inline"><span style="color:red">*</span> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">描述:</label>
			<div class="controls">
				<input id="description" name="description" class="required" type="text" value="${dict.description}" maxlength="50"/>
				<span class="help-inline"><span style="color:red">*</span> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">排序:</label>
			<div class="controls">
				<input id="sort" name="sort" class="required digits" type="text" value="${dict.sort}" maxlength="11"/>
				<span class="help-inline"><span style="color:red">*</span> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<textarea id="remarks" name="remarks" maxlength="200" class="input-xlarge" rows="3">${dict.remarks}</textarea>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form>
</body>
</html>