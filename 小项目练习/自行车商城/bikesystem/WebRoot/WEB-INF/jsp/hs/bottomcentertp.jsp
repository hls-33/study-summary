<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

	<style>
	#bm_tp_top{
			border-bottom:1px solid #FAFAFA;
			background-color:#F2EFEF;
			font-size:18px;
			width:260px;
			height:40px;
			line-height:40px;
			text-align:center;
	}
	
	#bm_tp_bottom table{
		margin-top:40px;
	}
		
	#bm_tp_bottom thead{
			font-size:15px;
			
	}
		#bm_tp_bottom tbody{
			font-size:14px;
			color:#E17E7E;
	}
	.bm_tp_bottom {
			background-color:black;
			width:100px;
			height:30px;
			margin-left:80px;
			margin-top:20px;
			line-height:30px;
			text-align:center;
	}
	.bm_tp_bottom a{
		color:#FFFFFF;
		text-decoration:none;
	}
	
	</style>

<div id="bm_tp_top">${requestScope.bikeRent.shopName}自行车专营店</div>
<div id="bm_tp_bottom">
		<table>
			<thead><th>描述</th><th>服务</th><th>物流</th></thead>
			<tbody><th>4.8</th><th>4.9</th><th>4.8</th></tbody>
		</table>
		<div class="bm_tp_bottom"><a href="/bikesystem/hs/shop?shopname=${requestScope.bikeRent.shopName}">进店逛逛</a></div>
</div>