<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>居民管理</title>
<%@include file="/common/meta.jsp"%>
<script src="<%=ctx%>/js/nevwuye.js" type="text/javascript"></script>
<link rel="stylesheet"
	href="<%=ctx%>/js/jquery-ui/themes/base/jquery.ui.all.css">
</head>

<div class="max-height">
	<div class="wrapper wrapos">
		<!--左导航开始-->
		<%@include file="/common/leftNav.jsp"%>
		<!--左导航结束-->

		<!--右部主体内容开始-->
		<div class="mainr">
			<%@include file="/common/header.jsp"%>
			<!--下拉显示导航-->
			<div class="scroll">
				<div class="scroll-box">
					<ul id="oneul">
						<li id="type_" class="active navlist"><a href="javascript:;"><span>注册居民</span><b class="donbut"><i></i></b></a> 
							<input type="hidden" name="type" id="type" value="${type}" />
							<input type="hidden" name="dateField" id="dateField" value="${dateField }" />
							<ul class="erjnav">
								<li id="type_1"><a href="javascript:;">其中验证居民</a></li>
							</ul>
						</li>
						<li id="timeScope_" class="navlist"><a href="javascript:;"><span>所有时间范围</span><b class="donbut"><i></i></b></a> 
							<input type="hidden" name="timeScope" id="timeScope" value="${timeScope }" /> 
							<input type="hidden" name="startTime" id="startTime" value="" /> 
							<input type="hidden" name="endTime" id="endTime" value="" />
							<ul class="erjnav">
								<li id="timeScope_0"><a href="javascript:;">当日</a></li>
								<li id="timeScope_7"><a href="javascript:;">7天内</a></li>
								<li id="timeScope_30"><a href="javascript:;">30天内</a></li>
								<li id="timeScope_90"><a href="javascript:;">90天内</a></li>
								<li id="timeScope_365"><a href="javascript:;">365天内</a></li>
								<li id="timeScope_scope"><a href="javascript:;">选择时间范围</a></li>
							</ul>
						</li>
						<c:if test="${orgType =='operation' }">
							<li id="comId_" class="navlist"><a href="javascript:;"><span>所有社区</span><b class="donbut"><i></i></b></a> 
								<input type="hidden" name="comId" id="comId" value="" /> 
								<ul class="erjnav">
									<c:forEach items="${comList }" var="comBean" varStatus="key">
										<li id="comId_${comBean.comId }"><a href="javascript:;">${comBean.comName }</a></li>
									</c:forEach>
								</ul>
							</li>	
							
							<li id="estateId_" class="navlist"><a href="javascript:;"><span>所有小区</span><b class="donbut"><i></i></b></a> 
								<input type="hidden" name="estateId" id="estateId" value="" /> 
								<ul id="estateUL" class="erjnav"></ul>
							</li>	
						</c:if>					
					</ul>
					<p id="rowCount" style="float: left; line-height: 52px; color: #cc2510; font-weight: bold; margin-left: 20px;">共${pager.rowCount }条</p>
				</div>
				<div id="search">
					<div class="borbox">
						<input id="searbox" type="text" name="keyWord" value="" placeholder='真实姓名/昵称/电话/小区名称搜索' />
						<input id="searbut" type="button" onclick="search()" value="" />
					</div>
				</div>
			</div>
			
			<div class="column">
				<c:forEach items="${baseBean.list }" var="user" varStatus="key">
					<div class="manbox"
						<c:if test="${key.index % 3 == 0}" >style="margin-left:0;"</c:if>>
						<a class="nopotr" href="javascript:;">
							<div class="info">
								注册时间：<span><fmt:formatDate value="${user.registTime }" pattern="yyyy-MM-dd HH:mm" /></span>
							</div>
							<hr class="link">
							<h2 class="yggl_title" style="line-height:21px;">
								<span class="yggl_poht"><img src="<%=ctx %>${user.portrait}" style="width: 100%;"></span>
								<em>真实姓名：${user.realname }</em><br>
								<em>昵　　称：${user.nickname }</em><br>
								<em>电　　话：${user.tel }</em>
							</h2>
							<div class="state">
									<c:choose>
										<c:when test="${user.type == 0}"><span class="yggl_relsta cgreen"> 注册用户</span></c:when>
										<c:when test="${user.type == 1}"><span class="yggl_relsta cyellow"> 验证用户</span></c:when>
									</c:choose>
							</div>

							<p class="yggl_text">常用小区：<span>${user.estateName }</span></p>
		                    <p class="yggl_text">常用地址：<span>${user.address }</span></p>
		                    <p class="yggl_text">最后登录时间：<span><fmt:formatDate value="${user.lastLoginTime }" pattern="yyyy-MM-dd HH:mm"/></span></p>
		                    <hr class="link">
		                    
		                    <div class="operate operate2 blop">
		                    	<shiro:hasPermission name="appuser_view_detail">
			                    <span class="see"  title="查看居民详情" id="block5" onclick="seeUserDetail(${user.userId})"></span>
			                    </shiro:hasPermission>
			                    <%-- <shiro:hasPermission name="appuser_view">
			                    <span class="edit" onclick="chat(${user.userId})"></span>
			                    <span class="message" onclick="chat(${user.userId})"></span>
			                    </shiro:hasPermission>
			                    <span class="del" id="block9" onclick="userReport(${user.userId}, '${user.realname }')"></span> --%>
		                    </div>
						</a>
					</div>
				</c:forEach>
				<div class="no-float"></div>
			</div>
			<div class="page">
				<div class="pagec">
					<input type="hidden" id="pageCount" value="${pager.pageCount}" />
					<ul id="pageUl">
						<li><a id="arrow-l" class="arrow" href="javascript:prev();" <c:if test="${pager.pageId <= 1 }"> disabled </c:if>></a></li>
						<c:forEach items="${pager.indexs }" var="pageNo">
							<li><a <c:if test="${pageNo == 1}"> id="curr" </c:if> href="javascript:jump(${pageNo });"><span id="page_${pageNo }">${pageNo }</span></a></li>
						</c:forEach>
						<li><a id="arrow-r" class="arrow" href="javascript:next();" <c:if test="${pager.pageId >= pager.pageCount }"> disabled </c:if>></a></li>
					</ul>
				</div>
			</div>
			<div class="no-float"></div>
			<%@include file="/common/footer.jsp"%>
		</div>
		<!--右部主体内容结束-->
		</div>
		</div>
		
		<div id="userInfoLayer" class="busswi5 s-xw-bu">
			<div id="userInfoBar" class="sidebar5 s-xw-si">
				<a id="close5" title="关闭" class="s-xw-cl" href="javascript:;" onclick="$('#userInfoLayer').fadeOut('slow');"></a>
				<h2 class="tit5">居民信息<em>【<span id="userType"></span>】</em></h2>
				<div id="wrapper-250"  style="bottom:40px;">
					<ul class="accordion5">
						<li id="one5" class="files"><a href="#one"><lable style="color: #333;">基本信息</lable></a></li>
						<div class="link5"></div>
						<ul class="sub-menu8">
							<li><span class="xxl">所属小区：<lable id="estateName"></lable></span></li>
							<li><span class="xxl">注册时间：<lable id=registTime></lable></span></li>
							<li><span class="xxl">验证时间：<lable id="verifyTime"></lable></span></li>
							<li><span class="xxl">居民身份：<lable id="userIdentity"></lable></span></li>
							<li><span class="xxl">备注居民：<lable id="remark" style="color: #cc2510;"></lable></span>
								<div id="remarksDiv" class="s-xw-con" style="margin-top:10px;">
									<input type="hidden" name="userId" id="userId"/>
									<textarea class="iptnewtit" id="remarks" name="remarks" style="width:200px;height:22px; font-size:14px; padding-top:5px; padding-left:5px;" placeholder="请输入备注居民信息" ></textarea>
									<input type="button" value="保存" onclick="submitRemarks()"> 
									<input type="button" value="取消" onclick="$('#remarksDiv').hide();">
								</div>
							</li><br/>
							<li id="one5" class="files"><a href="#one"><lable style="color: #333;">个人资料</lable></a></li>
							<div class="link5"></div>
							<li id="jmgl_one"><a href="#">头像：<span class="jmgl_poht" id="portrait"></span>
							</a></li>
							<li><a href="#">真实姓名：<i class="jmgl_change"><span id="realname"></span></i></a></li>
							<li><a href="#">绑定手机：<i class="jmgl_change"><span id="boundphone"></span></i></a></li>
							<li><a href="#">昵称：<i class="jmgl_change"><span id="nickname"></span></i></a></li>
							<li><a href="#">微信：<i class="jmgl_change"><span id="weixin"></span></i>
							</a></li>
							<li><a href="#">性别：<i class="jmgl_change"><span id="sex"></span></i></a></li>
							<li><a href="#">生日：<i class="jmgl_change"><span id="birthday"></span></i></a></li>
							<li><a href="#">地址：<i class="jmgl_change"><span id="address"></span></i></a></li> <br>
							<li id="one5" class="files"><a href="#one"><lable style="color: #333;">小区信息</lable></a></li>
							<div class="link5"></div>
							<li><a href="#">常用小区：<i class="jmgl_change"><span id="oftenestate"></span></i></a></li>
							<li><a href="#">所属驿站：<i class="jmgl_change"><span id="staName"></span></i></a></li>
							<div class="link5"></div>
							<div class="submtpres"></div> 
						</ul>
					</ul>
				</div>
			</div>
		</div>
		
		<!-- <div id="activeLogLayer" class="busswi5 s-xw-bu">
			<div id="activeLogBar" class="sidebar5 s-xw-si">
				<a id="close5" title="关闭" class="s-xw-cl" href="javascript:;" onclick="$('#activeLogLayer').fadeOut('slow');"></a>
				<h2 class="tit5">使用记录</h2>
				<div id="wrapper-250">
					<ul class="accordion5">
						<li id="one9" class="files"><a href="#one">物业报修<i>（<span id="repaircount"></span>次）</i></a></li>
						<div class="link9_9"></div>
						<ul class="sub-menu9">
							<div id="repairDiv"></div>
							<li id="one9_9" class="files"><a href="#one">建议/投诉<i>（<span id="feedcount"></span>次）</i></a></li>
							<div id="feekDiv"></div>
						</ul>
					</ul>
				</div>
			</div>
		</div> -->
