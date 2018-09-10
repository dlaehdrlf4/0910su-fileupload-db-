<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body><!-- 파일 전송할 때는 method랑 enctype 이것은 무조건 한다. 컨트롤러로 간다.-->
	<form action="upload.file" method = "post" enctype ="multipart/form-data">
	<label for ="name">이름</label>
	<input type = "text" name = "name"/><br />
	<label for "file">첨부파일</label>
	<input type ="file" name = "file"/><br />
	<input type = "submit" value = "파일 전송"/>
	</form>
</body>
</html>