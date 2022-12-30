package my.mini.project.user.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	//회원가입 페이지
	@RequestMapping("userEnroll.me")
	public String userEnroll() {
		
		return "user/userEnrollPage";
	}
	
	//회원가입
	@RequestMapping("insert.me")
	public String insertUser(User u,HttpSession session,Model model) {
		
		String encPwd = bcryptPasswordEncoder.encode(u.getUserPwd());
		
		u.setUserPwd(encPwd);
		//암호화 된 pwd를 User u에 담아주기(평문과 바꿔치기)
		int result = userService.insertUser(u);
		
		if(result>0) {
			session.setAttribute("alertMsg", "회원가입이 완료되었습니다");
			return "redirect:/";
		}else {
			model.addAttribute("errorMsg", "회원가입이 실패되었습니다");
			return "redirect:/";
		}
	}
	
	//회원가입 - 아이디 중복체크
	@RequestMapping(value="idCheck.ui", produces="text/html; charset=UTF-8")
	@ResponseBody
	public void idCheck(Model model, HttpServletResponse response, String checkId) throws IOException {
		
		int count = userService.idCheck(checkId);
		
		if(count>0) {
			response.getWriter().print("NNNNN");
		}else {
			response.getWriter().print("NNNNY");
		}
	}
	
	//로그인 홈페이지 이동
	@RequestMapping("loginPage.ui")
	public String loginPage() {
		
		return "user/loginPage";
	}
	
	
	//로그인
	@RequestMapping("loginuser.ui")
	public ModelAndView loginUser(User u,HttpSession session,ModelAndView mv) {
		
		User loginUser = userService.loginUser(u);
		
		if(loginUser!=null && bcryptPasswordEncoder.matches(u.getUserPwd(), loginUser.getUserPwd())) {
			session.setAttribute("alertMsg", loginUser.getUserName()+"님 안녕하세요!");
			session.setAttribute("loginUser", loginUser);				
			mv.setViewName("redirect:/");	

		}else {
			session.setAttribute("alertMsg", "아이디와 비밀번호를 확인해주세요");
			mv.setViewName("user/login");
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
	
	//마이페이지 -> 회원정보수정
	@RequestMapping("update.me")
	public String updateUser(User u,HttpSession session, Model model) {
		
		String encPwd = bcryptPasswordEncoder.encode(u.getUserPwd());
		u.setUserPwd(encPwd);
		
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
	
	//회원탈퇴
	@RequestMapping("delete.ui")
	public String deleteUser(String userPwd,HttpSession session, Model model) {
		
		String userId = ((User)session.getAttribute("loginUser")).getUserId();
		String encPwd = ((User)session.getAttribute("loginUser")).getUserPwd();
		
		if(bcryptPasswordEncoder.matches(userPwd, encPwd)) {
			//비번 일치할 경우 ㅡ 탈퇴처리
			
			int result = userService.deleteUser(userId);
			
			if(result>0) {
				
				session.removeAttribute("loginUser");
				
				session.setAttribute("alertMsg", "회원 탈퇴성공");
				
				return "redirect:/";
			}else {
				//탈퇴실패
				model.addAttribute("alertMsg", "탈퇴 실패");
			
				return "redirect:/";
			}
		}else {
			
			session.setAttribute("alertMsg", "비밀번호를 잘못입력하셨습니다 ");
			
			return "redirect:/myPage.me";
		}
	}
}
