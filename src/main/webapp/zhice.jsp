<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" href="css/zhuce.css" />
		
	</head>
	<body style="background-color:#f0f4f5;">
		<div class="body">
		<div id="headup">
			<img style="margin-left: 400px;" src="img/logo.png" >
		</div>
		<div class="headdawn">
			<div class="left">
				<div class="title">
					<span style="color: #eb6b00;;"  >欢迎注册成为申通会员</span>
				</div>
				<div class="inpt">
					<input placeholder="请输入手机号" />
					<input class="inpt02" style="width: 165px;" placeholder="请输入验证码" />
					<button id="code" style="cursor: pointer;"  onclick="getCode()">发送验证码</button>
					
					<input class="inpt02" placeholder="请输入密码" />
					<input class="inpt02" placeholder="请再次输入密码" />
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
					<input style="cursor: pointer;" type="button" class="LoginBtn" value="注册" />
				</p>
				<p class="p1" style="font-size: 12px; text-align: center;">
					<span>以有申通账号？</span>
					<span style="color:#ee6a00;cursor: pointer;"><a href="denglu.html" style="color:#ee6a00 ;">直接登录</a></span>
				</p>
				<img class="img" src="img/sort.png" />
			</div>
			<div class="right">
				<p>
					<img class="img2" src="img/wechat_official_account.jpg" />
				</p>
				<p class="p">
					扫描关注申通微信公众号
				</p>
			</div>
		</div>
		</div>
	</body>
	<script src="js/jquery-3.4.1.min.js"type="text/javascript"></script>
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
			var start=true;//申明变量记录是否有点击
			function getCode(){
				//判断是否开启
				if(start==true){
					//设置记录变量为假
					start=false;
				document.getElementById("code").innerText=60;
				document.getElementById("code").disabled=true;
				//得到定时器
				time=setInterval("update()",1000);
				//使用ajax去发送验证
					}
			}
			function update(){
				count--;
				document.getElementById("code").innerText=count;
				//判断是否已经到0
				if(count<=0){
					start=true;//设置值重新到初始值
					count=60;
					//如果到0就清除定时器
					clearInterval(time);
					//文字还原
					document.getElementById("code").innerText='获取验证码';
					//按钮重新打开
					document.getElementById("code").disabled=false;
				}
			}
	</script>
</html>
