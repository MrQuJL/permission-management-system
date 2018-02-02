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
			$("#saveAreaForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					
					var obj = {};
					var formObj = $("#saveAreaForm").serializeArray();
					$.each(formObj, function(i, item) {
						obj[item.name] = item.value;
					});
					obj = JSON.stringify(obj);
					
					var msg = "";
					if ($("#id").val() == "") {
						msg = "新增";
					} else {
						msg = "修改";
					}
					
					$.ajax({
						type : "post",
						url : "${ctx}/sysmgr/saveArea.action",
						data : {"jsonObj" : obj},
						dataType : "json",
						success : function(data) {
							if (data.message == "yes") { // 更新数据成功
								alert(msg+"区域成功！");
								location.href = "${ctx}/sysmgr/gotoAreaList.action";
							} else { // 更新数据失败
								alert(msg+"区域失败,请联系系统管理员!");
							}
							top.$.jBox.closeTip();
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
		<li><a href="${ctx}/sysmgr/gotoAreaList.action">区域列表</a></li>
		<li class="active">
			<a href="javascript:void(0);">区域
				<c:choose>
					<c:when test="${editFlag == 1}">添加</c:when>	
					<c:otherwise>修改</c:otherwise>
				</c:choose>
			</a>
		</li>
	</ul><br/>
	<form id="saveAreaForm" class="form-horizontal" action="#" method="post">
		<input id="id" name="id" type="hidden" value="${area.id}"/>

		<div class="control-group">
			<label class="control-label">上级区域:</label>
			<div class="controls">
<div class="input-append">
	<input id="parentId" name="parentId" class="input-block-level" type="hidden" value="${area.parentId}"/>
	<input id="parentName" name="parentName" readonly="readonly" type="text" value="${area.parentName}"
		class="input-block-level" style=""/><a id="areaButton" href="javascript:showArea();" class="btn" style="">&nbsp;<i class="icon-search"></i>&nbsp;</a>&nbsp;&nbsp;

	<!-- zTree -->
	<div id="areaContent" class="areaContent" style="display:none; position:absolute;">
		<ul id="areaTree" class="ztree" style="margin-top:0;
			background-color:rgb(243,243,243); width:260px; z-index:9;">
		</ul>
	</div>

</div>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">区域名称:</label>
			<div class="controls">
				<input id="name" name="name" class="required" type="text" value="${area.name}" maxlength="50"/>
				<span class="help-inline"><span style="color:red">*</span> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">编码:</label>
			<div class="controls">
				<input id="code" name="code" type="text" value="${area.code}" maxlength="50"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">排序:</label>
			<div class="controls">
				<input id="code" name="sort" type="text" value="${area.sort}" maxlength="50"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">备注:</label>
			<div class="controls">
				<textarea id="remarks" name="remarks" maxlength="200" class="input-xlarge" rows="3">${area.remarks}</textarea>
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
					enable: true,
					idKey : "id",
					pIdKey : "parentId",
					rootPId : 0
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
			var zTree = $.fn.zTree.getZTreeObj("areaTree");
			
			nodes = zTree.getSelectedNodes();
			var parentName = "";
			var parentId = "";
			
			nodes.sort(function compare(a,b){return a.id-b.id;});
			for (var i=0, l=nodes.length; i<l; i++) {
				parentName += nodes[i].name + ",";
				parentId += nodes[i].id + ",";
			}
			if (parentName.length > 0 ) parentName = parentName.substring(0, parentName.length-1);
			$("#parentName").attr("value", parentName);
			
			if (parentId.length > 0 ) parentId = parentId.substring(0, parentId.length-1);
			$("#parentId").attr("value", parentId);
			hideArea();
		};
		
		function showArea() {
			var parent = $("#parentName");
			var parentOffset = $("#parentName").offset();
			$("#areaContent").css({left:parentOffset.left + "px",
				top:parentOffset.top + parent.outerHeight() + "px"}).slideToggle("fast");
			$("body").bind("click", onBodyDown);
		};
		
		function hideArea() {
			$("#areaContent").slideToggle("fast");
			$("body").unbind("click", onBodyDown);
		};
		
		function onBodyDown(event) {
			if (!(event.target.id == "areaButton" || event.target.id == "parentName" ||
				event.target.id == "areaContent" || $(event.target).parents("#areaContent").length>0)) {
				hideArea();
			}
		};
		
		$(document).ready(function(){
			// 页面一刷新就加载zTree
			var areaId = $("#id").val();
			$.ajax({
				type : "post",
				url : "${ctx}/sysmgr/areaTreeData.action",
				// 设为同步的，否则数据加载完成了无法赋值给页面
				async : false,
				data : {"areaId" : areaId},
				dataType : "json",
				success : function(data) {
					var areaArray = JSON.parse(data.jsonObj);
					
					var areaTree = $.fn.zTree.init($("#areaTree"), setting, areaArray);
					
					// 展开所有节点
					var nodes = areaTree.getNodesByParam("level",1);
					for(var i=0; i< nodes.length; i++){
						areaTree.expandNode(nodes[i],true,false,true,false);
					}
					
					//areaTree.expandAll(true);
					
					// 如果是修改页面，定位到当前选中的节点
					var selectNodeId = $("#parentId").val();
					if (selectNodeId != null) {
						areaTree.selectNode(areaTree.getNodeByParam("id",selectNodeId,null));
					}
				}
			});
		});
	</script>
</body>
</html>