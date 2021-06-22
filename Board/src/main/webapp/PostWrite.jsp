<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kopo12.domain.*" %>
<%@ page import="kopo12.dao.*" %>
<%@ page import="kopo12.service.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<%
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		if(title.contains("<") || content.contains("<")){
			title = title.replaceAll("<", "&lt;");
			content = content.replaceAll("<", "&lt;");
		}
		int boardId = Integer.parseInt(request.getParameter("id"));
		BoardItemService boardItemService = BoardItemServiceImpl.getInstance();
		BoardItem boardItem = new BoardItem(title, content, boardId);
		boardItemService.create(boardItem);
		
		List<BoardItem> postNumber = boardItemService.selectAll(boardId);
		int size = postNumber.size();
		int id = postNumber.get(size-1).getId();
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