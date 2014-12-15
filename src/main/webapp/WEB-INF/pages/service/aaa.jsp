<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,user-scalable=no"/>
<title>信息详情</title>
<link href="${ctx }/js/activity/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx }/css/showLoading.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="x-main">
    <div class="x-total">
        <div class="x-infor">
            <p class="x-xt"><span class="x-xdd">${publisherName}</span> <span class="x-xsj"><fmt:formatDate value="${publishTime }" pattern="yyyy-MM-dd HH:mm"/></span></p>
            <hr class="x-line">
            <div class="x-head">
    	        <a class="x-pto"><img src="images/tx.jpg"></a>
                <p class="x-title"><span>${title}</span></p>
            </div>
        </div>
        <div class="x-content">
            <div class="x-cx">
                ${newsContent}
            </div>
            <hr/>
            <div class="x-zs1">
                <span class="x-z1">
                    <a><img src="images/zk.png"></a>
                    <em>${supports}</em>
                </span>
<!--                <span class="x-s1">
                    <a><img src="images/share.png"></a>
                    <em>123</em>
                </span>-->
            </div>
        </div>
    </div>
    <div class="x-total x-pl">
        <p class="x-pc">全部评论(<span>${commentCount }</span>)</p>
        <div>
        
        	<c:forEach items="${commentList }" var="comment">
	            <dl class="s-clt">
	                <dt>
	                    <a href="#" class="pto"><img src="${ctx }/static/images/tx1.png"></a>
	                </dt>
	                <dd>
	                    <div class="info">
	                        <span class="nine">${comment.commentorName}</span>
	                        <span class="time">${comment.commentTime}</span>
	                    </div>
	                    <div class="one">${content}</div>
	                </dd>
	            </dl>
            </c:forEach>
        
        </div>
        <hr style="border: 1px solid #e8e8e8; margin:10px -10px;">
        <a class="more" id="nextBtn"><span id="curr">1</span></a>
    </div>
    <input type="hidden" name="pageCount" id="pageCount" value="${pager.pageCount}" />
   <div class="x-inp">
        <div>
           <span><input type="text" class="x-inc" name="" placeholder="请输入您要回复的内容..."></span>
           <span><input type="button" value="发送"></span>
        </div>
    </div>
</div>
<script src="${ctx }/js/activity/js/jquery-1.7.2.min.js"></script>
<script src="${ctx }/js/activity/js/script.js"></script>
<script src="${ctx }/js/jquery.showLoading.min.js"></script>
<script>
/*赞*/
$(document).ready(function(){
	 $('.x-z a').click(function(){
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
	 });
	 

		//点赞
		 $('.x-z a').click(function(){
		 	$.ajax({
	           url: '${ctx}/service/commiunity/supportJournalism.json',
	           cache: false,
	           data: {
	           	ID: 1,
	           	sessionid: 'aaaa', 
	           	userId: 1
	           },
	           success: function (data) {
	               $('.x-z a').append('<em class="x-add">+1</em>');
					$('.x-z img').attr("src","images/ze.png");
					$('.x-z img').attr("disabled",true);
					$('.x-z em').css("color","#e41212");
			        $('.x-add').css({'position':'absolute', 'color':'#FF0000','left':'0px','top':'0px'}).animate({top:'-30px',left:'0px'},'slow',function(){
			          $(this).fadeIn('fast').remove();
			          var Num = parseInt($('.x-z em').text());
			          Num++;
			          $('.x-z em').text(Num);
					  $('.x-z img').attr("src","images/zk.png");
					  $('.x-z em').css("color","#030303");
			        });
	           },
	           error: function() {
	               alert('评论失败');
	           }
	       });
		 });
		
		//评论
		 $('#commentBtn').click(function() {
		 	var content = $('#comment').val();
		 	if(content != '') {
		 		$.ajax({
		 		    url: '${ctx}/service/commiunity/saveJournalismReview.json',
		 		    cache: false,
		 		    data: {
		 		    	ID: 1,
		 	           	sessionid: 'aaaa', 
		 	           	userId: 1,
		 		    	content: content
		 		    },
		 		    success: function (data) {
		 		    	alert('评论成功');
		 		    	$('#comment').attr('disabled', true);
		 		    	var newContent = ''
		 		      	+ '<dl class="s-clt">'
						+ '<dt>'
						+ '<a href="#" class="pto"><img src="${ctx}${protrait}"></a>'
						+ '</dt>'
						+ '<dd>'
						+ '<div class="info">'
						+ '<span class="nine">${realName }</span>'
						+ '<span class="time">时间</span>'
						+ '</div>'
						+ '<div class="one">'+content+'</div>'
						+ '</dd>'
						+ '</dl>';
		 				$('#comments').append(newContent);
		 		    },
		 		    error: function () {
		 		        alert('评论失败');
		 		    }
		 		});
		 	}else{
		 		alert('评论不能为空');return;
		 	}
		 });
		
		$('#nextBtn').click(function() {
			var currNo = $('#curr').text();
		 	var nextNo = parseInt(currNo) + 1;
		 	var pageCount = $('#pageCount').val();
		 	alert('pageCount   '+pageCount + ' currNo '+currNo);
		 	if(nextNo > pageCount) {
		 		nextNo = pageCount;
		 		$('#curr').text('亲已经到底了');
		 		$('#nextBtn').attr('disabled', true);
		 		return;
		 	}else{
		 		jump(nextNo);
		 	}
		});
		
 });
 
//获取下页评论内容
function jump(nextNo) {
	alert('nextNo   '+nextNo);
	$.ajax({
			type: 'post',
		    url: '${ctx}/service/commiunity/getJournalismReviewById.json',
		    cache: false,
		    data: {
		    	ID: 1,
	           	sessionid: 'aaaa', 
	           	userId: 1,
		    	page: nextNo
		    },
		    success: function (data) {
		    	eval('data=' + data);
		    	$('#curr').text(nextNo);
                var rows = data.content.reviewList;
                if(rows.length > 0) {
                	for(var i=0;i<rows.length;i++) {
                		var row = rows[i];   
                		var newContent = ''
            		    + '<dl class="s-clt">'
            			+ '<dt>'
            			+ '<a href="#" class="pto"><img src="${ctx}'+row.avatar+'"></a>'
            			+ '</dt>'
            			+ '<dd>'
            			+ '<div class="info">'
            			+ '<span class="nine">'+row.name+'</span>'
            			+ '<span class="time">'+row.commentTime+'</span>'
            			+ '</div>'
            			+ '<div class="one">'+row.content+'</div>'
            			+ '</dd>'
            			+ '</dl>';
            			$('#comments').append(newContent);
                	}
                }
		    },
		    error: function () {
		        alert('获取下页评论内容失败');
		    }
		});
}
</script>
</body>
</html>
