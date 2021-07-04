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
		<table>
		<c:forEach var="boardList" items="${boardList}">
			<tr>
		 		<td class=num>${boardList.id}</td>
		 	 	<td class=title><a href=PostTable.jsp?id=${boardList.id}&from=1 id=movePage>${boardList.title}</a></td>
		 	 	<td class=title><a href=hello id=movePage>${boardList.title}</a></td>
			</tr>
		</c:forEach>
		</table>
	</body>
</html>