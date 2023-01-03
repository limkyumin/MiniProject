package my.mini.project.kakao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Setter;
import lombok.extern.java.Log;
import my.mini.project.kakao.model.service.KakaoPay;

@Log
@Controller
public class SampleController {
	
		@Autowired
		private KakaoPay kakaopay;
		
//		@RequestMapping("kakaoPay.ui", method = RequestMethod.GET)
//		public String kakaoPay(HttpServletRequest request, HttpSession session) throws Exception{
//			
//			System.out.println("1111111");
//			
//			return "redirect:" + kakaopay.KakaoPayReady();
//		}
//		
//		@RequestMapping("kakaoPay.ui")
//		public String kakaoPay(HttpServletRequest request, HttpSession session) throws Exception{
//			
//			System.out.println("1111111");
//			
//			return "redirect:" + kakaopay.KakaoPayReady();
//		}
   
	    //@Setter(onMethod_ = @Autowired)
	    //private KakaoPay kakaopay;
	    
	    
	    //@GetMapping("/kakaoPay")
	    //public void kakaoPayGet() {
		//}
	    
	    //@PostMapping("/kakaoPay")
	    //public String kakaoPay() {
	    //    log.info("kakaoPay post............................................");
	        
	    //    return "redirect:" + kakaopay.KakaoPayReady();
	    //}
	    
	    //@GetMapping("/kakaoPaySuccess")
	    //public void kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
	        //log.info("kakaoPaySuccess get............................................");
	        //log.info("kakaoPaySuccess pg_token : " + pg_token);
	        
	        //model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token));
	        
	    //}
	    
}

