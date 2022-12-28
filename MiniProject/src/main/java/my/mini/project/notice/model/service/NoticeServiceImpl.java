package my.mini.project.notice.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.mini.project.common.model.vo.PageInfo;
import my.mini.project.notice.model.dao.NoticeDao;
import my.mini.project.notice.model.vo.Notice;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeDao Noticedao;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//전체 게시글
	@Override
	public int selectListCount() {
		
		return NoticeDao.selectListCount(sqlSession);
	}
	
	//페이징 처리
	@Override
	public ArrayList<Notice> selectAll(PageInfo pi) {
		
		return NoticeDao.selectAll(sqlSession, pi);
	}
	
	//공지사항 작성
	@Override
	public int noticeInsert(Notice n) {
		
		return NoticeDao.noticeInsert(sqlSession, n);
	}
	
	//조회수 증가
	@Override
	public int viewCount(int noticeNo) {
		
		return NoticeDao.viewCount(sqlSession, noticeNo);
	}
	
	//공지사항 글 내용
	@Override
	public Notice noticeDetail(int noticeNo) {
		
		return NoticeDao.noticeDetail(sqlSession, noticeNo);
	}
	
	//글 내용 수정하기
	@Override
	public int updateNotice(Notice n) {
		
		return NoticeDao.updateNotice(sqlSession, n);
	}
	
	//글 삭제하기
	@Override
	public int noticeDelete(int noticeNo) {
		
		return NoticeDao.noticeDelete(sqlSession, noticeNo);
	}
	
	
	
	


	
}
