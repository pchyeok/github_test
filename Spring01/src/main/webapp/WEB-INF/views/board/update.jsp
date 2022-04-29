<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.title }</title>
</head>
<body>
  <h2>게시글 수정</h2>
  <form action="update" method="POST">
<!--     <input type="hidden" name="_method" value="PUT"> -->
    <input type="hidden" name="page" value="${page }">
    <div>
      <p>글 번호 : ${bvo.boardNo }</p>
      <input type="hidden" name="boardNo" value="${bvo.boardNo }"> <!-- hidden 제목 숨기기 :)  -->
    </div>
    <div>
      <p>
       제목 <input type="text" name="boardTitle" value="${bvo.boardTitle  }">
    </div>
    <div>
      <p>작성자 : ${bvo.boardId }</p>
      <p>작성일 : ${bvo.cdate }</p>
    </div>
    <div>
      <textarea rows="20" cols="120" name="boardContent">${bvo.boardContent }</textarea>
    </div>
    <div>
      <input type="submit" value="게시글 수정">
    </div>
  </form>

  
</body>
</html>