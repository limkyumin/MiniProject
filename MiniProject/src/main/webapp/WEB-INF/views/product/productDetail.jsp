<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품판매</title>

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

<style>
	.content {
		width: 90%;
		margin: auto;
	}
	
	.innerOuter {
		width: 90%;
		margin: auto;
		padding: 5% 10%;
		background-color: white;
	}
	
	table * {
		margin: 5px;
	}
	
	table {
		width: 100%;
	}
</style>

</head>
<body>
<!-- 얼랏 alert 스크립트임 -->
	<c:if test="${not empty alertMsg}">
		<script>
			alertify.alert("","${alertMsg}");
		</script>
		<c:remove var="alertMsg" scope="session"/>
	</c:if>
	
	<div class="content">
		<br><br>
		<div class="innerOuter" align="center">
			<br> <a class="btn btn-secondary" style="float: right; background-color: #2D55C9;" href="productMain.ui">목록</a>
			<br><br><br>

			<table id="contentArea" align="center" class="table">
				<tr>
					<th width="200">제목</th>
					<td colspan="3">${p.productName }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${p.userId }</td>
				</tr>	
				<tr>	
					<th>작성일</th>
					<td>${p.productDate }</td>	
				</tr>
				<tr>
					<th>상품유형</th>
					<td>${p.productType }</td>
				</tr>
				<tr>	
					<th>상품개수</th>
					<td>${p.productCount }</td>
				</tr>	
					<th>상품가격</th>
					<td>${p.productPrice }</td>
				<tr>	
					<th>상품타입</th>
					<td>${p.productType }</td>
				</tr>	
			</table>
			<h2>상품내용</h2>
			<div id="content2" align="center">
			${p.productContent }
			</div>
			<br>

			<form id="postform" action="" method="post">
				<input type="hidden" name="pno" value="${p.productNo }">
			</form>
			
		</div>
		
		<div align="center">
			<c:if test="${loginUser.userId eq p.userId }">
				<a class="btn btn-primary" onclick="productUpdate();">수정</a>
				<a class="btn btn-danger" onclick="productDelete();">삭제</a>
			</c:if>
			
			<c:if test="${loginUser.userId eq 'admin' }">
				<a class="btn btn-danger" onclick="productDelete();">삭제</a>
			</c:if>
			
			<c:if test="${loginUser.userId ne p.userId }">
				<a class="btn btn-danger" id="buy">구매</a>
			</c:if>
    			
    		<a class="btn btn-danger" id="kakao">
    			카페</a>
			
			<a class="btn btn-danger" id="boot">
    			boot</a>
		</div>
		<script>
		function productUpdate(){
			$("#postform").attr("action", "productUpdate.ui").submit();
		}
		
		function productDelete(){
			$("#postform").attr("action", "productDelete.ui").submit();
		}
		
		</script>
		
		<!-- 아임포트 -->
		<script type="text/javascript">
			$(document).ready(function(){
				$("#buy").click(function(){
					payment();
				});
			});
				
			
			function payment(data) {
				IMP.init('imp18673883');
				IMP.request_pay({
					pg: "kakaopay.TC0ONETIME", //pg사명 or pg사명.CID (잘못 입력할 경우, 기본 PG사가 띄워짐)
			        pay_method: "card", //지불 방법
			        merchant_uid:  'merchant_' + new Date().getTime(), //가맹점 주문번호 (아임포트를 사용하는 가맹점에서 중복되지 않은 임의의 문자열을 입력)
			        name: ${p.productName }, //결제창에 노출될 상품명
			        amount: ${p.productPrice }, //금액
			        buyer_email : "testiamport@naver.com", 
			        buyer_name : "홍길동",
			        buyer_tel : "01012341234"
				}, function(rsp) {q
					if(rsp.success){
						alert('결제 성공');
						console.log('성공');
					}else{
						alert('실패');
						console.log('실패');
					}
				});
			}
		</script>
		
		<script>
		<!-- 카카오 -->
		$(function(){
			IMP.init('imp18673883');
			$('#kakao').click(function(){
				$.ajax({
					url:"kakao.ui" ,
					dataType: 'json' ,
					success:function(data){
						var box = data.next_redirect_pc_url;
						//console.log(data);
						window.open(box);	
						
					},
					error:function(error){
						alert(error);
						console.log('ㅇㅇㅇㅇㅇㅇㅇ');
					}
				});
			});
		});
			
		</script>
		
		<!-- 부트 -->
		<script>
		
		</script>
		

		<br><br>
	</div>

	<jsp:include page="../common/footer.jsp" />

</body>
</html>