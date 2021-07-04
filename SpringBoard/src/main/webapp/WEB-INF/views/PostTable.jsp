<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.kopo12.domain.*" %>
<%@ page import="kr.ac.kopo.kopo12.dao.*" %>
<%@ page import="kr.ac.kopo.kopo12.service.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<link href="/SpringBoard/resources/board.css?after" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div id="navigation">
			<a href="PostTable.jsp?id=${boardId}&from=1" id="navi" style="width: 500px; display: inline-block;" ><h1>${name}</h1></a>
			<input type="button" id="selectBoard" onclick="location.href='boardSelect.jsp'" value="게시판 선택">
		</div>
		<div>
			<form method="post" id="move" action="PostSearch.jsp?boardId=${boardId}">
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
			<c: choose>
				<c: when test = "${fn: length(boardItemList) == 0}">
					</table>
					<div>
					<div style="width: 1103px; display: inline-block;"></div>
					<input type="button" class="new" onclick="location.href='PostInsert.jsp?id=${boardId}'" value="신규">
					</div>	
				</c: when>
				<c: otherwise>
					<c: forEach var="array" items="${boardNum}" begin="array[1]" end="array[0]" varStatus="status">
						<c:set var="boardItemList" items="${boardItemList[${status.current}]}"></c:set>
						
						<tr>
							<td class=num>
									${status.current+1}
							</td>
							<td class=title>
								<a href=PostView.jsp?id=${boardItem.getId()}&boardId=${boardId} id=\"movePage\">${boardItemList.title}</a>
							</td>
							<td class=date>
								${boardItemList.date}
							</td>
						</tr>
					</c: forEach>
			<%
	/* 		
			for(int number = boardNum[1]; number <= boardNum[0]; number++){
				BoardItem boardItem = boardItemList.get(number);
				out.print("<tr>" +
								"<td class=num>" +
									(number + 1) +
								"</td>" +
								"<td class=title>" +
									"<a href=PostView.jsp?id=" + boardItem.getId() + "&boardId=${boardId} id=\"movePage\">" + boardItem.getTitle() + "</a>" +
								"</td>" +
								"<td class=date>" +
									boardItem.getDate() +
								"</td>" +
							"</tr>");
				boardItemSize--;
			} */
			%>
		</table>
		<div>
		<div style="width: 1103px; display: inline-block;"></div>
		<button class="new" onclick="location.href='PostInsert.jsp?id=${boardId}'">신규</button>
		</div>
		<div>
			<br>
			<div style="width: 850px; display: inline-block;"></div>
			<span><a href="PostTable.jsp?id=${boardId}&from=1">처음</a></span>
		<%-- 	<% 
			out.print("<span><a href=PostTable.jsp?id=${boardId}&from=" + (boardNum[4]-1)  + "><</a></span> ");
			for( int i = boardNum[2]; i < boardNum[2] + 10; i++) {
				if( i > boardNum[3]) {
					break;
				} else {
				
				out.print("<span><a href=PostTable.jsp?id=${boardId}&from=" + i  + ">" + i + "</a></span> ");
				}
			}
			out.print("<span><a href=PostTable.jsp?id=${boardId}&from=" + (boardNum[4]+1)  + ">></a></span> ");
			%>
			<span><a href="PostTable.jsp?id=${boardId}&from=<%= (boardNum[3] - 1) * 10 + 1 %>">끝</a></span>
			<span>&nbsp;현재페이지: <%= boardNum[4]%></span> --%>
		</div>
			</c: otherwise>
		</c: choose>
	</body>
</html>