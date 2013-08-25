<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">

function linkPage(pageNo){
	location.href = "boardList.do?pageNo="+pageNo;
}

</script>
</head>

<body>
<table>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>파일명</th>
	</tr>
<c:forEach items="${boardlist}" var="board">
	<tr>
		<td><c:out value="${board.bbsId}"/></td>
		<td><c:out value="${board.bbsTitle}"/></td>
		<td><c:out value="${board.bbsFile}"/></td>
		
	</tr>
</c:forEach>	
</table>
<br/>
<table width="50%">
	<tr>
		<td align="center">
		<div id="pagination">
		<ui:pagination paginationInfo = "${paginationInfo}"
			type="image"
			jsFunction="linkPage"
			/>
		</div>	
		</td>
	</tr>
</table>
</body>
</html>