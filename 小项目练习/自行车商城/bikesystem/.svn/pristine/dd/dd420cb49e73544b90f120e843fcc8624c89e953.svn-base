$("input[name='aphone']").blur(function(){
	var str=$("input[name='aphone']").val();
	$.ajax({
		url:"/bikesystem/aphone",
		type:"post",
		data:{"aphone":str},
		success:function(message){
			$("#aphonespan").html(message);
		}
	});
});
$("input[name='aname']").blur(function(){
	$.ajax({
		url:"/bikesystem/aname",
		type:"post",
		data:{"aname":$("input[name='aname']").val()},
		success:function(message){
			$("#anamespan").html(message);
		}
	});
});
$("input[name='apassword']").blur(function(){
	$.ajax({
		url:"/bikesystem/apassword",
		type:"post",
		data:{"apass":$("input[name='apassword']").val()},
		success:function(message){
			$("#apassspan").html(message);
		}
	});
});
$("input[name='asurepass']").blur(function(){
	$.ajax({
		url:"/bikesystem/asurepass",
		type:"post",
		data:{"asure":$("input[name='asurepass']").val()+":"+$("input[name='apassword']").val()},
		success:function(message){
			$("#asurepassspan").html(message);
		}
	});
});
$("input[name='aidnumber']").blur(function(){
	var str=this.value;
	$.ajax({
		url:"/bikesystem/aidnumberp",
		type:"post",
		data:{"aidnumber":str},
		success:function(message){
			$("#aidnumberspan").html(message);
		}
	});
});
$("input[type='button'").click(function(){
	$("#create-div input[type='text']").val("");
	$("#create-div input[type='password']").val("");
	$("#create-div span").html("");
});























