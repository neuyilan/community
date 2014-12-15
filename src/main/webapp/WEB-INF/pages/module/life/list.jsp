<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <%@include file="/common/meta.jsp"%>
        <script src="<%=ctx%>/js/nevwuye.js" type="text/javascript"></script>
        <link rel="stylesheet" href="<%=ctx%>/js/jquery-ui/themes/base/jquery.ui.all.css">
        <script type="text/javascript">
            function delLife(id) {
                var flag = window.confirm('请确认是否删除生活信息！');
                if(flag) {
                    $.getJSON("${ctx}/business/businessLife/delete.do", {id : id}, function(data) {
                        alert(data.message);
                        location.reload();
                    });
                }
            }

            function toUpdatepage(id) {
                window.location.href = "${ctx}/business/businessLife/modify.do?serviceId="+id;
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
	                
	                	<li id="pulishState_" class="active navlist"><a href="javascript:;"><span>全部信息</span><b class="donbut"><i></i></b></a>
	                    		<input type="hidden" name="pulishState" id="pulishState" value="" />
	                    	<ul class="erjnav">
	                
	                            <li id="pulishState_0"><a href="javascript:;">已发布</a></li>
	                            
	                            <li id="pulishState_1"><a href="javascript:;">待审核</a></li>
	                            
	                            <li id="pulishState_1"><a href="javascript:;">未通过</a></li>
	                        
	                        </ul>
	                    
	                    </li>
	                    
	                    <li id="typeId_" class="navlist"><a href="javascript:;"><span>所有分类</span><b class="donbut"><i></i></b></a>
	                    		<input type="hidden" name="typeId" id="typeId" value="" />
	                    	<ul class="erjnav">
	                
	                            <li id="typeId_1"><a href="javascript:;">已发布</a></li>
	                            
	                            <li id="typeId_2"><a href="javascript:;">待发</a></li>
	                            
	                            <li id="typeId_3"><a href="javascript:;">待发</a></li>
	                            
	                            <li id="typeId_4"><a href="javascript:;">待发</a></li>
	                            
	                            <li id="typeId_5"><a href="javascript:;">待发</a></li>
	                        
	                        </ul>
	                    
	                    </li>
	                    
	                    
	                    
	                    <li id="timeScope_" class="navlist"><a href="javascript:;"><span>所有时间范围</span><b class="donbut"><i></i></b></a>
	                    		<input type="hidden" name="timeScope" id="timeScope" value="" />
	                    		<input type="hidden" name="startTime" id="startTime" value="" />
	                    		<input type="hidden" name="endTime" id="endTime" value="" />
	                    	<ul class="erjnav">
	                
	                            <li id="timeScope_7"><a href="javascript:;">7天</a></li>
	                            
	                            <li id="timeScope_30"><a href="javascript:;">30天</a></li>
	                            
	                            <li id="timeScope_90"><a href="javascript:;">90天</a></li>
	                            
	                            <li id="timeScope_365"><a href="javascript:;">365天</a></li>
	                            
	                            <li id="timeScope_scope"><a href="javascript:;">选择时间范围</a></li>
	                        
	                        </ul>
	                    
	                    </li>
	                    
	                    <li id="orderBy_" class="navlist"><a href="javascript:;"><span>排序</span><b class="donbut"><i></i></b></a>
	                    		<input type="hidden" name="orderBy" id="orderBy" value="" />
	                    	<ul class="erjnav">
	                            <li id="orderBy_publishTime"><a href="javascript:;">最新发布求助</a></li>
	                            <li id="orderBy_visits"><a href="javascript:;">浏览量高到低</a></li>
	                        </ul>
	                    
	                    </li>
	                    
	                    
	                
	                </ul>
	                 <p id="rowCount"  style="float:left; line-height:52px; color:#cc2510; font-weight:bold; margin-left:20px;">共${pager.rowCount }条</p>
	            </div>
	        
	        	<div id="search"><div class="borbox"><input id="searbox" type="text" name="keyWord" value="" /><input id="searbut" type="button" onclick="search()" value="" /></div></div>
	        
	        </div>
	        
	        <div class="column">
	        	
	        	<div class="manbox" style="margin-left:0;">
            
	            	<a class="nopotr" href="javascript:;" style="cursor:pointer;">
	            
	                    <div class="relnews"><img src="${ctx}/images/icon/relnews.png" style="width:100%;" onclick="window.location.href='${ctx}/business/businessLife/add.do'" /></div>
	                
	                	<span class="tittex" onclick="window.location.href='${ctx}/business/businessLife/add.do'">发布位置信息</span>
	                
	                </a>
	                
	            </div>
            	
	            <c:forEach items="${baseBean.list }" var="life" varStatus="key">
	        		<div class="manbox" <c:if test="${key.index % 3 == 2}" >style="margin-left:0;"</c:if> >
            
		            	<a class="nopotr" href="javascript:;">
		            
		                    <div class="y-shq-info">类型：<span>${life.typeName}</span></div>
		                    
		                    <time><fmt:formatDate value="${life.publishTime }" pattern="yyyy-MM-dd HH:mm"/></time>
		                    
		                    <hr class="link">
		                    
		                    <h2 class="y-shq-title title">${life.serviceName }</h2>
		                    
		                    <div class="state"><span class="relsta">

							<c:choose>
								       <c:when test="${life.pulishState == 0}">
								              	已发布
								       </c:when>
								       <c:when test="${life.pulishState == 1}">
								              	待审核
								       </c:when>
								       <c:when test="${life.pulishState == 2}">
								              	未通过
								       </c:when>
								</c:choose>
							
							</span><div class="other-r"><i class="look">${life.visits }</i></div></div>
		                
		                    <p class="y-shq-dzinfor">
		                    <span>地址：${life.content }</span>
		                    <span>覆盖小区：${life.estateScope }</span></p>
		                    
		                    <hr class="link">
		                    
		                    <div class="operate"><span class="see y-shq-yfb"></span>
		                    <shiro:hasPermission name="life_edit_life"><span class="edit" onclick="toUpdatepage('${life.serviceId}');"></span></shiro:hasPermission>
		                    <shiro:hasPermission name="life_delete_life"><span id="text1" class="del  y-shq-sck" onclick="delLife('${life.serviceId }');"></span></shiro:hasPermission>
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
    
	$(document).ready(function() {
		
		//日期选择表单
		$( "#dateDialog").dialog({
			autoOpen: false,
			height: 300,
			width: 500,
			modal: true,
			buttons: {
				"确定": function() {
						if($('#setStartTime').val() == '' || $('#setEndTime').val() == '') {
							alert('您必须选择开始和结束日期');return;
						}else{
							$('#startTime').val($('#setStartTime').val());
							$('#endTime').val($('#setEndTime').val());
							$( this ).dialog( "close" );
							//查询
							jump(0);
						}
				},
				"取消": function() {
					$('#startTime').val('');
					$('#endTime').val('');
					$( this ).dialog( "close" );
				}
			},
			close: function() {
			}
		});
		
		$( "#setStartTime" ).datepicker({
			defaultDate: "+1w",
			autoSize: true,
			changeMonth: true,
			changeYear: true,
			numberOfMonths: 1,
			onClose: function( selectedDate ) {
				$( "#setEndTime" ).datepicker( "option", "minDate", selectedDate );
			}
		},
		$.datepicker.regional['zh-CN']);
		
		$( "#setEndTime" ).datepicker({
			defaultDate: "+1w",
			autoSize: true,
			changeMonth: true,
			changeYear: true,
			numberOfMonths: 1,
			onClose: function( selectedDate ) {
				$( "#setStartTime" ).datepicker( "option", "maxDate", selectedDate );
			}
		},
		$.datepicker.regional['zh-CN']);
		
		//alert('adf');
		//alert($('#oneul').find('ul>li').length);
		$('#oneul').find('ul>li').each(function(index, obj) {
			//bindClick($(obj).attr('id'));
			bindClick($(obj));	
		});
	});
	
	function bindClick(obj) {
		$(obj).click(function() {
			//alert($(obj).attr('id'));
			var idStr = $(obj).attr('id');
			var arr = idStr.split('_');
			var field = idStr.substring(0, (idStr.indexOf('_')));
			//alert('field  '+field);
			var idKey = idStr.substring(idStr.indexOf('_')+1);
			//alert('idKey  '+idKey);
			//if(idKey != '') {//选中一项
				//判断是字段还是时间范围,如果是字段直接赋值，并显示展示选中项，如果是时间范围则要弹出时间段选择框并赋值开始结束时间,最后提交参数到后台查询数据
				if(idKey != 'scope') {
					//直接赋值并显示展示
					$('#'+field).val(idKey);
					var text = $(obj).parent().parent().find('span').text();
					//alert('text   '+text);
					var li_id = $(obj).parent().parent().attr('id');
					//alert('li_id    '+li_id);
					$(obj).parent().parent().find('span').text($(obj).first().text());
					$(obj).parent().parent().attr('id', $(obj).attr('id'));
					var newLi = '<li id="'+li_id+'"><a href="javascript:;">'+text+'</a></li>';
					$(obj).parent().append(newLi);
					$(obj).remove();
					bindClick($(newLi));
					//执行搜索
					jump(0);
				}else{
					//弹出时间范围选择框
					$( "#dateDialog" ).dialog( "open" );
				}
				
			//}
		});
	}

	function search() {
		jump(0);
	}
	
	//切换页号样式
	function setCurrPageNo(pageNo) {
		if($('#curr').first().text() != pageNo) {
			$('#curr').attr('id', 'old');
			$('#page_'+pageNo).parent().attr('id', 'curr');
		}
	}
	
	//获取多参数
	function getParams() {
		var params = '';
		var keyWord = $('#searbox').val();
		if(keyWord != '' && keyWord != null) {
			params = {keyWord: keyWord};
		}else{
			params = {
					pulishState: $('#pulishState').val(),
					typeId: $('#typeId').val(),
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
    	if(pageNo != 0) {
    		params.page = pageNo;
    	}
    	$.ajax({
    		type: 'post',
            url: '<%=path %>/business/businessLife/getPageList.do',
            dataType: 'json',
            data: params,
            cache: false,
            success: function (data) {
            	$("#rowCount").html("共" + data.total + "条");  // 根据查询条件更新总条数
                var rows = data.rows;
                if(params.page == 1) {
                	var addHtml = ''
	                + '<div class="manbox" style="margin-left:0;">'
	                + '<a class="nopotr2" href="javascript:window.location.href=\'<%=ctx %>/business/businessLife/add.do\';" style="cursor:pointer;">'
	                + '<div class="relnews"><img src="<%=ctx %>/images/icon/relnews.png" style="width:100%;" /></div> '
	                + '<span class="tittex">发布位置信息</span>'              
	                + '</a>'
	                + '</div>';
                	$('.column').append(addHtml);
                }
                if(rows.length > 0) {
                	var length = 0;
                	if(params.page == 1) {
                		if(rows.length > 5) {length = rows.length - 1;}else{
                			length = rows.length;
                		}
                	}else{
                		length = rows.length;
                	}
                	for(var i=0;i<length;i++) {
                    	var row = rows[i];  
                    	var styleStr = '';
                    	if(params.page == 1 && i % 3 == 2) {
                    		styleStr = 'style="margin-left:0;"';
       	        		}else if(params.page > 1 && i % 3 == 0) {
       	        			styleStr = 'style="margin-left:0;"';
       	        		}
                    	var pulishState = '';
                    	if(row.pulishState == 0) {
                    		pulishState = '已发布';
    		            }else if(row.pulishState == 1) {
    		            	pulishState = '待审核';
    		            }else{
    		            	pulishState = '未通过';
    		            }
                    	var htmlDom = ''
                  		+ '<div class="manbox"'
        	        	+ styleStr
        	        	+ '>'
                    	+ '<a class="nopotr2" href="javascript:;">  '                 
                    	+ '<div class="y-shq-info">类型：<span>'+row.typeName+'</span></div>'
                    	+ '<time>'+(row.publishTime != '' ? row.publishTime.substring(0, 16) : '')+'</time>'
                    	+ '<hr class="link">'
                    	+ '<h2 class="y-shq-title title">'+row.serviceName+'</h2>'
                    	+ '<div class="state"><span class="relsta">'+row.pulishState+'</span><div class="other-r"><i class="look">'+row.visits+'</i></div></div>'
                    	+ '<p class="y-shq-dzinfor">'
                    	+ '<span>地址：'+row.content+'</span>'
                    	+ '<span>覆盖小区：'+row.estateScope+'</span></p>'
                    	+ '<hr class="link">'
                    	+ '<div class="operate"><span class="see y-shq-yfb"></span>'
                    	<shiro:hasPermission name="life_edit_life">
                    	+ '<span class="edit"></span>'
                    	</shiro:hasPermission>
                    	<shiro:hasPermission name="life_delete_life">
                    	+ '<span id="text1" class="del  y-shq-sck"></span>'
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
                var boolnext = 'javascript:next();';
                //if((data.pageId)>=(data.pageCount)) { boolnext='#'; }else { boolnext='javascript:next();'; }
                var boolprev = 'javascript:prev();';
                //if((data.pageId)<=1) { boolprev='#'; }else { boolprev='javascript:prev();';  }
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
    
    function showList() {
    	
    }
    
  //上一页
    function prev() {
    	var currNo = $('#curr').first().text();
    	var prevNo = parseInt(currNo) - 1;
    	if(prevNo <= 0) {
    		prevNo = 1;
    	}
    	jump(prevNo);
    }
    
    //下一页
    function next() {
    	var currNo = $('#curr').first().text();
    	var nextNo = parseInt(currNo) + 1;
    	if(nextNo > ${pager.pageCount}) {
    		nextNo = ${pager.pageCount};
    	}
    	jump(nextNo);
    }
    
</script>