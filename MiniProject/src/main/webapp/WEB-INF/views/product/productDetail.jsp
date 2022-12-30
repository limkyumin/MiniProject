<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" href="./resources/images/zip3.png">
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

<!-- 카카오페이 -->
<script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
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
				<a class="btn btn-danger" onclick="productSell();" id=kakao>구매</a>
			</c:if>
			
			
			
		</div>
		<script>
		function productUpdate(){
			$("#postform").attr("action", "productUpdate.ui").submit();
		}
		
		function productDelete(){
			$("#postform").attr("action", "productDelete.ui").submit();
		}
		
		function productSell(){
			$("#postform").attr("action", "productSell.ui").submit();
		}
		
		</script>
		
		<script>
			$(function(){
				$('#kakao').click(function(){
					$.ajax({
						url:
						dataType:'json',
						success:function(data){
							alert(data.tid);
						} ,
						error:function(error){
							alert(error);
						}
					})
				})
			})
			
			</script>
		<br><br>
	</div>

	<jsp:include page="../common/footer.jsp" />

</body>
</html>