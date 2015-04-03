<%@ page language="java" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<script type="text/javascript" src="<%=ctx %>/js/jquery-easyui/jquery.easyui.min.js"></script>
<script src="<%=ctx %>/js/jquery.validate.min.js" type="text/javascript"></script>
<script src="<%=ctx %>/js/messages_zh.js" type="text/javascript"></script>
<script src="<%=ctx %>/js/ajaxUpload.js" type="text/javascript"></script>
<style type="text/css">
	label.error { color: Red; font-size: 13px; margin-left: 5px; padding-left: 16px; }
</style>
<script type="text/javascript">
$(function () {
	//APP小图
	$('#prizePicBtn').click(function() {
		$('#picUploadLayerJpsz').fadeIn('slow');
		//初始化上传
    	uploadInitJpsz('prizePic');
    	$('#uploadFieldJpsz').val('prizePic');
	}); 
	
    //验证表单
    $('#ffJpsz').validate({
        submitHandler:function(form){
        	if($('#prizeAction').val() == "add") {
        		$('#prizeConcat').val($('#prizeConcat').val()+"@@"+$('#prizePic').val()+"##"+$('#awardName').val()+"##"+$('#prizeName').val()+"##"+$('#rankStart').val()+"##"+$('#rankEnd').val()+"##"+$('#prizeDesc').val());
        		$('#prizeConcatDiv').empty();
            	var prizeConcat = $('#prizeConcat').val().substring(2);
            	var prizeConcatSplit=prizeConcat.split("@@");      
                for (var i=0; i<prizeConcatSplit.length ;i++ ) {   
                	var prizeArr = prizeConcatSplit[i].split("##"); 
                   	var htmlDom = ""
                   		+'<div id="prizeArr'+i+'" style="overflow:hidden; margin-bottom:20px;"><img src="<%=ctx %>'+prizeArr[0]+'" width="191" height="191" style="float:left; padding-right:10px;">'
           				+'<div style="color:#000;">'
           				+'<p style="height:42px; margin:10px 0;">奖项名称：<span id="awardName'+i+'">'+prizeArr[1]+'</span></p>'
           				+'<p style="height:42px; margin-bottom:10px;">奖品名称：<span id="prizeName'+i+'">'+prizeArr[2]+'</span></p>'
           				+'<p style="height:42px; margin-bottom:10px;">获奖名次：排名<span id="rankStart'+i+'">'+prizeArr[3]+'</span>名至<span id="rankEnd'+i+'">'+prizeArr[4]+'</span>名</p>'
           				+'<a style="color:#0000ff; cursor:pointer;" onclick="editPrizeConcat(\'edit\', \''+i+'\')">编辑</a>'
           				+'</div>'
           				+'</div>';
                   	$('#prizeConcatDiv').append(htmlDom);
                }
                $('#prizePic').val("");
                $('#awardName').val("");
                $('#prizeName').val("");
                
                var prizeConcat2 = $('#prizeConcat').val().substring(2);
            	var prizeConcatSplit2=prizeConcat2.split("@@");     
            	if($('#prizeConcat').val() != '') {
            	    for (var i=0; i<prizeConcatSplit2.length ;i++ ) {   
            	    	if(i+1 == prizeConcatSplit2.length) {
            	    		var prizeArr1 = prizeConcatSplit2[i].split("##"); 
            	    	    $('#rankStart').val(parseInt(prizeArr1[4])+1);
            	    	}
            	    }
            	} else {
            		$('#rankStart').val("1");
            	}
            	
                $('#rankEnd').val("");
                $('#functionId').val("");
                $('#prizeDesc').val("");
                $('#prizePicBtn').attr('src', '<%=ctx %>/images/icon/add.jpg');
                ue2.setContent("");
                $('#imageShowJpsz').empty();
        	} else if($('#prizeAction').val() == "edit") {
        		var prizeConcat = $('#prizeConcat').val().substring(2);
            	var prizeConcatSplit=prizeConcat.split("@@");  
            	var concatHtmlDom = "";
                for (var i=0; i<prizeConcatSplit.length ;i++ ) {   
                	if($('#functionId').val() == i) {
                		concatHtmlDom += "@@"+$('#prizePic').val()+"##"+$('#awardName').val()+"##"+$('#prizeName').val()+"##"+$('#rankStart').val()+"##"+$('#rankEnd').val()+"##"+$('#prizeDesc').val();
                	} else {
                		if((parseInt($('#functionId').val())+1) == i) {
                    		var split = prizeConcatSplit[i].split("##");
                    		split[3] = parseInt($('#rankEnd').val()) + 1;
                    		concatHtmlDom += "@@"+split[0]+"##"+split[1]+"##"+split[2]+"##"+split[3]+"##"+split[4]+"##"+split[5];
                		} else {
                    		concatHtmlDom += "@@"+prizeConcatSplit[i];
                		} 
                		// concatHtmlDom += "@@"+prizeConcatSplit[i];
                	}
                }
                $('#prizeConcat').val(concatHtmlDom);
        		$('#prizeConcatDiv').empty();
            	var prizeConcat1 = concatHtmlDom.substring(2);
            	var prizeConcatSplit1=prizeConcat1.split("@@");     
                for (var i=0; i<prizeConcatSplit1.length ;i++ ) {   
                	var prizeArr1 = prizeConcatSplit1[i].split("##"); 
                   	var htmlDom = ""
                   		+'<div id="prizeArr'+i+'" style="overflow:hidden; margin-bottom:20px;"><img src="<%=ctx %>'+prizeArr1[0]+'" width="191" height="191" style="float:left; padding-right:10px;">'
           				+'<div style="color:#000;">'
           				+'<p style="height:42px; margin:10px 0;">奖项名称：<span id="awardName'+i+'">'+prizeArr1[1]+'</span></p>'
           				+'<p style="height:42px; margin-bottom:10px;">奖品名称：<span id="prizeName'+i+'">'+prizeArr1[2]+'</span></p>'
           				+'<p style="height:42px; margin-bottom:10px;">获奖名次：排名<span id="rankStart'+i+'">'+prizeArr1[3]+'</span>名至<span id="rankEnd'+i+'">'+prizeArr1[4]+'</span>名</p>'
           				+'<a style="color:#0000ff; cursor:pointer;" onclick="editPrizeConcat(\'edit\', \''+i+'\')">编辑</a>'
           				+'</div>'
           				+'</div>';
                   	$('#prizeConcatDiv').append(htmlDom);
                }
        		$('#prizeAction').val("add");
        		$('#prizePic').val("");
                $('#awardName').val("");
                $('#prizeName').val("");
                
                var prizeConcat2 = $('#prizeConcat').val().substring(2);
            	var prizeConcatSplit2=prizeConcat2.split("@@");     
            	if($('#prizeConcat').val() != '') {
            	    for (var i=0; i<prizeConcatSplit2.length ;i++ ) {   
            	    	if(i+1 == prizeConcatSplit2.length) {
            	    		var prizeArr1 = prizeConcatSplit2[i].split("##"); 
            	    	    $('#rankStart').val(parseInt(prizeArr1[4])+1);
            	    	}
            	    }
            	} else {
            		$('#rankStart').val("1");
            	}
            	
                $('#rankEnd').val("");
                $('#functionId').val("");
                $('#prizeDesc').val("");
                $('#prizePicBtn').attr('src', '<%=ctx %>/images/icon/add.jpg');
                ue2.setContent("");
                $('#imageShowJpsz').empty();
        	} 
        	$('#picUploadLayerJPTP').fadeOut('slow');
        },
        errorClass: "error",
        success: function(label) {
            label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
        },
        rules: {
        	prizePic: {
                required: true
            },
            awardName: {
                required: true,
                maxlength : 60
            },
            prizeName: {
                required: true,
                maxlength : 14
            },
            rankEnd: {
                required: true,
                digits: true
            },
            prizeDesc: {
            	required: true
            }
        },
        messages: {
        	prizePic: {
                required: '请上传奖品展示小图！'
            },
            awardName: {
            	required: '请填写奖项名称！',
                maxlength: '奖项名称为60字以内'
            },
            prizeName: {
            	required: '请填写奖品名称！',
                maxlength: '奖品名称为14字以内'
            },
            rankEnd: {
                required:  '请输入到多少名止！',
                digits: '排名截止必须为数字' 
            },
            prizeDesc: {
                required: '请输入奖品图文描述！'
            }
        }
    });
});

