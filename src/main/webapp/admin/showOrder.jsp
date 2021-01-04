<%--
  Created by IntelliJ IDEA.
  User: hzh
  Date: 2020/12/29
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单管理</title>
    <link rel="stylesheet" href="../layui/css/layui.css">
</head>
<body>
<table class="layui-table" lay-filter="tab" lay-data="{height:512,url:'../orders/selectAll',page:true,toolbar:'default',id:'tables'}">
    <thead>
    <tr>
        <th lay-data="{type: 'checkbox', fixed: 'left'}"></th>
        <th lay-data="{field:'oid', width:80}">ID</th>
        <th lay-data="{field:'picid'}">取件人Id</th>
        <th lay-data="{field:'seid', sort: true}">寄件人ID</th>
        <th lay-data="{field:'weight'}">重量</th>
        <th lay-data="{field:'amount'}">支付金额</th>
        <th lay-data="{field:'amountstate'}">支付状态</th>
        <th lay-data="{field:'state'}">状态</th>
    </tr>
    </thead>
</table>
<script src="../js/jquery-3.5.1.min.js" ></script>
<script src="../layui/layui.all.js"></script>

<script>
    var table = layui.table,layer=layui.layer,form=layui.form;
    var method=null;
    //新增修改
    form.on('submit(formsubmit)',function(data){
        layer.close(layer.index);
        $.ajax({
            type:"post",
            url:'../orders/'+method,
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
                        id=id+data[i].oid+",";
                    }
                    $.ajax({
                        type:"post",
                        url:"../orders/deleteByIds",
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
                $(".oid").val(data[0].oid);
                $(".picid").val(data[0].picid);
                $(".seid").val(data[0].seid);
                $(".weight").val(data[0].weight);
                $(".amount").val(data[0].amount);
                $(".amountstate").val(data[0].amountstate);
                $(".state").val(data[0].state);
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
            <input type="text" name="oid" disabled autocomplete="off"  class="layui-input oid">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">取件人ID</label>
        <div class="layui-input-block">
            <input type="text" name="picid" lay-verify="required|title"
                   autocomplete="off" class="layui-input picid">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">寄件人ID</label>
        <div class="layui-input-block">
            <input type="text" name="seid" lay-verify="required|title"
                   autocomplete="off" class="layui-input seid">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">重量</label>
        <div class="layui-input-block">
            <input type="number" name="weight" lay-verify="required|title"
                   autocomplete="off" class="layui-input weight">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">支付金额</label>
        <div class="layui-input-block">
            <input type="number" name="amount" lay-verify="required|title"
                   autocomplete="off" class="layui-input amount">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">支付状态</label>
        <div class="layui-input-block">
            <input type="number" name="amountstate" lay-verify="required|title"
                   autocomplete="off" class="layui-input amountstate">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">状态</label>
        <div class="layui-input-block">
            <input type="number" name="state" lay-verify="required|title"
                   autocomplete="off" class="layui-input state">
        </div>
    </div>
    <div class="layui-input-block">
        <button class="layui-btn" lay-submit="" lay-filter="formsubmit" id="formsubmit">立即提交<tton>
            <button type="reset" class="layui-btn layui-btn-primary">重置<tton>
    </div>
</form>
</html>
