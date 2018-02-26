/*获取个人信息*/
/*进入到用户个人页面安全设置信息*/
	window.onload=function(){
		safeset();
	}
	function safeset(){
		$.ajax({
			url:"/bikesystem/queryuserinfo",
			type:"post",
			dataType:"json",
			success:function(message){
				$("#safe").css({"backgroundColor": "rgb(230,230,230)","color":"black"});
				$("#user_info").html("");
				$("#user_info").html("<span>您的基础信息</span>");
				var str="<p>会员名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+message[0].uphone+"</p>";
				if(message[0].email==null||message[0].email==""){
					str+="<p>登录邮箱：您尚未设置登录邮箱 &nbsp;&nbsp;&nbsp;&nbsp;<a id='addemail'>添加邮箱</a></p>";
				}
				else str+="<p>登录邮箱："+message[0].email+"&nbsp;&nbsp;&nbsp;&nbsp;<a id='updateemail'>修改邮箱</a></p>";
				str+="<p>绑定手机："+message[0].uphone+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a id='updateuserphone'>修改手机</a></p>";
				str+="<hr/>";
				str+="<span>您的安全服务</span>";
				str+="<table>";
				if(message[0].idnumber==null||""==message[0].idnumber)
					str+="<tr><td class='nohave'>未设置</td><td>身份认证</td><td class='have'>用于提升账号的安全性和信任级别。认证后的有卖家记录的账号不能修改认证信息。</td><td><a id='addidnumber'>设置</a></td><td id='showid'></td></tr>";
				else 
					str+="<tr><td class='have'>已完成</td><td>身份认证</td><td class='have'>用于提升账号的安全性和信任级别。认证后的有卖家记录的账号不能修改认证信息。</td><td><a id='queryidnumber'>查看</a></td><td id='showid'></td></tr>";
				str+="<tr><td class='have'>已设置</td><td>登录密码</td><td class='have'>安全性高的密码可以使账号更安全。设置一个包含数字和字母，并长度超过8位以上的密码。</td><td><a id='updateuserpassword'>修改</a></td><td id='showpass'></td></tr>";
				str+="<tr><td class='have'>已设置</td><td>绑定手机</td><td class='have'>绑定手机后，您即可享受自行车租赁销售网丰富的手机服务，如手机找回密码等。</td><td><a id='updatephoneuser'>修改</a></td><td id='showpass'></td></tr>";
				str+="</table>";
				str+="<div id='updateinput'></div>";
				$("#user_info").append($(str));
			}
		});
	}
	
	/*账户设置*/
	$("#accountset").slideUp("slow");
	$("#set").click(function(){
		$("#accountset").slideToggle("slow");
	});
	
	
	/*点击有“账户管理”栏的首页*/
	$("#safeli").click(function(){
		location.href="/bikesystem/user/userpersonal";
	});
	
	
	
	$("#safe").click(function(){
		lichange(this);
		safeset();
	});
	
	
	$("#accountset span:nth-of-type(1)").click(function(){
		safeset();
	});
	
	
	$("#user_info").on("click","#queryidnumber",function(){
		$.ajax({
			url:"/bikesystem/queryuserinfo",
			type:"post",
			dataType:"json",
			success:function(message){
				$("#showid").html(message[0].idnumber);
			}
		});
	})
	$("#user_info").on("click","#updateemail",function(){
		$("#user_info").css({"opacity":"0.4","opacity":"1"});
		$("#updateinput").css("display","block");
		$("#updateinput").html("<span>输入邮箱:<input id='sremail' type='text'></span><input type='button' id='btnsj' value='提交'><input id='btnqx' type='button' value='取消'>");
		$("#user_info").on("click","#btnsj",function(){
			var email=$("#sremail").val();
			location.href="/bikesystem/user/updateuseremail?email="+email;
		})
	})
	$("#user_info").on("click","#addemail",function(){
		$("#user_info").css({"opacity":"0.4","opacity":"1"});
		$("#updateinput").css("display","block");
		$("#updateinput").html("<span>输入邮箱:<input id='sremail' type='text'></span><input type='button' id='btnsj' value='提交'><input id='btnqx' type='button' value='取消'>");
		$("#user_info").on("click","#btnsj",function(){
			var email=$("#sremail").val();
			location.href="/bikesystem/user/updateuseremail?email="+email;
		})
	})
	$("#user_info").on("click","#updateuserphone",function(){
		$("#user_info").css({"opacity":"0.4","opacity":"1"});
		$("#updateinput").css("display","block");
		$("#updateinput").html("<span>输入设置手机号:<input id='sremail' type='text'></span><input type='button' id='btnsj' value='提交'><input id='btnqx' type='button' value='取消'>");
		$("#user_info").on("click","#btnsj",function(){
			var uphone=$("#sremail").val();
			location.href="/bikesystem/user/updateuserphone?uphone="+uphone;
		})
	})
	$("#user_info").on("click","#updatephoneuser",function(){
		$("#user_info").css({"opacity":"0.4","opacity":"1"});
		$("#updateinput").css("display","block");
		$("#updateinput").html("<span>输入设置手机号:<input id='sremail' type='text'></span><input type='button' id='btnsj' value='提交'><input id='btnqx' type='button' value='取消'>");
		$("#user_info").on("click","#btnsj",function(){
			var uphone=$("#sremail").val();
			location.href="/bikesystem/user/updateuserphone?uphone="+uphone;
		})
	})
	$("#user_info").on("click","#updateuserpassword",function(){
		$("#user_info").css({"opacity":"0.4","opacity":"1"});
		$("#updateinput").css({"display":"block"});
		$("#updateinput").html("<span>输入旧登录密码:<input id='sroldpass' type='text'></span>" +
				"<br><br><span>输入新登录密码:<input id='srnewpass' type='text'></span></span>"+
				"<input type='button' id='btnsj' value='提交'><input id='btnqx' type='button' value='取消'>");
		$("#user_info").on("click","#btnsj",function(){
			var oldpass=$("#sroldpass").val();
			var newpass=$("#srnewpass").val();
			location.href="/bikesystem/user/updatepassword?pass="+oldpass+":"+newpass;
		})
	})
	$("#user_info").on("click","#btnqx",function(){
		$("#updateinput").css("display","none");
		$("#user_info").css("opacity","1");
	})
	
	
