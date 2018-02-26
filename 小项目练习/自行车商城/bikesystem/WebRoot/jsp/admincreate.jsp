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
	<link rel="stylesheet" type="text/css" href="css/txz/aindexstyle.css">
  </head>
  
  <body>
   	<div id="create-div">
   		<span id="total">自行车网络租赁与售卖综合管理系统</span>
   		<form action="/bikesystem/admincreate" method="post">
   		<table>
   			<tr>
   				<td>手&nbsp;机&nbsp;号</td>
   				<td><input type="text" name="aphone" placeholder="请输入手机号码">
   				<span id="aphonespan"></span>
   				</td>
   			</tr>
   			<tr>
   				<td>姓&nbsp;&nbsp;&nbsp;&nbsp;名</td>
   				<td><input type="text" name="aname" placeholder="请输入姓名">
   				<span id="anamespan"></span>
   				</td>
   			</tr>
   			<tr>
   				<td>设置密码</td>
   				<td><input type="password" name="apassword"  placeholder="请设置密码">
   				<span id="apassspan"></span>
   				</td>
   			</tr>
   			<tr>
   				<td>确认密码</td>
   				<td><input type="password"name="asurepass" placeholder="请确认密码">
   				<span id="asurepassspan"></span>
   				</td>
   			</tr>
   			<tr>
   				<td>身份证号</td>
   				<td><input type="text" name="aidnumber" placeholder="请输入身份证号码">
   				<span id="aidnumberspan"></span>
   				</td>
   			</tr>
   			<tr>
   				<th><input type="submit" value="注册"></th>
   				<th><input type="button" value="取消"></th>
   			</tr>
   		</table>
   		</form>
   	</div>
   	<script type="text/javascript" src="/bikesystem/js/txz/jquery-3.1.1.min.js"></script>
    <script type="text/javascript" src="/bikesystem/js/txz/admincreate.js"></script>
  </body>
</html>
