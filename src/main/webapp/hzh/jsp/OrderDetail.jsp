<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<meta charset="utf-8">
		<title>申通快递|会员中心|客户的满意,申通的追求!</title>
		<link rel="stylesheet" href="../css/OrderDetail.css" />
		<link rel="shortcut icon" href="../img/logo.ICO" type="image/x-icon" />
	</head>
	<body style="background-color: #f0f4f5;">
		<!-- 头部 -->
		<iframe src="../html/headTwo.html" width="100%" height="120px" scrolling="no"></iframe>

		<!-- 中间内容 -->
		<div class="orderdetailTitle">订单详情&gt;订单编号：ST20210223150282888</div>
		<div class="orderdetailline"></div>
		<div class="box">
			<div class="viewOrderNum">
				<div class="resultBox">
					<div class="resultBoxTop">
						<span class="titleOne">订单编号：${orderDetail.oid}</span>
						<span class="titleTwo">订单状态：未完成
						<c:forEach items="${map}" var="m">
							${m.value}
						</c:forEach>
						</span>
					</div>
					<div class="resultBox">
						<div class="resultNo">
							<div class="resultList">
								<ul id="trackList">
									<li>
										<div class="listTwo">订单已取消</div>
										<div class="listOne"></div>
										<div class="listThree"></div>
										<div class="clear"></div>
										<div class="order_bottom_title">物流信息</div>
										<div class="listInfo" style="display: block;">
											<div>当前订单还没有物流信息</div>
											<ul>
											</ul>
										</div>
									</li>
								</ul>
								<div class="orderdetail_bottom_messge" style="overflow: hidden;">
									<div class="order_bottom_title">订单信息</div>
									<div oncancel="order_bottom_contont_left" style="width:50%;float:left;">
										<div class="order_bottom_contont">
											寄件人信息：
											<br>
											&nbsp;&nbsp;&nbsp;&nbsp;<span class="addresColor">寄件人地址：安徽省合肥市瑶海区测试1</span>
											<br>
											&nbsp;&nbsp;&nbsp;&nbsp;<span class="addresColor">寄件人姓名：测试</span>
											<br>
											&nbsp;&nbsp;&nbsp;&nbsp;<span class="addresColor">寄件人电话：177******77</span>
										</div>
										<div class="order_bottom_contont">
											收件人信息：
											<br>
											&nbsp;&nbsp;&nbsp;&nbsp;<span class="addresColor">收件人地址：安徽省芜湖市芜湖县测试2</span>
											<br>
											&nbsp;&nbsp;&nbsp;&nbsp;<span class="addresColor">收件人姓名：测试啊</span>
											<br>
											&nbsp;&nbsp;&nbsp;&nbsp;<span class="addresColor">收件人电话：177******77</span>
										</div>
									</div>
									<div class="order_bottom_contont_right">
										<div class="order_bottom_contont">取件时间：2021/2/23 15:55:24 - 2021/2/23 18:55:24</div>

										<div class="order_bottom_contont">下单时间：2021/2/23 15:55:24</div>
										<div class="order_bottom_contont">订单状态：未完成</div>
										<div class="order_bottom_contont">下单渠道：官网会员中心</div>
										<div class="order_bottom_contont">取件码：795896</div>
										<div class="order_bottom_contont">物品类型：其他:测试</div>
										<div class="order_bottom_contont">加价金额：0<span>元</span></div>
										<div class="order_bottom_contont">客户留言：测试，请不要 处理</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="content_buttom">
						<a class="order_print" onclick="AgainOrder('ST20210223150282888')">再来一单</a>
					</div>
				</div>
			</div>
		</div>
		<!-- 底部 -->
		<iframe src="../html/topTwo.html" width="100%" height="200px" scrolling="no"></iframe>
	</body>
</html>
