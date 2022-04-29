package test.spring.ex01.service;

import java.util.List;

import test.spring.ex01.domain.ReplyVO;

public interface ReplyService {
	
	int create(ReplyVO rvo) throws Exception;
	List<ReplyVO> read(int replyBno);
	int update(ReplyVO rvo);
	int delete(int replyNo, int replyBno) throws Exception;
	
}//end ReplyService