function closePrizeConcat() {
	$('#prizePic').val("");
    $('#awardName').val("");
    $('#prizeName').val("");
	
    var prizeConcat2 = $('#prizeConcat').val().substring(2);
	var prizeConcatSplit2=prizeConcat2.split("@@");     
	if($('#prizeConcat').val() != '') {
	    for (var i=0; i<prizeConcatSplit2.length ;i++ ) {   
	    	if(i+1 == prizeConcatSplit2.length) {
	    		var prizeArr1 = prizeConcatSplit2[i].split("##"); 
	    	    $('#rankStart').val(parseInt(prizeArr1[4])+1);
	    	}
	    }
	} else {
		$('#rankStart').val("1");
	}
    $('#rankEnd').val("");
    $('#prizeDesc').val("");
    $('#prizeAction').val("add");
    $('#functionId').val("");
    $('#prizePicBtn').attr('src', '<%=ctx %>/images/icon/add.jpg');
    ue2.setContent("");
    $('#imageShowJpsz').empty();
    
	$('#picUploadLayerJPTP').fadeOut('slow');
}

function editPrizeConcat(edit, functionId) { 
	console.log($('#prizeConcat').val().substring(2));
	var prizeConcat2 = $('#prizeConcat').val().substring(2);
   	var prizeConcatSplit2=prizeConcat2.split("@@");   
   	if($('#prizeConcat').val() != '') {
   	    for (var i=0; i<prizeConcatSplit2.length ;i++ ) {   
   	    	if(i == functionId) {
   	    		var prizeArr2 = prizeConcatSplit2[i].split("##"); 
   	    		$('#prizePic').val(prizeArr2[0]);
   	    	    $('#awardName').val(prizeArr2[1]);
   	    	    $('#prizeName').val(prizeArr2[2]);
   	    	    $('#rankStart').val(prizeArr2[3]);
   	    	    $('#rankEnd').val(prizeArr2[4]);
   	    	    $('#prizeDesc').val(prizeArr2[5]);
   	    	    $('#prizeAction').val(edit);
   	    	    $('#functionId').val(functionId);
   	    	    $('#prizePicBtn').attr('src', '<%=ctx %>'+prizeArr2[0]);
   	    	    ue2.setContent(prizeArr2[5]);
   	    	    $('#imageShowJpsz').html(
   	    	      '<li>'+
   	    	      '<a href="#">'+'<img src="<%=ctx%>'+prizeArr2[0]+'" width="200" height="200">'+'</a>'+
   	    	      '<span class="delet4" id="btnDeleteImg" onclick="delImgJpsz(\''+prizeArr2[0]+'\')"></span>'+
   	    	      '</li> '
   	    	     );
   	    	}
   	    }
   	}
    $('#picUploadLayerJPTP').fadeIn('slow');
}
</script>
<!-- 图片上传开始 -->
<div id="picUploadLayerJPTP" class="busswi5 s-xw-bu">
	<div id="picUploadBarJPTP" class="sidebar5 s-xw-si s-xw-show" style="width:900px;">
		<a id="close5" title="关闭" href="javascript:;" onclick="closePrizeConcat()"></a>
		<h2 class="tit4" style="margin-left:50px;">添加奖品</h2>
		<div class="line2" style="width:700px; margin-left:50px;"></div>
		
		<div class="newsrel">
			<div class="cont-l">
				<form id="ffJpsz">
					<h2 class="relran" style="font-weight: bold;">奖品展示小图<span style="font-weight: normal; font-size: 16px;">【用于奖品列表页展示】</span><label for="prizePic" class="error success"></label></h2>
					<div id="divImg" style="overflow: hidden;">
						<img id="prizePicBtn" src="<%=ctx %>/images/icon/add.jpg" width="200" height="200" style="float: left; padding-right: 10px;">
						<div style="color:#000; padding-top:26px;"><label style="font-weight:bold; color:#ff0000;">点击添加奖品</label>  请上传【宽300PX、高300PX】jpg格式图片<br>图片大小不能超过30K!</div>
					</div>
					<input type="hidden" name="prizePic" id="prizePic" value="">
	            	<input type="hidden" name="uploadFieldJpsz" id="uploadFieldJpsz" value="">
	            	<input type="hidden" name="prizeAction" id="prizeAction" value="add">
	            	<input type="hidden" name="functionId" id="functionId" value="">
					<div class="line2" style="width:700px;"></div>
					奖项名称：<input style="width: 184px" class="iptnewtit" type="text" id="awardName" name="awardName" />
						   <label for="awardName" class="error success"></label>
						   
					<br>奖品名称：<input style="width: 347px" class="iptnewtit" type="text" name="prizeName" id="prizeName" placeholder="请输入不超过14个汉字" />
						   <label for="prizeName" class="error success"></label>
						   
					<h2 class="relran">获奖名次：<label for="rankEnd" class="error success"></label></h2>
					<div>
						排名<input style="width: 120px" class="iptnewtit" type="text" name="rankStart" id="rankStart" value="1" disabled/> 名
						<span style="color: #e7402f">至</span>
						<input style="width: 120px" class="iptnewtit" type="text" name="rankEnd" id="rankEnd" />名
					</div>
					<div class="line2" style="width:700px;"></div>
					
					<h2 class="newscont">奖品图文描述<label for="prizeDesc" class="error success"></label></h2>
		            <%--文本编辑器--%>
		            <script type="text/plain" id="prizeDescEditor" style="width:740px;height:240px;"></script>
		            <input type="hidden" name="prizeDesc" id="prizeDesc">
	            
					<div class="submtpres" style="margin-top:50px; margin-left:200px;">
						<input id="qrbut" type="button" value="确认提交" onclick="submitFormJpsz()" />
					</div>
				</form>
			</div>
		</div>

	</div>
</div>
<jsp:include page="/common/uploadJPTPActiveJpsz.jsp"/>

<script>
	//简单编辑器实例化
	var ue2 = UE.getEditor('prizeDescEditor',{
		toolbars: [[
			'fullscreen', 'source', 'removeformat', '|', 'undo', 'redo', '|', 'bold', 'underline', 'forecolor', 'backcolor', 'insertimage', 'justifyleft', 'justifycenter', 'justifyright'
			
			/* 'fullscreen', 'source', '|', 'undo', 'redo', '|',
	        'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
	        'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
	        'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|',
	        'directionalityltr', 'directionalityrtl', 'indent', '|',
	        'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
	        'link', 'unlink', 'anchor', '|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
	        'insertimage', 'map', 'pagebreak', 'template', 'background', '|',
	        'date', 'time', 'spechars', '|',
	        'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols', 'charts', '|',
	        'preview', 'searchreplace', 'help' */
		]]
	});
	
	//提交表单
	function submitFormJpsz() {
		$('#prizeDesc').val(ue2.getContent());
		$('#ffJpsz').submit();
	}
</script>