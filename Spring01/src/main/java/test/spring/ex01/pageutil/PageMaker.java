package test.spring.ex01.pageutil;

// ?Ž˜?´ì§? ë²ˆí˜¸?“¤?˜ ë§í¬ë¥? ë§Œë“¤ê¸? ?œ„?•œ ?œ ?‹¸ë¦¬í‹° ?´?ž˜?Š¤
public class PageMaker {
	private PageCriteria criteria; // criteria ê¸°ì??´?? ?œ»
	private int totalCount; // ? „ì²? ê²Œì‹œê¸? ê°œìˆ˜
	private int numsOfPageLinks; // ?Ž˜?´ì§? ë²ˆí˜¸ ë§í¬?˜ ê°œìˆ˜
	private int startPageNo; // ?‹œ?ž‘ ?Ž˜?´ì§? ë§í¬ ë²ˆí˜¸
	private int endPageNo; // ? ?Ž˜?´ì§? ë§í¬ ë²ˆí˜¸
	private boolean hasPrev; // ?™”ë©´ì— ë³´ì´?Š” ?‹œ?ž‘ ?Ž˜?´ì§? ë²ˆí˜¸ë³´ë‹¤ ?ž‘?? ?ˆ«?ž?˜ ?Ž˜?´ì§?ê°? "?žˆ?Š” ì§? or ?—†?Š” ì§?"
	private boolean hasNext; // ?™”ë©´ì— ë³´ì´?Š” ? ?Ž˜?´ì§? ë²ˆí˜¸ë³´ë‹¤ ?° ?ˆ«?ž?˜ ?Ž˜?´ì§?ê°? ?žˆ?Š” ì§?
	
	public PageMaker() {
		this.numsOfPageLinks = 3; // ?•„?ž˜ 1~10?Ž˜?´ì§? ë²ˆí˜¸ ë§í¬ ?ˆ˜. 3ê°œì”© ë³´ì—¬ì¤?!
	}
	
	public PageCriteria getCriteria() {
		return criteria;
	}
	
	public void setCriteria(PageCriteria criteria) {
		this.criteria = criteria;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getNumsOfPageLinks() {
		return numsOfPageLinks;
	}
	
	public int getStartPageNo() {
		return startPageNo;
	}
	
	public int getEndPageNo() {
		return endPageNo;
	}
	
	public boolean isHasPrev() {
		return hasPrev;
	}
	
	public boolean isHasNext() {
		return hasNext;
	}
	
	// startPageNo, endPageNo, hasPrev, hasNext ê°’ì„ ê³„ì‚° ë°? ?„¸?Œ…
	public void setPageData() {
		int totalLinkNo = (int) Math.ceil((double) totalCount / criteria.getNumsPerPage());
											// ì´? ?Ž˜?´ì§? / ?˜„ ?Ž˜?´ì§? ê°??ˆ˜ = ?•„?ž˜ ?Ž˜?´ì§? ë§í¬ ê°??ˆ˜ (ë°˜ì˜¬ë¦? ?•„?ˆ˜)
		int temp = (int) Math.ceil((double) criteria.getPage() / numsOfPageLinks) * numsOfPageLinks;
											//  ?˜„?ž¬ ?Ž˜?´ì§? / ?Ž˜?´ì§? ë²ˆí˜¸ ë§í¬ ?ˆ˜ = 
		if (temp > totalLinkNo) {
			endPageNo = totalLinkNo;
		} else {
			endPageNo = temp;
		}
		
		startPageNo = ((endPageNo - 1) / numsOfPageLinks) * numsOfPageLinks + 1;
		
		if (startPageNo == 1) {
			hasPrev = false;
		} else {
			hasPrev = true;
		}
		
		if (endPageNo * criteria.getNumsPerPage() >= totalCount) {
			hasNext = false;
		} else {
			hasNext = true;
		}
		// Math.ceil (?˜¬ë¦?)
		// Math.floor (ë²„ë¦¼
		
	}
	
} // end PageMaker
