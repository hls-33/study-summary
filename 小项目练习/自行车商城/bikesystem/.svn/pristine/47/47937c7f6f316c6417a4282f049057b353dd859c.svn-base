var cicyle=0;

function nav(){
	//获取所有子li
	var imglists=$("#nav-ul").children(".img-list");
	var len = imglists.length;
	for(var i=0;i<len;i++){
		if(cicyle == i){
			$(imglists[i]).show(1000);
		}else{
			$(imglists[i]).hide();
		}
	}
	cicyle++;
	if(cicyle == len){
		cicyle=0;
	}
}

var bkcss = "url('"+backgroundPath+"') no-repeat fixed";
$(function(){
	var imglists=$("#nav-ul").children(".img-list");
	for(var i=1;i<imglists.length;i++){
		$(imglists[i]).hide();
	}
	//setInterval('nav()',3000);
	var bkcss="url('"+backgroundPath+"') "+"no-repeat "+"fixed";
	$(".total").css("background",bkcss);
});
	
	
	
	
	
	
	