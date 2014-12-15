<%@ page language="java" pageEncoding="UTF-8" %>
<html>
	<head>
	    <title>添加缴费通知</title>
	    <%@include file="/common/meta.jsp"%>
	    <%@include file="/common/editorJs.jsp"%>
	    <script type="text/javascript" src="<%=ctx %>/js/jquery-easyui/jquery.easyui.min.js"></script>
	    <script src="<%=ctx %>/js/jquery.validate.min.js" type="text/javascript" ></script>
	    <script src="<%=ctx %>/js/messages_zh.js" type="text/javascript" ></script>
	    <style type="text/css">
	        label.error {
	            color:Red;
	            font-size:13px;
	            margin-left:5px;
	            padding-left:16px;
	        }
	    </style>
	    <script type="text/javascript">
			$(function () {
				$(document).keyup(function(event){
					  if(event.keyCode ==13){
							  submitForm();			
					  }
				});
			});
	    
	        $(function () {
	        	//验证表单
	            $('#attachform').validate({
	                submitHandler:function(form){
	                    $('#attachform').form('submit', {
	                        success:function(data){
	                            var data = eval('(' + data + ')');  // 改变json对象为javascript对象
	                            alert(data.message);
	                            window.location.href = '<%=ctx%>/business/businessChargeAnno/list.do';
	                        }
	                    });
	                },
	                errorClass: "error",
	                success: function(label) {
	                    label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
	                },
	                rules: {
	                	reportName: {
	                        required: true,
	                        maxlength: 22
	                    },
	                    reportExcel: {
	                        required: true
	                    }
	                },
	                messages: {
	                	reportName: {
	                        required: '请输入通知标题！',
		                    maxlength: '请输入通知标题22字以内！'
	                    },
	                    reportExcel: {
	                        required: '请上传excle格式的文件！'
	                    }
	                }
	            });
	        });
	    </script>
	</head>
	<body class="bagcolr">
	    <div class="wrapper wranews">	
	        <div class="newsrel">   
	        	<form id="attachform" action="save.do" method="post">
	            <div class="header-public"><span class="return" onclick="history.go(-1)"></span>添加缴费通知</div>
	            <div class="cont-l">        
	               	<h2 class="relran">通知标题<label for="reportName" class="error success"></label></h2>
			       	<input class="iptnewtit" type="text"  name="reportName"  id="reportName"  placeholder='请输入通知标题22字以内' />
	               
	               	<h2 class="relran">上传通知内容<label for="reportExcel" class="error success"></label></h2>
		            <div style="position:relative;">
		            	<span class="ranbut radiusbox" onclick="$('.busswi4').fadeIn('slow');">点击选择上传</span>
		            	<lable style="position: absolute; top: 10px; left: 160px;" id="reportExcel2"></lable>
		            </div>
		            <input type="hidden" name="reportExcel" id="reportExcel" value=""> <%-- 通知内容 --%>
	                <input type="hidden" name="users" id="users" value="">
	                
	                <div class="jftz">
	                	<div class="jf-title">
		                    <h3 class="jf-ttz" style="cursor:default;"><img src="<%=ctx %>/images/icon/jfico.jpg"/>实际通知用户  <span><em id="user_app"></em>人</span></h3>
		                    <h3 class="jf-twtz"  style="cursor:default;"><img src="<%=ctx %>/images/icon/jfico.jpg"/>未注册无法通知  <span><em id="user"></em>人</span></h3>
		                  </div>
		                  <div class="jf-tz jf-ui">
		                    <ul id ="user_app_li"></ul>
		                  </div>
		                  <div class="jf-wtz jf-ui">
		                    <ul id = "user_li"></ul>
		                  </div>
	                </div> <!-- 显示通知内容 -->         
	                <div class="submtpres" style="margin:40px 0 20px;">                           
	                    <input id="qrbut" type="submit" name="" value="确认提交" />          
	                </div>      
	            </div>    
	            </form>
	        </div>    
	    </div>
	    
	    <div class="busswi4" style="height:100%; position:fixed;">
	        <div class="sidebar4" style="height:100%;">
	          <a id="close4" title="关闭" href="javascript:;" onclick="$('.busswi4').fadeOut('slow');"></a>
	          <h2 class="tit4">文件选择</h2>               
	          <div id="wrapper-250">        
	            <ul class="accordion4">         
	              <li id="one4" class="files">
	                <span class="add4"></span>
	                <a href="#one" id="btnUploadImg">点击浏览上传</a>
	                <a style="margin-left:30px; color:#E94D2F; text-decoration:underline;" href="<%=ctx%>/common/charge_template.xls">下载EXCEL模板</a>
	              </li>
	              <li class="sub-menu4"></li> 
	            </ul>          
	          </div>  
	          <div class="w-gg-btn">
	            <input type="button" value="确定" class="w-gg-qr w-gg-total" style="width:100px;" onclick="saveUpload()">
				<input type="button" value="取消" class="w-gg-qx w-gg-total" style="width:100px;" onclick="cancleUpload()">
	          </div>
	        </div>     
	    </div> 
	    <script>	
	    	function cancleUpload() {
	    		$('#reportExcel').val("");
	    		$('#users').val("");
	    		$('#reportExcel2').html("");
	    		$('.sub-menu4').html("");
	    		$('.busswi4').fadeOut('slow');
	    		$('#user_app_li').html("");
           		$('#user_li').html("");
	    		$(".jftz").css("display","none");
	    	}
	    	
			function saveUpload() {
				if($('#reportExcel').val() == "") {
					alert("请选择上传文件!");
				} else {
					$('#reportExcel2').html($('#excelname').val());
					$.ajax({
	        			type: 'post',
	        	        url: '<%=path %>/business/businessChargeAnno/jsonExcel.do',
	        	        dataType: 'json',
	        	        data: {reportName: $('#excelname').val()},
	        	        cache: false,
	        	        success: function (data) {
	        	            var rows = data.rows;
	        	            if(rows.length > 0) {
	        	            	$('#users').val(data.count2);
        	                	$('#user_app').html(data.count2);
        	                	$('#user').html(data.count1);
        	                	var user_app_ul = '';
        	                	var user_ul = '<li><h3>由于被通知人，没有安装APP,故无法进行"缴费通知"发送</h3></li>';
       	                		for(var i=0;i<rows.length;i++) {
   	        	                	var row = rows[i];  
   	        	                	if(row.count == 1) {
	        	                		user_app_ul += ''
	        	                		+'<li>'
	        	                		+'<div class="jf-in">'
	        	                		+'<p>姓名：<span>'+row.name+'</span><span>'+row.cellphone+'</span></p>'
	        	                		+'<p class="jf-top">小区：<span>'+row.estateName+'</span></p>'
	        	                		+'<p class="jf-top">楼栋：<span>'+row.building+'号</span>单元：<span>'+(row.unit=='null'? '':row.unit)+'</span>门牌：<span>'+row.house+'</span></p>'
	        	                		+'</div>'
	        	                		+'<div class="jf-con">'
	        	                		+'<h4>通知内容：</h4>'
	        	                		+'<p>'+row.content+'</p>'
	        	                		+'</div>'
	        	                		+'</li>';
   	        	                	}
   	        	                	if(row.count == 0) {
   	        	                		user_ul += ''
   	        	                		+'<li>'
   	        	                		+'<p>'
   	        	                		+'<span class="jf-sml">姓名：<em>'+row.name+'</em><em class="jf-pho">'+row.cellphone+'</em></span>'
   	        	                		+'<span>小区：<em>'+row.estateName+'</em></span>'
   	        	                		+'<span>楼栋：<em>'+row.building+'号</em></span>'
   	        	                		+'<span>单元：<em>'+row.unit+'</em></span>'
   	        	                		+'<span>门牌：<em>'+row.house+'</em></span>'
   	        	                		+'</p>'
   	        	                		+'</li>';
   	        	                	}
       	                		}
       	                		$('#user_app_li').append(user_app_ul);
       	                		$('#user_li').append(user_ul);
	        	            }else{
	        	            	$('.jftz').html('很抱歉，没有相关记录。');
	        	            }
	        	        },
	        	        error: function () {
	        	        	$('.jftz').html('很抱歉，加载内容出错，我们及时修改问题。');
	        	        }
	        	    });
					$(".jftz").css("display","block");
		    		$('.busswi4').fadeOut('slow');
				}
	    	}
	    	
			$(function() {
				init();
			});
			    
			//初始化
			function init() {
				//初始化文件上传
				var btnImg = document.getElementById("btnUploadImg");
				var img = document.getElementById("imgShow");
				var hidImgName = document.getElementById("hidImgName");
				g_AjxUploadImg(btnImg, img, hidImgName);
			}
			    
			//文件上传
			function g_AjxUploadImg(btn, img, hidPut) {
				var button = btn, interval;
				new AjaxUpload(button, {
		            action: '${ctx}/business/businessChargeAnno/uploadExcel.do',
		            data: {},
		            name: 'exclefile',
		            onSubmit: function(file, ext) {
		                if (!(ext && /^(xlsx|XLSX|xls|XLS)$/.test(ext))) {
		                    alert("您上传的excel格式不对，请重新选择！");
		                    return false;
		                }
					},
		            onComplete: function(file, response) {
		                var content = response.replace('<pre>','').replace('</pre>','');
		                content = content.substring(content.indexOf('>')+1);
		               	// alert('content   '+content);
		                var json = $.parseJSON(content);
						
		                if (json.success) {
		                    $('.sub-menu4').append('&nbsp;&nbsp;<input type="hidden" id="excelname" name="excelname" value="'+json.message.split("|")[1]+'"/><a style="color:#a6a6a6;" href="#">'+json.message.split("|")[1]+'&nbsp;&nbsp;('+json.message.split("|")[0]+'KB)</a>');
		                    $('#reportExcel').val($('#excelname').val());
		                } else  {
		                    alert(json.message);
		                }
		            }
			    });
			}		

	        /* $(document).ready(function(e) {
	            $(".jf-title h3").click(function(e) {
	                $(".jf-title h3 img").css("display","none");
					$(this).find("img").css("display","inline");
	            });
				$(".jf-ttz").click(function(e) {
	                $(".jf-tz").css("display","block");
					$(".jf-wtz").css("display","none");
	            });
				$(".jf-twtz").click(function(e) {
	                $(".jf-wtz").css("display","block");
					$(".jf-tz").css("display","none");
	            });
	        }); */
			
			 //提交表单
		     function submitForm() {
				$('#attachform').submit();
		     }
	    </script>  
	</body>
</html>