package test.spring.ex01.service;

import java.util.List;

import test.spring.ex01.domain.BoardVO;
import test.spring.ex01.pageutil.PageCriteria;

// CRUD Ȯ��! 11.01.24
public interface BoardService {
	public abstract int create(BoardVO bvo);
	public abstract List<BoardVO> read(PageCriteria criteria);
	public abstract BoardVO read(int boardNo);
	public abstract int update(BoardVO bvo);
	public abstract int delete(int boardNo);
	public abstract int getTotalNumsOfRecords();
}// end BoardService
