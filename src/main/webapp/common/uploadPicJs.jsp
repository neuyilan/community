<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<script src="<%=ctx %>/js/ajaxUpload.js" type="text/javascript" ></script>

<!-- 图片上传开始 -->
	<div id="picUploadLayer" class="busswi5 s-xw-bu">
        <div id="picUploadBar" class="sidebar5 s-xw-si s-xw-show">
            <a id="close5" title="关闭" href="javascript:;" onclick="$('#picUploadLayer').fadeOut('slow');"></a>
	        <h2 class="tit4">图片上传</h2>
	        <div>
	            <ul class="accordion4"><br />
	                <li id="one4" class="files"><span class="add4"></span>
	                    <div class="uploadImg">
<input id="hidImgName" type="text" style="display:none;" value="">
<input id="btnUploadImg" class=" " type="button" value="点击浏览上传" style="margin-left:5px; font-size:22px; ">
</div>
	                </li>
	                <ul id="imageShow" class="sub-menu4"> </ul>
	                
	                <!-- 显示默认图片列表 -->
	                <ul id="defaultImgs" class="s-xw-dimg"></ul>
	            </ul>
        </div>
        </div>
    </div>
<!-- 列表页大图大图结束 -->
<script>
function getImagesById(imgpath) {
	/*$.post("<%=path %>/business/businessImages/getImagesDetail.do", {imgId : imgId}, function(data) {
    	eval("data = "+data);
    	console.log(data)
     });*/
	var uploadField = $('#uploadField').val();
     $('#'+uploadField).val(imgpath);
    $('#'+uploadField+'Btn').attr('src', '<%=ctx%>'+imgpath);
}

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
	            	var htmlDom = '<li>暂无默认图片！</li>';
	            	//$('#defaultImgs').html(htmlDom);
	            }
	        },
	        error: function () {
	        	//$('#defaultImgs').html('很抱歉，加载内容出错，我们及时修改问题。');
	        }
	    });
	}
	$('#imageShow').empty();
	var uploadField = $('#uploadField').val();
	
	if(uploadField != '' && uploadField == fieldName) {
		$('#'+uploadField).val('');
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
        	//alert('file   '+file + '    response   '+response);
            
            /*
            var flagValue = response;
            if (flagValue == "1") {
                alert("您上传的图片格式不对，请重新选择！");
            }
            else if (flagValue == "2") {
                alert("您上传的图片大于200K，请重新选择！");
            }
            else if (flagValue == "3") {
                alert("图片上传失败！");
            }else {
            	
            } */
            var imgpath = response;
            //alert('s   '+response.indexOf("<pre"));
            if(response.indexOf("<pre") == 0) {
            	imgpath = $(imgpath).first().text();
            	//alert('imgpath   '+imgpath);
            }
        	hidImgName.value = imgpath;
        	//alert('adfasd   '+hidImgName.value);
            var uploadField = $('#uploadField').val();
            //alert('uploadField  '+uploadField+'         imgpath  '+imgpath);
            $('#'+uploadField).val(imgpath);
            $('#'+uploadField+'Btn').attr('src', '<%=ctx%>'+imgpath);
            $('#imageShow').empty();
            $('#imageShow').append(
                    '<li>'+
                    '<a href="#">'+
                    '<img src="<%=ctx%>'+imgpath+'" width="107" height="107">'+
                    '</a>'+
                    '<span class="delet4" id="btnDeleteImg" onclick="delImg(\''+imgpath+'\')"></span>'+
                    '</li> ');
            //展示小图
            $('#block4').attr('src', imgpath);
        }
    });
}

function delImg(imgpath){
  if(confirm('确认删除该图片吗?')){
	  $.ajax({
		  url: '<%=ctx%>/image/delImage.do',
		  data: {picPath: imgpath},
		  method: 'post',
		  success: function(data) {
			  eval('data=' + data);
			  alert(data.message);
			  $('#imageShow').empty();
			  $('#subjectPic').val('');
		  },
		  error: function() {
			  alert('删除失败');
		  }
	  });
  }
}
</script>