<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>申通快递|会员中心|客户的满意,申通的追求!</title>
		<link rel="stylesheet" href="../css/OrdelGl.css" />
		 <link rel="shortcut icon" href="../img/logo.ICO" type="image/x-icon" />
		 <link rel="stylesheet" href="../css/headTwo.css" />
	</head>
	<body>
		<!-- 头部 -->
		<iframe src="../headTwo.html" width="100%" scrolling="no"></iframe>
		<!-- <div id="head">
			<dl>
				<dt>退出</dt>
				<dt>您好,185******19</dt>
			</dl>
		</div>
		<div id="head_up">
			<dl>
				    <dt><a href="../index.html"><img src="../头部底部图片/申通快递.png" style="margin-top: 12px;"/></a></dt>
				    <dt><a href="../index1.html">首页</a></dt>
			        <dt><a href="../ship.html">在线寄件</a></dt>
			        <dt><a href="../waybill.html">运单查询</a></dt>
			        <dt><a href="../OrderGL.jsp">订单管理</a></dt>
			        <dt><a href="../user.html">账户管理</a></dt>
			        <dt><a href="../Agreement.html">协议客户</a></dt>
			        <dt><a href="../league.html">网点申请</a></dt>
			</dl>
		</div> -->
		<!-- 中间内容 -->
				<div class="viewOrder">
					<div class="left">
						<div class="title">
							<span><img src="../订单图片/order.png" alt="订单" title="订单" /></span>
							<span class="titleText">订单管理</span>
						</div>
						<div class="adress_top_tab">
							<ul>
								<li style="width: 33%;" class="all on">全部订单</li>
								<li style="width: 33%;" class="hand">处理中</li>
								<li style="width: 34%;" class="cancel">已取消</li>
								<li style="width: 33%;" class="finish">已完成</li>
							</ul>
						</div>
					</div>
					<div class="right">
						<div class="orderInputBox">
							<input type="text" id="orderId" class="orderSearchBox" maxlength="25" placeholder="请输入申通快递订单编号" /><input type="button"
							 class="orderSearchBtn" value="搜索" />
						</div>
						<table id="orderList" border="0" cellpadding="0" cellspacing="0">
							<tr class="titleBox">
								<th class="titleCheckbox" height="20">
									<input type="checkbox" name="AllcheckId" id="AllcheckId" style="width:15px" />
								</th>
								<th class="titleOrder">订单编号</th>
								<th class="titlePerson">寄件人 > 收件人</th>
								<th class="titleTime">下单时间</th>
								<th class="titleOperate">操作</th>
							</tr>
							<c:forEach var="list" items="${orderList}">
							<tr>
								<td></td>
								<td>${list.oid}</td>
								<td>${list.sender.sname} > ${list.recipients.rname}</td>
								<td>${list.downtime}</td>
								<td>修改</td>
							</tr>
							</c:forEach>
						</table>
					</div>
				</div>

		<!-- 底部 -->
		<iframe src="../topTwo.html" width="100%" height="200px" scrolling="no"></iframe>
	</body>
	<script type="text/javascript" src="../html/js/jquery-3.5.1.min.js" ></script>
	<script type="text/javascript">
		/*$(function () {
			//location.href="../orders/selectByState";
			$.ajax({
				type:"POST",
				url:"../orders/selectByState",
				data:"state=1",
				dataType: 'html',
				success:function(msg){

				}
			})
		})*/
		$(".adress_top_tab ul li").click(function () {
			var index=$(this).index();
			$(this).css("color","#ee6900").siblings(".adress_top_tab ul li").css("color","black");
			/*$.ajax({
				type:"POST",
				url:"../orders/selectByState",
				data:"state=1",
				dataType: 'html',
				success:function(msg){

				}
			})*/
			if(index==0){
				index="";
			}
			location.href="../orders/selectByState?state="+index;
		})

</script>
</html>
