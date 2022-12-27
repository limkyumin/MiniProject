<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <jsp:include page="../main.jsp" />
​
    <div class="content">
        <br><br>
        <div class="innerOuter">
            <h2>마이페이지</h2>
            <br>
​
            <form action="update.me" method="post">
                <div class="form-group">
                    <label for="userId">* ID : </label>
                    <input type="text" class="form-control" id="userId" value="${loginUser.userId}" name="userId" readonly> <br>
​
                    <label for="userName">* Name : </label>
                    <input type="text" class="form-control" id="userName" value="${loginUser.userName}" name="userName" readonly> <br>
​					
					<label for="userPwd">* Password : </label>
                    <input type="password" class="form-control" id="userPwd" value="" name="userPwd" required> <br>

                    <label for="checkPwd">* Password Check : </label>
                    <input type="password" class="form-control" id="checkPwd" required> <br>
											
                    <label for="userEmail"> &nbsp; Email : </label>
                    <input type="text" class="form-control" id="userEmail" value="${loginUser.userEmail}" name="userEmail"> <br>
​
                    <label for="userBirth"> &nbsp; 생년월일 : </label>
                    <input type="number" class="form-control" id="userBirth" value="${loginUser.userBirth}" name="userBirth" readonly> <br>
​
                    <label for="userPhone"> &nbsp; Phone : </label>
                    <input type="tel" class="form-control" id="userPhone" value="${loginUser.userPhone}" name="userPhone"> <br>
                    
                    <label for="userAddress"> &nbsp; Address : </label>
                    <input type="text" class="form-control" id="userAddress" value="${loginUser.userAddress}" name="userAddress"> <br>
                </div> 
                <br>
                <div class="btns" align="center">
                    <button type="submit" class="btn btn-primary">수정하기</button>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#deleteForm">회원탈퇴</button>
                </div>
            </form>
        </div>
        <br><br>
        
    </div>
​
    <!-- 회원탈퇴 버튼 클릭 시 보여질 Modal -->
    <div class="modal fade" id="deleteForm">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
​
                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">회원탈퇴</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>
​
                <form action="delete.ui" method="post">
                    <!-- Modal body -->
                    <div class="modal-body">
                        <div align="center">
                            탈퇴 후 복구가 불가능합니다. <br>
                            정말로 탈퇴 하시겠습니까? <br>
                        </div>
                        <br>
                            <label for="userPwd" class="mr-sm-2">Password : </label>
                            <input type="password" class="form-control mb-2 mr-sm-2" placeholder="Enter Password" id="userPwd" name="userPwd"> <br>
                    </div>
                    <!-- Modal footer -->
                    <div class="modal-footer" align="center">
                        <button type="submit" class="btn btn-danger">탈퇴하기</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
​
   
</html>