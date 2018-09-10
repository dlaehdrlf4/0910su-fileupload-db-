<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드 결과 페이지</title>
</head>
<body>
<!-- 앞에 컨트롤러 . 서비스 -->
	이름: ${map.name}<br />
	업로드 된 파일 이름 : ${map.uploadname}<br />
	원본 파일 이름 : ${map.originalname}<br />
	
</body>
</html>