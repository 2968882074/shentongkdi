<%--
  Created by IntelliJ IDEA.
  User: like
  Date: 2020/12/28
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>线路管理列表</title>
    <link rel="stylesheet" href="layui-v2.5.6/layui/css/layui.css"  media="all">
</head>
<body>
<div id="lineDiv" style="display:none;width:320px;margin-top:10px">
    <form id=myFrom class="layui-form" lay-filter="formTest">
        <div class="layui-form-item">

            <div class="layui-input-inline">
                <input name="lid" readonly="readonly" required="required"   class="layui-input" type="hidden">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">线路类型</label>
            <div class="layui-input-inline">
                <select name="line" lay-filter="aihao">
                    <option value="">线路类型</option>
                    <option value="1">全部</option>
                    <option value="2" >干线</option>
                    <option value="3">周边</option>
                    <option value="4">省内</option>
                    <option value="5" >临时</option>
                    <option value="6">市内</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">线路名称</label>
            <div class="layui-input-inline">
                <input type="text" name="linename" required lay-verify="required" placeholder="请输入线路名称" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">路径</label>
            <div class="layui-input-inline">
                <input type="text" name="linepath" required lay-verify="required" placeholder="请输入路径" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>



<table class="layui-hide" id="test" lay-filter="test"></table>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-group">
        <button type="button" class="layui-btn layui-btn-primary layui-btn-sm" lay-event="add"><i class="layui-icon"></i></button>
        <button type="button" class="layui-btn layui-btn-primary layui-btn-sm" lay-event="deleteid"><i class="layui-icon"></i></button>
    </div>
    线路名称：
    <div class="layui-inline">
        <input class="layui-input" name="linename" id="linename" autocomplete="off" placeholder="请输入线路名称">
    </div>
    <button class="layui-btn" data-type="reload" lay-event="search">搜索</button>
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script src="layui-v2.5.6/layui/layui.js" charset="utf-8"></script>
<script src="js/jquery-3.5.1.min.js" type="text/javascript"></script>
<script>
    layui.use(['table','layer','form'], function() {
        var table = layui.table;
        var layer = layui.layer;
        var form = layui.form;
        var url="";
        table.render({
            elem: '#test'
            , url: 'line/selectAll'
            , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            , defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                , layEvent: 'LAYTABLE_TIPS'
                , icon: 'layui-icon-tips'
            }]
            , title: '线路管理数据表'
            , cols: [[
                {type: 'checkbox', fixed: 'left'}
                , {field: 'lid', title: '线路id', width: 300, fixed: 'left', unresize: true, sort: true,align : 'center'}
                , {field: 'line', title: '线路类型', width: 300, edit: 'text',align : 'center'}
                , {field: 'linename', title: '线路名称', width: 300, edit: 'text',align : 'center'}
                , {field: 'linepath', title: '路径', width: 300, edit: 'text', sort: true,align : 'center'}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 280,align : 'center'}
            ]]
            , page: true
        });


        //监听提交
        form.on('submit(formDemo)', function(data){
            var json=JSON.stringify(data.field);
            $.ajax({
                type: "POST",
                url: "line/"+url,
                data:"json="+json,
                dataType:"text",
                success: function(msg){
                    layer.closeAll();
                    layer.msg(msg);
                    table.reload('test');
                }
            });
            return false;
        });

        //头工具栏事件
        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id);
            switch(obj.event){
                case 'add':
                    url="insert";
                    //清空表单
                    $("#myFrom")[0].reset();

                    layer.open({
                        type:1,
                        title:'新增用户',
                        area: ['400px','400px'],
                        shadeClose: true,
                        shade: false,
                        maxmin: true, //开启最大化最小化按钮
                        content: $('#lineDiv')
                    });
                    break;
                case 'search':
                    //得到输入框的值
                    var value=$("#linename").val();
                    //执行重载
                    table.reload('test', {
                        url : "line/selectAll?linename="+value
                        ,page : {
                            curr : 1
                            //重新从第 1 页开始
                        }
                    });
                    $("#linename").val(value);//刷新值会被消除，则需要重新设定
                    break;
                case 'deleteid'://删除多个
                    var data = checkStatus.data;
                    //layer.alert(JSON.stringify(data));
                    if(data.length>0){
                        layer.confirm('真的要删除么', function(index) {
                            //获取所有选中的id
                            var lid="";
                            for (var i = 0; i < data.length; i++) {
                                lid+=data[i].lid+"-";
                                console.log(data[i].lid);
                            }

                            layer.close(index);
                            //使用ajax删除选中的
                            $.ajax({
                                type : "POST",
                                url : "line/delete",
                                data : "lid="+lid,
                                success : function(msg) {
                                    layer.msg('删除成功！');
                                    table.reload('test');
                                }
                            });

                        });
                    }else{
                        layer.alert('你至少选一行');
                    }
                    break;

            };
        });
        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;//得到当行数据
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                    $.ajax({
                        type: "POST",
                        url: "line/delete",
                        data:"lid="+data.lid,
                        success: function(msg){
                            layer.alert("删除成功！");
                        }
                    });
                });
            } else if(obj.event === 'edit'){
                //alert(1);
                url="updateById";
                //给表单赋值
                form.val("formTest", {
                    "lid": data.lid
                    , "line": data.line
                    ,"linename": data.linename
                    ,"linepath": data.linepath
                });


                layer.open({
                    type: 1,
                    title: '修改',
                    shadeClose: true,
                    shade: false,
                    maxmin: true, //开启最大化最小化按钮
                    area: ['400px','400px'],
                    content: $("#lineDiv")
                });
            }
        });
    });

</script>
</body>
</html>
