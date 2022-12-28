<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="common/header.jsp"/>
	
	
	<div class="content">
		<br><br>
		<div class="innerOuter">
			<h4 align="center">게시글 TOP 5</h4>
			<br>
		</div>
	<table id="boardList" class="table table-hover" align="center">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>작성일</th>
				<th>첨부파일</th>
			</tr>
		</thead>
		
		<tbody>
			<!-- ajax로 조회수 상위 5개 조회해오기 -->
		</tbody>
	</table>	
	
	</div>
	<br><br>
	
<!-- 		<script>
	$(function(){
		$("tbody").on("click, "tr", function(){
			location.href="detail.bo?bno" + $(this).children().eq(0).text();
		});
	});
	</script>
 -->	
	
	<script>
		

	
	</script>

	
	<jsp:include page="common/footer.jsp"/>
</body>
</html>