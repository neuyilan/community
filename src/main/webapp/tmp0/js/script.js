var cWidth,frameh;
if (document.compatMode == "BackCompat") {
    cWidth = document.body.clientWidth;
    frameh = document.body.clientHeight-43;
}
else {
    cWidth = document.documentElement.clientWidth;
    frameh = document.documentElement.clientHeight-43;	
}


/*设置iframe高度*/
function iframeload(){
    document.getElementById('myframe').height=frameh;
}

$(function() {
	/*获取验证码按钮切换和倒计时*/
	$(".getyzm").click(function(e) {
		$(this).css("display","none");
		$(".repget").css("display","inline");
		time=$(".repget").val().substr(5,2);
		int=setInterval(djs,1000);
	});
	
	function djs(){
		if(time>0){
			time--;
			$(".repget").val("重新获取("+time+")");
		}
		else if(time==0){
			clearInterval(int);
			$(".getyzm").css("display","inline");
			$(".repget").css("display","none");
			$(".repget").val("重新获取(60)");
		}
	}
	
	/*新鲜事头部导航拖动*/
	var totwidth=0;
	for(var i=0; i<$("#dragul span").length; i++){
		var iwidth=0;
		if($("#dragul span").eq(i).outerWidth(true)>200){
		     var txtlength=$("#dragul span").eq(i).text().length;
			 iwidth= parseInt(txtlength*13+16+18);  
		}
		else{
		    iwidth=$("#dragul span").eq(i).outerWidth(true);
		}
		totwidth+=iwidth;
	}
    var maxleft=parseInt(cWidth-totwidth-20);
    var left,right,startleft,moveleft,startright,moveright;
    if(document.getElementById("dragul")!=null){
		document.getElementById("dragul").addEventListener("touchstart", touchStart, false);
		document.getElementById("dragul").addEventListener("touchmove", touchMove, false);
	}
    function touchStart(event) {
	    var touch = event.touches[0];
	    startleft = touch.pageX;
	    left=parseInt($("#dragul").css("left"));
    }
    function touchMove(event) {
	    var touch = event.touches[0];
	    var lor = touch.pageX-startleft; 
	    moveleft=left+lor;
	    if(lor>0){
		    if( moveleft<=0){
			    $("#dragul").css("left",moveleft);
		    }
		    else{
			    $("#dragul").css("left","0px");
		    }
	    }
	    else{
		    if( moveleft>=maxleft){
			    $("#dragul").css("left",moveleft);
		    }
		    else{
			    $("#dragul").css("left",maxleft);
		    }
	    }
    }
	
	/*跳蚤市场小区选择*/
	$(".header h1 span").click(function(){
		if($(".tz-sel").css("display")=="none"){
	        $(".tz-sel").css("display","block");	
		}
		else{
		    $(".tz-sel").css("display","none");
		}
	});
	$(".tz-sel a").click(function(){
		$(".header h1 span").text($(this).text());
		$(".tz-sel").css("display","none");
	}); 
	
	/*跳蚤详情*/
	if(document.getElementsByClassName("swiper-container")!=null){
		var mySwiper = new Swiper('.swiper-container',{
			mode:'horizontal',
			pagination:'.pagination',
			paginationClickable: true,
			loop: false 
	   });
	}
   $('.tz-z a').click(function(){
	   $('.tz-z a').append('<em class="x-add">+1</em>');
	   $('.tz-z a').css("background-image","url(images/zyellow.png)");
	   $('.tz-z em').css("color","#fd8b07");
	   $('.x-add').css({'position':'absolute', 'color':'#fd8b07','left':'0px','top':'0px'}).animate({top:'-30px',left:'0px'},'slow',function(){
		   $(this).fadeIn('fast').remove();
		   var Num = parseInt($('.tz-z em').text());
		   Num++;
		   $('.tz-z em').text(Num);
		   $('.tz-z a').css("background-image","url(images/zgray.png)");
		   $('.tz-z em').css("color","#7c7c7c");
	   });
	   tiaozao_dianzan();
    }); 
})

function  tiaozao_dianzan(){
	var ID =parseFloat($("#ID").val());
	if(ID !=''){
		 $.ajax({
			 type: "POST",
			 url: "tiaozao_dianzan.php",
			 data: "ID="+ID,
			 success: function(msg){
				$('.tz-z em').text(msg);
			}
		});
	}
}




