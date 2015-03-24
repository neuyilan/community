<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<script src="<%=ctx %>/js/ajaxUpload.js" type="text/javascript" ></script>

<div id="picUploadLayer" class="busswi5 s-xw-bu">
	<div id="picUploadBar" class="sidebar5 s-xw-si s-xw-show">
		<a id="close5" title="关闭" href="javascript:;" onclick="$('#picUploadLayer').fadeOut('slow');"></a>
		<h2 class="tit4">多图片上传</h2>
		<div>
			<ul class="accordion4">
				<br />
				<li id="one4" class="files"><span class="add4"></span>
					<div class="uploadImg">
						<input id="hidImgName" type="text" style="display: none;" value="">
						<input id="btnUploadImg" class=" " type="button" value="点击浏览上传" style="margin-left: 5px; font-size: 22px;">
						<label id="maxCount" style="margin-left:15px; font-size:18px; color:Red;">最多只能上传6张图片！</label>
					</div></li>
				<ul id="imageShow" class="sub-menu4"> </ul>
			</ul>
		</div>
	</div>
</div>

<script type="text/javascript">

var count = 0;
//初始化上传动作 
////第四个参数flag为是否显示默认图片
function uploadInit(folderName, fieldName, imgType, flag) {
	// 显示默认图片
	if(flag == 1) {
		$('#defaultImgs').html("");
		$.ajax({
			type: 'post',
	        url: '<%=path %>/business/businessImages/list.do',
	        dataType: 'json',
	        data: {imgType: imgType},
	        cache: false,
	        success: function (data) {
	            var rows = data.rows;
	            if(rows.length > 0) {
	            	$('#defaultImgs').html("");
	            	for(var i=0;i<rows.length;i++) {
	                	var row = rows[i];  
	                	var htmlDom = ''
	                	+'<li>'
	                	+'<input type="radio" name="imgId" id="imgId'+row.imgId+'" value="'+row.imgId+'" onchange="getImagesById(\''+row.imgPath+'\')"/>'
	                	+'<div class="delinf">'
	                	+'<p><img src="<%=ctx%>'+row.imgPath+'"  width="100" height="100" ></p>'
	                	+'<p><a>'+row.imgName+'</a></p>'
	                	+'</div>'
	                	+'</li>';
	                	$('#defaultImgs').append(htmlDom);
	                }
	            }else{
	            }
	        },
	        error: function () {
	        }
	    });
	}
	
	$('#maxCount').hide();
	
	// 获取添加的img路径
	var arr = new Array();
	$("img").each(function() {
		 if($(this).attr("class") == "lilabel") {
		 	arr.push($(this).attr("src"));
		 }
	});
	if(arr.length > 0){
		 var uploadField = $('#uploadField').val();
		 if(count >= 6) {
        	$('#btnUploadImg').hide();
        	$('#maxCount').show();
         } 
		 for(var i=0; i<arr.length; i++) {
			 $('#imageShow').append(
		          '<li id="li_'+imgpath.substring(arr[i].lastIndexOf('/')+1,arr[i].lastIndexOf('.'))+'">'+
		          '<a href="#">'+
		          '<img src="<%=ctx%>'+imgpath+'" width="107" height="107">'+
		          '</a>'+
		          '<span class="delet4" id="btnDeleteImg" onclick="delImg(\''+uploadField+'\', \''+arr[i].substring(arr[i].lastIndexOf('/')+1,arr[i].lastIndexOf('.'))+'\',\''+arr[i].substring(arr[i].lastIndexOf('/image'))+'\')"></span>'+
		          '</li> '
		     );
		 }
	}
	 
	$('#imageShow').empty();
	var uploadField = $('#uploadField').val();
	if(uploadField != '' && uploadField == fieldName) {
	    $('#'+uploadField+'Btn').attr('src', '<%=ctx %>/images/icon/add.jpg');
	}
	
	//展示上传层
	$('#btnUploadImg').click(function() {
		//初始化图片上传
	    var imgUploadBtn = $("#btnUploadImg");
	    var imgShow = $("#imageShow");
	    var hidImgName = $("#hidImgName");
	    g_AjxUploadImg(imgUploadBtn, imgShow, hidImgName, folderName);
	});
	$('#btnUploadImg').click();
}

//图片上传
function g_AjxUploadImg(imgUploadBtn, imgShow, hidImgName, folderName) {
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
			
	    	hidImgName.value = imgpath;
	        var uploadField = $('#uploadField').val();
        	if(imgpath != null || imgpath != ""){
        		var htmlDom = '<label id="img_'+imgpath.substring(imgpath.lastIndexOf('/')+1,imgpath.lastIndexOf('.'))+'"><img class="lilabel" src="<%=ctx%>'+imgpath+'" width="100" height="100"  style="float:left; padding-right:10px;"></label>';
        		$("#divImg").append(htmlDom);
        	} else {
        		alert("图片路径不存在！");
        	}
	        $('#'+uploadField).val($('#'+uploadField).val()+'#'+imgpath);
	        $('#imageShow').append(
              '<li id="li_'+imgpath.substring(imgpath.lastIndexOf('/')+1,imgpath.lastIndexOf('.'))+'">'+
              '<a href="#">'+
              '<img src="<%=ctx%>'+imgpath+'" width="107" height="107">'+
              '</a>'+
              '<span class="delet4" id="btnDeleteImg" onclick="delImg(\''+uploadField+'\', \''+imgpath.substring(imgpath.lastIndexOf('/')+1,imgpath.lastIndexOf('.'))+'\',\''+imgpath+'\')"></span>'+
              '</li> ');
	        count++;
	        if(count >= 6) {
	        	$('#btnUploadImg').hide();
	        	$('#maxCount').show();
	        } 
	    }
	});
}

function delImg(uploadField, img_id, imgpath){
	if(confirm('确认删除该图片吗?')){
	  $.ajax({
		  url: '<%=ctx%>/image/delImage.do',
		  data: {picPath: imgpath},
		  method: 'post',
		  success: function(data) {
			  eval('data=' + data);
			  alert(data.message);
			  var img = "";
			  var uf = $('#'+uploadField).val();
			  
			  var ufimg = uf.substring(1).split("#");
			  for(var i=0; i<ufimg.length; i++) {
				  if(ufimg[i] !=imgpath) {
					  img = img + "#" + ufimg[i];
				  } 
			  }
			  $('#img_'+img_id).empty();
			  $('#li_'+img_id).empty();
			  $('#'+uploadField).val(img);
			  count--;
			  if(count < 6) {
				  $('#btnUploadImg').show();
	        	  $('#maxCount').hide();
	          }
		  },
		  error: function() {
			  alert('删除失败');
		  }
	  });
	}
}
</script>