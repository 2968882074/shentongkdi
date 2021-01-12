<%--
  Created by IntelliJ IDEA.
  User: YYing
  Date: 2021/1/4
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>付费表的layui</title>
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">
</head>
<body>
<div id="chargeDiv" style="display:none;width:320px;margin-top:30px;">
    <form id=myFrom class="layui-form" lay-filter="formTest">
        <div class="layui-form-item">

            <div class="layui-input-inline">
                <input name="chid" readonly="readonly" required="required"   class="layui-input" type="hidden">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">始发地</label>
            <div class="layui-input-inline">
                <input type="text" name="commence" required lay-verify="required" placeholder="请输入始发地" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">目的地</label>
            <div class="layui-input-inline">
                <input type="text" name="those" required lay-verify="required" placeholder="请输入目的地" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">物品重量</label>
            <div class="layui-input-inline">
                <input type="text" name="goods" required lay-verify="required" placeholder="请输入物品重量" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">日期</label>
            <div class="layui-input-inline">
                <input type="text" name="chargetime" required lay-verify="required" placeholder="请输入日期" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">现付参考价格</label>
            <div class="layui-input-inline">
                <input type="text" name="price" required lay-verify="required" placeholder="请输入现付参考价格" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">预计到达时间</label>
            <div class="layui-input-inline">
                <input type="text" name="predicttime" required lay-verify="required" placeholder="请输入预计到达时间" autocomplete="off" class="layui-input">
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
    日期：
    <div class="layui-inline">
        <input class="layui-input" name="chargetime" id="chargetime" autocomplete="off" placeholder="请输入日期">
    </div>
    <button class="layui-btn" data-type="reload" lay-event="search">搜索</button>
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
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
            , url: 'charge/selectAll'
            , toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            , defaultToolbar: ['filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
                title: '提示'
                , layEvent: 'LAYTABLE_TIPS'
                , icon: 'layui-icon-tips'
            }]
            , title: '线路管理数据表'
            , cols: [[
                {type: 'checkbox', fixed: 'left'}
                , {field: 'chid', title: '收费id', width: 160, fixed: 'left', unresize: true, sort: true,align : 'center'}
                , {field: 'commence', title: '始发地', width: 160, edit: 'text',align : 'center'}
                , {field: 'those', title: '目的地', width: 160, edit: 'text',align : 'center'}
                , {field: 'goods', title: '物品的重量', width: 160, edit: 'text', sort: true,align : 'center'}
                , {field: 'chargetime', title: '日期', width: 160, edit: 'text', sort: true,align : 'center'}
                , {field: 'price', title: '现付参考价格', width: 160, edit: 'text', sort: true,align : 'center'}
                , {field: 'predicttime', title: '预计到达时间', width: 160, edit: 'text', sort: true,align : 'center'}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 180,align : 'center'}
            ]]
            , page: true
        });


        //监听提交
        form.on('submit(formDemo)', function(data){
            var json=JSON.stringify(data.field);
            $.ajax({
                type: "POST",
                url: "charge/"+url,
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
                    url="add";
                    //清空表单
                    $("#myFrom")[0].reset();

                    layer.open({
                        type:1,
                        title:'新增收费',
                        offset: '100px',
                        area: ['400px','480px'],
                        shadeClose: true,
                        shade: false,
                        maxmin: true, //开启最大化最小化按钮
                        content: $('#chargeDiv')
                    });
                    break;
                case 'search':
                    //得到输入框的值
                    var value=$("#chargetime").val();
                    //执行重载
                    table.reload('test', {
                        url : "charge/selectAll?chargetime="+value
                        ,page : {
                            curr : 1
                            //重新从第 1 页开始
                        }
                    });
                    $("#chargetime").val(value);//刷新值会被消除，则需要重新设定
                    break;
                case 'deleteid'://删除多个
                    var data = checkStatus.data;
                    //layer.alert(JSON.stringify(data));
                    if(data.length>0){
                        layer.confirm('真的要删除么', function(index) {
                            //获取所有选中的id
                            var chid="";
                            for (var i = 0; i < data.length; i++) {
                                chid+=data[i].chid+"-";
                                console.log(data[i].chid);
                            }

                            layer.close(index);
                            //使用ajax删除选中的
                            $.ajax({
                                type : "POST",
                                url : "charge/delete",
                                data : "chid="+chid,
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
                        url: "charge/delete",
                        data:"chid="+data.chid,
                        success: function(msg){
                            layer.alert("删除成功！");
                        }
                    });
                });
            } else if(obj.event === 'edit'){
                url="updateById";
                //给表单赋值
                form.val("formTest", {
                    "chid": data.chid
                    , "commence": data.commence
                    ,"those": data.those
                    ,"goods": data.goods
                    ,"chargetime": data.chargetime
                    ,"price": data.price
                    ,"predicttime": data.predicttime
                });


                layer.open({
                    type: 1,
                    title: '修改',
                    shadeClose: true,
                    shade: false,
                    maxmin: true, //开启最大化最小化按钮
                    offset: '100px',
                    area: ['400px','480px'],
                    content: $("#chargeDiv")
                });
            }
        });
    });
</script>
</body>
</html>
