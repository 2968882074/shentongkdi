<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<link rel="stylesheet" href="html/css/denglu.css" />
		
	</head>
	<body style="background-color:#f0f4f5;">
		<div class="body">
		<div id="headup">
			<img style="margin-left: 400px;" src="html/img/logos.png" >
		</div>
		<div class="headdawn">
			<div class="left">
				<div class="title">
					<a href="javascript:void(0)" style="color: #555;" onclick="qwe(this)" id="denglu" >账户登录</a>
					<span style="font-size: 12px;color: #ececec;margin: 0 35px;">|</span>
					<a href="javascript:void(0)"  style="color: #555;" onclick="qwes(this)" id="denglu2">短信登录</a>
				</div>
				<div class="inpt" id="inpts">
					<input  type="text"  id="uphone"  name="uphones"  placeholder="请输入手机号" />
					<input  name="userpass"  id="inpt02" placeholder="请输入密码" />
					<input  class="inpt03"  id="code" name="code" style="width: 165px;" placeholder="请输入验证码" />
					<a href="javascript:void(0)" id="getCode"><button  id="codes" style="cursor: pointer;"  onclick="getCodes()">获取验证码</button></a>
				</div>
				<p class="wjmm" style="color: #eb6b00; font-size: 12px;">
					忘记密码？
				</p>
				<p>
					<input style="cursor: pointer;" type="button" onclick="yanzhen()" class="LoginBtn" value="登录" />
				</p>
				<p class="p1" style="font-size: 12px; text-align: center;">
					<span>还没有申通快递？</span>
					<span style="color:#ee6a00">《服务条款》</span>
					<span>| </span>
					<span style="color:#ee6a00;cursor: pointer;"><a href="zhice.jsp"  style="color: #ee6a00;";>立即注册</a></span>
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
			$("#inpt02").css("display","block");
			$(".inpt03").css("display","none");
			$("#codes").css("display","none");
		}
		function qwes(me){
			$(me).css("color","#ee6902");
			$("#denglu").css("color","#555");
			$(".inpt03").show();
			$("#codes").show();
			$("#inpt02").css("display","none");
		}
		//获取验证码
		var count=60;
		var time=null;
		var start=true;//申明变量记录是否有点击
		function getCodes(){
			var uphone=document.getElementById('uphone').value;
			//判断是否开启

			$.ajax({
				url:"user/denglu",
				type:"post",
				data:"uphone="+uphone,
				dataType: "json",
				success:function(state) {
					if (state == 1) {
						if (start == true) {//设置记录变量为假
							start = false;
							document.getElementById("codes").innerText = 60;
							document.getElementById("codes").disabled = true;
							//得到定时器
							time = setInterval("update()", 1000);
						}
						$.ajax({
							url:"getCode/yzm",
							type:"post",
							data:"uphones="+uphone,
							success: function (msg) {
								alert(msg);
							}
						})
					}else{
						alert("账号不存在！");
					}
				}
				})
		}
		//验证验证码
		function yanzhen() {
			var code=document.getElementById('code').value;
			alert(code);
			$.ajax({
				url:"getCode/yzyzms",
				type:"post",
				data:"code="+code,
				success:function(msg){
					alert(msg);
					if(msg=="好大哥登录成功！将为您跳到主页！"){
						window.location.href="baidu.html";
					}
				}
			});
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
