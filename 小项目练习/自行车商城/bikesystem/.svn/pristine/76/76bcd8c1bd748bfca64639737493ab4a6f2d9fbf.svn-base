$(function(){
	
	
	//默认是1
	$(".rent-time-input").val(1);
	
	$(".rent-time-input").blur(function(){
		var renttype = $(".order-rentModel input[type='radio']:checked").val();
		var renttimes = $(".rent-time-input").val();
		$.ajax({
			url:"/bikesystem/hs/caculate",
			data:{"renttype":renttype,"renttimes":renttimes,"brid":brid},
			type:"post",
			dataType:"json",
			success:function(acount){
				var totalTimePrice = acount.totalTimePrice;
				var allPayPrice = acount.allPayPrice;
				$("#hourPriceSale").html("￥"+totalTimePrice);
				$("#total-price").html("￥"+allPayPrice);
				$("#allpayprice").html(allPayPrice);
			},error:function(){
			}
			
		});
		
		
	});
	
	//做一个验证，防止数为1以下
	$(".rent-time-input").change(function(){
		var rentTimes = $(this).val();
		if(rentTimes<=1){
			$(this).val(1);
		}
	});
	
});