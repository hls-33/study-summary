<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'comment.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	.ShowAllComment{
		width:500px;
		height:600px;
		background-color:gray;
	}
	.showYourComment{
		width:440px;
		height:300px;
		background-color:yellow;
	}
	</style>
	
  </head>
  
  <body>
    <center>
    	<!-- 根据评论类型查看 -->
    	<input type="radio" name="select1" onclick=""/>好评
    	<input type="radio" name="select2" onclick=""/>中评
    	<input type="radio" name="select3" onclick=""/>差评
    	<br>
    	
    	<!-- 显示所有评论 -->
    	<div class="ShowAllComment">
			<%=request.getAttribute("message")%>
    	</div>

  		<!-- 提交评论 -->
    	<br>
    	<form action="/CommentProject/CommentServlet" method="post">
    		
    		<input type="text" name="comment" class="showYourComment"/>
    		<br>
    		<input type="radio" name="select1" onclick=""/>好评
    		<input type="radio" name="select2" onclick=""/>中评
    		<input type="radio" name="select3" onclick=""/>差评
    		<br>
    		
			<!--获取当前时间-->
			<%
			Date commentdate = new Date();
			out.print(commentdate);
			//获取当前用户
			String user=request.getParameter("cid");
			String shopname=request.getParameter("shopname");
			String bikename=request.getParameter("bikename");
			String commentImgPath=request.getParameter("commentImgPath");
			String commentStatus=request.getParameter("commentStatus");
			
			%>
			
			<input type="hidden" name="shopname" value=${requestScope.shopname}/>
			<input type="hidden" name="bikename" value=${requestScope.bikename}/>
			<input type="hidden" name="commentdate" value=${requestScope.commentdate}/>
			<input type="hidden" name="commentImgPath" value=${requestScope.commentImgPath}/>
			<input type="hidden" name="commentStatus" value=${requestScope.commentStatus}/>
    		<input type="submit" name="message" value="提交" />
    		
    		
    	</form>
    	
   	</center>
    
    
  </body>
</html>
