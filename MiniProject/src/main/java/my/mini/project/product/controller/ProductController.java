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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.java.Log;
import my.mini.project.common.model.vo.PageInfo;
import my.mini.project.common.template.Pagination;
import my.mini.project.product.model.service.OrderService;
import my.mini.project.product.model.service.ProductService;
import my.mini.project.product.model.vo.Order;
import my.mini.project.product.model.vo.Product;

@Log
@Controller
public class ProductController {
	
//	//Java에서는 Date 클래스와 String 클래스 사이에 파싱을 도와주는 SimpleDateFormat 클래스
//	// 현재 시간을 Date 객체로 가져옴
//	Date date = new Date();		
//	// SimpleDateFormat 객체 생성
//	String datePattern = "yyyyMMddHHmmss";
//	SimpleDateFormat format = new SimpleDateFormat(datePattern);
//	// 문자열로 변환
//	String dateStr = format.format(date);
//	
//	String orderNo = "" + dateStr;
	
	@Autowired
	ProductService Productservice;
	
	@Autowired
	OrderService orderService;
	

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
	@RequestMapping("kakao")
	@ResponseBody
	public String productSell() {
		
		//Java에서는 Date 클래스와 String 클래스 사이에 파싱을 도와주는 SimpleDateFormat 클래스
		// 현재 시간을 Date 객체로 가져옴
		Date date = new Date();		
		// SimpleDateFormat 객체 생성
		String datePattern = "yyyyMMddHHmmss";
		SimpleDateFormat format = new SimpleDateFormat(datePattern);
		// 문자열로 변환
		String dateStr = format.format(date);
		
		String orderNo = "" + dateStr;
		
		/*step 1)주문번호를 체번한다. //위에 dateStr로 주문번호 날짜로 생성하는거 완료 > 전역변수 세팅은 변하지 않는값만 > 그래서 컨트롤러에 선언
		*/
		//주문번호에 대한 객체생성
//		String orderNo = "1"; 맨 위 컨트롤러 및 전역변수로 선언해봄. db에 똑같이 저장됨
		
		try {
			//step 2)카카오에 결제모듈을 띄울 때 주문번호 객체 + "정보" 같이 보내준다
			URL kakao = new URL("https://kapi.kakao.com/v1/payment/ready"); //웹상주소 URL 선언
			HttpURLConnection hrc = (HttpURLConnection) kakao.openConnection();   //요청하는 클라이언트, 서버연결을 해주는것.
			hrc.setRequestMethod("POST"); //포스트 방식
			hrc.setRequestProperty("Authorization", "KakaoAK 7a96f0ac17cb9603eaa371eb185eef21"); //	내 어드민 주소 7a96f0ac17cb9603eaa371eb185eef21
			hrc.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			hrc.setDoOutput(true); //이 연결을통해 서버에게 전해줄것이 있는지 없는지, 내보낼 것이 있다 그래서 true 이것은 생성될때 input은 자동적으로 true라 인풋 선언 필요없다 하지만 아웃풋은 false기 때문에 true로 선언
			
			String kakaoParameter = "cid=TC0ONETIME&" 		//가맹점 코드
					+ "partner_order_id=" + orderNo + "&" 	//가맹점 주문번호
					+ "partner_user_id=partner_user_id&" 	//가맹점 회원 아이디
					+ "item_name=hi&"						//상품명
					+ "quantity=1&"							//수량
					+ "total_amount=1000&"					//가격
					+ "vat_amount=200&"						//부가세
					+ "tax_free_amount=0&"					//상품 비과세
//					+ "approval_url=http://localhost:8989/project/" + orderNo + "/productMain.ui&"	//결제 성공시
					+ "approval_url=http://localhost:8989/project/productMain.ui&"
					+ "fail_url=http://localhost:8989/productSell.ui&"				//결제 실패시
					+ "cancel_url=http://localhost:8989/productSell.ui";			//결제 취소시
			
			OutputStream give = hrc.getOutputStream(); //주는애
			DataOutputStream giveData = new DataOutputStream(give);//데이터를 준다
			giveData.writeBytes(kakaoParameter); // OutputStream은 데이터를 바이트 형식으로 주고 받기로 약속되어 있다. (형변환)
			giveData.close(); // flush가 자동으로 호출이 되고 닫는다. (보내고 비우고 닫다)
					
			int result = hrc.getResponseCode(); // 잘됐나 안됐나 그 결과번호를 인트로 받는다
			InputStream receive; //받는애
			
			if(result == 200) { //http 코드에서 200은 성공했을때의 코드임.
				receive = hrc.getInputStream();
			}else {
				receive = hrc.getErrorStream(); //에러 확인은 200 말고 다른거해서 확인해보기.
			}
		
			// 읽는 부분
			InputStreamReader read = new InputStreamReader(receive); // 받은걸 읽는다.
			BufferedReader change = new BufferedReader(read); // 바이트를 읽기 위해 형변환 버퍼리더는 실제로 형변환을 위해 존제하는 클레스는 아니다.
			// 받는 부분
			
			/*step 3 
				주문번호 객체(orderNo)를 카카오에 보내고
				tid, next_redirect_pc_url를 받아온다.
				
				String으로 받아왔기에 값 하나하나 꺼내주려면 json형태로 형변환을 해줘야한다
				(json형태로 꺼내온 것을 다시 toString으로 문자열 형변환을 해줌)
				
			*/
			String input = change.readLine(); 
			//{"tid":"T3bea397003e7c9849e0","tms_result":false,"next_redirect_app_url":"https://online-pay.kakao.com/mockup/v1/6d418c9ce35792cff7b4c6708fb83d2921e0622142b13112250a3f030022012b/aInfo","next_redirect_mobile_url":"https://online-pay.kakao.com/mockup/v1/6d418c9ce35792cff7b4c6708fb83d2921e0622142b13112250a3f030022012b/mInfo","next_redirect_pc_url":"https://online-pay.kakao.com/mockup/v1/6d418c9ce35792cff7b4c6708fb83d2921e0622142b13112250a3f030022012b/info","android_app_scheme":"kakaotalk://kakaopay/pg?url=https://online-pay.kakao.com/pay/mockup/6d418c9ce35792cff7b4c6708fb83d2921e0622142b13112250a3f030022012b","ios_app_scheme":"kakaotalk://kakaopay/pg?url=https://online-pay.kakao.com/pay/mockup/6d418c9ce35792cff7b4c6708fb83d2921e0622142b13112250a3f030022012b","created_at":"2023-01-11T20:55:03"}
			
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(input); 
			//json 형태로 형변환
			
			System.out.println(jsonObject.get("tid"));
			//T3be99db003e7c98479f
			System.out.println(jsonObject.get("next_redirect_pc_url"));
			//https://online-pay.kakao.com/mockup/v1/0d0fb429e6ca136cfbfeccf44b67a4a8f998437e5a3eb00bc0abb630b2a975c9/info
			
			System.out.println("dateStr"+dateStr);
			
			/*step 4
				ORDER_TEST(임시테이블)에  orderNo, tid 를 저장한다
			*/
			Order o = new Order();
			o.setPartner_order_id(orderNo);
			o.setTid(jsonObject.get("tid").toString());
			
			//저장할 service 선언
			int order = orderService.insertOrderTemp(o);
			
			//리턴할 url을 json형태로 꺼내온 뒤 tostring 형변환
			//view datatype : text
			return (jsonObject.get("next_redirect_pc_url").toString()); 
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	
    //http://localhost:8989/project/20230113151836/productSell.ui?pg_token=adcdaf8fb1b4e6ab9d39
	//TID/매핑주소?PG토큰
	@ResponseBody
	@RequestMapping("{partner_order_id}/productMain.ui")
	public String kakaoPaySuccess(
			@RequestParam("pg_token") String pg_token,
			@PathVariable("partner_order_id") String partner_order_id,
//			@PathVariable("tid") String tid,
			Model model) {
        
        //step 5.
        //DB에서 tid 를 꺼내와야 한다(select)
        
        String selectTid = orderService.selectTid(partner_order_id);
       
        
        //step 6.
        //카카오에 tid,token을 결제승인 api 요청
        
		try {
			URL kakao = new URL("https://kapi.kakao.com/v1/payment/approve");
			HttpURLConnection hrc = (HttpURLConnection) kakao.openConnection();   //요청하는 클라이언트, 서버연결을 해주는것.
			hrc.setRequestMethod("POST"); //포스트 방식
			hrc.setRequestProperty("Authorization", "KakaoAK 7a96f0ac17cb9603eaa371eb185eef21"); //	내 어드민 주소 7a96f0ac17cb9603eaa371eb185eef21
			hrc.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			hrc.setDoOutput(true); //이 연결을통해 서버에게 전해줄것이 있는지 없는지, 내보낼 것이 있다 그래서 true 이것은 생성될때 input은 자동적으로 true라 인풋 선언 필요없다 하지만 아웃풋은 false기 때문에 true로 선언
			
			String kakaoParameter = "cid=TC0ONETIME&" 		//가맹점 코드
					+ "tid=" + selectTid + "&"
					+ "partner_order_id=" + partner_order_id + "&" 	//가맹점 주문번호
					+ "partner_user_id=partner_user_id&" 	//가맹점 회원 아이디
					+ "pg_token=" + pg_token + "&";
			
			OutputStream give = hrc.getOutputStream(); //주는애
			DataOutputStream giveData = new DataOutputStream(give);//데이터를 준다
			giveData.writeBytes(kakaoParameter); // OutputStream은 데이터를 바이트 형식으로 주고 받기로 약속되어 있다. (형변환)
			giveData.close(); // flush가 자동으로 호출이 되고 닫는다. (보내고 비우고 닫다)
					
			int result = hrc.getResponseCode(); // 잘됐나 안됐나 그 결과번호를 인트로 받는다
			InputStream receive; //받는애
			
			if(result == 200) { //http 코드에서 200은 성공했을때의 코드임.
				receive = hrc.getInputStream();
			}else {
				receive = hrc.getErrorStream(); //에러 확인은 200 말고 다른거해서 확인해보기.
			}
		
			// 읽는 부분
			InputStreamReader read = new InputStreamReader(receive); // 받은걸 읽는다.
			BufferedReader change = new BufferedReader(read); // 바이트를 읽기 위해 형변환 버퍼리더는 실제로 형변환을 위해 존제하는 클레스는 아니다.
			// 받는 부분
			
			String input = change.readLine(); 
			//{"tid":"T3bea397003e7c9849e0","tms_result":false,"next_redirect_app_url":"https://online-pay.kakao.com/mockup/v1/6d418c9ce35792cff7b4c6708fb83d2921e0622142b13112250a3f030022012b/aInfo","next_redirect_mobile_url":"https://online-pay.kakao.com/mockup/v1/6d418c9ce35792cff7b4c6708fb83d2921e0622142b13112250a3f030022012b/mInfo","next_redirect_pc_url":"https://online-pay.kakao.com/mockup/v1/6d418c9ce35792cff7b4c6708fb83d2921e0622142b13112250a3f030022012b/info","android_app_scheme":"kakaotalk://kakaopay/pg?url=https://online-pay.kakao.com/pay/mockup/6d418c9ce35792cff7b4c6708fb83d2921e0622142b13112250a3f030022012b","ios_app_scheme":"kakaotalk://kakaopay/pg?url=https://online-pay.kakao.com/pay/mockup/6d418c9ce35792cff7b4c6708fb83d2921e0622142b13112250a3f030022012b","created_at":"2023-01-11T20:55:03"}
			
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(input); 
			
			/* 취소 step1)
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 
			 * 주문정보 -> 결제정보 저장(새로운 테이블) 세팅해야한다.
			
			* new CancelVO???
			*
			*
			*
			*
			*/
			System.out.println("tid" + selectTid);
//			return (jsonObject.get("partner_order_id").toString()); 
			return "redirect:productMain.ui";
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		} 
		  catch (IOException e) {
			
			e.printStackTrace();
		} catch (ParseException e) {

			e.printStackTrace();
		}
	
        
        
        
        //step 7.
        //카카오에서 결제성공시 나올 view 띄우기

//		model.addAttribute("pg_token", pg_token);
		
        return "";
	}

	    
}
	
	
	