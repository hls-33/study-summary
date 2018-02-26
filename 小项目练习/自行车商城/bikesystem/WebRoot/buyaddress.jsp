<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'buyaddress.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script language="javascript" type="text/javascript" src="/bikesystem/js/hp/jquery-3.2.0.js"></script>
<style type="text/css">
		li{
				list-style-type:none;
				margin:10px;
		}
		li input{
				width:240px;
				height:30px;
				
		}
	ul{
		margin-top:100px;
		height:260px;
		width:340px;
		border:1px solid #44C8CE;
		background-color:#369148;
		color:white;
		font-weight:bold;
		box-shadow: 2px 2px 10px #909090;	
	}
	#save {
		width:50px;
		height:50px;
		fony-size:16px;
		background-color:#DD4B28;
		margin-top:-100px;
		color:#E7E8ED;
		font-weight:bold;
		cursor:pointer;
		border:1px solid #E49017;
	}
	
</style>
  </head>
  
  <body><center>
    			<form action="/bikesystem/hp/address" method="post">
    				<ul>
    						<li>省&nbsp;&nbsp;&nbsp;市：<input type="text"  name="city"/></li>
    						<li>详细地址:<input type="text" name="minuteaddress"placeholder="具体到街道"/></li>
    						<li>收货人:&nbsp;&nbsp;<input type="text" name="username"/></li>
    						<li>电话号码:<input type="text" name="phone" placeholder="11位手机号码"/></li>
    				</ul>
    				<div><input type="submit" id="save" value="保存"></div>
    			</form>	
			</center>
  </body>
</html>
