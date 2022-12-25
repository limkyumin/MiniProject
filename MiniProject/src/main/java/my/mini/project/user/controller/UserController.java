package my.mini.project.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import my.mini.project.user.model.service.UserService;
import my.mini.project.user.model.vo.User;

@Controller
//Controller 타입의 어노테이션을 붙여주면 빈 스캐너가 자동으로 빈 등록해줌

public class UserController {
	
	//private MemberService memberService = new MemberServiceImpl();
		/*
		 * 기존 객체 생성 방식
		 * 서비스가 동시에 많은 회수가 요청되면 그만큼 객체가 생성된다
		 * 객체간의 결합도가 높아진다 (소스코드의 수정이 일어날경우 해당코드를 작성한곳에 전부 수정이 이루어져야한다)
		 * Spring의 DI(Dependency injection) 객체를 생성해서 주입해준다.
		 * 
		 * new 연산자를 쓰지않고 선언만해도 되지만 @Autowired 어노테이션을 작성해줘야한다.
		 * 
		 * */
	
	@Autowired
	private UserService userService;
	
	//회원가입 페이지
	@RequestMapping("userEnroll.me")
	public String userEnroll() {
		
		return "user/userEnrollPage";
	}
	
	//회원가입
	@RequestMapping("insert.me")
	public String insertUser(User u,HttpSession session,Model model) {
		
		int result = userService.insertUser(u);
		
		if(result>0) {
			session.setAttribute("alertMsg", "회원가입이 완료되었습니다");
			return "redirect:/";
		}else {
			model.addAttribute("errorMsg", "회원가입이 실패되었습니다");
			return "redirect:/";
		}
	}
	
	//로그인
	@RequestMapping("loginuser.ui")
	public ModelAndView loginUser(User u,HttpSession session,ModelAndView mv) {
		
		User loginUser = userService.loginUser(u);
		
		if(loginUser!=null) {
			session.setAttribute("loginUser", loginUser);
			mv.setViewName("redirect:/");			
		}else {
			mv.addObject("alertMsg", "로그인에 실패하였습니다");
			mv.setViewName("redirect:/");
		}
		
		return mv;
	}
	
	//로그아웃
	@RequestMapping("logout.me")
	public String logoutUser(HttpSession session) {
		
		session.removeAttribute("loginUser");
		
		return "redirect:/";
	}
	
	//마이페이지 ui
	@RequestMapping("myPage.me")
	public String myPage() {
			
		return "user/myPage";
	}
	
	//마이페이지
	@RequestMapping("update.me")
	public String updateUser(User u,HttpSession session, Model model) {
		
		int result = userService.updateUser(u);
		
		if(result>0) {
			User updateUser = userService.loginUser(u);
			session.setAttribute("loginUser", updateUser);
			session.setAttribute("alertMsg", "회원정보 수정완료");
			return "redirect:/";
		}else {
			model.addAttribute("errorMsg", "회원정보 수정실패");
			
			return "redirect:myPage.me";
		}
		
		
		
	}
}
