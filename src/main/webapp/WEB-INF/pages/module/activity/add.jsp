<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发布活动</title>
    <%@include file="/common/meta.jsp"%>
    <%@include file="/common/editorJs.jsp"%>
	<link rel="stylesheet" href="<%=ctx%>/js/jquery-ui/themes/base/jquery.ui.all.css">
	<link rel="stylesheet" type="text/css" href="<%=ctx%>/js/jquery.confirm/jquery.confirm.css" />
    <script type="text/javascript" src="<%=ctx %>/js/jquery-easyui/jquery.easyui.min.js"></script>
    <script src="<%=ctx %>/js/jquery.validate.min.js" type="text/javascript" ></script>
    <script src="<%=ctx%>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js" type="text/javascript" ></script>
    <script src="<%=ctx%>/js/jquery-ui/jquery.ui.datepicker-zh-CN.js" type="text/javascript" ></script>
    <script src="<%=ctx%>/js/datepicker/WdatePicker.js" type="text/javascript" ></script>
	<script src="<%=ctx%>/js/jquery.confirm/jquery.confirm.js"></script>
    <style type="text/css">
        label.error
        {
            color:Red;
            font-size:13px;
            margin-left:5px;
            padding-left:16px;
        }
    </style>
</head>
<body class="bagcolr">
<form id="ff" action="save.do" method="post">
<div class="wrapper wranews">
    <div class="newsrel">
        <div class="header-public"><span class="return" onclick="history.go(-1);"></span>活动发布</div>
        <div class="cont-l">
            <h2 class="title">活动名称<label for="actName" class="error success"></label></h2>
            <input class="iptnewtit" type="text" id="actName" name="actName" placeholder='请输入活动名称24字以内' />
            
            <h2 class="relran">活动简介<label for="brief" class="error success"></label></h2>
            <input class="iptnewtit" type="text" name="brief" id="brief" placeholder='请输入简介28字以内' />
            
            <h2 class="relstatus">活动类型  <em style="font-size:15px; color:#e7402f;">（青年汇活动，由青年汇人员进行新建）</em><label for="typeId" class="error success"></label></h2>
            <label><input class="radiostyle2" type="radio"name="typeId" value="1" checked >&nbsp;定时抢</label>　
            <label><input class="radiostyle2" type="radio" name="typeId" value="2"  >&nbsp;报名活动</label>　
            <label><input class="radiostyle2" type="radio" name="typeId" value="3"  >&nbsp;投票活动</label>　
            <label><input class="radiostyle2" type="radio" name="typeId" value="4"  >&nbsp;抢优惠券</label>　
            <label><input class="radiostyle2" type="radio" name="typeId" value="5"  >&nbsp;青年汇活动</label>　
            <label><input class="radiostyle2" type="radio" name="typeId" value="6"  >&nbsp;精品投票活动</label>
            <input type="hidden" id="typeName" name="typeName" value="" >
            
            <!-- 报名活动 -->
            <div id="bmhdId"></div>
            <!-- 投票活动 -->
	        <div id="tphdId"></div>
            <!-- 抢优惠券-->
            <div id="yhqId"></div>
            <!-- 青年汇活动-->
            <div id="qnhId"></div>
            <!-- 精品投票活动-->
            <div id="jptpId"></div>
               
            <div id="display">
	            <div class="line2"></div>
				<h2 class="title">奖品发放规则<label for="prizeRules" class="error success"></label></h2>
				<script type="text/plain" id="actEditor1" style="width:840px;height:240px;">　</script>
			    <input type="hidden" name="prizeRules" id="prizeRules" value="0">
			</div>
			
            <div class="line2"></div>
            <h2 class="relran" style="font-weight: bold;">活动展示范围<label for="actScope" class="error success"></label></h2>
            <div style="position:relative;">
	            <span class="ranbut radiusbox" id="showScopeLayer">点击选择范围</span> 　　<br><em>可根据小区进行活动参与范围限定</em>
            	<input type="hidden" id="actScope" name="actScope" value=""/>
	            <label style="position: absolute; top: 10px; left: 160px;"  id="actScopeShow"></label>
            </div>
            
            <div class="line2"></div>
            <h2 class="relran" style="font-weight: bold;">活动列表大图<label for="actPic" class="error success"></label></h2>
            <div id="divImg" style=" overflow:hidden;"><img id="actPicBtn" src="${ctx}/images/icon/tp01.jpg" width="305" height="102" style="float:left; padding-right:10px;"><div style="color:#000; padding-top:26px;">请上传【宽600PX、高250PX】jpg格式图片<br>图片大小不能超过100K!</div></div>
            <input type="hidden" name="actPic" id="actPic" value="">
            
            <%-- <div class="line2"></div>
            <h2 class="relran" style="font-weight: bold;">活动列表结束大图<label for="actPicNo" class="error success"></label></h2>
            <div id="divImg" style=" overflow:hidden;"><img id="actPicNoBtn" src="${ctx}/images/icon/tp01.jpg" width="305" height="102" style="float:left; padding-right:10px;"><div style="color:#000; padding-top:26px;">请上传【宽600PX、高250PX】jpg格式图片<br>图片大小不能超过100K!</div></div>
            <input type="hidden" name="actPicNo" id="actPicNo" value=""> --%>
            
            <div class="line2"></div>
            <h2 class="relran" style="font-weight: bold;">分享展示图<span style="font-weight:normal;font-size: 16px;">【用于微信分享时使用！】</span><label for="appPic" class="error success"></label></h2>
            <div id="divImg" style=" overflow:hidden;"><img id="appPicBtn" src="${ctx}/images/icon/add.jpg" width="100" height="100" style="float:left; padding-right:10px;"><div style="color:#000; padding-top:26px;">请上传【宽170PX、高125PX】jpg格式图片<br>图片大小不能超过20K!</div></div>
            <input type="hidden" name="appPic" id="appPic" value="">
            <input type="hidden" name="uploadField" id="uploadField" value="">
                        
            <div class="line2"></div>
            <h2 class="newscont">活动内容<label for="actContent" class="error success"></label></h2>
            <%--文本编辑器--%>
            <script type="text/plain" id="actEditor" style="width:840px;height:240px;"></script>
            <input type="hidden" name="actContent" id="actContent">
			
            <!-- 抢优惠券--活动时间设置-->
            <div id="yhqAvtiveTime"></div>
            
            <%--<h2 class="newscont">活动周期</h2>
            <input class="Wdate" type="text" name="startTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"> 至
            <input class="Wdate" type="text" name="endTime" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"><font color="red">*</font>
			--%>
			<!-- 定时抢 -->
			<div id="rankId"></div>
			
            <!-- <h2 class="relstatus">评论开启<label for="isComment" class="error success"></label></h2>
            <div class="options">
                <p>
                    <label>
                        <input class="radiostyle" type="radio" name="isComment" value="0">
                        &nbsp;所有时段</label>
                    <br><br>
                    <label>
                        <input class="radiostyle" type="radio" name="isComment" value="1">
                        &nbsp;活动结束后</label>
                    <br>
                </p>
            </div> -->
			
            <%--<h2 class="relstatus">订购/报名开启</h2>
            <div class="options">
                <p>
                    <label>
                        <input class="radiostyle" type="radio" name="isEstateAgent" value="0">
                        关闭</label>
                    <br><br>
                    <label>
                        <input class="radiostyle" type="radio" name="isEstateAgent" value="1">
                        开启</label>
                    <br>
                </p>
                <input class="Wdate" type="text" name="startDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"> 至
                <input class="Wdate" type="text" name="endDate" onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"><font color="red">*</font>
            </div>--%>
			<div class="line2"></div>
            <h2 class="relstatus">是否推送<label for="isPush" class="error success"></label></h2>
            <div class="options">
                <p>
                    <label>
                        <input id="isPush1"  class="radiostyle" type="radio" name="isPush" value="1">
                        &nbsp;是</label>
                    　　<em style="color:#e7402f;">选择推送后，将通过系统推送至手机用户，非重要信息请勿选择</em><br><br>
                    <label>
                        <input class="radiostyle" type="radio" name="isPush" value="0" checked>
                        &nbsp;否</label>
                    <br>
                </p>
            </div>
            <div class="line2"></div>
            <h2 class="relstatus">推荐到</h2>
            <div class="options">
                <p>
                    <label><input class="radiostyle" type="radio" name="recommend" value="0">&nbsp;首页焦点图</label>
                    　　			<em style="color:#000;">将推送至焦点图管理列表，在焦点图管理中进行焦点图制作上传，审核通过后发布至焦点图位置</em><br><br>
                    <label><input class="radiostyle" type="radio" name="recommend" value="3">&nbsp;首页广告焦点图</label> 
					<em style="color: #000;">　将推送至广告焦点图管理列表，在广告焦点图管理中进行广告焦点图制作上传，审核通过后发布至广告焦点图位置</em><br><br>
                   	<!--<label><input class="radiostyle" type="radio" name="recommend" value="1">&nbsp;首页新闻列表置顶</label><br><br> -->
                    <label><input class="radiostyle" type="radio" name="recommend" value="2" checked>&nbsp;以上都不选</label><br>
                </p>
            </div>
            
            <div class="line2"></div>
            <h2 class="relstatus">是否定时推送<label for="isTimingPush" class="error success"></label></h2>
            <div class="options">
                <p>
                    <label><input class="radiostyle" type="radio" name="isTimingPush" value="1"  onclick="isTimePash(1)">&nbsp;是</label><br><br>
                    <label><input class="radiostyle" type="radio" name="isTimingPush" value="0" onclick="isTimePash(0)" checked>&nbsp;否</label><br>
                </p>
            </div>
			
            <h2 class="relran" style="display: none;" id="pushconTentTitle">定时推送内容<label for="timingPushconTent" class="error success"></label></h2>
            <input class="iptnewtit" type="text" name="timingPushconTent" id="timingPushconTent" placeholder='请输入定时推送内容64字以内' style="display: none;"/>
            
            <div id="setTimeDiv" style="display: none;">
	            <h2 class="relstatus" style="font-weight: bold;">定时推送<label for="timingPushTime" class="error success"></label></h2>
	            <input type="text" class="iptnewtit"  name="timingPushTime1" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" style="width:240px" /> 
			</div>
            
            <div class="line2"></div>
            <h2 class="relstatus">发布状态<label for="state" class="error success"></label></h2>
            <div class="options">
                <p>
                	<shiro:hasPermission name="activity_instant_publish">
                    <label><input class="radiostyle" type="radio" name="state" value="1" >&nbsp;立即发布</label><br>
                    </shiro:hasPermission><br>
                    <label><input class="radiostyle" type="radio" name="state" value="6" >&nbsp;定时发布</label><br><br>
                    <shiro:hasPermission name="activity_waiting_publish">
                    <label><input class="radiostyle" type="radio" name="state" value="5"  checked>&nbsp;暂缓发布</label><br>
                    </shiro:hasPermission><br>
                    <label><input class="radiostyle" type="radio" name="state" value="3">&nbsp;待审核</label><br><br>
                </p>
            </div>
            <div id="timingPublicLabel"></div>
            
            <div class="submtpres">
                <input id="qrbut" type="button" value="确认提交" onclick="submitForm()"/>
            </div>
        </div>
    </div>
