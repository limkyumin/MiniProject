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
import java.util.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import my.mini.project.product.model.service.OrderService;
import my.mini.project.product.model.vo.Order;
import my.mini.project.product.model.vo.orderCancel;

@Controller
public class OrderController {

	@Autowired
	OrderService orderService;
	
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
					+ "approval_url=http://localhost:8989/project/" + orderNo + "/productMain.ui&"	//결제 성공시
//					+ "approval_url=http://localhost:8989/project/productMain.ui&"
					+ "fail_url=http://localhost:8989/productSell.ui&"				//결제 실패시
					+ "cancel_url=http://localhost:8989/project/" + orderNo + "/productMain.ui";			//결제 취소시
			
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

			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(input); 
			//json 형태로 형변환
			System.out.println("들어오는 값 : " + input);
			/*tid":"T3c643ed4a466e29a6d9",
			"tms_result":false,
			"next_redirect_app_url":"https://online-pay.kakao.com/mockup/v1/7304c80af93faa9fdd4e64b09b29c4c62a631bc8e506b83f4d399f7c9e2f18b8/aInfo",
			"next_redirect_mobile_url":"https://online-pay.kakao.com/mockup/v1/7304c80af93faa9fdd4e64b09b29c4c62a631bc8e506b83f4d399f7c9e2f18b8/mInfo",
			"next_redirect_pc_url":"https://online-pay.kakao.com/mockup/v1/7304c80af93faa9fdd4e64b09b29c4c62a631bc8e506b83f4d399f7c9e2f18b8/info",
			"android_app_scheme":"kakaotalk://kakaopay/pg?url=https://online-pay.kakao.com/pay/mockup/7304c80af93faa9fdd4e64b09b29c4c62a631bc8e506b83f4d399f7c9e2f18b8",
			"ios_app_scheme":"kakaotalk://kakaopay/pg?url=https://online-pay.kakao.com/pay/mockup/7304c80af93faa9fdd4e64b09b29c4c62a631bc8e506b83f4d399f7c9e2f18b8",
			"created_at":"2023-01-17T15:45:01"}
			 */
			
			System.out.println(jsonObject.get("tax_free_amount")); //null
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
					+ "pg_token=" + pg_token + "&"
					+ "cancel_amount=cancel_amount&"
					+ "cancel_tax_free_amount=cancel_tax_free_amount"
					;
			
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
			System.out.println("input" + input);
			/* 들어오는 값
			 * {"aid":"A3c526314a466e299f70",
			 * "tid":"T3c5261d003e7c9896fa",
			 * "cid":"TC0ONETIME",
			 * "partner_order_id":"20230116192531",
			 * "partner_user_id":"partner_user_id",
			 * "payment_method_type":"MONEY",
			 * "item_name":"hi",
			 * "quantity":1,
			 * "amount":{"total":1000,"tax_free":0,"vat":200,"point":0,"discount":0,"green_deposit":0},
			 * "created_at":"2023-01-16T19:25:34",
			 * "approved_at":"2023-01-16T19:26:16"}
			 * */
			
			
			
			
			/* 취소 step1)
	
			 * 주문정보 -> 결제정보 저장(새로운 테이블) 세팅해야한다.
			 * new CancelVO???
			*/

			orderCancel c = new orderCancel();
			c.setCid(jsonObject.get("cid").toString());
			c.setTid(jsonObject.get("tid").toString());		 
			c.setPartner_order_id(jsonObject.get("partner_order_id").toString());
			c.setCancel_amount(jsonObject.get("amount").toString());		 //취소금액!
//			c.setCancel_tax_free_amount(jsonObject.get("cancel_tax_free_amount").toString()); //취소 비과세 금액
//			c.setCancel_yn(jsonObject.get("cancel_yn").toString()); 	 //취소여부
			
			//ORDER_CANCEL 테이블에 저장하자.
			int cancel = orderService.cancelOrder(c);
		
			System.out.println("orderCancel 저장 잘되는지 확인");
	

			return "";
			
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
	
	//취소 시작******************************************************************************
	@ResponseBody
	@GetMapping("{partner_order_id}/productMain.ui")
	@RequestMapping("cancel")
	public String kakoCancel(
//			@RequestParam("pg_token") String pg_token,
		/*	@PathVariable("partner_order_id")*/ String partner_order_id, String tid) {
		
		
		try {
			
			/*DB에서 tid 를 꺼내와야 한다(select)
			1) tid를 select 진행 후 tid를 카카오에 넘겨야 함(tid는 카카오에서 pk개념임)
				tid를 select 할 때는 orderNo(유니크값)로 가져와야 함.
			 */
			String selectTid = orderService.selectTid(partner_order_id);
			Order o = new Order();
			o.setPartner_order_id(partner_order_id);
			o.setTid(tid);
			System.out.println("111111111 : " + partner_order_id);
			System.out.println("22222222222 : " + tid);
//			orderCancel c = new orderCancel();
//			c.setTid(partner_order_id.toString());
			
			
			//카카오에 결제모듈을 띄울 때 주문번호 객체 + "정보" 같이 보내준다
			URL kakao = new URL("https://kapi.kakao.com/v1/payment/cancel"); //웹상주소 URL 선언
			HttpURLConnection hrc = (HttpURLConnection) kakao.openConnection();   //요청하는 클라이언트, 서버연결을 해주는것.
			hrc.setRequestMethod("POST"); //포스트 방식
			hrc.setRequestProperty("Authorization", "KakaoAK 7a96f0ac17cb9603eaa371eb185eef21"); //	내 어드민 주소 7a96f0ac17cb9603eaa371eb185eef21
			hrc.setRequestProperty("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
			hrc.setDoOutput(true); //이 연결을통해 서버에게 전해줄것이 있는지 없는지, 내보낼 것이 있다 그래서 true 이것은 생성될때 input은 자동적으로 true라 인풋 선언 필요없다 하지만 아웃풋은 false기 때문에 true로 선언

			
			String kakaoParameter = "cid=TC0ONETIME&" 		//가맹점 코드
					+ "tid=" + tid + "&"
					+ "partner_order_id=" + partner_order_id + "&" 	//가맹점 주문번호
					+ "partner_user_id=partner_user_id&" 	//가맹점 회원 아이디
					+ "cancel_amount=1000&"
					+ "cancel_tax_free_amount=cancel_tax_free_amount&"
					+ "cancel_url=http://localhost:8989/project/" + partner_order_id + "/productMain.ui";			//결제 취소시
			
			System.out.println("33333333: " + partner_order_id);
			System.out.println("44444444: " + tid);
			System.out.println("전달하는 카카오파라메터 확인 : " + kakaoParameter);
			
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

			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(input); 
			//json 형태로 형변환
			System.out.println("들어오는 값 : " + input);
			
			//cancel_yn -> Y(취소)으로 업데이트하기
			int cancelUpdate = orderService.cancelUpdate();
			
			return (jsonObject.get("next_redirect_pc_url").toString());  
			//리턴 url은 어떻게 하지..
			
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
	
	
	

	
}
