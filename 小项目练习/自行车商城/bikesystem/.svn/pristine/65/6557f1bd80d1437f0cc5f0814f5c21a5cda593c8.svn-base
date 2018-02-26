<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'navigation.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<style type="text/css">
			#top_header{
				width: 1366px;
				 height: 35px;
				 background-color:#F2F2F2;
				 margin-bottom:10px;}
			#top_header_left{
					float:left;
					width:400px;
					height: 35px;
					line-height:35px;
					font-size:15px;
					margin-left:100px;
					color:#999999;
					cursor:pointer;
			}
		
			#top_header_right{
					display:block;
					width:400px;
					float:right;
					height: 35px;
					line-height:35px;
					font-size:15px;
					margin-right:100px;
					color:#999999;
					cursor:pointer;
			}
			#top_header_left >span a,#top_header_right >span a{
					color:#999999;
					text-decoration:none;
			}
			#top_header_left >span a:hover,#top_header_right >span a:hover{
					color:#C40000;
					text-decoration:underline;
			}
			
	</style>
	
  </head>
  
  <body>
  <div id="top_header">
	<div id="top_header_left">
			<span>欢迎您的光临</span>&nbsp;	&nbsp;
			<c:if test="${empty sessionScope.user}">				
				<span><a href="/bikesystem/userlogin">请登录</a></span>	&nbsp;&nbsp;	
				<span><a href="/bikesystem/userregist">免费注册</a></span>&nbsp;	
			</c:if>
			<c:if test="${not empty sessionScope.user}">
				<span><a href="javascript:void(0)">${sessionScope.user.name}</a></span>	&nbsp;&nbsp;	
				<span><a href="/bikesystem/user/userexit">注销登录</a></span>	&nbsp;&nbsp;
				<span><a href="/bikesystem/user/userpersonal">个人中心</a></span>&nbsp;	
			</c:if>
	</div>
	
	
	<div  id="top_header_right">
			<span><a href="/bikesystem/user/hs/shoppingcart">购物车</a></span>&nbsp;&nbsp;	
			<span><a href="/bikesystem/user/userpersonal">已买到的宝贝</a></span>&nbsp;&nbsp;	
			<span><a href="/bikesystem/user/userpersonal">已租赁的宝贝</a></span>&nbsp;
			
	</div>
	</div>


  </body>
</html>
