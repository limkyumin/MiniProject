package my.mini.project.common.model.vo;

public class PageInfo {
	
	private int listCount; 		//현재 총 게시글 개수
	private int currentPage;	//현재 페이지 (사용자가 요청한 페이지)
	private int pageLimit;		//페이지 하단에 보이는 페이지 최대 개수
	private int pageCount;		//한 페이지에서 보여질 게시글 개수
	
	private int maxPage;		//가장 마지막 페이지가 몇 번 페이지인지(총 페이지 수)
	private int startPage;		//페이지 하단에 보여질 페이징 시작 수
	private int endPage;		//페이지 하단에 보여질 페이징 끝 수
	
	
	//VO 생성 알트+쉬프트+S
	
	public PageInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageInfo(int listCount, int currentPage, int pageLimit, int pageCount, int maxPage, int startPage,
			int endPage) {
		super();
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.pageCount = pageCount;
		this.maxPage = maxPage;
		this.startPage = startPage;
		this.endPage = endPage;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	@Override
	public String toString() {
		return "PageInfo [listCount=" + listCount + ", currentPage=" + currentPage + ", pageLimit=" + pageLimit
				+ ", pageCount=" + pageCount + ", maxPage=" + maxPage + ", startPage=" + startPage + ", endPage="
				+ endPage + "]";
	}
	
}
