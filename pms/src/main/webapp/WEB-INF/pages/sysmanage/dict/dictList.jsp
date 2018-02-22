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
    	var dictMgr = {
    		// 获取分页后的字典列表
	    	getDictListPage : function(pageNo, pageSize) {
	    		loading("正在查询...");
	    		var type = $("#type").val();
	    		var description = $("#description").val();
	    		$.ajax({
	    			type : "post",
	    			url : "${ctx}/sysmgr/getDictListPage.action",
	    			data : {"type":type,"description":description,"pageParam.pageNo":pageNo,"pageParam.pageSize":pageSize},
	    			dataType : "json",
	    			success : function(data) {
	    				top.$.jBox.closeTip();
	    				// 获取分页条
	    				var pageBar = data.pageBar;
	    				// 获取字典列表
	    				data = JSON.parse(data.jsonObj);
	    				var htmlTable = "";
	    				if (data.length != 0) {
	    					for (var i = 0; i < data.length; i++) {
		    					console.log(data[i].id+ "," +data[i].label);
		    					htmlTable = htmlTable + "<tr>";
		    					htmlTable = htmlTable + "<td>";
		    					htmlTable = htmlTable + data[i].value;
		    					htmlTable = htmlTable + "</td>";
		    					htmlTable = htmlTable + "<td>";
		    					htmlTable = htmlTable + data[i].label;
		    					htmlTable = htmlTable + "</td>";
		    					htmlTable = htmlTable + "<td>";
		    					htmlTable = htmlTable + data[i].type;
		    					htmlTable = htmlTable + "</td>";
		    					htmlTable = htmlTable + "<td>";
		    					htmlTable = htmlTable + data[i].description;
		    					htmlTable = htmlTable + "</td>";
		    					htmlTable = htmlTable + "<td>";
		    					htmlTable = htmlTable + data[i].sort;
		    					htmlTable = htmlTable + "</td>";
		    					htmlTable = htmlTable + "<td>";
		    					htmlTable = htmlTable + "<a href='${ctx}/sysmgr/gotoDictEdit.action?dictId=" + data[i].id + 
		    						"'>修改</a> <a href='javascript:void(0);' onclick='dictMgr.delDict(" + data[i].id + ")'>删除</a>";
		    					htmlTable = htmlTable + "</td>";
		    					htmlTable = htmlTable + "</tr>";
		    				}
	    				} else {
	    					htmlTable = "没有查询到数据";
	    				}
	    				$("#dictTable").find("tbody").html(htmlTable);
	    				$("#dictPageBar").html(pageBar);
	    			},
	    			error : function(data, status, errorThrown) {
	    				top.$.jBox.closeTip();
	    				alert("您没有权限操作此功能，请联系系统管理员进行授权");
	    			}
	    		});
	    	},
    		// 删除字典
    		delDict : function(dictId) {
    			if (confirm("您确定要删除该字典吗？")) {
    				loading('正在提交，请稍等...');
        			$.ajax({
        				type : "post",
        				url : "${ctx}/sysmgr/delDict.action",
        				data : {"dictId" : dictId},
        				dataType : "json",
        				success : function(data){
    	    				alert(data.message);
        				},
        				complete : function(){
        					top.$.jBox.closeTip();
        					// 删除完了之后重新查询一下字典列表
        					dictMgr.getDictList();
        				}
        			});
    			}
    		}
    	};
    </script>
</head>
<body>
	<ul class="nav nav-tabs">
	    <li class="active"><a href="javascript:void(0);">字典列表</a></li>
	    <li><a href="${ctx}/sysmgr/gotoDictEdit.action">字典添加</a></li>
	</ul>
	
	<form id="searchForm" class="breadcrumb form-search" action="#" method="post">
	    <label>类型：</label>
        <select id="type" name="type" class="input-medium">
            <option value="">所有类型</option>
            <c:forEach items="${dictTypeList}" var="dictType">
	        	<option value="${dictType}">${dictType}</option>
            </c:forEach>
        </select>&nbsp;&nbsp;
        
    	<label>描述 ：</label>
        <input id="description" name="description" class="input-medium" type="text" value="" maxlength="50"/>&nbsp;
    	<shiro:hasPermission name="sys:dict:view">
    		<input id="btnSubmit" class="btn btn-primary" type="button" onclick="dictMgr.getDictListPage(1, 10);" value="查询"/>
    	</shiro:hasPermission>
	</form>

	<table id="dictTable" class="table table-striped table-bordered table-condensed">
	    <thead>
	    <tr>
	        <th>键值</th>
	        <th>标签</th>
	        <th>类型</th>
	        <th>描述</th>
	        <th>排序</th>
	        <th>操作</th>
	    </tr>
	    </thead>
	    <tbody>
			
	    </tbody>
	</table>
	
	<%-- 此处为分页条所在的位置 --%>
	<div class="pagination" id="dictPageBar">
	
	</div>
</body>
</html>