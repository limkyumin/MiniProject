<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    
    <!-- 메뉴바 -->
    <jsp:include page="../main.jsp" />

    <div class="content">
        <br><br>
        <div class="innerOuter">
            <h2>회원가입</h2>
            <br>

            <form action="insert.me" method="post" id="userEnroll">
                <div class="form-group">
                    <label for="userId">* ID : </label>
                    <input type="text" class="form-control" id="userId" placeholder="Please Enter ID" name="userId" required>
<!-- 					<button type="button" onclick="idchk();">중복체크</button>  -->
<!-- 					<div id="idcheck"></div> -->
                    <label for="userPwd">* Password : </label>
                    <input type="password" class="form-control" id="userPwd" placeholder="Please Enter Password" name="userPwd" required> <br>

                    <label for="checkPwd">* Password Check : </label>
                    <input type="password" class="form-control" id="checkPwd" placeholder="Please Enter Password" required> <br>

                    <label for="userName">* Name : </label>
                    <input type="text" class="form-control" id="userName" placeholder="Please Enter Name" name="userName" required> <br>

					<label for="userBirth">* 생일 : </label>
                    <input type="text" class="form-control" id="userBirth" placeholder="Please Enter Name" name="userBirth" required> <br>


                    <label for="userEmail"> &nbsp; Email : </label>
                    <input type="text" class="form-control" id="userEmail" placeholder="Please Enter Email" name="userEmail"> <br>

<!--                     <label for="age"> &nbsp; Age : </label> -->
<!--                     <input type="number" class="form-control" id="age" placeholder="Please Enter Age" name="age"> <br> -->

                    <label for="userPhone"> &nbsp; Phone : </label>
                    <input type="tel" class="form-control" id="userPhone" placeholder="Please Enter Phone (-없이)" name="userPhone"> <br>
                    
                    <label for="userAddress"> &nbsp; Address : </label>
                    <input type="text" class="form-control" id="userAddress" placeholder="Please Enter Address" name="userAddress"> <br>
                    
<!--                     <label for=""> &nbsp; Gender : </label> &nbsp;&nbsp; -->
<!--                     <input type="radio" id="Male" value="M" name="gender" checked> -->
<!--                     <label for="Male">남자</label> &nbsp;&nbsp; -->
<!--                     <input type="radio" id="Female" value="F" name="gender"> -->
<!--                     <label for="Female">여자</label> &nbsp;&nbsp; -->
                </div> 
                <br>
                <div class="btns" align="center">
<!--                     <button type="submit" class="btn btn-primary" disabled>회원가입</button> -->
					<button type="submit" class="btn btn-primary">회원가입</button>
                    <button type="reset" class="btn btn-danger">초기화</button>
                </div>
            </form>
        </div>
        <br><br>
        <script>
        
//         $(function(){
//         	let $idchk = $("#userEnroll input[name=userId]");
        
//         		$idchk.keyup(function(){
        			
//         			if($idchk.val().length>=4){
// 		            		$.ajax({
// 		        				url : "idCheck.me",
// 		        				data : {
// 		        					checkId : $idchk.val()
// 		        				},
// 		        				success : function(result){
		        					
// 		        					if(result == "NNNNN"){ //아이디 사용불가능
// 		        						$("#idcheck").show();
// 		        						$("#idcheck").css("color","red").text("중복된 아이디가 존재합니다. 다른 아이디를 입력해주세요.");
		        						
// 		        						//회원가입 버튼 비활성화 시키기
// 		        						$("#userEnroll :submit").attr("disabled",true);
		        						
// 		        					}else{//아이디 사용가능 
// 		        						$("#idcheck").show();
// 		        						$("#idcheck").css("color","yellowgreen").text("멋진 아이디네요!")
		        						
// 		        						$("#userEnroll :submit").attr("disabled",false);
// 		        					}
		        					
// 		        				},
// 		        				error : function(){
		        						
// 		        						console.log("통신실패");
// 		        				}
// 		        			})
// 		            	}else{ //4글자 미만일때 - 메세지 숨기기
// 		            		$("#idcheck").hide();
		            	
// 		            		$("#userEnroll :submit").attr("disabled",true);
// 		            	}
//         	})
//         })
//         	 function chk(){
         		
//      			$.ajax({
//      				url : "idcheck.me",
//      				data : {
//      					checkId : $("#enrollForm input[name=userId]").val()
//      				},
//      				success : function(){
     					
//      				},
//      				error : function(){
     						
//      						console.log("통신실패");
//      				}
//      			})
//              }
        </script>
        
        

    </div>

    <!-- 푸터바 -->
  <!--   <jsp:include page="../common/footer.jsp" />  -->

</body>
</html>