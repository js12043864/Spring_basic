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
		<%
		request.setCharacterEncoding("utf-8");
		int boardId = Integer.parseInt(request.getParameter("id"));
		BoardService boardService = BoardServiceImpl.getInstance();
		Board board = boardService.selectOne(boardId);
		String name = board.getTitle();
		int from = Integer.parseInt(request.getParameter("from"));
		%>
		<div id="navigation">
			<a href="PostTable.jsp?id=<%= boardId %>&from=1" id="navi" style="width: 500px; display: inline-block;" ><h1><%= name %></h1></a>
			<input type="button" id="selectBoard" onclick="location.href='boardSelect.jsp'" value="게시판 선택">
		</div>
		<div>
			<form method="post" id="move" action="PostSearch.jsp?boardId=<%= boardId%>">
				<input type="text" class="search" name="keyWord" placeholder="검색어 입력">
				<input type="submit" id="search" value="검색">
			</form>
		</div>
		<br>
		<table>
			<tr>
				<td class="Id"><b>번호</b></td>
				<td class="Ttl"><b>제목</b></td>
				<td class="day"><b>등록일</b></td>
			</tr>
			<%
			BoardItemService boardItemService = BoardItemServiceImpl.getInstance();
			List<BoardItem> boardItemList = boardItemService.selectAll(boardId);
			if(boardItemList.size() == 0){ %>
			</table>
				<div>
				<div style="width: 1103px; display: inline-block;"></div>
				<input type="button" class="new" onclick="location.href='PostInsert.jsp?id=<%= boardId %>'" value="신규">
				</div>
				<%
				return;
			}
			int boardItemSize = boardItemList.size();				
			int totalCnt = boardItemList.size();	//게시글 총 수
			int finPage = totalCnt % 10 == 0 ? totalCnt / 10 : (totalCnt / 10) + 1;	//마지막 페이지
			if( from < 1) {
				from = 1;
			}else if (from > finPage) {
				from = finPage;
			}	//예외처리
			int cur_page = 0;	//현재 페이지
			int startNum = from * 10 <= totalCnt ? (from * 10) - 1 : totalCnt - 1;	//시작 번호
			int endNum = (from - 1) * 10;
			
			if( from % 10 == 0) {
				cur_page = from / 10;
			}else {
				cur_page = from / 10 + 1;
			}
			
			int pr_pg = (cur_page / 10) * 10 + 1;
			if(cur_page % 10 == 0 ) {
				pr_pg = ((cur_page / 10) - 1) * 10 + 1;
			}
			
			//for(BoardItem boardItem : boardItemList){
			for(int number = endNum; number <= startNum; number++){
				BoardItem boardItem = boardItemList.get(number);
				out.print("<tr>" +
								"<td class=num>" +
									(number + 1) +
								"</td>" +
								"<td class=title>" +
									"<a href=PostView.jsp?id=" + boardItem.getId() + "&boardId=" + boardId + " id=\"movePage\">" + boardItem.getTitle() + "</a>" +
								"</td>" +
								"<td class=date>" +
									boardItem.getDate() +
								"</td>" +
							"</tr>");
				boardItemSize--;
			}
			%>
		</table>
		<div>
		<div style="width: 1103px; display: inline-block;"></div>
		<input type="button" class="new" onclick="location.href='PostInsert.jsp?id=<%= boardId %>'" value="신규">
		</div>
		<div>
			<br>
			<div style="width: 850px; display: inline-block;"></div>
			<span><a href="PostTable.jsp?id=<%= boardId %>&from=1">처음</a></span>
			<% 
			out.print("<span><a href=PostTable.jsp?id=" + boardId + "&from=" + (from-1)  + "><</a></span> ");
			for( int i = pr_pg; i < pr_pg + 10; i++) {
				if( i > finPage) {
					break;
				} else {
				
				out.print("<span><a href=PostTable.jsp?id=" + boardId + "&from=" + i  + ">" + i + "</a></span> ");
				}
			}
			out.print("<span><a href=PostTable.jsp?id=" + boardId + "&from=" + (from+1)  + ">></a></span> ");
			%>
			<span><a href="PostTable.jsp?id=<%= boardId %>&from=<%= (finPage - 1) * 10 + 1 %>">끝</a></span>
			<span>&nbsp;현재페이지: <%= from%></span>
		</div>
	</body>
</html>