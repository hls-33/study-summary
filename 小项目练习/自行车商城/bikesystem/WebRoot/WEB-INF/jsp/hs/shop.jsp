<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <base target="_blank">
    <title>My JSP 'shop.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- css文件 -->
	<link rel="stylesheet" type="text/css" href="css/hs/shop.css" >
	<!-- js文件 -->
	<script type="text/javascript" src=""></script>
	<!-- jqeury库和bootstrap库 -->
	<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
 	<script type="text/javascript" src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  	<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
  </head>
  
  <body>
  <div>
  	<jsp:include page="../hp/navigation.jsp"></jsp:include>
  </div>
  <div class="total">
  	<div class="shop-head">
	    <div class="shop-title" >
	    	
	    	<img alt="${requestScope.shopname}" src="${requestScope.headImages[0].imagePath}">
	    	<div class="shop-nav" >
		    	<nav class="navbar navbar-default" role="navigation">
		    	<div class="container-fluid">
			    <div class="navbar-header">
			        <a class="navbar-brand" href="#">本店所有商品</a>
			    </div>
			    <div>
			    	<ul class="nav navbar-nav">
			    		<c:forEach items="${requestScope.bikeKinds}" var="kind">
			    		<li><a href="hs/category?shopname=${requestScope.shopname}&biketype=kind-rent&kindname=${kind.kindName}">${kind.kindName}</a></li>
			    		</c:forEach>
			    	</ul>
			    </div>
			    </div>
		    	</nav>
	   		</div>
	    </div>
	   
	    <!-- 图片轮训导航 -->
    	<div class="img-nav" >
    		<ul class="img-ul" id="nav-ul">
    			<li class="img-list"><img src="${requestScope.navImages[0].imagePath}"></li>
    			<li class="img-list"><img src="${requestScope.navImages[1].imagePath}"></li>
    		</ul>
    		<span class="prev-img nav-img" ></span>
    		<span class="next-img nav-img" ></span>
    	</div>
    </div>
    
    
  	<div class="shop-main">
  		<!-- 热租 -->
  		<div class="hot-rent">
  			<div class="hot-logo">
  				<img src="/bikesystem/image/hs/热租商品.jpg" alt="热租自行车">
  				<a class="more-bikes-rent more-bikes" href="hs/category?shopname=${requestScope.shopname}&biketype=rent"></a>
  			</div>
  			<div class="hot-bike">
  				<c:forEach items="${requestScope.hotRentBikes}" var="hotBike">
  					<a href="/bikesystem/hp/bikesell?shopname=${bikeRent.shopName}&bikename=${bikeRent.bikeName}" class="hot-item">
  						<img alt="${hotBike.bikeName}" src="${hotBike.imgPath}" >
    					<span class="price"><span class="span1">￥</span><strong>${hotBike.dayPrice}</strong><span class="span2">日租金</span></span>
    					<span class="choose-count">${hotBike.rentCount}人已选择过</span>
  					</a>
  				</c:forEach>
  			</div>
  		</div>
  		
  		<!-- 热销 -->
  		<div class="hot-sell">
  			<div class="hot-logo">
  				<img src="/bikesystem/image/hs/热销商品.png" alt="热销自行车">
  				<a class="more-bikes-sell more-bikes" href="hs/category?shopname=${requestScope.shopname}&biketype=sell"></a>
  			</div>
  			<div class="hot-bike">
  				<c:forEach items="${requestScope.hotRentBikes}" var="hotBike">
  					<a href="/bikesystem/hp/bikesell?shopname=${bikeRent.shopName}&bikename=${bikeRent.bikeName}" class="hot-item">
  						<img alt="${hotBike.bikeName}" src="${hotBike.imgPath}" >
    					<span class="price"><span class="span1">￥</span><strong>${hotBike.dayPrice}</strong><span class="span2">日租金</span></span>
    					<span class="choose-count">${hotBike.rentCount}人已购买过</span>
  					</a>
  				</c:forEach>
  			</div>
  		</div>
  	</div>
  	
  	
  	
  </div>
  <script type="text/javascript">
  	var backgroundPath = "${requestScope.backgroundImage[0].imagePath}";
  </script>
  <script type="text/javascript" src="js/hs/shop.js"></script>
  </body>
</html>
