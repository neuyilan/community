<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<script src="<%=ctx %>/js/ajaxUpload.js" type="text/javascript" ></script>

<div id="picUploadLayer1" class="busswi5 s-xw-bu">
	<div id="picUploadBar1" class="sidebar5 s-xw-si s-xw-show">
		<a id="close5" title="关闭" href="javascript:;" onclick="onClose()"></a>
		<h2 class="tit4">多图片上传</h2>
		<div>
			<ul class="accordion4">
				<br />
				<li id="one4" class="files"><span class="add4"></span>
					<div class="uploadImg">
						<input id="hidImgName1" type="text" style="display: none;" value="">
						<input id="btnUploadImg1" class=" " type="button" value="点击浏览上传" style="margin-left: 5px; font-size: 22px;">
					</div></li>
				<ul id="imageShow1" class="sub-menu4"> </ul>
			</ul>
		</div>
	</div>
</div>

<script type="text/javascript">
	function onClose() {
		$('#picUploadLayer1').fadeOut('slow');
		$('#imageShow1').html("");
	}
//初始化上传动作 
////第四个参数flag为是否显示默认图片
function uploadInit1(folderName, fieldName, imgType, flag, type) {	
	// 获取添加的img路径
	var arr = new Array();
	$("img").each(function() {
		 if($(this).attr("class") == "lilabel") {
		 	arr.push($(this).attr("src"));
		 }
	});
	
	if(arr.length > 0){
		 for(var i=0; i<arr.length; i++) {
			 $('#imageShow1').append(
		          '<li id="li_'+arr[i].substring(arr[i].lastIndexOf('/')+1,arr[i].lastIndexOf('.'))+'">'+
		          '<a href="#">'+
		          '<img src="'+arr[i]+'" width="107" height="107">'+
		          '</a>'+
		          '<span class="delet4" id="btnDeleteImg" onclick="delImg1(\''+fieldName+'\', \''+arr[i].substring(arr[i].lastIndexOf('/')+1,arr[i].lastIndexOf('.'))+'\',\''+arr[i].substring(arr[i].lastIndexOf('/image'))+'\')"></span>'+
		          '</li> '
		     );
		 }
	}
	
	//展示上传层
	$('#btnUploadImg1').click(function() {
		//初始化图片上传
	    var imgUploadBtn = $("#btnUploadImg1");
	    var imgShow = $("#imageShow1");
	    var hidImgName1 = $("#hidImgName1");
	    g_AjxUploadImg1(imgUploadBtn, imgShow, hidImgName1, folderName, type);
	});
	$('#btnUploadImg1').click();
}

//图片上传
function g_AjxUploadImg1(imgUploadBtn, imgShow, hidImgName1, folderName, type) {
	var button = imgUploadBtn, interval;
	//alert(path);
	new AjaxUpload(button, {
	    action: '<%=ctx %>/PicUploadServlet?folderName='+folderName,
	    cache: false,
	    headers:{'Cache-Control':'no-cache'},
	    async: false,
	    name: 'myfile',
	    onSubmit: function(file, ext) {
	        if (!(ext && /^(jpg|JPG|png|PNG|gif|GIF)$/.test(ext))) {
	            alert("您上传的图片格式不对，请重新选择！");
	            return false;
	        }
	    },
	    onComplete: function(file, response) {
	        var imgpath = response;
	        if(response.indexOf("<pre") == 0) {
	        	imgpath = $(imgpath).first().text();
	        }
			
	    	hidImgName1.value = imgpath;
	        var uploadField1 = $('#uploadField1').val();
        	if(imgpath != null || imgpath != ""){
        		
        		if(type == 'i') {
        			var htmlDom = '<label id="img_'+imgpath.substring(imgpath.lastIndexOf('/')+1,imgpath.lastIndexOf('.'))+'"><img class="lilabel" src="<%=ctx%>'+imgpath+'" width="130" height="130"  style="float:left; padding-top:20px; padding-right:20px;"></label>';
            		$("#voteTypeImgDiv").append(htmlDom);
        		} else if(type == 'ci') {
        			var htmlDom = '<div id="actpublish_'+imgpath.substring(imgpath.lastIndexOf('/')+1,imgpath.lastIndexOf('.'))+'" class="actpublish "><label id="img_'+imgpath.substring(imgpath.lastIndexOf('/')+1,imgpath.lastIndexOf('.'))+'"><img class="lilabel" src="<%=ctx%>'+imgpath+'" width="130" height="130"></label>'
        			+'&nbsp;&nbsp;&nbsp;&nbsp;<label id="content_'+imgpath.substring(imgpath.lastIndexOf('/')+1,imgpath.lastIndexOf('.'))+'"><input type="text" class="iptnewtit"  name="content" style="width:240px"  placeholder="请输入选项内容" /></label><div>';
        			$("#voteTypeConImgDiv").append(htmlDom);
        		}
        	} else {
        		alert("图片路径不存在！");
        	}
	        $('#'+uploadField1).val($('#'+uploadField1).val()+'#'+imgpath);
	        $('#imageShow1').append(
              '<li id="li_'+imgpath.substring(imgpath.lastIndexOf('/')+1,imgpath.lastIndexOf('.'))+'">'+
              '<a href="#">'+
              '<img src="<%=ctx%>'+imgpath+'" width="107" height="107">'+
              '</a>'+
              '<span class="delet4" id="btnDeleteImg" onclick="delImg1(\''+uploadField1+'\', \''+imgpath.substring(imgpath.lastIndexOf('/')+1,imgpath.lastIndexOf('.'))+'\',\''+imgpath+'\')"></span>'+
              '</li> ');
	    }
	});
}

function delImg1(uploadField1, img_id, imgpath){
	if(confirm('确认删除该图片吗?')){
	  $.ajax({
		  url: '<%=ctx%>/image/delImage.do',
		  data: {picPath: imgpath},
		  method: 'post',
		  success: function(data) {
			  eval('data=' + data);
			  alert(data.message);
			  var img = "";
			  var uf = $('#'+uploadField1).val();
			  
			  var ufimg = uf.substring(1).split("#");
			  for(var i=0; i<ufimg.length; i++) {
				  if(ufimg[i] !=imgpath) {
					  img = img + "#" + ufimg[i];
				  } 
			  }
			  $('#img_'+img_id).empty();
			  $('#content_'+img_id).empty();
			  $('#actpublish_'+img_id).empty();
			  $('#li_'+img_id).empty();
			  $('#'+uploadField1).val(img);
		  },
		  error: function() {
			  alert('删除失败');
		  }
	  });
	}
}
</script>