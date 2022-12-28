package my.mini.project.notice.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import my.mini.project.common.model.vo.PageInfo;
import my.mini.project.notice.model.vo.Notice;

@Repository
public class NoticeDao {
	
	//전체 글
	public static int selectListCount(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectOne("noticeMapper.selectListCount");
	}

	//페이징 처리
	public static ArrayList<Notice> selectAll(SqlSessionTemplate sqlSession, PageInfo pi) {
		
		int offset = (pi.getCurrentPage()-1)*pi.getPageCount();
		int limit = pi.getPageCount();
		
		RowBounds rowBounds = new RowBounds(offset,limit);
		
		return (ArrayList)sqlSession.selectList("noticeMapper.selectAll", null, rowBounds);
	}

	//글 작성
	public static int noticeInsert(SqlSessionTemplate sqlSession, Notice n) {
		
		return sqlSession.insert("noticeMapper.noticeInsert", n);
	}

	//조회수 증가
	public static int viewCount(SqlSessionTemplate sqlSession, int noticeNo) {
		
		return sqlSession.update("noticeMapper.viewCount", noticeNo);
	}
	
	//글 내용
	public static Notice noticeDetail(SqlSessionTemplate sqlSession, int noticeNo) {
		
		return sqlSession.selectOne("noticeMapper.noticeDetail", noticeNo);
	}

	//글 수정
	public static int updateNotice(SqlSessionTemplate sqlSession, Notice n) {
		
		return sqlSession.update("noticeMapper.updateNotice", n);
	}
	
	//글 삭제
	public static int noticeDelete(SqlSessionTemplate sqlSession, int noticeNo) {
		
		return sqlSession.update("noticeMapper.noticeDelete", noticeNo);
	}



}
