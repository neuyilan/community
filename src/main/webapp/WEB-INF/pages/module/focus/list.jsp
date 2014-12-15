<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>焦点图管理</title>
        <%@include file="/common/meta.jsp"%>
        <script src="<%=ctx%>/js/nevwuye.js" type="text/javascript"></script>
        <link rel="stylesheet" href="<%=ctx%>/js/jquery-ui/themes/base/jquery.ui.all.css">
    </head>

    <div class="max-height">
    <div class="wrapper wrapos">
        <!--左导航开始-->
        <%@include file="/common/leftNav.jsp"%>
        <!--左导航结束-->

        <!--右部主体内容开始-->
        <div class="mainr">
            <%@include file="/common/header.jsp"%>
            <div class="scroll">
	        	<div class="scroll-box">
	                <ul id="oneul">
	                	<li id="state_" class="active navlist"><a href="javascript:;"><span>全部焦点图</span><b class="donbut"><i></i></b></a>
	                    	<input type="hidden" name="state" id="state" value="${state }" />
	                    	<ul>
	                            <li id="state_0"><a href="javascript:;">已发布</a></li>
	                            <li id="state_1"><a href="javascript:;">待发布</a></li>
	                            <li id="state_2"><a href="javascript:;">待审核</a></li>
	                            <li id="state_3"><a href="javascript:;">未通过</a></li>
	                        </ul>
	                    </li>                
	                                        
	                    <li id="timeScope_" class="navlist"><a href="javascript:;"><span>所有时间范围</span><b class="donbut"><i></i></b></a>
                    		<input type="hidden" name="timeScope" id="timeScope" value="" />
                    		<input type="hidden" name="startTime" id="startTime" value="" />
                    		<input type="hidden" name="endTime" id="endTime" value="" />
	                    	<ul>
	                    		<li id="timeScope_0"><a href="javascript:;">当日</a></li>
	                            <li id="timeScope_7"><a href="javascript:;">7天内</a></li>
								<li id="timeScope_30"><a href="javascript:;">30天内</a></li>
								<li id="timeScope_90"><a href="javascript:;">90天内</a></li>
								<li id="timeScope_365"><a href="javascript:;">365天内</a></li>
								<li id="timeScope_scope"><a href="javascript:;">选择时间范围</a></li>
	                        </ul>
	                    </li>
	                    
	                    <li id="orderBy_" class="navlist"><a href="javascript:;"><span>最新时间排序</span><b class="donbut"><i></i></b></a>
	                    	<input type="hidden" name="orderBy" id="orderBy" value="" />
	                    	<ul>
	                            <li id="orderBy_visits"><a href="javascript:;">展示量高到低</a></li>
	                        </ul>
	                    </li>
	                </ul>
	                 <p id="rowCount" style="float:left; line-height:52px; color:#cc2510; font-weight:bold; margin-left:20px;">共${pager.rowCount }条</p>
	            </div>
	        	<div id="search"><div class="borbox"><input id="searbox" type="text" name="keyWord" placeholder='标题/选用人搜索'/><input id="searbut" type="button" onclick="search()"/></div></div>
	        </div>
	        
	        <div class="column">
	            <shiro:hasPermission name="focus_publish">
		        	<div class="manbox"  style="margin-left:0;">
		            	<a class="nopotr2 s-baoliao-no" href="javascript:window.location.href='<%=ctx %>/business/businessFocus/add.do';" style="cursor:pointer; height:326px;">
		                    <div class="relnews">
	                            <img src="<%=ctx %>/images/icon/relnews.png" style="width:100%;" />
	                        </div>
		                	<span class="tittex">发布焦点图</span>
		                </a>
		            </div>
	            </shiro:hasPermission>
	            
	            <c:forEach items="${baseBean.list }" var="focus" varStatus="key">
	            		
	            		<shiro:lacksPermission name="focus_publish">
	        				<div class="manbox" <c:if test="${key.index % 3 == 0}" > style="margin-left:0;" </c:if> >
	        			</shiro:lacksPermission>
	        			<shiro:hasPermission name="focus_publish">
	        				<div class="manbox" <c:if test="${key.index % 3 == 2}" > style="margin-left:0;" </c:if> >
	        			</shiro:hasPermission>
	        			
		            	<a class="nopotr2 s-baoliao-no" href="javascript:;" style="height:326px;"> 
		                    <div class="info">
		                    	<p style="float:left;">范围：<span style="color: #3EAF0E;">${focus.focusScope}</span></p>
		                    </div>
		                    <time><fmt:formatDate value="${focus.selectTime }" pattern="yyyy-MM-dd HH:mm"/></time>
		                    <hr class="link">
		                    <h2 class="s-jdt-title title">${focus.title }</h2>
		                    <div class="state">
								<c:if test="${focus.state == 0 }"><span class="relsta cgreen">已发布</span></c:if>
								<c:if test="${focus.state == 1 }"><span class="relsta cgray">未发布</span></c:if>
								<c:if test="${focus.state == 2 }"><span class="relsta cyellow">待审核</span></c:if>
								<c:if test="${focus.state == 3 }"><span class="relsta cred">未通过</span></c:if>
								<c:if test="${focus.state == 4 }"><span class="relsta cblue">已通过</span></c:if>
								<div class="other-r">
									<i class="look" title="浏览量">${focus.visits }</i>
								</div>
							</div>
		                	<img class="s-jdt-img" src="<%=ctx %>${focus.picUrl}"/>
		                    <hr class="link">
                    		<div class="operate">
                    			<shiro:hasPermission name="focus_view_detail">
                    				<span class="see s-xw-yfb" title="查看焦点图详情" onclick="checkFocusDetail('${focus.focusId}');"></span>
								</shiro:hasPermission>
								<shiro:hasPermission name="focus_edit">
									<span class="edit" title="编辑焦点图" onclick="editFocusId('${focus.focusId}');"></span>
								</shiro:hasPermission>
								<shiro:hasPermission name="focus_delete">
									<span id="text1" class="del"  title="删除焦点图" onclick="delFocus('${focus.focusId}');"></span>
                    			</shiro:hasPermission>
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
	                	<li><a id="arrow-l" class="arrow" href="javascript:prev();" <c:if test="${pager.pageId <= 1 }"> disabled </c:if> ></a></li>
	                	<c:forEach items="${pager.indexs }" var="pageNo">
	                		<li><a <c:if test="${pageNo == 1}"> id="curr" </c:if> href="javascript:jump(${pageNo });"><span id="page_${pageNo }">${pageNo }</span></a></li>
	                	</c:forEach>
	                	<li><a id="arrow-r" class="arrow" href="javascript:next();" <c:if test="${pager.pageId >= pager.pageCount }"> disabled </c:if> ></a></li>
	                </ul>
	        	</div>
	        </div>
            <div class="no-float"></div>
            <%@include file="/common/footer.jsp"%>
        </div>
        <!--右部主体内容结束-->
    </div>
		
    <div id="focusInfoLayer" class="busswi5 s-xw-bu">
	    <div id="focusInfoBar" class="sidebar5 s-xw-si">
	        <a id="close5" title="关闭" class="s-xw-cl" href="javascript:;" onclick="$('#focusInfoLayer').fadeOut('slow');"></a>
	        <h2 class="tit5">焦点图内容<em>【<span id="showstate"></span>】</em></h2>
	        
	        <div id="wrapper-250">
	            <ul class="accordion5">
	                <li id="one5" class="files"><a href="#one"><lable id="title" style="color: #333;"></lable></a></li>
	                <div class="link5"></div>
	                <ul class="sub-menu5 s-xw-xx">
		              	<li><span>范围：<lable id="focusScope1"></lable></span></li>
		              	<li><span class="xxl">选用人：<lable id="selectorName"></lable></span><span class="xxr">选用时间：<lable id="selectTime"></lable></span></li>
		              	<li><span class="xxl">审核人：<lable id="auditorName"></lable></span><span class="xxr">审核时间：<lable id="auditTime"></lable></span></li>
	               		<div class="s-xw-ic"><i class="look"><lable id="visits"></lable></i></div>
	              		<div class="link5"></div>
	              		 <li id="auditInfo1" style="color: #cc2510; margin:17px 0 10px 0; display:none;"><lable id="auditInfo2"></lable></li>
		                <div id="hr1" class="link5" style="display:none;"></div>
	              		<li>
		                	<div class="s-xw-con">
		                		<lable id=picUrl></lable><br>
		                		<span >焦点图链接地址： </span>
		                		<div><lable id="pageUrl"></lable></div>
		                	</div>
		                </li>
	           		</ul>
	            </ul>
	        </div>
	        <div class="s-xw-zd">
        		<div class="link6"></div>
           		<div class="submtpres">
               		<lable id="ding"></lable>
           		</div>
       		</div>
       	</div>
	</div>
	
	<div id="focusInfoLayer1" class="busswi5 s-xw-bu">
        <div id="focusInfoBar1" class="sidebar5 s-xw-si">
            <a id="close5" title="关闭" class="s-xw-cl" href="javascript:;" onclick="$('#focusInfoLayer1').fadeOut('slow');"></a>
            <h2 class="tit5">焦点图内容<em>【<span id="showstate2"></span>】</em></h2>
            <div id="wrapper-250">
                <ul class="accordion5">
                    <li id="one5" class="files"><a href="#one"><lable id="title2" style="color: #333;"></lable></a></li>
                    <div class="link5"></div>
                    <ul class="sub-menu5 s-xw-xx">
		                <li><span>类型：<lable id="focusScope2"></lable></span></li>
		                <li><span class="xxl">选用人：<lable id="selectorName2"></lable></span><span class="xxr">选用时间：<lable id="selectTime2"></lable></span></li>
		                <div class="link5"></div>
		                <li><div class="s-xw-con"><lable id="focusId2"></lable><textarea class="iptnewtit" id="auditInfo" name="auditInfo" style="width:435px;height:200px; font-size:14px; padding-top:5px; padding-left:5px;" placeholder="请输入拒绝原因，发送至提交人" ></textarea></div></li>
	              	</ul>
                </ul>
            </div>
            <div class="s-xw-zd">
	      		<div class="link6"></div>
	          	<div class="submtpres">
	                  <input id="qrbut7" type="button"  value="确定" onclick="updateFocusState()"/>
	                  <input id="zsbut7" type="button"  value="取消" onclick="$('#focusInfoLayer1').fadeOut('slow');"/>
	          	</div>
    		</div>
        </div>
    </div>
