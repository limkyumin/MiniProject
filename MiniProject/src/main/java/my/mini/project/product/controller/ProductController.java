package my.mini.project.product.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import lombok.extern.java.Log;
import my.mini.project.common.model.vo.PageInfo;
import my.mini.project.common.template.Pagination;
import my.mini.project.kakao.model.vo.KakaoPayApprovalVO;
import my.mini.project.kakao.model.vo.KakaoPayReadyVO;
import my.mini.project.product.model.service.ProductService;
import my.mini.project.product.model.vo.Product;

@Log
@Controller
public class ProductController {
	
	@Autowired
	ProductService Productservice;
	
	KakaoPayApprovalVO kakaoPayApprovalVO;
	
	KakaoPayReadyVO kakaoPayReadyVO;
	
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
		
		RestTemplate restTemplate = new RestTemplate();
		
		try {
			
			URL kakao = new URL("https://kapi.kakao.com/v1/payment/ready"); //웹상주소 URL 선언
			String abc = "https://kapi.kakao.com/v1/payment/ready";
			HttpURLConnection hrc = (HttpURLConnection) kakao.openConnection();   //요청하는 클라이언트, 서버연결을 해주는것.
			hrc.setRequestMethod("POST"); //포스트 방식
			hrc.setRequestProperty("Authorization", "KakaoAK 7a96f0ac17cb9603eaa371eb185eef21"); //	내 어드민 주소 7a96f0ac17cb9603eaa371eb185eef21
			hrc.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			hrc.setDoOutput(true); //이 연결을통해 서버에게 전해줄것이 있는지 없는지, 내보낼 것이 있다 그래서 true 이것은 생성될때 input은 자동적으로 true라 인풋 선언 필요없다 하지만 아웃풋은 false기 때문에 true로 선언
			
			String kakaoParameter = "cid=TC0ONETIME&"
					+ "partner_order_id=partner_order_id&"
					+ "partner_user_id=partner_user_id&"
					+ "item_name=hi&quantity=1&total_amount=1000&"
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
//			try(BufferedReader br = new BufferedReader(
//					new InputStreamReader(hrc.getInputStream(), "utf-8"))) {
//				StringBuilder response = new StringBuilder();
//				String responseLine = null;
//				while ((responseLine = br.readLine()) != null) {
//					response.append(responseLine.trim());
//				}
//				System.out.println(response.toString());
//			}
			if(result == 200) { //http 코드에서 200은 성공했을때의 코드임.
				receive = hrc.getInputStream();
			}else {
				receive = hrc.getErrorStream(); //에러 확인은 200 말고 다른거해서 확인해보기.
			}
//			kakaoPayReadyVO = restTemplate.postForObject(new URI(abc), kakaoParameter, KakaoPayReadyVO.class);
//			return kakaoPayReadyVO.getNext_redirect_pc_url();
			
			// 읽는 부분
			InputStreamReader read = new InputStreamReader(receive); // 받은걸 읽는다.
			BufferedReader change = new BufferedReader(read); // 바이트를 읽기 위해 형변환 버퍼리더는 실제로 형변환을 위해 존제하는 클레스는 아니다.
			// 받는 부분
			return change.readLine(); // 문자열로 형변환을 알아서 해주고 찍어낸다 그리고 본인은 비워진다.
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RestClientException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	@ResponseBody
	@RequestMapping("productSell.ui")
	public String kakaoPaySuccess(@RequestParam("pg_token") String pg_token,
			@RequestParam("tid") String tid,@RequestParam("next_redirect_pc_url") String next_redirect_pc_url,
			@RequestParam("created_at") Date created_at,
			Model model) {
        log.info("kakaoPaySuccess get............................................");
        log.info("kakaoPaySuccess pg_token : " + pg_token);
        System.out.println("pg_token" + pg_token);
        System.out.println("tid" + tid);
        System.out.println("next_redirect_pc_url" + next_redirect_pc_url);
        System.out.println("created_at" + created_at);

        model.addAttribute("pg_token", pg_token);
        
		
        return null;
	}

	    
}
	
	
	