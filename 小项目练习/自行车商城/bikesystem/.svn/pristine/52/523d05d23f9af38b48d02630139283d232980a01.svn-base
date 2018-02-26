			$("#login-div p:nth-of-type(1) input").blur(function(){
    			$.ajax({
    				url:"/bikesystem/loginajax",
    				type:"POST",
    				data:{"username":$("input[name='username']").val()},
    				success:function(message){
    					$("#contentid").html(message);
    				},
    				error:function(){}
    			});
    		});
    		$("#login-div p:nth-of-type(2) input").blur(function(){
    			$.ajax({
    				url:"/bikesystem/loginpassajax",
    				type:"POST",
    				data:{"password":$("input[name='password']").val()},
    				success:function(message){
    					$("#contentpass").html(message);
    				},
    				error:function(){}
    			});
    		});
    		$("#login-div p:nth-of-type(3) input").blur(function(){
    			$.ajax({
    				url:"/bikesystem/loginchkajax",
    				type:"POST",
    				data:{"chk":$("input[name='check']").val()},
    				success:function(message){
    					$("#checkspan").html(message);
    				},
    				error:function(){}
    			});
    		});
    		$("#flushimg").click(function(){
    			$("#flushimg").attr("src","/bikesystem/showchk?date="+new Date().getMilliseconds());
    		});
    		$("#wrong").click(function(){
    			 $("#login-div").css("opacity","0.4");
    			 $("#losspassword").css("display","block");
    			 $("#sure").click(function(){
    				 $.ajax({
    					 url:"/bikesystem/usersearchpass",
    					 type:"post",
    					 data:{"phone":$("#tele").val()},
    					 success:function(message){
    						 $("#getphone").html("登录密码："+message);
    					 }
    				 });
    			 });
    		 });
    		$("#closeimg").click(function(){
    			$("#login-div").css("opacity","1");
   			 	$("#losspassword").css("display","none");
    		});
    		