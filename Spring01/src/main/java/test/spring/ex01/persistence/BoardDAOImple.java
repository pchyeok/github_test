package test.spring.ex01.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.spring.ex01.domain.BoardVO;
import test.spring.ex01.pageutil.PageCriteria;

@Repository // @Component 

public class BoardDAOImple implements BoardDAO {
	private static final Logger logger =
			LoggerFactory.getLogger(BoardDAOImple.class);
	private static final String NAMESPACE = 
			"test.spring.ex01.BoardMapper";
	
	// MyBatis의 SqlSession을 사용하기 위해서
	// 스프링 프레임워크가 생성한 bean을 주입(injection)받음
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public int insert(BoardVO bvo) {
		logger.info("insert() 호출");
		return sqlSession.insert(NAMESPACE + ".insert", bvo);
	} // end insert

	@Override
	public List<BoardVO> select() { // 전체검색
		logger.info("select() 호출");
		return sqlSession.selectList(NAMESPACE + ".select_all");
	} // end select

	@Override
	public BoardVO select(int boardNo) {// 번호 검색
		logger.info("select() 호출 : bno = " + boardNo);
		
		return sqlSession.selectOne(NAMESPACE + ".select_by_boardNo", boardNo);
	}// end select

	@Override
	public int update(BoardVO bvo) { // 수정 

		logger.info("update() 호출 : vo = " + bvo);
		return sqlSession.update(NAMESPACE + ".update", bvo);
	} // end update

	@Override
	public int delete(int boardNo) {
		logger.info("delete()호출 : bno = " + boardNo);
		return sqlSession.delete(NAMESPACE+".delete", boardNo);
	}// end delete

	 @Override
	   public List<BoardVO> select(PageCriteria c) { // 페이징처리 (1~5 페이지)
	      logger.info("");
	      return sqlSession.selectList(NAMESPACE + ".paging", c);
	   }// end select(PageCriteria c)

	  @Override
	   public int getTotalNumsOfRecords() { // 조회수 
	      logger.info("getTotalNumsOfRecords() 호출");
	      return sqlSession.selectOne(NAMESPACE + ".total_count");
	   }// end getTotalNumsOfRecords

	@Override
	public List<BoardVO> select(String boardId) { // 유저 아이디로 검색

		 logger.info("select()호출 + userid = " + boardId);
	      boardId = "%" + boardId + "%";
	      return sqlSession.selectList(NAMESPACE+".select_by_userid", boardId);
	}// end select

	  @Override
	   public List<BoardVO> selectByTitleOrContent(String keyword) {
	      logger.info("select()호출 + keyword = " + keyword);
	      keyword = "%" + keyword + "%";
	      return sqlSession.selectList(NAMESPACE + ".select_by_title_content", keyword);
	   }// end selectByTitleOrContent
	
}// end BoardDAOImple
