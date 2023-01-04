package my.mini.project.product.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.java.Log;
import my.mini.project.common.model.vo.PageInfo;
import my.mini.project.common.template.Pagination;
import my.mini.project.product.model.service.ProductService;
import my.mini.project.product.model.vo.Product;

@Log
@Controller
public class ProductController {
	
	@Autowired
	ProductService Productservice;
	
	//상품 판매 페이지 메인
	@RequestMapping("productMain.ui")
	public String productMain(@RequestParam(value="ppage",defaultValue="1") int currentPage, Model model) {
			
		int pageLimit = 9;
		int productLimit = 5;
		
		int listCount = Productservice.selectListCount();
		
		PageInfo pi = Pagination.getPageInfo(listCount, currentPage, pageLimit, productLimit);
		
		ArrayList<Product> list = Productservice.selectAll(pi);
		
		model.addAttribute("list", list);
		
		model.addAttribute("pi", pi);
		
		return "product/productMain";
		
	}
	
	//상품 작성하기 폼
	@RequestMapping("productEnroll.ui")
	public String productEnroll() {
		
		return "product/productInsert";
	}
	
	//상품등록
	@RequestMapping("productInsert.ui")
	public String productInsert(Product p, HttpSession session, Model model ) {

		int result = Productservice.productInsert(p);
		
		if(result>0) {	
			session.setAttribute("alertMsg", "상품 등록완료");
			return "product/productMain";
		}else {		
			model.addAttribute("errorMsg", "상품 등록실패");
			return "redirect/ProductMain";			
		}
		
	}
	
	//상품 등록 내용 페이지
	@RequestMapping("productDetail.ui")
	public String productDetail(int pno, Model model) {
		
		Product p = Productservice.productDetail(pno);
		
		model.addAttribute("p", p);
		
		return "product/productDetail";
		
	}
	
	//상품 수정 페이지
	@RequestMapping("productUpdate.ui")
	public String updateForm(int pno, Model model) {
		
		Product p = Productservice.productDetail(pno);
		
		model.addAttribute("p", p);
		
		return "product/productUpdate";
		
	}
	
	@RequestMapping("update.ui")
	public String update(Product p, HttpSession session, Model model) {
		
		Product pr = new Product();
		
		pr.setProductNo(p.getProductNo());
		pr.setProductName(p.getProductName());
		pr.setProductContent(p.getProductContent());
		
		int result = Productservice.update(pr);
		
		if(result > 0) {
			
			session.setAttribute("alertMsg","상품이 수정되었습니다.");
			return "redirect/ProductMain" + p.getProductNo();
		}
		else {
			
			model.addAttribute("errorMsg", " 수정 실패");
			return "redirect/ProductMain";
		}
	}
	
	//상품 삭제
	@RequestMapping("productDelete.ui")
	public String productDelete(int pno, HttpSession session, Model model) {
		
		int result = Productservice.productDelete(pno);
		
		if(result > 0) {
			
			session.setAttribute("alertMsg","삭제되었습니다.");
			return "product/ProductMain";
		}
		else {
			
			model.addAttribute("errorMsg", "삭제 실패");
			return "product/ProductMain";
		}
	}
	
	//상품구매
	/*https://developers.kakao.com/docs/latest/ko/kakaopay/common 카카오페이 결제 프로세스 참조
	*/
	@RequestMapping("kakao.ui")
	@ResponseBody
	public String productSell() {
		
		try {
			
			URL kakao = new URL("https://kapi.kakao.com/v1/payment/ready"); //웹상주소 URL 선언
			HttpURLConnection hrc = (HttpURLConnection) kakao.openConnection();   //요청하는 클라이언트, 서버연결을 해주는것.
			hrc.setRequestMethod("POST"); //포스트 방식
			hrc.setRequestProperty("Authorization", "KakaoAK 7a96f0ac17cb9603eaa371eb185eef21"); //	내 어드민 주소 7a96f0ac17cb9603eaa371eb185eef21
			hrc.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			hrc.setDoOutput(true); //이 연결을통해 서버에게 전해줄것이 있는지 없는지, 내보낼 것이 있다 그래서 true 이것은 생성될때 input은 자동적으로 true라 인풋 선언 필요없다 하지만 아웃풋은 false기 때문에 true로 선언
			
			String kakaoParameter = "cid=TC0ONETIME&"
					+ "partner_order_id=partner_order_id&"
					+ "partner_user_id=partner_user_id&"
					+ "item_name=초코파이&quantity=1&total_amount=2200&"
					+ "vat_amount=200&tax_free_amount=0&"
					+ "approval_url=http://localhost:8989/project/productSell.ui&"
					+ "fail_url=http://localhost:8989/productSell.ui&"
					+ "cancel_url=http://localhost:8989/productSell.ui";
			
			OutputStream give = hrc.getOutputStream(); //주는애
			DataOutputStream giveData = new DataOutputStream(give);//데이터를 준다
			giveData.writeBytes(kakaoParameter);
			giveData.close();
			
			int result = hrc.getResponseCode(); // 잘됐나 안됐나 그 결과번호를 인트로 받는다
			
			InputStream receive; //받는애
			
			if(result == 200) { //http 코드에서 200은 성공했을때의 코드임.
				receive = hrc.getInputStream();
				
				
			}else {
				receive = hrc.getErrorStream(); //에러 확인은 200 말고 다른거해서 확인해보기.
			}
			//위의 인풋스트림은 받을줄만 알지 읽을 수 없음 그래서 밑에 reader 선언
			InputStreamReader reader = new InputStreamReader(receive); //reader에 inputstream 매개변수 선언
			BufferedReader change = new BufferedReader(reader); //형변환하는애
			System.out.println("카카오톡 페이 넘어와요? 마지막 시스아웃");
			return change.readLine();
			
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		return "product/ProductMain";
	}
	
	
	@ResponseBody
	@RequestMapping("productSell.ui")
	public String productSuccess(@RequestParam("pg_token") String pg_token, Model model) {
		 
		log.info("kakaoPaySuccess get............................................");
	    log.info("kakaoPaySuccess pg_token : " + pg_token);
	   
	    model.addAttribute("info", pg_token);
	     
	     
	     
//		RestTemplate restTemplate = new RestTemplate();
//	       
//	    // 서버로 요청할 Header
//		HttpHeaders headers = new HttpHeaders();
//	    headers.add("Authorization", "KakaoAK " + "7a96f0ac17cb9603eaa371eb185eef21");
//	    headers.add("Accept", MediaType.APPLICATION_JSON_UTF8_VALUE);
//	    headers.add("Content-Type", MediaType.APPLICATION_FORM_URLENCODED_VALUE + ";charset=UTF-8");
//	    
//	    // 서버로 요청할 Body
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
//		
//        params.add("cid", "TC0ONETIME");
//        params.add("tid", kakaoPayReadyVO.getTid());
//        params.add("partner_order_id", "1001");
//        params.add("partner_user_id", "gorany");
//        params.add("pg_token", pg_token);
//        params.add("total_amount", "2100");
//		
//        
//        "cid=TC0ONETIME&"
//		+ "partner_order_id=partner_order_id&"
//		+ "partner_user_id=partner_user_id&"
//		+ "item_name=초코파이&quantity=1&total_amount=2200&"
//		+ "vat_amount=200&tax_free_amount=0&"
//		+ "approval_url=http://localhost:8989/project/productSell.ui&"
//		+ "fail_url=http://localhost:8989/productSell.ui&"
//		+ "cancel_url=http://localhost:8989/productSell.ui";
//        
        return "product/test";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
