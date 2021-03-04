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
<table class="layui-table" lay-filter="tab" id="tables">
   <%-- <thead>
    <tr>
        <th lay-data="{type: 'checkbox', fixed: 'left'}"></th>
        <th lay-data="{field:'twid', width:80}">ID</th>
        <th lay-data="{field:'twname'}">姓名</th>
        <th lay-data="{field:'twtime', sort: true}">时间</th>
        <th lay-data="{field:'state'}">状态</th>
        <th lay-data="{field:'code'}">地区码</th>
    </tr>
    </thead>--%>
</table>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script src="../js/jquery-3.4.1.min.js" ></script>
<script src="../layui/layui.all.js"></script>

<script>
    var table = layui.table,layer=layui.layer,form=layui.form;
    var method=null;
    //方法渲染查询
    table.render({
        elem: '#tables'
        ,height: 500
        ,toolbar:'default'
        ,url: '../totals/selectAll' //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            ,{field: 'twid', title: 'ID', sort: true}
            ,{field: 'twname', title: '姓名'}
            ,{field: 'entertwtime', title: '入仓时间'}
            ,{field: 'gotime', title: '出仓时间'}
            ,{field: 'state', title: '状态', sort: true}
            ,{field: 'code', title: '地区码',  sort: true}
            ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
        ]]
    });
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

    //监听行工具事件
    table.on('tool(tab)', function(obj){
        var data = obj.data;
        console.log(data)
        if(obj.event === 'del'){
            layer.confirm('真的删除行么', function(index){
                //行删除
                $.ajax({
                    type:"post",
                    url:"../totals/delete",
                    data:"id="+data.twid,
                    success:function(json){
                        layer.msg(data.twid+json.data);
                        table.reload("tables");
                    }
                });
            });
        } else if(obj.event === 'edit'){
            //行修改
            method="updateById";
            $(".twid").val(data.twid);
            $(".twname").val(data.twname);
            $(".entertwtime").val(data.entertwtime);
            $(".gotime").val(data.gotime);
            $(".state").val(data.state);
            $(".code").val(data.code);
            layer.open({
                type:1,
                content:$('#form'),
                title:'修改',
                area:['400px','600px'],
                resize:false
            });
        }
    });

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
                var data=data[0];
                $(".twid").val(data.twid);
                $(".entertwtime").val(data.entertwtime);
                $(".gotime").val(data.gotime);
                $(".state").val(data.state);
                $(".code").val(data.code);
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
            <input type="text" name="twid"  placeholder="只读" disabled autocomplete="off"  class="layui-input twid">
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
        <label class="layui-form-label">入仓时间</label>
        <div class="layui-input-block">
            <input type="text" name="entertwtime" lay-verify="required|title"
                   autocomplete="off" class="layui-input entertwtime">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">出仓时间</label>
        <div class="layui-input-block">
            <input type="text" name="gotime" lay-verify="required|title"
                   autocomplete="off" class="layui-input gotime">
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
