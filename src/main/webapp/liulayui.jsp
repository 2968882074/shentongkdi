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
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">
</head>
<body>
<div id="lineDiv" style="display:none;width:320px;margin-top:10px">
    <form id=myFrom class="layui-form" lay-filter="formTest">
        <div class="layui-form-item">

            <div class="layui-input-inline">
                <input name="seid" readonly="readonly" required="required"   class="layui-input" type="hidden">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">寄件人名</label>
            <div class="layui-input-inline">
                <input type="text" name="sname" required lay-verify="required" placeholder="请输入寄件人名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">寄件人地址</label>
            <div class="layui-input-inline">
                <input type="text" name="saddress" required lay-verify="required" placeholder="请输入寄件人座机号" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">寄件人座机号码</label>
            <div class="layui-input-inline">
                <input type="text" name="slandline" required lay-verify="required" placeholder="请输入座机号码" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">寄件人手机号码</label>
            <div class="layui-input-inline">
                <input type="text" name="sphone" required lay-verify="required" placeholder="请输入手机号码" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">寄件人详细地址</label>
            <div class="layui-input-inline">
                <input type="text" name="sdetailedaddress" required lay-verify="required" placeholder="请输入详细地址" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">付款方式</label>
            <div class="layui-input-inline">
                <input type="text" name="spayment" required lay-verify="required" placeholder="付款方式" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">邮箱</label>
            <div class="layui-input-inline">
                <input type="text" name="semail" required lay-verify="required" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">寄件时间</label>
            <div class="layui-input-inline">
                <input type="text" id="sendertime" name="sendertime" required lay-verify="required" placeholder="寄件时间" autocomplete="off" class="layui-input">
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
    <button class="layui-btn layui-btn-normal" data-type="reload" lay-event="search">搜索</button>
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="edit">
        <i class="layui-icon layui-icon-edit" style="font-size: 30px;"></i>编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">
        <i class="layui-icon layui-icon-delete " style="font-size: 30px;"></i>删除
    </a>
</script>
<script src="layui/layui.js" charset="utf-8"></script>
<script src="js/jquery-3.4.1.min.js" type="text/javascript"></script>
<script>
    layui.use(['table','layer','form'], function() {
        var table = layui.table;
        var layer = layui.layer;
        var form = layui.form;
        var url="";
        table.render({
            elem: '#test'
            , url: 'lw/selectAll'
            , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            , defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                , layEvent: 'LAYTABLE_TIPS'
                , icon: 'layui-icon-tips'
            }]
            , title: '线路管理数据表'
            , cols: [[
                {type: 'checkbox', fixed: 'left'}
                , {field: 'seid', title: '寄件人ID', width: 100, fixed: 'left', unresize: true, sort: true,align : 'center'}
                , {field: 'sname', title: '寄件人姓名', width: 100, edit: 'text',align : 'center'}
                , {field: 'saddress', title: '寄件人地址', width: 100, edit: 'text',align : 'center'}
                , {field: 'slandline', title: '座机', width: 100, edit: 'text', sort: true,align : 'center'}
                , {field: 'sphone', title: '手机', width: 100, edit: 'text', sort: true,align : 'center'}
                , {field: 'sdetailedaddress', title: '详细地址', width: 100, edit: 'text', sort: true,align : 'center'}
                , {field: 'spayment', title: '支付方式', width: 100, edit: 'text', sort: true,align : 'center'}
                , {field: 'semail', title: '电子邮箱', width: 200, edit: 'text', sort: true,align : 'center'}
                , {field: 'sendertime', title: '寄货时间', width: 100, edit: 'text', sort: true,align : 'center'}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 280,align : 'center'}
            ]]
            , page: true
        });


        //监听提交
        form.on('submit(formDemo)', function(data){
            var json=JSON.stringify(data.field);
            $.ajax({
                type: "POST",
                url: "lw/"+url,
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
                    var myDate = new Date();//获取系统当前时间


                        var a=	myDate.getFullYear()
                        var b=	myDate.getMonth()+1
                        var c=	myDate.getDate()
                        var d=	myDate.getHours()
                        var e=	myDate.getMinutes()
                       var aaa=(a+"-"+b+"-"+c+"/"+d+":"+e)

                    $("#sendertime").val(aaa)
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
                            var seid="";
                            for (var i = 0; i < data.length; i++) {
                                seid+=data[i].seid+"-";
                                console.log(data[i].seid);
                            }

                            layer.close(index);
                            //使用ajax删除选中的
                            $.ajax({
                                type : "POST",
                                url : "lw/delete",
                                data : "seid="+seid,
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
                        url: "lw/delete",
                        data:"seid="+data.seid,
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
                    "seid": data.seid
                    , "sname": data.sname
                    ,"saddress": data.saddress
                    ,"slandline": data.slandline
                    ,"sphone": data.sphone
                    ,"sdetailedaddress": data.sdetailedaddress
                    ,"spayment": data.spayment
                    ,"semail": data.semail
                    ,"sendertime": data.sendertime
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
