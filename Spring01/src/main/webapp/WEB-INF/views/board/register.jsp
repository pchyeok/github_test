<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성하기</title>
</head>
<body>
<form action="register" method="post">
  <div>
	<p>제목 : <input type="text" name="boardTitle" placeholder="제목입력" required>
  </div>
  <div>
	<p> 아이디 : <input type="text" name="boardId"  value="${sessionScope.boardId }" readonly="readonly">
  </div>
  <div>
	<p>내용 <textarea rows="30" cols="50" maxlength="50" name="boardContent" placeholder="내용기입"> </textarea>
  </div>
  <div>
	<input type="submit" value="게시글 등록하기">
  </div>

</form>
</body>
</html>