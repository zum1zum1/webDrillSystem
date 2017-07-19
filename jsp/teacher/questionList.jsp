<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="beans.Question"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	@SuppressWarnings("unchecked")
	ArrayList<Question> question = (ArrayList<Question>) request.getAttribute("Question");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>問題確認</title>
</head>
<body>
	<jsp:include page="./navbar.jsp" flush="true" />
	<p align="center">
		<FONT color="#000000" size="6">問題一覧</FONT><br>
	</p>
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>番号</th>
				<th>見出し</th>
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
								
								out.println("<td>");
								out.println("<form action='./questionDetailServlet'>");
								out.println("<input type='hidden' value='"+question.get(i).getQuestionId()+"' name='detail'/>");
								out.println("<input type='submit' class='btn btn-default' value='詳細'/>");
								out.println("</form>");
								out.println("</td>");

								out.println("<td>");
								out.println("<form action='./questionEditServlet'>");
								out.println("<input type='hidden' value='"+question.get(i).getQuestionId()+"' name='edit'/>");
								out.println("<input type='submit' class='btn btn-info' value='編集'/>");
								out.println("</form>");
								out.println("</td>");
								
								out.println("<td>");
								out.println("<form action='./questionDeleteServlet' name='deleteQuestion'>");
								out.println("<input type='hidden' value='"+question.get(i).getQuestionId()+"'name='delete'/>");
								out.println("<input type='submit' class='btn btn-warning' value='削除'/>");
								out.println("</form>");
								out.println("</td>");
								out.println("</td>");
								out.println("</tr>");
							}
							%>

		</tbody>
		</table>
		<A href="./questionCreate.jsp" class="btn btn-dafault">問題作成</A>
</body>
</html>