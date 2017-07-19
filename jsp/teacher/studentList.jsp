<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="beans.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	@SuppressWarnings("unchecked")
	ArrayList<User> user = (ArrayList<User>) request.getAttribute("User");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生確認</title>
</head>
<body>
	<jsp:include page="./navbar.jsp" flush="true" />
	<p align="center">
		<FONT color="#000000" size="6">学生一覧</FONT><br>
	</p>
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>番号</th>
				<th>名前</th>
			</tr>
		</thead>
		<tbody>
			<%
							for (int i=0;i<user.size();i++) {
								
								out.println("<tr>");
								out.println("<th>");
								out.println(user.get(i).getId());
								out.println("</th>");
								out.println("<th>");
								out.println(user.get(i).getUserName());
								out.println("</th>");
								
								out.println("<td>");
								out.println("<form action='./studentDetailServlet'>");
								out.println("<input type='hidden' value='"+user.get(i).getId()+"' name='detail'/>");
								out.println("<input type='submit' class='btn btn-default' value='詳細'/>");
								out.println("</form>");
								out.println("</td>");
								
								out.println("<td>");
								out.println("<form action='./studentDeleteServlet' name='deleteStudent'>");
								out.println("<input type='hidden' value='"+user.get(i).getId()+"'name='delete'/>");
								out.println("<input type='submit' class='btn btn-warning' value='削除'/>");
								out.println("</form>");
								out.println("</td>");
								out.println("</td>");
								out.println("</tr>");
							}
							%>

		</tbody>
	</table>
	<A href="./studentCreate.jsp" class="btn btn-dafault">学生登録</A>
</body>
</html>