</div>
<!-- 类型层 -->
<div id="typeLayer" class="busswi3">
    <div class="sidebar3">
        <a id="close3" title="关闭" href="javascript:;"></a>
        <h2 class="tit3">类型列表</h2>
        <!--<hr class="link3">-->
        <div>
            <ul class="accordion3">
                    <li id="one2" class="files">
                        
                    </li>
            </ul>
            <div class="w-gg-btn">
	            	<span class="w-gg-qr w-gg-total" id="typeOk" style="cursor: pointer;">确认</span>
	            	<span class="w-gg-qx w-gg-total" id="typeCancel" style="cursor: pointer;">取消</span>
	        </div>
        </div>
    </div>
</div>


<link rel="stylesheet" type="text/css" href="${ctx}/css/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=ctx %>/css/easyui/themes/icon.css">
<script type="text/javascript" src="${ctx}/js/jquery-easyui/jquery.easyui.min.js"></script>

<!-- 范围选择开始 -->
<div id="scopeLayer" class="busswi y-fbes-jm">
	<div id="scopeBar" class="sidebar y-fbes-jms">
    	<a id="y-fbes-close" class="close" title="关闭" href="javascript:;" onclick="$('#scopeLayer').fadeOut('slow');"></a>
    	<h2 class="tit">活动展示范围选择</h2>
        <div id="wrapper-250">
	          <ul id="scopeTree" style="font-size: 18px;"></ul>
        </div>
        <div class="w-gg-btn">
            <input class="w-gg-qr w-gg-total" type="button"  value="确定"  id="scopeOk" />
			<input class="w-gg-qx w-gg-total" type="button"  value="取消" onclick="$('#scopeLayer').fadeOut('slow');"/>
        </div>
    </div>
</div>
<!-- 范围选择结束 -->

<!-- 上传优惠券文件开始 -->
<div class="busswi4" style="height:100%; position:fixed;">
    <div class="sidebar4" style="height:100%;">
      <a id="close4" title="关闭" href="javascript:;" onclick="$('.busswi4').fadeOut('slow');"></a>
      <h2 class="tit4">文件选择</h2>               
      <div id="wrapper-250">        
        <ul class="accordion4">         
          <li id="one4" class="files">
            <span class="add4"></span>
            <a href="#one" id="btnUploadImg2">点击浏览上传</a>
            <a style="margin-left:30px; color:#E94D2F; text-decoration:underline;" href="<%=ctx%>/common/couponCode_template.xlsx">下载EXCEL模板</a>
          </li>
          <li><span style="margin-left:6px; font-weight:normal;font-size: 12px;">下载优惠劵模板（请根据格式进行填写后，进行上传）</span></li>
          <li class="sub-menu4"></li> 
        </ul>          
      </div>  
      <div class="w-gg-btn">
        <input type="button" value="确定" class="w-gg-qr w-gg-total" style="width:100px;" onclick="saveUpload()">
		<input type="button" value="取消" class="w-gg-qx w-gg-total" style="width:100px;" onclick="cancleUpload()">
      </div>
    </div>     
