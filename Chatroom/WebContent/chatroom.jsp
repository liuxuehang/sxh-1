<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>

<style type="text/css">
.overall {
	border: 1px solid rosybrown;
	width: 800px;
	height: 630px;
	margin: 30px 300px;
	background-color: beige;
}

.left {
	border: 1px solid rosybrown;
	width: 150px;
	height: 610px;
	margin: 10px 10px;
	float: left;
	text-align: center;
	
}

p {
	font-size: 16px;
	font-family: "楷体";
	margin: 10px 20px;
}

.top {
	border: 1px solid rosybrown;
	width: 625px;
	height: 80px;
	margin: 10px 165px;
}

.centre {
	border: 1px solid green;
	width: 625px;
	height: 380px;
	margin: 10px 165px;
}

.hidden1 {
	display: none;
}

.hidden1 span {
	float: left;
	margin-top: 10px;
	margin-left: 10px;
	font-size: 12px;
}

.hidden1 div {
	width: 230px;
	height: 80px;
	margin-left: 3px;
	margin-top: 10px;
	border: 1px solid rosybrown;
}

.hidden2 {
	display: none;
}

.hidden2 div {
	width: 230px;
	/*height: 80px;  */
	background: honeydew;
	margin-top: 10px;
	margin-left: 350px;
	border: 1px solid rosybrown;
	float: left;
	font-size: 12px;
}

.hidden2 span {
	margin-top: 10px;
	font-size: 12px;
}

.bottom {
	border: 1px solid rosybrown;
	width: 625px;
	height: 125px;
	margin: 10px 165px;
}

.bottom-one {
	font-size: 12px;
	border: 1px solid rosybrown;
	float: left;
	margin-top: 10px;
}

.name {
	font-size: 30px;
	margin: 5px;
	color: brown;
}

h2 {
	font-family: "楷体";
}

textarea {
	width: 400px;
	height: 105px;
	margin-top: 10px;
	margin-left: 15px;
}

select {
	
}

li {
	list-style: none;
}

#div_one {
	overflow-y: scroll;
	width: 625px;
	height: 380px;
}

.item {
	clear: both;
	margin: 10px 5px;
	width: 300px;
	border: 1px solid red;
	padding: 5px;
	background-color: beige;
	font-size: 12px;
	float: left;
}

.myitem {
	clear: both;
	margin: 10px 5px;
	width: 300px;
	border: 1px solid green;
	padding: 5px;
	background-color: beige;
	font-size: 12px;
	float: right;
}
</style>
<script type="text/javascript">
	$(function() {
		getUser();
		getSelte();

		//点击发送时增加聊天记录
		$("#bbbb").click(
				function() {

					var mess = $("#message").val();
					var seler_user = $("#seler_user").val();
				/* 	alert(seler_user + "-----"); */
					$("#message").val("");

					$.ajax({
						url : "ChatroomServlet",
						data : "oper=insert&message=" + mess + "&seler_user="
								+ seler_user,
						type : "post"
					});
					$("#message").focus();
				});
	});
	//查询所有在线用户
	function getUser() {
		$.ajax({
			url : "UserSevlet",
			data : "oper=listUsers",
			type : "post",

			success : function(result) {
				$("#divLeft").html("");
				for (var i = 0; i < result.List.length; i++) {
					
					if(result.List[i].u_nickName==result.nickName){
						var $li = $("<li style='color:green;font-size: 15px;'>" + result.List[i].u_nickName + "</li>");
					}else{
						var $li = $("<li>" + result.List[i].u_nickName + "</li>");
					}
					
					$li.click(function() {

						if ($(this).text() != result.nickName) {

							var $opt = $("<option selected='selected' value="
									+ $(this).text() + ">" + $(this).text()
									+ "</option>");

							$("#seler_user option:eq(1)").replaceWith($opt);

						}
					});

					$("#divLeft").append($li);
				}
			}
		});
	}
	//查询聊天记录
	function getSelte() {
		$
				.ajax({
					url : "ChatroomServlet",
					data : "oper=select",
					type : "post",
					success : function(result) {
						$("#div_one").html("");
						for (var i = 0; i < result.List.length; i++) {

							if (result.List[i].m_from == result.nickname) {

								var $div = $("<div class='myitem'>"
										+ result.List[i].m_addtime
										+ "<br/>"
										+ "<hr/>"
										+ "<span style='color:green;font-size: 13px;'>"
										+ result.List[i].m_from + "对"
										+ result.List[i].m_to + "说:"
										+ "</span>" + "<br/>"
										+ result.List[i].m_message + "</div>");

							} else {

								/*alert(seler_user + "++++++++++++");
								 alert("22222222"+result.List[i].m_to);
								alert("1111111111"+"ccc");
								alert(result.List[i].m_to=="所有人"); */
								if (result.List[i].m_to == "所有人"|| result.List[i].m_to == result.nickname) {
									var $div = $("<div class='item'>"
											+ result.List[i].m_addtime
											+ "<br/>"
											+ "<hr/>"
											+ "<span style='color:red;font-size: 15px;'>"
											+ result.List[i].m_from + "对"
											+ result.List[i].m_to + "说:"
											+ "</span>" + "<br/>"
											+ result.List[i].m_message
											+ "</div>");
								}
							}
							$("#div_one").append($div);
						}
						$("#div_one").scrollTop(100000);
					}
				});
	}

	setInterval(getSelte, 1000);
	setInterval(getUser, 1000);
</script>
</head>

<body>

	<div class="overall">
		<div class="left" id="left">
			<div id="divTop">在线用户人:</div>
			<div id="divLeft"></div>
		</div>
		<c:choose>
			<c:when test="${empty sessionScope.username }">
			<c:redirect url="login.jsp"></c:redirect>
			</c:when>
			<c:otherwise>
				<div class="top">
					<h2>
						欢迎用户<span class="name">${username}</span>进入聊天室&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
							href="UserSevlet?oper=signOut">注销</a>
					</h2>
				</div>
			</c:otherwise>
		</c:choose>
		<div class="centre" id="div_one">
			<div class="hidden1" id="divs_two"></div>

		</div>
		<form method="post" id="myform" action="">
			<div class="bottom">

				<select class="bottom-one" id="seler_user" name="seler_user">

					<option value="所有人" id="selsect_one" selected="selected">所有人</option>

					<option value=""></option>
				</select>
				<textarea name="text" rows="" cols="" placeholder="请输入聊天内容"
					id="message"></textarea>
				<input type="button" value="发送" id="bbbb">
			</div>
			</from>
	</div>

</body>

</html>