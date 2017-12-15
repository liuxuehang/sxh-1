<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>理想IT聊天室</title>
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<style type="text/css">
body {
	background-image: url(img/225702rv99rf4vhg44lc8h.jpg);
}

.tab {
	border: 1px solid #000000;
	width: 850px;
	height: 600px;
	margin: 0px auto;
}

.div_top {
	border: 1px solid #000000;
	width: 848px;
	height: 50px;
}

.div_left {
	border: 1px solid #000000;
	height: 548px;
	width: 148px;
	margin-right: 800px;
}

.div_left_fj {
	border: 1px solid #000000;
	width: 147px;
	height: 40px;
	text-align: center;
	padding-top: 10px;
	background-color: antiquewhite;
}

.div_right_top {
	border: 1px solid #EA5200;
	height: 437px;
	width: 698px;
	margin-top: -550px;
	margin-left: 150px;
	overflow-y: scroll;
}

.div_right_bottom {
	border: 1px solid #000000;
	height: 108px;
	width: 698px;
	margin-left: 150px;
}

h2 {
	margin-top: 5px;
}

.tt {
	line-height: 0px;
}

.div_top_a {
	width: 60px;
	height: 30px;
	margin-top: -50px;
	margin-left: 400px;
}

.div_right_bottom_at {
	width: 165px;
	height: 30px;
	color: red;
	margin-right: 520px;
	margin-top: 15px;
}

.div_right_bottom_ot {
	width: 500px;
	height: 110px;
	margin-top: -35px;
	margin-left: 150px;
}

a:hover {
	color: #EA5200;
}

p {
	text-align: center;
}

#dt {
	list-style-type: none;
	margin-left: -100px;
}

.ull {
	padding-top: 5px;
	margin-left: -40px;
	line-height: 10px;
	list-style-type: none;
	width: 200px;
	height: 50px;
}

.div_right_top_one {
	width: 200px;
	height: 80px;
	background-color: beige;
	margin-right: 400px;
	margin-top: 50px;
	text-align: center;
}

.div_right_top_Two {
	width: 200px;
	height: 80px;
	background-color: beige;
	margin-left: 400px;
	margin-top: 30px;
	text-align: center;
}
</style>
<script type="text/javascript">
	var name = '${sessionScope.name}';
	$(function() {
		if (name == "") {
			alert("还没有登入请先登入！！！");
			top.location.href = 'Login.jsp';
		}
		setInterval(text1, 500);
		setInterval(room, 2000);
	});

	function clickk(a) {
		var $selNode = $("<option>" + $(a).text() + "</option>");
		$("#sel").append($selNode);
		$("#sel").val($(a).text());
	}

	function text1() {
		$.ajax({
			url : "Json_Name",
			type : "post",
			success : function(result) {
				if (result != null) {
					$("#dt").text("");
					for (var i = 0; i < result.length; i++) {
						if ($("strong").text() == result[i]) {
							var $newNode = $("<li style='color:red;'>"
									+ result[i] + "</li>");
							$("#dt").append($newNode);
						} else {
							var $newNode = $("<li onclick='clickk(this)'>"
									+ result[i] + "</li>");
							$("#dt").append($newNode);
						}
					}
					$("#sp").html(result.length);
				}
			}
		});
	}
	function mess() {
		var data = {
			oper : "mes",
			text : $("#text").val(),
			userName : $("strong").text(),
			sel : $("#sel").val()
		}
		$.ajax({
			url : "login",
			type : "post",
			data : data,
			success : function(result) {
				$("#text").val("");
			}
		});
	}
	function room() {
		var data = {
			oper : "roo",
			time : $("#sa").text(),
			userName : $("strong").text(),
			sel : $("#sel").val()
		}
		$.ajax({
					url : "login",
					type : "post",
					data : data,
					success : function(result) {
						if (result != null) {
							$(".div_right_top").text("");
							for (var i = 0; i < result.length; i++) {
								var json = JSON.parse(result[i]);
								if ($("strong").text() == json.m_from) {
									var $divNode = $("<div class='div_right_top_Two'></div>");
									var $ulNode = $("<ul class='ull'></ul>");
									var $li1 = $("<li>" + json.m_from + "对"
											+ json.m_to + "说:<hr></li>");
									var $li2 = $("<li>" + json.m_message
											+ "<hr></li>");
									var $li3 = $("<li>" + json.m_addtime
											+ "</li>");
									$(".div_right_top").append($divNode);
									$divNode.append($ulNode);
									$ulNode.append($li1);
									$ulNode.append($li2);
									$ulNode.append($li3);
								} else {
									var $divNode = $("<div class='div_right_top_one'></div>");
									var $ulNode = $("<ul class='ull'></ul>");
									var $li1 = $("<li>" + json.m_from + "对"
											+ json.m_to + "说:<hr></li>");
									var $li2 = $("<li>" + json.m_message
											+ "<hr></li>");
									var $li3 = $("<li>" + json.m_addtime
											+ "</li>");
									$(".div_right_top").append($divNode);
									$divNode.append($ulNode);
									$ulNode.append($li1);
									$ulNode.append($li2);
									$ulNode.append($li3);
								}
							}
							document.getElementById("div5").scrollTop = document
									.getElementById("div5").scrollHeight;
						}
					}
				});
	}
	function zx() {
		var data = {
			oper : "zhuxiao",
			userName : $("strong").text()
		}
		$.ajax({
			url : "login",
			type : "post",
			data : data,
			success : function(result) {
				location.href = "Login.jsp";
			}
		});
	}
</script>
</head>
<body>

	<div class="tab" align="center">
		<div class="div_top">
			<h2>欢迎使用理想IT聊天室</h2>
			欢迎[<strong>${sessionScope.name}</strong>]进入聊天室！登入时间：[<span id="sa">${sessionScope.time}</span>]
			<div class="div_top_a">
				<a href="#" onclick="zx()">注销</a>
			</div>
		</div>
		<div class="div_left">
			<div class="div_left_fj">
				房间人数(<span id="sp"></span>)
			</div>
			<ul id="dt"></ul>
		</div>
		<div class="div_right_top" id="div5"></div>
		<div class="div_right_bottom">
			<div class="div_right_bottom_at">
				你想对 <select id="sel">
					<option>所有人</option>
				</select> 说：
			</div>
			<div class="div_right_bottom_ot">
				<textarea name="showText" cols="50" rows="4" id="text"></textarea>
				<input type="submit" name="upload" value="发送" onclick="mess()" />
			</div>

		</div>
	</div>
</body>
</html>