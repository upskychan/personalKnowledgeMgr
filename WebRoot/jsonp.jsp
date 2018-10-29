<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSONP</title>
<script type="text/javascript" src="resource/js/jquery-1.11.1.js"></script>
<script type="text/javascript">
	function inputTrim(inputElement){
		var inputValue = inputElement.value;
		if(inputValue=='你想要什么图') {
			inputElement.value="";
		}
	}
	
	function inputReset(inputElement){
		var inputValue = inputElement.value;
		if(inputValue=='') {
			inputElement.value="你想要什么图";
		}
	}
	
	$(function() {
		$("#sendRequest").click(function() {
			//var flickerAPI = "http://localhost:8080/personalKnowledgeMgr/JsonpServlet?t=" + Math.random();
			var flickerAPI = "http://api.flickr.com/services/feeds/photos_public.gne?jsoncallback=?";
			var tagNames = $("#userName").val();
			if(tagNames == '你想要什么图') {
				tagNames="mount rainier";
			}
			$.getJSON( flickerAPI, {
			    tags: tagNames,
			    tagmode: "any",
			    format: "json"
			  })
			    .done(function( data ) {
			    //console.log(data);
			    $("#showcontent").html("");
			      $.each( data.items, function( i, item ) {
			        $( "<img>" ).attr( "src", item.media.m ).appendTo("#showcontent");
			        if ( i === 3 ) {
			          return false;
			        }
			      });
			    })
			    .fail(function( jqxhr, textStatus, error ) {
    				var err = textStatus + ", " + error;
    				console.log( "Request Failed: " + err );
			    });
			/*  
			//简写形式，效果相同  
			$.getJSON("http://app.example.com/base/json.do?sid=1494&busiId=101&jsonpCallback=?",  
			        function(data){  
			            $("#showcontent").text("Result:"+data.result)  
			});  
			 
			 var url = "http://localhost:8080/personalKnowledgeMgr/JsonpServlet?t=" + Math.random();
			$.ajax({
				type : "get",
				async : false,
				url : url,
				dataType : "jsonp",//数据类型为jsonp  
				jsonp : "jsonpCallback",//服务端用于接收callback调用的function名的参数  
				success : function(data) {
					$("#showcontent").text("Result:" + data.result)
				},
				error : function() {
					alert('fail');
				}
			});
			*/
		});
	});
</script>
</head>
<body>
	<table border="0" width="800" height="600" align="center">
		<tr>
			<td></td>
		</tr>
		<tr>
			<td>
				<input id="userName" type="text"  value="你想要什么图" onfocus="inputTrim(this)" onblur="inputReset(this)">
				<input id="sendRequest" type="button"  value="有图有真相" >
			</td>
		</tr>
		<tr>
			<td height="20">&nbsp;</td>
		</tr>
		<tr>
			<td height="20" id="showcontent"></td>
		</tr>
	</table>
</body>
</html>