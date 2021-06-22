<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			}

			#menu3 {
				background-color: yellow;
			}

			#hubo {
				width: 100px;
			}
			
			td {
				border: 1px solid black;
				border-collapse: collapse;
				padding-top: 4px;
				padding-bottom: 4px;
			}
			
			a:link {
				color : black;
			}
			
			a:visited {
				color : black;
			}
			
			.person {
				padding: 2px 4px 2px 4px;
				width: 100px;
			}
			
			.graph {
				width: 500px;	
			}
		</style>
	</head>
	<body>
		<%
		try{
			HuboService huboService = HuboServiceImpl.getInstance();
			TupyoService tupyoService = TupyoServiceImpl.getInstance();
			List<Hubo> huboList = huboService.selectAll();
			List<Tupyo> tupyoAllList = tupyoService.selectAll();
			int tupyoAllSize = tupyoAllList.size();
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
			후보 별 득표율
			<table>
			<% 	
			for(Hubo hubo: huboList){
				List<Tupyo> tupyoKihoList = tupyoService.selectAll(hubo.getId());
				double percent = Math.round((tupyoKihoList.size() * 100 /tupyoAllSize) * 100) / 100.0;
				double wid = percent * 400 / 100.0;
				out.println("<tr><td class=person>" + "<a href=/Vote/oneview.jsp?num=" + hubo.getId() + ">" 
					+ hubo.getId() + " &nbsp;" + hubo.getName() + "</a></td><td class=graph><span style=\"border: 1px solid red; width:" + wid + "px; background-color: red; height: 10px; display: inline-block;\"></span>" 
					+ tupyoKihoList.size() + "(" + percent + "%)</td></tr>"); 
				}
			}catch(Exception e) {
				out.println(e.getMessage());
				out.println("후보가 없습니다.");
			}
			%>
			</table>
		</div>
	</body>
</html>