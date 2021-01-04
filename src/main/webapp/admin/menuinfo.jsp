<%--
  Created by IntelliJ IDEA.
  User: 欧阳俊豪
  Date: 2020/12/30
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜单管理</title>
    <link rel="stylesheet" href="../assets/plugins/layui/css/layui.css" />
</head>
    <body>
        <table class="layui-table" lay-data="{url:'../admin/selectMenuinfoLimit'}">
            <%--标题--%>
            <thead>
                <th lay-data="{field:'menuid'}">权限ID</th>
                <th lay-data="{field:'title'}">权限名称</th>
                <th lay-data="{field:'menustate'}">权限状态</th>
                <th lay-data="{field:'url'}">页面路径</th>
                <th lay-data="{field:'previd'}">父级ID</th>
                <th lay-data="{field:'iconCls'}">图标路径</th>
            </thead>
        </table>
    </body>
    <%--引入layui.js--%>
    <script src="../assets/plugins/layui/layui.all.js" type="text/javascript"></script>
    <%--js代码块--%>
    <script>

    </script>
</html>
