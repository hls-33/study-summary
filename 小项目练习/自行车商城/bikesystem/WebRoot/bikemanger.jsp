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
	<link rel="stylesheet" type="text/css" href="css/txz/bikemangerstyle.css">
  </head>
  
  <body>
    <div id="manger-div">
    	<div id="top-div">
    		欢迎进入自行车租赁销售网
    	</div>
    	<div id="admin">
    		<img src="/bikesystem/image/txz/admin.png"/>
    		<p>卖家</p>
    	</div>
    	<div id="user">
    		<img src="/bikesystem/image/txz/users.png"/>
    		<p>客户</p>
    	</div>
    </div>
     <script type="text/javascript" src="/bikesystem/js/txz/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="/bikesystem/js/txz/rolechose.js"></script>
  </body>
</html>
