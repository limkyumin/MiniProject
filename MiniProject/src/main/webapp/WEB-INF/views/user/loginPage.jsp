<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/png" href="./resources/images/zip3.png">
<meta charset="UTF-8">
<title>로그인/회원가입</title>
<link rel="stylesheet" href="./resources/css/loginandnewuser.css">
<style>
.idpw{
	text-decoration:none;
	color:black;
	font-size:12px;
	float: right;
	position: relative;
	left: -30%;
}
#ZIP { 
	display: block; margin: 0px auto;
}
.form-wrap{
	margin-top:15px !important;
}
.input-wrap{
}
#loginidpws{
}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css"/>
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/semantic.min.css"/>
</head>
<body>

	<c:if test="${not empty alertMsg}" >
		<script>
		alertify.alert("ZIP","${alertMsg}");
		</script>
		<c:remove var="alertMsg" scope="session"/>
	</c:if>
	
    <div class="wrap">
    	<a href="./">
    		<img src="./resources/img/slide/slide-1.jpg" id="ZIP" style="width: 120px; height: 100px;">
    	</a>
        <div class="form-wrap">
            <div class="button-wrap">
            
                <div id="btn"></div>
                <button type="button" class="togglebtn" onclick="login()">로그인</button>
                <button type="button" class="togglebtn" onclick="register()">회원가입</button>
            </div>
            <form id="login" action="loginuser.ui" class="input-group" method="post">
                <input type="text" class="input-field" placeholder="아이디를 입력해주세요" id="userId" name="userId" required>
                <input type="password" class="input-field" placeholder="비밀번호를 입력해주세요" id="userPwd" name="userPwd" required>
                <input type="checkbox" class="checkbox" id="checkId" name="checkId"><label for="checkId">아이디 저장</label>
                <button class="submit">로그인</button><br>
                <a href="idpwsearch.ui" class="idpw">아이디/비밀번호 찾기</a><br>
                
                
 
				
            </form>
            <form id="register" action="userEnroll.me" class="input-group" method="post">
                <button class="submit">회원가입 페이지로 이동</button>
            </form>
        </div>
    </div>
    <script>
    var x = document.getElementById("login"); 
    var y = document.getElementById("register");
    var z = document.getElementById("btn");
    function login(){
        x.style.left = "50px";
        y.style.left = "450px";
        z.style.left = "0";
    }

    function register(){
        x.style.left = "-400px";
        y.style.left = "50px";
        z.style.left = "110px";
    }
    
    </script>
    

</body>
</html>