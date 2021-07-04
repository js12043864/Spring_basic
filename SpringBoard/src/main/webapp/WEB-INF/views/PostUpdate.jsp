<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.kopo12.domain.*" %>
<%@ page import="kr.ac.kopo.kopo12.dao.*" %>
<%@ page import="kr.ac.kopo.kopo12.service.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*, java.text.*" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<link href="/SpringBoard/resources/board.css?after" rel="stylesheet" type="text/css" />
	</head>
	<body>
		
		<%
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        
        BoardService boardService = BoardServiceImpl.getInstance();
		Board board = boardService.selectOne(boardId);
		String name = board.getTitle();
        
		BoardItemService boardItemService = BoardItemServiceImpl.getInstance();
		BoardItem boardItem = boardItemService.selectOne(id);
		List<BoardItem> boardItemList = boardItemService.selectAll(boardId);
		int size = boardItemList.size();
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
        String date = sdf.format(cal.getTime());
		%>
		<div id="navigation">
			<a href="PostTable.jsp?id=<%= boardId %>&from=1" id="navi"><h1><%= name %></h1></a>
		</div>
		<form method="post" action="CompleteUpdate.jsp?id=<%= id%>&boardId=<%= boardId%>">
			<table>
				<tr>
					<td class="option">번호</td>
					<td class="content"><input type="text" name="id" id="title" readonly value=<%= number%>></td>
				</tr>
				<tr>
					<td class="option">제목</td>
					<td class="content"><input type="text" name="title" id="title" required maxlength="20" value=<%= title%>></td>
				</tr>
				<tr>
					<td class="option">일자</td>
					<td class="content"><%= date%></td>
				</tr>
				<tr>
					<td class="option">내용</td>
					<td class="content" id="content"><textarea name="content" id="cnt" rows="20" required placeholder="내용을 입력하세요"><%= content %></textarea></td>
				</tr>
			</table>
			<div>
			<div style="width: 813px; display: inline-block;"></div>
			<input type="button" class="cancel" onclick="location.href='PostTable.jsp?id=<%= boardId %>&from=1'" value="취소">
			<input type="submit" class="write" value="저장">
			<input type="button" class="delete" onclick="location.href='PostDelete.jsp?id=<%= id%>&boardId=<%= boardId %>'" value="삭제">
			</div>
		</form>
	</body>
</html>