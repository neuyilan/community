<%@ page language="java" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<script src="<%=ctx %>/js/ajaxUpload.js" type="text/javascript"></script>

<!-- 图片上传开始 -->
<div id="picUploadLayerJpsz" class="busswi5 s-xw-bu">
	<div id="picUploadBarJpsz" class="sidebar5 s-xw-si s-xw-show">
		<a id="close5" title="关闭" href="javascript:;" onclick="$('#picUploadLayerJpsz').fadeOut('slow');"></a>
		<h2 class="tit4">上传奖品展示小图</h2>
		<div>
			<ul class="accordion4">
				<li id="one4" class="files"><span class="add4"></span>
					<div class="uploadImg">
						<input id="btnUploadImgJpsz" type="button" value="点击浏览上传" style="margin-left: 5px; font-size: 22px;">
					</div>
				</li>
				<ul id="imageShowJpsz" class="sub-menu4"></ul>
			</ul>
		</div>
	</div>
</div>
<script>
	//初始化上传动作 
	function uploadInitJpsz(folderName) {
		//展示上传层
	    $('#btnUploadImgJpsz').click(function() {
	  		//初始化图片上传
	  		
	        var imgUploadBtnJpsz = $("#btnUploadImgJpsz");
	        g_AjxUploadImgJpsz(imgUploadBtnJpsz, folderName);
	    });
	    $('#btnUploadImgJpsz').click();
	}
	
	//图片上传
	function g_AjxUploadImgJpsz(imgUploadBtnJpsz, folderName) {
	    var button = imgUploadBtnJpsz, interval;
	    new AjaxUpload(button, {
	        action: '<%=ctx %>/PicUploadServlet?folderName='+folderName,
	        data: {folderName: folderName},
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
	            var uploadFieldJpsz = $('#uploadFieldJpsz').val();
	            $('#'+uploadFieldJpsz).val(imgpath);
	            $('#'+uploadFieldJpsz+'Btn').attr('src', '<%=ctx%>'+imgpath);
	            $('#imageShowJpsz').empty();
	            $('#imageShowJpsz').append(
	             '<li>'+
	             '<a href="#">'+'<img src="<%=ctx%>'+imgpath+'" width="200" height="200">'+'</a>'+
	             '<span class="delet4" id="btnDeleteImg" onclick="delImgJpsz(\''+imgpath+'\')"></span>'+
	             '</li> '
	            );
	        }
	    });
	}
	
	function delImgJpsz(imgpath){
		if(confirm('确认删除该图片吗?')){
		  $.ajax({
			  url: '<%=ctx%>/image/delImage.do',
				data:{picPath:imgpath},
				method:'post',
				success:function(data) {
					var uploadFieldJpsz = $('#uploadFieldJpsz').val();
		            $('#'+uploadFieldJpsz).val("");
		            $('#'+uploadFieldJpsz+'Btn').attr('src', '<%=ctx %>/images/icon/add.jpg');
					eval('data=' + data);
					alert(data.message);
					$('#imageShowJpsz').empty();
				},
				error : function() {
					alert('删除失败');
				}
			});
		}
	}
</script>