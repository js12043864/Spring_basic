<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kopo12.domain.*" %>
<%@ page import="kopo12.dao.*" %>
<%@ page import="kopo12.service.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<!DOCTYPE html>
<html>
<head>
<link href="reserv.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<%
	request.setCharacterEncoding("utf-8");
	String date = request.getParameter("date");
	int room = Integer.parseInt(request.getParameter("room"));
	ReservService reservService = ReservServiceImpl.getInstance();
	String roomName = reservService.roomName(room);	
	%>
	<div id="resortName">
		<center>
			<a href="index.jsp" class="resortName"><h1>♧ JS Resort ♧</h1></a>
		</center>
	</div>
	<form method="post" action="ReservInsert.jsp?room=<%= room %>">
	<center>
	<table>
		<tr>
			<td>성명</td>
			<td><input type="text" class="input" name="name" placeholder="성명을 입력해주세요."></td>
		</tr>
		<tr>
			<td>예약일자</td>
			<td><input type="text" class="input" name="date" readonly value=<%= date %>></td>
		</tr>
		<tr>
			<td>객실</td>
			<td><input type="text" class="input" readonly value=<%= roomName %>></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" class="input" name="addr" placeholder="주소를 입력해주세요."></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="tel" name="tel" class="input" placeholder="전화번호를 입력해주세요." pattern="[0-9]{11}" title="하이픈(-)을 넣지 말고 11자리의 전화번호를 입력해주세요."></td>
		</tr>
		<tr>
			<td>입금자명</td>
			<td><input type="text" name="in_name" class="input" placeholder="입금자명을 입력해주세요."></td>
		</tr>
		<tr>
			<td>전달사항</td>
			<td><input type="text" name="comment" class="input" placeholder="전달사항을 입력해주세요."></td>
		</tr>	
	</table>
	<input type="submit" id="reserve" value="예약하기">
	</center>
	</form>
</body>
</html>