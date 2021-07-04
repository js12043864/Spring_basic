<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.kopo12.domain.*" %>
<%@ page import="kr.ac.kopo.kopo12.dao.*" %>
<%@ page import="kr.ac.kopo.kopo12.service.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Document</title>
		<%
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		BoardItemService boardService = BoardItemServiceImpl.getInstance();
		BoardItem boardItem = new BoardItem(id);
		boardService.delete(boardItem);
		%>	
		<script>
		window.addEventListener('DOMContentLoaded', function() {
			location.href = 'PostTable.jsp?id=<%=boardId%>&from=1';
		});
		</script>
	</head>
	<body>
		
	</body>
</html>