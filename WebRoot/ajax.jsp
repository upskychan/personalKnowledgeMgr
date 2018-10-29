<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>XMLHTTPRequest</title>
<script type="text/javascript">
	function inputTrim(inputElement){
		var inputValue = inputElement.value;
		if(inputValue=='请输入你的名字') {
			inputElement.value="";
		}
	}
	
	function inputReset(inputElement){
		var inputValue = inputElement.value;
		if(inputValue=='') {
			inputElement.value="请输入你的名字";
		}
	}
	//var userNameObj = document.getElementById("userName");
	
	function sendRequest(){
		//alert("sendRequesting...");
		var xmlhttp;
		if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		var userName = document.getElementById("userName").value;
		
		xmlhttp.onreadystatechange = function() {
			console.log(xmlhttp.readyState);
			if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				document.getElementById("content").innerHTML = xmlhttp.responseText;
			}
		}
		var url = "/personalKnowledgeMgr/AjaxServlet?t=" + Math.random() +"&userName=" + userName;
		//xmlhttp.open("GET", url, true);
		xmlhttp.open("POST", url, true);
		xmlhttp.send();

	}
</script>
</head>
<body>
	<table border="0" width="800" height="600" align="center">
		<tr>
			<td></td>
		</tr>
		<tr>
			<td>
				<input id="userName" type="text"  value="请输入你的名字" onfocus="inputTrim(this)" onblur="inputReset(this)">
				<input type="button"  value="点你妹的" onclick="sendRequest()" >
			</td>
		</tr>
		<tr>
			<td height="20">&nbsp;</td>
		</tr>
		<tr>
			<td height="20" id="content"></td>
		</tr>
	</table>
</body>
</html>