package test.spring.ex01.pageutil;

// 브라?��???��?�� 보여�? ?��?���? 번호??
// ?�� ?��?���??��?�� 보여�? 게시�??�� 개수�? ???��?��?�� ?��?��?��
// -> paging 처리?�� ?��?��?�� start?? end 번호�? ?�� ?�� ?��?��
public class PageCriteria {
	private int page; // ?��?�� ?��?���? 번호
	private int numsPerPage; // ?�� ?��?���??�� 게시�? 개수
	
	public PageCriteria() {
		this.page = 1; // 1 ?��?���? ?��?��.
		this.numsPerPage = 5; // bno 5�? ?��?���? 보여�?.
	} // 기초값을 1?��?���? 5개로 ?��?��?�� ?��?��?��?��. ?��?��?�� ?��?�� :) 
	
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
	
	// ?��?�� 보여�??�� ?��?���??�� ?��?�� �? ?��?��번호(rn)
	public int getStart() {
		return (this.page - 1) * this.numsPerPage + 1;
	} // page ?��?�� ?��?���? 번호, numsPerPage 게시�? �??�� 
	
	// ?��?�� 보여�??�� ?��?���??�� 마�?�? �? ?��?��번호(rn)
	public int getEnd() {
		return this.page * this.numsPerPage;
	}
	
	
} // end PageCriteria
