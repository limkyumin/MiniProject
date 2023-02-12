<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>상품등록</title>

<jsp:include page="../common/header.jsp" />

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<!-- jQuery 라이브러리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<!-- naver스마트에디터 -->
<script type="text/javascript" src="/smarteditor2/js/HuskyEZCreator.js" charset="UTF-8"></script>
<style>
.content {
	background-color: rgb(247, 245, 245);
	width: 80%;
	margin: auto;
}

.innerOuter {
	border: 1px solid lightgray;
	width: 80%;
	margin: auto;
	padding: 5% 10%;
	background-color: white;
}

#enrollForm>table {
	width: 100%;
}

#enrollForm>table * {
	margin: 5px;
}
</style>

</head>
<body>
	
	
	카카오페이 결제가 정상적으로 완료되었습니다.
	 
	결제일시:     [[${info.approved_at}]]<br/>
	주문번호:    [[${info.partner_order_id}]]<br/>
	상품명:    [[${info.item_name}]]<br/>
	상품수량:    [[${info.quantity}]]<br/>
	결제금액:    [[${info.amount.total}]]<br/>
	결제방법:    [[${info.payment_method_type}]]<br/>
	 
	 
	 
	<h2>[[${info}]]</h2>
	
	<jsp:include page="../common/footer.jsp" />

	
</body>
</html>