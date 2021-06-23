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
<title>Insert title here</title>
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
	Reservation reservation = new Reservation(date, room);
	reservService.delete(reservation);
	%>
	
	<script>
		window.addEventListener('DOMContentLoaded', function() {
			location.href = 'ReservTable.jsp?date=<%= listDate%>';
		});
		</script>
</body>
</html>