<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'searchBikeSell.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">


  <link rel="stylesheet" type="text/css" href="css/hp/searchBikes.css" >
	<!-- js文件 -->
	<script type="text/javascript" src=""></script>
	<!-- jqeury库和bootstrap库 -->
	<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
 	<script type="text/javascript" src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  	<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
  </head>
  
  <body>
  	<!-- 导航栏 -->
    <div class="nav">
    	<jsp:include page="navigation.jsp"></jsp:include>
    </div>
    <div class="header-wraper">
    	<div class="logo"><a href="/bikesystem/index.jsp"><img alt="小芳自行车" src="/bikesystem/image/hs/bikelogo.png" ></a></div>
    	<div class="search">
    		<form action="hp/search" method="post" >
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
    <div class="main" id="main-top">
   		<div id="mainsrp-nav">
   			<div class="crumb">
    			<span>所有分类 &nbsp; &gt;</span>
    			<span class="total">共<span class="h">${requestScope.bikeRentList.size()}</span>款相关产品</span>
	    	</div>
	    	<div class="m-nav">
	    		<div class="group">
		    		<span class="nav-title">赛车类型：</span>
		    		<c:forEach items="${requestScope.bikeKindsList}" var="bikekind">
		    			<a class="nav-text" href="/bikesystem/hp/search?&bikename=${requestScope.bikename}&kindname=${bikekind.kindName}">${bikekind.kindName}</a>
		    		</c:forEach>
	    		</div>
	    		<div class="group">
		    		<span class="nav-title">颜色：</span>
		    		<a class="nav-text" href="/bikesystem/hp/search?&bikename=${requestScope.bikename}&color=红色">红色</a>
	    			<a class="nav-text" href="/bikesystem/hp/search?&bikename=${requestScope.bikename}&color=蓝色">蓝色</a>
	    			<a class="nav-text" href="/bikesystem/hp/search?&bikename=${requestScope.bikename}&color=白色">白色</a>
	    			<a class="nav-text" href="/bikesystem/hp/search?&bikename=${requestScope.bikename}&color=黑色">黑色</a>
	    			<a class="nav-text" href="/bikesystem/hp/search?&bikename=${requestScope.bikename}&color=黄色">黄色</a>
	    		</div>
	    		<div class="group">
		    		<span class="nav-title">价格￥：</span>
		    		<a class="nav-text" href="/bikesystem/hp/search?&bikename=${requestScope.bikename}&bikeprice=500~800">500~800</a>
	    			<a class="nav-text" href="/bikesystem/hp/search?&bikename=${requestScope.bikename}&bikeprice=800~1000">800~1000</a>
	    			<a class="nav-text" href="/bikesystem/hp/search?&bikename=${requestScope.bikename}&bikeprice=1000~1200">1000~1200</a>
	    			<a class="nav-text" href="/bikesystem/hp/search?&bikename=${requestScope.bikename}&bikeprice=1200~100000">1200以上</a>
	    		</div>
	    	</div>
    	</div>
    	<div class="s-result">
    		<c:forEach items="${requestScope.bikeSellList}" var="bikeSell">
    			<div class="result-item">
    				<div class="img-item"><img alt="${bikeSell.bikeName}" src="${bikeSell.imgPath}" ></div>
    				<div class="price-item">
    					<div class="price"><span class="span1">￥</span><strong>${bikeSell.bikePrice}</strong><span class="span2">价格</span></div>
    					<div class="choose-count">${hotBike.sellCount}人已选择</div>
    				</div>
    				<div class="goods-title-item">
    					<a href="/bikesystem/hp/bikesell?shopname=${bikeSell.shopName}&bikename=${bikeSell.bikeName}" ><span>${bikeSell.bikeName}</span></a>
    					<span class="span3">${bikeSell.sellCount}</span>
        			</div>
    				<div class="shop-item">
    				<a href="/bikesystem/hs/shop?shopname=${bikeSell.shopName}" class="shopname">
    					<span class="dsrs">
	            			<span class="dsr equalthan"></span>
	           				<span class="dsr equalthan"></span>
	            			<span class="dsr equalthan"></span>
	        			</span>
    				<span>${bikeSell.shopName}</span>
    				</a></div>
    			</div>
    		</c:forEach>
    	</div>
    	
    </div>
    <!-- 页脚 -->
    <div class="footer">
    	
    </div>
    <script type="text/javascript" src="js/hp/searchBikes.js"></script>
  </body>
</html>
