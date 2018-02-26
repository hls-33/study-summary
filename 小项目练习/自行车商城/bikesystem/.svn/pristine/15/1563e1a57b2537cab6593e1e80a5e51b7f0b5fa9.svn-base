$(function(){
							var one = false;
							var two = false;
							var thir = false;
							var forth=false;
							var fifth = false;
						window.onload=function(){
										$(".order-address .tableid:nth-of-type(1)  table").css({"border":"2px solid red","opacity":"1"});
										$(".order-address .tableid:nth-of-type(2)  table").css({"border":"none","opacity":"0.5"});
										$(".order-address .tableid:nth-of-type(3)  table").css({"border":"none","opacity":"0.5"});
										$(".order-address .tableid:nth-of-type(4)  table").css({"border":"none","opacity":"0.5"});
										$(".order-address .tableid:nth-of-type(5)  table").css({"border":"none","opacity":"0.5"});
						}
							$(".order-address .tableid:nth-of-type(1)").click(function(){
									$(".order-address .tableid:nth-of-type(1)  table").css({"border":"2px solid red","opacity":"1"});
									one=true;
									if(one){
										$(".order-address .tableid:nth-of-type(2)  table").css({"border":"none","opacity":"0.5"});
										$(".order-address .tableid:nth-of-type(3)  table").css({"border":"none","opacity":"0.5"});
										$(".order-address .tableid:nth-of-type(4)  table").css({"border":"none","opacity":"0.5"});
										$(".order-address .tableid:nth-of-type(5)  table").css({"border":"none","opacity":"0.5"});
										}
									var id = $(this).children().children().children().children().children().children().text();
									var arr = new Array();
									 $(this).children().children().children().children().each(function(i){
										 arr[i] = $(this).text();
									 })
									var address = arr[1];
									 var namephone = arr[2];
									$.ajax({
										url:"/bikesystem/hp/addressajax",
										type:"POST",
										data:{"id":id,"address":address,"namephone":namephone},
										dataType:"text",
										success:function(JsonStr){
											var returnaddress = JsonStr.substring(0,JsonStr.indexOf("&"));
											var returnnamephone = JsonStr.substring(JsonStr.indexOf("&")+1);
											$(".bottom-sp ol li:first-of-type>span").empty();
											$(".bottom-sp ol li:last-of-type>span").empty();
											$(".bottom-sp ol li:first-of-type>span").append(returnaddress);
											$(".bottom-sp ol li:last-of-type>span").append(returnnamephone);
										},
										error:function(JsonStr){
											alert("错误");
											
										}
										
									})
									
									
									
							});

							$(".order-address .tableid:nth-of-type(2)").click(function(){
									$(".order-address .tableid:nth-of-type(2)  table").css({"border":"2px solid red","opacity":"2"});
	
									two=true;
									if(two){
											$(".order-address .tableid:nth-of-type(1)  table").css({"border":"none","opacity":"0.5"});
											$(".order-address .tableid:nth-of-type(3)  table").css({"border":"none","opacity":"0.5"});
											$(".order-address .tableid:nth-of-type(4)  table").css({"border":"none","opacity":"0.5"});
											$(".order-address .tableid:nth-of-type(5)  table").css({"border":"none","opacity":"0.5"});
										}
									var id = $(this).children().children().children().children().children().children().text();
									var arr = new Array();
									 $(this).children().children().children().children().each(function(i){
										 arr[i] = $(this).text();
									 })
									var address = arr[1];
									 var namephone = arr[2];
									$.ajax({
										url:"/bikesystem/hp/addressajax",
										type:"POST",
										data:{"address":address,"namephone":namephone},
										dataType:"text",
										success:function(JsonStr){
											var returnaddress = JsonStr.substring(0,JsonStr.indexOf("&"));
											var returnnamephone = JsonStr.substring(JsonStr.indexOf("&")+1);
											$(".bottom-sp ol li:first-of-type>span").empty();
											$(".bottom-sp ol li:last-of-type>span").empty();
											$(".bottom-sp ol li:first-of-type>span").append(returnaddress);
											$(".bottom-sp ol li:last-of-type>span").append(returnnamephone);
										},
										error:function(JsonStr){
											alert(JsonStr);
											
										}
										
									})
							});
							
						$(".order-address .tableid:nth-of-type(3)").click(function(){
							$(".order-address .tableid:nth-of-type(3)  table").css({"border":"2px solid red","opacity":"1"});

									thir=true;
									if(thir){
											$(".order-address .tableid:nth-of-type(1)  table").css({"border":"none","opacity":"0.5"});
											$(".order-address .tableid:nth-of-type(2)  table").css({"border":"none","opacity":"0.5"});
											$(".order-address .tableid:nth-of-type(4)  table").css({"border":"none","opacity":"0.5"});
											$(".order-address .tableid:nth-of-type(5)  img").css({"border":"none","opacity":"0.5"});
										
										}
									var id = $(this).children().children().children().children().children().children().text();
									var arr = new Array();
									 $(this).children().children().children().children().each(function(i){
										 arr[i] = $(this).text();
									 })
									var address = arr[1];
									 var namephone = arr[2];
									$.ajax({
										url:"/bikesystem/hp/addressajax",
										type:"POST",
										data:{"address":address,"namephone":namephone},
										dataType:"json",
										success:function(JsonStr){
											var returnaddress = JsonStr.substring(0,JsonStr.indexOf("&"));
											var returnnamephone = JsonStr.substring(JsonStr.indexOf("&")+1);
											$(".bottom-sp ol li:first-of-type>span").empty();
											$(".bottom-sp ol li:last-of-type>span").empty();
											$(".bottom-sp ol li:first-of-type>span").append(returnaddress);
											$(".bottom-sp ol li:last-of-type>span").append(returnnamephone);
										}		
									})
							});
						$(".order-address .tableid:nth-of-type(4)").click(function(){
							$(".order-address .tableid:nth-of-type(4)  table").css({"border":"2px solid red","opacity":"1"});

							forth=true;
							if(forth){
									$(".order-address .tableid:nth-of-type(1)  table").css({"border":"none","opacity":"0.5"});
									$(".order-address .tableid:nth-of-type(2)  table").css({"border":"none","opacity":"0.5"});
									$(".order-address .tableid:nth-of-type(5)  table").css({"border":"none","opacity":"0.5"});
									$(".order-address .tableid:nth-of-type(3)  table").css({"border":"none","opacity":"0.5"});
								
								}
							var id = $(this).children().children().children().children().children().children().text();
							var arr = new Array();
							 $(this).children().children().children().children().each(function(i){
								 arr[i] = $(this).text();
							 })
							var address = arr[1];
							 var namephone = arr[2];
							
							$.ajax({
								url:"/bikesystem/hp/addressajax",
								type:"POST",
								data:{"address":address,"namephone":namephone},
								dataType:"json",
								success:function(message){
									var returnaddress = JsonStr.substring(0,JsonStr.indexOf("&"));
									var returnnamephone = JsonStr.substring(JsonStr.indexOf("&")+1);
									$(".bottom-sp ol li:first-of-type>span").empty();
									$(".bottom-sp ol li:last-of-type>span").empty();
									$(".bottom-sp ol li:first-of-type>span").append(returnaddress);
									$(".bottom-sp ol li:last-of-type>span").append(returnnamephone);
								}		
							})
					});
						$(".order-address .tableid:nth-of-type(5)").click(function(){
							$(".order-address .tableid:nth-of-type(5)  table").css({"border":"2px solid red","opacity":"1"});

							fifth=true;
							if(fifth){
									$(".order-address .tableid:nth-of-type(1)  img").css({"border":"none","opacity":"0.5"});
									$(".order-address .tableid:nth-of-type(2)  img").css({"border":"none","opacity":"0.5"});
									$(".order-address .tableid:nth-of-type(3)  img").css({"border":"none","opacity":"0.5"});
									$(".order-address .tableid:nth-of-type(4)  img").css({"border":"none","opacity":"0.5"});
								
								}
							var id = $(this).children().children().children().children().children().children().text();
							var arr = new Array();
							 $(this).children().children().children().children().each(function(i){
								 arr[i] = $(this).text();
							 })
							var address = arr[1];
							 var namephone = arr[2];
							
							$.ajax({
								url:"/bikesystem/hp/addressajax",
								type:"POST",
								data:{"address":address,"namephone":namephone},
								dataType:"json",
								success:function(message){
									var returnaddress = JsonStr.substring(0,JsonStr.indexOf("&"));
									var returnnamephone = JsonStr.substring(JsonStr.indexOf("&")+1);
									$(".bottom-sp ol li:first-of-type>span").empty();
									$(".bottom-sp ol li:last-of-type>span").empty();
									$(".bottom-sp ol li:first-of-type>span").append(returnaddress);
									$(".bottom-sp ol li:last-of-type>span").append(returnnamephone);
								}		
							})
					});
							

						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
					})