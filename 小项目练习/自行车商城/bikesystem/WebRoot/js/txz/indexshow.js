/*自行车分类简介处鼠标移入对应的简介出现，移开后隐藏*/
$(".bikeinfo").hide();
$("#bike-info li").mouseover(function(){
	$(".bikeinfo").hide();
	$(this).children().show();	
});
$("#bike-info li").mouseleave(function(){
	$(".bikeinfo").hide();
});

/*点击进入登陆与注册页面*/
$("#login").click(function(){
	location.href="/bikesystem/jsp/userlogins.jsp";
});
$("#create").click(function(){
	location.href="/bikesystem/jsp/usercreate.jsp";
});
$("#exit").click(function(){
	location.href="/bikesystem/user/userexit";
});


/*自行车种类及简介显示*/
$.ajax({
	url:"/bikesystem/allbikekind",
	type:"post",
	dataType:"json",
	success:function(message){
		$("#bike-info").html("");
		for(var i=0;i<message.length;i++){
			var str="<li>" +message[i].kindName+
					"<div class='bikeinfo' style='display:none'>";
			str+="<p class='introp'><img src='/bikesystem/image/txz/sbike.jpg'>自行车简介</p>";
			str+=message[i].bkInformation;
			str+="</div></li>";
			$("#bike-info").append($(str));
		}
	}
});
$("#bike-info").on("mouseover","li",function(){
	$(this).children().css("display","inline-block");
});
$("#bike-info").on("mouseout","li",function(){
	$(this).children().css("display","none");
});

/*店铺信息显示（默认情况下显示）*/

$.ajax({
	url:"/bikesystem/showinformation",
	type:"post",
	data:{"content":""},
	dataType:"json",
	success:function(message){
		$("#shopshow").html("");
		for(var i=0;i<message.length;i++){
			var str="<div class='shopinfo' id='shop'>";
			str+="<img  src='"+message[i].imagePath+"'>";
			str+="店铺名："+"<a href='/bikesystem/hs/shop?shopname="+message[i].shopname+"'>"+message[i].shopname+"</a>";
			str+="</div>";
			$("#shopshow").append($(str));
		}
	}
});
/*店铺显示*/
$("#chose-div ul li:nth-of-type(1)").click(function(){
	var str=$(this).html();
	$.ajax({
		url:"/bikesystem/showinformation",
		type:"post",
		data:{"content":str},
		dataType:"json",
		success:function(message){
			$("#shopshow").html("");
			if(message.length==0){
				$("#shopshow").html("没有搜索到相关的信息");
			}
			else{
				for(var i=0;i<message.length;i++){
					var str="<div class='shopinfo' id='shop'>";
					str+="<img  src='"+message[i].imagePath+"'>";
					str+="店铺名："+"<a href='/bikesystem/hs/shop?shopname="+message[i].shopname+"'>"+message[i].shopname+"</a>";
					str+="</div>";
					$("#shopshow").append($(str));
				}
			}
		}
	});
});
/*双击对应的店铺图标，进入店铺*/
$("#shopshow").on("dblclick","#shop img",function(){
	var shopname=$(this).next().html();
	location.href="/bikesystem/hs/shop?shopname="+shopname;
});

/*可购买自行车显示*/
$("#chose-div ul li:nth-of-type(2)").click(function(){
	var str=$(this).html();
	$.ajax({
		url:"/bikesystem/querybikesellinfo",
		type:"post",
		data:{"content":str},
		dataType:"json",
		success:function(message){
			$("#shopshow").html("");
			for(var i=0;i<message.length;i++){
				var str="<div class='shopinfo' id='willbuybike'>";
				str+="<img  src='"+message[i].imgPath+"'>";
				str+="自行车名："+"<a href='/bikesystem/hp/bikesell?shopname="+message[i].shopName+"&bikename="+message[i].bikeName+"'>"+message[i].bikeName+"</a>";
				str+="<br>店铺名：<a>"+message[i].shopName+"</a>";
				str+="<br>售价：￥"+message[i].bikePrice;
				str+="</div>";
				$("#shopshow").append($(str));
			}
		}
	});
});

/*双击对应的店铺图标，进入自行车购买信息*/
$("#shopshow").on("dblclick","#willbuybike img",function(){
	var bikename=$(this).next().html();
	var shopname=$(this).next().next().next().html();
	location.href="/bikesystem/hp/bikesell?shopname="+shopname+"&bikename="+bikename;
});

/*可租自行车显示*/
$("#chose-div ul li:nth-of-type(3)").click(function(){
	var str=$(this).html();
	$.ajax({
		url:"/bikesystem/querybikerentinfo",
		type:"post",
		data:{"content":str},
		dataType:"json",
		success:function(message){
			$("#shopshow").html("");
			for(var i=0;i<message.length;i++){
				var str="<div class='shopinfo' id='willrentbike'>";
				str+="<img  src='"+message[i].imgPath+"'>";
				str+="自行车名："+"<a href='/bikesystem/hs/bikerent?shopname="+message[i].shopName+"&bikename="+message[i].bikeName+"'>"+message[i].bikeName+"</a>";
				str+="<br>店铺名："+"<a>"+message[i].shopName+"</a>";
				str+="<br>日租金：￥"+message[i].dayPrice;
				str+="</div>";
				$("#shopshow").append($(str));
			}
		}
	});
});
$("#shopshow").on("dblclick","#willrentbike img",function(){
	var bikename=$(this).next().html();
	var shopname=$(this).next().next().next().html();
	location.href="/bikesystem/hs/bikerent?shopname="+shopname+"&bikename="+bikename;
});

/*点击自行车分类中的自行车类型信息显示进入*/
function getBikeType(){
	var sel=null;
	var objs=$("#list-div input[type='radio']");
	for(var i=0;i<objs.length;i++){
		if(objs[i].checked){
			sel=objs[i].value;
			break;
		}
	}
	return sel;
}
$("#bike-info").on("click","li",function(){
	var str=$(this).html();
	var sel=getBikeType();
	var s=str.substring(0, str.indexOf("<"));
	if(sel=="租借")
		location.href="/bikesystem/hs/search?kindname="+s;
	else if(sel=="购买")
		location.href="/bikesystem/hp/search?kindname="+s;
})























