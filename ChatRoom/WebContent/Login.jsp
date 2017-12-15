<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>理想IT聊天室登录页面</title>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("img").click(function() {
			$(this).attr("src", "Num.jsp?d=" + new Date());
		});
		$("#regForm").validate({
			rules : {
				userName : {
					required : true,
					minlength : 2
				},
				pwd : {
					required : true,
					rangelength : [ 6, 18 ]
				}
			},
			messages : {
				userName : {
					required : "用户名不能为空！",
					minlength : "用户名长度必须大于2"
				},
				pwd : {
					required : "密码不能为空！",
					rangelength : "密码长度必须是6~18"
				}
			}
		});
	});
	function text1() {
		var yzText = $("#yz").val();
		if (yzText != null) {
			var data = {
				yzm : yzText
			};
			$.ajax({
				url : "Ajax_login",
				type : "post",
				data : data,
				success : function(result) {
					$("#sp").text(result);
				}
			});
		}

	}
</script>
<style type="text/css">
tr {
	text-align: center;
}

.right {
	text-align: right;
}

.left {
	text-align: left;
}

table {
	
	width: 500px;
	height: 300px;
}

.col {
	line-height: 5px;
}

body {
	background-image: url(img/30772752_8.jpg);
}

#yzm {
	margin-left: 10px;
}

span {
	background: url("./demo/images/unchecked.gif") no-repeat 0px 0px;
	padding-left: 16px;
	padding-bottom: 2px;
	font-size: 12px;
	color: #EA5200;
}

label.error {
	background: url("./demo/images/unchecked.gif") no-repeat 0px 0px;
	padding-left: 16px;
	padding-bottom: 2px;
	font-size: 12px;
	color: #EA5200;
}

label.checked {
	background: url("./demo/images/checked.gif") no-repeat 0px 0px;
}

label.valid {
	background: url('images/checked.gif') no-repeat;
	display: block;
	width: 16px;
	height: 16px;
}
div{
	border: 1px solid #000000;
	margin:0px auto;
	width: 500px;
	height: 300px;
} 
a:hover{
	color: #EA5200;
}
</style>
</head>
<body>
	<div>
		<form action="login?oper=login" method="post" id="regForm">
			<table align="center">
				<tr class="col">
					<td colspan="2"><h2>理想IT聊天室登录页面</h2></td>
				</tr>
				<tr class="col">
					<td colspan="2"><hr></td>
				</tr>
				<tr>
					<td class="right">用户名：</td>
					<td class="left"><input type="text" name="userName" /></td>
				</tr>
				<tr>
					<td class="right">密码：</td>
					<td class="left"><input type="password" name="pwd"></td>
				</tr>
				<tr>
					<td class="right">验证码：</td>
					<td class="left"><input type="text" value="" size="7"
						name="yzm" id="yz" onblur="text1()"><img src="Num.jsp"
						id="yzm"><span id="sp"></span></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="登录">&nbsp;&nbsp;&nbsp;&nbsp;<a href="Register.jsp">还没注册？快去注册</a></td>
				</tr>
			</table>
			
		</form>
	</div>

</body>
</html>