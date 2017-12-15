$(function(){
		$("#submitRegister").validate({
			rules: {
				userName: {
					required: true,
					minlength: 2
				},
				passWord: {
					required: true,
					rangelength: [6, 18]
				},
				rePassWord: {
					required: true,
					equalTo: "[name=passWord]"
				},
				email: {
					required: true,
					email: true
				}
			},
			messages: {
				userName: {
					required: "用户名不能为空！",
					minlength: "用户名长度至少2位字符！"
				},
				passWord: {
					required: "密码不能为空！",
					rangelength: "密码长度至少6-18位字符"
				},
				rePassWord: {
					required: "二次确认密码不能为空",
					equalTo: "两次输入的密码不一致"
				},
				email: {
					required: "电子邮箱不能为空",
					email: "邮箱格式不正确"
				}
			}
		});
	});