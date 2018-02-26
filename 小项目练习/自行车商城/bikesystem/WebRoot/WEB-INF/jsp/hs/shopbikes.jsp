<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'shopbikes.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="css/hs/shop.css" >
	<link rel="stylesheet" type="text/css" href="css/hs/shopbikes.css">
	<link rel="stylesheet" type="text/css" href="css/hs/searchBikes.css" >
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
	</div>
	<div class="shop-bikes">
		<div class="kind-nav">
			<div class="kind-nav-title kind-nav-row">商品分类</div>
			<div class="kind-nav-rent kind-nav-row">
				<a href="hs/category?shopname=${requestScope.shopname}&biketype=rent">查看所有出租车型</a>
				<a href="hs/category?shopname=${requestScope.shopname}&biketype=rent&ordertype=rentcount_desc">按租量</a>
				<a href="hs/category?shopname=${requestScope.shopname}&biketype=rent&ordertype=dayprice_desc">按日租价格</a>
			</div>
			<div class="kind-nav-sell kind-nav-row">
				<a href="hs/category?shopname=${requestScope.shopname}&biketype=sell">查看所有销售车型</a>
				<a href="hs/category?shopname=${requestScope.shopname}&biketype=sell&ordertype=sellcount_desc">按销量</a>
				<a href="hs/category?shopname=${requestScope.shopname}&biketype=sell&ordertype=bikeprice_desc">按销售价格</a>
			</div>
			<div class="kind-nav-kindname ">
				<c:forEach items="${requestScope.bikeKinds}" var="bikeKind">
					<div class="kind-nav-item">
						<div class="kind-nav-row nav-kindname-div">
						<span  class="nav-icon kind-nav-icon-open"></span>
						<a class="nav-kindname" >${bikeKind.kindName}</a>
						</div>
						
						<div class="kind-type-choose">
							<div class="kind-type-choose-div">
								<span  class="kind-nav-icon-item"></span>
								<a href="hs/category?shopname=${requestScope.shopname}&biketype=kind-rent&kindname=${bikeKind.kindName}">租车</a>
							</div>
							<div class="kind-type-choose-div">
								<span  class="kind-nav-icon-item"></span>
								<a href="hs/category?shopname=${requestScope.shopname}&biketype=kind-sell&kindname=${bikeKind.kindName}">买车</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		
		</div>
		<div class="bikes-info">
			<c:forEach items="${requestScope.shopBikes}" var="shopBike">
    			<div class="result-item">
    				<div class="img-item"><img alt="${shopBike.bikeName}" src="${shopBike.imgPath}" ></div>
    				<div class="price-item">
    					<c:if test="${requestScope.listLogo=='rent'}">
    					<div class="price"><span class="span1">￥</span><strong>${shopBike.dayPrice}</strong><span class="span2">日租金</span></div>
    					<div class="shopbikes-choose-count">${shopBike.rentCount}人曾青睐</div>
    					</c:if>
    					
    					<c:if test="${requestScope.listLogo=='sell'}">
    					<div class="price"><span class="span1">￥</span><strong>${shopBike.bikePrice}</strong><span class="span2">单价</span></div>
    					<div class="shopbikes-choose-count">${shopBike.sellCount}人已购买</div>
    					</c:if>
    					
    				</div>
    				<div class="goods-title-item">
    					<c:if test="${requestScope.listLogo=='rent'}">
	    					<a href="/bikesystem/hs/bikerent?shopname=${shopBike.shopName}&bikename=${shopBike.bikeName}" ><span>${shopBike.bikeName}</span></a>
	    					<span class="span3">${shopBike.isRented}</span>
    					</c:if>
    					<c:if test="${requestScope.listLogo=='sell'}">
    						<a href="/bikesystem/hp/bikesell?shopname=${shopBike.shopName}&bikename=${shopBike.bikeName}" ><span>${shopBike.bikeName}</span></a>
    					</c:if>
        			</div>
    				<div class="shop-item">
    				<a href="/bikesystem/hs/shop?shopname=${shopBike.shopName}" class="shopname">
    					<span class="dsrs">
	            			<span class="dsr equalthan"></span>
	           				<span class="dsr equalthan"></span>
	            			<span class="dsr equalthan"></span>
	        			</span>
    				<span>${shopBike.shopName}</span>
    				</a></div>
    			</div>
    		</c:forEach>
		</div>
	</div>
	
	<script type="text/javascript" src="js/hs/shopbikes.js"></script>
  </body>
</html>
