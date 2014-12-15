<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <title>公告管理</title>
    <%@include file="/common/meta.jsp"%>
</head>
<body>
<div class="wrapper">
    <!--左导航开始-->
    <%@include file="/common/leftNav.jsp"%>
    <!--左导航结束-->
    <!--右部主体内容开始-->
    <div class="mainr">
        <%@include file="/common/header.jsp"%>

        <!--下拉显示导航-->
        <div class="scrolldown">
            <div class="scrolldownbox">
                <div class="scroll-box">

                    <ul id="oneuldown">

                        <li class="active"><a href="javascript:;">全部新闻:<span class="current">267条</span><b class="donbut"><i></i></b></a>

                            <ul>

                                <li><a href="javascript:;">已发布：121条</a></li>

                                <li><a href="javascript:;">待发：布90条</a></li>

                                <li><a href="javascript:;">待发：布90条</a></li>

                                <li><a href="javascript:;">待发：布90条</a></li>

                                <li><a href="javascript:;">待发：布90条</a></li>

                            </ul>

                        </li>



                        <li><a href="javascript:;">所有分类<b class="donbut"><i></i></b></a>

                            <ul>

                                <li><a href="javascript:;">已发布：121条</a></li>

                                <li><a href="javascript:;">待发：布90条</a></li>

                                <li><a href="javascript:;">待发：布90条</a></li>

                                <li><a href="javascript:;">待发：布90条</a></li>

                                <li><a href="javascript:;">待发：布90条</a></li>

                            </ul>

                        </li>



                        <li><a href="javascript:;">所有时间范围<b class="donbut"><i></i></b></a>

                            <ul>

                                <li><a href="javascript:;">已发布：121条</a></li>

                                <li><a href="javascript:;">待发：布90条</a></li>

                                <li><a href="javascript:;">待发：布90条</a></li>

                                <li><a href="javascript:;">待发：布90条</a></li>

                                <li><a href="javascript:;">待发：布90条</a></li>

                            </ul>

                        </li>



                        <li><a href="javascript:;">排序<b class="donbut"><i></i></b></a>

                            <ul>

                                <li><a href="javascript:;">已发布：121条</a></li>

                                <li><a href="javascript:;">待发：布90条</a></li>

                                <li><a href="javascript:;">待发：布90条</a></li>

                                <li><a href="javascript:;">待发：布90条</a></li>

                                <li><a href="javascript:;">待发：布90条</a></li>

                            </ul>

                        </li>



                    </ul>

                </div>

                <div id="search"><div class="borbox"><input id="searbox" type="text" name="" value="" /><input id="searbut" type="submit" value="" /></div></div>
            </div>
        </div>

        <div class="column">
			<div class="manbox" style="margin-left:0;">
            	<a class="nopotr" href="javascript:;" style="cursor:pointer;">
                    <div class="relnews"><img src="${ctx}/images/icon/relnews.png" style="width:100%;" onclick="window.location.href='${ctx}/business/businessAnno/add.do'"/></div>
                	<span class="tittex" onclick="window.location.href='${ctx}/business/businessAnno/add.do'">发布公告</span>
                </a>
            </div>
            <div class="manbox">
            	<a class="nopotr" href="javascript:;">
                    <div class="info">公告范围：<span>罗马嘉园 — 1号楼、2号楼</span></div>
                    <time>2014-4-25 10:53</time>
                    <hr class="link">
                    <h2 class="title">公告标题，公告标题，公告标题，公告标题</h2>
                    <div class="state"><span class="relsta">已发布</span><div class="other-r"><i class="look">100</i><i class="rev">100</i><i class="help" id="block6">100</i></div></div>
                    <p class="text">公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容...</p>
                    <hr class="link">
                    <div class="operate"><span class="see" id="block5"></span><span class="edit"></span><span class="del"></span></div>
                    <span class="gore goreblock"><img src="${ctx}/images/icon/gore.png" width="31" height="31" /><i>顶</i></span>
                </a>
            </div>
            <div class="manbox">
            	<a class="nopotr" href="javascript:;">
                    <div class="info">公告范围：<span>罗马嘉园 — 1号楼、2号楼</span></div>
                    <time>2014-4-25 10:53</time>
                    <hr class="link">
                    <h2 class="title">公告标题，公告标题，公告标题，公告标题</h2>
                    <div class="state"><span class="relsta">已发布</span><div class="other-r"><i class="look">100</i><i class="rev">100</i><i class="help">100</i></div></div>
                    <p class="text">公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容...</p>
                    <hr class="link">
                    <div class="operate"><span class="see"></span><span class="edit"></span><span class="del"></span></div>
                    <span class="gore goreblock"><img src="${ctx}/images/icon/gore.png" width="31" height="31" /><i>顶</i></span>
                </a>
            </div>
            <div class="manbox" style="margin-left:0;">
            
            	<a class="nopotr" href="javascript:;">
            
                    <div class="info">公告范围：<span>罗马嘉园 — 1号楼、2号楼</span></div>
                    
                    <time>2014-4-25 10:53</time>
                    
                    <hr class="link">
                    
                    <h2 class="title">公告标题，公告标题，公告标题，公告标题</h2>
                    
                    <div class="state"><span class="relsta">已发布</span><div class="other-r"><i class="look">100</i><i class="rev">100</i><i class="help">100</i></div></div>
                
                    <p class="text">公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容...</p>
                    
                    <hr class="link">
                    
                    <div class="operate"><span class="see"></span><span class="edit"></span><span class="del"></span></div>
                
                    <span class="gore goreblock"><img src="${ctx}/images/icon/gore.png" width="31" height="31" /><i>顶</i></span>
                
                </a>
                
            </div>
            
            <div class="manbox">
            
            	<a class="nopotr" href="javascript:;">
            
                    <div class="info">公告范围：<span>罗马嘉园 — 1号楼、2号楼</span></div>
                    
                    <time>2014-4-25 10:53</time>
                    
                    <hr class="link">
                    
                    <h2 class="title">公告标题，公告标题，公告标题，公告标题</h2>
                    
                    <div class="state"><span class="relsta">已发布</span><div class="other-r"><i class="look">100</i><i class="rev">100</i><i class="help">100</i></div></div>
                
                    <p class="text">公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容...</p>
                    
                    <hr class="link">
                    
                    <div class="operate"><span class="see"></span><span class="edit"></span><span class="del"></span></div>
                
                    <span class="gore goreblock"><img src="${ctx}/images/icon/gore.png" width="31" height="31" /><i>顶</i></span>
                
                </a>
                
            </div>
            
            <div class="manbox">
            
            	<a class="nopotr" href="javascript:;">
            
                    <div class="info">公告范围：<span>罗马嘉园 — 1号楼、2号楼</span></div>
                    
                    <time>2014-4-25 10:53</time>
                    
                    <hr class="link">
                    
                    <h2 class="title">公告标题，公告标题，公告标题，公告标题</h2>
                    
                    <div class="state"><span class="relsta">已发布</span><div class="other-r"><i class="look">100</i><i class="rev">100</i><i class="help">100</i></div></div>
                
                    <p class="text">公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容...</p>
                    
                    <hr class="link">
                    
                    <div class="operate"><span class="see"></span><span class="edit"></span><span class="del"></span></div>
                
                    <span class="gore goreblock"><img src="${ctx}/images/icon/gore.png" width="31" height="31" /><i>顶</i></span>
                
                </a>
                
            </div>
            
            <div class="no-float"></div>
            
            <div class="page">

                <a id="arrow-l" class="arrow" href="javascript:;"></a>
                
                <ul>
                
                    <li><a id="old" href="javascript:;">1</a></li>
                    
                    <li><a id="curr" href="javascript:;">2</a></li>
                    
                    <li><a href="javascript:;">3</a></li>
                    
                    <li><a href="javascript:;">4</a></li>
                    
                    <li><a href="javascript:;">5</a></li>
                
                </ul>
                
                <a id="arrow-r" class="arrow" href="javascript:;"></a>
                
            </div>

        </div>
        
        <div class="no-float"></div>
        <%@include file="/common/footer.jsp"%>
    </div>
    <!--右部主体内容结束-->
    
