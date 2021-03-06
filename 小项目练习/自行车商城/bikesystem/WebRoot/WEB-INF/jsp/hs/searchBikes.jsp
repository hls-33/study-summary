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
    
    <title>My JSP 'serchShop.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<!-- css文件 -->
	<link rel="stylesheet" type="text/css" href="css/hs/searchBikes.css" >
	<!-- js文件 -->
	<script type="text/javascript" src=""></script>
	<!-- jqeury库和bootstrap库 -->
	<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
 	<script type="text/javascript" src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  	<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
  </head>
  
  <body>
  	<!-- 导航栏 -->
    <div>
  	<jsp:include page="../hp/navigation.jsp"></jsp:include>
 	</div>
    <div class="header-wraper">
    	<div class="logo"><a href="index.jsp"><img alt="小芳自行车" src="/bikesystem/image/hs/bikelogo.png" ></a></div>
    	<div class="search">
    		<form action="/bikesystem/hs/search" method="post" >
    			<div class="wraper">
    				<div class="tab-wraper ">
    					<div class="tab">
    					<ul class="triggers" >
    						<li>宝贝</li>
    						<li>店铺</li>
    					</ul>
    					<span class="arrow "></span>
    					</div>
    				</div>
    				<div class="input-search">
    					<div class="search-combobox">
    						<input class="search-input" type="text" name="bikename" placeholder="请输入要搜索的词">
    					</div>
    				</div>
    			</div>
    			<button type="submit" class="submit">搜索</button>
    		</form>
    	</div>
    </div>
    <!-- 搜索结果主体 -->
    <div class="main">
   		<div id="mainsrp-nav">
   			<div class="crumb">
    			<span>所有分类 &nbsp; &gt;</span>
    			<span class="total">共<span class="h">${requestScope.bikeRentList.size()}</span>款相关产品</span>
	    	</div>
	    	<div class="m-nav">
	    		<div class="group">
		    		<span class="nav-title">赛车类型：</span>
		    		<c:forEach items="${requestScope.bikeKindsList}" var="bikekind">
		    			<a class="nav-text" href="/bikesystem/hs/search?&bikename=${requestScope.bikename}&kindname=${bikekind.kindName}">${bikekind.kindName}</a>
		    		</c:forEach>
	    		</div>
	    		<div class="group">
		    		<span class="nav-title">颜色：</span>
		    		<a class="nav-text" href="/bikesystem/hs/search?&bikename=${requestScope.bikename}&color=红色">红色</a>
	    			<a class="nav-text" href="/bikesystem/hs/search?&bikename=${requestScope.bikename}&color=蓝色">蓝色</a>
	    			<a class="nav-text" href="/bikesystem/hs/search?&bikename=${requestScope.bikename}&color=白色">白色</a>
	    			<a class="nav-text" href="/bikesystem/hs/search?&bikename=${requestScope.bikename}&color=黑色">黑色</a>
	    			<a class="nav-text" href="/bikesystem/hs/search?&bikename=${requestScope.bikename}&color=黄色">黄色</a>
	    		</div>
	    		<div class="group">
		    		<span class="nav-title">日租金：</span>
		    		<a class="nav-text" href="/bikesystem/hs/search?&bikename=${requestScope.bikename}&dayprice=0~50">0~50</a>
	    			<a class="nav-text" href="/bikesystem/hs/search?&bikename=${requestScope.bikename}&dayprice=50~100">50~100</a>
	    			<a class="nav-text" href="/bikesystem/hs/search?&bikename=${requestScope.bikename}&dayprice=100~200">100~200</a>
	    			<a class="nav-text" href="/bikesystem/hs/search?&bikename=${requestScope.bikename}&dayprice=200~10000">200以上</a>
	    		</div>
	    		<div class="group">
		    		<span class="nav-title">出租状态：</span>
		    		<a class="nav-text" href="/bikesystem/hs/search?&bikename=${requestScope.bikename}&isrented=已出租">已出租</a>
	    			<a class="nav-text" href="/bikesystem/hs/search?&bikename=${requestScope.bikename}&isrented=未出租">未出租</a>
	    		</div>
	    	</div>
    	</div>
    	<div class="s-result">
    		<c:forEach items="${requestScope.bikeRentList}" var="bikeRent">
    			<div class="result-item">
    				<div class="img-item"><img alt="${bikeRent.bikeName}" src="${bikeRent.imgPath}" ></div>
    				<div class="price-item">
    					<div class="price"><span class="span1">￥</span><strong>${bikeRent.dayPrice}</strong><span class="span2">日租金</span></div>
    					<div class="choose-count">${hotBike.rentCount}人已选择</div>
    				</div>
    				<div class="goods-title-item">
    					<a href="/bikesystem/hs/bikerent?shopname=${bikeRent.shopName}&bikename=${bikeRent.bikeName}&brid=${bikeRent.brid}" ><span>${bikeRent.bikeName}</span></a>
    					<span class="span3">${bikeRent.isRented}</span>
        			</div>
    				<div class="shop-item">
    				<a href="/bikesystem/hs/shop?shopname=${bikeRent.shopName}" class="shopname">
    					<span class="dsrs">
	            			<span class="dsr equalthan"></span>
	           				<span class="dsr equalthan"></span>
	            			<span class="dsr equalthan"></span>
	        			</span>
    				<span>${bikeRent.shopName}</span>
    				</a></div>
    			</div>
    		</c:forEach>
    	</div>
    	
    </div>
    <!-- 页脚 -->
    <div class="footer">
    	
    </div>
    <script type="text/javascript" src="js/hs/searchBikes.js"></script>
  </body>
</html>
