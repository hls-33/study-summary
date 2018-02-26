<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<link    href="/bikesystem/css/hp/marketsell.css" rel="stylesheet" type="text/css"/>
	<script type="text/javascript" src="/bikesystem/js/hp/image.js"></script>
		<style>
				#img{
									display:block;
									width:400px;
									height:370px;
									margin:auto;
									border-right:1px solid #E5DDDD;
					}
					#img_bottom{
									width:400px;
									height:100px;
									margin:auto;
									padding-left:2px;
					}
					#img_bottom >img{
									height:60px;
									width:40px;
									margin:6px;
					}
		</style>
						<img id="img" src="${requestScope.bikeSellList.get(0).imgPath }" onmouseover="over(-1)" onmouseout="out()" />
								<div id="img_bottom">
										<c:set var="index" value="-1" />
									<c:forEach  items="${requestScope.bikeSellList }" var="bikeSellList"  varStatus="st">
												<c:set var="index" value="${index+1}" />
												<img id="img${st.index}" src="${bikeSellList.imgPath}"  onmouseover="over(${index})" onmouseout="out()" />
									</c:forEach>
								</div>		
			<script type="text/javascript">
					var arr =[];
						<c:forEach  items="${requestScope.bikeSellList }" var="bikeSellList" >
								 arr.push("${bikeSellList.imgPath}")
						</c:forEach>
					var cur = 0;
					var before = -1;
					function loop(){
						document.getElementById("img").src = arr[cur%arrnumber];	
						document.getElementById("img"+cur%arrnumber).style.border = "1px solid red";
						if(before != -1){
							document.getElementById("img"+before%arrnumber).style.borderWidth = "0px";
						}
						before = cur;
						cur++;
						var timer = setTimeout("loop()",4000);
					}
					function over(index){
						clearTimeout(timer);
						if(-1 == index)
							return;
						document.getElementById("img").src = arr[index];
						document.getElementById("img"+before%arrnumber).style.borderWidth = "0px";
						document.getElementById("img"+index).style.border = "1px solid red";
						before = index;
						cur = before+1;
					}
					function out(){
						timer = setTimeout("loop()",4000);
					}
			</script>
								
								