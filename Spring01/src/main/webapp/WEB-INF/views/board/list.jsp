<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>   
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table, th, td {
  border-style : solid;
  border-width : 1px;
  text-align : center;
}

ul {
  list-style-type : none;
}

li {
  display : inline-block;
}

</style>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>게시판 메인</title>
</head>
<body>
  <h1>게시판 메인화면</h1>
  
  <c:if test="${empty boardId }">
  	<button type="button" id="btn_login">로그인</button>
  </c:if>
  
  <c:if test="${not empty boardId }">
    <a href="register"><input type="button" value="글작성"></a>
  	<button type="button" id="btn_logout">로그아웃</button>
  </c:if>
  <hr>
  <!-- list.jsp는 게시판 메인글 호출이므로, GET방식이다 :) 
    form에서 method를 따로 지정하지 않으면, GET방식으로 디폴트된다. 
   -->
  <hr>
  <table>
    <thead>
      <tr>
        <th style="width : 60px">번호</th>
        <th style="width : 700px">제목</th>
        <th style="width : 60px">작성자</th>
        <th style="width : 100px">작성일</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="bvo" items="${list }">
        <tr>
          <td>${bvo.boardNo }</td>
          <td><a href="detail?boardNo=${bvo.boardNo }&page=${pageMaker.criteria.page}">${bvo.boardTitle }</a></td> 
          <!--  <a href="detail.do">로 제목 클릭시 넘어가기. -->
          <td>${bvo.boardId }</td>
         <fmt:formatDate value="${bvo.cdate }"  pattern="yyyy-MM-dd HH:mm:ss" var="cdate"/>
          <td>${cdate }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
  
  <hr>
  <ul>
    <c:if test="${pageMaker.hasPrev }">
      <li><a href="list?page=${pageMaker.startPageNo -1 }">이전</a></li> 
      <!-- startPageNo 4,5,6일 경우 이전을 누를시 , startpage 4번 -1 -> 3번으로 넘어감!(1,2,3) -->
    </c:if>
    
    <c:forEach begin="${pageMaker.startPageNo }" 
    end="${pageMaker.endPageNo }" var="num"> 
    <!-- begin : 시작  end : 끝 -->
      <li><a href="list?page=${num }">${num }</a></li>    
      <!--  페이지 번호가 늘어나면, var=num 설정으로 자동으로 번호가 늘어난다. -->
    </c:forEach>
    
    <c:if test="${pageMaker.hasNext }">
    <li><a href="list?page=${pageMaker.endPageNo + 1 }">다음</a></li>
    <!-- endpage 1,2,3 < 일 경우 다음을 누를 시, 4부터 구현되게 -->
    </c:if>
    <!-- 페이지 버튼은 구현이 되었지만, 게시글이 부족하면 구현되지 않는 기능..  -->
    <!--  날짜검색, 페이지 게시글 숫자 늘리기 (버튼으로) -->
  </ul>
  
  <!-- BoardController -> registerPOST()에서 보낸 데이터 저장 10.19-->
  <input type="hidden" id="insertAlert" value="${insert_result }">
  
  <script type="text/javascript">
     $(document).ready(function(){
         confirmInsertResult();
         function confirmInsertResult() {
             var result =$('#insertAlert').val();
             if(result == 'success') {
                 alert('새 글 작성 성공');
             }
         } // end function
         
         $('#btn_login').click(function(){
        	 location ='../member/login'
         }); // end btn_login.click
         
         $('#btn_logout').click(function(){
        	 location = '../member/logout'
         }); // end btn_logout.click
     }); // end ready(function)
  </script>
  
</body>
</html>
