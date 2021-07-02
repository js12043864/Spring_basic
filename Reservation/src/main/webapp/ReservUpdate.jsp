<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kopo12.domain.*" %>
<%@ page import="kopo12.dao.*" %>
<%@ page import="kopo12.service.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	Reservation reservation = reservService.selectOne(date, room);
	request.setAttribute("reservation", reservation);
	String roomName = reservService.roomName(room);	
	%>
	<div id="resortName">
		<center>
			<a href="index.jsp" class="resortName"><h1>♧ JS Resort ♧</h1></a>
		</center>
	</div>
	<form method="post" action="CompleteUpdate.jsp?room=<%= room %>">
	<center>
	<table>
		<tr>
			<td>성명</td>
			<td><input type="text" name="name" readonly value="${reservation.name}"></td>
		</tr>
		<tr>
			<td>예약일자</td>
			<td><input type="text" name="date" readonly value="${reservation.resv_date}"></td>
		</tr>
		<tr>
			<td>객실</td>
			<td><input type="text" readonly value=<%= roomName %>></td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="addr" value=${reservation.addr}></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="tel" name="tel" pattern="[0-9]{11}" title="하이픈(-)을 넣지 말고 11자리의 전화번호를 입력해주세요."
					value=${reservation.telnum}></td>
		</tr>
		<tr>
			<td>입금자명</td>
			<td><input type="text" name="in_name" value=${reservation.in_name}></td>
		</tr>
		<tr>
			<td>전달사항</td>
			<td><input type="text" name="comment" value=${reservation.comment}></td>
		</tr>	
	</table>
	<input type="button" id="cancel" onclick="location.href='ReservView.jsp?date=<%= date %>&room=<%= room %>'" value="취소">
	<input type="submit" id="change" value="예약변경">
	</form>
	<center>
</body>
<script>
    function cancel() {
        if (!confirm("예약변경을 취소하시겠습니까?")) {
            alert("취소(아니오)를 누르셨습니다.");
        } else {
            alert("확인(예)을 누르셨습니다.");
            location.href = 'ReservView.jsp?date=<%= date %>&room=<%= room %>';
        }
    }
</script>
</html>