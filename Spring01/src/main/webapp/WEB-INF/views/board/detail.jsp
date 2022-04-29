<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<title>${bvo.boardTitle } - 게시판</title>
</head>
<body>
<h2>글 보기</h2>
  <div>
    <p>글 번호 : ${bvo.boardNo }</p>
  </div>
  <div>
    <p>
      제목 <input type="text" value="${bvo.boardTitle }" readonly="readonly">
    </p>
  </div>
  <div>
    <p>작성자 : ${bvo.boardId }</p> <!-- 작성자 아이디 boardId -->
    <fmt:formatDate value="${bvo.cdate }"  pattern="yyyy-MM-dd HH:mm:ss" var="cdate"/>
    <p>작성일 : ${cdate }</p>

  </div>
  <div>
    <textarea rows="20" cols="120" readonly="readonly">${bvo.boardContent }</textarea>
  </div>
  <div>
    <a href="list?page=${page }"><input type="button" value="글 목록"></a>
    <c:if test="${sessionScope.boardId == bvo.boardId }">
      <a href="update?boardNo=${bvo.boardNo }&page=${page}"><input type="button" value="글 수정"></a>
    <a href="delete?boardNo=${bvo.boardNo }"><input type="button" value="글 삭제"></a>
    </c:if>
</div>
<!-- 게시판 댓글 -->
  <div Style="text-align: center">
    <div>
      <input type="hidden" id="replyBno" value="${rvo.bno }"> 
        <input type="text" id="replyId" value="${sessionScope.boardId }">
        <input type="text" id="replyContent">
  
          <c:if test="${not empty boardId }"> <!-- 아이디가 있을시 댓글작성 -->
	        <button type="button" id="btn_add">작성</button>
          </c:if>
      
    </div>
  </div>
  <!-- 댓글-->
  <hr>
  <div style="text-align: center">
    <div id="replies"> </div>
    </div>
    
    <script type="text/javascript">
    $(document).ready(function(){
        var replyBno = $('#replyBno').val();// 게시판 번호 값을 광역변수로 선언.
        getAllReplies(); // 작성된 댓글 전체조회 
        
      $('#btn_add').click(function(){ // btn_add 버튼을 누르면 
          var replyContent = $('#replyContent').val(); // 댓글 내용
          var replyId = $('#replyId').val() // 댓글 아이디
          var obj = {
                 'replyBno' : replyBno,
                 'replyContent' : replyContent,
                 'replyId' : replyId
            }; 

          var JSONObj = JSON.stringify(obj);
          // 자바스크립트 객체를 json으로 변환 JSON.stringify(객체명);
            
          // $.ajax로 송수신
          $.ajax({
              type : 'post',
              url :  'replies',
              headers : {
                  'Content-Type' : 'application/json',
                  // 'Content-Type' : 현재 전송하는 데이터가 어떤 타입인지에 대한 설명
                  'X-HTTP-Method-Override' : 'POST'
              },
              data : JSONObj, // {obj : JSON.stringify(obj)},  JSON으로 변환. 자바스크립트 객체를 문자열(JSON)으로 변환.
              success : function(result, status){
                  console.log(result);
                  console.log(status);
                  if(result == 1) {
                      alert('댓글 입력 성공');
                      getAllReplies(); // 댓글 등록이 성공한다면, 다시 댓글창을 불러오기 :) 
                      
                  }
              }
          }); //
      }); // end btn_add.click()
        
        // 게시판의 댓글 전체 가져오기 GetMapping
        function getAllReplies() { //getAllReplies 댓글 전체 가져오기 기능설정 22.01.25
            var url = 'replies/all/' + replyBno; // 현재 게시판 번호. all < selectAll
            $.getJSON( // 알아서 parse 해줌.
              url,
    
              function(jsonData) {
                  // jsonData : 서버에서 온 list 데이터가 저장되어 있음.
                  console.log(jsonData);
                var replyWriter = $('#replyId').val();  
                var list = ''; // JSON 데이터를 표현할 변수 선언 
                // $(컬렉션).each() : 컬렉션 데이터를 반복문으로 꺼내는 함수
                
                $(jsonData).each(function(){
                    // this : 컬렉션에서 각 데이터를 꺼내서 저장 
                    console.log(this); // object 타입. 자바스크립트 :)
                    
                  var replyDate = new Date(this.replyDate);
                  var disabled = 'disabled'; 
                  var readonly = 'readonly'; 
                  
                  if(replyWriter == this.replyId) { 
                      disabled = '';
                      readonly = '';
                  }  
                  
                  list += '<div class="reply_item">' 
                    + '<pre>'
                    + '<input type="hidden" id="replyNo" value="'+ this.replyNo +'" />'
                    + '<input type="hidden" id="replyId" value="'+ this.replyId + '" />'
                    + this.replyId
                    +  '&nbsp;&nbsp;' // 공백
                    + '<input type="text" id="replyContent" value="'+ this.replyContent + '" '+ readonly + '/>'
                     
                    + '&nbsp;&nbsp;'
                    + replyDate
                    + '&nbsp;&nbsp;'
                    + '<button class="btn_update" type="button" '+ disabled +' >수정</button>'
                    + '<button class="btn_delete" type="button" '+ disabled +' >삭제</button>'  
                    
                    + '</pre>'
                    + '</div>';
                 
                }); // end each()
                $('#replies').html(list);
                
              } // end function(jsonData)
            
            );// end getSJON
        }// end getAllReplies()
        
        // 수정 버튼을 클릭하면 선택된 댓글 수정
              $('#replies').on('click', '.reply_item .btn_update', function(){
                  
                  console.log(this); 
                  
                  console.log($(this).prevAll()); // prevAll 기능 조회. 
                  // 선택된 댓글 replyNo, replyContent 값을 저장 
                  var replyNo = $(this).prevAll('#replyNo').val();
                  // prevAll() : 선택된 노드의 이전 모든 형제의 노드 
                  var replyContent = $(this).prevAll('#replyContent').val();
                  console.log("선택된 댓글 번호 : " + replyNo + ", 댓글 내용 : " + replyContent);
              
                // ajax 요청  수정
                $.ajax({
                    type : 'put', 
                    url : 'replies/' + replyNo,
                    data : JSON.stringify({ 
                        'replyBno' : replyBno,
                        'replyContent' : replyContent
                    }),
                    headers : {
                        'Content-Type' : 'application/json',
                        
                        'X-HTTP-Method-Override' : 'PUT'
                    },
                    success : function(result) {
                        if(result == 'success'){
                            alert('댓글 수정 성공!');
                            getAllReplies(); // 댓글 수정이 성공하면 댓글창 다시 불러오기 :)
                        }
                    }// end success
                }); // end ajax
              }); // replies.on() update
              
           // 삭제 버튼을 클릭하면 선택된 댓글 삭제
          $('#replies').on('click', '.reply_item .btn_delete', function(){
                console.log(this);
                
               var replyNo = $(this).prevAll('#replyNo').val(); // 댓글 번호로 삭제
         console.log("선택된 댓글 번호 : " + replyNo);       
                // ajax 요청하기 :)
              $.ajax({
               type : 'delete', // 원래는 post로 해야함.
               url : 'replies/' + replyNo,
               data : JSON.stringify({
                  'replyBno' : replyBno,
              }),
              headers : {
                  'Content-Type' : 'application/json',
                  // 'Content-Type' : 현재 전송하는 데이터가 어떤 타입인지에 대한 설명
                  'X-HTTP-Method-Override' : 'DELETE'
              },
              success : function(result) {
                  if(result == 'success'){
                      alert('댓글 삭제 성공!');
                      getAllReplies(); // 댓글 수정이 삭제되면 댓글창 다시 불러오기 :)
                  }
                }// end success
              }); // end ajax
           }); // end replies.on() delete 
           
    }); // end documnet
  </script>
</body>
</html>