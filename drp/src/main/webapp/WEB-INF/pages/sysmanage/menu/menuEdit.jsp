<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<title>菜单管理</title>
<meta charset="utf-8" />
<meta name="renderer" content="webkit">
<%@ include file="/WEB-INF/pages/include/head.jsp" %>
	<script type="text/javascript">
		/* $(function() {
			$("#name").focus();
			$("#saveMenuForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					
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
		}); */
		var menuMgr = {
			saveMenu : function(id) {
				loading('正在提交，请稍等...');
				// 1.获取菜单的各个值
				var jsonObj = $("#saveMenuForm").serializeArray();
				// 2.封装成js对象
				var obj = {};
				$.each(jsonObj,function(i, item) {
					if (item.name != "parentName") {
						obj[item.name] = item.value;
					}
				});
				// 3.发送ajax请求
				$.ajax({
					method : "post",
					url : "${ctx}/sysmgr/saveMenu.action",
					data : {"jsonObj" : JSON.stringify(obj)},
					dataType : "json",
					success : function(data) {
						alert(data.message);
						top.$.jBox.closeTip();
					}
				});
			}
		};
		
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sysmgr/gotoMenuList.action">菜单列表</a></li>
		<li class="active"><a href="javascript:void(0);">菜单
			<c:choose>
				<c:when test="${editFlag==1}">
					添加
				</c:when>
				<c:otherwise>修改</c:otherwise>
			</c:choose>
		</a></li>
	</ul><br/>
	<form id="saveMenuForm" class="form-horizontal" action="#" method="post">
		<input id="id" name="id" type="hidden" value="${menu.id}"/>

		<div class="control-group">
			<label class="control-label">上级菜单:</label>
			<div class="controls">
				<sys:treeSelect id="parent" name="parentId" value="${menu.parentId}"
							labelName="parentName" labelValue="${menu.parentName}"
							title="菜单" url="/sysmgr/menuTreeData.action" 
							extId="${not empty menu.id ? menu.id : 0}" cssClass="required" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">名称:</label>
			<div class="controls">
				<input id="name" name="name" class="required input-xlarge" type="text" value="${menu.name}" maxlength="50"/>
				<span class="help-inline"><span style="color:red">*</span> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">链接:</label>
			<div class="controls">
				<input id="href" name="href" class="input-xxlarge" type="text" value="${menu.href}" maxlength="2000"/>
				<span class="help-inline">点击菜单跳转的页面</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">目标:</label>
			<div class="controls">
				<input id="target" name="target" class="input-small" type="text" value="${menu.target}" maxlength="10"/>
				<span class="help-inline">链接地址打开的目标窗口，默认：mainFrame</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">图标:</label>
			<div class="controls">
				<sys:iconselect id="icon" name="icon" value="${menu.icon}" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">排序:</label>
			<div class="controls">
				<input id="sort" name="sort" class="required digits input-small" type="text" value="${menu.sort}" maxlength="50"/>
				<span class="help-inline"><span class="help-inline"><span style="color:red">*</span> </span>排列顺序，升序。</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">可见:</label>
			<div class="controls">
				<span><input id="isShow1" name="isShow" class="required" type="radio" value="${menu.isShow}" checked="checked"/><label for="isShow1">显示</label></span><span><input id="isShow2" name="isShow" class="required" type="radio" value="0"/><label for="isShow2">隐藏</label></span>
				<span class="help-inline">该菜单或操作是否显示到系统菜单中</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">权限标识:</label>
			<div class="controls">
				<input id="permission" name="permission" class="input-xxlarge" type="text" value="${menu.permission}" maxlength="100"/>
				<span class="help-inline">控制器中定义的权限标识，如：@RequiresPermissions("权限标识")</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<textarea id="remarks" name="remarks" maxlength="200" class="input-xxlarge" rows="3">${menu.remarks}</textarea>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="button" onclick="menuMgr.saveMenu();" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form>
</body>
</html>