</div>
<!-- 上传优惠券文件结束 -->
	    
<!-- 设定时间开始 -->
<div id="setTimeLayer" class="busswi">
    <div id="setTimeBar" class="sidebar">
        <a id="close" title="关闭" class="closeSetTime" href="javascript:;"></a>
        <h2 class="tit">定时提醒</h2>
        <!--<hr class="link">-->
        <div id="wrapper-250">
            <ul style="font-size: 18px;">
            	<div id="datepicker"></div>
            </ul>
            <ul>默认自动获取当天日期</ul>
            <ul style="font-size: 18px;">
            	<div>&nbsp;</div>
            	<div><span>时间</span><span>
            		<select name="setHour" id="setHour">
            			<option value="">小时</option>
            			<option value="01">01</option>
            			<option value="02">02</option>
            			<option value="03">03</option>
            			<option value="04">04</option>
            			<option value="05">05</option>
            			<option value="06">06</option>
            			<option value="07">07</option>
            			<option value="08">08</option>
            			<option value="09">09</option>
            			<option value="10">10</option>
            			<option value="11">11</option>
            			<option value="12">12</option>
            			<option value="13">13</option>
            			<option value="14">14</option>
            			<option value="15">15</option>
            			<option value="16">16</option>
            			<option value="17">17</option>
            			<option value="18">18</option>
            			<option value="19">19</option>
            			<option value="20">20</option>
            			<option value="21">21</option>
            			<option value="22">22</option>
            			<option value="23">23</option>
            			<option value="00">00</option>
            		</select>
            		-
            		<select name="setMinute" id="setMinute">
            			<option value="">分钟</option>
            			<option value="00">00</option>
            			<option value="30">30</option>
            		</select>
            		</span>
            	</div>
            </ul>
        </div>
        <div class="w-gg-btn">
           	<span class="w-gg-qr w-gg-total" id="setTimeOk" style="cursor: pointer;">确认</span>
           	<span class="w-gg-qx w-gg-total" id="setTimeCancel" style="cursor: pointer;">取消</span>
       	</div>
    </div>
</div>

</form>

<jsp:include page="/common/uploadPicJs.jsp"/>
<jsp:include page="/common/uploadVoteTypeMultiPicJs.jsp"/>
<jsp:include page="jptpActiveJpsz.jsp"/>

