<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'marketSell.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language="javascript" type="text/javascript" src="/bikesystem/js/hp/jquery-3.2.0.js"></script>
	<link    href="/bikesystem/css/hp/marketsell.css" rel="stylesheet" type="text/css"/>
	
  </head>
  
  <body>
  	 <jsp:include page="navigation.jsp"></jsp:include>
  		<div id="header" class="tm-chn">
  				<div id="headerCon">
  						<h1 id="mallLogo">
  							<span class="mlogo">
  										<a href="//www.tmall.com/" title="天猫Tmall.com">
  											天猫Tmall.com
  										</a>
  							</span>
  						</h1>
  						<div id="shopExtra">
  								<div class="slogo">
  									<a class="slogo-shopname" href="">
  										<strong>${requestScope.shopname}自行车店铺，欢迎您的到来</strong>
  									</a>
  								</div>
  						</div>
  						<form action="hp/search" method="post" >
  						<div id="input-sou">
  								<input  placeholder="请输入要搜索的词" class="search-input" type="text" name="bikename" ><button  type="submit" class="submit">搜本店</button>
  						</div>
  						</form>
  				</div>		
  		</div>
		<br>
  		<div id="top-bm">
  		<ol>
  			<li><a href="/bikesystem/hs/category">本店所有商品 </a></li><li><a href="/bikesystem/hs/shop">首页</a></li><li>热卖款</li><li>店铺活动</li>
  		</ol>
  		</div>
  		<br><br>
  		<div id="main">
  				<div id="main-left">
						  	<%@ include file="image.jsp"%>	
  				</div>	
 		
	  			<div id="main-center">
	  						<ul>
	  							<li class="main-center-li-f">${requestScope.bikeheadinfo}<br>
	  								<span>${requestScope.bikesubheadinfo}</span>
	  							</li>
	  							<br>
	  							<li>
	  									<div>价格    &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&yen;<span>${requestScope. bikeprice}</span></div><br>
	  							</li>
	  							<br>
	  							<li> <div class="font_size"> 运费  &nbsp; &nbsp; &nbsp;免运费</div>
	  							</li>
	  							<br>
	  							<li class="font_size" style="height:80px;">颜色分类<div><jsp:include page="imagecolor.jsp"></jsp:include></div></li>
	  							<br><br>
	  							<li > 
	  									 <jsp:include page="sellnumber.jsp"></jsp:include>

	  							</li>
	  							<li><div class="buy-now"><a href="javascript:buynow()">立即购买</a></div><div class="shopping-cart"><a href="11">加入购物车</a></div></li><br><br><br>
	  							<br><li class="font_size"><div>服务承诺 &nbsp; &nbsp;正品保证 &nbsp;&nbsp;T2极速退款 &nbsp; &nbsp;七天无理由退换 </div></li>
	  						</ul>
	  			</div>	
  		</div>
  		<div id="bottom">
  			<div id="bottom-left">
  					<div id="bottom-left_tp"><%@ include file="bottomcentertp.jsp"%></div>
  					<div id="bottom-left_bm"><%@ include file="bottomcenterbm.jsp"%></div>
  			</div>
  			<div id="bottom-center">
  				<div id="bottom-center_lt"><a >商品详情</a></div>
  				<div id="bottom-center_rt">累计评价</div>
  			</div>
  		</div>
 <script type="text/javascript" src="js/hp/searchBikes.js"></script>
 	<script type="text/javascript" src="/bikesystem/js/hp/market.js"></script>
 	<script type="text/javascript">
 	
 			function buynow(){
			var color=$(".chosecolor span").html();
			var number=$("#number-text").val();
				if(color!=""){
					window.location.href="/bikesystem/user/hp/buynow?shopname=${requestScope.shopname}"+"&count="+number+"&bikename=${requestScope.bikename}&bikecolor="+color+"&bisd=${requestScope.bisd}";	
				}
				else{
						alert("请自行车颜色选择颜色");
				}
		}
	
 	</script>
  </body>
</html>
