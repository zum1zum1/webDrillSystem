<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>問題作成</title>
</head>
<body>
<jsp:include page="./navbar.jsp" flush="true" />
	<p align="center">
		<FONT color="#000000" size="6">問題作成</FONT><br>
	</p>
	<form action="./questionCreateServlet" name='create'>
<%

	out.println("<div class='col-md-10 col-md-offset-1'>");
	out.println("<table class='table table-striped table-bordered'>");
	out.println("<tr>");
	out.println("<td>");
	out.println("問題番号");
	out.println("</td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("見出し");
	out.println("</td>");
	out.println("<td>");
	out.println("<input type='text' name='headline'>");
	out.println("</td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("問題文");
	out.println("</td>");
	out.println("<td>");
	out.println("<TEXTAREA name='text'></TEXTAREA>");
	out.println("</td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("解答①");
	out.println("</td>");
	out.println("<td>");
	out.println("<input type='text' name='choice1'>");
	out.println("</td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("解答②");
	out.println("</td>");
	out.println("<td>");
	out.println("<input type='text' name='choice2'>");
	out.println("</td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("解答③");
	out.println("</td>");
	out.println("<td>");
	out.println("<input type='text' name='choice3'>");
	out.println("</td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("正解");
	out.println("</td>");
	out.println("<td>");
	out.println("<input type='text' name='correctAnswer'>");
	out.println("</td>");
	out.println("</tr>");

	out.println("</table>");
	out.println("<button type='button' class='btn btn-default' onclick='createConfirm()'>確認</button>");
	out.println("</div>");
	
%>
	</form>

	<script type="text/javascript">
	function createConfirm(){
		if(confirm("この内容でよろしいでしょうか？")){
			document.create.submit();
		}else{
			return false;
		}
	}
	</script>
</body>
</html>