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
<%@ include file="/WEB-INF/pages/include/head.jsp" %>
<meta name="renderer" content="webkit">
	<meta name="decorator" content="default"/>
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
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sysmgr/gotoAreaList.action">区域列表</a></li>
		<li class="active"><a href="javascript:void(0);">
			区域
			<c:choose>
				<c:when test="editFlag == 1">添加</c:when>	
				<c:otherwise>修改</c:otherwise>
			</c:choose>
		</a></li>
	</ul><br/>
	<form id="inputForm" class="form-horizontal" action="#" method="post">
		<input id="id" name="id" type="hidden" value=""/>

<script type="text/javascript">top.$.jBox.closeTip();</script>

		<div class="control-group">
			<label class="control-label">上级区域:</label>
			<div class="controls">
<div class="input-append">
	<input id="areaId" name="parent.id" class="input-block-level" type="hidden" value="2"/>
	<input id="areaName" name="parent.name" readonly="readonly" type="text" value="湖南省" data-msg-required=""
		class="input-block-level" style=""/><a id="areaButton" href="javascript:" class="btn  " style="">&nbsp;<i class="icon-search"></i>&nbsp;</a>&nbsp;&nbsp;
</div>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">区域名称:</label>
			<div class="controls">
				<input id="name" name="name" class="required" type="text" value="" maxlength="50"/>
				<span class="help-inline"><span style="color:red">*</span> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">区域编码:</label>
			<div class="controls">
				<input id="code" name="code" type="text" value="" maxlength="50"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">区域类型:</label>
			<div class="controls">
				<select id="type" name="type" class="input-medium">
					<option value="1">国家</option><option value="2">省份、直辖市</option><option value="3">地市</option><option value="4">区县</option>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<textarea id="remarks" name="remarks" maxlength="200" class="input-xlarge" rows="3"></textarea>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form>
</body>
</html>