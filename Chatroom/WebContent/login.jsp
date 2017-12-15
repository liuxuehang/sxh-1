<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/messages_zh.js"></script>
<style type="text/css">
#div_one {
	width: 1440px;
	height: 900px;
	background-image: url(img/1037894.jpg);
}

#input_img2 {
	background-image: url(img/button_login.gif);
	width: 76px;
	height: 30px;
}

#div_two {
	border: 2px solid red;
	margin: 80px 50px 0px 350px;
	width: 380px;
	height: 50px;
	text-align: center;
	color: blueviolet;
}

.table_1 {
	border: 2px solid yellowgreen;
	text-align: center;
	width: 381px;
	height: 280px;
	margin: 0px 10px 20px 350px;
	color: blueviolet;
}

table tr {
	width: 90px;
}

td {
	width: 88px;
	margin: 0px 0px 0px 3px;
}
</style>
<script type="text/javascript">
	$(function() {
		$("img").click(function() {
			$(this).attr("src", "Num.jsp?d=" + new Date());
		})

		/* //表单验证
		$("#LoginForm").validate({

			rules : {
				username : {
					required : true,
					minlength : 2
				},
				pwd : {
					required : true,
					minlength : 6
				}

			},
			messages : {
				username : {
					required : "用户名不为空",
					minlength : "长度不小于2"
				},

				pwd : {
					required : "密码不能为空",
					minlength : "长度不小于6"
				}

			}
		}); */

	});
	
</script>
</head>

<body>
	<%
		if (request.getAttribute("mark") != null) {
			out.print("<script>alert('验证码错误 ---注册失败')</script>");
		}
		if(request.getAttribute("count") != null){
			out.print("<script>alert('此用户已在另一台电脑登录!');</script>");
		}
	%>
	<div id="div_one">
		<div id="div_two">
			<h2>欢迎登录</h2>
		</div>
		<form class="form_one" method="post" action="UserSevlet?oper=login" id="LoginForm">
			<table class="table_1">
				<tr>
					<td>用户名</td>
					<td><input type="text" id="username" name="username" /><span
						id="spanusernam"></span></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input type="password" id="pwd" name="pwd" /><span
						id="spanusername"></span></td>
				</tr>
				<tr>
					<td class="td">验证码:</td>
					<td><input type="text" name="validata" size="7" /><img
						src="Num.jsp"><span type="text" id="yanzheng"
						name="yanzheng"></span></td>
				</tr>
				<tr>

					<td><a href="register.jsp" style="color: red">注册</a></td>
					<td><input type="submit" id="input_img2" value="" /></td>
				</tr>
			</table>

		</form>

	</div>
</body>

</html>