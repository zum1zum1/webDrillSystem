<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    String userName = (String) session.getAttribute("userName");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbarEexample7">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>
		<div class="collapse navbar-collapse" id="navbarEexample7">
			<font size="5">WEBドリルシステム</font><br>
			<p class="navbar-text navbar-left">
			<form action="./questionListServletTeacher">
				<button type="submit" class="btn btn-default navbar-btn navbar-left">問題確認</button>
			</form>
			<form action="./studentListServlet">
				<button type="submit" class="btn btn-default navbar-btn navbar-left">学生確認</button>
			</form>
			</p>

			<p class="navbar-text navbar-right">
				ようこそ
				<% out.println(userName); %>
				さん。
			</p>
			<form action="../logoutServlet" name="logout">
			<button type="button"
				class="btn btn-default  navbar-btn navbar-right" onclick="logoutConfirm()">ログアウト</button>
				</form>
		</div>
	</div>
	</nav>
	<script type="text/javascript">
	function logoutConfirm(){
		if(confirm("ログアウトしますか？")){
			document.logout.submit();
		}else{
			return false;
		}
	}
	</script>

</body>
</html>