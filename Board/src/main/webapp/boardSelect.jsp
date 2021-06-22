<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kopo12.domain.*" %>
<%@ page import="kopo12.dao.*" %>
<%@ page import="kopo12.service.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<link href="board.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<table>
		<%
		request.setCharacterEncoding("utf-8");
		BoardService boardService = BoardServiceImpl.getInstance();
		List<Board> boardList = boardService.selectAll();
		for(Board board : boardList){
			out.print("<tr>" +
					"<td class=num>" +
						board.getId() +
					"</td>" +
					"<td class=title>" +
						"<a href=PostTable.jsp?id=" + board.getId() + "&from=1 id=\"movePage\">" + board.getTitle() + "</a>" +
					"</td>" +
				"</tr>");
		}	
		%>
		</table>
	</body>
</html>