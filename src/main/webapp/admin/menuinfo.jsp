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
    <style>
        *{
            margin: 0;
            padding: 0;
        }

        .layui-table{
            text-align: center;
            line-height: 50px;
        }

        .layui-table th{
            text-align: center;
        }

        .layui-table-cell .layui-form-checkbox[lay-skin=primary]{
            top: 5px;
        }
    </style>
</head>
    <body>
        <table class="layui-table" lay-data="{page: true,toolbar:'default',url:'../admin/selectMenuinfoLimit'}" lay-filter="table" id="table">
            <%--标题--%>
            <thead>
                <th lay-data="{type:'checkbox'}"></th>
                <th lay-data="{field:'menuid'}">权限ID</th>
                <th lay-data="{field:'title'}">权限名称</th>
                <th lay-data="{field:'menustate',templet:'#templets'}">权限状态</th>
                <th lay-data="{field:'url'}">页面路径</th>
                <th lay-data="{field:'previd'}">父级ID</th>
                <th lay-data="{field:'iconCls'}">图标路径</th>
                <th lay-data="{fixid:'right',title:'操作',toolbar:'#barDemo',width:150}"></th>
            </thead>
        </table>



        <%--新增修改表单,弹出层调用--%>
        <form id="form" class="layui-form" style="display: none; padding: 10px; width: 400px;" lay-filter="forms">
            <div class="layui-form-item">
                <%--标题--%>
                <label class="layui-form-label">权限ID</label>
                <%--输入框--%>
                <div class="layui-input-block">
                    <input type="text" name="menuid" required  lay-verify="required" placeholder="请输入ID" autocomplete="off" class="layui-input" />
                </div>
            </div>
            <div class="layui-form-item">
                <%--标题--%>
                <label class="layui-form-label">权限名称</label>
                <%--输入框--%>
                <div class="layui-input-block">
                    <input type="text" name="title" required  lay-verify="required" placeholder="请输入ID" autocomplete="off" class="layui-input" />
                </div>
            </div>
            <div class="layui-form-item">
                <%--标题--%>
                <label class="layui-form-label">权限状态</label>
                <%--输入框--%>
                <div class="layui-input-block">
                    <input type="checkbox" name="menustate" lay-skin="switch" value="1" lay-text="开启|关闭" checked />
                </div>
            </div>
            <div class="layui-form-item">
                <%--标题--%>
                <label class="layui-form-label">页面路径</label>
                <%--输入框--%>
                <div class="layui-input-block">
                    <input type="text" name="url" required  lay-verify="required" placeholder="请输入ID" autocomplete="off" class="layui-input" />
                </div>
            </div>
            <div class="layui-form-item">
                <%--标题--%>
                <label class="layui-form-label">父级ID</label>
                <%--输入框--%>
                <div class="layui-input-block">
                    <input type="text" name="previd" required  lay-verify="required" placeholder="请输入ID" autocomplete="off" class="layui-input" />
                </div>
            </div>
            <div class="layui-form-item">
                <%--标题--%>
                <label class="layui-form-label">图标路径</label>
                <%--输入框--%>
                <div class="layui-input-block">
                    <input type="text" name="iconcls"  placeholder="请输入ID" autocomplete="off" class="layui-input" />
                </div>
            </div>
            <div class="layui-form-item">
                <%--标题--%>
                <label class="layui-form-label"></label>
                <%--输入框--%>
                <div class="layui-input-block">
                    <button class="layui-btn layui-btn-normal" lay-submit lay-filter="submits">立即新增</button>
                </div>
            </div>
        </form>



    </body>
    <%--操作模板--%>
    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>
    <%--自定义模板--%>
    <script type="text/html" id="templets">
        {{#  if(d.menustate == 1){ }}
        <span class="layui-badge layui-bg-blue" style="margin-top: 6px;">开启中</span>
        {{#  } else { }}
        <span class="layui-badge layui-bg-gray" style="margin-top: 6px;">关闭中</span>
        {{#  } }}
    </script>

    <%--引入jquery--%>
    <script src="../assets/js/jquery.min.js"></script>
    <%--引入layui.js--%>
    <script src="../assets/plugins/layui/layui.all.js" type="text/javascript"></script>
    <%--js代码块--%>
    <script>
        var table=layui.table,layer=layui.layer,form=layui.form;
        var method = "";

        /*监听表格头工具栏*/
        table.on('toolbar(table)',function (obj) {
            var checkStatus = table.checkStatus(obj.config.id);
            switch (obj.event) {
                case 'add':
                    show_AddAndUpdate('add','新增');
                    break;
                case 'update':
                    if(checkStatus.data.length != 1) layer.msg("请选择一个");
                    else{
                        show_AddAndUpdate('update','修改',obj.checkStatus.data[0]);
                    }
                    break;
                case 'delete':
                    layer.msg("删除");
                    console.log(obj.data);
                    var id = "id=";
                    for(var p in obj.data){
                        console.log(obj.data[p].menuid);
                    }
                    break;
            }
        });

        /*监听表格行工具栏*/
        table.on('tool(table)',function(obj){
            console.log(obj.event);
            switch (obj.event) {
                case 'edit':
                    show_AddAndUpdate('update','修改',obj.data);
                    break;
                case 'del':

                    break;
            }
        });

        /*监听提交事件*/
        form.on('submit(submits)',function(data){
            /*判断状态是否为关闭 如是关闭 则设置为0*/
            if(data.field.menustate == null) data.field.menustate = 0;
            $.ajax({
                url:"../admin/"+method+"Menuinfo",
                data:data.field,
                dataType:"json",
                success:function(json){
                    if(json.state){
                        /*提示*/
                        layer.msg("执行成功!");
                        /*重载表格*/
                        table.reload('table',{});
                    }else layer.msg("执行失败!");

                }
            });
            /*阻止表单跳转*/
            return false;
        });

        /*删除操作*/
        function deldata(){

        }

        /*显示修改或新增面板*/
        function show_AddAndUpdate(method,title,data=null){
            if(method == 'add'){
                /*清楚表单数据*/
                document.getElementById("form").reset()
                /*禁用*/
                $("input[name='menuid']").removeAttr("disabled");
            }else if(method == 'update'){
                /*表单赋值*/
                form.val("forms",data);
                /*禁用*/
                $("input[name='menuid']").prop("disabled","disabled");
            }

            /*打开面板*/
            layer.open({
                type:1,
                title:title,
                area: '500px',
                resize:false,
                content:$("#form")
            });
        }
    </script>
</html>
