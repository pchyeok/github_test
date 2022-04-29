package test.spring.ex01.pageutil;

// ?��?���? 번호?��?�� 링크�? 만들�? ?��?�� ?��?��리티 ?��?��?��
public class PageMaker {
	private PageCriteria criteria; // criteria 기�??��?? ?��
	private int totalCount; // ?���? 게시�? 개수
	private int numsOfPageLinks; // ?��?���? 번호 링크?�� 개수
	private int startPageNo; // ?��?�� ?��?���? 링크 번호
	private int endPageNo; // ?�� ?��?���? 링크 번호
	private boolean hasPrev; // ?��면에 보이?�� ?��?�� ?��?���? 번호보다 ?��?? ?��?��?�� ?��?���?�? "?��?�� �? or ?��?�� �?"
	private boolean hasNext; // ?��면에 보이?�� ?�� ?��?���? 번호보다 ?�� ?��?��?�� ?��?���?�? ?��?�� �?
	
	public PageMaker() {
		this.numsOfPageLinks = 3; // ?��?�� 1~10?��?���? 번호 링크 ?��. 3개씩 보여�?!
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
	
	// startPageNo, endPageNo, hasPrev, hasNext 값을 계산 �? ?��?��
	public void setPageData() {
		int totalLinkNo = (int) Math.ceil((double) totalCount / criteria.getNumsPerPage());
											// �? ?��?���? / ?�� ?��?���? �??�� = ?��?�� ?��?���? 링크 �??�� (반올�? ?��?��)
		int temp = (int) Math.ceil((double) criteria.getPage() / numsOfPageLinks) * numsOfPageLinks;
											//  ?��?�� ?��?���? / ?��?���? 번호 링크 ?�� = 
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
		// Math.ceil (?���?)
		// Math.floor (버림
		
	}
	
} // end PageMaker
