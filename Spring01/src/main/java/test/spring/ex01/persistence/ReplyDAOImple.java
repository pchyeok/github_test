package test.spring.ex01.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.spring.ex01.domain.ReplyVO;

@Repository
public class ReplyDAOImple implements ReplyDAO {
	private static final Logger logger =
			LoggerFactory.getLogger(ReplyDAOImple.class);
	private static final String NAMESPACE =
			"test.spring.ex01.ReplyMapper";
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(ReplyVO rvo) {
		logger.info("inser() 호출");
		return sqlSession.insert(NAMESPACE + ".insert", rvo);
	}

	@Override
	public List<ReplyVO> select(int replyBno) {
		logger.info("select() 호출 : replyBno = " + replyBno);
		
		return sqlSession.selectList(NAMESPACE + ".select_all_by_reply_bno", replyBno);
	}

	@Override
	public int update(ReplyVO rvo) {
		logger.info("update() 호출");
		return sqlSession.update(NAMESPACE + ".update", rvo);
	}

	@Override
	public int delete(int replyNo) {
		logger.info("delete() 호출 : replyNo = " + replyNo);
		return sqlSession.delete(NAMESPACE + ".delete" , replyNo);
	}

}
