<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<link rel="stylesheet" type="text/css" href="css/txz/aindexstyle.css">
  </head>
  
  <body>
   	<div id="alogin-div">
   		<form action="/bikesystem/adminlogin" method="post">
    			<p><img src="./image/txz/user.png"/> <input type="text" name="adminname" placeholder="请输入手机号"/><span id="contentid" class="content"></span></p>
    			<p><img src="./image/txz/lock.png"/> <input type="password" name="apassword" placeholder="请输入密码"/><span id="contentpass" class="content"></span></p>
    			<p>验证码: <input type="text" placeholder="请输入验证码" name="check"/>
    				<span id="contentck" class="contentck">
    					<img id="flushimg" src="/bikesystem/showchk" style="width:135px; height:40px;"/>
    				</span>
    			</p>
    			<span id="checkspan"></span>
    			<p><input type="submit" value="登录"/></p>
    			<p>
    				<a id="wrongpass">忘记密码?</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="/bikesystem/jsp/admincreate.jsp">免费注册</a>
    			</p>
    		</form>
   	</div>
   	<div id="losspassword">
   		<div id="closeimg">X</div>
   		<br><br><br><br>
   		<p>输入预留手机号</p><input id="tele" type="text" placeholder="">
   		<button id="sure">提交</button>
   		<div id="getphone"></div>
   	</div>
   	<script type="text/javascript" src="/bikesystem/js/txz/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="/bikesystem/js/txz/adminlogin.js"></script>
  </body>
</html>
