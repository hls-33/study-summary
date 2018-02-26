$(function(){
	$(".tab").hover(function(){
		$(this).addClass("tab-hover");
	},function(){
		$(this).removeClass("tab-hover");
	});
	$(".triggers>li:last-child").click(function(){
		var choose = $(this).html();
		var firstli=$(".triggers>li:first-child");
		var temp = firstli.html();
		firstli.html(choose);
		$(this).html(temp);
		//设置input框中的name为对应的值
		if(choose=="店铺"){
			$(".search-input").attr("name","shopname");
		}else{
			$(".search-input").attr("name","bikename");
		}
		$(".tab").removeClass("tab-hover");
	});
})