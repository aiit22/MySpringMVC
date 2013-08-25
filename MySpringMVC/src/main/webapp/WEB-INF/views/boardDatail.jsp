<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>파일명</th>
	</tr>

	<tr>
		<td><c:out value="${board.bbsId}"/></td>
		<td><c:out value="${board.bbsTitle}"/></td>
		<td><c:out value="${board.bbsId}"/></td>
		
	</tr>
	
</table>
</body>
</html>