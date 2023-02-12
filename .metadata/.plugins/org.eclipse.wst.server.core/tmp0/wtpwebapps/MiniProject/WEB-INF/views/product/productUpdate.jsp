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

	<div class="hero page-inner overlay" style="background-image: url('./resources/images/hero_bg_1.jpg'); height: 200px;">

		<div class="container">
			<div class="row justify-content-center align-items-center" style="height: 300px;">
				<div class="col-lg-9 text-center mt-5">
					<h1 class="heading" data-aos="fade-up" style="padding-top: 50px;">상품 등록</h1>
				</div>
			</div>
		</div>

	</div>

	<div class="content">
		<br><br>
		<div class="innerOuter">
			<br><br>

			<form id="enrollForm" method="post" action="productInsert.ui">
				
				
				<div class="form-group">
                
					               
                	
                    <label for="productName">* 제목 : </label>
                    <input type="text" class="form-control" id="productName" placeholder="제목을 입력하세요" name="productName" value="${p.productName }" required> <br>
					
					<label for="productType">* 상품유형 : </label>
                    <input type="text" class="form-control" id="productType" placeholder="상품 유형을 입력하세요(ex 고양이,강아지 등...)" name="productType" value="${p.productType }" required> <br>
                    
                    <label for="productCount">* 상품개수 : </label>
                    <input type="text" class="form-control" id="productCount" placeholder="개수를 입력하세요(숫자만)" name="productCount" value="${p.productCount }" required> <br>

                    
					
                    <label for="productPrice">* 상품 가격 : </label>
                    <input type="text" class="form-control" id="productPrice" placeholder="숫자만 입력하세요(숫자만)" name="productPrice" value="${p.productPrice }" required> <br>
                    
                    <label for="productContent">* 내용 : </label>
                    <textarea class="form-control" rows="30" id="productContent" placeholder="내용을 입력하세요" name="productContent" value="${p.productContent }" required></textarea> <br>
                    
                </div>
				
				<div align="center">
					<input type="hidden" value="${loginUser.userNo }" name="productWriter">
					<button type="submit" id="insert" class="btn btn-primary" onclick="submitContents();">등록하기</button>
					<button type="button" class="btn btn-danger" onclick="history.back();">뒤로가기</button>
				</div>
			</form>
		
<script type="text/javascript">
  var oEditors = [];
  nhn.husky.EZCreator.createInIFrame({
  oAppRef: oEditors,
  elPlaceHolder: "productWriter",
  sSkinURI: "/MiniProject/src/main/webapp/SmartEditor2Skin.html",
  fCreator: "createSEditor2"
  });

  //‘저장’ 버튼을 누르는 등 저장을 위한 액션을 했을 때 submitContents가 호출된다고 가정한다.
  function submitContents(elClickedObj) {
  // 에디터의 내용이 textarea에 적용된다.
  oEditors.getById["productWriter"].exec("UPDATE_CONTENTS_FIELD", [ ]);
  document.getElementById("form").submit();
  // 에디터의 내용에 대한 값 검증은 이곳에서
  // document.getElementById("textAreaContent").value를 이용해서 처리한다.

  try {
  elClickedObj.form.submit();
  } catch(e) {

  }
  }

</script>






		</div>
		<br><br>
	</div>

	<jsp:include page="../common/footer.jsp" />

	
</body>
</html>