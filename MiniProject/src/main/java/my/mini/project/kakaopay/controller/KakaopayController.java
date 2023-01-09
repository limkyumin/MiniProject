//package my.mini.project.kakaopay.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//import lombok.extern.slf4j.Slf4j;
//import my.mini.project.kakaopay.model.service.KakaoPayService;
//import my.mini.project.kakaopay.model.vo.ApproveResponse;
//import my.mini.project.kakaopay.model.vo.ReadyResponse;
//
//@Slf4j
//@Controller
//@SessionAttributes({"tid","order"}) 
//public class KakaopayController {
//	
//	@Autowired
//	KakaoPayService kakaoService;
//	
//	// 카카오페이결제 요청
//	@GetMapping("kakao.ui")
//	public @ResponseBody ReadyResponse payReady(@RequestParam(name = "total_amount") int totalAmount, Order order, Model model) {
//		
//		log.info("주문정보:"+order);
//		log.info("주문가격:"+totalAmount);
//		// 카카오 결제 준비하기	- 결제요청 service 실행.
//		ReadyResponse readyResponse = kakaoService.payReady(totalAmount);
//		// 요청처리후 받아온 결재고유 번호(tid)를 모델에 저장
//		model.addAttribute("tid", readyResponse.getTid());
//		log.info("결재고유 번호: " + readyResponse.getTid());		
//		// Order정보를 모델에 저장
//		model.addAttribute("order",order);
//		
//		return readyResponse; // 클라이언트에 보냄.(tid,next_redirect_pc_url이 담겨있음.)
//	}
//	
//	// 결제승인요청
//		@GetMapping("/order/pay/completed")
//		public String payCompleted(@RequestParam("pg_token") String pgToken, @ModelAttribute("tid") String tid, @ModelAttribute("order") Order order,  Model model) {
//			
//			log.info("결제승인 요청을 인증하는 토큰: " + pgToken);
//			log.info("주문정보: " + order);		
//			log.info("결재고유 번호: " + tid);
//			
//			// 카카오 결재 요청하기
//			ApproveResponse approveResponse = kakaoService.payApprove(tid, pgToken);	
//			
//			
//			return "redirect:/orders";
//		}
//}