</div>
<div class="busswi5">

	<div class="sidebar5">
    
    	<a id="close5" href="javascript:;"></a>
    
    	<h2 class="tit5">公告内容<em>【待审核】</em></h2>
        <div id="wrapper-250">
        
            <ul class="accordion5">
          
            <li id="one5" class="files"><a href="#one">公告标题，公告标题，公告标题，公告标题，</a></li>
            <div class="link5"></div>
            
              <ul class="sub-menu5">
              
                <li><a href="#">公告范围：方丹苑 — 1号楼、2号楼、3号楼（1、2、3单元）</a></li>
                
                <li><a href="#">发布人：李晓雨</a><em class="time2">发布时间：2014-4-25  10:13</em></li>
                
                <div class="link5"></div>
                
                <img class="green" src="images/green.jpg" width="367" height="254">
                
                <li><a href="#">公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容，公告内容</a></li>
                
              </ul>
          </ul>
            <div class="link6"></div>
            <div class="submtpres">
                <input id="qrbut5" type="submit" name="" value="采纳" />
            	<input id="zsbut5" type="button" name="" value="拒绝" />
            </div>
        </div>
    </div>
</div>   
<div class="busswi6">
	<div class="sidebar6">
    	<a id="close6" href="javascript:;"></a>
    	<h2 class="tit6">点赞量</h2>
        <div id="wrapper-250">
            <ul class="accordion6">
              <ul class="sub-menu6">
                <li><img class="zan_icon" src="${ctx}/images/icon/zan_icon.jpg" width="43" height="43"><a href="#">jinaiyuliang<br><strong style="font-weight:normal; color:#f00;">望京</strong></a><em class="time2">点赞时间：<br>2014-4-25　　　10:13</em></li>
                <div class="link6"></div>
                <li><img class="zan_icon" src="${ctx}/images/icon/zan_icon.jpg" width="43" height="43"><a href="#">jinaiyuliang<br><strong style="font-weight:normal; color:#f00;">望京</strong></a><em class="time2">点赞时间：<br>2014-4-25　　　10:13</em></li>
                <div class="link6"></div>
                <li><img class="zan_icon" src="${ctx}/images/icon/zan_icon.jpg" width="43" height="43"><a href="#">jinaiyuliang<br><strong style="font-weight:normal; color:#f00;">望京</strong></a><em class="time2">点赞时间：<br>2014-4-25　　　10:13</em></li>
                <div class="link6"></div>
                <li><img class="zan_icon" src="${ctx}/images/icon/zan_icon.jpg" width="43" height="43"><a href="#">jinaiyuliang<br><strong style="font-weight:normal; color:#f00;">望京</strong></a><em class="time2">点赞时间：<br>2014-4-25　　　10:13</em></li>
                <div class="link6"></div>
              </ul>
          </ul>
      </div>
    </div>
</div> 
     
</body>
</html>
