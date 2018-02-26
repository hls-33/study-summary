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
    
    <title>My JSP 'insertBikeDestroy.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="/bikesystem/css/hgg/basestyle.css" rel="stylesheet" type="text/css">
	<link href="/bikesystem/css/hgg/insertbikedestroystyle.css" rel="stylesheet" type="text/css">
	
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
		  					<div class="function_div">
		  						<span class="one_font">&nbsp;&nbsp;&nbsp;租赁管理</span>
		  					</div>
		  					<div>
		  						<table>
		  							<tr>
		  								<td class="two_font">
		  									<a href="/bikesystem/hgg/querybike">查看自行车</a>
		  								</td>
		  								<td class="two_font">
		  									<a href="/bikesystem/hgg/queryuserrent">用户租借信息</a>
		  								</td>
		  							</tr>
		  						</table>
		  					</div>
		  					
		  				</li>
		  				<li>
		  					<div class="function_div">
		  						<span class="one_font">&nbsp;&nbsp;&nbsp;申购管理</span>
		  					</div>
		  					<ul>
		  						<li class="two_font">
		  							<a href="/bikesystem/hgg/showinsertbike">宝贝入库</a>
		  						</li>
		  					</ul>
		  					
		  				</li>
		  				<li>
		  					<div class="function_div">
		  						<span class="one_font">&nbsp;&nbsp;&nbsp;报废管理</span>
		  					</div>
		  					<ul>
		  						<li class="two_font">
		  							<span style="color:#FF4700">宝贝报废</span>
		  						</li>
		  					</ul>
		  				</li>
	  				</ul>
	  			</div>
	  		</div>
	  		<div class="content_div">
	  			
	  			<c:forEach items="${requestScope.allbikerent}" var="bike">
	  				
	  				<div class="good_div">
	  					<div class="content_tittle_div">
		  					<div class="bikenumber_div">
		  						<input type="checkbox" name="destroybox">
		  						
		  						<span style="font:14px 黑体;color:#3C3C3C;">
		  							车牌号:${bike.bikeNumber}
		  						</span>
		  					</div>
		  					<div class="destroy_div">
		  						<img src="/bikesystem/image/hgg/QQ图片20170505180422.png" class="destroy_img">
		  					</div>
	  					</div>
	  					<table class="content">
	  						<tr>
	  							<td>
	  								<img src="${bike.imgPath}" style="float:left;width:80px;height:80px;">
	  								<div class="gooddescription">
	  									<span>${bike.bikeName}</span><span class="bnumber">${bike.bikeNumber }</span>
	  									<br>
	  									<span>${bike.color}&nbsp;&nbsp;${bike.kindName}</span>
	  								</div>
	  								
	  							</td>
	  							<td>
	  								${bike.hourPrice}
	  							</td>
	  							<td>
	  								${bike.dayPrice}
	  							</td>
	  							<td>
	  								${bike.isRented }
	  							</td>
	  							<td>
	  								${bike.bikedeposit}
	  							</td>
	  						</tr>
	  						
	  					</table>
	  				</div>
	  				<br>
	  			</c:forEach>
	 			<button id="destroybut">批量报废</button>
	   		</div>
	  </div>
	  <!-- 模态窗口 -->
	  <div id="model_div">
	  	
	  </div>
	  <div id="model_content_div">
	  	<div>您确定要报废该自行车吗？</div>
	  	<div>没有做垃圾箱哦！报废了就找不回来了</div>
	  	<div id="button_div">
	  		<input type="button" value="确定">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="关闭">
	  	</div>
	  </div>
	  <script src="/bikesystem/js/hgg/jquery-3.2.0.js"></script>
	  <script>
	  	
	  	/*鼠标移动/移出 到信息显示div上  显示/隐藏 删除按钮图片*/
	  	$(".good_div").hover(function(){
	  		$(this).children().children().next().css("opacity","1");
	  	});
	  	$(".good_div").mouseleave(function(){
	  		$(this).children().children().next().css("opacity","0");
	  	});
	  	/*
	  		点击批量报废
	  	*/
	  	$("#destroybut").click(function(){
	  		
	  		var checks=document.getElementsByName("destroybox");
	  		var bikenumbers=new Array();
	  		var index=0;
	  		for(var i=0;i<checks.length;i++){
	  			if(checks[i].checked){
	  		 	var bikenumber=$(checks[i]).parent().parent().next().find(".bnumber").html();
	  		 	bikenumbers[index]=bikenumber;
	  		 	index++;
	  			}
	  		}
	  		var bikenumberstr="";
	  		for(var i=0;i<bikenumbers.length;i++){
	  			bikenumberstr+=bikenumbers[i];
	  			bikenumberstr+="-";
	  		}
	  		
	  		$.ajax({
	  			url:"/bikesystem/hgg/insertbikedestroy",
	  		 	type:"post",
	  		 	data:{"bikenumber":bikenumberstr},
	  			 datatype:"String",
	  			 success:function(resultstr){
	  		 		if(resultstr=="true"){
	  		 			for(var i=0;i<checks.length;i++){
	  		 				if(checks[i].checked){
		  		 				
		  		 				$(checks[i]).parent().parent().parent().remove();
		  		 			}
	  		 			}
	  		 		}
	  		 	}
	  		 })
	  	})
	  	<!-- 保存当前点击区域的bikenumber -->
	  	var current_content=null;
	  	<!-- 保存该行 -->
	  	var trnode=null;
	  	/*点击删除图片*/
	  	$(".destroy_img").click(function(){
	  		$("#model_div").css("display","block");
	  		$("#model_content_div").css("display","block");
	  		current_content=$(this).parent().parent().next().find(".bnumber").html();
	  		trnode=$(this).parent().parent().parent();
	  	})
	  	/*模态窗口“确定”按钮*/
	  	$("input[value='确定']").click(function(){
	  		$.ajax({
	  			url:"/bikesystem/hgg/insertbikedestroy",
	  			type:"post",
	  			data:{"bikenumber":current_content},
	  			datatype:"String",
	  			success:function(result){
	  				if(result=="true"){
	  					$(trnode).remove();
	  					$("#model_div").css("display","none");
	  					$("#model_content_div").css("display","none");
	  				}
	  			}
	  		})
	  	})
	  	/*模态窗口“关闭”按钮*/
	  	$("input[value='关闭']").click(function(){
	  		$("#model_div").css("display","none");
	  		$("#model_content_div").css("display","none");
	  	})
	  </script>
  </body>
</html>