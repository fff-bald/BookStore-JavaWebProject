<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>订单详细信息</title>
	<%@include file="/pages/common/head.jsp"%>
</head>
<body>
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">订单信息</span>
		<%@include file="/pages/common/manager_menu.jsp"%>
	</div>
	<div align="center" style="font-size: 20px;">
		用户：	${sessionScope.user.username}
		<br>
		订单号： ${param.oid}


	</div>
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>数量</td>
				<td>总价</td>
			</tr>
			<c:forEach items="${requestScope.items}" var="item">
				<tr>
					<td>${item.name}</td>
					<td>${item.price}</td>
					<td>${item.count}</td>
					<td>${item.totalPrice}</td>
				</tr>
			</c:forEach>

		</table>
	</div>
	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>