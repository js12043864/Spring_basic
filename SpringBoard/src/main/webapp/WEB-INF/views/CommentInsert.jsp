<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.kopo12.domain.*" %>
<%@ page import="kr.ac.kopo.kopo12.dao.*" %>
<%@ page import="kr.ac.kopo.kopo12.service.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%
		request.setCharacterEncoding("utf-8");
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		int id = Integer.parseInt(request.getParameter("id"));
		int parentId = id;
		String comment = request.getParameter("comment");
		if(comment.contains("<")){
			comment = comment.replaceAll("<", "&lt;");
		}
		comment = comment.replaceAll("\n","<br>");
		BoardItem boardItem = new BoardItem(comment, parentId);
		BoardItemService boardItemService = BoardItemServiceImpl.getInstance();
		boardItemService.create(boardItem);
		%>
		<script>
		window.addEventListener('DOMContentLoaded', function() {
			location.href = 'PostView.jsp?id=<%= id%>&boardId=<%= boardId%>';
		});
		</script>
	</head>
	<body>
		
	</body>
</html>