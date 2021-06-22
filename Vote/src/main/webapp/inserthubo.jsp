<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kopo12.domain.*"%>
<%@ page import="kopo12.dao.*"%>
<%@ page import="kopo12.service.*"%>
<%@ page import="java.util.*"%>
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
				background-color: yellow;
			}	
		</style>
	</head>
	<body>
		<%
		String add_hubo = request.getParameter("new");
		if (add_hubo.equals("")) {
			out.println("후보등록 결과 : 잘못된 후보명 형식입니다.");
		} else {
			HuboService huboService = HuboServiceImpl.getInstance();
			Hubo hubo = new Hubo(add_hubo);
			huboService.create(hubo);
		%>
		<div id="box">
			<span> <input type="button" id="menu1" class="menu"
				onClick="location.href='votetable.jsp'" value="후보등록">
			</span> <span> <input type="button" id="menu2" class="menu" value="투표"
				onClick="location.href='voteHubo.jsp'">
			</span> <span> <input type="button" id="menu3" class="menu"
				value="개표결과" onClick="location.href='resultVote.jsp'">
			</span> <br>
			<table>
				<%
				out.println("후보등록 결과 : 후보가 추가 되었습니다.");
				}
				%>
			</table>
		</div>
	</body>
</html>