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
			
			.age {
				width: 100px;
				text-align:center;
			}
			.graph {
				width: 500px;
			}
		</style>
	</head>
	<body>
		<%
		String person_info = request.getParameter("num");
		int num = Integer.parseInt(person_info);
		HuboService huboService = HuboServiceImpl.getInstance();
		Hubo hubo1 = huboService.selectOne(num);
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
			<%=num%>. <%= hubo1.getName() %> 후보 득표성향 분석
			<table>
			<% 
			TupyoService tupyoService = TupyoServiceImpl.getInstance();
			List<Tupyo> tupyoKihoList = tupyoService.selectAll(num);
			int tupyoKihoSize = tupyoKihoList.size();
			
			int age_num = 10;
			for(int i = 0; i < 9; i++){
				int cnt = 0;
				for(int j = 0; j < tupyoKihoSize; j++){
					if(tupyoKihoList.get(j).getAge() == age_num){
						cnt++;		//각 나이별 수 
					}
				}
				double percent = Math.round((cnt * 100 /tupyoKihoSize) * 100) / 100.0;
				double wid = percent * 400 / 100.0;
				out.println("<tr>" +
								"<td class=age>" + age_num + "대</td>" +
								"<td class=graph>" +
									"<span style=\"border: 1px solid red; width:" + wid + "px; background-color: red; height: 10px; display: inline-block;\">" +
									"</span>" + 
									cnt + "(" + percent +"%)" +
								"</td>" +
							"</tr>"); 
				age_num = age_num + 10;
			}
			%>
			</table>
		</div>
	</body>
</html>