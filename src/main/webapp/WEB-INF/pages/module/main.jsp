<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.community.app.module.common.ModuleConst"%>
<!DOCTYPE html>
<html>
<head>
<title>北青社区后台管理系统</title>
<%@include file="/common/meta.jsp"%>
<link rel="stylesheet"
	href="<%=ctx%>/js/jquery-ui/themes/base/jquery.ui.all.css">
<script src="<%=ctx%>/js/jquery-ui/jquery.ui.core.js"></script>
<script src="<%=ctx%>/js/jquery-ui/jquery.ui.widget.js"></script>
<script src="<%=ctx%>/js/jquery-ui/jquery.ui.mouse.js"></script>
<script src="<%=ctx%>/js/jquery-ui/jquery.ui.draggable.js"></script>
<script src="<%=ctx%>/js/jquery-ui/jquery.ui.position.js"></script>
<script src="<%=ctx%>/js/jquery-ui/jquery.ui.resizable.js"></script>
<script src="<%=ctx%>/js/jquery-ui/jquery.ui.button.js"></script>
<script src="<%=ctx%>/js/jquery-ui/jquery.ui.dialog.js"></script>

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
					<span class="tiele">内部公告</span><span class="divider-vertical"></span>
					<c:if test="${empty annoList }">
						<span class="hot">无最新公告</span>
					</c:if>
					<c:if test="${!empty annoList }">
						<c:forEach items="${annoList }" var="anno">
							<a style="cursor: pointer;"
								onclick='showAnnoContent("${anno.annoId }")'><span
								class="hot">${anno.annoTitle }</span></a>
							<span class="time"><fmt:formatDate
									value="${anno.editTime }" pattern="yyyy-MM-dd HH:mm" /></span>
						</c:forEach>
					</c:if>
				</div>

				<a href="javascript:;" class="leftbut"></a><a href="javascript:;"
					class="rightbut"></a>
			</div>

			<div class="column">
				<%-- <shiro:hasRole name="property"> --%>
				<%-- <c:if test="${orgType == 'property'}"> --%>
					<!-- 物业统计开始 -->
					<shiro:hasPermission name="index_property_verified_resident">
						<div class="column-box">

							<a style="border-bottom: 5px solid #6cc0f3;"
								href="<%=ctx%>/app/appUser/list.do?type=1">

								<h4 class="title-msg">已有验证居民</h4>

								<div class="icon-shop">
									<img src="${ctx}/images/icon/yyyz_zcjm.png" style="width: 100%">
								</div>

								<hr class="link"> <span class="current">${verifiedResidents }<i
									class="other">条</i></span>

							</a>

						</div>
					</shiro:hasPermission>

					<shiro:hasPermission name="index_property_today_registed">
						<div class="column-box">

							<a style="border-bottom: 5px solid #6cc0f3;"
								href="<%=ctx%>/app/appUser/list.do?timeScope=0&dateField=registTime">

								<h4 class="title-msg">当日注册居民</h4>

								<div class="icon-shop">
									<img src="${ctx}/images/icon/yyyz_zcjm.png" style="width: 100%">
								</div>

								<hr class="link"> <span class="current">${propertyRegistedResidentsOnDay }<i
									class="other">条</i></span>

							</a>

						</div>
					</shiro:hasPermission>

					<shiro:hasPermission name="index_property_today_verified">
						<div class="column-box">

							<a style="border-bottom: 5px solid #6cc0f3;"
								href="<%=ctx%>/app/appUser/list.do?type=1&timeScope=0&dateField=verifyTime">

								<h4 class="title-msg">当日验证居民</h4>

								<div class="icon-shop">
									<img src="${ctx}/images/icon/yyyz_zcjm.png" style="width: 100%">
								</div>

								<hr class="link"> <span class="current">${propertyVerifiedResidentsOnDay }<i
									class="other">条</i></span>

							</a>

						</div>
					</shiro:hasPermission>

					<shiro:hasPermission name="index_property_unrepair_handler">
						<div class="column-box">

							<a style="border-bottom: 5px solid #49971d;"
								href="javascript:window.location.href='<%=ctx%>/business/businessRepair/list.do?repairState=0';">

								<h4 class="title-msg">未处理报修</h4>

								<div class="icon-shop">
									<img src="${ctx}/images/icon/wclbx.png" style="width: 100%">
								</div>

								<hr class="link"> <span class="current">${unresolvedRepair }<i
									class="other">条</i></span>

							</a>

						</div>
					</shiro:hasPermission>
					<shiro:hasPermission name="index_property_unreply_feedback">
						<div class="column-box">

							<a style="border-bottom: 5px solid #2c63a9;"
								href="javascript:window.location.href='<%=ctx%>/business/businessFeedback/list.do?fbState=0';">

								<h4 class="title-msg">未回复投诉建议</h4>

								<div class="icon-shop">
									<img src="${ctx}/images/icon/whffk.png" style="width: 100%">
								</div>

								<hr class="link"> <span class="current">${unreplied }<i
									class="other">条</i></span>

							</a>

						</div>
					</shiro:hasPermission>
					<shiro:hasPermission name="index_property_anno_comment">
						<div class="column-box">

							<a style="border-bottom: 5px solid #c68b1d;"
								href="<%=ctx%>/business/businessAnno/list.do?sort=comments&timeScope=0&dateField=comments">

								<h4 class="title-msg">今日新增评论</h4>

								<div class="icon-shop">
									<img src="${ctx}/images/icon/yyggpl.png" style="width: 100%">
								</div>

								<hr class="link"> <span class="current">${propCommentedAnno }<i
									class="other">条</i></span>

							</a>

						</div>
					</shiro:hasPermission>
				<%-- </c:if> --%>
				<!-- 物业统计结束 -->
				<%-- </shiro:hasRole> --%>

				<%-- <shiro:hasRole name="station"> --%>
				<%-- <c:if test="${orgType == 'station'}"> --%>
					<!-- 驿站统计开始 -->
					<shiro:hasPermission name="index_station_anno_comment">
						<div class="column-box">

							<a style="border-bottom: 5px solid #6cc0f3;"
								href="javascript:window.location.href='<%=ctx%>/business/businessAnno/list.do?sort=comments';">

								<h4 class="title-msg">公告评论数量</h4>

								<div class="icon-shop">
									<img src="${ctx}/images/icon/yyggpl.png" style="width: 100%">
								</div>

								<hr class="link"> <span class="current">${stationCommentedAnno }<i
									class="other">条</i></span>

							</a>

						</div>
					</shiro:hasPermission>
					<shiro:hasPermission name="index_station_unsolved_express">
						<div class="column-box">

							<a style="border-bottom: 5px solid #49971d;"
								href="<%=ctx%>/business/businessExp/list.do?expState=0">

								<h4 class="title-msg">未处理快递服务</h4>

								<div class="icon-shop">
									<img src="${ctx}/images/icon/wclkdfw.png" style="width: 100%">
								</div>

								<hr class="link"> <span class="current">${unresolvedExp }<i
									class="other">条</i></span>

							</a>

						</div>
					</shiro:hasPermission>
					<shiro:hasPermission name="index_station_unreply_help">
						<div class="column-box">

							<a style="border-bottom: 5px solid #2c63a9;"
								href="<%=ctx%>/business/businessHelp/list.do?state=0">

								<h4 class="title-msg">未回复求助信息</h4>

								<div class="icon-shop">
									<img src="${ctx}/images/icon/whfqzxx.png" style="width: 100%">
								</div>

								<hr class="link"> <span class="current">${unrepliedHelp}<i
									class="other">条</i></span>

							</a>

						</div>
					</shiro:hasPermission>
					<shiro:hasPermission name="index_station_going_activity">
						<div class="column-box">

							<a style="border-bottom: 5px solid #c68b1d;"
								href="<%=ctx%>/business/businessActivity/list.do?stateStr=0_1">

								<h4 class="title-msg">进行中的活动</h4>

								<div class="icon-shop">
									<img src="${ctx}/images/icon/jxzdhd.png" style="width: 100%">
								</div>

								<hr class="link"> <span class="current">${gointActivity}<i
									class="other">条</i></span>

							</a>

						</div>
					</shiro:hasPermission>
					<shiro:hasPermission name="index_station_unsolved_feedback">
						<div class="column-box">

							<a style="border-bottom: 5px solid #c68b1d;"
								href="<%=ctx%>/business/businessFeedback/list.do?fbState=0">

								<h4 class="title-msg">未处理建议投诉</h4>

								<div class="icon-shop">
									<img src="${ctx}/images/icon/wcljmfk.png" style="width: 100%">
								</div>

								<hr class="link"> <span class="current">${unresolvedFeedback}<i
									class="other">条</i></span>

							</a>

						</div>
					</shiro:hasPermission>

					<!-- 驿站统计结束 -->
				<%-- </c:if> --%>
				<%-- </shiro:hasRole> --%>

				<%-- <shiro:hasRole name="community"> --%>
				<%-- <c:if test="${orgType == 'community'}"> --%>
					<!-- 社区报开始 -->
					<shiro:hasPermission name="index_com_news_comment">
						<div class="column-box">

							<a style="border-bottom: 5px solid #c68b1d;"
								href="<%=ctx%>/business/businessNews/list.do?sort=comments&timeScope=0&dateField=comments">

								<h4 class="title-msg">今日新鲜事评论</h4>

								<div class="icon-shop">
									<img src="${ctx}/images/icon/yyxwpl.png" style="width: 100%">
								</div>

								<hr class="link"> <span class="current">${commentsNews }<i
									class="other">条</i></span>

							</a>

						</div>
					</shiro:hasPermission>
					<shiro:hasPermission name="index_com_unsolved_break">
						<div class="column-box">

							<a style="border-bottom: 5px solid #c68b1d;"
								href="<%=ctx%>/business/businessBreak/list.do?state=0">

								<h4 class="title-msg">未处理网友爆料</h4>

								<div class="icon-shop">
									<img src="${ctx}/images/icon/wclwybl.png" style="width: 100%">
								</div>

								<hr class="link"> <span class="current">${unresolvedBreak }<i
									class="other">条</i></span>

							</a>

						</div>
					</shiro:hasPermission>
					<shiro:hasPermission name="index_com_auding_news">
						<div class="column-box">

							<a style="border-bottom: 5px solid #c68b1d;"
								href="<%=ctx%>/business/businessNews/list.do?state=2">

								<h4 class="title-msg">待审核新鲜事</h4>

								<div class="icon-shop">
									<img src="${ctx}/images/icon/dshxw.png" style="width: 100%">
								</div>

								<hr class="link"> <span class="current">${auditingNews }<i
									class="other">条</i></span>

							</a>

						</div>
					</shiro:hasPermission>
					<%-- <div class="column-box" style="border-bottom:5px solid #c68b1d;">

                    <!-- <a href="javascript:;">
 -->
                        <h4 class="title-msg">待审核位置</h4>

                        <div class="icon-shop"><img src="${ctx}/images/icon/dshwzxx.png" style="width:100%"></div>

                        <hr class="link">

                        <span class="current">${auditingLife }<i class="other">条</i></span>

                   <!--  </a> -->

                </div> --%>

					<shiro:hasPermission name="index_com_goting_activity">
						<div class="column-box">

							<a style="border-bottom: 5px solid #c68b1d;"
								href="<%=ctx%>/business/businessActivity/list.do?stateStr=0_1">

								<h4 class="title-msg">进行中的活动</h4>

								<div class="icon-shop">
									<img src="${ctx}/images/icon/jxzdhd.png" style="width: 100%">
								</div>

								<hr class="link"> <span class="current">${comGoingActivity }<i
									class="other">条</i></span>

							</a>

						</div>
					</shiro:hasPermission>

					<shiro:hasPermission name="index_station_audting_market">
						<div class="column-box">

							<a style="border-bottom: 5px solid #c68b1d;"
								href="<%=ctx%>/business/businessProduct/list.do?dealState=1">

								<h4 class="title-msg">待审核二手信息</h4>

								<div class="icon-shop">
									<img src="${ctx}/images/icon/dshesxx.png" style="width: 100%">
								</div>

								<hr class="link"> <span class="current">${auditingMarket }<i
									class="other">条</i></span>

							</a>

						</div>
					</shiro:hasPermission>

					<!-- 社区报结束 -->
				<%-- </c:if> --%>
				<%-- </shiro:hasRole> --%>

				<%-- <shiro:hasRole name="operation"> --%>
				<%-- <c:if test="${orgType == 'operation'}"> --%>
					<!-- 运营开始 -->
					<%-- <shiro:hasPermission name="index_operation_regist_resident">
						<div class="column-box">

							<a style="border-bottom: 5px solid #c68b1d;"
								href="<%=ctx%>/app/appUser/list.do?type=0">

								<h4 class="title-msg">已有注册居民</h4>

								<div class="icon-shop">
									<img src="${ctx}/images/icon/iconshop1.png" style="width: 100%">
								</div>

								<hr class="link"> <span class="current">${regisitedResident }<i
									class="other">条</i></span>

							</a>

						</div>
					</shiro:hasPermission> --%>

					<shiro:hasPermission name="index_operation_today_registed">
						<div class="column-box">

							<a style="border-bottom: 5px solid #c68b1d;"
								href="<%=ctx%>/app/appUser/list.do?timeScope=0&dateField=registTime">

								<h4 class="title-msg">当日注册居民</h4>

								<div class="icon-shop">
									<img src="${ctx}/images/icon/iconshop1.png" style="width: 100%">
								</div>

								<hr class="link"> <span class="current">${operationRegistedResidentsOnDay }<i
									class="other">条</i></span>

							</a>

						</div>
					</shiro:hasPermission>

					<shiro:hasPermission name="index_operation_today_verified">
						<div class="column-box">

							<a style="border-bottom: 5px solid #c68b1d;"
								href="<%=ctx%>/app/appUser/list.do?type=1&timeScope=0&dateField=verifyTime">

								<h4 class="title-msg">当日验证居民</h4>

								<div class="icon-shop">
									<img src="${ctx}/images/icon/iconshop1.png" style="width: 100%">
								</div>

								<hr class="link"> <span class="current">${operationVerifiedResidentsOnDay }<i
									class="other">条</i></span>

							</a>

						</div>
					</shiro:hasPermission>

					<shiro:hasPermission name="index_operation_unreply_feedback">
						<div class="column-box">

							<a style="border-bottom: 5px solid #c68b1d;"
								href="<%=ctx%>/business/businessFeedback/list.do?fbState=0">

								<h4 class="title-msg">未回复居民反馈</h4>

								<div class="icon-shop">
									<img src="${ctx}/images/icon/whffk.png" style="width: 100%">
								</div>

								<hr class="link"> <span class="current">${unrepliedFeedback }<i
									class="other">条</i></span>

							</a>

						</div>
					</shiro:hasPermission>
					<shiro:hasPermission name="index_operation_auditing_anno">
						<div class="column-box">

							<a style="border-bottom: 5px solid #c68b1d;"
								href="<%=ctx%>/business/businessAnno/list.do?publishState=2">

								<h4 class="title-msg">待审核公告信息</h4>

								<div class="icon-shop">
									<img src="${ctx}/images/icon/dshggxx.png" style="width: 100%">
								</div>

								<hr class="link"> <span class="current">${audtingAnno }<i
									class="other">条</i></span>

							</a>

						</div>
					</shiro:hasPermission>
					<%-- <div class="column-box" >

                    <a style="border-bottom:5px solid #c68b1d;" href="javascript:;">

                        <h4 class="title-msg">推送未成功</h4>

                        <div class="icon-shop"><img src="${ctx}/images/icon/iconshop5.png" style="width:100%"></div>

                        <hr class="link">

                        <span class="current">0<i class="other">条</i></span>

                    </a>

                </div> --%>
					<shiro:hasPermission name="index_operation_publishing_focus">
						<div class="column-box">

							<a style="border-bottom: 5px solid #c68b1d;"
								href="<%=ctx%>/business/businessFocus/list.do?state=1">

								<h4 class="title-msg">待发布焦点图</h4>

								<div class="icon-shop">
									<img src="${ctx}/images/icon/dfbjdt.png" style="width: 100%">
								</div>

								<hr class="link"> <span class="current">${auditFocus }<i
									class="other">条</i></span>

							</a>

						</div>
					</shiro:hasPermission>
					<!-- 运营结束 -->
				<%-- </c:if> --%>
				<%-- </shiro:hasRole> --%>

			</div>

			<div class="no-float"></div>

			<%@include file="/common/footer.jsp"%>

		</div>
		<!--右部主体内容结束-->
	</div>

	<!--侧滑内容开始-->

	<div class="busswi">

		<div class="sidebar">

			<a id="close" href="javascript:;"></a>

			<h2 class="tit">选择业务</h2>

			<hr class="link">

			<div id="wrapper-250">

				<ul class="accordion">

					<li id="one" class="files"><a href="#one">社区报管理<span></span></a>

						<ul class="sub-menu">

							<li><a href="#">社区报管理<span></span></a></li>

							<li><a href="#">社区报管理<span></span></a></li>

							<li><a href="#">社区报管理<span></span></a></li>

							<li><a href="#">社区报管理<span></span></a></li>

							<li><a href="#">社区报管理<span></span></a></li>

						</ul></li>

					<li id="two" class="mail"><a href="#two">驿站管理<span></span></a>

						<ul class="sub-menu">

							<li><a href="#">驿站管理<span></span></a></li>

							<li><a href="#">驿站管理<span></span></a></li>

						</ul></li>

					<li id="three" class="cloud"><a href="#three">物业管管理<span></span></a>

						<ul class="sub-menu">

							<li><a href="#">物业管管理<span></span></a></li>

							<li><a href="#">物业管管理<span></span></a></li>

							<li><a href="#">物业管管理<span></span></a></li>

							<li><a href="#">物业管管理<span></span></a></li>

							<li><a href="#">物业管管理<span></span></a></li>

							<li><a href="#">物业管管理<span></span></a></li>

						</ul></li>

					<li id="four" class="sign" style="border-bottom: 1px solid #ebebeb">
						<a href="#four">运营管理<span></span></a>

						<ul class="sub-menu">

							<li><a href="#">运营管理</a></li>

							<li><a href="#">运营管理</a></li>

							<li><a href="#">运营管理</a></li>

						</ul>

					</li>

				</ul>

			</div>

			<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>

			<script type="text/javascript">

                $(document).ready(function() {

                    var accordion_head = $('.accordion > li > a'),

                            accordion_body = $('.accordion li > .sub-menu');

                    accordion_head.first().addClass('active').next().slideDown('normal');

                    accordion_head.on('click', function(event) {

                        event.preventDefault();

                        if ($(this).attr('class') != 'active'){

                            accordion_body.slideUp('normal');

                            $(this).next().stop(true,true).slideToggle('normal');

                            accordion_head.removeClass('active');

                            $(this).addClass('active');

                        }

                    });

                });
            </script>

		</div>

	</div>



	<!--侧滑内容结束-->


</div>

</html>
<div id="dialog-modal" title="公告内容">
	<div id="annoContentDom"></div>
</div>
<script src="<%=ctx%>/js/jquery-ui/jquery-ui-1.10.4.custom.min.js"
	type="text/javascript"></script>
<script>			
			function showAnnoContent(annoId) {
				$('#annoContentDom').html('');
				$.ajax({
					url: '<%=ctx%>/business/businessAnno/getAnnoJson.do',
			type : 'post',
			dataType : 'json',
			data : {
				annoId : annoId
			},
			success : function(data) {
				$('#annoContentDom').html(data.annoContent);
				$("#dialog-modal").dialog({
					width : 500,
					height : 400,
					modal : true
				});
				$("#dialog-modal").dialog('open');
			},
			error : function() {
				alert('抱歉，没有公告内容');
			}
		});
	}
</script>