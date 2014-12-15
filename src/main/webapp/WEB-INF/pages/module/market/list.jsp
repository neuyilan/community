<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>跳蚤市场管理</title>
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
	                	<li id="dealState_" class="active navlist"><a href="javascript:;"><span>全部信息</span><b class="donbut"><i></i></b></a>
	                    	<input type="hidden" name="dealState" id="dealState" value="${dealState }" />
	                    	<ul class="erjnav">
	                            <li id="dealState_0"><a href="javascript:;">发布中</a></li>
	                            <li id="dealState_1"><a href="javascript:;">待审核</a></li>
	                            <li id="dealState_2"><a href="javascript:;">未通过</a></li>
	                            <li id="dealState_3"><a href="javascript:;">已关闭</a></li>
	                            <li id="dealState_4"><a href="javascript:;">审核删除</a></li>
	                            <li id="dealState_5"><a href="javascript:;">居民删除</a></li>
	                        </ul>
	                    </li>
	                    
	                    <li id="dealType_" class="navlist"><a href="javascript:;"><span>所有分类</span><b class="donbut"><i></i></b></a>
	                    	<input type="hidden" name="dealType" id="dealType" value="" />
	                    	<input type="hidden" name="typeId" id="typeId" value="" />
	                    	<ul class="erjnav">
	                            <li id="typeId_1"><a href="javascript:;">手机数码</a></li>
	                            <li id="typeId_2"><a href="javascript:;">生活用品</a></li>
	                            <li id="typeId_3"><a href="javascript:;">母婴玩具</a></li>
	                            <li id="typeId_4"><a href="javascript:;">服饰丽人</a></li>
	                            <li id="typeId_5"><a href="javascript:;">闲置家居</a></li>
	                            <li id="typeId_6"><a href="javascript:;">文体休闲</a></li>
	                            <li id="typeId_7"><a href="javascript:;">家电</a></li>
	                            <li id="typeId_8"><a href="javascript:;">贵重收藏</a></li>
	                            <li id="typeId_9"><a href="javascript:;">其他二手</a></li>
	                            <li id="dealType_1"><a href="javascript:;">求购</a></li>
	                            <!-- <li id="dealType_2"><a href="javascript:;">交换</a></li> -->
	                        </ul>
	                    </li>
	                    
	                    <li id="timeScope_" class="navlist"><a href="javascript:;"><span>所有时间范围</span><b class="donbut"><i></i></b></a>
	                    		<input type="hidden" name="timeScope" id="timeScope" value="" />
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
	                    
	                    <li id="orderBy_" class="navlist"><a href="javascript:;"><span>最新时间排序</span><b class="donbut"><i></i></b></a>
	                    	<input type="hidden" name="orderBy" id="orderBy" value="" />
	                    	<ul class="erjnav">
	                            <li id="orderBy_comments"><a href="javascript:;">评论量高到低</a></li>
	                            <li id="orderBy_supports"><a href="javascript:;">点赞量高到低</a></li>
	                            <li id="orderBy_visits"><a href="javascript:;">浏览量高到低</a></li>
	                        </ul>
	                    </li>
	                </ul>
	                <p id="rowCount" style="float:left; line-height:52px; color:#cc2510; font-weight:bold; margin-left:20px;">共${pager.rowCount }条</p>
	            </div>
	        	<div id="search"><div class="borbox"><input id="searbox" type="text" name="keyWord" value="" placeholder='标题/内容/发布人搜索' />
	        	<input id="searbut" type="button" onclick="search()" value="" /></div></div>
	        </div>
	        
	        <div class="column">
	        	<shiro:hasPermission name="market_publish">
	        	<div class="manbox" style="margin-left:0;">
	            	<a class="nopotr" href="javascript:window.location.href='<%=ctx %>/business/businessProduct/add.do';" style="cursor:pointer;">
	                    <div class="relnews">
                            <img src="<%=ctx %>/images/icon/relnews.png" style="width:100%;" />
                        </div>
	                	<span class="tittex">发布信息</span>
	                </a>
	            </div>
            	</shiro:hasPermission>
            	
	            <c:forEach items="${baseBean.list }" var="product" varStatus="key">
	        		
	        			<shiro:lacksPermission name="market_publish">
	        			<div class="manbox" <c:if test="${key.index % 3 == 0}" >style="margin-left:0;"</c:if> >
	        			</shiro:lacksPermission>
	        			<shiro:hasPermission name="market_publish">
	        			<div class="manbox" <c:if test="${key.index % 3 == 2}" >style="margin-left:0;"</c:if> >
	        			</shiro:hasPermission> 
	        		
		            	<a class="nopotr" href="javascript:;">
		                    <div class="info">
		                    	<span>类型：
									<c:if test="${product.dealType == 0 }">
										${product.typeName}
									</c:if>
									<c:if test="${product.dealType == 1 }">求购</c:if>
									<%-- <c:if test="${product.dealType == 2 }">交换</c:if> --%>
								</span> 
								<span class="s-xw-sq">来源：${product.estateScope}</span>
							</div>
							<div class="info">
		                    	<span>发布人：${product.realname}<c:if test="${product.publisherName != ''}">【${product.publisherName}】</c:if></span> 
								<span class="s-xw-sq"><time><fmt:formatDate value="${product.publishTime }" pattern="yyyy-MM-dd HH:mm"/></time></span>
							</div>
		                    <hr class="link">
		                    <h2 class="y-shq-title title">${product.title }</h2>
		                    <div class="state">
								<c:choose>
								       <c:when test="${product.dealState == 0}">
								              	<span class="relsta cgreen">发布中</span>
								       </c:when>
								       <c:when test="${product.dealState == 1}">
								              	<span class="relsta cyellow">待审核</span>
								       </c:when>
								       <c:when test="${product.dealState == 2}">
								              	<span class="relsta cred">未通过</span>
								       </c:when>
								       <c:when test="${product.dealState ==3}">
								              	<span class="relsta cgray">已关闭</span>
								       </c:when>
								       <c:when test="${product.dealState ==4}">
								              	<span class="relsta cyellow">审核删除</span>
								       </c:when>
								       <c:when test="${product.dealState ==5}">
								              	<span class="relsta cyellow">居民删除</span>
								       </c:when>
								</c:choose>		
							<div class="other-r">
								<c:choose>
								      <c:when test="${product.dealState == 0 && product.comments!=0}"> 
								      <i class="revlight" title="评论量" style="cursor:pointer;" onclick="window.location.href='getProductCommentList.do?productId=${product.productId}' ">${product.comments }</i>
								     </c:when>
								       <c:otherwise>
								              <i class="rev" title="评论量">${product.comments }</i>
								       </c:otherwise>
								</c:choose>
								<i class="look" title="浏览量">${product.visits }</i>
								<i class="help" title="点赞量">${product.supports }</i>
							</div>
							</div>
							
							<div class="y-hdgl-dzinfor" style="${product.dealType != 2?'height:25px; ':'height:0px; ' }line-height:25px; margin-bottom:0;">
								<c:if test="${product.dealType != 2 }">
			                    	<span  style="color: #cc2510;"><c:if test="${product.dealType == 0}">售价 </c:if><c:if test="${product.dealType ==1}">求购价 </c:if>：￥<fmt:formatNumber type='number' value='${product.price}'  maxFractionDigits="0"></fmt:formatNumber><c:if test="${product.dealType == 1 }">&nbsp;以下</c:if></span>
			                    </c:if>
		                    </div>
		                    
		                    <div class="y-hdgl-dzinfor" style="${product.dealType != 2?'height:50px;':'height:75px;' } line-height:25px;margin-bottom:0;"><span>${product.content }</span></div>
		                   <hr class="link y-qz-hr" style=" margin:10px auto 20px;">
		                    <shiro:hasPermission name="market_view_detail">
							<div class="operate operate2 blop" style="margin:0;" >
								<span id="redCircle_${product.productId}" style="position:relative; height:30px;"  class="see s-xw-yfb" title="查看跳蚤详情" onclick="checkProductDetail('${product.productId}', '${product.newsCount}');">
									<c:if test="${product.newsCount > 0 }"><img style="position: absolute; right: 0px; top:7px;" src="<%=ctx %>/images/redCircle.png" /></c:if>
								</span>
		                    </div>
		                    </shiro:hasPermission>
		                    <c:if test="${product.isEstateAgent == 0}">
		                    	<span class="gore goreblock"><img src="<%=ctx %>/images/icon/gore.png" width="31" height="31" /><i>驿</i></span>
		                	</c:if>
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
	                	<%-- <c:forEach var="${pager.pageCount }" >
	                		<li><a <c:if test="${pageNo == 1}"> id="curr" </c:if> href="javascript:jump(${pageNo });"><span id="page_${pageNo }">${pageNo }</span></a></li>
	                	</c:forEach> --%>
	                	<c:forEach var="pageNo" begin="1" end="${pager.pageCount }" step="1">
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
    </div>
    
    <div id="productInfoLayer" class="busswi5 s-xw-bu">
        <div id="productInfoBar" class="sidebar5 s-xw-si">
            <a id="close5" title="关闭" class="s-xw-cl" href="javascript:;" onclick="$('#productInfoLayer').fadeOut('slow');"></a>
            <h2 class="tit5">跳蚤信息<em>【<span id="showDealState"></span>】</em></h2>
            <div id="wrapper-250">
                <ul class="accordion5">
                    <li id="one5" class="files"><a href="#one"><lable id="title" style="color: #333;"></lable></a></li>
                    <div class="link5"></div>
                    <ul class="sub-menu5 s-xw-xx">
		                <li><span class="xxl">类型：<lable id="dealType1"></lable></span><span class="xxr">来源：<lable id="estateScope"></lable></span></li>
		                <li><span class="xxl">发布人：<lable id="publisherName"></lable></span><span class="xxr">发布时间：<lable id="publishTime"></lable></span></li>
		                <li><span class="xxl">审核人：<lable id="auditorName"></lable></span><span class="xxr">审核时间：<lable id="auditTime"></lable></span></li>
		                <li id="isShow"><span class="xxl"><lable id="price" style="color: #cc2510;"></lable></span><span class="xxr"><lable id="isEstateAgent" style="color: #cc2510;"></lable></span></li>
		                 <div class="s-xw-ic"><i class="rev"><lable id="comments"></lable></i><i class="look"><lable id="visits"></lable></i><i id="block6" class="help"><lable id="supports"></lable></i></div>
		                <div class="link5"></div>
		                <li id="remarks1" style="color: #cc2510; margin:17px 0 10px 0; display:none;"><lable id="remarks2"></lable></li>
		                <div id="hr1" class="link5" style="display:none;"></div>
		                <li>
		                	<div class="s-xw-con">
		                		<lable id="picture"></lable><br>
		                		<lable id="content"></lable><br><br>
		                		<span >联系人：<lable id="contactName"></lable></span>
		                		<span>电   话：<lable id="contactTel"></lable></span>
		                		<!-- <span>其   它：<lable id="contactQQ"></lable></span> -->
		                		<span>地   址：<lable id="estateScope1"></lable></span>
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
    
    <div id="productInfoLayer1" class="busswi5 s-xw-bu">
        <div id="productInfoBar1" class="sidebar5 s-xw-si">
            <a id="close5" title="关闭" class="s-xw-cl" href="javascript:;" onclick="$('#productInfoLayer1').fadeOut('slow');"></a>
            <h2 class="tit5">跳蚤信息<em>【<span id="showDealState2"></span>】</em></h2>
            <div id="wrapper-250">
                <ul class="accordion5">
                    <li id="one5" class="files"><a href="#one"><lable id="title2" style="color: #333;"></lable></a></li>
                    <div class="link5"></div>
                    <ul class="sub-menu5 s-xw-xx">
		                <li><span class="xxl">类型：<lable id="dealType2"></lable></span><span class="xxr">来源：<lable id="estateScope2"></lable></span></li>
		                <li><span class="xxl">发布人：<lable id="publisherName2"></lable></span><span class="xxr">发布时间：<lable id="publishTime2"></lable></span></li>
		                <li id="isShow1"><span class="xxl"><lable id="price2" style="color: #cc2510;"></lable></span><span class="xxr"><lable id="isEstateAgent2" style="color: #cc2510;"></lable></span></li>
		                <div class="link5"></div>
		                <li><div class="s-xw-con"><lable id="productId2"></lable><textarea class="iptnewtit" id="auditInfo" name="auditInfo" style="width:435px;height:200px; font-size:14px; padding-top:5px; padding-left:5px;" placeholder="请输入拒绝原因，发送至提交人" ></textarea></div></li>
	              	</ul>
                </ul>
            </div>
            <div class="s-xw-zd">
	      		<div class="link6"></div>
	          	<div class="submtpres">
	                  <input id="qrbut7" type="button"  value="确定" onclick="updateProductState()"/>
	                  <input id="zsbut7" type="button"  value="取消" onclick="$('#productInfoLayer1').fadeOut('slow');"/>
	          	</div>
    		</div>
        </div>
    </div>
    
    <div id="productInfoLayer3" class="busswi5 s-xw-bu">
        <div id="productInfoBar3" class="sidebar5 s-xw-si">
            <a id="close5" title="关闭" class="s-xw-cl" href="javascript:;" onclick="$('#productInfoLayer3').fadeOut('slow');"></a>
            <h2 class="tit5">跳蚤信息<em>【<span id="showDealState3"></span>】</em></h2>
            <div id="wrapper-250">
                <ul class="accordion5">
                    <li id="one5" class="files"><a href="#one"><lable id="title3" style="color: #333;"></lable></a></li>
                    <div class="link5"></div>
                    <ul class="sub-menu5 s-xw-xx">
		                <li><span class="xxl">类型：<lable id="dealType3"></lable></span><span class="xxr">来源：<lable id="estateScope3"></lable></span></li>
		                <li><span class="xxl">发布人：<lable id="publisherName3"></lable></span><span class="xxr">发布时间：<lable id="publishTime3"></lable></span></li>
		                <li id="isShow3"><span class="xxl"><lable id="price3" style="color: #cc2510;"></lable></span><span class="xxr"><lable id="isEstateAgent3" style="color: #cc2510;"></lable></span></li>
		                <div class="link5"></div>
		                <li><div class="s-xw-con"><lable id="productId3"></lable><textarea class="iptnewtit" id="auditInfo3" name="auditInfo" style="width:435px;height:200px; font-size:14px; padding-top:5px; padding-left:5px;" placeholder="请输入删除原因，发送至提交人" ></textarea></div></li>
	              	</ul>
                </ul>
            </div>
            <div class="s-xw-zd">
	      		<div class="link6"></div>
	          	<div class="submtpres">
	                  <input id="qrbut7" type="button"  value="确定" onclick="delProductState()"/>
	                  <input id="zsbut7" type="button"  value="取消" onclick="$('#productInfoLayer3').fadeOut('slow');"/>
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

	//初始化判断是否首页跳转过来的链接并更改默认搜索条件
	$(function(){  
		if($('#dealState').val() != undefined && $('#dealState').val() != '') {
			var objId = 'dealState_'+$('#dealState').val();
			bindChange($('#'+objId));
		}
	}); 
	// 关闭该条信息
	function saleChangeProductState(productId,publisherId) {
		var bool = window.confirm("您确定关闭该条信息？");
	    if(bool) {
	        $.post("saleChangeProductState.do", {id : productId,publisherId:publisherId}, function(data) {
	        	 var data = eval('(' + data + ')');  // 改变json对象为javascript对象
                 alert(data.message);
	             window.location.reload();
	        });
	    }
	}
	
	// 立即发布该条信息
	function cnChangeProductState(productId,publisherId) {
		var bool = window.confirm("您确定立即发布该条信息？");
	    if(bool) {
	        $.post("updateProductState.do", {id : productId, auditInfo : '',publisherId:publisherId}, function(data) {
	        	 var data = eval('(' + data + ')');  // 改变json对象为javascript对象
                 alert(data.message);
	            window.location.reload();
	        });
	    }
	}
	
	// 拒绝该条信息
	function jjChangeProductState(productId) {
		$('#productInfoLayer1').fadeIn("slow");
	  	$("#productInfoLayer1").css("height",$(document.body).outerHeight(true)+'px');
	    $("#productInfoBar1").css("height",$(document.body).outerHeight(true)-40+'px');
	    
	    $.post("getProductDetail.do", {productId : productId}, function(data) {
	    		eval("data = "+data);
	    	    $('#title2').html(data.title);	//标题
		        //交易类型 0:出售 1:求购 2:交换
		        if(data.dealType == 0 ) {
		        	$('#dealType2').html(data.typeName);
		        } else if(data.dealType == 1 ) {
		        	$('#dealType2').html("求购");
		         }else if(data.dealType == 2 ) {
		        	$('#dealType2').html("交换");
		        }
		        $('#estateScope2').html(data.estateScope);	//来源
		        $('#publisherName2').html(data.publisherName);	//发布人
		        $('#publishTime2').html(new Date(data.publishTime.time).format('yyyy-MM-dd hh:mm'));	//发布日期
		        //$('#price2').html(data.price);	//售价
		        //$('#isEstateAgent2').html(data.isEstateAgent== '0'?'是':'否');	//驿站委托
		    	$('#productId2').html("<input type=\"hidden\" id=\"productId\" value='"+data.productId+"'/> <input type=\"hidden\" id=\"publisherId\" value='"+data.publisherId+"'/>");
		    	if(data.dealType == 0) {
		        	$("#isShow1").css('display','block'); 
		        	$('#price2').html("售价：￥" +data.price);	//售价
		        	//$('#isEstateAgent2').html("驿站委托：" + (data.isEstateAgent == 0?'是':'否'));	//驿站委托
		        } else  if(data.dealType == 1) {
		        	$("#isShow1").css('display','block'); 
		        	$('#price2').html("求购价：￥" +data.price + "&nbsp;以下");	//求购价
		        	$('#isEstateAgent2').html("");		
		        } else  if(data.dealType == 2) {		//交换
		        	$("#isShow1").css('display','none'); 
		        	$('#price2').html("");		
		        	$('#isEstateAgent2').html("");		
		        } 
		        //发布状态
		        if(data.dealState == 0 ) {
		        	$('#showDealState2').html("发布中");
		        } else if(data.dealState == 1 ) {
		        	$('#showDealState2').html("待审核");
		        }else if(data.dealState == 2 ) {
		        	$('#showDealState2').html("未通过");
		        }else if(data.dealState == 3 ) {
		        	$('#showDealState2').html("已关闭");
		        }else if(data.dealState == 4 ) {
		        	$('#showDealState2').html("审核删除");
		        }else if(data.dealState == 5 ) {
		        	$('#showDealState2').html("居民删除");
		        }
	     });
	}
	
	// 删除该条信息
	function scChangeProductState(productId) {
		$('#productInfoLayer3').fadeIn("slow");
	  	$("#productInfoLayer3").css("height",$(document.body).outerHeight(true)+'px');
	    $("#productInfoBar3").css("height",$(document.body).outerHeight(true)-40+'px');
	    
	    $.post("getProductDetail.do", {productId : productId}, function(data) {
	    		eval("data = "+data);
	    	    $('#title3').html(data.title);	//标题
		        //交易类型 0:出售 1:求购 2:交换
		        if(data.dealType == 0 ) {
		        	$('#dealType3').html(data.typeName);
		        } else if(data.dealType == 1 ) {
		        	$('#dealType3').html("求购");
		         }else if(data.dealType == 2 ) {
		        	$('#dealType3').html("交换");
		        }
		        $('#estateScope3').html(data.estateScope);	//来源
		        $('#publisherName3').html(data.publisherName);	//发布人
		        $('#publishTime3').html(new Date(data.publishTime.time).format('yyyy-MM-dd hh:mm'));	//发布日期
		        //$('#price3').html(data.price);	//售价
		        //$('#isEstateAgent3').html(data.isEstateAgent== '0'?'是':'否');	//驿站委托
		    	$('#productId3').html("<input type=\"hidden\" id=\"productId\" value='"+data.productId+"'/> <input type=\"hidden\" id=\"publisherId\" value='"+data.publisherId+"'/>");
		    	if(data.dealType == 0) {
		        	$("#isShow1").css('display','block'); 
		        	$('#price3').html("售价：￥" +data.price);	//售价
		        	//$('#isEstateAgent3').html("驿站委托：" + (data.isEstateAgent == 0?'是':'否'));	//驿站委托
		        } else  if(data.dealType == 1) {
		        	$("#isShow1").css('display','block'); 
		        	$('#price3').html("求购价：￥" +data.price + "&nbsp;以下");	//求购价
		        	$('#isEstateAgent3').html("");		
		        } else  if(data.dealType == 2) {		//交换
		        	$("#isShow3").css('display','none'); 
		        	$('#price3').html("");		
		        	$('#isEstateAgent3').html("");		
		        } 
		        //发布状态
		        if(data.dealState == 0 ) {
		        	$('#showDealState3').html("发布中");
		        } else if(data.dealState == 1 ) {
		        	$('#showDealState3').html("待审核");
		        }else if(data.dealState == 2 ) {
		        	$('#showDealState3').html("未通过");
		        }else if(data.dealState == 3 ) {
		        	$('#showDealState3').html("已关闭");
		        }else if(data.dealState == 4 ) {
		        	$('#showDealState3').html("审核删除");
		        }else if(data.dealState == 5 ) {
		        	$('#showDealState3').html("居民删除");
		        }
	     });
	}
	
	function updateProductState() {
		if(($('#auditInfo').val()).trim() == '') {
			alert("请填写拒绝原因!");
		} else {
			var bool = window.confirm("您确定拒绝该条信息？");
		    if(bool) {
				$.post('updateProductState.do', {
		    		id : $('#productId').val(),
		    		auditInfo : $('#auditInfo').val(),
		    		publisherId : $('#publisherId').val()
		    		}, 
		    		function(data) {
		    			 var data = eval('(' + data + ')');  // 改变json对象为javascript对象
                         alert(data.message);
		            	window.location.reload();
		        }); 
		    } 
		}
    }
	
	//更改发布状态--删除
	function delProductState() {
		if(($('#auditInfo3').val()).trim() == '') {
			alert("请填写删除原因!");
		} else {
			var bool = window.confirm("您确定删除该条信息？");
		    if(bool) {
				$.post('delProductState.do', {
		    		id : $('#productId').val(),
		    		auditInfo : $('#auditInfo3').val(),
		    		publisherId : $('#publisherId').val()
		    		}, 
		    		function(data) {
		    			 var data = eval('(' + data + ')');  // 改变json对象为javascript对象
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

	function checkProductDetail(productId, newsCount) {
	  	$('#productInfoLayer').fadeIn("slow");
	  	$("#productInfoLayer").css("height",$(document.body).outerHeight(true)+'px');
	    $("#productInfoBar").css("height",$(document.body).outerHeight(true)-40+'px');
		
	    $.post("getProductDetail.do", {productId : productId, newsCount: newsCount}, function(data) {
	    		eval("data = "+data);
	    	    $('#title').html(data.title);	//标题
		        $('#content').html(data.content);	//内容
		        
		        var picArray= new Array();
		        picArray = data.picUrl.split("#");
		        var pics= '';
		        if(data.picUrl != '') {
		        	 for(var i=0; i<picArray.length; i++){
			        	pics +="<img src='"+data.ip+picArray[i]+"' />";
		        		 $('#picture').html(pics);	//图片显示
		        	} 
		        } else {
		        	$('#picture').html("");	//图片显示
		        }
		        
		        //交易类型 0:出售 1:求购 2:交换
		        if(data.dealType == 0 ) {
		        	$('#dealType1').html(data.typeName);
		        } else if(data.dealType == 1 ) {
		        	$('#dealType1').html("求购");
		         }else if(data.dealType == 2 ) {
		        	$('#dealType1').html("交换");
		        }
		        $('#estateScope').html(data.estateScope);	//来源
		        $('#publisherName').html(data.publisherName);	//发布人
		        $('#publishTime').html(new Date(data.publishTime.time).format('yyyy-MM-dd hh:mm'));	//发布日期
		        $('#auditorName').html(data.auditorName== null || data.auditorName== ''?'':data.auditorName);	//审批人
		        $('#auditTime').html(data.auditTime== null?'':new Date(data.auditTime.time).format('yyyy-MM-dd hh:mm'));	//审批日期
		        $('#comments').html(data.comments);	//评论量
		        $('#visits').html(data.visits);	//浏览量
		        $('#supports').html(data.supports);	//支持量
		        $('#contactName').html(data.contactName);	//联系人
		        $('#contactTel').html(data.contactTel);	//电   话
		        /* $('#contactQQ').html(data.contactQq); */	//QQ
		        $('#estateScope1').html(data.estateScope);	//地址
		        if(data.dealType == 0) {
		        	$("#isShow").css('display','block'); 
		        	$('#price').html("售价：￥" +data.price);	//售价
		        	//$('#isEstateAgent').html("驿站委托：" + (data.isEstateAgent == 0?'是':'否'));	//驿站委托
		        } else  if(data.dealType == 1) {
		        	$("#isShow").css('display','block'); 
		        	$('#price').html("求购价：￥" +data.price + "&nbsp;以下");	//求购价
		        	$('#isEstateAgent').html("");		
		        } else  if(data.dealType == 2) {		//交换
		        	$("#isShow").css('display','none'); 
		        	$('#price').html("");		
		        	$('#isEstateAgent').html("");		
		        } 
		        //发布状态
		        if(data.dealState == 0) {
		        	$('#showDealState').html("发布中");
		        	$('#ding').html("");
		        	<shiro:hasPermission name="market_del">
		        	$('#ding').append("<input id=\"qrbut5\" title=\"删除该条跳蚤\" type=\"button\" value=\"删除\" onclick=\"scChangeProductState("+data.productId+","+data.publisherId+");\"/>");
		        	/* rightStr = '<input id=\"qrbut5\" title=\"立即发布该条跳蚤\" type=\"submit\" value=\"立即发布\" onclick=\"cnChangeProductState("+data.productId+","+data.publisherId+");\"/>'; */
		        	</shiro:hasPermission>
		        	<shiro:hasPermission name="market_refuse">
		        	/* rightStr = '"<input id=\"zsbut5\" title=\"拒绝该条跳蚤\" type=\"button\" value=\"拒绝\" onclick=\"jjChangeProductState("+data.productId+","+data.publisherId+");\"/>"'; */
		        	$('#ding').append("<input id=\"zsbut5\" title=\"拒绝该条跳蚤\" type=\"button\" value=\"拒绝\" onclick=\"jjChangeProductState("+data.productId+","+data.publisherId+");\"/>");
		        	</shiro:hasPermission>
		        	 $("#remarks1").css('display','none'); 
			         $("#hr1").css('display','none'); 
		        } else if(data.dealState == 1 ) {
		        	$('#showDealState').html("待审核");
		        	$('#ding').html("");
		        	<shiro:hasPermission name="market_audit">
		        	$('#ding').append("<input id=\"qrbut5\" title=\"立即发布该条跳蚤\" type=\"button\" value=\"立即发布\" onclick=\"cnChangeProductState("+data.productId+","+data.publisherId+");\"/>");
		        	/* rightStr = '<input id=\"qrbut5\" title=\"立即发布该条跳蚤\" type=\"submit\" value=\"立即发布\" onclick=\"cnChangeProductState("+data.productId+","+data.publisherId+");\"/>'; */
		        	</shiro:hasPermission>
		        	<shiro:hasPermission name="market_refuse">
		        	/* rightStr = '"<input id=\"zsbut5\" title=\"拒绝该条跳蚤\" type=\"button\" value=\"拒绝\" onclick=\"jjChangeProductState("+data.productId+","+data.publisherId+");\"/>"'; */
		        	$('#ding').append("<input id=\"zsbut5\" title=\"拒绝该条跳蚤\" type=\"button\" value=\"拒绝\" onclick=\"jjChangeProductState("+data.productId+","+data.publisherId+");\"/>");
		        	</shiro:hasPermission>
		        	/* $('#ding').html(rightStr); */
		        	$("#remarks1").css('display','none'); 
		        	$("#hr1").css('display','none'); 
		        }else if(data.dealState == 2 ) {
		        	$('#showDealState').html("未通过");
		        	$('#ding').html("");
		        	$("#remarks1").css('display','block'); 
		        	$("#hr1").css('display','block'); 
		        	$('#remarks2').html("批注：" + data.remarks);
		        }else if(data.dealState == 3 ) {
		        	$('#showDealState').html("已关闭");
		        	$('#ding').html("");
		        	$("#remarks1").css('display','block'); 
		        	$("#hr1").css('display','block'); 
		        	$('#remarks2').html("批注：" + data.remarks);
		        }else if(data.dealState == 4 ) {
		        	$('#showDealState').html("审核删除");
		        	$('#ding').html("");
		        	$("#remarks1").css('display','block'); 
		        	$("#hr1").css('display','block'); 
		        	$('#remarks2').html("批注：" + data.remarks);
		        }else if(data.dealState == 5 ) {
		        	$('#showDealState').html("居民删除");
		        	$('#ding').html("");
		        	$('#ding').html("<input class=\"s-xw-btn2\" title=\"居民删除\" type=\"button\" value=\"居民删除\" />");
		        	$("#remarks1").css('display','none'); 
		        	$("#hr1").css('display','none'); 
		        }
		        //取消红点
		        if(newsCount > 0) {
		        	$('#redCircle_'+productId).html('');
		        }		        
	    });
	}

	//获取多参数
	function getParams() {
		var params = '';
		var keyWord = $('#searbox').val();
		if(keyWord != '' && keyWord != null) {
			params = {keyWord: keyWord};
		}else{
			if($('#dealType').val() != "") {
				params = {
						dealState: $('#dealState').val(),
						dealType: $('#dealType').val(),
						timeScope: $('#timeScope').val(),
						startTime: $('#startTime').val(),
						endTime: $('#endTime').val(),
						orderBy: $('#orderBy').val()
				};
				$('#dealType').val("");
			} else if($('#typeId').val() != "") {
				params = {
						dealState: $('#dealState').val(),
						typeId:$('#typeId').val(),
						timeScope: $('#timeScope').val(),
						startTime: $('#startTime').val(),
						endTime: $('#endTime').val(),
						orderBy: $('#orderBy').val()
				};
				$('#typeId').val("");
			} else {
				params = {
						dealState: $('#dealState').val(),
						dealType: $('#dealType').val(),
						typeId:$('#typeId').val(),
						timeScope: $('#timeScope').val(),
						startTime: $('#startTime').val(),
						endTime: $('#endTime').val(),
						orderBy: $('#orderBy').val()
				};
			}
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
            url: '<%=path %>/business/businessProduct/getPageList.do',
            dataType: 'json',
            data: params,
            cache: false,
            success: function (data) {
                var rows = data.rows;
                $("#rowCount").html("共" + data.total + "条");  // 根据查询条件更新总条数
                <shiro:hasPermission name="market_publish">
                if(params.page == 1) {
                	var addHtml = ''
	                + '<div class="manbox" style="margin-left:0;">'
	                + '<a class="nopotr" href="javascript:window.location.href=\'<%=ctx %>/business/businessProduct/add.do\';" style="cursor:pointer;">'
	                + '<div class="relnews"><img src="<%=ctx %>/images/icon/relnews.png" style="width:100%;" /></div> '
	                + '<span class="tittex">发布信息</span>'              
	                + '</a>'
	                + '</div>';
	                
                	$('.column').append(addHtml);
                }
                </shiro:hasPermission>
                if(rows.length > 0) {
                	/* var length = 0;
                	if(params.page == 1) {
                		if(rows.length > 5) {length = rows.length - 1;}else{
                			length = rows.length;
                		}
                	}else{
                		length = rows.length;
                	} */
                	
                	for(var i=0;i<rows.length;i++) {
                    	var row = rows[i];  
                    	var styleStr = '';
                    	<shiro:lacksPermission name="market_publish">
                    	if(params.page == 1 && i % 3 == 0) {
	   	        			styleStr = 'style="margin-left:0;"';
	   	        		}
                    	</shiro:lacksPermission>
                    	<shiro:hasPermission name="market_publish">
                    	if(params.page == 1 && i % 3 == 2) {
	                		styleStr = 'style="margin-left:0;"';
	   	        		}
                    	</shiro:hasPermission>
						if(params.page > 1 && i % 3 == 0) {
       	        			styleStr = 'style="margin-left:0;"';
       	        		}
                    	var dealState = '';
                    	if(row.dealState == 0) {
                    		dealState = '<span class="relsta cgreen">发布中</span>';
    		            }else if(row.dealState == 1) {
    		            	dealState = '<span class="relsta cyellow">待审核</span>';
    		            }else if(row.dealState == 2 ){
    		            	dealState = '<span class="relsta cred">未通过</span>';
    		            }else if(row.dealState == 3 ) {
    		            	dealState = '<span class="relsta cgray">已关闭</span>';
    			        }else if(row.dealState == 4 ) {
    		            	dealState = '<span class="relsta cyellow">审核删除</span>';
    			        }else if(row.dealState == 5 ) {
    		            	dealState = '<span class="relsta cyellow">居民删除</span>';
    			        }
                    	var dealType = '';
                    	if(row.dealType == 0) {
							dealType = row.typeName;
    		            }else if(row.dealType == 1) {
    		            	dealType = '求购';
    		            }/* else{
    		            	dealType = '交换';
    		            } */
                    	
                    	var dt = "";
                    	var dtn = "";
                    	if(row.dealType == 0) {
                    		dt = "售价";
                    		dtn = "";
    		            }else if(row.dealType == 1) {
    		            	dt = "求购价";
    		            	dtn = "&nbsp;以下";
    		            }
                    	var htmlDom = ''
                  		+ '<div class="manbox"'
        	        	+ styleStr
        	        	+ '>'
        	        	+ '<a class="nopotr" href="javascript:;">'
                    	+ '<div class="info"><span>类型：'+dealType+'</span> <span class="s-xw-sq">来源：'+row.estateScope+'</span></div>'
                    	+ '<div class="info"><span>发布人：'+row.realname +(row.publisherName != '' ? '【'+row.publisherName+'】' : '')+'</span> <span class="s-xw-sq"><time>'+(row.publishTime != '' ? row.publishTime.substring(0, 16) : '')+'</time></span></div>'
                    	+ '<hr class="link">'
                    	+ '<h2 class="y-shq-title title">'+row.title+'</h2>'
                    	+ '<div class="state">'+dealState+'<div class="other-r">'
                    	+'<i class="'+((row.dealState ==0 && row.comments!=0)?'revlight':'rev')+'" '
                    	+'title="评论量" style="'+((row.dealState ==0 && row.comments!=0)?'cursor:pointer;':'')+'" '
                    	+'onclick="'+((row.dealState ==0 && row.comments!=0)?'window.location.href=\'getProductCommentList.do?productId='+row.productId+'\' ':'')+'">'+row.comments+'</i>'
                    	+'<i class="look" title="浏览量">'+row.visits+'</i>'
                    	+ '<i class="help" title="点赞量">'+row.supports+'</i></div></div>'
                   		+'<div class="y-hdgl-dzinfor" style="'+((row.dealType !=2)?'height:25px;':'height:0px;')+'line-height:25px; margin-bottom:0;">'
                   		+ ((row.dealType !=2)?'<span  style="color: #cc2510;">'+dt+'：￥'+parseInt(row.price)+dtn+'</span>':'')
                   		+'</div>'
                   		+ '<div class="y-hdgl-dzinfor" style="'+((row.dealType !=2)?'height:50px;':'height:75px;')+'line-height:25px;margin-bottom:0;"><span>'+row.content+'</span></div>'
                   		+'<hr class="link y-qz-hr" style=" margin:10px auto 20px;">'
                   		<shiro:hasPermission name="market_view_detail">
                    	+ '<div class="operate operate2 blop" style="margin:0;"><span id="redCircle_'+row.productId+'" class="see s-xw-yfb" style="position:relative; height:30px;" title="查看跳蚤详情" onclick="checkProductDetail('+row.productId+','+row.newsCount+')">'
                    	+ (row.newsCount>0?'<img style="position: absolute; right: 0px; top:7px;" src="<%=ctx %>/images/redCircle.png" />':'')
                    	+ '</span></div>'
                    	</shiro:hasPermission>
                    	+ (row.isEstateAgent != 0 ? '':'<span class="gore goreblock"><img src="<%=ctx%>/images/icon/gore.png" width="31" height="31" /><i>驿</i></span>')
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