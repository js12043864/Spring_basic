<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.kopo12.domain.*" %>
<%@ page import="kr.ac.kopo.kopo12.dao.*" %>
<%@ page import="kr.ac.kopo.kopo12.service.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<link href="/SpringBoard/resources/board.css?after" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div id="navigation">
			<a href="PostTable?id=${boardId}&from=1" id="navi"><h1>${name}</h1></a>
		</div>
		<div style="display: inline-block; position:absolute; left:605px;">
		<span id=key>"${keyWord}"검색결과</span>
		</div>
		<br>
		<table>
			<tr>
				<td class="Id"><b>번호</b></td>
				<td class="Ttl"><b>제목</b></td>
				<td class="day"><b>등록일</b></td>
			</tr>
			<c:forEach var="boardItemList" items="${boardItemList}">
			
				<c:forEach var="iterator" items="${iterator}">
				<c:set var="i" value="${i+1}"></c:set>
					<tr>
						<td class=num>${i}</td>
						<td class=title><a href=PostView?id=${iterator}&boardId=${boardId} id=movePage>${boardItemList.title}</a></td>
						<td class=date>${boardItem.date}</td>
					</tr>
				</c:forEach>
			</c:forEach>
			<%-- <%
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
			%> --%>
	</body>
</html>