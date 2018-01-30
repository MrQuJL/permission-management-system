<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<title>部门管理</title>
	
<meta charset="utf-8" />
<%@ include file="/WEB-INF/pages/include/head.jsp" %>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
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
		});
	</script>
	<script type="text/javascript">top.$.jBox.closeTip();</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sysmgr/gotoDeptList.action">部门列表</a></li>
		<li class="active"><a href="javascript:void(0);">部门添加</a></li>
	</ul><br/>
	
	<form id="inputForm" class="form-horizontal" action="#" method="post">
		<input id="id" name="id" type="hidden" value="${dept.id}"/>

		<div class="control-group">
			<label class="control-label">上级部门:</label>
			<div class="controls">
				<div class="input-append">
					<input id="parentId" name="parentId" class="" type="hidden" value="${dept.parentId}"/>
					<input id="parentName" name="parentName" readonly="readonly" type="text" value="${dept.parentName}"/>
					<a id="officeButton" href="javascript:" class="btn  " style="">
						&nbsp;<i class="icon-search"></i>&nbsp;
					</a>&nbsp;&nbsp;
				</div>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label">部门名称:</label>
			<div class="controls">
				<input id="name" name="name" class="required" type="text" value="${dept.name}" maxlength="50"/>
				<span class="help-inline"><span style="color:red">*</span></span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">排序:</label>
			<div class="controls">
				<input id="sort" name="sort" class="required" type="text" value="${dept.sort}" maxlength="50"/>
				<span class="help-inline"><span style="color:red">*</span>排列顺序，升序。</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">机构编号:</label>
			<div class="controls">
				<input id="code" name="code" type="text" value="${dept.code}" maxlength="50"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">部门地址:</label>
			<div class="controls">
				<input id="address" name="address" type="text" value="${dept.address}" maxlength="50"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">负责人:</label>
			<div class="controls">
				<input id="master" name="master" type="text" value="${dept.master}" maxlength="50"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电话:</label>
			<div class="controls">
				<input id="phone" name="phone" type="text" value="${dept.phone}" maxlength="50"/>
				<span class="help-inline"></span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">传真:</label>
			<div class="controls">
				<input id="fax" name="fax" type="text" value="${dept.fax}" maxlength="50"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">邮箱:</label>
			<div class="controls">
				<input id="email" name="email" type="text" value="${dept.email}" maxlength="50"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<textarea id="remarks" name="remarks" maxlength="200" class="input-xlarge" rows="3">${dept.remarks}</textarea>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form>
</body>
</html>
