<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>

<jsp:include page="../common/header.jsp" />

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

<!-- jQuery 라이브러리 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

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
	
	table * {
		margin: 5px;
	}
	
	table {
		width: 100%;
	}
</style>

</head>
<body>

	<div class="hero page-inner overlay" style="background-image: url('./resources/images/hero_bg_1.jpg'); height: 500px;">

		<div class="container">
			<div class="row justify-content-center align-items-center" style="height: 500px;">
				<div class="col-lg-9 text-center mt-5">
					<h1 class="heading" data-aos="fade-up" style="padding-top: 50px;">공지사항</h1>
				</div>
			</div>
		</div>

	</div>

	<div class="content">
		<br><br>
		<div class="innerOuter">
			<br> <a class="btn btn-secondary" style="float: right; background-color: #2D55C9;" href="noticeMain.ui">목록</a>
			<br><br><br>

			<table id="contentArea" align="center" class="table">
				<tr>
					<th width="200">제목</th>
					<td colspan="3">${n.noticeTitle }</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>관리자</td>
					<th>작성일</th>
					<td>${n.noticeDate }</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td colspan="3">${n.noticeView }</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3"></td>
				</tr>
				<tr>
					<td colspan="4"><p style="height: 150px;">${n.noticeContent }</p></td>
				</tr>
			</table>
			<br>

			<div align="center">
				<c:if test="${loginUser.userId eq 'admin' }">
					<a class="btn btn-primary" onclick="postFormSubmit(1);">수정</a>
					<a class="btn btn-danger" onclick="postFormSubmit(2);">삭제</a>
				
				</c:if>
			</div>
			<br><br>

			<form id="postform" action="" method="post">
				<input type="hidden" name="vct" value="${n.noticeNo }">
			</form>
			
			<script>
			//수정하기 또는 삭제하기 url로 요청 못하게 post형식으로 숨기기
	        	function postFormSubmit(num){
	        		//action속성에 경로값을 넣어주는 함수 + sumbit까지
	        		if(num==1){ //1일땐 수정하기
	        			$("#postform").attr("action","updateForm.ui").submit();
	        		}else{ //2일(아닐)땐 삭제하기
	        			$("#postform").attr("action","noticeDelete.ui").submit();
	        		}
	        		
	        	}	
				
			</script>
		</div>
	</div>

	<jsp:include page="../common/footer.jsp" />

</body>
</html>