</html>

<!-- 开始时间设置 -->
<div id="dateDialog" title="选择日期范围">
	<div>
		<label for="setStartTime">开始日期</label> <input type="text" class="iptnewtit" name="setStartTime" id="setStartTime" value="" />
		<label for="setEndTime">结束日期</label> <input type="text" class="iptnewtit" name="setEndTime" id="setEndTime" value="" />
	</div>
</div>
<!-- 开始时间设置 -->

<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>
<script src="<%=ctx%>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>
<script src="<%=ctx%>/js/jquery-ui/jquery.ui.datepicker-zh-CN.js" ype="text/javascript"></script>
<script type="text/javascript">
	$(function () {
		$(document).keyup(function(event){
			  if(event.keyCode ==13){
			    $("#searbut").trigger("click");
			  }
		});
	});
	
	//初始化判断是否首页跳转过来的链接并更改默认搜索条件
	$(function(){  
		if($('#type').val() != undefined && $('#type').val() != '') {
			var objId = 'type_'+$('#type').val();
			bindChange($('#'+objId));
		}
		if($('#timeScope').val() != undefined && $('#timeScope').val() != '') {
			var objId = 'timeScope_'+$('#timeScope').val();
			bindChange($('#'+objId));
		}
	}); 
	
	//获取多参数
	function getParams() {
		var params = '';
		var keyWord = $('#searbox').val();
		if($('#type').val() == 1) {//验证
			$('#dateField').val('verifyTime');
		}else{//注册
			$('#dateField').val('registTime');
		}
		if(keyWord != '' && keyWord != null) {
			params = {keyWord: keyWord};
		}else{
			params = {
					type: $('#type').val(),
					timeScope: $('#timeScope').val(),
					startTime: $('#startTime').val(),
					endTime: $('#endTime').val(),
					orderBy: $('#orderBy').val(),
					dateField: $('#dateField').val(),
					comId:$('#comId').val(),
					estateId:$('#estateId').val()
			};
		}
		return params;
	}
    
    //跳转页面
    function jump(pageNo) {
    	$('.column').html('');
    	$('#loading').css('display', 'block');
    	var params = getParams();
    	if(pageNo != 0) {
    		params.page = pageNo;
    	}
    	$.ajax({
    		type: 'post',
            url: '<%=path %>/app/appUser/getPageList.do',
            timeout: 1000,
            data: params,
            cache: false,
            dataType: 'json',
            success: function (data) {
            	$("#rowCount").html("共" + data.total + "条");  // 根据查询条件更新总条数
                var rows = data.rows;
                if(rows.length > 0) {
                	for(var i=0;i<rows.length;i++) {
                    	var row = rows[i];    
                    	var styleStr = '';
                    	if(i % 3 == 0) {
                    		styleStr = 'style="margin-left:0;"';
                    	} 
                    	var type = '';
                    	if(row.type == 0) {
                    		type = '<span class="yggl_relsta cgreen"> 注册用户</span>';
    		            }else{
    		            	type = '<span class="yggl_relsta cyellow"> 验证用户</span>';
    		            }  
                    	/* var workerMemo = '';
                    	if(row.workerMemo != '' && row.workerMemo != null) {
                    		workerMemo = '<p class="yggl_text">员工备注：<span>'+row.workerMemo+'</span></p>';
                    	} */
                    	var htmlDom = ''                    	
                    	+ '<div class="manbox"' 
    	        		+ styleStr
    	        		+ '>'
                        + '<a class="nopotr" href="javascript:;">'
    		            + '<div class="info">注册时间：<span>'+(row.registTime != '' ? row.registTime.substring(0, 16) : '')+'</span></div>'
    		            + '<hr class="link">'
    		            + '<h2 class="yggl_title" style="line-height:21px;"><span class="yggl_poht"><img src="<%=ctx%>'+row.portrait+'" style="width:100%;"></span><em>真实姓名：'+row.realname+'</em><br><em>昵　　称：'+row.nickname+'</em><br><em>电　　话：'+row.tel+'</em></h2>'
    		            + '<div class="state">'+type+'</div>'
    		            + '<p class="yggl_text">常用小区：<span>'+row.estateName+'</span></p>'
    		            + '<p class="yggl_text">常用地址：<span>'+row.address+'</span></p>'
						
    		            + '<p class="yggl_text">最后登录时间：<span>'+(row.lastLoginTime != 'null' ? row.lastLoginTime.substring(0, 16) : '')+'</span></p>'
    		            + '<hr class="link">'
    		            + '<div class="operate operate2 blop">'
    		            <shiro:hasPermission name="appuser_view_detail">
    		            + '<span class="see" title="查看居民详情" id="block5" onclick="seeUserDetail('+row.userId+')"></span>'
    		            </shiro:hasPermission>
    		            // + '<span class="message" onclick="chat('+row.userId+')"></span>'
    		            //+ '<span class="del" id="block9" onclick="userReport('+row.userId+', '+row.userName+')"></span>'
    		            + '</div>'
    		            + '</a>'
    		            + '</div>';
                    	$('.column').append(htmlDom);
                    }
                }else{
                	$('.column').html('很抱歉，没有相关记录。');
                }
                $('.column').append('<div class="no-float"></div>');
                $('#loading').css('display', 'none');
                
             	// 获取社区下对于的所有小区
            	$('.erjnav').eq(3).html('');
            	var comId = $("#comId").val();
            	$.ajax({
					type: 'post',
			        url: '<%=path %>/manage/manageEstate/findEstateByComId.do',
			        dataType: 'json',
			        data: {comId : comId},
			 		cache: false,
			        success: function (data) {
			            var rows = data.rows;
	                	var estateId = $("#estateId").val();
		            	var htmlDom = "";
		            	
	                	if(estateId != "") {
		                	htmlDom = '<li id="estateId_"><a href="javascript:;">所有小区</a></li>';
		                	$('.erjnav').eq(3).append(htmlDom);
	                	}
	                	
			            if(rows.length > 0 && comId != "") {
			            	for(var i=0;i<rows.length;i++) {
			                	var row = rows[i];  
			                	if(row.estateId != estateId) {
				                	htmlDom = '<li id="estateId_'+row.estateId+'"><a href="javascript:;">'+row.estateName+'</a></li>';
				                	$('.erjnav').eq(3).append(htmlDom);
			                	}
			            	}
			            	$('#oneul').find('.erjnav:eq(3)>li').each(function(index, obj) {
								bindClick($(obj));
							});
			            }else {
			            	$('.erjnav').eq(3).html('');
			            }
			        },
			        error: function () {
			        	$('.erjnav:eq(3)').html('很抱歉，加载小区内容出错，我们及时修改问题。');
			        }
			    });
            	
                var vis = $("#pageUl li:not(#pageUl :first,#pageUl :last):visible");//显示的数量
               	var liCount = '';  
                for(var pageno=1; pageno<=(data.pageCount); pageno++){
                	var flag=false;
                	for(var i=0;i<vis.size();i++){
                		if(vis.eq(i).find("span").text()==pageno){
                			flag=true;
                		}
                	}
                	if(flag){
                		liCount = liCount + '<li><a   href="javascript:jump('+pageno+');"><span id="page_'+pageno+'">'+pageno+'</span></a></li>';
                	}else{
                		liCount = liCount + '<li style="display:none";><a  href="javascript:jump('+pageno+');"><span id="page_'+pageno+'">'+pageno+'</span></a></li>';
                	}
                }
                var boolnext = '';
                if((data.pageId)>=(data.pageCount)) { boolnext='#'; }else { boolnext='javascript:next();'; }
                var boolprev = '';
                if((data.pageId)<=1) { boolprev='#'; }else { boolprev='javascript:prev();';  }
	           	var pageDom = ''
	           		+ '<div class="pagec"><ul id="pageUl">'
	           		+ '<li><a id="arrow-l" class="arrow" href="'+boolprev+'"></a></li>'
	           		+ liCount
	           		+ '<li><a id="arrow-r" class="arrow" href="'+boolnext+'"></a></li>'
	           		+ '</ul></div>';
	           	$('.page').html('');
            	$('.page').html(pageDom);
	            setCurrPageNo(pageNo);
            },
            error: function () {
            	$('.column').html('很抱歉，加载内容出错，我们及时修改问题。');
            }
        });
    }
    
     //发布评论
	 function chat(userId) {
		 window.location.href = '<%=ctx%>/business/businessUserPropertyCom/getChatInfo.do?userId='+userId;
	 }
    
     //查看用户详情
     function seeUserDetail(userId) {
	  	$('#userInfoLayer').fadeIn("slow");
		$('#remarksDiv').hide();
        $.getJSON('${ctx}/app/appUser/getUserDetail.do', {userId : userId}, function(data) {
            $('#userType').text(data.type == 0 ? '注册用户' : '验证用户');
            $('#estateName').text(data.estateName); //所属小区
            $('#registTime').text(data.registTime != '' ? data.registTime.substring(0, 16) : ''); //注册时间
            $('#verifyTime').text(data.verifyTime != '' ? data.verifyTime.substring(0, 16) : ''); //验证时间
            $('#portrait').html('<img src="<%=ctx %>'+data.portrait+'" style="width:100%;">');  //头像
            $('#realname').text(data.realname); //真实姓名
            $('#boundphone').text(data.boundphone); //绑定手机
            $('#nickname').text(data.nickname); //昵称
            $('#weixin').text(data.weixin); //微信
            $('#sex').text(data.sex == 0 ?'男':'女'); //性别
            $('#birthday').text(data.birthday); //生日
            $('#address').text(data.estateName+data.buildingName+data.unitName+data.houseNo); //地址
            $('#oftenestate').text(data.oftenestate); //常用小区
            $('#staName').text(data.staName); //所属驿站
            $('#userIdentity').text(data.isWorker == 0 ? "普通居民":"社区报记者");  //居民身份
            $('#remark').text(data.remarks); 
            $('#userId').val(data.userId);    
            //submtpres
            var html ;
            if (data.isWorker == 0 ) {
					html = "<input id=\"qrbut5\" title=\" 开通记者权限\" type=\"button\" value=\"开通记者权限\" onclick=\"changeIdentity("+data.userId+",1);\"/>";  	
            }  else {
            		html = "<input id=\"qrbut5\" title=\" 关闭记者权限\" type=\"button\" value=\"关闭记者权限\" onclick=\"changeIdentity("+data.userId+",0);\"/>";  
            }
            html += "<input id=\"zsbut5\" title=\" 备注居民\" type=\"button\" value=\"备注居民\" onclick=\"showRemarks();\"/>";
            $('.submtpres').html(html);
        });
    }
     
     function changeIdentity(userId,isWork)
     {
 		var bool = window.confirm("您确定修改身份？");
	    if(bool) {
	        $.post("updateIdentity.do", {userId: userId}, function(data) {
	        	eval("data = "+data);
    			alert(data.message);
	            window.location.reload();
	        });
	    }
     }
     
     function showRemarks(){
    	 $('#remarksDiv').fadeIn("slow");
     }
	 
     function submitRemarks(){
    	 var remarks = $('#remarks').val();
    	 if(remarks == '') {
    		 alert("请输入备注居民信息！");
    	 } else {
    		 var bool = window.confirm("您确定保存备注居民信息？");
 		     if(bool) {
 				$.post('updateRemarks.do', {
 		    		id : $('#userId').val(),
 		    		remarks : $('#remarks').val()
 		    		}, 
 		    		function(data) {
 		    			eval("data = "+data);
 		    			alert(data.message);
 		            	window.location.reload();
 		        }); 
 		    }
    	 }
     }
     
    //用户使用记录
    function userReport(userId, realname) {
    	$('#activeLogLayer').fadeIn("slow");
        
        $('#curuser').text(realname);
        //报修次数
        $.post('${ctx}/business/businessRepair/getRepairtCount.do', {reporterId : userId}, function(data) {
            $('#repaircount').text(data);
        });
        //报修信息
        $.getJSON('${ctx}/business/businessRepair/getRepairtInfoByUser.do', {reporterId : userId}, function(data) {
            $('#repairDiv').empty();
            $.each(data, function(i, item) {
                var html =
                '<div class="link9"></div>'
                +'<li><a href="#">类型：<i class="jmgl_change">报修类型</i></a></li>'
                +'<li><a href="#">提交时间：<i class="jmgl_change">2014-05-04  14:55</i></a></li>'
                +'<li><a href="#">状态：<i class="jmgl_change">未解决</i></a></li>'
                +'<li><a href="#">服务评价：<i class="jmgl_change"><img src="${ctx}/images/icon/icon2_2.jpg" width="20" height="20"></i><img src="${ctx}/images/icon/icon2_2.jpg" width="20" height="20"></i><img src="${ctx}/images/icon/icon2_2.jpg" width="20" height="20"></i> </a></li>';
                $('#repairDiv').append(html);
            });
        });

        //用户反馈次数
        $.getJSON('${ctx}/business/businessFeedback/getFeedCount.do', {fberId : userId}, function(data) {
            $('#feedcount').text(data);
        });
        //用户反馈信息
        $.getJSON('${ctx}/business/businessFeedback/getFeedInfoByUser.do', {fberId : userId}, function(data) {
            $('#feekDiv').empty();$.each(data, function(i, item) {
                var html =
                        '<div class="link9"></div>'
                        +'<li><a href="#">类型：<i class="jmgl_change">报修类型</i></a></li>'
                        +'<li><a href="#">提交时间：<i class="jmgl_change">2014-05-04  14:55</i></a></li>'
                        +'<li><a href="#">状态：<i class="jmgl_change">未解决</i></a></li>'
                        +'<li><a href="#">服务评价：<i class="jmgl_change"><img src="${ctx}/images/icon/icon2_2.jpg" width="20" height="20"></i><img src="${ctx}/images/icon/icon2_2.jpg" width="20" height="20"></i><img src="${ctx}/images/icon/icon2_2.jpg" width="20" height="20"></i> </a></li>';
                $('#feekDiv').append(html);
            });
        });
    }
</script>