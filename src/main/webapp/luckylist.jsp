<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<!-- easyui的样式主题文件 -->
<link rel="stylesheet" type="text/css" href="./easyui/themes/default/easyui.css">
<!-- easyui的系统图标-->
<link rel="stylesheet" type="text/css" href="./easyui/themes/icon.css">
<!-- 引入颜色的样式 -->
<link rel="stylesheet" type="text/css" href="./easyui/themes/color.css">
<!-- easyui依赖的jquery库-->
<script type="text/javascript" src="./easyui/jquery.min.js"></script>
<!-- easyui的插件库-->
<script type="text/javascript" src="./easyui/jquery.easyui.min.js"></script>
<!-- easyui的汉化包 -->
<script type="text/javascript" src="./easyui/locale/easyui-lang-zh_CN.js"></script>
<body>
<table id="zhongjiangtb" class="easyui-datagrid" title="                          恭喜以下热心网友中奖"
       style="width:800px;height:450px"
       pagination="true" data-options="singleSelect:true,url:'/wwsw/getCode',method:'get'"
       rownumbers="true" fitColumns="true">
    <thead>
    <tr>
        <th data-options="field:'id',width:10,align:'center'">中奖编号</th>
        <%-- <th data-options="field:'name',width:20,align:'center'">姓名</th>
         <th data-options="field:'age',width:10,align:'center'">年龄</th>--%>
    </tr>
    </thead>
</table>
</body>
</html>