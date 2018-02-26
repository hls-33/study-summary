<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'imagecolor.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<style type="text/css">
				#color-span1{
						width:120px;	
						height:60px;
						border:1px solid #F2F2F2;	
				}
				img{
						padding:5px;
						width:30px;	
						height:30px;
						border:1px solid #E5DDDD;	
						cursor:pointer;
				}
				img:hover{
						border:1px solid red;
				}
				li{
						list-style-type: none;
						color:black;
				}		
				.second{
						width:40px;
						height:30px;	
						display:none;
						line-height:30px;
						font-weight:bold;
						
				}		
				.second>span:hover{
						color:black;
						
				}			
				.first>span:hover>.second{
						display:block;
					}
					
				.first span:nth-of-type(1) .second{
						position:absolute;
						left:665px;
						top:420px;
				}	
					.first span:nth-of-type(2) .second{
						position:absolute;
						left:715px;
						top:420px;
				}	.first span:nth-of-type(3) .second{
						position:absolute;
						left:765px;
						top:420px;
				}
				.chosecolor span{
						font-size:18px;
						font-weight:bold;
						
				}
					
		</style>

<script language="javascript" type="text/javascript" src="/bikesystem/js/hp/jquery-3.2.0.js"></script>

  </head>
  
  <body>

					<div class="first">
							<c:forEach items="${requestScope.bikeSellList}" var="bikeSell">
									<span id="color-span1">
												<img alt="${bikeSell.bikeName}" src="${bikeSell.imgPath}" />
												<ul class="second">
														<li>${bikeSell.color }</li>
												</ul>
									</span>
							</c:forEach><br><br>
							<p class = "chosecolor" style="font-size:15px;margin-left:-150px;color:black;">选择的颜色为：<span></span></p>
					</div>
		<script type="text/javascript">
					$(function(){
							var one = false;
							$(".first #color-span1:nth-of-type(1)").click(function(){
									$(".first #color-span1:nth-of-type(1)  img").css({"border":"2px solid red"});
									var color=$(".first #color-span1:nth-of-type(1) .second li").html();
									var src =$(".first #color-span1:nth-of-type(1)  img")[0].src;
									$("#img").removeAttr("src"); 
									$("#img").attr("src",src);
									$(".chosecolor span").empty(); 
									$(".chosecolor span").append(color);
									one=true;
									if(one){
											$(".first #color-span1:nth-of-type(2)  img").css({"border":"none",});
											$(".first #color-span1:nth-of-type(3)  img").css({"border":"none",});
											$(".first #color-span1:nth-of-type(4)  img").css({"border":"none",});
											$(".first #color-span1:nth-of-type(5)  img").css({"border":"none",});
										}
							});

							$(".first #color-span1:nth-of-type(2)").click(function(){
									$(".first #color-span1:nth-of-type(2)  img").css({"border":"2px solid red"});
									var color=$(".first #color-span1:nth-of-type(2) .second li").html();
									var src =$(".first #color-span1:nth-of-type(2)  img")[0].src;
									$("#img").removeAttr("src"); 
									$("#img").attr("src",src);
									$(".chosecolor span").empty(); 
									$(" .chosecolor span").append(color);
									one=true;
									if(one){
											$(".first #color-span1:nth-of-type(1)  img").css({"border":"none",});
											$(".first #color-span1:nth-of-type(3)  img").css({"border":"none",});
											$(".first #color-span1:nth-of-type(4)  img").css({"border":"none",});
											$(".first #color-span1:nth-of-type(5)  img").css({"border":"none",});
										}
							});
							
						$(".first #color-span1:nth-of-type(3)").click(function(){
									$(".first #color-span1:nth-of-type(3)  img").css({"border":"2px solid red"});
									var color=$(".first #color-span1:nth-of-type(3) .second li ").html();
									var src =$(".first #color-span1:nth-of-type(3)  img")[0].src;
									$("#img").removeAttr("src"); 
									$("#img").attr("src",src);
									$(".chosecolor span").empty(); 
									$(".chosecolor span").append(color);
									one=true;
									if(one){
											$(".first #color-span1:nth-of-type(1)  img").css({"border":"none",});
											$(".first #color-span1:nth-of-type(2)  img").css({"border":"none",});
											$(".first #color-span1:nth-of-type(4)  img").css({"border":"none",});
											$(".first #color-span1:nth-of-type(5)  img").css({"border":"none",});
										
										}
							});
							
							$(".first #color-span1:nth-of-type(4)").click(function(){
									$(".first #color-span1:nth-of-type(4)  img").css({"border":"2px solid red"});
									var color=$(".first #color-span1:nth-of-type(4) .second li ").html();
									var src =$(".first #color-span1:nth-of-type(4)  img")[0].src;
									$("#img").removeAttr("src"); 
									$("#img").attr("src",src);
									$(".chosecolor span").empty(); 
									$(".chosecolor span").append(color);
									one=true;
									if(one){
											$(".first #color-span1:nth-of-type(1)  img").css({"border":"none",});
											$(".first #color-span1:nth-of-type(2)  img").css({"border":"none",});
											$(".first #color-span1:nth-of-type(3)  img").css({"border":"none",});
											$(".first #color-span1:nth-of-type(5)  img").css({"border":"none",});
										
										}
							});
							$(".first #color-span1:nth-of-type(5)").click(function(){
									$(".first #color-span1:nth-of-type(5)  img").css({"border":"2px solid red"});
									var color=$(".first #color-span1:nth-of-type(5) .second li ").html();
									var src =$(".first #color-span1:nth-of-type(5)  img")[0].src;
									$("#img").removeAttr("src"); 
									$("#img").attr("src",src);
									$(".chosecolor span").empty(); 
									$(".chosecolor span").append(color);
									one=true;
									if(one){
											$(".first #color-span1:nth-of-type(1)  img").css({"border":"none",});
											$(".first #color-span1:nth-of-type(2)  img").css({"border":"none",});
											$(".first #color-span1:nth-of-type(3)  img").css({"border":"none",});
											$(".first #color-span1:nth-of-type(4)  img").css({"border":"none",});
										
										}
							});
												
					})
		</script>			
					
					
					
					
					
					
					
  </body>
</html>
