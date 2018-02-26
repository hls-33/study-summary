$("#uphone").blur(function(){
	$.ajax({
		url:"/bikesystem/uphone",
		type:"POST",
		data:{"uphone":$("#uphone").val()},
		success:function(message){
			$("#uphonespan").html(message);
		}
	});
});
$("#uname").blur(function(){
	$.ajax({
		url:"/bikesystem/uname",
		type:"POST",
		data:{"uname":$("#uname").val()},
		success:function(message){
			$("#unamespan").html(message);
		}
	});
});
$("#upassword").blur(function(){
	$.ajax({
		url:"/bikesystem/upassword",
		type:"POST",
		data:{"upassword":$("#upassword").val()},
		success:function(message){
			$("#upasswordspan").html(message);
		}
	});
});
$("#surepass").blur(function(){
	$.ajax({
		url:"/bikesystem/surepass",
		type:"POST",
		data:{"surepass":$("#surepass").val()+":"+$("#upassword").val()},
		success:function(message){
			$("#surepassspan").html(message);
		}
	});
});
$("#uid").blur(function(){
	$.ajax({
		url:"/bikesystem/uidnumber",
		type:"POST",
		data:{"uid":$("#uid").val()},
		success:function(message){
			$("#uidspan").html(message);
		}
	});
});
$("#address").blur(function(){
	$.ajax({
		url:"/bikesystem/uaddress",
		type:"POST",
		data:{"address":$("#address").val()},
		success:function(message){
			$("#addressspan").html(message);
		}
	});
});
$("#email").blur(function(){
	$.ajax({
		url:"/bikesystem/uemail",
		type:"POST",
		data:{"email":$("#email").val()},
		success:function(message){
			$("#emailspan").html(message);
		}
	});
});


































