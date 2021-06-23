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
	String name = request.getParameter("name");
	String date = request.getParameter("date");
	String addr = request.getParameter("addr");
	String tel = request.getParameter("tel");
	String in_name = request.getParameter("in_name");
	String comment = request.getParameter("comment");
	int room = Integer.parseInt(request.getParameter("room"));
	int processing = 1;
	ReservService reservService = ReservServiceImpl.getInstance();
	Reservation reservation = new Reservation(name,date,room,addr,tel,in_name,comment,processing);
	reservService.create(reservation);
	%>
	
	<script>
		window.addEventListener('DOMContentLoaded', function() {
			location.href = 'ReservView.jsp?date=<%= date%>&room=<%= room%>';
		});
		</script>
</body>
</html>