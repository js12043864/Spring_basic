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
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
	String listDate = sdf.format(cal.getTime());	
	
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
	<center>
	<table>
		<tr>
			<td>성명</td>
			<td>${reservation.name}</td>
		</tr>
		<tr>
			<td>예약일자</td>
			<td>${reservation.resv_date}</td>
		</tr>
		<tr>
			<td>객실</td>
			<td><%= roomName %></td>
		</tr>
		<tr>
			<td>주소</td>
			<td>${reservation.addr}</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${reservation.telnum}</td>
		</tr>
		<tr>
			<td>입금자명</td>
			<td>${reservation.in_name}</td>
		</tr>
		<tr>
			<td>전달사항</td>
			<td>${reservation.comment}</td>
		</tr>
		<tr>
			<td>작성날짜</td>
			<td>${reservation.write_date}</td>
		</tr>
		<tr>
			<td>예약상태</td>
			<td>
			<c:set var = "reservation" value = "${reservation.processing}"/>
		    <c:choose>	
		        <c:when test = "${reservation == 1}">
		         예약완료
		        </c:when>
		        <c:when test = "${reservation == 2}">
		         입금완료
		        </c:when>
		        <c:otherwise>
		         환불요청
		        </c:otherwise>
		    </c:choose>
			</td>
		</tr>
	</table>
	<input type="button" id="list" onclick="location.href='ReservTable.jsp?date=<%= listDate %>'" value="목록">
	<input type="button" id="change" onclick="update()" value="예약변경">
	<input type="button" id="cancel" onclick="cancel()" value="예약취소">
	</center>
</body>
<script>
    function cancel() {
        if (!confirm("예약을 취소하시겠습니까?")) {
            alert("취소(아니오)를 누르셨습니다.");
        } else {
            alert("확인(예)을 누르셨습니다.");
            location.href = 'ReservCancel.jsp?date=<%= date %>&room=<%= room %>';
        }
    }
    function update() {
        if (!confirm("예약을 변경하시겠습니까?")) {
            alert("취소(아니오)를 누르셨습니다.");
        } else {
            alert("확인(예)을 누르셨습니다.");
            location.href = 'ReservUpdate.jsp?date=<%= date %>&room=<%= room %>';
        }
    }
</script>
</html>