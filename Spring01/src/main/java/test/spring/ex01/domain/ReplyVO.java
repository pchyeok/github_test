package test.spring.ex01.domain;

import java.util.Date;

public class ReplyVO {
	// ´ñ±Û ¹øÈ£
	private int replyNo;
	// °Ô½ÃÆÇ ¹øÈ£ (boardNo)
	private int replyBno;
	// ´ñ±Û ³»¿ë
	private String replyContent;
	// ´ñ±Û ¾ÆÀÌµð 
	private String replyId;
	// ´ñ±Ûµî·Ï³¯Â¥
	private Date replyDate; 
	
	public ReplyVO() {}

	public ReplyVO(int replyNo, int replyBno, String replyContent, String replyId, Date replyDate) {
		super();
		this.replyNo = replyNo;
		this.replyBno = replyBno;
		this.replyContent = replyContent;
		this.replyId = replyId;
		this.replyDate = replyDate;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public int getReplyBno() {
		return replyBno;
	}

	public void setReplyBno(int replyBno) {
		this.replyBno = replyBno;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	@Override
	public String toString() {
		return "ReplyVO [replyNo=" + replyNo + ", replyBno=" + replyBno + ", replyContent=" + replyContent
				+ ", replyId=" + replyId + ", replyDate=" + replyDate + "]";
	}
	
	
}// end ReplyVO
