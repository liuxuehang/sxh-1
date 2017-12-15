var xhr;
//创建异步请求对象XMLHttpRequest
function createXMLHttpRequest(){
	//不同浏览器创建XMLHttpRequest方法不同。
	if(window.ActiveXObject){ //如果是IE浏览器
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}else if(window.XMLHttpRequest){ //非IE浏览器
		xhr = new XMLHttpRequest();
	}
}

function doGet(url,processRequest){
	//执行异步操作
	createXMLHttpRequest();
	//执行初始化
	xhr.open("get",url,true);
	xhr.onreadystatechange = processRequest;  //设置回调函数
	//发送请求
	xhr.send(null);
}

function doPost(url,data,processRequest){
	//发送ajax请求
	createXMLHttpRequest();
	//执行初始化
	xhr.open("post",url,true);
	xhr.onreadystatechange = processRequest;  //设置回调函数
	//设置为post方式提交
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	//发送请求
	xhr.send(data);
}