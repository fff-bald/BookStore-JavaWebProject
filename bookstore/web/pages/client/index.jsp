<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
<%@include file="/pages/common/head.jsp"%>
<Script type="text/javascript"> $(function () {
	// 给加入购物车按钮绑定单击事件
	$("button.addToCart").click(function () {
		/**
		 * 在事件响应的 function函数中，有一个 this 对象，这个 this 对象，是当前正在响应事件的 dom 对象
		 *  @type {jQuery}
		 */

		var bookId = $(this).attr("bookId");
		location.href = "${pageScope.basePath}/bookstore/cartServlet?action=addItem&id=" + bookId;
	});
});
</Script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<div>
				<c:choose>
					<c:when test="${empty sessionScope.user}">
						<a href="pages/user/login.jsp">登录</a> |
						<a href="pages/user/regist.jsp">注册</a> &nbsp;&nbsp;
					</c:when>
					<c:otherwise>
						<span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临尚硅谷书城</span>
						<a href="userServlet?action=myOrder">我的订单</a>
						<a href="userServlet?action=logout">注销</a>
					</c:otherwise>
				</c:choose>
				<a href="pages/cart/cart.jsp">购物车</a>
				<a href="pages/manager/manager.jsp">后台管理</a>
			</div>
	</div>
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<form action="client/bookServlet" method="get">
					<input type="hidden" name="action" value="pageByPrice">
					价格：<input id="min" type="text" name="min" value="${param.min}"> 元 -
						<input id="max" type="text" name="max" value="${param.max}"> 元
						<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<c:if test="${empty sessionScope.cart.items}">
					<%--购物车为空的输出--%>
					<span> </span>
					<div>
						<span style="color: red">当前购物车为空</span>
					</div>
				</c:if>
				<c:if test="${not empty sessionScope.cart.items}">
					<%--购物车非空的输出--%>
					<span>您的购物车中有 ${sessionScope.cart.totalCount} 件商品</span>
					<div>
						您刚刚将
						<span style="color: red">${sessionScope.lastName}</span>
						加入到了购物车中
					</div>
				</c:if>
			</div>

			<c:forEach items="${requestScope.page.items}" var="book">
				<div class="b_list">
					<div class="img_div">
						<img class="book_img" alt="" src="${book.imgPath}" />
					</div>
					<div class="book_info">
						<div class="book_name">
							<span class="sp1">书名:</span>
							<span class="sp2">${book.name}</span>
						</div>
						<div class="book_author">
							<span class="sp1">作者:</span>
							<span class="sp2">${book.author}</span>
						</div>
						<div class="book_price">
							<span class="sp1">价格:</span>
							<span class="sp2">￥${book.price}</span>
						</div>
						<div class="book_sales">
							<span class="sp1">销量:</span>
							<span class="sp2">${book.sales}</span>
						</div>
						<div class="book_amount">
							<span class="sp1">库存:</span>
							<span class="sp2">${book.stock}</span>
						</div>

						<div class="book_add">
							<c:if test="${book.stock<=0}">
									正在火速为您备货！！！
							</c:if>
							<c:if test="${book.stock>0}">
							<button bookId="${book.id}" class="addToCart">加入购物车</button>
							</c:if>
						</div>
					</div>
				</div>
			</c:forEach>

		</div>

		<div id="page_nav">
			<%--大于首页，才显示--%>
			<c:if test="${requestScope.page.pageNo > 1}">
				<a href="${ requestScope.page.url }&pageNo=1">首页</a>
				<a href="${ requestScope.page.url }&pageNo=${requestScope.page.pageNo-1}">上一页</a>
			</c:if>

			<%--页码输出的开始--%>
			<c:choose>
				<%--情况 1：如果总页码小于等于 5 的情况，页码的范围是：1-总页码--%>
				<c:when test="${ requestScope.page.pageTotal <= 5 }">
					<c:set var="begin" value="1"/>
					<c:set var="end" value="${requestScope.page.pageTotal}"/>
				</c:when> <%--情况 2：总页码大于 5 的情况--%>
				<c:when test="${requestScope.page.pageTotal > 5}">
					<c:choose> <%--小情况 1：当前页码为前面 3 个：1，2，3 的情况，页码范围是：1-5.--%>
						<c:when test="${requestScope.page.pageNo <= 3}">
							<c:set var="begin" value="1"/>
							<c:set var="end" value="5"/>
						</c:when> <%--小情况 2：当前页码为最后 3 个，8，9，10，页码范围是：总页码减 4 - 总页码--%>
						<c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal-3}">
							<c:set var="begin" value="${requestScope.page.pageTotal-4}"/>
							<c:set var="end" value="${requestScope.page.pageTotal}"/>
						</c:when> <%--小情况 3：4，5，6，7，页码范围是：当前页码减 2 - 当前页码加 2--%>
						<c:otherwise>
							<c:set var="begin" value="${requestScope.page.pageNo-2}"/>
							<c:set var="end" value="${requestScope.page.pageNo+2}"/>
						</c:otherwise> </c:choose> </c:when> </c:choose>
			<c:forEach begin="${begin}" end="${end}" var="i">
				<c:if test="${i == requestScope.page.pageNo}"> 【${i}】 </c:if>
				<c:if test="${i != requestScope.page.pageNo}">
					<a href="${ requestScope.page.url }&pageNo=${i}">${i}</a>
				</c:if> </c:forEach> <%--页码输出的结束--%>

			<%-- 如果已经 是最后一页，则不显示下一页，末页 --%>
			<c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
				<a href="${ requestScope.page.url }&pageNo=${requestScope.page.pageNo+1}">下一页</a>
				<a href="${ requestScope.page.url }&pageNo=${requestScope.page.pageTotal}">末页</a>
			</c:if>
			共${ requestScope.page.pageTotal }页，${ requestScope.page.pageTotalCount }条记录 到第

			<input value="${empty param.pageNo?"1":param.pageNo}" name="pn" id="pn_input"/>页
			<input id="searchPageBtn" type="button" value="确定">
		</div>
		<script type="text/javascript"> $(function () {
			// 跳到指定的页码
			$("#searchPageBtn").click(function () {
				var pageNo = $("#pn_input").val();
				<%--var pageTotal = ${requestScope.page.pageTotal};--%>
				<%--alert(pageTotal);--%>
				// javaScript 语言中提供了一个 location 地址栏对象
				// 它有一个属性叫 href.它可以获取浏览器地址栏中的地址
				// href 属性可读，可写
			location.href = "${pageScope.basePath}${ requestScope.page.url }&pageNo=" + pageNo;
			});
		});
		</script>
	</div>

	<%@include file="/pages/common/footer.jsp"%>
</body>
</html>