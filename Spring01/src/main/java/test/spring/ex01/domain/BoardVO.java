package test.spring.ex01.domain;

import java.util.Date;

public class BoardVO {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardId;
	private Date cdate;
	
	public BoardVO() {}

	public BoardVO(int boardNo, String boardTitle, String boardContent, String boardId, Date cdate) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardId = boardId;
		this.cdate = cdate;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	@Override
	public String toString() {
		return "BoardVO [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardId=" + boardId + ", cdate=" + cdate + "]";
	}

	

	
}// end BoradVO