/*个人资料信息查询*/
	function lichange(x){
		$("#personinfomation li").css({"backgroundColor": "rgb(245,245,245)","color":"rgb(102,102,102)"});
		$(x).css({"backgroundColor": "rgb(230,230,230)","color":"black"});	
	}
	function queryuserinfo(){
		$.ajax({
			url:"/bikesystem/queryuserinfo",
			type:"post",
			dataType:"json",
			success:function(message){
				$("#user_info").html("");
				$("#user_info").html("<span>您的基础信息</span>");
				str="<p>会员名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+message[0].uphone+"</p>";
				str+="<p>登录邮箱："+message[0].email+"</p>";
				str+="<p>绑定手机："+message[0].uphone+"</p>";
				str+="<hr>";
				str+="<span>您的隐私查看</span>";
				str+="<table id='infotable'>";
				str+="<tr><td>姓名：</td><td>"+message[0].name+"</td></tr>";
				str+="<tr><td>性别：</td><td>"+message[0].sex+"</td></tr>";
				str+="<tr><td>身份证号：</td><td>"+message[0].idnumber+"</td></tr>";
				str+="<tr><td>收货地址：</td><td>"+message[0].address+"</td></tr>";
				str+="<tr><td>账户余额：</td><td>"+message[0].balance+"</td></tr>";
				str+="</table>";
				$("#user_info").append($(str));
			}
		});
	}
$("#personalinfo").click(function(){
	lichange(this);
	queryuserinfo();
});
$("#accountset span:nth-of-type(2)").click(function(){
	queryuserinfo();
});

