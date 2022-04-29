package test.spring.ex01.persistence;

import java.util.List;

import test.spring.ex01.domain.BoardVO;
import test.spring.ex01.pageutil.PageCriteria;

public interface BoardDAO {
	
	int insert(BoardVO bvo);
	List<BoardVO> select();
	BoardVO select(int boardNo);
	int update (BoardVO bvo);
	int delete(int boardNo);
	List<BoardVO> select(PageCriteria c);
	int getTotalNumsOfRecords();
	List<BoardVO> select(String boardId);
	List<BoardVO> selectByTitleOrContent(String keyword);
   
	
	

}// end BaordDAO
