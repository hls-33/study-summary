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
    
    <title>My JSP 'bikerentorder.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<link rel="stylesheet" type="text/css" href="css/hs/bikerentorder.css" >
	<link rel="stylesheet" type="text/css" href="css/hs/payqrcode.css" >
	<link rel="stylesheet" type="text/css" href="css/hs/tolocalshop.css" >
	<!-- jqeury库和bootstrap库 -->
	<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
 	<script type="text/javascript" src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
  	<link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css">
  	
  	<!-- bootstrap 日期控件 -->
  	<script type="text/javascript" src="js/hs/bootstrap-datetimepicker.min.js"></script>
  	<link rel="stylesheet" href="css/hs/bootstrap-datetimepicker.min.css">
  	<script type="text/javascript" src="js/hs/locales/bootstrap-datetimepicker.zh-CN.js"></script>
  </head>
  	
  <body>
    <jsp:include page="../hp/navigation.jsp"></jsp:include>
    <div class="header-order" >
    	<div class="malllogo">
    	<a href="index.jsp"><img class="web-logo" src="/bikesystem/image/hgg/logo.jpg"></a>
    	</div>
    	<div class="stepbarbox">
    		<ol class="order-stepbar">
    			<li class="step-first step-item">
    				<div class="step-name">预约商品</div>
    				<div class="step-no"></div>
    			</li>
    			<li class="step-second step-item">
    				<div class="step-name">支付预约押金</div>
    				<div class="step-no">2</div>
    			</li>
    			<li class="step-third step-item">
    				<div class="step-name">到店取车</div>
    				<div class="step-no">3</div>
    			</li>
    			<li class="step-fourth step-item">
    				<div class="step-name">到店还车</div>
    				<div class="step-no">4</div>
    			</li>
    			<li class="step-last step-item">
    				<div class="step-name">评价</div>
    				<div class="step-no">5</div>
    			</li>
    		</ol>
    	</div>
    </div>
    
    <div class="main-container">
    	<c:if test="${requestScope.continaerPage == './confirmorder.jsp' }">
    		<%@ include file="./confirmorder.jsp" %>
    	</c:if>
    	<c:if test="${requestScope.continaerPage == './payqrcode.jsp' }">
    		<%@ include file="./payqrcode.jsp" %>
    	</c:if>
    	<c:if test="${requestScope.continaerPage == './tolocalshop.jsp' }">
    		<%@ include file="./tolocalshop.jsp" %>
    	</c:if>
    	
    	
    	<c:if test="${requestScope.continaerPage == './payerror.jsp' }">
    		<%@ include file="./payerror.jsp" %>
    	</c:if>
    </div>
    
    
    <script type="text/javascript">
    	var brid="${requestScope.newBikeRent.brid}";
    </script>
    <script type="text/javascript" src="js/hs/bikerentorder.js"></script>
  </body>
</html>
