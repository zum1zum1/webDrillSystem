<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="beans.Question"%>
<%@ page import="beans.History"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Question question = (Question) request.getAttribute("Question");
	History history = (History) request.getAttribute("History");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>問題</title>
</head>
<body>
	<jsp:include page="./navbar.jsp" flush="true" />
	<p align="center">
		<FONT color="#000000" size="6">解答を変更する</FONT><br>
	</p>
	<form action="./historyUpdateServlet">
		<%
	out.println("<table class='table table-striped table-bordered'>");
	out.println("<tr>");
	out.println("<td>");
	out.println("問題番号");

	out.println("</td>");
	out.println("<td>");	
	out.println(question.getQuestionId());
	out.println("</td>");
	out.println("<input type='hidden' name='questionId' value='"+question.getQuestionId()+"'>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("見出し");
	out.println("</td>");
	out.println("<td>");
	out.println(question.getQuestionHeadline());
	out.println("</td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("問題文");
	out.println("</td>");
	out.println("<td>");
	out.println(question.getQuestionText());
	out.println("</td>");
	out.println("</tr>");
	if(history.getUserAnswer()==1){
		out.println("<tr>");
		out.println("<td>");
		out.println("解答①");
		out.println("</td>");
		out.println("<td>");
		out.println(question.getChoice1());
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='radio' name='answer' value='1' checked></font>");
		out.println("</td>");
		out.println("</tr>");
	
		out.println("<tr>");
		out.println("<td>");
		out.println("解答②");
		out.println("</td>");
		out.println("<td>");
		out.println(question.getChoice2());
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='radio' name='answer' value='2'></font>");
		out.println("</td>");
		out.println("</tr>");
	
		out.println("<tr>");
		out.println("<td>");
		out.println("解答③");
		out.println("</td>");
		out.println("<td>");
		out.println(question.getChoice3());
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='radio' name='answer' value='3'></font>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
	}else if(history.getUserAnswer()==2){
		out.println("<tr>");
		out.println("<td>");
		out.println("解答①");
		out.println("</td>");
		out.println("<td>");
		out.println(question.getChoice1());
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='radio' name='answer' value='1'></font>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("解答②");
		out.println("</td>");
		out.println("<td>");
		out.println(question.getChoice2());
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='radio' name='answer' value='2' checked></font>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("解答③");
		out.println("</td>");
		out.println("<td>");
		out.println(question.getChoice3());
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='radio' name='answer' value='3'></font>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
	}else{
		out.println("<tr>");
		out.println("<td>");
		out.println("解答①");
		out.println("</td>");
		out.println("<td>");
		out.println(question.getChoice1());
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='radio' name='answer' value='1'></font>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("解答②");
		out.println("</td>");
		out.println("<td>");
		out.println(question.getChoice2());
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='radio' name='answer' value='2'></font>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr>");
		out.println("<td>");
		out.println("解答③");
		out.println("</td>");
		out.println("<td>");
		out.println(question.getChoice3());
		out.println("</td>");
		out.println("<td>");
		out.println("<input type='radio' name='answer' value='3' checked></font>");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
	}
%>
		<input type="submit" class="btn btn-default" value="答える！" />
	</form>
</body>
</html>