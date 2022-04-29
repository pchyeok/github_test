package test.spring.ex01.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.spring.ex01.domain.ReplyVO;
import test.spring.ex01.service.ReplyService;

@RestController
@RequestMapping(value = "")
public class ReplyRESTController {
	private static final Logger logger = 
			LoggerFactory.getLogger(ReplyRESTController.class);

	@Autowired
	private ReplyService replyService;

	@PostMapping("/board/replies")
	public ResponseEntity<Integer> createReply(@RequestBody ReplyVO rvo) {
		// @RequestBody
		// - 클라이언트에서 전송받은 json 데이터를 자바 객체로 변환해주는 annotation
		// ReplyVO 에 변수명과, JSON으로 설정한 변수명이 같아야 한다.
		logger.info(rvo.toString());
		int result = 0;

		// ResponseEntity<T> : Rest 방식에서 데이터를 리턴할 때 쓰이는 객체
		try {
			result = replyService.create(rvo);
			logger.info("댓글 등록성공");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("result값 확인 : " + result);
		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}// end createReply

	// 현 여기부분이 불러오질 못함. getMappting으로 선언하였음. 
	@GetMapping("/board/replies/all/{replyBno}") // replyBno : 게시판 번호를 가져오기.
	public ResponseEntity<List<ReplyVO>> readReplies(@PathVariable("replyBno") int replyBno) {
		// @PathVariable("replyBno") : / all/{replyBno}값을 설정된 변수에 저장
		logger.info("readReplies() 호출 댓글 전체조회");
		
		List<ReplyVO> list = replyService.read(replyBno);
		logger.info("댓글조회 성공");
		
		return new ResponseEntity<List<ReplyVO>>(list, HttpStatus.OK);
	}// end readReplies

	@PutMapping("/board/replies/{replyNo}") // PUT : 댓글 수정
	public ResponseEntity<String> updateReply(
			@PathVariable("replyNo") int replyNO, 
			@RequestBody ReplyVO rvo) {
		
		rvo.setReplyNo(replyNO);
		int result = replyService.update(rvo);

		if (result == 1) {
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("fail", HttpStatus.OK);
		}
	}// end updateReply

	@DeleteMapping("/board/replies/{replyNo}")
	public ResponseEntity<String> deleteReply(
			@PathVariable("replyNo") int replyNo,
			@RequestBody ReplyVO rvo) {
		try {
			replyService.delete(replyNo, rvo.getReplyBno());
			return new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("fail", HttpStatus.OK);
		}
	}// end deleteReply	

}// end ReplyRESTController
