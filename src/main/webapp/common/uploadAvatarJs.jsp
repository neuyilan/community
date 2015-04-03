<%@ page language="java" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String ctx = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
 <script type="text/javascript" src="<%=ctx %>/js/jquery-easyui/jquery.easyui.min.js"></script>
 <script src="<%=ctx %>/js/jquery.validate.min.js" type="text/javascript" ></script>
 <script src="<%=ctx %>/js/messages_zh.js" type="text/javascript" ></script>
<script src="<%=ctx %>/js/ajaxUpload.js" type="text/javascript"></script>
<style type="text/css">
        label.error  {
            color:Red;
            font-size:13px;
            margin-left:5px;
            padding-left:16px;
        }
</style>
<script type="text/javascript">
$(function () {
	var flag = false;
    //验证表单
    $('#ffAvatar').validate({
        submitHandler:function(form){
        	if(flag == true) {
        		return;
        	}else{
        		flag = true;
        	}
            $('#qrbut5').attr("disabled","disabled");
            $('#ffAvatar').form('submit', {
                success:function(data){
                    var data = eval('(' + data + ')');  // 改变json对象为javascript对象
                    alert(data.message);
                    window.location.href = '<%=ctx%>/business/businessActivity/viewJPTPInformation.do?actId=' + $("#actId").val();
                }
            });
        },
        errorClass: "error",
        success: function(label) {
            label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
        },
        rules: {
        	avatar: {
                required: true
            }
        },
        messages: {
        	avatar: {
                required: '请上传展示或选择默认头像！'
            }
        }
    });
});
</script>
<!-- 图片上传开始 -->
<div id="picUploadLayerAvatar" class="busswi5 s-xw-bu">
	<div id="picUploadBarAvatar" class="sidebar5 s-xw-si s-xw-show" style="position: fixed; overflow: hidden; float: right;">
		<a id="close5" title="关闭" href="javascript:;" onclick="cancleAvatar()"></a>
		<h2 class="tit4">上传展示头像</h2><br>
		<div id="wrapper-250">
			<span style="margin-left:6px; font-weight:normal;font-size: 18px; color:#ff3300;">(点击浏览上传图片，或在下面报名人相册中选择)</span>
			<form id="ffAvatar" action="<%=ctx%>/business/businessActReg/saveStartVote.do" method="post">
				<div>
					<ul class="accordion4"><br />
						<li id="one4" class="files"><span class="add4"></span>
							<div class="uploadImg">
								<input id="btnUploadImgAvatar" type="button" value="点击浏览上传" style="margin-left: 5px; font-size: 22px;"><label for="avatar" class="error success"></label>
								<input type="hidden" name="regIdAvatar" id="regIdAvatar" value="" />
								<input type="hidden" name="action" id="action" value="" />
								<input type="hidden" name="avatar" id="avatar" value="" />
								<input type="hidden" name="picUrlAvatar" id="picUrlAvatar" value=""> 
								<input type="hidden" name="contentAvatar" id="contentAvatar" value=""> 
							</div>
						</li>
						<ul id="imageShowAvatar" class="sub-menu4"></ul>
						<!-- 显示默认图片列表 -->
		                <ul id="defaultImgs" class="s-xw-dimg"></ul>
					</ul>
				</div>
				
		   	</form>
		</div>
		<div class="s-xw-zd">
    		<div class="link6"></div>
       		<div class="submtpres">
           		<input id="qrbut5" title="确认" type="button" value="确认"  onclick="submitFormAvatar()"/>
				<input id="zsbut5" title="取消" type="button" value="取消" onclick="cancleAvatar()"/>
       		</div>
   		</div>
	</div>
	
</div>
<script>
	function getImagesById(imgpath) {
		$('#avatar').val(imgpath);
		$('#imageShowAvatar').empty();
        $('#imageShowAvatar').append(
         '<li>'+
         '<a href="#">'+'<img src="<%=ctx%>'+imgpath+'" width="200" height="200">'+'</a>'+
         '</li> '
        );
	}
	
	function cancleAvatar() {
		$('#picUploadLayerAvatar').fadeOut('slow');
		$('#avatar').val("");
		$('#imageShowAvatar').empty();
	}
	
	//初始化上传动作 
	function uploadInitAvatar(folderName, action, regId1) {
		$.ajax({
			type: 'post',
	        url: '<%=path %>/business/businessRegPic/list.do',
	        dataType: 'json',
	        data: {regId: regId1},
	        cache: false,
	        success: function (data) {
	            var rows = data.rows;
	            if(rows.length > 0) {
	            	$('#defaultImgs').html("");
	            	for(var i=0;i<rows.length;i++) {
	                	var row = rows[i];  
	                	var htmlDom = ''
	                	+'<li>'
	                	+'<input type="radio" name="picId" id="picId'+row.picId+'" value="'+row.picId+'" onchange="getImagesById(\''+row.picUrl+'\')"/>'
	                	+'<div class="delinf">'
	                	+'<p><img src="<%=ctx%>'+row.picUrl+'" width="140" height="140"></p>'
	                	+'</div>'
	                	+'</li>';
	                	$('#defaultImgs').append(htmlDom);
	                }
	            }else{
	            	$('#defaultImgs').append('<li>暂无默认图片！</li>');
	            }
	        },
	        error: function () {
	        	$('#defaultImgs').html('很抱歉，加载内容出错，我们及时修改问题。');
	        }
	    });
		//展示上传层
	    $('#btnUploadImgAvatar').click(function() {
	  		//初始化图片上传
	        var imgUploadBtnAvatar = $("#btnUploadImgAvatar");
	        g_AjxUploadImgAvatar(imgUploadBtnAvatar, folderName);
	    });
		
		if(action == "vote") {
			$('#regIdAvatar').val(regId1);
		} else if(action == "savevote") {
			$('#regIdAvatar').val($('#regId').val());
			$('#picUrlAvatar').val($('#picUrl').val());
			$('#contentAvatar').val($('#content').val());
		}
	    $('#action').val(action);
	    $('#btnUploadImgAvatar').click();
	}
	
	//图片上传
	function g_AjxUploadImgAvatar(imgUploadBtnAvatar, folderName) {
	    var button = imgUploadBtnAvatar, interval;
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
	            	$('#avatar').val(imgpath);
	            }
	            $('#imageShowAvatar').empty();
	            $('#imageShowAvatar').append(
	             '<li>'+
	             '<a href="#">'+'<img src="<%=ctx%>'+imgpath+'" width="200" height="200">'+'</a>'+
	             '<span class="delet4" id="btnDeleteImg" onclick="delImgAvatar(\''+imgpath+'\')"></span>'+
	             '</li> '
	            );
	        }
	    });
	}
	
	function delImgAvatar(imgpath){
		if(confirm('确认删除该图片吗?')){
		  $.ajax({
			  url: '<%=ctx%>/image/delImage.do',
				data:{picPath:imgpath},
				method:'post',
				success:function(data) {
					$('#avatar').val("");
					eval('data=' + data);
					alert(data.message);
					$('#imageShowAvatar').empty();
				},
				error : function() {
					alert('删除失败');
				}
			});
		}
	}
	
	//提交表单
    function submitFormAvatar() {
		if($('#avatar').val() == '') {
			alert("请上传展示或选择默认头像！");
		} else {
	    	var flag = window.confirm("请慎重选择, 点击确认提交任何信息都将无法修改！");
		    if(flag) {
	        	$('#ffAvatar').submit();
		    }
		}
    }
</script>