package test.spring.ex01.persistence;

import java.util.List;

import test.spring.ex01.domain.ReplyVO;

public interface ReplyDAO {
	
	int insert(ReplyVO rvo);
	List<ReplyVO> select(int replyBno);
	int update(ReplyVO rvo);
	int delete(int replyNo);
	
}// end ReplyDAO
