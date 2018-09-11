<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 전송</title>
</head>
<body>
	<form action="sendmail.do" method="post">
		받는사람:<input type = "text" name ="receiver"
		required = "required" /><br />
		제목:<input type = "text" name = "subject"/>
		<br />
		내용:<textarea rows="10" cols="50"
		name="msg"></textarea><br />
		<input type = "submit" value ="전송"/>
		
	</form>
</body>
</html>