</html>

<!-- 开始时间设置 -->
<div id="dateDialog" title="选择日期范围">
	<div>
		<label for="setStartTime">开始日期</label>
		<input type="text" class="iptnewtit" name="setStartTime" id="setStartTime" value="" />
		<label for="setEndTime">结束日期</label>
		<input type="text" class="iptnewtit" name="setEndTime" id="setEndTime" value="" />
	</div>
</div>
<!-- 开始时间设置 -->

<script type="text/javascript"  src="${ctx}/js/jquery.min.js"></script>
<script src="<%=ctx%>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js" type="text/javascript" ></script>
<script src="<%=ctx%>/js/jquery-ui/jquery.ui.datepicker-zh-CN.js" type="text/javascript" ></script>
<script type="text/javascript">
	$(function () {
		$(document).keyup(function(event){
			  if(event.keyCode ==13){
			    $("#searbut").trigger("click");
			  }
		});
	});

	function delFocus(id) {
	    var flag = window.confirm("是否删除该焦点图！");
	    if(flag) {
	        $.post('${ctx}/business/businessFocus/delete.do', {id : id}, function(data) {
 	        	eval("data = "+data);
     			alert(data.message);
 	            window.location.reload();
	        });
	    }
	}
	
	//编辑
    function editFocusId(focusId) {
    	window.location.href = "modify.do?focusId="+focusId;
    }
	
    function checkFocusDetail(focusId) {
	  	$('#focusInfoLayer').fadeIn("slow");
        $.post("getFocusDetail.do", {focusId : focusId}, function(data) {
        	eval("data = "+data);
            $('#title').html(data.title);	//焦点图标题
            $('#selectorName').html(data.selectorName);		//焦点图选用人
            $('#selectTime').html(new Date(data.selectTime.time).format('yyyy-MM-dd hh:mm'));	//选用日期
            $('#auditorName').html(data.auditorName);		//审批人
            $('#auditTime').html(data.auditTime== null?'':new Date(data.auditTime.time).format('yyyy-MM-dd hh:mm'));	//审批日期
            String.prototype.replaceAll  = function(s1,s2){    
                return this.replace(new RegExp(s1,"gm"),s2);    
            };
            $('#focusScope1').html((data.focusScope).replaceAll(",", " | "));		//选用范围
            $('#visits').html(data.visits);		//浏览量
            $('#picUrl').html('<img src="<%=ctx %>'+data.picUrl+'" style="width:100%;" />');		//焦点图片
            $('#pageUrl').html('<a href="'+data.pageUrl+'" target="_blank">'+data.pageUrl+'</a>');		//内容链接
            $('#auditInfo2').html("批注：" +data.auditInfo);	//审批原因 
                        
            //焦点图状态
            if(data.state == 0 ) {
            	$('#showstate').html("已发布");
            	<shiro:hasPermission name="focus_takeoff">
            	$('#ding').html("<input class=\"s-xw-btn1\" title=\" 撤回发布该条焦点图\" type=\"button\" value=\"撤回发布\" onclick=\"cancelFocusPublishState("+data.focusId+");\"/>");
            	</shiro:hasPermission>
            	$("#auditInfo1").css('display','none'); 
		        $("#hr1").css('display','none'); 
            } else if(data.state == 1 ) {
            	$('#showstate').html("待发布");
            	<shiro:hasPermission name="focus_edit">
            	$('#ding').html("<input class=\"s-xw-btn1\" title=\"编辑焦点图\" type=\"button\" value=\"编辑\" onclick=\"window.location.href='modify.do?focusId="+data.focusId+"' \"/>");
            	</shiro:hasPermission>
            	$("#auditInfo1").css('display','none'); 
		        $("#hr1").css('display','none'); 
            } else if(data.state == 2 ) {
            	$('#showstate').html("待审核");
            	<shiro:hasPermission name="focus_audit">
            	$('#ding').html("<input id=\"qrbut5\" title=\"立即发布该条焦点图\" type=\"submit\" value=\"立即发布\" onclick=\"cnChangeFocusState("+data.focusId+");\"/><input id=\"zsbut5\" title=\"拒绝该条焦点图\" type=\"button\" value=\"拒绝\" onclick=\"jjChangeFocusState("+data.focusId+");\"/>");
            	</shiro:hasPermission>
            	$("#auditInfo1").css('display','none'); 
		        $("#hr1").css('display','none'); 
            } else if(data.state == 3 ) {
            	$('#showstate').html("未通过");
            	<shiro:hasPermission name="focus_edit">
            	$('#ding').html("<input class=\"s-xw-btn1\" title=\"编辑焦点图\" type=\"button\" value=\"编辑\" onclick=\"window.location.href='modify.do?focusId="+data.focusId+"' \"/>");
            	</shiro:hasPermission>
            	$("#auditInfo1").css('display','block'); 
		        $("#hr1").css('display','block'); 
            } 
        });
    }
	
 	// 撤回发布该条焦点图
	function cancelFocusPublishState(focusId) {
		var bool = window.confirm("您确定撤回发布该条焦点图？");
	    if(bool) {
	        $.post("cancelFocusPublishState.do", {id : focusId}, function(data) {
	        	eval("data = "+data);
    			alert(data.message);
	            window.location.reload();
	        });
	    }
	}
 	
	// 立即发布该条焦点图
	function cnChangeFocusState(focusId) {
		var bool = window.confirm("您确定立即发布该条焦点图？");
	    if(bool) {
	        $.post("updateFocusState.do", {id : focusId, auditInfo : ''}, function(data) {
	        	eval("data = "+data);
    			alert(data.message);
	            window.location.reload();
	        });
	    }
	}
	
	// 拒绝该条焦点图
	function jjChangeFocusState(focusId) {
		$('#focusInfoLayer1').fadeIn("slow");
        
        $.post("getFocusDetail.do", {focusId : focusId}, function(data) {
        	eval("data = "+data);
        	$('#title2').html(data.title);	//焦点图标题
            $('#selectorName2').html(data.selectorName);		//焦点图选用人
            $('#selectTime2').html(new Date(data.selectTime.time).format('yyyy-MM-dd hh:mm'));	//选用日期
            String.prototype.replaceAll  = function(s1,s2){    
                return this.replace(new RegExp(s1,"gm"),s2);    
            };
            $('#focusScope2').html((data.focusScope).replaceAll(",", " | "));		//选用范围
        	$('#focusId2').html("<input type=\"hidden\" id=\"focusId\" value='"+data.focusId+"'/>");
            //发布状态
            if(data.state == 0 ) {
            	$('#showstate2').html("已发布");
            } else if(data.state == 1 ) {
            	$('#showstate2').html("未发布");
            } else if(data.state == 2 ) {
            	$('#showstate2').html("待审核");
            }else if(data.state == 3 ) {
            	$('#showstate2').html("未通过");
            }
         });
	}
	
	function updateFocusState() {
		if(($('#auditInfo').val()).trim() == '') {
			alert("请填写拒绝原因!");
		} else {
			var bool = window.confirm("您确定拒绝该条焦点图？");
		    if(bool) {
				$.post('updateFocusState.do', {
		    		id : $('#focusId').val(),
		    		auditInfo : $('#auditInfo').val()
		    		}, 
		    		function(data) {
		    			eval("data = "+data);
		    			alert(data.message);
		            	window.location.reload();
		        }); 
		    } 
		}
    }
	
    Date.prototype.format = function(format)
	{
	    var o =
	    {
	        "M+" : this.getMonth()+1, //month
	        "d+" : this.getDate(),    //day
	        "h+" : this.getHours(),   //hour
	        "m+" : this.getMinutes(), //minute
	        "s+" : this.getSeconds(), //second
	        "q+" : Math.floor((this.getMonth()+3)/3),  //quarter
	        "S" : this.getMilliseconds() //millisecond
	    }
	    if(/(y+)/.test(format))
	    format=format.replace(RegExp.$1,(this.getFullYear()+"").substr(4 - RegExp.$1.length));
	    for(var k in o)
	    if(new RegExp("("+ k +")").test(format))
	    format = format.replace(RegExp.$1,RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
	    return format;
	}
    
	//获取多参数
	function getParams() {
		var params = '';
		var keyWord = $('#searbox').val();
		if(keyWord != '' && keyWord != null) {
			params = {keyWord: keyWord};
		}else{
			params = {
					state: $('#state').val(),
					timeScope: $('#timeScope').val(),
					startTime: $('#startTime').val(),
					endTime: $('#endTime').val(),
					orderBy: $('#orderBy').val()
			};
		}
		return params;
	}
    
    //跳转页面
    function jump(pageNo) {
    	$('.column').html('');
    	$('#loading').css('display', 'block');
    	var params = getParams();
     	if(pageNo != undefined && pageNo != 0) {
    		params.page = pageNo;
    	}else{
    		params.page = 1;
    	}
    	$.ajax({
    		type: 'post',
            url: '<%=path %>/business/businessFocus/getPageList.do',
            dataType: 'json',
            data: params,
            cache: false,
            success: function (data) {
                $("#rowCount").html("共" + data.total + "条");  // 根据查询条件更新总条数
                var rows = data.rows;
                <shiro:hasPermission name="focus_publish">
	                if(params.page == 1) {
	                	var addHtml = ''	                
	                        + '<div class="manbox" style="margin-left:0;">'
	                        + '<a class="nopotr2 s-baoliao-no" onclick="javascript:window.location.href=\'<%=ctx %>/business/businessFocus/add.do\';" style="cursor:pointer; height:326px;">'
	                        + '<div class="relnews"><img src="<%=ctx %>/images/icon/relnews.png" style="width:100%;" /></div>'
	                        + '<span class="tittex">发布焦点图</span>'
	                        + '</a>'
	                        + '</div>';
	                       	$('.column').append(addHtml);
	                }
	            </shiro:hasPermission>
                if(rows.length > 0) {
                	for(var i=0;i<rows.length;i++) {
                    	var row = rows[i];  
                    	var styleStr = '';
                    	<shiro:lacksPermission name="focus_publish">
                    	if(params.page == 1 && i % 3 == 0) {
       	        			styleStr = 'style="margin-left:0;"';
       	        		}
                    	</shiro:lacksPermission>
                    	<shiro:hasPermission name="focus_publish">
                    	if(params.page == 1 && i % 3 == 2) {
                    		styleStr = 'style="margin-left:0;"';
       	        		}
                    	</shiro:hasPermission>
    					if(params.page > 1 && i % 3 == 0) {
       	        			styleStr = 'style="margin-left:0;"';
       	        		}
                    	var state = '';
                    	if(row.state == 0) {
	                		state = '<span class="relsta cgreen">已发布</span>';
			            }else if(row.state == 1) {
			            	state = '<span class="relsta cgray">未发布</span>';
			            }else if(row.state == 2) {
			            	state = '<span class="relsta cyellow">待审核</span>';
			            }else if(row.state == 3) {
			            	state = '<span class="relsta cred">未通过</span>';
			            }else if(row.state == 4) {
			            	state = '<span class="relsta cblue">已通过</span>';
			            }
                    	
                    	var htmlDom = ''
                    	+ '<div class="manbox" '+styleStr+'>'
                    	+ '<a class="nopotr2 s-baoliao-no" href="javascript:;" style="height:326px;"> '
                    	+ '<div class="info"><p style="float:left;">范围：<span style="color: #3EAF0E;">'+row.focusScope+'</span></p> </div>'
                    	+ '<time>'+(row.selectTime != '' ? row.selectTime.substring(0, 16) : '')+'</time>'
                    	+ '<hr class="link">'
                    	+ '<h2 class="s-jdt-title title">'+row.title+'</h2>'
                    	+ '<div class="state">'+state+'<div class="other-r">'
                    	+ '<i class="look"><em>'+row.supports+'</em></i></div></div>'
                    	+ '<img class="s-jdt-img" src="<%=ctx %>'+row.picUrl+'"/>'
                    	+ '<hr class="link">'
                    	+ '<div class="operate">'
                    	<shiro:hasPermission name="focus_view_detail">
                    	+ '<span class="see s-jdt-yfb" title="查看焦点图详情" onclick="checkFocusDetail('+row.focusId+');"></span>'
                    	</shiro:hasPermission>
                    	<shiro:hasPermission name="focus_edit">
                    	+ '<span class="edit" title="编辑焦点图" onclick="editFocusId('+row.focusId+');"></span>'
                    	</shiro:hasPermission>
                    	<shiro:hasPermission name="focus_delete">
                    	+ '<span id="text1" class="del"  title="删除焦点图" onclick="delFocus('+row.focusId+');"></span>'
                    	</shiro:hasPermission>
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
</script>