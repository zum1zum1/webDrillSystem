<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生登録</title>
</head>
<body>
<jsp:include page="./navbarx.jsp" flush="true" />
	<p align="center">
		<FONT color="#000000" size="6">学生登録</FONT><br>
	</p>
	<form action="./studentCreateServlet" name='create'>
<%

	out.println("<div class='col-md-10 col-md-offset-1'>");
	out.println("<table class='table table-striped table-bordered'>");
	out.println("<tr>");
	out.println("<td>");
	out.println("学生番号");
	out.println("</td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("氏名");
	out.println("</td>");
	out.println("<td>");
	out.println("<input type='text' name='userName'>");
	out.println("</td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("ログインid");
	out.println("</td>");
	out.println("<td>");
	out.println("<input type='text' name='userId'>");
	out.println("</td>");
	out.println("</tr>");
	
	out.println("<tr>");
	out.println("<td>");
	out.println("ログインパスワード");
	out.println("</td>");
	out.println("<td>");
	out.println("<input type='text' name='userPassword'>");
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