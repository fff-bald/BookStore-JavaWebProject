<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>编辑图书</title>
	<%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript" src="static/script/edit.js"></script>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
	
	input {
		text-align: center;
	}

	.errorMsg {
		float: left;
		margin-left: 10px;
		margin-top: 10px;
		color: red;
		font-size: 18px;
	}
</style>
</head>
<body>
		<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">编辑图书</span>
			<%@include file="/pages/common/manager_menu.jsp"%>
		</div>
		
		<div id="main">
			<span class="errorMsg">请输入图书相关信息:</span>
			<form action="manager/bookServlet" method="get">
				<input type="hidden" name="action" value="${empty param.id?"add":"update"}" />
				<input type="hidden" name="pageNo" value="${param.pageNo}">
				<input type="hidden" name="id" value="${requestScope.book.id}">
				<table>
					<tr>
						<td>名称</td>
						<td>价格</td>
						<td>作者</td>
						<td>销量</td>
						<td>库存</td>
						<td colspan="2">操作</td>
					</tr>		
					<tr>
						<td><input id="name" name="name" type="text" value="${requestScope.book.name}"/></td>
						<td><input id="price" name="price" type="text" value="${requestScope.book.price}"/></td>
						<td><input id="autor" name="author" type="text" value="${requestScope.book.author}"/></td>
						<td><input id="sales" name="sales" type="text" value="${requestScope.book.sales}"/></td>
						<td><input id="stock" name="stock" type="text" value="${requestScope.book.stock}"/></td>
						<td><input id="nullbool" type="submit" value="提交"/></td>
					</tr>	
				</table>
			</form>
			
	
		</div>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>