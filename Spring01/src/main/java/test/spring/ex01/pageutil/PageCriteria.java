package test.spring.ex01.pageutil;

// λΈλΌ?°???? λ³΄μ¬μ§? ??΄μ§? λ²νΈ??
// ? ??΄μ§??? λ³΄μ¬μ§? κ²μκΈ?? κ°μλ₯? ???₯?? ?΄??€
// -> paging μ²λ¦¬? ??? start?? end λ²νΈλ₯? ? ? ??
public class PageCriteria {
	private int page; // ??¬ ??΄μ§? λ²νΈ
	private int numsPerPage; // ? ??΄μ§?? κ²μκΈ? κ°μ
	
	public PageCriteria() {
		this.page = 1; // 1 ??΄μ§? ??.
		this.numsPerPage = 5; // bno 5κ°? ??Όλ‘? λ³΄μ¬μ€?.
	} // κΈ°μ΄κ°μ 1??΄μ§? 5κ°λ‘ ?€? ? ?΄???. ??΄?Έ ?€?  :) 
	
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
	
	// ??¬ λ³΄μ¬μ§?? ??΄μ§?? ?? κΈ? ?Ό? ¨λ²νΈ(rn)
	public int getStart() {
		return (this.page - 1) * this.numsPerPage + 1;
	} // page ??¬ ??΄μ§? λ²νΈ, numsPerPage κ²μκΈ? κ°?? 
	
	// ??¬ λ³΄μ¬μ§?? ??΄μ§?? λ§μ?λ§? κΈ? ?Ό? ¨λ²νΈ(rn)
	public int getEnd() {
		return this.page * this.numsPerPage;
	}
	
	
} // end PageCriteria
