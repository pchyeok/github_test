package test.spring.ex01.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.spring.ex01.domain.BoardVO;
import test.spring.ex01.pageutil.PageCriteria;
import test.spring.ex01.persistence.BoardDAO;

@Service // 22.01.24 ���� ������̼�
// �� ������ ���������� ������� �ʵ��� �ϴ� ���� (Ʈ����� ����) // DB������� ������ ó��
public class BoardServiceImple implements BoardService{
	private static final Logger logger = 
			LoggerFactory.getLogger(BoardServiceImple.class);
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Override
	public int create(BoardVO bvo) {
		logger.info("create() ȣ�� : bvo = " + bvo.toString());
		return boardDAO.insert(bvo);
	}// end create

	@Override
	public List<BoardVO> read(PageCriteria criteria) {
		logger.info("read() 호출 : criteria = " + criteria );
		return boardDAO.select(criteria);
	}// end read(criteria)

	@Override
	public BoardVO read(int boardNo) {
		logger.info("read() 호출 : boardNo = " + boardNo);
		return boardDAO.select(boardNo);
	}// end read(int boardNo)

	@Override
	public int update(BoardVO bvo) {
		logger.info("update() 호출 : bvo = " + bvo.toString());
		return boardDAO.update(bvo);
	}// end update

	@Override
	public int delete(int boardNo) {
		logger.info("delete() 호출 : boardNo = " + boardNo);
		return boardDAO.delete(boardNo);
	}

	@Override
	public int getTotalNumsOfRecords() {
		logger.info("getTotalNumsOfRecords() 호출");
		return boardDAO.getTotalNumsOfRecords();
	}// end getTotalNumsOfRecords
	
}// end BoardServiceImple
