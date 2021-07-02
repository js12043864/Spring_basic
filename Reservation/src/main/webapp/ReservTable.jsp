<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kopo12.domain.*"%>
<%@ page import="kopo12.dao.*"%>
<%@ page import="kopo12.service.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	String date = sdf.format(cal.getTime());
	String selectedDate = request.getParameter("date");
	%>
	<div id="resortName">
		<center>
			<a href="index.jsp" class="resortName"><h1>♧ JS Resort ♧</h1></a>
		</center>
	</div>
	<form action="ReservTable.jsp">
		<center>
			<input type='month' id='currentMonth' name="date" min="<%= date%>" value="<%=selectedDate%>">
			<input type="submit" value="선택" id='select'>
		</center>
	</form>
	<div>
	<center>
	<table>
		<tr>
			<th>Date</th>
			<th>Standard</th>
			<th>Superior</th>
			<th>Deluxe</th>
		</tr>
		<%
		ReservService reservService = ReservServiceImpl.getInstance();
		List<List<String>> showData = reservService.showList(date, selectedDate);
		request.setAttribute("showData", showData);
		%>
		<c:forEach var="showData" items="${showData}">
			<tr>
		 	<td><c:out value="${showData.get(0)}"/></td>
			<c:set var="check" value="${showData.get(2)}" />
				<c:choose>
				    <c:when test="${check eq '예약가능'}">
				        <td><a href=Reserve.jsp?date=${showData.get(0)}&room=${showData.get(1)} style="text-decoration:none; color:black;"><c:out value="${showData.get(2)}"/></a></td>
				    </c:when>
				    <c:otherwise>
				        <td><a href=ReservView.jsp?date=${showData.get(0)}&room=${showData.get(1)}><c:out value="${showData.get(2)}"/></a></td>
				    </c:otherwise>
				</c:choose>
			<c:set var="check" value="${showData.get(4)}" />
				<c:choose>
				    <c:when test="${check eq '예약가능'}">
				        <td><a href=Reserve.jsp?date=${showData.get(0)}&room=${showData.get(3)} style="text-decoration:none; color:black;"><c:out value="${showData.get(4)}"/></a></td>
				    </c:when>
				    <c:otherwise>
				        <td><a href=ReservView.jsp?date=${showData.get(0)}&room=${showData.get(3)}><c:out value="${showData.get(4)}"/></a></td>
				    </c:otherwise>
				</c:choose>
			<c:set var="check" value="${showData.get(6)}" />
				<c:choose>
				    <c:when test="${check eq '예약가능'}">
				        <td><a href=Reserve.jsp?date=${showData.get(0)}&room=${showData.get(5)} style="text-decoration:none; color:black;"><c:out value="${showData.get(6)}"/></a></td>
				    </c:when>
				    <c:otherwise>
				        <td><a href=ReservView.jsp?date=${showData.get(0)}&room=${showData.get(5)}><c:out value="${showData.get(6)}"/></a></td>
				    </c:otherwise>
				</c:choose>		
			</tr>
		</c:forEach>
	</table>

	</div>
</body>
</html>