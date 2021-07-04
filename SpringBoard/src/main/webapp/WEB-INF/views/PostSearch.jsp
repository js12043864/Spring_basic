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
		<link href="/SpringBoard/resources/board.css?after" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<%
		request.setCharacterEncoding("utf-8");
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		BoardService boardService = BoardServiceImpl.getInstance();
		Board board = boardService.selectOne(boardId);
		String name = board.getTitle();
		
		String keyWord = request.getParameter("keyWord");
		if(keyWord.contains("<")){
			keyWord = keyWord.replaceAll("<", "&lt;");
		}
		String[] spKeyWord = keyWord.split(" ");
		BoardItemService boardItemService = BoardItemServiceImpl.getInstance();
		List<BoardItem> boardItemList = boardItemService.selectAll(boardId);
		%>
		<div id="navigation">
			<a href="PostTable.jsp?id=<%= boardId %>&from=1" id="navi"><h1><%= name %></h1></a>
		</div>
		<div style="display: inline-block; position:absolute; left:605px;">
		<span id=key>"<%= keyWord %>"검색결과</span>
		</div>
		<br>
		<table>
			<tr>
				<td class="Id"><b>번호</b></td>
				<td class="Ttl"><b>제목</b></td>
				<td class="day"><b>등록일</b></td>
			</tr>
			<%
			int boardItemSize = boardItemList.size();
			int cnt = 1;
			for(BoardItem boardItem : boardItemList){
				HashSet<Integer> hash = new HashSet<Integer>();
				for(String key : spKeyWord){
					if(boardItem.getContent().contains(key) || boardItem.getTitle().contains(key)){
						hash.add(boardItem.getId());
					}
				}
				Iterator it = hash.iterator();
				
				while(it.hasNext()){
				out.print("<tr>" +
								"<td class=num>" +
									cnt +
								"</td>" +
								"<td class=title>" +
									"<a href=PostView.jsp?id=" + it.next() + "&boardId=" + boardId + " id=\"movePage\">" + boardItem.getTitle() + "</a>" +
								"</td>" +
								"<td class=date>" +
									boardItem.getDate() +
								"</td>" +
							"</tr>");
					
				}
				cnt++;
			}
			%>
	</body>
</html>