<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kopo12.domain.*" %>
<%@ page import="kopo12.dao.*" %>
<%@ page import="kopo12.service.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
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
				background-color: yellow;
			}		
		</style>
	</head>
	<body>
		<%
			int delId = Integer.parseInt(request.getParameter("num"));
			HuboService huboService = HuboServiceImpl.getInstance();
			Hubo hubo = new Hubo(delId);
			huboService.delete(hubo);
		%>
		<div id="box">
			<span>
				<input type="button" id="menu1" class="menu" onClick="location.href='votetable.jsp'" value="�ĺ����">
			</span>
			<span>
				<input type="button" id="menu2" class="menu" value="��ǥ" onClick="location.href='voteHubo.jsp'">
			</span>
			<span>
				<input type="button" id="menu3" class="menu" value="��ǥ���" onClick="location.href='resultVote.jsp'">
			</span>
			<br>	
			<table>
			<% 
				out.println("�ĺ���� ��� : �ĺ��� ���� �Ǿ����ϴ�.");	
			%>
			</table>
		</div>
	</body>
</html>