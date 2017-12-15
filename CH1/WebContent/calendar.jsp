<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	a:hover{
		color:red;
	}
</style>
</head>
<body>
	<div>
		<table style="text-align: center;border:1px solid black;">
			<tr>
				<td colspan="7">万年历</td>
			</tr>
			<tr>
				<td colspan="7" style="color: blue">今天是：<a href="#">
					<%
						SimpleDateFormat format = new SimpleDateFormat("yyyy年 MM月dd日");
						String date = format.format(new Date());
						/* String today = date.substring(9,11); */
						out.print(date);
					%>
					</a>
				</td>
			</tr>
			<tr>
				<td>星期天</td>
				<td>星期一</td>
				<td>星期二</td>
				<td>星期三</td>
				<td>星期四</td>
				<td>星期五</td>
				<td>星期六</td>
			</tr>
			<tr>
				<%
					for(int i=1;i<=30;i++){
						out.print("<td>"+i+"</td>");
						if(i%7==7){
							out.print("<tr>");
						}
						if(i%7==0){
							out.print("</tr>");
						}
					}
					
				%>
			</tr>
		</table>
		<div>
		</div>
	</div>
</body>
</html>