</body>
<%--初始化文本编辑器--%>
<script type="text/javascript">
    //实例化编辑器
    var ue = UE.getEditor('actEditor');
    // var ue1 = UE.getEditor('actEditor1');
  	//简单编辑器实例化
    var ue1 = UE.getEditor('actEditor1',{
    	toolbars: [[
			'undo', 'redo', '|', 'bold', 'underline', 'forecolor', 'backcolor', 'insertimage', 'justifyleft', 'justifycenter', 'justifyright'
			
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
    
    $(document).ready(function(){
		var isPush = document.getElementsByName("isPush");
    	$('#isPush1').change(function(){
    		$.confirm({
    			'title'		: '选择推送重要提示',
    			'message'	: '<font color="red"><b>请慎重选择推送！</b></font><br/>选择推送，会将此条活动推送至<font color="red"><b>所有注册用户</b></font>手机桌面。<br/>如本篇活动已进行过推送操作，<font color="red"><b>切勿再次推送！</b></font>否则会造成频繁推送！<br/>如确认推送，请选择【确定】，否则，请点击【取消】',
    			'buttons'	: {
    				'确定'	: {
    					'class'	: 'blue',
    					'action': function(){
    						isPush[0].checked = true;
    					}
    				},
    				'取消'	: {
    					'class'	: 'gray',
    					'action': function(){
    						isPush[0].checked = false;
    			    		isPush[1].checked = true;
    					}	
    				}
    			}
    		});
    	});
    });
     	  
  	//时间选择显示
    function isTimePash(idvalue) {
    	var isTimingPush = $("input[name='isTimingPush']:checked").val();
    	if(isTimingPush == 1) {
    		$('#setTimeDiv').show();
    		$('#timingPushconTent').show();
    	}else{
    		$('#setTimeDiv').hide();
    		$('#timingPushconTent').hide();
    	}
    }
	
    function cancleUpload() {
		$('#reportExcel').val("");
		$('#reportExcel2').html("");
		$('.busswi4').fadeOut('slow');
	}
	
	function saveUpload() {
		if($('#reportExcel').val() == "") {
			alert("请选择上传Excel文件!");
		} else {
			$('#reportExcel2').html($('#excelname').val());
    		$('.busswi4').fadeOut('slow');
		}
	}
	
	//奖品设置
	function startActiveJpszinfo() {
		$('#picUploadLayerJPTP').fadeIn('slow');
	}
	
	$(function() {
		init2();
	});
	    
	// 初始化
	function init2() {
		//初始化文件上传
		var btnImg = document.getElementById("btnUploadImg2");
		var img = document.getElementById("imgShow");
		var hidImgName = document.getElementById("hidImgName");
		g_AjxUploadImg2(btnImg, img, hidImgName);
	}
	
	// 文件上传
	function g_AjxUploadImg2(btn, img, hidPut) {
		var button = btn, interval;
		new AjaxUpload(button, {
            action: '${ctx}/business/businessActivity/uploadExcel.do',
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
	
    $(function () {
	    $(document).keyup(function(event){
	    	if(event.keyCode ==13){
				submitForm();			
		  	}
		});
	    
    	if($("input[name='typeId']:checked").val() == 1) {
 			$("#display").hide();
    		var htmlDom = ''
    		+'<h2 class="relran" style="font-weight: bold;">活动时间(设定抢时间)<label for="planTime" class="error success"></label></h2>'
    		+'<div style="position:relative;">'
    		+'<span class="ranbut radiusbox" id="setTimeBtn">点击设置时间</span>'
    		+'<input type="hidden" id="planTime" name="planTime" value=""/>'
    		+'<label style="position: absolute; top: 10px; left: 160px;"  id="planTimeShow"></label>'
    		+'</div>'
    		+'<div class="line2"></div>'
    		+'<h2 class="newscont">获奖排名设定<label for="rank" class="error success"></label></h2>'
    		+'<input class="iptnewtit" type="text" id="rank" name="rank"/>名以前，可获奖';
    		$("#rankId").append(htmlDom);
 			$("#yhqId").empty();
 			$("#yhqAvtiveTime").empty();
    		$("#bmhdId").empty();
    		$("#tphdId").empty();
 			$("#jptpId").empty();
    		$("#typeName").val("定时抢");
			$("input[name='state']:eq(0)").val("1");
			
    		//显示定时提醒
            $("#setTimeBtn").click(function(){
                $("#setTimeLayer").fadeIn("slow");
                $("#setTimeLayer").css("height",$(document.body).outerHeight(true)+'px');
                $("#setTimeBar").css("height",$(document.body).outerHeight(true)-40+'px');
            });
    	}
		
	 	// 活动类型 
	    $("input[name='typeId']").change(function() {
			var $typeId = $("input[name='typeId']:checked").val();
			if ($typeId == 2) {
				$("#display").hide();
				$('#rankStart').val("1");
				var htmlDom=''
				+'<div class="line2"></div>'
				+'<h2 class="relstatus">活动场次<label for="times" class="error success"></label></h2>'
				+'<label><input id="times0" class="radiostyle2" type="radio" name="times" value="0" checked >&nbsp;单次</label>　　'　　
				+'<label><input class="radiostyle2" type="radio" name="times" value="1"  >&nbsp;多次</label><br><br>'
				+'<div id="timesDiv">'
				+'<span id="timesSpan">'
				+' 时　　间：<input id="timeSlotName1" type="text" class="iptnewtit"  name="timeSlotName1" onfocus="WdatePicker({dateFmt:\'yyyy-MM-dd HH:mm\'})" style="width:240px" />　　' 　　
				+'人数限定：<input type="text" class="iptnewtit"  name="number" style="width:100px" maxlength="5" /><br><br>'
				+'</span>'
				+'</div>'
				+'<input class="timeBtn" type="button" name="timesBtn" value="增加一次" style="display:none;" />'
				+'<h2 class="relstatus">报名表单字段<span style="font-weight:normal;font-size: 16px;">【如需增加报名字段请联系移动互联网事业部！】</span><label for="attributeValues" class="error success"></label></h2>'
	 			+'<label><input id="attributeValues1" type="checkbox" name="attributeValues" value="1"/> 昵称</label>　　　　　　'
	 			+'<label><input id="attributeValues2" type="checkbox" name="attributeValues" value="2"/> 真实姓名</label>　　　　　　'
	 			+'<label><input id="attributeValues3" type="checkbox" name="attributeValues" value="3"/> 联系电话</label><br><br>'
	 			+'<label><input id="attributeValues4" type="checkbox" name="attributeValues" value="4"/> 生日</label>　　　　　　'
	 			+'<label><input id="attributeValues5" type="checkbox" name="attributeValues" value="5"/> 年龄</label>　　　　　　　　'
	 			+'<label><input id="attributeValues6" type="checkbox" name="attributeValues" value="6"/> 职业</label><br><br>'
	 			+'<label><input id="attributeValues7" type="checkbox" name="attributeValues" value="7"/> 身份证号</label>　　　　'
	 			+'<label><input id="attributeValues8" type="checkbox" name="attributeValues" value="8"/> Email</label>　　　　		　　　'
	 			+'<label><input id="attributeValues9" type="checkbox" name="attributeValues" value="9"/> 详细地址</label>'
	            
	 			+'<h2 class="relran" style="font-weight: bold;">报名截止日期<label for="endTime" class="error success"></label></h2>'
	 			+'<input id="endTime" type="text" class="iptnewtit"  name="endTime" onfocus="WdatePicker({dateFmt:\'yyyy-MM-dd HH:mm\'})" style="width:240px" />';
	 			$("#bmhdId").append(htmlDom);
	 			$("#rankId").empty();
	 			$("#yhqId").empty();
	 			$("#yhqAvtiveTime").empty();
	 			$("#tphdId").empty();
	 			$("#qnhId").empty();
	 			$("#jptpId").empty();
				$("#typeName").val("报名活动");
				$("input[name='state']:eq(0)").val("0");
				
				// 报名活动--活动场次
				$("input[name='times']").change(function(){
					var $times = $("input[name='times']:checked").val();
					if($times == 0) {
						$("#timesDiv").empty();
						var htmlDom = ''
					    	+'<span>'
					    	+'时　　间：<input type="text" class="iptnewtit"  name="timeSlotName1" onfocus="WdatePicker({dateFmt:\'yyyy-MM-dd HH:mm\'})" style="width:240px" />&nbsp;&nbsp;　　'
					    	+'人数限定：<input type="text" class="iptnewtit"  name="number" style="width:100px;" maxlength="5" /><br><br>'
					    	+'</span>';
					    $("#timesDiv").append(htmlDom);
						$("input[name='timesBtn']").hide();
					} else {
						$("input[name='timesBtn']").show();
					}
				});
				
				// 增加/删除活动场次--多次
			    $("input[name='timesBtn']").click(function() {
			    	var htmlDom = ''
			    	+'<span>'
			    	+'时　　间：<input type="text" class="iptnewtit"  name="timeSlotName1" onfocus="WdatePicker({dateFmt:\'yyyy-MM-dd HH:mm\'})" style="width:240px" />&nbsp;&nbsp;　　'
			    	+'人数限定：<input type="text" class="iptnewtit"  name="number" style="width:100px;" maxlength="5" /> 　　'
			    	+'<a style="cursor:pointer;" onclick="javascript:$(this).parent().remove();">删除</a><br><br>'
			    	+'</span>';
			    	$("#timesDiv").append(htmlDom);
			    });
				
			} else if ($typeId == 1) {
				$("#display").hide();
				$('#rankStart').val("1");
				var htmlDom = ''
	    		+'<h2 class="relran" style="font-weight: bold;">活动时间(设定抢时间)<label for="planTime" class="error success"></label></h2>'
	    		+'<div style="position:relative;">'
	    		+'<span class="ranbut radiusbox" id="setTimeBtn">点击设置时间</span>'
	    		+'<input type="hidden" id="planTime" name="planTime" value=""/>'
	    		+'<label style="position: absolute; top: 10px; left: 160px;"  id="planTimeShow"></label>'
	    		+'</div>'
	    		+'<div class="line2"></div>'
	    		+'<h2 class="newscont">获奖排名设定<label for="rank" class="error success"></label></h2>'
	    		+'<input class="iptnewtit" type="text" id="rank" name="rank"/>名以前，可获奖';
	    		$("#bmhdId").empty();
	    		$("#tphdId").empty();
	    		$("#yhqId").empty();
	    		$("#yhqAvtiveTime").empty();
	    		$("#rankId").append(htmlDom);
	    		$("#qnhId").empty();
	    		$("#jptpId").empty();
				$("#typeName").val("定时抢");
				$("input[name='state']:eq(0)").val("1");
				
				//显示定时提醒
		        $("#setTimeBtn").click(function(){
		            $("#setTimeLayer").fadeIn("slow");
		            $("#setTimeLayer").css("height",$(document.body).outerHeight(true)+'px');
		            $("#setTimeBar").css("height",$(document.body).outerHeight(true)-40+'px');
		        });
				
			} else if ($typeId == 3) {
				$("#display").hide();
				$('#rankStart').val("1");
				var htmlDom = ''
				+'<div class="line2"></div>'
	    		+'<h2 class="relstatus">投票类型<label for="voteType" class="error success"></label></h2>'
	    		+'<label><input class="radiostyle2" type="radio"name="voteType" value="1" checked >&nbsp;文字</label>　'
	    		+'<label><input class="radiostyle2" type="radio" name="voteType" value="2"  >&nbsp;图片</label>　'
	    		+'<label><input class="radiostyle2" type="radio" name="voteType" value="3"  >&nbsp;混合</label>'
	    		+'<div id="voteTypeDiv"></div>'
	    		+'<div class="line2"></div>'
	    		+'<h2 class="relran">单个用户可投票数量<label for="votes" class="error success"></label></h2>'
	    		+'　　　<label>限定每个人可对<input class="iptnewtit" type="text" id="votes" name="votes" style="width:80px" />个项目，进行投票</label>'
	    		+'<div class="line2"></div>'
	    		+'<h2 class="relran" style="font-weight: bold;">投票截止日期<label for="endTime" class="error success"></label></h2>'
	 			+'<input id="endTime" type="text" class="iptnewtit"  name="endTime" onfocus="WdatePicker({dateFmt:\'yyyy-MM-dd HH:mm\'})" style="width:240px" />';
	    		$("#bmhdId").empty();
	    		$("#rankId").empty();
	    		$("#yhqId").empty();
	    		$("#yhqAvtiveTime").empty();
	    		$("#qnhId").empty();
	    		$("#jptpId").empty();
	    		$("#tphdId").append(htmlDom);
				$("#typeName").val("投票活动");
				$("input[name='state']:eq(0)").val("0");
				
				var htmlvoteType = '';
				if ($("input[name='voteType']:checked").val() == 1) {
					htmlvoteType = ''
					+'<span id="voteTypeSpan">'
					+'<input id="content" type="text" class="iptnewtit"  name="content" style="width:240px"  placeholder="请输入选项内容" />&nbsp;&nbsp;'
					+'<input class="voteTypeBtn" type="button" name="voteTypeContentBtn" value="添加" /><br>'
					+'</span>';
					$("#voteTypeDiv").html(htmlvoteType);
				}
				
				// 增加投票活动--文本
			    $("input[name='voteTypeContentBtn']").click(function() {
			    	var voteTypeContentBtn = ''
			    	+'<span>'
			    	+'<input id="content" type="text" class="iptnewtit"  name="content" style="width:240px"  placeholder="请输入选项内容" />&nbsp;&nbsp;'
			    	+'<a style="cursor:pointer;" onclick="javascript:$(this).parent().remove();">删除</a><br>'
			    	+'</span>';
			    	$("#voteTypeDiv").append(voteTypeContentBtn);
			    });
				
				// 投票活动类型 
			    $("input[name='voteType']").change(function() {
					var $voteType = $("input[name='voteType']:checked").val();
				
					if ($("input[name='voteType']:checked").val() == 1) {
						htmlvoteType = ''
						+'<span id="voteTypeSpan">'
						+'<input id="content" type="text" class="iptnewtit"  name="content" style="width:240px"  placeholder="请输入选项内容" />&nbsp;&nbsp;'
						+'<input class="voteTypeBtn" type="button" name="voteTypeContentBtn" value="添加" /><br>'
						+'</span>';
					} else if ($voteType == 2) {
						htmlvoteType = ''
						+'<span id="voteTypeSpan">'
						+'<div id="voteTypeImgDiv" style=" overflow:hidden;"><img id="voteTypeImg" src="${ctx}/images/icon/add.jpg" width="130" height="130" style="float:left; padding-top:20px; padding-right:20px;"></div>'
						+'<input type="hidden" name="image" id="image"> '
						+'<input type="hidden" name="uploadField1" id="uploadField1">'
						+'</span>';
					} else if ($voteType == 3) {
						htmlvoteType = ''
						+'<span id="voteTypeSpan">'
						+'<div id="voteTypeConImgDiv" style=" overflow:hidden;"><div class="actpublish "><img id="voteTypeContentImg" src="${ctx}/images/icon/add.jpg" width="130" height="130"></div></div>'
						+'<input type="hidden" name="image" id="image"> '
						+'<input type="hidden" name="uploadField1" id="uploadField1">'
						+'</span>';
					}
					$("#voteTypeDiv").html(htmlvoteType);
					
				 	// 增加投票活动--文本
				    $("input[name='voteTypeContentBtn']").click(function() {
				    	var voteTypeContentBtn = ''
				    	+'<span>'
				    	+'<input id="content" type="text" class="iptnewtit"  name="content" style="width:240px"  placeholder="请输入选项内容" />&nbsp;&nbsp;'
				    	+'<a style="cursor:pointer;" onclick="javascript:$(this).parent().remove();">删除</a><br>'
				    	+'</span>';
				    	$("#voteTypeDiv").append(voteTypeContentBtn);
				    });
				 	
				  	// 增加投票活动--图片
					$('#voteTypeImg').click(function() {
						$('#picUploadLayer1').fadeIn('slow');
						//初始化上传
				    	uploadInit1('voteType', 'image', '0', '0', 'i');
				    	$('#uploadField1').val('image');
					});
				  	
					// 增加投票活动--文本&图片
					$('#voteTypeContentImg').click(function() {
						$('#picUploadLayer1').fadeIn('slow');
						//初始化上传
				    	uploadInit1('voteType', 'image', '0', '0', 'ci');
				    	$('#uploadField1').val('image');
					});
			    });
			 
				//显示定时提醒
		        $("#setTimeBtn").click(function(){
		            $("#setTimeLayer").fadeIn("slow");
		            $("#setTimeLayer").css("height",$(document.body).outerHeight(true)+'px');
		            $("#setTimeBar").css("height",$(document.body).outerHeight(true)-40+'px');
		        });
			} else if ($typeId == 4) {
				$("#display").hide();
				$('#rankStart').val("1");
				var htmlDom = ''
				+'<div class="line2"></div>'
				+'<h2 class="title">优惠券名称<label for="couponName" class="error success"></label></h2>'
				+'<input class="iptnewtit" type="text" id="couponName" name="couponName" placeholder="请输入优惠券名称32字以内" />'
            
				+'<div class="line2"></div>'
				+'<h2 class="relran">使用规则<label for="couponDesc" class="error success"></label></h2>'
				+'<textarea name="couponDesc" id="couponDesc" rows="10" cols="113"></textarea> 	'
            
				+'<div class="line2"></div>'
				+'<h2 class="relran" style="font-weight: bold;">优惠券图片<label for="couponImg" class="error success"></label></h2>'
				+'<div id="divImg" style=" overflow:hidden;"><img id="couponImgBtn" src="${ctx}/images/icon/tp01.jpg" width="305" height="102" style="float:left; padding-right:10px;"><div style="color:#000; padding-top:26px;">请上传【宽600PX、高250PX】jpg格式图片<br>图片大小不能超过100K!</div></div>'
				+'<input type="hidden" name="couponImg" id="couponImg" value="">'
            
				+'<div class="line2"></div>'
				+'<h2 class="relran">使用有效期<label for="couponStartDate" class="error success"></label><label for="couponEndDate" class="error success"></label></h2>'
				+'<input class="iptnewtit" type="text" name="couponStartDate" onclick="WdatePicker({dateFmt:\'yyyy-MM-dd\'})" style="width:200px" placeholder="请选择开始时间"> 至'
				+'<input class="iptnewtit" type="text" name="couponEndDate" onclick="WdatePicker({dateFmt:\'yyyy-MM-dd\'})" style="width:200px" placeholder="请选择结束时间">'
            	
				+'<div class="line2"></div>'
				+'<h2 class="title">优惠券数量<label for="couponNum" class="error success"></label></h2>'
				+'<input class="iptnewtit" type="text" id="couponNum" name="couponNum" placeholder="请输入优惠券数量" style="width:200px;"/>&nbsp;&nbsp;张'
				
				+'<div class="line2"></div>'
				+'<h2 class="relran">导入优惠券号码<label for="reportExcel" class="error success"></label></h2>'
				+'<div style="position:relative;">'
				+'<span class="ranbut radiusbox" onclick="$(\'.busswi4\').fadeIn(\'slow\');">点击选择上传</span>'
				+'<label style="position: absolute; top: 10px; left: 160px;" id="reportExcel2"></label>'
				+'</div>'
				+'<input type="hidden" name="reportExcel" id="reportExcel" value="">'; 
				
				var htmlDom1 = ''
				+'<h2 class="relran" style="font-weight: bold;">活动时间<label for="planTime" class="error success"></label></h2>'
	    		+'<div style="position:relative;">'
	    		+'<span class="ranbut radiusbox" id="setTimeBtn">点击设置时间</span>'
	    		+'<input type="hidden" id="planTime" name="planTime" value=""/>'
	    		+'<label style="position: absolute; top: 10px; left: 160px;"  id="planTimeShow"></label>'
	    		+'</div>'
	    		+'<div class="line2"></div>';
	    		
				$("#rankId").empty();
	    		$("#bmhdId").empty();
	    		$("#tphdId").empty();
	    		$("#qnhId").empty();
	    		$("#jptpId").empty();
	    		$("#typeName").val("抢优惠券");
				$("input[name='state']:eq(0)").val("1");
				$("#yhqId").append(htmlDom);
				$("#yhqAvtiveTime").append(htmlDom1);
				
				// 优惠券大图
		    	$('#couponImgBtn').click(function() {
		    		$('#picUploadLayer').fadeIn('slow');
		    		//初始化上传
		        	uploadInit('activity', 'couponImg', '1', '0');
		        	$('#uploadField').val('couponImg');
		    	});
				
		    	//显示定时提醒
		        $("#setTimeBtn").click(function(){
		            $("#setTimeLayer").fadeIn("slow");
		            $("#setTimeLayer").css("height",$(document.body).outerHeight(true)+'px');
		            $("#setTimeBar").css("height",$(document.body).outerHeight(true)-40+'px');
		        });
			} else if ($typeId == 5) {
				$("#display").hide();
				$('#rankStart').val("1");
				var htmlDom = ''
				+'<div class="line2"></div>'
				+'<h2 class="relran">报名开始截止时间<label for="startTime" class="error success"></label><label for="endTime" class="error success"></label></h2>'
				+'<input class="iptnewtit" type="text" name="startTime" onclick="WdatePicker({dateFmt:\'yyyy-MM-dd HH:mm\'})" style="width:200px" placeholder="请选择报名开始时间"> 至'
				+'<input class="iptnewtit" type="text" name="endTime" onclick="WdatePicker({dateFmt:\'yyyy-MM-dd HH:mm\'})" style="width:200px" placeholder="请选择报名结束时间">'
            	
				+'<div class="line2"></div>'
				+'<h2 class="relran">活动开始截止时间<label for="timeslotStartTime" class="error success"></label><label for="timeslotEndTime" class="error success"></label></h2>'
				+'<input class="iptnewtit" type="text" name="timeslotStartTime" onclick="WdatePicker({dateFmt:\'yyyy-MM-dd HH:mm\'})" style="width:200px" placeholder="请选择开始时间"> 至'
				+'<input class="iptnewtit" type="text" name="timeslotEndTime" onclick="WdatePicker({dateFmt:\'yyyy-MM-dd HH:mm\'})" style="width:200px" placeholder="请选择结束时间">'; 
	    		
				$("#rankId").empty();
	    		$("#bmhdId").empty();
	    		$("#tphdId").empty();
	    		$("#yhqId").empty();
	    		$("#jptpId").empty();
	    		$("#yhqAvtiveTime").empty();
	    		$("#typeName").val("青年汇活动");
				$("input[name='state']:eq(0)").val("0");
				$("#qnhId").append(htmlDom);
			} else if ($typeId == 6) {
				$("#display").show();
				var htmlDom = ''
				+'<div class="line2"></div>'
				+'<h2 class="relran">精品投票报名截止时间<label for="jptpTimeslotEndTime" class="error success"></label></h2>'
				+'<input class="iptnewtit" type="text" name="jptpTimeslotEndTime" onclick="WdatePicker({dateFmt:\'yyyy-MM-dd HH:mm\'})" style="width:200px" placeholder="请选择精品投票报名截止时间">'
				+'<div class="line2"></div>'
				+'<h2 class="relran">活动开始截止时间<label for="startTime" class="error success"></label><label for="endTime" class="error success"></label></h2>'
				+'<input class="iptnewtit" type="text" name="startTime" onclick="WdatePicker({dateFmt:\'yyyy-MM-dd HH:mm\'})" style="width:200px" placeholder="请选择开始时间"> 至'
				+'<input class="iptnewtit" type="text" name="endTime" onclick="WdatePicker({dateFmt:\'yyyy-MM-dd HH:mm\'})" style="width:200px" placeholder="请选择结束时间">' 
				+'<div class="line2"></div>'
				+'<h2 class="title">报名提交标准<label for="actRegWords" class="error success"></label></h2>'
				+'<input class="iptnewtit" type="text" id="actRegWords" name="actRegWords" placeholder="对报名资料的提交标准进行一句话提示" />'
				+'<div class="line2"></div>'
				+'<h2 class="relran" style="font-weight: bold;">奖品设置<span style="font-weight:normal;font-size: 16px;">【请通过下面逐个添加奖品！】</span><label for="prizeConcat" class="error success"></label></h2>'
				+'<div style=" overflow:hidden;"><img onclick="startActiveJpszinfo()" src="${ctx}/images/icon/add.jpg" width="100" height="100" style="float:left; padding-right:10px;"><div style="color:#000; padding-top:26px;"><label style="font-weight:bold; color:#ff0000;">点击添加奖品</label>  请上传【宽300PX、高300PX】jpg格式图片<br>图片大小不能超过30K!</div></div>'
				+'<input type="hidden" name="prizeConcat" id="prizeConcat" value="">'
				+'<div class="line2"></div>'
				+'<div id="prizeConcatDiv"></div>';

				$("#rankId").empty();
	    		$("#bmhdId").empty();
	    		$("#tphdId").empty();
	    		$("#yhqId").empty();
	    		$("#qnhId").empty();
	    		$("#yhqAvtiveTime").empty();
	    		$("#typeName").val("精品投票活动");
				$("input[name='state']:eq(0)").val("0");
				$("#jptpId").append(htmlDom);
			}
		});
	    
	    // 定时发布时间是否显示
	    $("input[name='state']").change(function() {
			var $state = $("input[name='state']:checked").val();
			if ($state == 6) {
				var htmlDom = '定时发布时间：<input type="text" class="iptnewtit"  name="timingPublicTime1" onfocus="WdatePicker({dateFmt:\'yyyy-MM-dd HH:mm:ss\'})" style="width:240px" />';
				$("#timingPublicLabel").append(htmlDom);
			} else {
				$("#timingPublicLabel").empty();
			}
		});
	    
	    $(function () {
            $("input[name='number']").keyup(function () {
                //如果输入非数字，则替换为''
                this.value = this.value.replace(/[^\d]/g, '');
            })
        });
	    


        //关闭时间设置
        $('#closeSetTime').click(function() {
            $("#setTimeLayer").fadeOut("slow");
        });
        
        //选择时间
        $('#setTimeOk').click(function() {
        	var date = $("#datepicker").datepicker("getDate");
        	if(date == '') {
        		alert('请选择日期');
        	}else if($('#setHour').val() == '' || $('#setMinute').val() == '') {
        		alert('请选择小时和分钟');
        	}else{
        		//获得日期和时间
        		var hour = $('#setHour').val();
        		var minute = $('#setMinute').val();
        		$('#planTime').val(formatDate(date)+' '+hour+':'+minute);
        		$('#planTimeShow').text(formatDate(date)+' '+hour+':'+minute);
        		$("#setTimeLayer").fadeOut("slow");
        	}
        });
        
      	//取消时间设置
        $('#setTimeCancel').click(function() {
            $("#setTimeLayer").fadeOut("slow");
        });
      	
      	$('.closeSetTime').click(function() {
      		$("#setTimeLayer").fadeOut("slow");
      	});
    	
    	//活动列表图
    	$('#actPicBtn').click(function() {
    		$('#picUploadLayer').fadeIn('slow');
    		//初始化上传
        	uploadInit('activity', 'actPic', '1', '0');
        	$('#uploadField').val('actPic');
    	});
    	
    	//活动列表结束图
    	/* $('#actPicNoBtn').click(function() {
    		$('#picUploadLayer').fadeIn('slow');
    		//初始化上传
        	uploadInit('activity', 'actPicNo', '1', '0');
        	$('#uploadField').val('actPicNo');
    	}); */
    	
    	//APP小图
    	$('#appPicBtn').click(function() {
    		$('#picUploadLayer').fadeIn('slow');
    		//初始化上传
        	uploadInit('activity', 'appPic', '0', '0');
        	$('#uploadField').val('appPic');
    	}); 
    	
    	//显示类型展示层
    	$('#typeLayerShow').click(function() {
    		$('#typeLayer').fadeIn('slow');
    	});
    	
    	//类型确定
    	$('#typeOk').click(function() {
    		var annoType = $("input[name='typeId']:checked").val();
    		if(annoType == undefined) {
    			alert('请选择活动类型');return;
    		}else{
    			$("#typeLayer").fadeOut("slow");
    		}
    	});
    	
    	//类型取消
    	$('#typeCancel').click(function() {
    		$('#typeLayer').fadeOut('slow');
    	});
    	
    	//选择范围结点
        $('#scopeTree').tree({
            checkbox: true,
            onSelect: function(node){
                var children = $('#scopeTree').tree('getChildren', node.target);
                if(children.length == 0) {//无子元素加入子结点,已有则展开结点即可
                    var idArr = node.id.split('_');
                    if(idArr[0] == 'building') {//加载楼栋下的单元
                        $.ajax({
                            url: '${ctx}/business/businessActivity/getEstateTree.do',
                            dataType: 'json',
                            data: {buildingId: idArr[1]},
                            cache: false,
                            success: function (data) {
                                 
                                if(data.success == true){
                                    $('#scopeTree').tree('append', {
                                        parent: node.target,
                                        data: data.result
                                    });
                                    $('#scopeTree').tree('expend', node);
                                }else{
                                    //$('#dep_'+depId).html('很抱歉，没有相关记录。');
                                }
                            },
                            error: function () {
                                //$('#dep_'+depId).html('很抱歉，加载内容出错，我们及时修改问题。');
                            }
                        });

                    }
                }else{
                    $('#scopeTree').tree('expend', node);
                }
            }
        });

        //显示范围层
        $("#showScopeLayer").click(function(){
            $("#scopeLayer").fadeIn("slow");
            $("#scopeLayer").css("height",$(document.body).outerHeight(true)+'px');
            $("#scopeBar").css("height",$(document.body).outerHeight(true)-40+'px');
            //显示小区列表
            $.ajax({
                url: '${ctx}/business/businessActivity/getEstateTree.do',
                dataType: 'json',
                data: {flag: 'add'},
                cache: false,
                success: function (data) {
                    if(data.success == true){
                        var rows = data.result;
                        //alert('data.result   '+rows.length);
                        if(rows.length > 0) {
                            $('#scopeTree').tree('loadData', data.result);
                        }else{
                            $('.accordion2').html('很抱歉，没有相关记录。');
                        }
                    }else{
                        $('.accordion2').html('很抱歉，没有相关记录。');
                    }
                },
                error: function () {
                    $('.accordion2').html('很抱歉，加载内容出错，我们及时修改问题。');
                }
            });
        });

        //关闭范围层
        $('#closeScope').click(function() {
        	//置空
        	 $('#scopeTree').tree('loadData', data.result);
            $("#scopeLayer").fadeOut("slow");
        });

        //选择范围
        $('#scopeOk').click(function() {
            var scopeIds = '';
            var scopeAry = [];
            var scopeInfo = '';
            var scopeNodes = $('#scopeTree').tree('getChecked');
            if(scopeNodes != null && scopeNodes.length > 0) {
            	for(var i=0;i<scopeNodes.length;i++) {
                	var node = scopeNodes[i];
                	if(node.id.indexOf("com")<0 && node.id.indexOf("allCom")<0){
                		var idArr = node.id.split('_');
                        var typeid = idArr[0];
                        scopeIds += idArr[1] + ':' + node.text + ',';
                        // alert('scopeIds   '+scopeIds);
                        scopeInfo += node.text + ',';
                	}
                }
                if(scopeIds != '') {
                    if(scopeIds.indexOf(',') > -1) {
                        scopeIds = scopeIds.substring(0, scopeIds.length-1);
                        scopeInfo = scopeInfo.substring(0, scopeInfo.length-1);
                    }
                }
                $('#actScope').val(scopeIds);
                $('#actScopeInfo').val(scopeInfo);                
                $('#actScopeShow').html(scopeInfo);                
                $("#scopeLayer").fadeOut("slow");
            }else{
                alert('请选择活动发布范围');
            }
        });

        //取消选择范围
        $('#scopeCancel').click(function() {
            $("#scopeLayer").fadeOut("slow");
        });
    	
        //计划时间
        //定时提醒日期
        $("#datepicker").datepicker({
        	altFormat: 'yy-mm-dd',
        	dateFormat: 'yy-mm-dd',
			autoSize: true,
			changeMonth: true,
			minDate: 0
		},
		$.datepicker.regional['zh-CN']);
        
    	
      	
      	var flag = false;
        //验证表单
        $('#ff').validate({
            submitHandler:function(form){
            	if(flag == true) {
            		return;
            	}else{
            		flag = true;
            	}
           		$('#qrbut').attr("disabled","disabled");
           		
           		var isPush = document.getElementsByName("isPush");
            	if(isPush[0].checked) {
                    window.location.href = '<%=ctx%>/business/businessActivity/list.do';
                    $('#ff').form('submit', {
                        success:function(data){
                            var data = eval('(' + data + ')');  // 改变json对象为javascript对象
                            alert(data.message);
                        }
                    });
            	}else {
            		$('#ff').form('submit', {
                        success:function(data){
                            var data = eval('(' + data + ')');  // 改变json对象为javascript对象
                            alert(data.message);
                            window.location.href = '<%=ctx%>/business/businessActivity/list.do';
                        }
                    });
            	}
            },
            errorClass: "error",
            success: function(label) {
                label.html("<span style=\"color:green\">填写正确！</span>").addClass("success");
            },
            rules: {
                actName: {
                    required: true,
                    maxlength : 24
                },
                brief: {
                    required: true,
                    maxlength : 28
                },
                typeId: {
                    required: true
                },
                actScope: {
                    required: true
                },
                actPic: {
                    required: true
                },
                /* actPicNo: {
                    required: true
                }, */
                appPic: {
                    required: true
                },
                actContent: {
                    required: true
                },
                planTime: {
                    required: true
                },
                rank: {
                    required: true,
                    digits: true
                },
                /* isComment: {
                    required: true
                }, */
                isPush: {
                    required: true
                },
                timingPublicTime1: {
                    required: true
                },
                attributeValues: {
                    required: true
                },
                times: {
                    required: true
                },
                timeSlotName1: {
                    required: true
                },
                number: {
                    required: true,
                    digits: true
                },
                startTime: {
                    required: true
                },
                endTime: {
                    required: true,
   					remote: {
   	                    type: "post",
   	                    url: "<%=path %>/business/businessActivity/endTimeXYtimeSlotName.do",
   	                    data: {
   	                    	endTime: function() {
   	                            return $("#endTime").val();
   	                        },
   	                     	timeSlotName1: function() {
	                            return $("#timeSlotName1").val();
	                       	}
   	                    }
   	                }
                },
                jptpTimeslotEndTime: {
                    required: true
                },
                actRegWords: {
                    required: true
                },
                voteType: {
                    required: true
                },
                votes: {
                    required: true,
                    digits: true
                },
                content: {
                    required: true,
                    maxlength : 64
                },
                image: {
                    required: true
                },
                couponName: {
                    required: true,
                    maxlength : 32
                },
                couponDesc: {
                    required: true,
                    maxlength : 64
                },
                couponImg: {
                    required: true
                },
                couponNum: {
                    required: true,
                    digits: true
                },
                couponStartDate: {
                    required: true
                },
                couponEndDate: {
                    required: true
                },
                reportExcel: {
                    required: true
                },
                state: {
                    required: true
                },
                prizeRules: {
                    required: true
                },
                prizeConcat: {
                	required: true
                }
            },
            messages: {
                actName: {
                    required: '请填写活动名称！',
                    maxlength: '活动名称为24字以内'
                },
                brief: {
                    required: '请填写活动简介！',
                    maxlength: '活动简介为28字以内'
                },
                typeId: {
                    required: '请选择活动类型！'
                },
                actScope: {
                    required: '请选择活动类型！'
                },
                actPic: {
                    required: '请选择活动图片！'
                },
                /* actPicNo: {
                    required: '请选择活动结束图片！'
                }, */
                appPic: {
                    required: '请选择分享展示图！'
                },
                actContent: {
                    required: '请填写活动内容！'
                },
                planTime: {
                    required: '请选择活动时间！'
                },
                rank: {
                    required: '请设定获奖排名量！',
                    digits: '排名必须为数字' 
                },
                /* isComment: {
                    required: '请选择是否评论开启！'
                }, */
                isPush: {
                    required: '请选择是否推送！'
                },
                timingPublicTime1: {
                    required: '请选择定时发布时间！'
                },
                attributeValues: {
                    required: '请选择报名表单字段！'
                },
                times: {
                    required: '请选择活动场次！'
                },
                timeSlotName1: {
                    required: '请选择报名活动时间！'
                },
                number: {
                    required: '请输入人数限定！',
                    digits: '人数限定必须为数字' 
                },
                startTime: {
                	 required:  '请选择开始时间！'
                },
                endTime: {
                    required:  '请选择截止时间！',
   					remote: "报名截止时间必须小于报名活动时间"
                },
                jptpTimeslotEndTime: {
                    required: '请选择报名截止时间！',
                },
                actRegWords: {
                    required: '请输入报名提交标准',
                },
                voteType: {
                    required: '请选择投票类型！'
                },
                votes: {
                    required:  '请输入单个用户可投票数量！',
                    digits: '单个用户可投票数量必须为数字' 
                },
                content: {
                    required:  '请输入投票类型文字描述！',
                    maxlength: '投票类型文字描述为64字以内'
                },
                image: {
                    required:  '请上传投票类型图片！'
                },
                couponName: {
                	required: '请填写优惠券名称！',
                    maxlength: '优惠券名称为32字以内'
                },
                couponDesc: {
                	required: '请填写使用规则！',
                    maxlength: '使用规则为64字以内'
                },
                couponImg: {
                	 required:  '请上传优惠券图片！'
                },
                couponNum: {
                	required:  '请输入优惠券数量！',
                    digits: '优惠券数量必须为数字'
                },
                couponStartDate: {
                	required: '请选择有效期开始时间！'
                },
                couponEndDate: {
                	required: '请选择有效期结束时间！'
                },
                reportExcel: {
                	required: '请上传excle格式的文件！'
                },
                state: {
                    required: '请选择发布状态！'
                },
                prizeRules: {
                    required: '请输入奖品发放规则！'
                },
                prizeConcat: {
                    required: '请添加奖品 ！'
                }
            }
        });
    });
    
    //提交表单
    function submitForm() {
        var content = ue.getContent();
        var temp = '';
        if(content != temp) {
            //设置内容
            $('#actContent').val(ue.getContent());
        }
        $('#prizeRules').val(ue1.getContent());
        $('#ff').submit();
    }
    
    //格式化日期
    function formatDate(date) { 
    	var year = date.getFullYear(); 
    	var month = date.getMonth() + 1; 
    	var day = date.getDate(); 
    	return year + "-" + formatTen(month) + "-" + formatTen(day); 
    }
    //格式化时间
    function formatTen(num) { 
    	return num > 9 ? (num + "") : ("0" + num); 
    }
</script>
</html>