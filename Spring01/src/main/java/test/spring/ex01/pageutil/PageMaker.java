package test.spring.ex01.pageutil;

// ??΄μ§? λ²νΈ?€? λ§ν¬λ₯? λ§λ€κΈ? ?? ? ?Έλ¦¬ν° ?΄??€
public class PageMaker {
	private PageCriteria criteria; // criteria κΈ°μ??΄?? ?»
	private int totalCount; // ? μ²? κ²μκΈ? κ°μ
	private int numsOfPageLinks; // ??΄μ§? λ²νΈ λ§ν¬? κ°μ
	private int startPageNo; // ?? ??΄μ§? λ§ν¬ λ²νΈ
	private int endPageNo; // ? ??΄μ§? λ§ν¬ λ²νΈ
	private boolean hasPrev; // ?λ©΄μ λ³΄μ΄? ?? ??΄μ§? λ²νΈλ³΄λ€ ??? ?«?? ??΄μ§?κ°? "?? μ§? or ?? μ§?"
	private boolean hasNext; // ?λ©΄μ λ³΄μ΄? ? ??΄μ§? λ²νΈλ³΄λ€ ?° ?«?? ??΄μ§?κ°? ?? μ§?
	
	public PageMaker() {
		this.numsOfPageLinks = 3; // ?? 1~10??΄μ§? λ²νΈ λ§ν¬ ?. 3κ°μ© λ³΄μ¬μ€?!
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
	
	// startPageNo, endPageNo, hasPrev, hasNext κ°μ κ³μ° λ°? ?Έ?
	public void setPageData() {
		int totalLinkNo = (int) Math.ceil((double) totalCount / criteria.getNumsPerPage());
											// μ΄? ??΄μ§? / ? ??΄μ§? κ°?? = ?? ??΄μ§? λ§ν¬ κ°?? (λ°μ¬λ¦? ??)
		int temp = (int) Math.ceil((double) criteria.getPage() / numsOfPageLinks) * numsOfPageLinks;
											//  ??¬ ??΄μ§? / ??΄μ§? λ²νΈ λ§ν¬ ? = 
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
		// Math.ceil (?¬λ¦?)
		// Math.floor (λ²λ¦Ό
		
	}
	
} // end PageMaker
