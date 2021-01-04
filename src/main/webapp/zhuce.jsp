<%--
  Created by IntelliJ IDEA.
  User: YYing
  Date: 2020/12/28
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <script type="text/javascript" src="js/jquery-3.5.1.min.js"></script>
</head>
<body>
<center>
    <h1>注册</h1><br>
    <form id="uploadForm" enctype="" method="post">
        <input type="text" id="uphone" placeholder="请输入电话"> <br>
        <div class="controller"><input type="text" id="code">
            <a href="javascript:void(0)" id="getCode">获取验证码</a></div>
        <div class="controller"><button>效验</button></div>
    </form>
</center>
</body>
<%--<script>
    function cx() {
        var formObj = document.getElementById("uploadForm");
        var formData = new FormData(formObj);
        $.ajax({
            url:"user/zhuce",
            type:"post",
            data:formData,
            processData : false,
            contentType : false,
            success:function(json) {
                alert(json.back);
                window.location.href="index.jsp";
            }
        });
    }
</script>--%>
<script type="text/javascript">
    var obj=document.getElementById("getCode");
    var flag=60;//全局变量
    obj.onclick=function () {
        //控制时间
        if (flag<60){
            return;
        }
        //ajax
        var xhr=new XMLHttpRequest();
        xhr.open("get","getCode.do?phone="+document.getElementById("uphone").value,true);//true表示异步请求
        //监听请求的状态
        xhr.onreadystatechange=function(){
            if(xhr.readyState==4&&xhr.status==200){
                alert(xhr.responseText);
            }
        }
        xhr.send(null);
        timer();
    }


    //计时器
    function  timer() {
        flag--;
        obj.innerHTML=flag+"秒之后重新获取验证码";
        if(flag==0){
            obj.innerHTML="获取验证码";
            flag=60;
        }else {
            setTimeout("timer()",1000);//递归调用
        }
    }


</script>
</html>
