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
	<!-- 顶部与底部CSS -->
	<link rel="stylesheet" type="text/css" href="css/txz/indexstyle.css">
	<!-- 中间内容CSS -->
	<link rel="stylesheet" type="text/css" href="css/txz/userindexstyle.css">
  </head>
  
  <body>
     <div id="top-div">
    	<a id="logo" href="/bikesystem/index.jsp">自行车网络租赁与售卖综合管理系统</a>
    	<%
    		Object obj=request.getSession().getAttribute("user");
    		if(obj!=null){
    			String us=obj.toString();
    			String[] str=us.split(":");
    			out.write("<ul id='top-menu-list'><li id='wellogin'>欢迎&nbsp;&nbsp;"+str[2]+"&nbsp;&nbsp;登陆</li><li id='exit'>注销</li><li id='create'>免费注册</li></ul>");
    		}
    		else out.write("<ul id='top-menu-list'><li id='login'>请登陆</li><li id='create'>免费注册</li></ul>");
    	%>
    	<ul id="top-menu-list2">
    		<li><a href="/bikesystem/index.jsp">首页</a></li>
    		<li><a href="/bikesystem/user/userpersonal">个人中心</a></li>
    		<li><a href="/bikesystem/hp/search">购买自行车</a></li>
    		<li><a href="/bikesystem/hs/search">租赁自行车</a></li>
    	</ul>
    </div>
    <script type="text/javascript" src="/bikesystem/js/txz/jquery-3.1.1.min.js"></script>
  	<script type="text/javascript" src="/bikesystem/js/txz/indexshow.js"></script>
  </body>
</html>
