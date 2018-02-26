<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="confirm-order">
    	<div class="order-title">
    		<h2 class="order-th">确认预约信息</h2>
    		<div class="order-td-div">
    			<div class="order-td-0 order-td-item">店铺宝贝</div>
    			<div class="order-td-1 order-td-item">商品属性</div>
    			<div class="order-td-2 order-td-item">小时租金</div>
    			<div class="order-td-3 order-td-item">日租金</div>
    			<div class="order-td-4 order-td-item">最低押金</div>
    		</div>
    	</div>
    	<div class="order-main">
    		<div class="order-info">
    			<img class="shop-icon" src="/bikesystem/image/hgg/logo.jpg">
    			<span>店铺:</span>
    			<span><a href="/bikesystem/hs/shop?shopname=${requestScope.shop.shopName}">${requestScope.shop.shopName }</a></span>
    			<span></span>
    		</div>
    		<div class="order-item">
    			<div class="order-item-0 order-item-row">
    				<img class="order-rent-image" src="${requestScope.newBikeRent.imgPath}">
    				<div class="order-rent-info">
    					<a>${requestScope.newBikeRent.bikeName}</a>
    					<div>
    					<a href="#" class="icon-a"><img src="//img.alicdn.com/tps/i3/T1Vyl6FCBlXXaSQP_X-16-16.png"></a>
    					<a href="#" cl><img src="//img.alicdn.com/tps/i4/T1BCidFrNlXXaSQP_X-16-16.png"></a>
    					<a href="#"><img src="//assets.alicdn.com/sys/common/icon/trade/xcard.png"></a>
    					</div>
    				</div>
    			</div>
    			<div class="order-item-1  order-item-row">
    				<ul>
    					<li>车身颜色:${requestScope.newBikeRent.color }</li>
    					<li>车型:${requestScope.newBikeRent.kindName }</li>
    					<li>状态:完好</li>
    				</ul>
    			</div>
    			<div class="order-item-2 order-item-row money-strong">￥${requestScope.oldBikeRent.hourPrice}</div>
    			<div class="order-item-3 order-item-row money-strong">￥${requestScope.oldBikeRent.dayPrice}</div>
    			<div class="order-item-4 order-item-row money-strong">￥${requestScope.oldBikeRent.bikedeposit}</div>
    		</div>
    		<div class="order-service">
    			<div class="order-service-title">售后服务:</div>
    			<div class="order-service-info">
    				<div class="order-service-icon">
    					<input type="checkbox" name="shopsale" value="sale">
    					<span>商家优惠</span>
    					<img src="http://gtd.alicdn.com/tps/i2/T1nsmkXu0iXXbfMpDa-17-16.jpg">
    					<a><img src="//img.alicdn.com/tps/TB1zNZ_LVXXXXasapXXXXXXXXXX-32-32.png" style="width:15px;height:15px;"></a>
    				</div>
    				<div class="order-service-saleprice money-strong">
    					<c:if test="${not empty requestScope.rentSale}">
    						<span class="hourPriceSale">￥${requestScope.rentSale.hourSalePrice}</span>
    						<span class="dayPriceSale">￥${requestScope.rentSale.daySalePrice}</span>
    					</c:if>
    						
    					<c:if test="${empty requestScope.rentSale}">
    						<span class="hourPriceSale">￥0.00</span>
    						<span class="dayPriceSale">￥0.00</span>
    					</c:if>
    				</div>
    			</div>
    		</div>
    		<div class="order-service">
    			<div class="order-service-title">折扣价格:</div>
    			<div class="order-service-info">
    				<div class="order-service-icon"></div>
    				<div class="order-service-saleprice money-strong">
    					<span class="hourPriceSale">￥${requestScope.newBikeRent.hourPrice}</span>
    					<span class="dayPriceSale">￥${requestScope.newBikeRent.dayPrice}</span>
    				</div>
    			</div>
    		</div>
    		<!-- 租时选择 -->
    		<div class="order-rentTime">
    			<div class="order-rentTime-title"><span>租时模式选择:</span></div>
    			<div class="order-rentModel">
    				<div class="hour-model"><input type="radio" name="renttimemodel" value="hourmodel">时租</div>
    				<div class="day-model"><span class="input-span"><input type="radio"  name="renttimemodel" value="daymodel" checked></span><span>日租</span></div>
    				<div class="order-rent-time"><input type="number" value="ordertime" class="rent-time-input"></div>
    			</div>
    			<div class="order-totalTime-price">
    				<span>租时费用:</span><span id="hourPriceSale" class="hourPriceSale money-strong">￥${requestScope.newBikeRent.dayPrice}</span>
    			</div>
    		</div>
    		
    		
    		<!-- 提车日期选择 （只能在一个星期之内提车，超过则收取违约金）-->
    		<div class="order-date-choose order-rentTime">
    			<div class="order-rentTime-title"><span>预约日期选择:</span></div>
    			<div class="date-choose">
    				<!--指定 date标记-->  
		            <div class="input-group date" id="datetimepicker2">  
		                <input type="text" id="input-date" class="form-control" name="orderdate" readonly="readonly"/>  
		                <span class="input-group-addon" id="input-date-icon">  
		                    <span class="glyphicon glyphicon-calendar"></span>  
		                </span> 
		                <span class="waring-info"></span> 
		            </div>  
    			</div>
    		</div>
    		
    		
    		<div class="order-ext">
    			<div class="order-ext-user"><span>租车用户:${sessionScope.user.name}</span></div>
    			<div class="order-ext-diliver"><span>配送方式:上门自提</span></div>
    			<div class="order-ext-price money-strong"><span>￥0.0</span></div>
    		</div>
	    	<div class="order-pay">
	    		<span style="color:#333;">店铺合计(上门自提)</span>
	    		<span id="total-price" class="total-price money-strong" >￥${requestScope.initAllPayPrice}</span>
	    	</div>
    	</div>
    	
    	<div class="order-payinfo">
    		<div class="order-payInfo-wrapper">
    			<div class="order-payinfo-money"><span style="font-size: 14px;color:#333;font-weight: 700;">实付款:</span><span style="font: 700 26px tahoma;">￥</span><span id="allpayprice" class="allpayprice money-strong" style="font: 700 26px tahoma;">${requestScope.initAllPayPrice}</span></div>
    			<div class="order-payinfo-address"><span style="font-size: 14px;color:#333;font-weight: 700;">店铺地址（提车）:</span><span>${requestScope.shop.shopAddress}</span></div>
    			<div class="order-payinfo-user"><span style="font-size: 14px;color:#333;font-weight: 700;">预约人:</span><span>${sessionScope.user.name}</span></div>
    		</div>
    	</div>
    	<div class="order-submit">
    		<div class="order-submit-button"><a class="a-button" href="javascript:submit()">提交预约</a></div>
    	</div>
    </div>
    <script type="text/javascript">
    	function submit(){
    		//做个日期是否选择的验证
    		var orderdate = $("#input-date").val();
    		if(orderdate!=""){
    			if(verifyOrderDate(orderdate)){
    				location.href="/bikesystem/user/hs/paydeposite?orderdate="+orderdate;
    			}
    		}else{
    			$(".waring-info").html("请选择提车日期，否则小店无法及时备货");
    		}
    	}
    	function verifyOrderDate(orderdate){
    		var nowDateLong = new Date().getTime();
    		var orderDateLong = new Date(orderdate).getTime();
    		var dateInterval = orderDateLong-nowDateLong;
    		var day = dateInterval/24/3600/1000;
    		if(day<=0){
    			$(".waring-info").html("请选择正确的在未来的提车日期");
    			return false;
    		}else if(day>7){
    			$(".waring-info").html("抱歉，预约的提车时间只能在7天之内");
    			return false;
    		}
    		return true;
    	}
    	
    	$(function(){
    		$("#input-date").focus(function(){
    			$(".waring-info").html("");
    		});
    		
    		 $('#datetimepicker2').datetimepicker({  
		        language: 'zh-CN',
                autoclose: true,
                todayHighlight: true 
    		});  
    		
    	});
    </script>