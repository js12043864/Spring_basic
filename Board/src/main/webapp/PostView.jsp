<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kopo12.domain.*" %>
<%@ page import="kopo12.dao.*" %>
<%@ page import="kopo12.service.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<link href="board.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<%
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		
		BoardService boardService = BoardServiceImpl.getInstance();
		Board board = boardService.selectOne(boardId);
		String name = board.getTitle();
		
		BoardItemService boardItemService = BoardItemServiceImpl.getInstance();
		BoardItem boardItem = boardItemService.selectOne(id);
		List<BoardItem> boardItemList = boardItemService.selectAll(boardId);
		int number = 0;
		int startNumber = 0;
		for(BoardItem boardItem2 : boardItemList){
			if(boardItem2.getId() == id){
				number = startNumber + 1;
			}
			startNumber++;
		}
		String title = boardItem.getTitle();
		String content = boardItem.getContent();
		String date = boardItem.getDate();
		content = content.replaceAll("\n","<br>");
		%>
		<div id="navigation"><a href="PostTable.jsp?id=<%= boardId %>&from=1" id="navi"><h1><%= name %></h1></a></div>
		<form method="post" action="CommentInsert.jsp?id=<%= id%>&boardId=<%= boardId%>">
			<table>
				<tr>
					<td class="option">번호</td>
					<td class="content"><%= number%></td>
				</tr>
				<tr>
					<td class="option">제목</td>
					<td class="content"><%= title%></td>
				</tr>
				<tr>
					<td class="option">일자</td>
					<td class="content"><%= date%></td>
				</tr>
				<tr>
					<td class="option">내용</td>
					<td class="content"><%= content%></td>
				</tr>
			</table>
			<div>
			<div style="width: 960px; display: inline-block;"></div>
			<input type="button" class="list" onclick="location.href='PostTable.jsp?id=<%= boardId %>&from=1'" value="목록">
			<input type="button" class="update" onclick="location.href='PostUpdate.jsp?id=<%= id%>&boardId=<%= boardId %>'" value="수정">
			</div>
			<br><br>
			<div>
				<div style="width: 595px; display: inline-block;"></div>
				<b>댓글</b>
			<div>
			<div>
				<textarea name="comment" id="cmt" rows="4" placeholder="댓글을 입력하세요"></textarea>
				<br>
				<div style="width: 1105px; display: inline-block;"></div>
				<input type="submit" class="addComment" value="댓글달기">
			</div>
		</form>
		<br>
		<table>
			<tr>
				<td class="number" style="text-align: center;"><b>번호</b></td>
				<td class="plusContent" style="text-align: center;"><b>댓글내용</b></td>
				<td class="Date"><b>날짜</b></td>
			</tr>
			<%
			List<BoardItem> showComments = boardItem.getComments(); 
			int commentNum = 1;
			for(BoardItem boardItem2 : showComments){
					out.print("<tr>" +
									"<td class=\"number\">" + commentNum + 
									"</td>" +
									"<td class=\"plusContent\">" + boardItem2.getContent() + 
									"</td>" +
									"<td class=\"date\">" + boardItem2.getDate() + 
									"</td>" +
								"<tr>");
					commentNum++;					
			}
			%>	
		</table>
	</body>
</html>