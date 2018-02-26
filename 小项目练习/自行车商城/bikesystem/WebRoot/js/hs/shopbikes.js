$(function(){
	$(".kind-type-choose").hide();
	var slideLogo = false; //false代表隐藏着的，即下一次toggle会是向下滑动，true代表下一次滑动是向上滑动
	$(".nav-kindname-div").click(function(){
		var slideItem = $(this).next();
		var icon = $(this).children(".nav-icon");
		if(slideLogo == false){
			slideItem.slideDown(function(){
				icon.removeClass("kind-nav-icon-open");
				icon.addClass("kind-nav-icon-close");
			});
			slideLogo = true;
		}else{
			slideItem.slideUp(function(){
				icon.addClass("kind-nav-icon-open");
				icon.removeClass("kind-nav-icon-close");
			});
			slideLogo = false;
		}
	});
});