/*修改个人资料*/
function updateuserinfo(){
	$.ajax({
		url:"/bikesystem/queryuserinfo",
		type:"post",
		dataType:"json",
		success:function(message){
			$("#user_info").html("");
			$("#user_info").html("<span>您的基础信息</span>");
			str="<p>会员名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+message[0].uphone+"</p>";
			str+="<p>登录邮箱："+message[0].email+"</p>";
			str+="<p>绑定手机："+message[0].uphone+"</p>";
			str+="<hr>";
			str+="<span>您的隐私设置</span><form action='/bikesystem/user/updatesomeinfo' method='post'>";
			str+="<table id='infotable'>";
			str+="<tr><td>姓名：</td><td><input type='text' name='uname' value='"+message[0].name+"'></td></tr>";
			str+="<tr><td>性别：</td><td><input type='text' name='usex' value='"+message[0].sex+"'>(男/女)</td></tr>";
			str+="<tr><td>身份证号：</td><td>"+message[0].idnumber+"</td></tr>";
			str+="<tr><td>收货地址：</td><td><input name='uaddress' type='text' value='"+message[0].address+"'>(xx省xx市xx)</td></tr>";
			str+="<tr><td>账户余额：</td><td>"+message[0].balance+"</td></tr>";
			str+="<tr><td></td><td><input type='submit' value='确认'></td></tr>";
			str+="</table></form>";
			$("#user_info").append($(str));
		}
	});
}
$("#accountset span:nth-of-type(3)").click(function(){
	updateuserinfo();
});
$("#updateallpersonalinfo").click(function(){
	lichange(this);
	updateuserinfo();
});
/*个人购买自行车交易信息*/
$("#buybike").click(function(){
	lichange(this);
	$.ajax({
		url:"/bikesystem/queryuserinfo",
		type:"post",
		dataType:"json",
		success:function(message){
			$("#user_info").html("");
			$("#user_info").html("<span>您的基础信息</span>");
			str="<p>会员名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+message[0].uphone+"</p>";
			str+="<p>登录邮箱："+message[0].email+"</p>";
			str+="<p>绑定手机："+message[0].uphone+"</p>";
			str+="<hr>";
			str+="<span>您的个人购买记录</span>";
			$("#user_info").append($(str));
		}
	});
	$.ajax({
		url:"/bikesystem/user/queryuserbikesell",
		type:"post",
		dataType:"json",
		success:function(message){
			var str="<table id='shoebikesell'>";
			str+="<thead><tr><th></th><th>车名</th><th>车类型</th><th>颜色</th>" +
					"<th>购买价格</th><th>所在店铺</th><th>购买时间</th></tr></thead>";
			str+="<tbody>";
			for(var i=0;i<message.length;i++){
				str+="<tr>";
				str+="<td><img id='bikesell' src='"+message[i].imgpath+"'></td>";
				str+="<td>"+message[i].bikename+"</td>";
				str+="<td>"+message[i].kindname+"</td>";
				str+="<td>"+message[i].color+"</td>";
				str+="<td>"+message[i].bikePrice+"</td>";
				str+="<td>"+message[i].shopName+"</td>";
				str+="<td>"+message[i].sellDate+"</td>";
				str+="</tr>";
			}
			str+="</tbody>";
			str+="</table>";
			$("#user_info").append($(str));
		}
	});
});

/*个人租借自行车交易信息*/
$("#rentbike").click(function(){
	lichange(this);
	$.ajax({
		url:"/bikesystem/queryuserinfo",
		type:"post",
		dataType:"json",
		success:function(message){
			$("#user_info").html("");
			$("#user_info").html("<span>您的基础信息</span>");
			str="<p>会员名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+message[0].uphone+"</p>";
			str+="<p>登录邮箱："+message[0].email+"</p>";
			str+="<p>绑定手机："+message[0].uphone+"</p>";
			str+="<hr>";
			str+="<span>您的个人租借记录</span>";
			$("#user_info").append($(str));
		}
	});
	$.ajax({
		url:"/bikesystem/user/queryuserbikerent",
		type:"post",
		dataType:"json",
		success:function(message){
			var str="<table id='shoebikesell'>";
			str+="<thead><tr><th>车编号</th><th>车名</th><th>所在店铺</th>" +
					"<th>租借时间</th><th>归还时间</th><th>押金</th><th>时租（日租）</th></tr></thead>";
			str+="<tbody>";
			for(var i=0;i<message.length;i++){
				str+="<tr>";
				str+="<td>"+message[i].bikeNumber+"</td>";
				str+="<td>"+message[i].bikeName+"</td>";
				str+="<td>"+message[i].shopName+"</td>";
				str+="<td>"+message[i].rentDate+"</td>";
				str+="<td>"+message[i].returnDate+"</td>";
				str+="<td>"+message[i].deposit+"</td>";
				if(message[i].rentType=="daymodel"){
					str+="<td>日租</td>";
				}
				else str+="<td>时租</td>";
				str+="</tr>";
			}
			str+="</tbody>";
			str+="</table>";
			$("#user_info").append($(str));
		},
		error:function(){alert("error");}
	});
});


/*搜索内容*/
$("#search").click(function(){
	var sel=$("#selectbike").val();
	var bike=$("#searchcontent").val();
	if(sel=="租借自行车"){
		location.href="/bikesystem/hs/search?bikename="+bike;
	}
	else location.href="/bikesystem/hp/search?bikename="+bike;
});


