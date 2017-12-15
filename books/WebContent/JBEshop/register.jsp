<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<style type="text/css">
		li {
			list-style: none;
		}
		
		input.error {
			border: 1px solid red;
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
</style>
<script src="../js/jquery-1.8.3.min.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/jquery.validate.min.js" type="text/javascript"
	charset="utf-8"></script>
<script type="text/javascript">
	$(function() {
		$("#submitRegister").validate({
			rules : {
				userName : {
					required : true,
					minlength : 2
				},
				passWord : {
					required : true,
					rangelength : [ 6, 18 ]
				},
				rePassWord : {
					required : true,
					equalTo : "#passWord"
				},
				email : {
					required : true,
					email : true
				}
			},
			messages : {
				userName : {
					required : "用户名不能为空！",
					minlength : "用户名长度至少2位字符！"
				},
				passWord : {
					required : "密码不能为空！",
					rangelength : "密码长度至少6-18位字符"
				},
				rePassWord : {
					required : "二次确认密码不能为空",
					equalTo : "两次输入的密码不一致"
				},
				email : {
					required : "电子邮箱不能为空",
					email : "邮箱格式不正确"
				}
			}
		});
	});
</script>

</head>
<body>
	<div id="header" class="wrap">
		<div id="logo">北大青鸟网上书城</div>
		<div id="navbar">
			<form method="get" name="search" action="">
				搜索：<input class="input-text" type="text" name="keywords" /><input
					class="input-btn" type="submit" name="submit" value="" />
			</form>
		</div>
	</div>
	<div id="register">
		<div class="title">
			<h2>欢迎注册北大青鸟网上书城</h2>
		</div>
		<div class="steps">
			<ul class="clearfix">
				<li class="current">1.填写注册信息</li>
				<li class="unpass">2.注册成功</li>
			</ul>
		</div>
		<form id="submitRegister" method="post"
			action="../userInfoServlet?oper=reg">
			<dl>
				<dt>用 户 名：</dt>
				<dd>
					<input class="input-text" type="text" name="userName" id="userName" /><span></span>
				</dd>
				<dt>密 码：</dt>
				<dd>
					<input class="input-text" type="password" name="passWord"
						id="passWord" /><span></span>
				</dd>
				<dt>确认密码：</dt>
				<dd>
					<input class="input-text" type="password" name="rePassWord"
						id="rePassWord" /><span></span>
				</dd>
				<dt>Email地址：</dt>
				<dd>
					<input class="input-text" type="text" name="email" id="email" /><span></span>
				</dd>
				<dt></dt>
				<dd class="button">
					<input class="input-reg" type="submit" name="register" value="" />
				</dd>
			</dl>
		</form>
	</div>
	<div id="footer" class="wrap">北大青鸟网上书城 &copy; 版权所有</div>
</body>
</html>
