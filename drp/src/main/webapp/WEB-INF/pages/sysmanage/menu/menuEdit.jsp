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
				<!-- 此处更换下拉式zTree -->
				<div class="input-append">
					<input id="parentId" name="parentId" class="required" type="hidden" value="${menu.parentId}"/>
					<input id="parentName" name="parentName" readonly="readonly" type="text" value="${menu.parentName}" 
						class="required" onclick="showMenu();"/>
					<a id="menuButton" href="javascript:showMenu();" class="btn">
						&nbsp;<i class="icon-search"></i>&nbsp;
					</a>&nbsp;&nbsp;
					
					<!-- 盛放菜单树的容器 -->
					<div id="menuContent" class="menuContent" style="display:none; position:absolute;z-index:10;">
						<ul id="menuTree" class="ztree" style="margin-top:0; width:264px; background-color:#f1f1f1;"></ul>
					</div>
				</div>
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
	<script type="text/javascript">
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
					type : "post",
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
		
		// 点击之前会触发的事件
		function beforeClick(treeId, treeNode) {
			/*var check = (treeNode && !treeNode.isParent);
			if (!check) alert("只能选择城市...");
			return check;*/
		};
		
		// 选中某个菜单项后会触发的操作
		function onClick(e, treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("menuTree");
			
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
			hideMenu();
		};
		
		function showMenu() {
			var parent = $("#parentName");
			var parentOffset = $("#parentName").offset();
			$("#menuContent").css({left:parentOffset.left + "px",
				top:parentOffset.top + parent.outerHeight() + "px"}).slideToggle("fast");
			$("body").bind("click", onBodyDown);
		};
		
		function hideMenu() {
			$("#menuContent").slideToggle("fast");
			$("body").unbind("click", onBodyDown);
		};
		
		function onBodyDown(event) {
			if (!(event.target.id == "menuButton" || event.target.id == "parentName" ||
				event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
				hideMenu();
			}
		};
		
		$(document).ready(function(){
			// 页面一刷新就加载zTree
			var menuId = $("#id").val();
			$.ajax({
				type : "post",
				url : "${ctx}/sysmgr/menuTreeData.action",
				// 设为同步的，否则数据加载完成了无法赋值给页面
				async : false,
				data : {"menuId" : menuId},
				dataType : "json",
				success : function(data) {
					var menuArray = JSON.parse(data.jsonObj);
					
					for (var i = 0; i < menuArray.length; i++) {
						var temp = {};
						temp.name = menuArray[i].name;
						temp.id = menuArray[i].id;
						temp.pId = menuArray[i].pId;
						zNodes.push(temp);
					}
					
					// 后台传过来的数据结构如下：
					/* [{"name":"功能菜单","pId":0,"id":1},
					 {"name":"系统设置","pId":1,"id":2},
					 ...
					 {"name":"修改密码","pId":28,"id":30}] */
				}
			});
			
			$.fn.zTree.init($("#menuTree"), setting, zNodes);
			var menuTree = $.fn.zTree.getZTreeObj("menuTree");
			// 展开所有节点
			menuTree.expandAll(true);
			
			// 如果是修改页面，定位到当前选中的节点
			var selectNodeId = $("#parentId").val();
			if (selectNodeId != null) {
				menuTree.selectNode(menuTree.getNodeByParam("id",selectNodeId,null));
			}
			
		});
	</script>
</body>
</html>