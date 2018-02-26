<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'sellnumber.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script language="javascript" type="text/javascript" src="/bikesystem/js/hp/jquery-3.2.0.js"></script>
	<script type="text/javascript" >
	  				$(document).ready(function(){
											var i=1;
											$("#number-text").val(i);
								$(".main-num-s1").click(function(){
											++i;
											if(i<=1){
															i=2;
											 }
											 if(i>="${requestScope.bikecount-requestScope.sellcount}"){
													i="${requestScope.bikecount-requestScope.sellcount}";
													$("#number-text").val("${requestScope.bikecount-requestScope.sellcount}");
											 }else{
													$("#number-text").val(i);
										 	}

								  });
								 $(".main-num-s2").click(function(){
										 --i;
									 if(i<=1){
												$("#number-text").val(1);
										 }
								 else{
										$("#number-text").val(i);
								 }
					 		 });							  
				});
				/*	
				$("#number-text").onchange('input',function(){  	 		 
						var number = $("input[type='text']").val();
						var price = ${requestScope.bikeprice};
						alert(number);
							$.ajax({
									url:"/user/hp/priceajax",
									type:"POST"	,
									data:{"inputnumber":number,"bikeprice":price},
									success:function(message){
 										var totalprice=message.totalprice
										$(".bottom-sp ul li span").html(totalprice);
										
									}
							})
						}	
					*/	
	  	</script>
<style>
			
#main-center-num{
	height: 35px;
    line-height: 31px;
    color: #878787;

}
#main-center-num span {
	display: inline-block;
    vertical-align: middle;

}

#main-center-num input{
	width:40px;
	height:40px;
}
.main-num-s1,.main-num-s2{
	width: 15px;
    height: 20px;
    overflow: hidden;
    border: 1px solid #a7a6ab;
    display: block;
    font-family: tm-detail-font;
    line-height: 20px;
    font-size: 16px;
    cursor: pointer;
     margin-bottom: 3px;
  
}
		</style>
  </head>
  			
  <body>
    		<div id="main-center-num">
   					<span  class="main-num-s2">&or;</span>
    				<input  name="inputnumber" type="text"  id="number-text" value="" />
			  		<span class="main-num-s1">&and;</span>
			  		&nbsp;件 &nbsp;&nbsp;  &nbsp;
			  		
     	</div>
     	
  
  </body>
</html>
