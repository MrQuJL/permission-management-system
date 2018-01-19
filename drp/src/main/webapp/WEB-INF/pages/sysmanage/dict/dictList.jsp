<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/pages/include/taglib.jsp" %>
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
    <title>字典管理</title>
    
<meta charset="utf-8" />
<meta name="renderer" content="webkit">
<%@ include file="/WEB-INF/pages/include/head.jsp" %>
    <meta name="decorator" content="default"/>
    <script type="text/javascript">
        function page(n, s) {
            $("#pageNo").val(n);
            $("#pageSize").val(s);
            $("#searchForm").submit();
            return false;
        }
    </script>
</head>
<body>
<ul class="nav nav-tabs">
    <li class="active"><a href="javascript:void(0);">字典列表</a></li>
    
        <li><a href="${ctx}/sysmgr/gotoDictEdit.action">字典编辑</a></li>
    
</ul>
<form id="searchForm" class="breadcrumb form-search" action="#" method="post">
    <input id="pageNo" name="pageNo" type="hidden" value="1"/>
    <input id="pageSize" name="pageSize" type="hidden" value="15"/>
    <label>类型：</label>
        <select id="type" name="type" class="input-medium">
            <option value=""></option>
            <option value="del_flag">del_flag</option><option value="sex">sex</option><option value="show_hide">show_hide</option><option value="sys_area_type">sys_area_type</option><option value="sys_data_scope">sys_data_scope</option><option value="sys_log_type">sys_log_type</option><option value="sys_office_grade">sys_office_grade</option><option value="sys_office_type">sys_office_type</option><option value="sys_user_type">sys_user_type</option><option value="yes_no">yes_no</option>
        </select>
    &nbsp;&nbsp;<label>描述 ：</label>
        <input id="description" name="description" class="input-medium" type="text" value="" maxlength="50"/>
    &nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
</form>
<script type="text/javascript">top.$.jBox.closeTip();</script>

<table id="contentTable" class="table table-striped table-bordered table-condensed">
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
    
        <tr>
            <td>0</td>
            <td><a href="#">正常</a></td>
            <td><a href="javascript:"
                   onclick="$('#type').val('del_flag');$('#searchForm').submit();return false;">del_flag</a>
            </td>
            <td>删除标记</td>
            <td>10</td>
            
                <td>
                    <a href="dictAdd.html">修改</a>
                    <a href="#" onclick="return confirmx('确认要删除该字典吗？', this.href)">删除</a>
                    <a href="dictAdd.html">添加键值</a>
                </td>
            
        </tr>
    
        <tr>
            <td>1</td>
            <td><a href="/sys/dict/toEdit?id=2">删除</a></td>
            <td><a href="javascript:"
                   onclick="$('#type').val('del_flag');$('#searchForm').submit();return false;">del_flag</a>
            </td>
            <td>删除标记</td>
            <td>20</td>
            <td>
                    <a href="dictAdd.html">修改</a>
                    <a href="#" onclick="return confirmx('确认要删除该字典吗？', this.href)">删除</a>
                    <a href="dictAdd.html">添加键值</a>
                </td>
                
            
        </tr>
    
        <tr>
            <td>1</td>
            <td><a href="/sys/dict/toEdit?id=96">男</a></td>
            <td><a href="javascript:"
                   onclick="$('#type').val('sex');$('#searchForm').submit();return false;">sex</a>
            </td>
            <td>性别</td>
            <td>10</td>
            
               <td>
                    <a href="dictAdd.html">修改</a>
                    <a href="#" onclick="return confirmx('确认要删除该字典吗？', this.href)">删除</a>
                    <a href="dictAdd.html">添加键值</a>
                </td>
            
        </tr>
    
        <tr>
            <td>2</td>
            <td><a href="/sys/dict/toEdit?id=97">女</a></td>
            <td><a href="javascript:"
                   onclick="$('#type').val('sex');$('#searchForm').submit();return false;">sex</a>
            </td>
            <td>性别</td>
            <td>20</td>
            
                <td>
                    <a href="dictAdd.html">修改</a>
                    <a href="#" onclick="return confirmx('确认要删除该字典吗？', this.href)">删除</a>
                    <a href="dictAdd.html">添加键值</a>
                </td>
        </tr>
    
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