<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kopo12.domain.*" %>
<%@ page import="kopo12.dao.*" %>
<%@ page import="kopo12.service.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
	<head>
		<style>
			#box {
				border: 3px solid green;
				border-collapse: collapse;
				width: 600px;
				margin-left: auto; 
				margin-right: auto;
				padding-bottom: 2px;
			}

			.menu {
				border: 2px solid blue;
				border-collapse: collapse;
				text-align: center;
				background-color: white;
				padding: 5px;
				margin-top : 5px;
				margin-bottom : 5px;
				font-size: 15px;
			}

			#menu1 {
				margin-left: 5px;
			}

			#menu2 {
				background-color: yellow;
			}
		</style>
		<%
		try{
		String voteNum = request.getParameter("num_name");
		String[] addNum = voteNum.split("번");
		int voteAge = Integer.parseInt(request.getParameter("age"));
		int voteId = Integer.parseInt(addNum[0]);		
		%>
	</head>
	<body>
		<%
		TupyoService tupyoService = TupyoServiceImpl.getInstance();
		Tupyo tupyo = new Tupyo(voteId, voteAge);
		tupyoService.create(tupyo);	
		%>
		<div id="box">
			<span>
				<input type="button" id="menu1" class="menu" onClick="location.href='votetable.jsp'" value="후보등록">
			</span>
			<span>
				<input type="button" id="menu2" class="menu" value="투표" onClick="location.href='voteHubo.jsp'">
			</span>
			<span>
				<input type="button" id="menu3" class="menu" value="개표결과" onClick="location.href='resultVote.jsp'">
			</span>
			<br>
			<table>
			<% 
			out.println("투표 결과 : 투표하였습니다.");
			}catch(NullPointerException e) {
				out.println("후보자가 없습니다.");
			}
			%>
			</table>
		</div>
	</body>
</html>