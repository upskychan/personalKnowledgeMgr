<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>setTimeOut</title>
<script type="text/javascript">

	for (var i = 1; i <= 3; i++) {
		setTimeout(function() {
			console.log(i);
		}, 0);
		console.log("外："+i);
	}
	//123444
	
//如果保证输出为123呢？
	/*
	 for (var i = 1; i <= 3; i++) {
	 setTimeout((function(i) {
	 return function() {
	 console.log(i);
	 };
	 })(i), 0); //改为立即执行的函数
	 console.log("外:"+i);
	 }
	 */
</script>
</head>
<body>
	欢迎！
</body>
</html>