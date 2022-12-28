package my.mini.project.notice.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import my.mini.project.common.model.vo.PageInfo;
import my.mini.project.common.template.Pagination;
import my.mini.project.notice.model.service.NoticeService;
import my.mini.project.notice.model.vo.Notice;

@Controller
public class NoticeController {

	@Autowired
	NoticeService Noticeservice;
	
	//공지사항 메인 페이지 페이징 처리 + 전체게시글 보기
	@RequestMapping("noticeMain.ui")
	public String noticeMain(@RequestParam(value = "npage",defaultValue="1") int currentPage, Model model) {
		
		int pageLimit = 10;
		int noticeLimit = 10;
		
		int listCount = Noticeservice.selectListCount();
		
		PageInfo pi = Pagination.getPageInfo(listCount, currentPage, pageLimit, noticeLimit);
		
		ArrayList<Notice> list = Noticeservice.selectAll(pi);
		
		model.addAttribute("list", list);
		
		model.addAttribute("pi", pi);
		
		return "notice/noticeMain";
		
	}
	
	//공지사항 글 작성 폼
	@RequestMapping("noticeInsertForm.ui")
	public String noticeInsertForm() {
		
		return "notice/noticeInsert";
	}
	
	//공지사항 글 작성
	@RequestMapping("noticeInsert.ui")
	public String noticeInsert(Notice n, HttpSession session, Model model) {
		
		int result = Noticeservice.noticeInsert(n);
		
		if(result > 0) {
			
			session.setAttribute("alertMsg","공지사항이 등록되었습니다.");
			return "redirect:noticeMain.ui";
		}
		else {
			
			model.addAttribute("errorMsg", "공지사항 등록 실패");
			return "notice/noticeMain";
		}
	}
	
	//공지사항 글 내용 + 조회수
	@RequestMapping("noticeDetail.ui")
	public String noticeDetail(int vct, Model model) {
		
		//조회수
		int result = Noticeservice.viewCount(vct);
	
		if(result>0) {
			
			Notice n = Noticeservice.noticeDetail(vct);
			
			model.addAttribute("n", n);
			return "notice/noticeDetail";
			
		}else {
			
			model.addAttribute("errorMsg", "상세보기 실패");
			return "notice/noticeMain";
		}
	}
	
	//글 수정 화면
	@RequestMapping("updateForm.ui")
	public String updateForm(int vct, HttpSession session, Model model) {
		
		Notice n = Noticeservice.noticeDetail(vct);
		
		model.addAttribute("n", n);
		
		return "notice/noticeUpdate";
	}
	
	//글 수정 하기
	@RequestMapping("updateNotice.ui")
	public String updateNotice(Notice n, HttpSession session, Model model) {
		
		int result = Noticeservice.updateNotice(n);
		
		if(result > 0) {
			
			session.setAttribute("alertMsg","공지사항이 수정되었습니다.");
			
			System.out.println("공지사항 수정 찍히냐 ");
			return "redirect:noticeMain.ui?currentPage=" + n.getNoticeNo();
		}
		else {
			
			model.addAttribute("errorMsg", "공지사항 수정 실패");
			return "notice/noticeMain";
		}
	}
	
	//글 삭제하기
	@RequestMapping("noticeDelete.ui")
	public String noticeDelete(int vct, HttpSession session, Model model) {
		
		int result = Noticeservice.noticeDelete(vct);
		
		if(result > 0) {
			
			session.setAttribute("alertMsg","공지사항이 삭제되었습니다.");
			return "redirect:noticeMain.ui?currentPage=";
		}
		else {
			
			model.addAttribute("errorMsg", "공지사항 삭제 실패");
			return "notice/noticeMain";
		}
	}
	
	
}
