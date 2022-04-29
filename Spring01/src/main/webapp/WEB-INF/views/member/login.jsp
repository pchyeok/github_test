<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
</head>
<body>
<h1> 로그인 </h1>
<form action="login" method="post">
	<input type="text" name ="boardId" placeholder ="아이디" required autofocus>
	<input type="password" name="password" placeholder="비밀번호" required autofocus>
	<input type="submit" class="btn_login" value="로그인">
</form>
<!-- 
<script type="text/javascript">
	$(document).ready(function(){
		$(".btn_login").click(function(){
			var boardId = $('.boardId').val();
			var password = $('.password').val();
			
			if(boardId == "") {
				alter ("아이디 미입력");
				$(".boardId").focus();
				return;
			}
			if(password == "") {
				alter ("비밀번호 미입력");
				$(".password").focus();
				return
			}
			$("#login").attr("action", "login");
			$("#login").submit();
		});// end btn_login.click
	});// end document.ready
</script>
 -->
</body>
</html>