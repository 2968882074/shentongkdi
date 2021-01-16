

var form;
var layfilter;

var layuiData={
    on:function(){
        form = $("form[name=layui-form]");
    },
    /*显示修改或新增面板*/
    show_AddAndUpdate:function(method,title,data=null){
        if(method == 'add'){
            /*清楚表单数据*/
            document.getElementById("form").reset()
        }else if(method == 'update'){
            /*表单赋值*/
            form.val("forms",data);
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
}