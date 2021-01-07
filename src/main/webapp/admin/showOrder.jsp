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
        ,url: '../orders/selectAll' //数据接口
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
            ,{field: 'weight', title: '重量'}
            ,{field: 'amount', title: '支付金额'}
            ,{field: 'amountstate', title: '支付状态', sort: true}
            ,{field: 'state', title: '订单状态',  sort: true}
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

    //头工具栏事件
    table.on('toolbar(tab)', function(obj){
        var checkStatus = table.checkStatus(obj.config.id);
        var data=checkStatus.data;
        console.log(data);
        switch(obj.event){
            case 'add':
                formselect("recipients",".selOne","selR","insert");
                formselect("sender",".selTwo","selS","insert");
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
                    formselect("sender",".selTwo","selS","update",fd);
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
            url:"../"+urlName+"/selectAll",
            data:"",
            success:function(data){
                $(className).empty();
                if(method=="insert"){
                    $(className).append(new Option("请选择",-1));
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
