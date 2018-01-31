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
			$("#saveDeptForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					var dept = $("#saveDeptForm").serializeArray();
					var deptObj = {};
					$.each(dept,function(i, item){
						if (item.name != "parentName") {
							deptObj[item.name] = item.value;
						}
					});
					
					//alert(JSON.stringify(deptObj));
					
					$.ajax({
						type : "post",
						url : "${ctx}/sysmgr/saveDept.action",
						data :{"jsonObj" : JSON.stringify(deptObj)},
						dataType : "json",
						success : function(data) {
							alert(data.message);
							top.$.jBox.closeTip();
							// 跳转到部门列表页面
							location.href = "${ctx}/sysmgr/gotoDeptList.action";
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
		<li><a href="${ctx}/sysmgr/gotoDeptList.action">部门列表</a></li>
		<li class="active"><a href="javascript:void(0);">部门
			<c:choose>
				<c:when test="${deptDto.id != null}">修改</c:when>
				<c:otherwise>添加</c:otherwise>
			</c:choose>
		</a></li>
	</ul><br/>
	
	<form id="saveDeptForm" class="form-horizontal" action="#" method="post">
		<input id="id" name="id" type="hidden" value="${deptDto.id}"/>

		<div class="control-group">
			<label class="control-label">上级部门:</label>
			<div class="controls">
				<div class="input-append">
					<input id="parentId" name="parentId" class="" type="hidden" value="${deptDto.parentId}"/>
					<input id="parentName" name="parentName" readonly="readonly" type="text" value="${deptDto.parentName}"/>
					<a id="deptBtn" href="javascript:showMenu();" class="btn">
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
			<label class="control-label">部门名称:</label>
			<div class="controls">
				<input id="name" name="name" class="required" type="text" value="${deptDto.name}" maxlength="50"/>
				<span class="help-inline"><span style="color:red">*</span></span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">排序:</label>
			<div class="controls">
				<input id="sort" name="sort" class="required" type="text" value="${deptDto.sort}" maxlength="50"/>
				<span class="help-inline"><span style="color:red">*</span>排列顺序，升序。</span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">机构编号:</label>
			<div class="controls">
				<input id="code" name="code" type="text" value="${deptDto.code}" maxlength="50"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">部门地址:</label>
			<div class="controls">
				<input id="address" name="address" type="text" value="${deptDto.address}" maxlength="50"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">负责人:</label>
			<div class="controls">
				<input id="master" name="master" type="text" value="${deptDto.master}" maxlength="50"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">电话:</label>
			<div class="controls">
				<input id="phone" name="phone" type="text" value="${deptDto.phone}" maxlength="50"/>
				<span class="help-inline"></span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">传真:</label>
			<div class="controls">
				<input id="fax" name="fax" type="text" value="${deptDto.fax}" maxlength="50"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">邮箱:</label>
			<div class="controls">
				<input id="email" name="email" type="text" value="${deptDto.email}" maxlength="50"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<textarea id="remarks" name="remarks" maxlength="200" class="input-xlarge" rows="3">${deptDto.remarks}</textarea>
			</div>
		</div>
		<div class="form-actions">
			<input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form>
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

		var zNodes = new Array();

		function beforeClick(treeId, treeNode) {
			// 在点击之前做的一些事情
		}

		function onClick(e, treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("deptTree"),
			nodes = zTree.getSelectedNodes();
			var name = "";
			var id = "";
			nodes.sort(function compare(a,b){return a.id-b.id;});
			for (var i=0, l=nodes.length; i<l; i++) {
				name += nodes[i].name + ",";
				id += nodes[i].id + ",";
			}
			if (name.length > 0 ) name = name.substring(0, name.length-1);
			if (id.length > 0 ) id = id.substring(0, id.length-1);

			$("#parentId").attr("value",id);
			$("#parentName").attr("value",name);
			
			hideMenu();
		}

		function showMenu() {
			var deptObj = $("#parentName");
			var deptOffset = $("#parentName").offset();
			$("#deptContent").css({left:deptOffset.left + "px", top:deptOffset.top + deptObj.outerHeight() + "px"}).slideDown("fast");

			$("body").bind("mousedown", onBodyDown);
		}
		function hideMenu() {
			$("#deptContent").slideUp("fast");
			$("body").unbind("mousedown", onBodyDown);
		}
		function onBodyDown(event) {
			if (!(event.target.id == "deptBtn" || event.target.id == "deptContent" || $(event.target).parents("#deptContent").length>0)) {
				hideMenu();
			}
		}

		$(document).ready(function(){
			var id = $("#id").val();
			$.ajax({
				type : "post",
				url : "${ctx}/sysmgr/loadDeptTree.action",
				// async是异步的意思，sync是同步的意思
				async : false,
				data : {"deptId" : id},
				dataType : "json",
				success : function(data) {
					var deptArray = JSON.parse(data.jsonObj);
					for (var i = 0; i < deptArray.length; i++) {
						var temp = {};
						temp["id"] = deptArray[i].id;
						temp["pId"] = deptArray[i].pId;
						temp["name"] = deptArray[i].name;
						zNodes.push(temp);
					}
					
					//alert(JSON.stringify(zNodes));
				}
			});
			var deptTree = $.fn.zTree.init($("#deptTree"), setting, zNodes);
			deptTree.expandAll(true);
		});
		
	</script>
</body>
</html>
