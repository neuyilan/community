;(function($){
    /*
     * 文本域光标操作（选、添、删、取）
     */
    $.fn.extend({
        /*
         * 获取光标所在位置
         */
        iGetFieldPos:function(){
            var field=this.get(0);
            if(document.selection){
                //IE
                var sel=document.selection;
                var range=sel.createRange();
                var dupRange=range.duplicate();
                dupRange.moveToElementText(field);
                dupRange.setEndPoint('EndToEnd',range);
                field.selectionStart=dupRange.text.length-range.text.length;
                field.selectionEnd=field.selectionStart+ range.text.length;
            }
            return field.selectionStart;
        },
        /*
         * 选中指定位置内字符 || 设置光标位置
         * --- 从start起选中(含第start个)，到第end结束（不含第end个）
         * --- 若不输入end值，即为设置光标的位置（第start字符后）
         */
        iSelectField:function(start,end){
            var field=this.get(0);
            //end未定义，则为设置光标位置
            if(arguments[1]==undefined){
                end=start;
            }
            if(document.selection){
                //IE
                var range = field.createTextRange();
                range.moveEnd('character',-$(this).val().length);
                range.moveEnd('character',end);
                range.moveStart('character',start);
            }else{
                //非IE
                field.setSelectionRange(start,end);
            }
        },
        /*
         * 选中指定字符串
         */
        iSelectStr:function(str){
            var field=this.get(0);
            var i=$(this).val().indexOf(str);
            i != -1 ? $(this).iSelectField(i,i+str.length) : false;
        },
        /*
         * 在光标之后插入字符串
         */
        iAddField:function(str){
            var field=this.get(0);
            var v=$(this).val();
            var len=$(this).val().length;
            if(document.selection){
                //IE
                document.selection.createRange().text=str;
            }else{
                //非IE
                var selPos=field.selectionStart;
                $(this).val($(this).val().slice(0,field.selectionStart)+str+$(this).val().slice(field.selectionStart,len));
                this.iSelectField(selPos+str.length);
            };
        },
        /*
         * 删除光标前面(-)或者后面(+)的n个字符
         */
        iDelField:function(n){
            var field=this.get(0);
            var pos=$(this).iGetFieldPos();
            var v=$(this).val();
            //大于0则删除后面，小于0则删除前面
            $(this).val(n>0 ? v.slice(0,pos-n)+v.slice(pos) : v.slice(0,pos)+v.slice(pos-n));
            $(this).iSelectField(pos-(n<0 ? 0 : n));
        }
    });
})(jQuery);

var mySwiper = new Swiper('.swiper-containerex',{
	mode:'horizontal',
	pagination:'.expagination',
	paginationClickable: true,
	loop: false 
});
var emperssion=new Array();
$(function(){
	$('.font-expre').click(function(e) {
		if($('.font-expre').hasClass("ex-show")){
		    expression();
		}
		else{
		    font();
		}
	});
	$(".delete").click(function(e) {
		var s = $("#comment").val();
		s=s.substring(0,s.length-1)
		$("#comment").val(s);
		handle()
	});
	$("#comment").focus(function(e) {
		if(!$('.font-expre').hasClass("ex-show")){
		    font();
		}
	});
	
	var i=0;
	$('.expression img[data-em]').click(function(e) {
		$("#comment").val($("#comment").val()+$(this).attr("data-icon"));
		emperssion[i]=new Array();
		emperssion[i][0]=$(this).attr("data-icon");
		emperssion[i][1]=$(this).attr("data-em");
		i++;
		handle()
	});
//	$("#commentBtn").click(function(){
//		if(!$('.font-expre').hasClass("ex-show")){
//		    font();
//		}
//		var str = $("#comment").val();
//		for(var i=0; i<emperssion.length; i++){
//			str=str.replace(emperssion[i][0], emperssion[i][1]);
//		}
//		//$("#show").html(replace_em(str));
//		$("#comment").val("");
//	});
});

//文字
function font(){
	$(".exbottom").css({"opacity":"0","height":"0"});
	$("#scrolltotal").toggleClass("scrollimg");
	$(".scroll").css("bottom","57px");
	$(".scrollimg").css({"position":"static","bottom":"0"});
	$('.font-expre').css({"background":"url(/community/js/activity/arclist/bq.png) no-repeat center center #eeeeee","background-size":"20px 20px","-webkit-background-size":"20px 20px"});
	$('.font-expre').addClass("ex-show");
}
//表情
function expression(){
    $(".exbottom").css({"opacity":"1","height":"200px"});
	$("#scrolltotal").toggleClass("scrollimg");
	$(".scroll").css("bottom","257px");
	$('.font-expre').css({"background":"url(/community/js/activity/arclist/wz.png) no-repeat center center #eeeeee","background-size":"14px 14px","-webkit-background-size":"14px 14px"});
	$('.font-expre').removeClass("ex-show");	
}
//查看结果
function replace_em(str){
	str = str.replace(/\[d_f0([0-9]*)\]/g,'<img src="/community/js/activity/arclist/$1.png" border="0" />');
	return str;
}