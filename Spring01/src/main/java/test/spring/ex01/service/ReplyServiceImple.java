package test.spring.ex01.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.spring.ex01.domain.ReplyVO;
import test.spring.ex01.persistence.BoardDAO;
import test.spring.ex01.persistence.ReplyDAO;

@Service
public class ReplyServiceImple implements ReplyService{
	public static final Logger logger=
			LoggerFactory.getLogger(ReplyServiceImple.class);
	
	@Autowired
	private ReplyDAO replyDAO;
	
	@Autowired
	private BoardDAO boardDAO;
	

	
	@Override
	public int create(ReplyVO rvo) throws Exception {
		 
		logger.info("create() 호출 : vo =" + rvo.toString());
		replyDAO.insert(rvo);
		logger.info("댓글등록");
		
		return 1;
		
	}// end create

	@Override
	public List<ReplyVO> read(int replyBno) {
		logger.info("read()호출");
		return replyDAO.select(replyBno);
	}// end read

	@Override
	public int update(ReplyVO rvo) {
		logger.info("update()호출");
		return replyDAO.update(rvo);
	}// end update
	
	
	@Override
	public int delete(int replyNo, int replyBno) throws Exception {
		logger.info("delete() 호출");
		replyDAO.delete(replyNo);
		logger.info("댓글삭제 성공");
		
		return 1;
	}//end delete
	
	
}// end ReplyServiceImple

