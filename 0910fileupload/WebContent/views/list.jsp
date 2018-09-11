<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록 보기</title>
</head>
<body>
	<h3 align="center">목록보기</h3>
	<table border="1" align="center">
	<tr>
		<th>코드</th>
		<th>파일이름</th>
		<th>파일크기</th>
		<th>보충설명</th>
	</tr>
	<c:forEach var="temp" items="${list}">
	<tr>
		<td>${temp.code}</td>
		<td>
		<a href="pdsupload/${temp.filename}">${temp.filename}</a></td>
		<td>${temp.filesize}</td>
		<td>${temp.description}</td>
	</tr>
	</c:forEach>
	</table>
	
</body>
</html>