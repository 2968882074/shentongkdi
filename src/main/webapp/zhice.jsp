<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" href="html/css/zhuce.css" />
		
	</head>
	<body style="background-color:#f0f4f5;">
		<div class="body">
		<div id="headup">
			<img style="margin-left: 400px;" src="html/img/logos.png" >
		</div>
		<div class="headdawn">
			<div class="left">
				<div class="title">
					<span style="color: #eb6b00;;"  >欢迎注册成为申通会员</span>
				</div>
				<div class="inpt" id="inpts">
					<input  type="text" id="uphone" name="uphone"  placeholder="请输入手机号" />
					<input class="inpt02"  id="code" name="code" style="width: 165px;" placeholder="请输入验证码" />
					<a href="javascript:void(0)" id="getCode"><button  id="codes" style="cursor: pointer;"  onclick="getCodes()">获取验证码</button></a>
					<input class="inpt02" name="userpass" id="userpass" placeholder="请输入密码" />
					<input class="inpt02"  placeholder="请再次输入密码" />
					<p>
					<input style="width: 13px; height: 13px;" class="kk" style="vertical-align: middle;" type="checkbox" checked=""/>
					<span style="font-size: 12px;">我同意</span>
					<span style="color:#ee6a00;font-size: 12px;">《会员注册服务条款》</span>
					</p>	
					
				</div>
				<p class="wjmm" style="color: #eb6b00; font-size: 12px;">
					忘记密码？
				</p>
				<p>
					<input style="cursor: pointer;" type="button" onclick="yanzhen()" class="LoginBtn" value="注册" />
				</p>
				<p class="p1" style="font-size: 12px; text-align: center;">
					<span>以有申通账号？</span>
					<span style="color:#ee6a00;cursor: pointer;"><a href="denglu.html" style="color:#ee6a00 ;">直接登录</a></span>
				</p>
				<img class="img" src="html/img/sorts.png" />
			</div>
			<div class="right">
				<p>
					<img class="img2" src="html/img/erwema.jpg" />
				</p>
				<p class="p">
					扫描关注申通微信公众号
				</p>
			</div>
		</div>
		</div>
	</body>
	<script src="html/js/jquery-3.5.1.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		
		function qwe(me){
			$(me).css("color","#ee6902");
			$("#denglu2").css("color","#555");
		}
		function qwes(me){
			$(me).css("color","#ee6902");
			$("#denglu").css("color","#555");
		}
			//获取验证码
			var count=60;
			var time=null;
			var obj=document.getElementById("getCode");
			var start=true;//申明变量记录是否有点击
			obj.onclick=function () {
			//ajax
			var xhr=new XMLHttpRequest();
			xhr.open("get","getCode/yzms?uphone="+document.getElementById("uphone").value,true);//true表示异步请求
			//监听请求的状态
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4&&xhr.status==200){
					alert(xhr.responseText);
				}
			}
			xhr.send(null);
		}


			function getCodes(){
				//判断是否开启
				if(start==true){
					//设置记录变量为假
					start=false;
				document.getElementById("codes").innerText=60;
				document.getElementById("codes").disabled=true;
				//得到定时器
				time=setInterval("update()",1000);
				//使用ajax去发送验证
					}
			}

		//验证验证码
		function yanzhen() {
			var code=document.getElementById('code').value;
			var uphone=$("#uphone").val();
			var userphone=$("#userpass").val();
				$.ajax({
					url:"getCode/yzyzm",
					type:"post",
					data:"code="+code,
					success:function(msg){
						alert(msg);
						if(msg=="牛逼,注册成功！直接为大哥跳到登录！"){
						$.ajax({
							url:"user/zhuce",
							type:"post",
							data:"uphone="+uphone+"&userpass="+userphone,
							success:function(json) {
								window.location.href="denglu.jsp";
							}
						});
						}
				}
				})
			}
			function update(){
				count--;
				document.getElementById("codes").innerText=count;
				//判断是否已经到0
				if(count<=0){
					start=true;//设置值重新到初始值
					count=60;
					//如果到0就清除定时器
					clearInterval(time);
					//文字还原
					document.getElementById("codes").innerText='获取验证码';
					//按钮重新打开
					document.getElementById("codes").disabled=false;
				}
			}
	</script>
</html>
