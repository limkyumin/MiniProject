package my.mini.project.common.template;

import my.mini.project.common.model.vo.PageInfo;

public class Pagination {

	public static PageInfo getPageInfo(int listCount,int currentPage, int pageLimit, int pageCount) {
		
		int maxPage = (int)Math.ceil((double)listCount/pageCount);
		if(listCount == 0) {
			maxPage = 1;
		}
		int startPage = (currentPage-1) / pageLimit * pageLimit + 1;
		int endPage = startPage+pageLimit -1 ;
		
		if(endPage>maxPage) {
			endPage=maxPage;
		}
		
		return new PageInfo(listCount,currentPage,pageLimit,pageCount,maxPage,startPage,endPage);
		
		
	}
	
}
