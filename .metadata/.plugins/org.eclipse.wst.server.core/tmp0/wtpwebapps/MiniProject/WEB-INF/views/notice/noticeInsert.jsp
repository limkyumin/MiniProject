<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>

<jsp:include page="../common/header.jsp" />
<!-- 부트스트랩에서 제공하고 있는 스타일 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- 부트스트랩에서 제공하고 있는 스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  
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

#noticeInsertForm>table {
	width: 100%;
}

#noticeInsertForm>table * {
	margin: 5px;
}
</style>

</head>
<body>

	<div class="hero page-inner overlay" style="background-image: url('./resources/images/hero_bg_1.jpg'); height: 500px;">

		<div class="container">
			<div class="row justify-content-center align-items-center" style="height: 500px;">
				<div class="col-lg-9 text-center mt-5">
					<h1 class="heading" data-aos="fade-up" style="padding-top: 50px;">공지사항 작성</h1>
				</div>
			</div>
		</div>

	</div>

	<div class="content">
		<br><br>
		<div class="innerOuter">
			<br><br>

			<form id="noticeInsertForm" method="post" action="noticeInsert.ui">
				<table align="center">
					<tr>
						<th><label for="title">제목</label></th>
						<td><input type="text" id="title" class="form-control" name="noticeTitle" required></td>
					</tr>
					<tr>
						<th><label for="content">내용</label></th>
						<td><textarea id="content" class="form-control" rows="10" style="resize: none;" name="noticeContent" required></textarea></td>
					</tr>
				</table>
				<br>

				<div align="center">
					<button type="submit" class="btn btn-primary">등록하기</button>
					<a data-toggle="modal" data-target="#Cancel" button type="button" class="btn btn-danger">취소하기</a>
				</div>
			</form>
		</div>
		<br><br>
	</div>
	
	<div class="modal fade" id="Cancel">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Cancel</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
 
                <div class="modal-body">글 작성을 취소하고 목록으로 돌아가시겠습니까?</div>
                <div class="modal-footer">
                	<a type="button" href="noticeMain.ui" class="btn btn-primary">확인<a>
                    <button type="button" class="btn btn-danger" data-dismiss="modal">취소</button>
                </div>  
            </div>
        </div>
    </div>

	<jsp:include page="../common/footer.jsp" />

	
</body>
</html>