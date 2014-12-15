<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/7/26
  Time: 13:04
  To change this template use File | Settings | File Templates.
  地图
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="http://webapi.amap.com/maps?v=1.3&key=52720c80a945411aaf54f0f3d2ee32f0" type="text/javascript"></script>
<script type="text/javascript">
    $(function() {
        //加载地图开始--------------------
        var lng = 116.397428;
        var lat = 39.90923;

        var contextMenuPositon;
        var position=new AMap.LngLat(lng,lat); //地图中心 天安门
        var mapObj=new AMap.Map("container",{
            view: new AMap.View2D({//创建地图二维视口
                center:position,//创建中心点坐标
                zoom:14, //设置地图缩放级别
                rotation:0 //设置地图旋转角度
            }),
            lang:"zh_cn"//设置地图语言类型，默认：中文简体
        });//创建地图实例
        //加载地图结束--------------------
        //AMap.event.addListener(mapObj,"click",eventHandler);
        //创建右键菜单
        var contextMenu = new AMap.ContextMenu();
        var ary = [];
        //右键添加Marker标记
        contextMenu.addItem("添加标记",function(e){
            var marker = new AMap.Marker({
                map:mapObj,
                position:contextMenuPositon, //基点位置
                //icon:"http://webapi.amap.com/images/marker_sprite.png", //marker图标，直接传递地址url
                icon:"http://webapi.amap.com/images/0.png", //marker图标，直接传递地址url
                offset:{x:-8,y:-34} //相对于基点的位置
            });
            $('#location').val(contextMenuPositon);

        },3);
        
        var clickEventListener=AMap.event.addListener(mapObj,'click',function(e){
 			document.getElementById("lngX").value=e.lnglat.getLng();
 			alert('e.lnglat.getLng()   '+e.lnglat.getLng());
			document.getElementById("latY").value=e.lnglat.getLat();
			alert('e.lnglat.getLat()   '+e.lnglat.getLat());
 		});

        //地图绑定鼠标右击事件——弹出右键菜单
        AMap.event.addListener(mapObj,'rightclick',function(e){
            contextMenu.open(mapObj,e.lnglat);
            contextMenuPositon = e.lnglat;
        });
        var lngstr = $('#Lng').val();
        var latstr = $('#Lat').val();
        if(lngstr != undefined && latstr != undefined) {

            new AMap.Marker({
                map:mapObj,
                position:new AMap.LngLat(parseFloat(lngstr),parseFloat(latstr)), //基点位置
                //icon:"http://webapi.amap.com/images/marker_sprite.png", //marker图标，直接传递地址url
                icon:"http://webapi.amap.com/images/0.png", //marker图标，直接传递地址url
                offset:{x:-8,y:-34} //相对于基点的位置
            });
        }

    })
</script>
<div class="busswi">
    <div class="sidebar" style="width: 750px;">
        <a id="close" href="javascript:;"></a>
        <h2 class="tit">位置选择</h2>
        <div style="width:710px;">
            <div id="container" style="width:700px;height: 550px"></div>
        </div>
    </div>
</div>


