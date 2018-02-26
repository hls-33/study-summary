<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="tolocalshop-main">
	<img class="shop-robot" alt="" src="/bikesystem/image/hs/shoprobot.png">
	<div class="local-info">
		<div><span>商店名:${requestScope.shop.shopName}</span></div>
		<div><span>自行车名:${requestScope.bikeRent.bikeName}</span></div>
		<div><span>商店地址:${requestScope.shop.shopAddress}</span></div>
		<div><span>预约提车日期:${requestScope.orderDate}</span></div>
		<div><span>租车归还日期:${requestScope.returnDate}</span></div>
		<div  id="gotoshop-button" class="gotoshop-button"><a>Go</a></div>
	</div>
	
	<script type="text/javascript">
		/* 将前面的都要设置一波 */
		$(".step-second>.step-no").css("background-position","50% -170px");
		$(".step-second>.step-no").html("");
		$(".step-third>.step-no").css("background-position","50% -170px");
		$(".step-third>.step-no").html("");
	</script>
</div>