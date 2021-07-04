<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.kopo12.domain.*" %>
<%@ page import="kr.ac.kopo.kopo12.dao.*" %>
<%@ page import="kr.ac.kopo.kopo12.service.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
$( document).ready(function() {
	console.log( "ready!");
	localStorage['key1'] = 'value1';
	localStorage['key2'] = 'value2';
	console.log(localStorage);
	console.log(localStorage['key1']);
})
</script>
</head>
<body>
	<%
	int boardId = 1;
	BoardItemService boardItemService = BoardItemServiceImpl.getInstance();
	List<BoardItem> boardItems = boardItemService.selectAll(boardId);
	request.setAttribute("boardItems", boardItems);
	%>
	<c:out value="hello world" />
	
	<c:forEach var="boardItem" items="${boardItems}">
		<p><c:out value="${boardItem.id}" /></p>
	</c:forEach>
</body>
</html>