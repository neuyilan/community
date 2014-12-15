<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <%@include file="/common/meta.jsp"%>
        <script src="<%=ctx%>/js/nevwuye.js" type="text/javascript"></script>

        <script type="text/javascript">
	        $(function () {
				$(document).keyup(function(event){
					  if(event.keyCode ==13){
					    $("#searbut").trigger("click");
					  }
				});
			});
        
            function seeChargeAnno(reportId) {
            	$('#annoInfoLayer').fadeIn("slow");
                $.post('<%=ctx %>/business/businessChargeAnno/getChargeDetail.do', {reportId : reportId}, function(data) {
                	eval("data = "+data);
                    var obj = data.obj;
                    var publisherState = obj.publisherState; //发布状态
                    if(publisherState == 0) {
                        $('#publisherState1').text('已发布');
                    } else if(publisherState == 1) {
                        $('#publisherState1').text('待发布');
                    }else if(publisherState == 2) {
                        $('#publisherState1').text('待审核');
                    }else if(publisherState == 3) {
                        $('#publisherState1').text('未通过');
                    }
                    //发布人 publisherName
                    var publisherName = obj.publisherName;
                    $('#publisherName').text(publisherName);
                    //发布时间 publishTime
                    var publishTime = obj.publishTime;
                    $('#publishTime').text(new Date(publishTime).format('yyyy-MM-dd hh:mm'));
                    //审批人  auditorName
                    var auditorName = obj.auditorName;
                    $('#auditorName').text(auditorName);
                    //审批时间  auditTime
                    var auditTime = obj.auditTime;
                    $('#auditTime').text(auditTime== null?'':new Date(auditTime).format('yyyy-MM-dd hh:mm'));
                    //APP通知用户数 users
                    var users = obj.users;
                    $('#users').text("APP通知用户： "+users+" 人");
                    $('#auditInfo2').html("批注：" +obj.auditInfo);	//审批原因
                    
                    var estateName = obj.estateName;
                    $('#estateName').text(estateName);

                    $('#reportName').text(obj.reportName);
                    $('#display').empty();
                    $.each(data.list, function(i, item) {
                        var o = item;
                        var html = '<div class="link5"></div>'
                        +'<li><a href="#">姓名：<i class="jmgl_change">'+o.name+'<strong>'+o.cellphone+'</strong></i></a></li>'
                        +'<li><a href="#">楼栋：<i class="jmgl_change">'+o.building+'号&nbsp;&nbsp;</i></a><a href="#">单元：<i class="jmgl_change">'+(o.unit=='null'? '':o.unit)+'</i></a><a href="#">&nbsp;&nbsp;门牌：<i class="jmgl_change">'+o.house+'</i></a></li>'
                        +'<li><a href="#">通知内容：<br><i class="jmgl_change">'+o.content+'</i></a></li>';
						
                        $('#display').append(html);
                    });
                  //发布状态
    	            if(obj.publisherState == 0 ) {
    	            	$('#publisherState1').html("已发布");
    	            	$('#ding').html("");
    	            	$("#auditInfo1").css('display','none'); 
    			         $("#hr1").css('display','none'); 
    	            } else if(obj.publisherState == 1 ) {
    	            	$('#publisherState1').html("待发布");
    	            	$('#ding').html("<input class=\"s-xw-btn1\" title=\"编辑缴费通知\" type=\"button\" value=\"编辑\" onclick=\"window.location.href='modify.do?reportId="+reportId+"' \"/>");
    	            	$("#auditInfo1").css('display','none'); 
    			         $("#hr1").css('display','none'); 
    	            } else if(obj.publisherState == 2 ) {
    	            	$('#publisherState1').html("待审核");
    	            	$('#ding').html("<input id=\"qrbut5\" title=\"立即发布该条缴费通知\" type=\"submit\" value=\"立即发布\" onclick=\"cnChangeAnnoState("+reportId+");\"/><input id=\"zsbut5\" title=\"拒绝该条缴费通知\" type=\"button\" value=\"拒绝\" onclick=\"changeAnnoState("+reportId+");\"/>");
    	            	$("#auditInfo1").css('display','none'); 
    			        $("#hr1").css('display','none'); 
    	            }else if(obj.publisherState == 3 ) {
    	            	$('#publisherState1').html("未通过");
    	            	$('#ding').html("<input class=\"s-xw-btn1\" title=\"编辑缴费通知\" type=\"button\" value=\"编辑\" onclick=\"window.location.href='modify.do?reportId="+reportId+"' \"/>");
    	            	$("#auditInfo1").css('display','block'); 
    			         $("#hr1").css('display','block'); 
    	            }
                });
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

            function delChargeAnno(reportId) {
                var flag = window.confirm("您确认要删除此缴费通知吗？");
                if(flag) {
                    $.getJSON('${ctx}/business/businessChargeAnno/delete.do', {id :reportId}, function(data) {
                        alert(data.message);
                        location.reload();
                    });
                }
            }
        </script>
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
	                	<li id="publisherState_" class="active navlist"><a href="javascript:;"><span>全部通知</span><b class="donbut"><i></i></b></a>
                    		<input type="hidden" name="publisherState" id="publisherState" value="" />
	                    	<ul class="erjnav">
	                            <li id="publisherState_0"><a href="javascript:;">已发布</a></li>
	                            <li id="publisherState_1"><a href="javascript:;">待发布</a></li>
	                            <li id="publisherState_2"><a href="javascript:;">待审核</a></li>
	                            <li id="publisherState_3"><a href="javascript:;">未通过</a></li>
	                        </ul>
	                    </li>
	                       
	                    <li id="timeScope_" class="navlist"><a href="javascript:;"><span>所有时间范围</span><b class="donbut"><i></i></b></a>
                    		<input type="hidden" name="timeScope" id="timeScope" value="" />
                    		<input type="hidden" name="startTime" id="startTime" value="" />
                    		<input type="hidden" name="endTime" id="endTime" value="" />
	                    	<ul class="erjnav">
	                			<li id="timeScope_0"><a href="javascript:;">当日</a></li>
	                            <li id="timeScope_7"><a href="javascript:;">7天</a></li>
	                            <li id="timeScope_30"><a href="javascript:;">30天</a></li>
	                            <li id="timeScope_90"><a href="javascript:;">90天</a></li>
	                            <li id="timeScope_365"><a href="javascript:;">365天</a></li>
	                            <li id="timeScope_scope"><a href="javascript:;">选择时间范围</a></li>
	                        </ul>
	                    </li>
	                    
	                    <li id="orderBy_" class="navlist" ><a href="javascript:;"><span>最新时间排序</span><b class="donbut"><i></i></b></a>
                    		<input type="hidden" name="orderBy" id="orderBy" value="" />
	                    	<ul class="erjnav">
	                            <li id="orderBy_users"><a href="javascript:;">通知用户高到低</a></li>
	                        </ul>
	                    </li>
	                </ul>
	                <p id="rowCount" style="float:left; line-height:52px; color:#cc2510; font-weight:bold; margin-left:20px;">共${pager.rowCount }条</p>
	            </div>
	        	<div id="search"><div class="borbox"><input id="searbox" type="text" name="keyWord" value="" placeholder='通知名称/发布人搜索' /><input id="searbut" type="button" onclick="search()" value="" /></div></div>
	        </div>
	        
	        <div class="column">
	        	<!-- 添加缴费通知开始 -->
	            <div class="manbox" style="margin-left:0;" id="addChargeBtn">
	            	<a class="nopotr" href="#" style="cursor:pointer;">
	                    <div class="relnews">
                            <img src="<%=ctx %>/images/icon/relnews.png" style="width:100%;" />
                        </div>
	                	<span class="tittex">添加缴费通知</span>
	                </a>
	            </div>
	        	<!-- 添加缴费通知结束 -->
	        	
	            <c:forEach items="${baseBean.list }" var="anno" varStatus="key">
	        		<div class="manbox" <c:if test="${key.index % 3 == 2}" >style="margin-left:0;"</c:if> >
		            	<a class="nopotr" href="javascript:;">
		                    <time><fmt:formatDate value="${anno.publishTime }" pattern="yyyy-MM-dd HH:mm"/></time>
		                    <hr class="link">
		                    <h2 class="yggl_title">${anno.reportName }</h2>
		                    <div class="state">
		                    	<span class="yggl_relsta">
			                    	<c:choose>
									       <c:when test="${anno.publisherState == 0}">
									              	已发布
									       </c:when>
									       <c:when test="${anno.publisherState == 1}">
									              	待发布
									       </c:when>
									       <c:when test="${anno.publisherState == 2}">
									              	待审核
									       </c:when>
									        <c:when test="${anno.publisherState == 3}">
									              	未通过
									       </c:when>
									</c:choose>
		                    	</span>
		                    </div>
		                    <p class="yggl_text">所属小区：<span>${anno.estateName }</span></p>
		                    <p class="yggl_text">实际通知用户：<span>${anno.users }人</span></p>
		                    <hr class="link" style="margin-top:14px;">
                            <div class="operate">
                                <span class="see block10" title="查看缴费通知详情" onclick="seeChargeAnno('${anno.reportId }');"></span>
                                <span class="edit" title="编辑缴费通知" onclick="window.location.href='${ctx}/business/businessChargeAnno/modify.do?reportId=${anno.reportId }'"></span>
                                <span class="del" title="删除缴费通知" onclick="delChargeAnno('${anno.reportId }')"></span>
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
        
        <!-- 通知详情开始 -->
        <div id="annoInfoLayer" class="busswi5 s-xw-bu">
        <div id="annoInfoBar" class="sidebar5 s-xw-si">
            <a id="close5" title="关闭" class="s-xw-cl" href="javascript:;" onclick="$('#annoInfoLayer').fadeOut('slow');"></a>
            <h2 class="tit5">缴费通知<em>【<span id="publisherState1"></span>】</em></h2>
            <div id="wrapper-250">
                <ul class="accordion5">
                    <li id="one5" class="files"><a href="#one"><lable id="reportName" style="color: #333;"></lable></a></li>
                    <div class="link5"></div>
                    <ul class="sub-menu5 s-xw-xx">
		                <li><span class="xxl">所属小区：<lable id="estateName"></lable></span></li>
		                <li><span class="xxl">发布人：<lable id="publisherName"></lable></span><span class="xxr">发布时间：<lable id="publishTime"></lable></span></li>
		                <li><span class="xxl">审核人：<lable id="auditorName"></lable></span><span class="xxr">审核时间：<lable id="auditTime"></lable></span></li>
		                <div class="link5"></div>
		                <li id="auditInfo1" style="color: #cc2510; margin:17px 0 10px 0; display:none;"><lable id="auditInfo2"></lable></li>
		                <div id="hr1" class="link5" style="display:none;"></div>
		                <p class="jfgl_tit"><lable id="users"></lable></p>
		                <lable id="display"></lable>
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
    	<!-- 通知详情结束 -->
    	
    	<!-- 拒绝开始 -->
		<div id="annoInfoLayer1" class="busswi5 s-xw-bu">
	        <div id="annoInfoBar1" class="sidebar5 s-xw-si">
	            <a id="close5" title="关闭" class="s-xw-cl" href="javascript:;" onclick="$('#annoInfoLayer1').fadeOut('slow');"></a>
	            <h2 class="tit5">缴费通知<em>【<span id="publisherState2"></span>】</em></h2>
	            <div id="wrapper-250">
	                <ul class="accordion5">
	                    <li id="one5" class="files"><a href="#one"><lable id="reportName2" style="color: #333;"></lable></a></li>
	                    <div class="link5"></div>
	                    <ul class="sub-menu5 s-xw-xx">
			                <li><span class="xxl">所属小区：<lable id="estateName2"></lable></span></li>
			                <li><span class="xxl">发布人：<lable id="publisherName2"></lable></span><span class="xxr">发布时间：<lable id="publishTime2"></lable></span></li>
			                <div class="link5"></div>
			                <li><div class="s-xw-con"><lable id="reportId2"></lable>
			                <textarea class="iptnewtit" id="auditInfo" name="auditInfo" style="width:435px;height:200px; font-size:14px; padding-top:5px; padding-left:5px;" placeholder="请输入拒绝原因，发送至提交人" ></textarea></div></li>
		              	</ul>
	                </ul>
	            </div>
	            <div class="s-xw-zd">
		      		<div class="link6"></div>
		          	<div class="submtpres">
		                  <input id="qrbut7" type="button"  value="确定" onclick="updateAnnoState()"/>
		                  <input id="zsbut7" type="button"  value="取消" onclick="$('#annoInfoLayer1').fadeOut('slow');"/>
		          	</div>
	    		</div>
	        </div>
	    </div>
		<!-- 拒绝结束 -->
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
<script type="text/javascript"  src="<%=ctx%>/js/jquery.min.js"></script>
<script src="<%=ctx%>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js" type="text/javascript" ></script>
<script src="<%=ctx%>/js/jquery-ui/jquery.ui.datepicker-zh-CN.js" type="text/javascript" ></script>
<script type="text/javascript">
	$(function() {
		$('#addChargeBtn').click(function() {
			if(parseInt('${curEstateId}') == 0) {
				alert("请先切换到小区");return;
			}
			window.location.href = '<%=ctx %>/business/businessChargeAnno/chargeExcel.do';
		});
	});

	//获取多参数
	function getParams() {
		var params = '';
		var keyWord = $('#searbox').val();
		if(keyWord != '' && keyWord != null) {
			params = {keyWord: keyWord};
		}else{
			params = {
					publisherState: $('#publisherState').val(),
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
            url: '<%=path %>/business/businessChargeAnno/getPageList.do',
            dataType: 'json',
            data: params,
            cache: false,
            success: function (data) {
            	$("#rowCount").html("共" + data.total + "条");  // 根据查询条件更新总条数
            	
                var rows = data.rows;
            	
                if(params.page == 1) {
	            	var addHtml = ''
	                + '<div class="manbox" style="margin-left:0;">'
	                + '<a class="nopotr" href="javascript:window.location.href=\'<%=ctx %>/business/businessChargeAnno/chargeExcel.do\';" style="cursor:pointer;">'
	                + '<div class="relnews"><img src="<%=ctx %>/images/icon/relnews.png" style="width:100%;" /></div> '
	                + '<span class="tittex">添加缴费通知</span>'              
	                + '</a>'
	                + '</div>';
	            	$('.column').append(addHtml);
	            }
                
                if(rows.length > 0) {
                	for(var i=0;i<rows.length;i++) {
                    	var row = rows[i];     
                    	var styleStr = '';
                    	if(params.page == 1 && i % 3 == 2) {
                    		styleStr = 'style="margin-left:0;"';
       	        		}else if(params.page > 1 && i % 3 == 0) {
       	        			styleStr = 'style="margin-left:0;"';
       	        		}
                    	var publisherState = '';
                    	if(row.publisherState == 0) {
                    		publisherState = '已发布';
    		            } else if(row.publisherState == 1) {
                    		publisherState = '待发布';
    		            } else if(row.publisherState == 2) {
                    		publisherState = '待审核';
    		            } else  if(row.publisherState == 3) {
    		            	publisherState = '未通过';
    		            }  
                    	var htmlDom = ''                    	
                    	+ '<div class="manbox"'
   	        			+ styleStr
   	        		    +'>'
                        + '<a class="nopotr" href="javascript:;">'
   		                + '<time>'+(row.publishTime != '' ? row.publishTime.substring(0, 16) : '')+'</time>'
   		                + '<hr class="link">'
   		                + '<h2 class="yggl_title">'+row.reportName+'</h2>'
   		                + '<div class="state"><span class="yggl_relsta">'
   		                + publisherState
   		                + '</span></div>'
   		                + '<p class="yggl_text">所属小区：<span>'+row.estateName+'</span></p>'
   		                + '<p class="yggl_text">APP通知用户：<span>'+row.users+'人</span></p>'
   		                + '<hr class="link" style="margin-top:14px;">'
   		                + '<div class="operate">'
   		                + '<span class="see block10" title="查看缴费通知详情" onclick="seeChargeAnno('+row.reportId+');"></span>'
   		             	+ '<span class="edit" title="编辑缴费通知" onclick="window.location.href=\'<%=ctx%>/business/businessChargeAnno/modify.do?reportId='+row.reportId+'\'"></span>'
   		          		+ '<span class="del" title="删除缴费通知" onclick="delChargeAnno('+row.reportId+')"></span>'
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
    
 	// 立即发布该条缴费通知
	function cnChangeAnnoState(reportId) {
		var bool = window.confirm("您确定立即发布该条通知？");
	    if(bool) {
	        $.post("updateAnnoState.do", {id : reportId, auditInfo : ''}, function(data) {
	        	eval("data = "+data);
    			alert(data.message);
	            window.location.reload();
	        });
	    }
	}
    
 	// 拒绝该条缴费通知
	function changeAnnoState(reportId) {
		$('#annoInfoLayer1').fadeIn("slow");
        
        // $.post("<%=ctx%>/business/businessChargeAnno/getChargeDetail.do", {reportId : reportId}, function(data) {
        	//eval("data = "+data);
        $.getJSON('${ctx}/business/businessChargeAnno/getChargeDetail.do', {reportId : reportId}, function(data) {
            var obj = data.obj;
            $('#reportName2').html(obj.reportName);	
            $('#estateName2').html(obj.estateName);	//所属小区
            $('#publisherName2').html(obj.publisherName);	//发布人
            $('#publishTime2').html(new Date(obj.publishTime).format('yyyy-MM-dd hh:mm'));	//发布日期
        	$('#reportId2').html("<input type=\"hidden\" id=\"reportId\" value='"+reportId+"'/>");
            //发布状态
            if(obj.publisherState == 0 ) {
            	$('#publisherState2').html("已发布");
            } else if(obj.publisherState == 1 ) {
            	$('#publisherState2').html("待发布");
            } else if(obj.publisherState == 2 ) {
            	$('#publisherState2').html("待审核");
            }else if(obj.publisherState == 3 ) {
            	$('#publisherState2').html("未通过");
            }
         }); 
	}
    
    //拒绝原因
    function updateAnnoState() {
		if(($('#auditInfo').val()).trim() == '') {
			alert("请填写拒绝原因!");
		} else {
			var bool = window.confirm("您确定拒绝该条通知？");
		    if(bool) {
		    	$.post('updateAnnoState.do', {
		    		id : $('#reportId').val(),
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
</script>