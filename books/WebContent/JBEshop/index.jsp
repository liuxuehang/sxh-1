<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet"
	href="/books/JBEshop/css/style.css" />
</head>
<body>
	<div id="header" class="wrap">
		<div id="logo">北大青鸟网上书城</div>
		<div id="navbar">
			<div class="userMenu">
				<ul>
					<li class="current"><a href="/books/JBEshop/index.jsp">User首页</a></li>
					<li><a href="/books/JBEshop/orderlist.jsp">我的订单</a></li>
					<li><a href="/books/JBEshop/shopping.jsp">购物车</a></li>
					<li><a href="userInfoServlet?oper=logout">注销</a></li>
				</ul>
			</div>
			<form method="get" name="search" action="">
				搜索：<input class="input-text" type="text" name="keywords" /><input
					class="input-btn" type="submit" name="submit" value="" />
			</form>
		</div>
	</div>
	<div id="content" class="wrap">
		<div class="list bookList">
			<form method="post" name="shoping"
				action="booksServlet?oper=shoppings">

				<c:choose>
					<c:when test="${empty  page}">
						<c:redirect url="../booksServlet?oper=index"></c:redirect>
					</c:when>
					<c:otherwise>
						<table>
							<tr class="title">
								<th class="checker"></th>
								<th>书名</th>
								<th class="price">价格</th>
								<th class="store">库存</th>
								<th class="view">图片预览</th>
							</tr>
							<c:forEach items="${page.data }" var="v">
								<tr>
									<td><input type="checkbox" name="bookId" value="${v.bid }" /></td>
									<td class="title"><a
										href="booksServlet?oper=shoppingItem&bid=${v.bid}">${v.bookname }</a></td>
									<td>￥${v.b_price }</td>
									<td>￥${v.stock }</td>
									<td class="thumb"><img src="${v.image }" /></td>
								</tr>
							</c:forEach>
						</table>

					</c:otherwise>  
				</c:choose>
				<div class="page-spliter">
					<c:if test="${!page.isFirst }">
						<a href="booksServlet?oper=index&pageIndex=1">首页</a>
						<a href="booksServlet?oper=index&pageIndex=${page.pageIndex-1 }">上一页</a>
					</c:if>
					<c:if test="${!page.isLast }">
						<a href="booksServlet?oper=index&pageIndex=${page.pageIndex+1 }">下一页</a>
						<a href="booksServlet?oper=index&pageIndex=${page.sumpage }">尾页</a>
					</c:if>
					当前页数:[${page.pageIndex }/${page.sumpage }]&nbsp;
				</div>
				<div class="button">
					<input class="input-btn" type="submit" name="submit" value="" />
				</div>
			</form>
		</div>
	</div>
	<div id="footer" class="wrap">北大青鸟网上书城 &copy; 版权所有</div>
</body>
</html>
