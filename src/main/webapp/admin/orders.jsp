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
    <style type="text/css">
        .layui-table-page {
            position:fixed;
        }
    </style>
</head>
<body>
<form class="layui-form" lay-filter="formfilter" enctype="multipart/form-data" id="form" style="display: none; padding: 20px;">
    <div class="layui-form-item">
        <label class="layui-form-label">ID</label>
        <div class="layui-input-block">
            <input type="text" name="oid" placeholder="只读" disabled autocomplete="off"  class="layui-input oid">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">收件人</label>
        <div class="layui-input-block">
            <select name="reid" lay-verify="" lay-search class="selOne">
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">寄件人</label>
        <div class="layui-input-block">
            <select name="seid" lay-verify="" lay-search class="selTwo">
            </select>
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
        <button class="layui-btn" lay-submit="" lay-filter="formsubmit" id="formsubmit">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
</form>
<table class="layui-table" lay-filter="tab" id="tables">
    <%--<thead>
    <tr>
        <th lay-data="{type: 'checkbox', fixed: 'left'}"></th>
        <th lay-data="{field:'oid', width:80}">ID</th>
        <th lay-data="{field:'{{data.recipients.rname}}'}">取件人Id</th>
        <th lay-data="{field:'seid', sort: true}">寄件人ID</th>
        <th lay-data="{field:'weight'}">重量</th>
        <th lay-data="{field:'amount'}">支付金额</th>
        <th lay-data="{field:'amountstate'}">支付状态</th>
        <th lay-data="{field:'state'}">状态</th>
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
        ,toolbar:'default'
        ,url: '../orders/selectLimit' //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
             {type: 'checkbox', fixed: 'left'}
            ,{field: 'oid', title: 'ID', sort: true}
            ,{field: 'rname', title: '收件人',templet: function (data) {
                return data.recipients.rname;
                }}
            ,{field: 'rname', title: '寄件人',templet: function (data) {
                    return data.sender.sname;
                }}
            ,{field: 'wayid', title: '运单号',width:200,templet: function (data) {
                    return data.waybill.wnumber;
                }}
            ,{field: 'brid', title: '网点名称',templet: function (data) {
                    return data.branch.branchname;
                }}
            ,{field: 'picid', title: '取件码',templet: function (data) {
                    return data.pickup.coding;
                }}
            ,{field: 'courid', title: '快递员',width:100,templet: function (data) {
                    return data.courier.couname;
                }}
            ,{field: 'userid', title: '用户名',templet: function (data) {
                    return data.user.username;
                }}
            ,{field: 'weight', title: '重量'}
            ,{field: 'amount', title: '支付金额'}
            ,{field: 'amountstate', title: '支付状态'}
            ,{field: 'state', title: '订单状态'}
            ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
        ]]
    });

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
            }
        });
        $("#form").reset();
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
                    url:"../orders/delete",
                    data:"id="+data.oid,
                    success:function(json){
                        layer.msg(data.oid+json.data);
                        table.reload("tables");
                    }
                });
            });
        } else if(obj.event === 'edit'){
            //行修改
            var fd=data;
            formselect("recipients",".selOne","selR","update",fd);
            formselect("lw",".selTwo","selS","update",fd);
            method="updateById";
            form.val("formfilter",{
                oid:fd.oid,
                weight:fd.weight,
                amount:fd.amount,
                amountstate:fd.amountstate,
                state:fd.state
                //reid:fd.recipients.rname,
                //seid:fd.sender.sname
            });
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
                formselect("recipients",".selOne","selR","insert");
                formselect("lw",".selTwo","selS","insert");
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
                    layer.alert("只能选择一个");
                }
                break;
            case 'update':
                if(data.length==1) {
                    var fd=data[0];
                    formselect("recipients",".selOne","selR","update",fd);
                    formselect("lw",".selTwo","selS","update",fd);
                    method="updateById";
                    form.val("formfilter",{
                        oid:fd.oid,
                        weight:fd.weight,
                        amount:fd.amount,
                        amountstate:fd.amountstate,
                        state:fd.state
                        //reid:fd.recipients.rname,
                        //seid:fd.sender.sname
                    });
                    layer.open({
                        type:1,
                        content:$('#form'),
                        title:'修改',
                        area:['400px','600px'],
                        resize:false
                    });
                }else{
                    layer.alert("只能选择一个");
                }
                break;
        };
    });
    function formselect(urlName,className,selVal,method,msg) {
        $.ajax({
            type:"post",
            url:"../"+urlName+"/selectOne",
            data:"",
            success:function(data){
                $(className).empty();
                if(method=="insert"){
                    $(className).append(new Option("请选择",1));
                }else if(method=="update"){
                    $(className).append(new Option(selVal=="selS"?msg.sender.sname:msg.recipients.rname,selVal=="selS"?msg.sender.seid:msg.recipients.reid));
                }
                $.each(data,function(index,val){
                    if(method=="update" && val.seid != msg.sender.seid && val.reid != msg.recipients.reid){
                        $(className).append(new Option(selVal=="selS"?val.sname:val.rname,selVal=="selS"?val.seid:val.reid));
                    }else if(method=="insert"){
                        $(className).append(new Option(selVal=="selS"?val.sname:val.rname,selVal=="selS"?val.seid:val.reid));
                    }
                })
                form.render();
            }
        })
    }
</script>
</body>
</html>
