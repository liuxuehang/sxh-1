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
#div_2 {
	border: 1px solid palegoldenrod;
	margin: 80px 50px 0px 350px;
	width: 500px;
	height: 50px;
	text-align: center;
	color: gold;
}

.table_1 {
	border: 1px solid yellowgreen;
	text-align: center;
	width: 500px; 
	height: 280px;
	margin: 0px 10px 20px 350px;
	color: blueviolet;
}

table tr {
	width: 40px;
	border:1px solid yellowgreen;
}

td {
	width: 88px;
	border:1px solid yellowgreen;
	text-align:left;
}

.g_img {
	background-image: url(img/button_reg.gif);
	width: 146px;
	height: 45px;
}
</style>
<script type="text/javascript">
	$(function() {

		$("img").click(function() {
			$(this).attr("src", "Num.jsp?d=" + new Date());
		})

		//表单验证
		$("#registerForm").validate({

			rules : {
				username : {
					required : true,
					minlength : 1
				},
				nickname : {
					required : true,
					minlength : 2
				},
				pwd : {
					required : true,
					minlength : 6
				},
				repwd : {
					required : true,
					equalTo : "#pwd"
				}
				,
				validata:{
					required :true,
					
				}

			},
			messages : {
				username : {
					required : "用户名不为空",
					minlength : "长度不小于2"
				},
				nickname : {
					required : "昵称不能为空",
					minlength : "长度不小于2"
				},
				pwd : {
					required : "密码不能为空",
					minlength : "长度不小于6"
				},
				repwd : {
					required : "不能为空",
					equalTo : "两次密码不一致"
				},
				validata :{
					required:"验证码不能为空"
				}
			}
		});
	});

	//判断用户是否存在
	function test() {
		var username = $("#username").val();

		if (username != null) {
			var data = {
				username : username
			};
			$.post("UserSevlet?oper=Checkusername", data, function(result,
					status) {
				$("#spanname").text("");				
					if (result == true) {
						$("#spanname").text("用户可以使用").css({
							"color" : "green"
						});
					} else if (result == false){
						$("#spanname").text("用户已存在").css({
							"color" : "red"
						});
					}else{
						$("#spanname").text("");
					}
				
				
			});
		}
	}
</script>
</head>
<body background="img/1037894.jpg">
	<%
		if(request.getAttribute("mark")!=null){
			out.print("<script>alert('验证码错误 ---注册失败')</script>");
		}
	%>
	<div id="div_2">
		<h2>欢迎注册理想IT聊天室</h2>
	</div>
	<form id="registerForm" method="post" action="UserSevlet?oper=add">
		<table class="table_1">
			<tr>
				<td class="td">用户名:</td>
				<td><input type="text" id="username" name="username"
					onblur="test()" /><span type="text" id="spanname" name="spanname"></span></td>
			</tr>
			<tr>
				<td class="td">昵称：</td>
				<td><input type="text" id="nickname" name="nickname" /><span
					type="text" id="spannick" name="spannick"></span></td>
			</tr>
			<tr>
				<td class="td">密码：</td>
				<td><input type="password" id="pwd" name="pwd" /><span
					type="text" id="spanpwd" name="spanpwd"></span></td>
			</tr>
			<tr>
				<td class="td">确认密码:</td>
				<td><input type="password" id="repwd" name="repwd" /><span
					type="text" id="spanrepwd" name="spanrepwd"></span></td>
			</tr>

			<tr>
				<td class="td">验证码:</td>
				<td><input type="text" id="validata" name="validata" size="7" /> <img src="Num.jsp"></td>
			</tr>
			<tr>
				<td class="td"><a href="login.jsp" style="color:red;">登录</a></td>
				<td><input class="g_img" type="submit" name="register" value=""
					id="registerBtn" /></td>
			</tr>
		</table>
	</form>
</body>
</html>