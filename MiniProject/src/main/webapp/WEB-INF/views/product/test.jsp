<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test</title>

<jsp:include page="../common/header.jsp" />

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<!-- jQuery 라이브러리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<!-- 아임포트 -->
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<!-- 아임포트 -->
 <!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment.js"></script>

</head>
<body>
	
	<form action="productSell.ui" id="productSell.ui">
		<button>test</button>
	</form>
	카카오페이 결제가 정상적으로 완료되었습니다.
 
	결제일시:     [[${info.approved_at}]]<br/>
	주문번호:    [[${info.partner_order_id}]]<br/>
	상품명:    [[${info.item_name}]]<br/>
	상품수량:    [[${info.quantity}]]<br/>
	결제금액:    [[${info.amount.total}]]<br/>
	결제방법:    [[${info.payment_method_type}]]<br/>
	
	
	
<!-- 	    params.add("cid", "TC0ONETIME"); -->
<!--         params.add("partner_order_id", "테스트오더아이디"); -->
<!--         params.add("partner_user_id", "테스트유저아이디"); -->
<!--         params.add("item_name", "테스트아이템이름"); -->
<!--         params.add("quantity", "테스트수량"); -->
<!--         params.add("total_amount", "테스트가격"); -->
<!--         params.add("tax_free_amount", "테스트가격2"); -->
	
	
</body>
</html>