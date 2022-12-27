<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>

	<!-- 메뉴바 -->
	<jsp:include page="../main.jsp" />

	<div class="content">
		<br>
		<br>
		<div class="innerOuter">
			<h2>회원가입</h2>
			<br>

			<form class="validation-form" novalidate action="insert.me"
				method="post" id="userEnroll">
				<div class="form-group">

					<div id="asd">
						<label for="userId">* 아이디 : </label> <input type="text"
							class="form-control" id="userId" name="userId"
							oppaste="return false;" onkeyup="characterCheck(this)"
							onkeydown="characterCheck(this)"
							placeholder="영문자,숫자를 포함하여 총 4~20자로 입력해주세요" required>
						<div id="idcheck"></div>
					</div>
					
					<label for="userName">* 이름 : </label> 
					<input type="text" class="form-control" id="userName" name="userName"
					placeholder="이름을 입력해주세요" value="" required> 					
					<br>
						
					<label for="userPwd">* 비밀번호 : </label> 
					<input type="password" class="form-control" id="userPwd" name="userPwd" 
					placeholder="영문자,숫자,특수문자로 총 8~15자로 입력해주세요" value="" required>
					<br>
					
					<div id="asdasd">
					<label for="userPwdchk">* 비밀번호 재확인 : </label> 
					<input type="password" class="form-control" id="userPwdchk" name="userPwdchk"
					placeholder="비밀번호 재확인을 입력해주세요" value="" required>
					<font id="chkNotice" size="3"></font>
					</div>
					<br>  
					
					<label for="userBirth">* 생일 : </label>
					<input type="text" class="form-control" id="userBirth" name="userBirth"
					placeholder="생년월일을 입력해주세요 ex)yyyymmdd" value="" required>
					<br> 
					
					
					<label for="userEmail"> &nbsp; Email : </label> <input
						type="text" class="form-control" id="userEmail"
						placeholder="Please Enter Email" name="userEmail"> <br>

					<label for="userPhone">* 핸드폰 번호 : </label>
					<input type="text" class="form-control" id="userPhone" name="userPhone"
					placeholder="'-'를 제외한 전화번호를 입력해주세요" value="" required>
					<br>

					<label for="userAddress"> &nbsp; Address : </label> <input
						type="text" class="form-control" id="userAddress"
						placeholder="Please Enter Address" name="userAddress"> <br>

				</div>
				<br>
				<div class="btns" align="center">
					<button type="submit" class="btn btn-primary" onclick="return validate();">회원가입</button>
					<button type="reset" class="btn btn-danger">초기화</button>
				</div>
			</form>
		</div>
		<br>
		<br>

<script>
    //정규표현식 만들기
	function validate(){
    	var userName = document.getElementById("userName").value;
        var userPwd = document.getElementById("userPwd").value;
        var userPwdchk = document.getElementById("userPwdchk").value;
        var userBirth = document.getElementById("userBirth").value;
        var userPhone = document.getElementById("userPhone").value;
        	    
        	    regExp=/^[가-힣]{2,}$/;
        	      if(!regExp.test(userName)){
        	          alert("유효한 이름을 입력해주세요.")
        	          document.getElementById("userName").select(); 
        	          return false;
        	      }
        	      
        	    regExp=/^[a-z\d!@#$%^&*\s]{8,15}$/i;
        	      if(!regExp.test(userPwd)){
        	          alert("비밀번호 입력 시 영문자,숫자,특수문자로 총 8~15자로 입력해주세요.");
        	          document.getElementById("userPwd").select();
        	          return false;
        	      }
        	      
        	      if(userPwd!=userPwdchk){
        	          alert("비밀번호와 동일하게 입력해주세요.");
        	          document.getElementById("userPwdchk").select();
        	          return false;
        	      }
        	      
        	    regExp=/^(19[0-9][0-9]|20\d{2})(0[1-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;
        	      if(!regExp.test(userBirth)){
        	          alert("형식에 맞춰서 생년월일을 입력해주세요.")
        	          document.getElementById("userBirth").select(); 
        	          return false;
        	      }
        	      
        	    regExp=/^01([0|1|6|7|8|9])?([0-9]{4})?([0-9]{4})$/;
        	      if(!regExp.test(userPhone)){
        	          alert("'-'를 제외한 전화번호를 입력해주세요.")
        	          document.getElementById("userPhone").select(); 
        	          return false;
        	      }
        	}
        	
        	//ID 중복체크 비동기통신 구현
        	$(function(){
    	let $idchk = $("#userEnroll input[name=userId]");
    
    		$idchk.keyup(function(){
    		    var userId = document.getElementById("userId").value;
    			var regExp= /^[a-zA-Z](?=.*[a-zA-Z])(?=.*?[0-9]).{3,19}$/;
    			
    			if($idchk.val().length>=4){
    				
	            		$.ajax({
	        				url : "idCheck.ui",
	        				data : {
	        					checkId : $idchk.val()
	        				},
	        				success : function(result){
	        					if(result == "NNNNN"){ 
	        						$("#idcheck").show();
	        						$("#idcheck").css("color","red").text("중복된 아이디이거나 탈퇴된 아이디입니다. 다른 아이디를 입력해주세요.");
	        						$("#userEnroll :submit").attr("disabled",true);
	        					} else{
		        					if(regExp.test(userId)==true){
		        						$("#idcheck").show();
		        						$("#idcheck").css("color","blue").text("멋진 아이디네요!");
		        						$("#userEnroll :submit").attr("disabled",false);
		        						return false;
		        					}
	        					}
	        				},
	        				error : function(){
	        						
	        						console.log("통신실패했다람쥐");
	        				}
	        			})
	            	}else{ 
	            		$("#idcheck").hide();
	            	
	            		$("#userEnroll :submit").attr("disabled",true);
	            	}
    	})
    })
        	
    //비밀번호 비교 확인.
    $(function(){
	    $('#userPwd').keyup(function(){
	      $('#chkNotice').html('');
	    });
	
	$('#userPwdchk').keyup(function(){
		if($('#userPwd').val() != $('#userPwdchk').val()){
	    	$('#chkNotice').html('비밀번호가 일치하지 않습니다');
	        $('#chkNotice').attr('color', 'red');
	        $("#userEnroll :submit").attr("disabled",true);
	        } else{
	          $('#chkNotice').html('비밀번호가 일치합니다');
	          $('#chkNotice').attr('color', 'blue');
	          $("#userEnroll :submit").attr("disabled",false);
	        }
	
	    });
	});
        	
        	
    function characterCheck(obj){
        		var regExp = /[ \{\}\[\]\/?.,;:|\)*~`!^\-_+┼<>@\#$%&\'\"\\\(\=가-힣ㄱ-ㅎㅏ-ㅣ]/gi; 
        		if( regExp.test(obj.value) ){
        		alert("한글 및 특수문자는 입력하실수 없습니다.");
        		obj.value = obj.value.substring( 0 , obj.value.length - 1 ); // 입력한 특수문자 한자리 지움
        		}
        	}
        	
        	$(document).ready(function() { 
            	$("[name=userId]").attr("required" , true);    
            	});
        	
</script>

	</div>


</body>
</html>