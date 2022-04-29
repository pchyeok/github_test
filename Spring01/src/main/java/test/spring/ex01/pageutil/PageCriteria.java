package test.spring.ex01.pageutil;

// ë¸Œë¼?š°???—?„œ ë³´ì—¬ì§? ?˜?´ì§? ë²ˆí˜¸??
// ?•œ ?˜?´ì§??—?„œ ë³´ì—¬ì§? ê²Œì‹œê¸??˜ ê°œìˆ˜ë¥? ???¥?•˜?Š” ?´?˜?Š¤
// -> paging ì²˜ë¦¬?— ?•„?š”?•œ start?? end ë²ˆí˜¸ë¥? ?•Œ ?ˆ˜ ?ˆ?Œ
public class PageCriteria {
	private int page; // ?˜„?¬ ?˜?´ì§? ë²ˆí˜¸
	private int numsPerPage; // ?•œ ?˜?´ì§??˜ ê²Œì‹œê¸? ê°œìˆ˜
	
	public PageCriteria() {
		this.page = 1; // 1 ?˜?´ì§? ?‹œ?‘.
		this.numsPerPage = 5; // bno 5ê°? ?ˆœ?œ¼ë¡? ë³´ì—¬ì¤?.
	} // ê¸°ì´ˆê°’ì„ 1?˜?´ì§? 5ê°œë¡œ ?„¤? •?„ ?•´?‘?—ˆ?Œ. ?””?´?Š¸ ?„¤? • :) 
	
	public PageCriteria(int page, int numsPerPage) {
		this.page = page;
		this.numsPerPage = numsPerPage;
	}

	// getter/setter
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getNumsPerPage() {
		return numsPerPage;
	}

	public void setNumsPerPage(int numsPerPage) {
		this.numsPerPage = numsPerPage;
	}
	
	// ?˜„?¬ ë³´ì—¬ì§??Š” ?˜?´ì§??˜ ?‹œ?‘ ê¸? ?¼? ¨ë²ˆí˜¸(rn)
	public int getStart() {
		return (this.page - 1) * this.numsPerPage + 1;
	} // page ?˜„?¬ ?˜?´ì§? ë²ˆí˜¸, numsPerPage ê²Œì‹œê¸? ê°??ˆ˜ 
	
	// ?˜„?¬ ë³´ì—¬ì§??Š” ?˜?´ì§??˜ ë§ˆì?ë§? ê¸? ?¼? ¨ë²ˆí˜¸(rn)
	public int getEnd() {
		return this.page * this.numsPerPage;
	}
	
	
} // end PageCriteria
