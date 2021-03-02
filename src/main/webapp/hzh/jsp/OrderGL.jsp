<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta charset="utf-8">
		<title>申通快递|会员中心|客户的满意,申通的追求!</title>
		<link rel="stylesheet" href="../css/OrdelGl.css" />
		 <link rel="shortcut icon" href="../img/logo.ICO" type="image/x-icon" />
	</head>
	<body>
		<!-- 头部 -->
		<iframe src="../html/headTwo.html" width="100%" height="120px" scrolling="no"></iframe>

		<!-- 中间内容 -->
		<div class="viewOrder">
			<div class="left">
				<div class="title">
					<span><img src="../img/ordergl.png" alt="订单" title="订单" /></span>
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
				</table>
				<div class="news_list">
					<table id="newsList"></table>

					<table class="orderList">
						<tbody class="orderTbody">
						<c:forEach var="list" items="${orderList}">
						<tr>
							<td class="tablelCheckbox" width="50"> <input type="checkbox" name="checkId" value="${list.oid}">
							<td class="tableOrder" style="width:180px"> <a class="addresColor" href="../orders/detail?oid=${list.oid}">
								<c:choose>
									<c:when test="${list.state == 1}"><img src="../img/handling.png" alt="处理中"> ${list.oid} </a></c:when>
									<c:when test="${list.state == 2}"><img src="../img/canncel.png" alt="已取消"> ${list.oid} </a></c:when>
									<c:when test="${list.state == 3}"><img src="../img/finished.png" alt="已完成"> ${list.oid} </a></c:when>
								</c:choose>
								 </td>
							<td class="tablePerson" style="width:260px">
								<span class="addresColor">${list.sender.sname}</span> ${list.sender.sdetailedaddress}&gt;
								<span class="addresColor">${list.recipients.rname}</span>${list.recipients.redetailedaddress} 快件
								<span class="td_state">
									<c:choose>
										<c:when test="${list.state == 1}">处理中</c:when>
										<c:when test="${list.state == 2}">已取消 </c:when>
										<c:when test="${list.state == 3}">已完成 </c:when>
									</c:choose>
								</span> </td>
							<td class="tableTime" style="width:140px"> <span></span><span>${list.downtime}</span> </td>
							<td class="tablelOperate" style="width:125px"> <a class="addresColor" >取消订单</a>
								| <a class="addresColor">再来一单</a>  </td>
						</tr>
						</c:forEach>
						</tbody>
					</table>



				</div>

				<div class="create_order_more_page_box">
					<a class="cur" onclick="pageData(0);" href="javascript:;">1</a>共有<span class="Order_page">3</span>条订单信息
				</div>
			</div>
		</div>

		<!-- 底部 -->
		<iframe src="../html/topTwo.html" width="100%" height="200px" scrolling="no"></iframe>
	</body>
	<script type="text/javascript" src="../../html/js/jquery-3.5.1.min.js" ></script>
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
			if(index==0){
				index="";
			}
			$.ajax({
				type:"POST",
				url:"../orders/SwitchState",
				data:"state="+index,
				success:function(msg){
					$(".orderTbody").empty();
					$.each(msg,function(i,list){
						var ste;
						var stes;
						if(list.state==1){
							stes="处理中";
							ste='<img src="../img/handling.png" alt="处理中"> ';
						}else if (list.state==2){
							stes="已取消";
							ste='<img src="../img/canncel.png" alt="已取消">';
						}else if(list.state==3){
							stes="已完成";
							ste='<img src="../img/finished.png" alt="已完成">';
						}
						$(".orderTbody").append('<tr><td class="tablelCheckbox" width="50"> <input type="checkbox" name="checkId" value="'+list.oid+'">\n' +
								'\t\t\t\t\t\t\t<td class="tableOrder" style="width:180px"> <a class="addresColor" href="../orders/detail?oid='+list.oid+'">\n' +
								'\t\t\t\t\t\t\t\t'+ste+' \n' +
								'\t\t\t\t\t\t\t\t '+list.oid+'</a></td>\n' +
								'\t\t\t\t\t\t\t<td class="tablePerson" style="width:260px">\n' +
								'\t\t\t\t\t\t\t\t<span class="addresColor">'+list.sender.sname+'</span> '+list.sender.sdetailedaddress+'&gt;\n' +
								'\t\t\t\t\t\t\t\t<span class="addresColor">'+list.recipients.rname+'</span>'+list.recipients.redetailedaddress+' 快件 '+stes+' </td>\n' +
								'\t\t\t\t\t\t\t<td class="tableTime" style="width:140px"> <span></span><span>'+list.downtime+'</span> </td>\n' +
								'\t\t\t\t\t\t\t<td class="tablelOperate" style="width:125px"> <a class="addresColor" >取消订单</a>\n' +
								'\t\t\t\t\t\t\t\t<a class="addresColor">再来一单</a>  </td></tr>');
						$(".Order_page").text(i+1);
					})

				}
			})
			//location.href="../orders/selectByState?state="+index;
		})

</script>
</html>
