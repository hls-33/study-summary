<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
    
    <title>My JSP 'queryalluserrent.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="/bikesystem/css/hgg/basestyle.css" rel="stylesheet" type="text/css">
	<link href="/bikesystem/css/hgg/queryuserrentstyle.css" rel="stylesheet" type="text/css">
	
  </head>
  
  <body>
	 
	<div class="background_div">
	  		<div class="tittle_div">
	  			<img src="/bikesystem/image/hgg/logo.jpg">
	  			<p>管理中心</p>
	  		</div>
	  		<div class="top_navigation_div">
	  			<ul>
	  				<li>首页</li>
	  				<li>敬请期待</li>
	  				<li>敬请期待</li>
	  				<li>敬请期待</li>
	  			</ul>
	  		</div>
	  		<div class="navigation_div">
	  			<div style="background-color:#F5F5F5;height:40px;border-bottom:1px solid #E0E0E0;line-height:40px;">
	  				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我的应用
	  			</div>
	  			<div class="function_menu_div">
	  				<ul>
		  				<li>
		  					<div>
		  						<span class="one_font">&nbsp;&nbsp;&nbsp;租赁管理</span>
		  					</div>
		  					<div>
		  						<table>
		  							<tr>
		  								<td class="two_font">
		  									<a href="/bikesystem/hgg/querybike">查看自行车</a>
		  								</td>
		  								<td class="two_font">
		  									<span style="color:#FF4700">用户租借信息</span>
		  								</td>
		  							</tr>
		  						</table>
		  					</div>
		  				</li>
		  				<li>
		  					<div>
		  						<span class="one_font">&nbsp;&nbsp;&nbsp;申购管理</span>
		  					</div>
		  					<ul>
		  						<li class="two_font">
		  							<a href="/bikesystem/hgg/showinsertbike">宝贝入库</a>
		  						</li>
		  					</ul>
		  					
		  				</li>
		  				<li>
		  					<div>
		  						<span class="one_font">&nbsp;&nbsp;&nbsp;报废管理</span>
		  					</div>
		  					<ul>
		  						<li class="two_font">
		  							<a href="/bikesystem/hgg/showbikedestroy">宝贝报废</a>
		  						</li>
		  					</ul>
		  				</li>
	  				</ul>
	  			</div>
	  		</div>
	  		<div class="content_div">
	  			
	  			<table id="content_table">
	  				<tr>
	  					<th>用户姓名</th>
	  					<th>车牌号</th>
	  					<th>车名</th>
	  					<th>店名</th>
	  					<th>租车日期</th>
	  					<th>换车日期</th>
	  					<th>押金</th>
	  					<th>租金类型</th>
	  				</tr>
				<c:forEach items="${requestScope.allUserRent }" var="userrent">
					<tr>
						<td>${userrent.name }</td>
						<td>${userrent.bikeNumber }</td>
						<td>${userrent.bikeName }</td>
						<td>${userrent.shopName }</td>
						<td>${userrent.rentDate }</td>
						<td>${userrent.returnDate }</td>
						<td>${userrent.deposit }</td>
						<c:if test="${userrent.rentType=='daymodel'}">
							<td>日租</td>
						</c:if>
						<c:if test="${userrent.rentType=='hourmodel'}">
							<td>时租</td>
						</c:if>
					</tr>
				</c:forEach>
	   			</table>
	   		</div>
	  </div>
	  
  </body>
  
</html>
