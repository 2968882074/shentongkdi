<%--
  Created by IntelliJ IDEA.
  User: hzh
  Date: 2020/12/30
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>仓库管理</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
</head>
<body>
<table class="layui-table" lay-filter="tab" lay-data="{height:512,url:'../totals/selectAll',page:true,toolbar:'default',id:'tables'}">
    <thead>
    <tr>
        <th lay-data="{type: 'checkbox', fixed: 'left'}"></th>
        <th lay-data="{field:'twid', width:80}">ID</th>
        <th lay-data="{field:'twname'}">姓名</th>
        <th lay-data="{field:'twtime', sort: true}">时间</th>
        <th lay-data="{field:'state'}">状态</th>
        <th lay-data="{field:'code'}">地区码</th>
    </tr>
    </thead>
</table>
<script src="../js/jquery-3.4.1.min.js" ></script>
<script src="../layui/layui.all.js"></script>

<script>
    var table = layui.table,layer=layui.layer,form=layui.form;
    var method=null;
    //新增修改
    form.on('submit(formsubmit)',function(data){
        layer.close(layer.index);
        $.ajax({
            type:"post",
            url:'../totals/'+method,
            data:data.field,
            success:function(json){
                table.reload("tables");
                layer.msg(json.data);
                $("#form").reset();
            }
        });
        return false;
    })

    //头工具栏事件
    table.on('toolbar(tab)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data=checkStatus.data;
        console.log(data);
        switch(obj.event){
            case 'add':
                method="insert"
                layer.open({
                    type:1,
                    content:$('#form'),
                    title:'新增',
                    area:['400px','600px'],
                    resize:false
                });
                break;
            case 'delete':
                if(data.length>0) {
                    var id="";
                    for (let i = 0; i <data.length ; i++) {
                        id=id+data[i].twid+",";
                    }
                    $.ajax({
                        type:"post",
                        url:"../totals/deleteByIds",
                        data:"id="+id,
                        success:function(json){
                            layer.msg(id+json.data);
                            table.reload("tables");
                        }
                    });
                }else{
                    layer.alert("未选中");
                }
                break;
            case 'update':
                method="updateById";
                $(".twid").val(data[0].twid);
                $(".twname").val(data[0].twname);
                $(".twtime").val(data[0].twtime);
                $(".state").val(data[0].state);
                $(".code").val(data[0].code);
                layer.open({
                    type:1,
                    content:$('#form'),
                    title:'修改',
                    area:['400px','600px'],
                    resize:false
                });
                break;
        };
    });
</script>
</body>
<form class="layui-form" enctype="multipart/form-data" id="form" style="display: none; padding: 20px;">
    <div class="layui-form-item">
        <label class="layui-form-label">ID</label>
        <div class="layui-input-block">
            <input type="text" name="twid" disabled autocomplete="off"  class="layui-input twid">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="twname" lay-verify="required|title"
                   autocomplete="off" class="layui-input twname">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">时间</label>
        <div class="layui-input-block">
            <input type="text" name="twtime" lay-verify="required|title"
                   autocomplete="off" class="layui-input twtime">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">状态</label>
        <div class="layui-input-block">
            <input type="number" name="state" lay-verify="required|title"
                   autocomplete="off" class="layui-input state">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">地区码</label>
        <div class="layui-input-block">
            <input type="text" name="code" lay-verify="required|title"
                   autocomplete="off" class="layui-input code">
        </div>
    </div>
    <div class="layui-input-block">
        <button class="layui-btn" lay-submit="" lay-filter="formsubmit" id="formsubmit">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
</form>
</html>
