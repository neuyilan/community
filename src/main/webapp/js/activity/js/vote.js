(function(downtime){
	var currState = $('#state').val();
	if(currState==2){
		return;
	}
	downtime.target = $(downtime.target);
	downtime.start = +new Date(downtime.start) || console.error("开始时间格式错误");
	downtime.end = +new Date(downtime.end) || console.error("开始时间格式错误");
	now=+new Date(downtime.time);
	
	var counter = function(){
		now=now+1000;
		if(now<downtime.start) {
			var delta = parseInt((downtime.start - now)/1000),
			day  = ("0"+parseInt(delta/86400)).substr(-2),
			hour = ("0"+parseInt((delta%86400)/3600)).substr(-2),
			min  = ("0"+parseInt((delta%3600)/60)).substr(-2),
			sec  = ("0"+(delta%60)).substr(-2);
		    downtime.target.html(downtime.format.replace("dd",day).replace("hh",hour).replace("mm",min).replace("ss",sec));
		}
		else if(now>downtime.start&&now<downtime.end){
		    $(".x-djs").css("display","none");
			$(".x-qg").css("display","block");
		}
		else if(now>downtime.end){
		    downtime.target.html("已结束");
			$(".x-qg").css("display","none");
			$(".x-djs").css("display","block");
		}
		if($(".x-pm").css("display")=="block"){
		    $(".x-qg").css("display","none");
		}
	}
	counter();
	setInterval(counter, 1000);
})({
	target : "#tpli_counter",
	format : "<i>dd</i><span>天</span><i>hh</i><span>时</span><i>mm</i><span>分</span><i>ss</i><span>秒</span>",
	 after : "已结束",
	 start : $('#startTime').val(),
	   end : $('#endTime').val(),
	   time:$('#dateTime').val()
});

$(document).ready(function(){
	 /*$('.x-z a').click(function(){
        $('.x-z a').append('<em class="x-add">+1</em>');
		$('.x-z img').attr("src","images/ze.png");
		$('.x-z em').css("color","#e41212");
        $('.x-add').css({'position':'absolute', 'color':'#FF0000','left':'0px','top':'0px'}).animate({top:'-30px',left:'0px'},'slow',function(){
          $(this).fadeIn('fast').remove();
          var Num = parseInt($('.x-z em').text());
          Num++;
          $('.x-z em').text(Num);
		  $('.x-z img').attr("src","images/zk.png");
		  $('.x-z em').css("color","#030303");
        });
	 });*/
 });