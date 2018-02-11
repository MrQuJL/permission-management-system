<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<%
String path = request.getContextPath();
%>

<!doctype html>
<html>
<head>
	<title>日志管理</title>
	
<meta charset="utf-8" />
<meta name="renderer" content="webkit">
<%@ include file="/WEB-INF/pages/include/head.jsp"%>
	<script type="text/javascript">
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
	    	return false;
	    }
	</script>
</head>
<body>
<!-- 	<ul class="nav nav-tabs"> -->

<!-- 	</ul> -->
	<form id="searchForm" class="breadcrumb form-search" action="#" method="post">
		<input id="pageNo" name="pageNo" type="hidden" value="1"/>
		<input id="pageSize" name="pageSize" type="hidden" value="15"/>
		<div>
			<label>操作菜单：</label><input id="title" name="title" type="text" maxlength="50" class="input-mini" value=""/>
			<label>用户ID：</label><input id="createBy.id" name="createBy.id" type="text" maxlength="50" class="input-mini" value=""/>
			<label>URI：</label><input id="requestUri" name="requestUri" type="text" maxlength="50" class="input-mini" value=""/>
		</div><div style="margin-top:8px;">
			<label>日期范围：&nbsp;</label><input id="beginDate" name="beginDate" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate"
				value="2015-07-01" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>
			<label>&nbsp;--&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label><input id="endDate" name="endDate" type="text" readonly="readonly" maxlength="20" class="input-mini Wdate"
				value="2015-08-01" onclick="WdatePicker({dateFmt:'yyyy-MM-dd',isShowClear:false});"/>&nbsp;&nbsp;
			&nbsp;<label for="exception"><input id="exception" name="exception" type="checkbox" value="1"/>只查询异常信息</label>
			&nbsp;&nbsp;&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>&nbsp;&nbsp;
		</div>
	</form>
<script type="text/javascript">top.$.jBox.closeTip();</script>

	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>操作菜单</th><th>操作用户</th><th>所在公司</th><th>所在部门</th><th>URI</th><th>提交方式</th><th>操作者IP</th><th>操作时间</th></thead>
		<tbody>
		
		</tbody>
	</table>
<div class="pagination"><ul>
<li class="disabled"><a href="javascript:">&#171; 上一页</a></li>
<li class="active"><a href="javascript:">1</a></li>
<li class="disabled"><a href="javascript:">下一页 &#187;</a></li>
<li class="disabled controls"><a href="javascript:">当前 <input type="text" value="1" onkeypress="var e=window.event||this;var c=e.keyCode||e.which;if(c==13)page(this.value,15,'');" onclick="this.select();"/> / <input type="text" value="15" onkeypress="var e=window.event||this;var c=e.keyCode||e.which;if(c==13)page(1,this.value,'');" onclick="this.select();"/> 条，共 0 条</a></li>
</ul>
<div style="clear:both;"></div></div>
</body>
</html>