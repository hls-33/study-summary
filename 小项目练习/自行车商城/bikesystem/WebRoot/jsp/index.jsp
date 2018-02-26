<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>自行车网络租赁与售卖综合管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="./css/txz/indexstyle.css">
	
  </head>
  <body>
    <div id="show-div">
    	<div id="list-div">
    		<span>
    			自行车分类简介
    			<p><input type="radio" name="biketype" value="购买">购买
    			&nbsp;&nbsp;<input name="biketype" type="radio" value="租借">租借</p>
    		</span>
    		<ul id="bike-info">
    			
    		</ul>
    	</div>
    	<div id="show-shop-div">
    		<div id="chose-div">
    			<ul>
    				<li>店铺</li>
    				<li>可购自行车</li>
    				<li>可租自行车</li>
    			</ul>
    			<div id="shopshow"></div>
    		</div>
    	</div>
    </div>
    <script type="text/javascript" src="/bikesystem/js/txz/jquery-3.1.1.min.js"></script>
  	<script type="text/javascript" src="/bikesystem/js/txz/indexshow.js"></script>
  	
  </body>
</html>
