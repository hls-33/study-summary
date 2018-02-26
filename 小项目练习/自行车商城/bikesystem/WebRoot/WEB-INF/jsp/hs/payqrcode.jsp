<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="qrcode-main">
	<div>
		<h3>扫描二维码,通过轻松付快捷支付</h3>
	</div>
	<div class="qrcode-ensure">
		<img id="qrcode-img" >
		<img class="checkpay" src="/bikesystem/image/hs/checkpay.png">
	</div>
	
</div>
<script type="text/javascript">
	//var interval = setInterval(getState(),1000);
	
	//设置二维码的图片防止缓存效果
	var img = document.getElementById("qrcode-img");
	img.src="/bikesystem/image/hs/payqrcode.png?date="+new Date().getTime();
	
	//修改导航标志的位置
	$(".step-second>.step-no").css("background-position","50% -170px");
	$(".step-second>.step-no").html("");
	
	$(".checkpay").hide();
	var interval = setInterval(function() {
		$.ajax({
			url : "/bikesystem/hs/ajaxcodescanner",
			success : function(scanner) {
				if("true" == scanner){
					$.ajax({
						url:"/bikesystem/hs/dopaycaculate",
						success:function(result){
							if("success" == result){
								clearInterval(interval);
								alert("付款成功！");
								$(".checkpay").show();
								location.href="/bikesystem/user/hs/toshop";
							}else{
								alert("付款失败,余额不足！")
							}
						}
					});
				}
			}
		});
	},1000);
	
	
</script>
