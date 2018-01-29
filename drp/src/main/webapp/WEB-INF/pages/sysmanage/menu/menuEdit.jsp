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
				<%-- <sys:treeSelect id="parent" name="parentId" value="${menu.parentId}"
							labelName="parentName" labelValue="${menu.parentName}"
							title="菜单" url="/sysmgr/menuTreeData.action" 
							extId="${not empty menu.id ? menu.id : 0}" cssClass="required" />
				--%>
				<!-- 此处更换下拉式zTree -->
				<div class="input-append">
					<input id="menuId" name="parentId" class="required" type="hidden" value="${menu.parentId}"/>
					<input id="menuName" name="parentName" readonly="readonly" type="text" value="${menu.parentName}" 
						class="required" style=""/>
					<a id="menuButton" href="javascript:showMenu();" class="btn">
						&nbsp;<i class="icon-search"></i>&nbsp;
					</a>&nbsp;&nbsp;
					
					<!-- 盛放菜单树的容器 -->
					<div id="menuContent" class="menuContent" style="display:none; position:absolute;">
						<ul id="treeDemo" class="ztree" style="margin-top:0; width:264px; background-color:#f1f1f1;"></ul>
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

		var zNodes =[
			{id:4, pId:0, name:"河北省", open:true},
			{id:41, pId:4, name:"石家庄"},
			{id:42, pId:4, name:"保定"},
			{id:43, pId:4, name:"邯郸"},
			{id:44, pId:4, name:"承德"},
			{id:5, pId:0, name:"广东省", open:true},
			{id:51, pId:5, name:"广州"},
			{id:52, pId:5, name:"深圳"},
			{id:53, pId:5, name:"东莞"},
			{id:54, pId:5, name:"佛山"},
			{id:6, pId:0, name:"福建省", open:true},
			{id:61, pId:6, name:"福州"},
			{id:62, pId:6, name:"厦门"},
			{id:63, pId:6, name:"泉州"},
			{id:64, pId:6, name:"三明"}
		 ];

		function beforeClick(treeId, treeNode) {
			/*var check = (treeNode && !treeNode.isParent);
			if (!check) alert("只能选择城市...");
			return check;*/
		}

		function onClick(e, treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getSelectedNodes(),
			v = "";
			nodes.sort(function compare(a,b){return a.id-b.id;});
			for (var i=0, l=nodes.length; i<l; i++) {
				v += nodes[i].name + ",";
			}
			if (v.length > 0 ) v = v.substring(0, v.length-1);
			var cityObj = $("#menuName");
			cityObj.attr("value", v);
		}

		function showMenu() {
			var cityObj = $("#menuName");
			var cityOffset = $("#menuName").offset();
			$("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

			$("body").bind("mousedown", onBodyDown);
		}
		function hideMenu() {
			$("#menuContent").fadeOut("fast");
			$("body").unbind("mousedown", onBodyDown);
		}
		function onBodyDown(event) {
			if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
				hideMenu();
			}
		}

		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		});
		
	</script>
</body>
</html>