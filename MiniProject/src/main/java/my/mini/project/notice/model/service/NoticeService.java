package my.mini.project.notice.model.service;

import java.util.ArrayList;

import my.mini.project.common.model.vo.PageInfo;
import my.mini.project.notice.model.vo.Notice;

public interface NoticeService {
	
	//게시글 전체보기
	int selectListCount();
	
	//페이징처리
	ArrayList<Notice> selectAll(PageInfo pi);
	
	//공지사항 작성
	int noticeInsert(Notice n);

	//조회수 증가
	int viewCount(int vct);

	//공지사항 내용보기
	Notice noticeDetail(int vct);
	
	//글 내용 수정하기
	int updateNotice(Notice n);

	//글 삭제하기
	int noticeDelete(int vct);
	
	

	
	

}
