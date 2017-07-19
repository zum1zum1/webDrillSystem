<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>



</head>
<body>
	<B>webドリルシステム</B>
	<form name="login" action="./loginServlet" method="POST">
		<p>ユーザーID</p>
		<input type="text" name="userId" maxlength="12">
		<p>パスワード</p>
		<input type="password" name="userPassword" maxlength="12">
		<p class="submit">
			<input type="button" value="ログイン" onclick="myConfirm()" />
		</p>
	</form>
	<script type="text/javascript">
		function myConfirm() {
			if(confirm("ログインしますか？")){
				document.login.submit();
			}else{
				return false;
			}
		}
	</script>

</body>
</html>