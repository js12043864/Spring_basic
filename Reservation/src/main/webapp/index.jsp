<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kopo12.domain.*" %>
<%@ page import="kopo12.dao.*" %>
<%@ page import="kopo12.service.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>
<html>
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<link href="reserv.css" rel="stylesheet" type="text/css" />
</head>
<body class="Main">
	<%
	Calendar cal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
	String date = sdf.format(cal.getTime());
	%>
	<div id="resortName">
		<center>
			<a href="index.jsp" class="resortName"><h1>♧ JS Resort ♧</h1></a>
		</center>
	</div>
	<div>
		<center>
			<input type="button" class="button" onclick="location.href='ReservTable.jsp?date=<%= date %>'" value="예약조회">
		</center>
	</div>
</body>
</html>