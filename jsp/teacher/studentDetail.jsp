<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="beans.User"%>
    <%@ page import="java.util.ArrayList"%>
	<%@ page import="beans.Question"%>
	<%@ page import="beans.History"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	User user = (User) request.getAttribute("User");
	@SuppressWarnings("unchecked")
	ArrayList<Question> question = (ArrayList<Question>) request.getAttribute("Question");
	@SuppressWarnings("unchecked")
	ArrayList<History> history = (ArrayList<History>) request.getAttribute("History");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生詳細</title>
</head>
<body>
<jsp:include page="./navbar.jsp" flush="true" />
	<p align="center">
		<FONT color="#000000" size="6">学生詳細</FONT><br>
	</p>

<%
	out.println("<table class='table table-striped table-bordered'>");
	out.println("<tr>");
	out.println("<td>");
	out.println("学生番号");
	out.println("</td>");
	out.println("<td>");	
	out.println(user.getId());
	out.println("</td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("氏名");
	out.println("</td>");
	out.println("<td>");
	out.println(user.getUserName());
	out.println("</td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("ユーザーid");
	out.println("</td>");
	out.println("<td>");
	out.println(user.getUserId());
	out.println("</td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("ユーザーパスワード");
	out.println("</td>");
	out.println("<td>");
	out.println(user.getUserPassword());
	out.println("</td>");
	out.println("</tr>");


	out.println("</table>");


%>
	<p align="center">
		<FONT color="#000000" size="6">解答履歴</FONT><br>
	</p>
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>番号</th>
				<th>見出し</th>
				<th>正解不正解</th>
				<th>生徒の解答</th>
			</tr>
		</thead>
		<tbody>
			<%
							for (int i=0;i<question.size();i++) {
								
								out.println("<tr>");
								out.println("<th>");
								out.println(question.get(i).getQuestionId());
								out.println("</th>");
								out.println("<th>");
								out.println(question.get(i).getQuestionHeadline());
								out.println("</th>");

								int flag = 0;
								for(int j=0;j<history.size();j++){
									if(question.get(i).getQuestionId()==history.get(j).getQuestionId()){
										flag = 1;
										out.println("<td>");
										
										if(question.get(i).getCorrectAnswer()==history.get(j).getUserAnswer()){
											out.println("正解");
										}else{
											out.println("不正解");
										}
										
										out.println("</td>");
										out.println("<td>");
										out.println(history.get(j).getUserAnswer());
										out.println("</td>");
										
										break;
									}
								}
								if(flag == 0){
									out.println("<td>");
									out.println("未解答");
									out.println("</td>");
								}
							}
							%>

		</tbody>
	</table>
</body>
</html>