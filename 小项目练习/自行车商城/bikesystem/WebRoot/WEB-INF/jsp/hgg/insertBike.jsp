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
    
    <title>My JSP 'insertBike.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="/bikesystem/css/hgg/basestyle.css" rel="stylesheet" type="text/css">
	<link href="/bikesystem/css/hgg/insertbikestyle.css" rel="stylesheet" type="text/css">
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
		  							<span style="color:#FF4700">宝贝入库</span>
		  						</li>
		  					</ul>
		  					
		  				</li>
		  				<li>
		  					<div class="function_div">
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
	  		
	  			<div id="select_div">
		  			<span style="font:14px 黑体;">商品用途：</span>
		  			<select name="bikekind" id="bikeforwhat">
			  				<option>出租</option>
			  				<option>出售</option>
			  		</select>
			  		
		  		</div>
		  		
		  		<div id="bikeforrent_div">
		  			
		  				<table>
			  				<tr>
			  					<td>车名</td>
			  					<td>
			  						<input type="text" id="bikename" class="one">
			  						<span id="pointout" style="position:absolute;top:28px;color:black;">*</span>
			  						<img src="/bikesystem/image/hgg/QQ图片20170508104545.png" style="position:absolute;top:28px;left:300px;display:none;">
			  					</td>
			  					<td>车身颜色：</td>
			  					<td>
			  						<input type="text" id="color" class="one">
			  						<span style="position:absolute;top:28px;left:728px;color:black">*</span>
			  						<img src="/bikesystem/image/hgg/QQ图片20170508104545.png" style="position:absolute;top:28px;left:728px;display:none;">
			  					</td>
			  				</tr>
			  				<tr>
			  					<td>车型：</td>
			  					<td>
			  						<select id="kindname">
			  							<c:forEach items="${requestScope.bikekind }" var="bikekinds">
			  								<option>${bikekinds.kindName}</option>
			  							</c:forEach>
			  						</select>
			  					</td>
			  					<td>时租金：</td>
			  					<td>
			  						<input type="text" id="hourprice" class="two" >
			  						<span style="position:absolute;top:78px;left:728px;color:black">*</span>
			  						<img src="/bikesystem/image/hgg/QQ图片20170508104545.png" style="position:absolute;top:78px;left:728px;display:none;">
			  					</td>
			  				</tr>
			  				<tr>
			  					<td>日租金：</td>
			  					<td>
			  						<input type="text" id="dayprice" class="two">
			  						<span style="position:absolute;top:134px;left:300px;color:black">*</span>
			  						<img src="/bikesystem/image/hgg/QQ图片20170508104545.png" style="position:absolute;top:134px;left:300px;display:none;">
			  					<td>押金：</td>
			  					<td>
			  						<input type="text" id="bikedeposit" class="two">
			  						<span style="position:absolute;top:134px;left:728px;color:black">*</span>
			  						<img src="/bikesystem/image/hgg/QQ图片20170508104545.png" style="position:absolute;top:134px;left:728px;display:none;">
			  					</td>
			  				</tr>
			  				<tr>
			  					
			  					<td>上传图片：</td>
			  					<td>
			  						<input type="file" id="imgpath">
			  					</td>
			  					<td></td>
			  					<td></td>
			  				</tr>
		  				</table>
		  				<input type="submit" value="入库" id="insertbr">
		  			
	  			</div>
	  			<div id="bikeforsell_div">
		  				<table>
			  				<tr>
			  					<td>车名：</td>
			  					<td>
			  						<input type="text" id="bikesellname" class="one">
			  						<span style="position:absolute;left:300px;top:28px;color:black">*</span>
			  						<img src="/bikesystem/image/hgg/QQ图片20170508104545.png" style="display:none;position:absolute;left:300px;top:28px;">
			  					</td>
			  					<td>车辆数量：</td>
			  					<td>
			  						<input type="text" id="bikecount" class="two">
			  						<span style="position:absolute;left:672px;top:28px;color:black">*</span>
			  						<img src="/bikesystem/image/hgg/QQ图片20170508104545.png" style="display:none;position:absolute;left:672px;top:28px;">
			  					</td>
			  				</tr>
			  				<tr>
			  					<td>车身颜色：</td>
			  					<td>
			  						<input type="text" id="bikesellcolor" class="one">
			  						<span style="position:absolute;left:300px;top:80px;color:black">*</span>
			  						<img src="/bikesystem/image/hgg/QQ图片20170508104545.png" style="display:none;position:absolute;left:300px;top:80px;">
			  					</td>
			  					<td>车型：</td>
			  					<td>
			  						<select id="kindsellname">
			  							<c:forEach items="${requestScope.bikekind }" var="bikekinds">
			  								<option>${bikekinds.kindName}</option>
			  							</c:forEach>
			  						</select>
			  						<span style="position:absolute;left:672px;top:80px;color:black">*</span>
			  					</td>
			  				</tr>
			  				<tr>
			  					<td>售价：</td>
			  					<td>
			  						<input type="text" id="bikeprice" class="two">
			  						<span style="position:absolute;left:300px;top:132px;color:black">*</span>
			  						<img src="/bikesystem/image/hgg/QQ图片20170508104545.png" style="display:none;position:absolute;left:300px;top:132px;">
			  					</td>
			  					<td>上传图片：</td>
			  					<td>
			  					
			  							<input type="file" id="bikesellimgpath">
			  						
			  					</td>
			  				</tr>
			  				<tr>
			  					<td valign="top">商品标题：</td>
			  					<td>
			  						<textarea id="headinfo" maxlength="50" placeholder="请输入商品标题，50字以内" class="one"></textarea>
			  						<span style="position:absolute;left:300px;top:184px;color:black">*</span>
			  						<img src="/bikesystem/image/hgg/QQ图片20170508104545.png" style="display:none;position:absolute;left:300px;top:234px;">
			  					</td>
			  					<td valign="top">商品描述：</td>
			  					<td>
			  						<textarea id="subheadinfo" maxlength="50" placeholder="请输入商品标题，50字以内" class="one"></textarea>
			  						<span style="position:absolute;left:672px;top:184px;color:black">*</span>
			  						<img src="/bikesystem/image/hgg/QQ图片20170508104545.png" style="display:none;position:absolute;left:672px;top:234px;">
			  					</td>
			  				</tr>
		  				</table>
		  				<input type="submit" value="入库" id="insertbs">
		  			
	  			</div>
	  			
	  			<div id="model_div">
	  				<div id="modelcontent_div">
	  					<span>添加成功</span><br>
	  					<a href="/bikesystem/hgg/showinsertbike">继续添加</a>
	  					<a href="/bikesystem/hgg/querybike">不了，谢谢</a>
	  				</div>
	  			</div>
	   		</div>
	  </div>
	<script type="text/javascript" src="/bikesystem/js/hgg/jquery-3.2.0.js"></script>
	<script>
		//为select设置nochange事件
		$("#bikeforwhat").change(function(){
			var selectval=$("#bikeforwhat").val();
			if(selectval=="出售"){
				$("#bikeforsell_div").css("display","block");
				$("#bikeforrent_div").css("display","none");
			}
			if(selectval=="出租"){
				$("#bikeforsell_div").css("display","none");
				$("#bikeforrent_div").css("display","block");
			}
		})
		/*为输入框设置blur事件*/
		$("#bikenumber").blur(function(){
			var bikenumber=$(this).val();
			var regex=/^bk[a-z0-9]*rent[\d]{5}/;
			if(regex.test(bikenumber)){
				$(this).next().next().css("display","block");
			}
			if(!regex.test(bikenumber)){
				$(this).next().css("color","red");
				$(this).next().html("格式不对");
			}
			if(bikenumber==""){
				$(this).next().html("不能为空");
				$(this).next().css("color","red");
			}
		})
		//为需要输入纯数字的输入框设置正则
		$(".two").blur(function(){
			var value=$(this).val();
			var regex=/^[1-9]\d*$/;
			if(value==""){
				$(this).next().html("不能为空");
				$(this).next().css("color","red");
			}
			if(!value==""&regex.test(value)){
				$(this).next().next().css("display","block");
				$(this).next().html("");
			}
			if(!value==""&!regex.test(value)){
				$(this).next().css("color","red");
				$(this).next().html("格式不对");
			}
		})
		//纯数字输入框focus事件
		$(".two").focus(function(){
			$(this).next().html("");
			$(this).next().next().css("display","none");
		})
		//为输入框设置focus事件
		$("#bikenumber").focus(function(){
			$(this).next().next().css("display","none");
			$(this).next().html("");
		})
		
		$(".one").blur(function(){
			var inputcontent=$(this).val();
			if(!inputcontent==""){
				$(this).next().next().css("display","block");
			}
			if(inputcontent==""){
				$(this).next().html("不能为空");
				$(this).next().css("color","red");
			}
		})
		
		$(".one").focus(function(){
			$(this).next().html("");
			$(this).next().next().css("display","none");
		})
		
		
		
		$("[type=submit]").click(function(){
			alert("111")
			/*获取各个输入框中的值*/
			//forrent 
			var bikenumber=$("#bikenumber").val();
			var bikename=$("#bikename").val();
			var color=$("#color").val();
			var kindname=$("#kindname").val();
			var dayprice=$("#dayprice").val();
			var hourprice=$("#hourprice").val();
			var bikedeposit=$("#bikedeposit").val();
			var imgpath=$("#imgpath").val();
			//forsell
			var bikesellname=$("#bikesellname").val();
			var bikecount=$("#bikecount").val();
			var bikesellcolor=$("#bikesellcolor").val();
			var kindsellname=$("#kindsellname").val();
			var bikeprice=$("#bikeprice").val();
			var bikesellimgpath=$("#bikesellimgpath").val();
			var goodtittle=$("#headinfo").val();
			var gooddescription=$("#subheadinfo").val();
			
			alert(bikenumber+"-"+bikename+"-"+color+"-"+kindname+"-"+
				dayprice+"-"+hourprice+"-"+bikedeposit+"-"+imgpath+"-")
			if(bikenumber!=""&bikename!=""&color!=""&kindname!=""&
				dayprice!=""&hourprice!=""&bikedeposit!=""&imgpath!=""){
				
				$.ajax({
					url:"/bikesystem/hgg/insertbike",
					type:"post",
					data:{
						"bikeforwhat":$("#bikeforwhat").val(),
						"bikenumber":bikenumber,
						"bikename":bikename,
						"color":color,
						"kindname":kindname,
						"hourprice":hourprice,
						"dayprice":dayprice,
						"bikedeposit":bikedeposit,
						"imgpath":imgpath,
					},
					datatype:"String",
					success:function(result){
						if(result=="true"){
							$("#select_div").css("display","none");
							$("#bikeforrent_div").css("display","none");
							$("#bikeforsell_div").css("display","none");
							$("#model_div").css("display","block");
							
						}
					}
				})
			}
			
			alert(bikesellname+"-"+bikecount+"-"+bikesellcolor+"-"+kindsellname+"-"+
				bikeprice+"-"+bikesellimgpath+"-"+goodtittle+"-"+gooddescription+"-")
			if(bikesellname!=""&bikecount!=""&bikesellcolor!=""&kindsellname!=""&
					bikeprice!=""&bikesellimgpath!=""&goodtittle!=""&gooddescription!=""){
				
				$.ajax({
					url:"/bikesystem/hgg/insertbike",
					type:"post",
					data:{
						"bikeforwhat":$("#bikeforwhat").val(),
						"bikesellimgpath":bikesellimgpath,
						"bikesellcolor":bikesellcolor,
						"bikesellname":bikesellname,
						"bikecount":bikecount,
						"bikeprice":bikeprice,
						"kindsellname":kindsellname,
						"bikeheadinfo":goodtittle,
						"bikesubheadinfo":gooddescription,
					},
					datatype:"String",
					success:function(result){
						if(result=="true"){
							$("#select_div").css("display","none");
							$("#bikeforrent_div").css("display","none");
							$("#bikeforsell_div").css("display","none");
							$("#model_div").css("display","block");
						}
					}
				})
			}
		})
	</script>
	</body>
</html>
