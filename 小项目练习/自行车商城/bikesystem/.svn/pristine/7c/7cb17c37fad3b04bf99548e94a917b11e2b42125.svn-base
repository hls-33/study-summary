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
	<link rel="stylesheet" type="text/css" href="./css/txz/userloginstyle.css">
  </head>
  <body>
    <jsp:include page="topdiv.jsp"></jsp:include>
    <div id="create-div">
    	<fieldset>
    		<legend>用户注册中心</legend>
    		<form action="/bikesystem/user/userregist" method="post">
	    		<table>
	    			<tr>
	    				<td>手&nbsp;机&nbsp;号</td>
	    				<td><input id="uphone" type="text" name="uphone" placeholder="请输入手机号"/><span id="uphonespan"></span></td>
	    			</tr>
	    			<tr>
	    				<td>姓&nbsp;&nbsp;&nbsp;&nbsp;名</td>
	    				<td><input id="uname" type="text" name="uname" placeholder="请输入姓名"/><span id="unamespan"></span></td>
	    			</tr>
	    			<tr>
	    				<td>&nbsp;用户密码</td>
	    				<td><input id="upassword" type="password" name="upass" placeholder="请设置密码"/><span id="upasswordspan"></span></td>
	    			</tr>
	    			<tr>
	    				<td>&nbsp;确认密码</td>
	    				<td><input id="surepass" type="password" name="usurepass" placeholder="请确认密码"/><span id="surepassspan"></span></td>
	    			</tr>
	    			<tr>
	    				<td>&nbsp;身份证号</td>
	    				<td><input id="uid" type="text" name="idnumber" placeholder="请输入身份证号"/><span id="uidspan"></span></td>
	    			</tr>
	    			<tr>
	    				<td>性&nbsp;&nbsp;&nbsp;&nbsp;别</td>
	    				<td>&nbsp;&nbsp;&nbsp;
	    					<input type="radio" name="personsex" value="女"/>女
	    					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    					<input type="radio" name="personsex" value="男"/>男
	    				</td>
	    			</tr>
	    			<tr>
	    				<td>住&nbsp;&nbsp;&nbsp;&nbsp;址</td>
	    				<td><input id="address" type="text" name="address" placeholder="请输入现行住址"/><span id="addressspan"></span></td>
	    			</tr>
	    			<tr>
	    				<td>邮&nbsp;&nbsp;&nbsp;&nbsp;箱</td>
	    				<td><input id="email" type="text" name="email" placeholder="请输入邮箱"/><span id="emailspan"></span></td>
	    			</tr>
	    		</table>
	    		<br>
	    		<input type="submit" id="regist" value="注册">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	    		<button id="exitregist">取消注册</button><br>
    		</form>
    	</fieldset>
    </div>
     <jsp:include page="bottomdiv.jsp"></jsp:include>
    <script type="text/javascript" src="/bikesystem/js/txz/jquery-3.1.1.min.js"></script>
    
  	<script type="text/javascript" src="/bikesystem/js/txz/indexshow.js"></script>
  	<script type="text/javascript" src="/bikesystem/js/txz/usercreate.js"></script>
  </body>
</html>
