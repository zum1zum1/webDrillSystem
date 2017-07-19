<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="beans.Question"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	Question question = (Question) request.getAttribute("Question");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>問題詳細</title>
</head>
<body>
<jsp:include page="./navbar.jsp" flush="true" />
	<p align="center">
		<FONT color="#000000" size="6">問題編集</FONT><br>
	</p>
	<form action="./questionUpdateServlet" name='edit'>
<%

	out.println("<div class='col-md-10 col-md-offset-1'>");
	out.println("<table class='table table-striped table-bordered'>");
	out.println("<tr>");
	out.println("<td>");
	out.println("問題番号");
	out.println("</td>");
	out.println("<td>");
	out.println("<input type='hidden' name='id' value='"+question.getQuestionId()+"'>");
	out.println(question.getQuestionId());
	out.println("</td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("見出し");
	out.println("</td>");
	out.println("<td>");
	out.println(question.getQuestionHeadline());
	out.println("</td>");
	out.println("<td>");
	out.println("<input type='text' name='headline' placeholder='"+question.getQuestionHeadline()+"'>");
	out.println("</td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("問題文");
	out.println("</td>");
	out.println("<td>");
	out.println(question.getQuestionText());
	out.println("</td>");
	out.println("<td>");
	out.println("<TEXTAREA name='text' placeholder='"+question.getQuestionText()+"'></TEXTAREA>");
	out.println("</td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("解答①");
	out.println("</td>");
	out.println("<td>");
	out.println(question.getChoice1());
	out.println("</td>");
	out.println("<td>");
	out.println("<input type='text' name='choice1' placeholder='"+question.getChoice1()+"'>");
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
	out.println("<input type='text' name='choice2' placeholder='"+question.getChoice2()+"'>");
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
	out.println("<input type='text' name='choice3' placeholder='"+question.getChoice3()+"'>");
	out.println("</td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("正解");
	out.println("</td>");
	out.println("<td>");
	out.println(question.getCorrectAnswer());
	out.println("</td>");
	out.println("<td>");
	out.println("<input type='text' name='correctAnswer' placeholder='"+question.getCorrectAnswer()+"'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("</table>");
	out.println("<button type='button' class='btn btn-default' onclick='editConfirm()'>確認</button>");
	out.println("</div>");
	
%>
	</form>

	<script type="text/javascript">
	function editConfirm(){
		if(confirm("本当に変更しますか？")){
			document.edit.submit();
		}else{
			return false;
		}
	}
	</script>
</body>
</html>