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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="./css/txz/loginstyle.css"/>
  </head>
  
  <body>
  	<jsp:include page="/jsp/topdiv.jsp"></jsp:include>
    <div id="middle-div"><img src="./image/txz/bike.jpg"/>
    	<div id="login-div">
    		<form action="/bikesystem/userlogin" method="post">
    			<p><img src="./image/txz/user.png"/><input type="text" name="username" placeholder="请输入用户名"/><span id="contentid" class="content"></span></p>
    			<p><img src="./image/txz/lock.png"/><input type="password" name="password" placeholder="请输入密码"/><span id="contentpass" class="content"></span></p>
    			<p>验证码:<input type="text" placeholder="请输入验证码" name="check"/>
    				<span id="contentck" class="contentck">
    					<img id="flushimg" src="/bikesystem/showchk" style="width:135px; height:40px;"/>
    				</span>
    			</p>
    			<span id="checkspan" ><%Object str=request.getAttribute("usererror");
    				if(str!=null)
    					out.write(str.toString());
    			 %></span>
    			<p><input type="submit" value="登录"/></p>
    			<p><input type="checkbox" name="loginstatus" value="selflogin"/><span>自动登录</span>&nbsp;&nbsp;
    				<a id="wrong">忘记密码?</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="/bikesystem/jsp/usercreate.jsp">免费注册</a></p>
    		</form>
    	</div>
    	<div id="losspassword">
    		<div id="closeimg">X</div>
	   		<br><br><br><br>
	   		<p>输入预留手机号</p><input id="tele" type="text" placeholder="">
	   		<button id="sure">提交</button>
	   		<div id="getphone"></div>
   		</div>
    	<div id="return-div">
    		<img src="./image/txz/return.png"><br>
    		<a href="/bikesystem/index.jsp">返回首页</a>
    	</div>
    </div>
    <jsp:include page="/jsp/bottomdiv.jsp"></jsp:include>
    <script type="text/javascript" src="/bikesystem/js/txz/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="/bikesystem/js/txz/userlogin.js"></script>
  </body>
</html>
