<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header 영역</title>
	<!-- jQuery 라이브러리 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    
    <!-- 부트스트랩에서 제공하고 있는 스타일 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    
    <!-- 부트스트랩에서 제공하고 있는 스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
    <!-- JavaScript -->
	<script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>
	
	<!-- CSS -->
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
	
	<!-- Default theme -->
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css"/>
	
	<!-- Semantic UI theme -->
	<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/semantic.min.css"/>
	
		<!-- Favicons -->
  <link href="./resources/img/favicon.png" rel="icon">
  <link href="./resources/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Roboto:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="./resources/vendor/animate.css/animate.min.css" rel="stylesheet" type="text/css">
  <link href="./resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <link href="./resources/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet" type="text/css">
  <link href="./resources/vendor/boxicons/css/boxicons.min.css" rel="stylesheet" type="text/css">
  <link href="./resources/vendor/glightbox/css/glightbox.min.css" rel="stylesheet" type="text/css">
  <link href="./resources/vendor/swiper/swiper-bundle.min.css" rel="stylesheet" type="text/css">

  <!-- Template Main CSS File -->
  <link href="./resources/css/style.css" rel="stylesheet" type="text/css">
	
	
	
</head>
<body>

<!-- 얼랏 alert 스크립트임 -->
	<c:if test="${not empty alertMsg}">
		<script>
			alertify.alert("","${alertMsg}");
		</script>
		<c:remove var="alertMsg" scope="session"/>
	</c:if>


	  <header id="header" class="fixed-top d-flex align-items-center">
    <div class="container d-flex align-items-center justify-content-between">

      <h1 class="logo"><a href="./">규민PJ</a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html" class="logo"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

      <nav id="navbar" class="navbar">
        <ul>
          <li><a class="nav-link scrollto active" href="./">Home</a></li>
          <li><a class="nav-link scrollto" href="noticeMain.ui">NOTICE</a></li>
          <li><a class="nav-link scrollto" href="productMain.ui">SHOP</a></li>
          <li><a class="nav-link scrollto" href="kakaopay.ui">Petsitter</a></li>
          
          <li class="dropdown"><a href="#"><span>Drop Down</span> <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><a href="#">Drop Down 1</a></li>
              <li class="dropdown"><a href="#"><span>Deep Drop Down</span> <i class="bi bi-chevron-right"></i></a>
                <ul>
                  <li><a href="#">Deep Drop Down 1</a></li>
                  <li><a href="#">Deep Drop Down 2</a></li>
                  <li><a href="#">Deep Drop Down 3</a></li>
                  <li><a href="#">Deep Drop Down 4</a></li>
                  <li><a href="#">Deep Drop Down 5</a></li>
                </ul>
              </li>
              <li><a href="#">Drop Down 2</a></li>
              <li><a href="#">Drop Down 3</a></li>
              <li><a href="#">Drop Down 4</a></li>
            </ul>
          </li> 
          <c:choose>
          	
          	<c:when test="${ empty loginUser }">
          		
          		<li><a class="getstarted scrollto" href="loginPage.ui">로그인/회원가입</a></li>
       	 	</c:when>
       	 	<c:otherwise>
              	              
	             <label>${ loginUser.userName }님 환영합니다</label> &nbsp;&nbsp;
	             <a href="myPage.me">마이페이지</a>
	             <a href="logout.me">로그아웃</a>
            </c:otherwise>
       	  </c:choose> 
        </ul>
         
<!-- <li><a class="nav-link scrollto" href="loginPage.ui">로그인</a></li> -->
        
   
        
        
        
        
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

    </div>
  </header><!-- End Header -->
  
    <script src="./resources/vendor/purecounter/purecounter_vanilla.js"></script>
  <script src="./resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="./resources/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="./resources/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="./resources/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="./resources/vendor/php-email-form/validate.js"></script>

  <!-- Template Main JS File -->
  <script src="./resources/js/main.js"></script>
  
  
</body>
</html>