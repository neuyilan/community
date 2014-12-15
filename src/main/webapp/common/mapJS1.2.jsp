<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="http://webapi.amap.com/maps?v=1.2&key=52720c80a945411aaf54f0f3d2ee32f0" type="text/javascript"></script>
<div class="busswi">
    <div class="sidebar" style="width: 750px;">
        <a id="close" href="javascript:;"></a>
        <h2 class="tit">位置选择</h2>
        <!-- <div style="margin-left: 10px;">
            <span>搜索:</span>
            <input style="width:300px;" class="iptnewtit" type="text" name="word" id="word" value="" />&nbsp;&nbsp;
            <input class="iptnewtit" type="button" id="searchBtn" onclick="search()" value="查询" />
        </div> -->
        <div style="margin-left: 10px;font-size: 14px;">
            	<p>经度:&nbsp;&nbsp;<span id="lon"></span>&nbsp;&nbsp;&nbsp;&nbsp;
            	纬度:&nbsp;&nbsp;<span id="lat"></span></p>
            	<p>地址:&nbsp;&nbsp;<span id="addr"></span></p>
        </div>
        
      <!-- 
		<div>
			<div>
				输入位置信息:</b><input type="text" name="searchText" / > 
			   <input type="button" value="查询" onclick="Search()" />
			   <div id="result" ></div>
			</div>
		      
		</div> -->
        
        
        <div style="width:710px;">
            <div id="container" style="width:700px;height: 500px"></div>
        </div>
    </div>
    
    
     
    
    
</div>


        




<script language="javascript">
var mapObj;
var lnglatXY;
//初始化地图
mapInit();
function mapInit(){
    var opt = {  
        level: 10, //设置地图缩放级别    
        center: new AMap.LngLat(116.397428, 39.90923) //设置地图中心点   
    }  
    mapObj = new AMap.Map("container", opt);  
	
	AMap.event.addListener(mapObj,'click',getLnglat); //点击事件
}
function geocoder() {
    var MGeocoder;
    //加载地理编码插件
    mapObj.plugin(["AMap.Geocoder"], function() {        
        MGeocoder = new AMap.Geocoder({ 
            radius: 1000,
            extensions: "all"
        });
        //返回地理编码结果 
        AMap.event.addListener(MGeocoder, "complete", geocoder_CallBack); 
        //逆地理编码
        MGeocoder.getAddress(lnglatXY); 
    });
    //加点
    var marker = new AMap.Marker({
        map:mapObj,
        icon: new AMap.Icon({
            image: "http://api.amap.com/Public/images/js/mark.png",
            size:new AMap.Size(58,30),
            imageOffset: new AMap.Pixel(-32, -0)
        }),
        position: lnglatXY,
        offset: new AMap.Pixel(-5,-30)
    });
   // mapObj.setFitView();
}
//回调函数
function geocoder_CallBack(data) {
    var address;
    //返回地址描述
    address = data.regeocode.formattedAddress;
    //返回结果拼接输出
    //document.getElementById("iAddress").innerHTML = address;
    $('#addr').text(address);
}  
//鼠标点击，获取经纬度坐标  
function getLnglat(e){    
	mapObj.clearMap();
	var x = e.lnglat.getLng();
	var y = e.lnglat.getLat(); 
	//document.getElementById("lnglat").innerHTML = x + "," + y;
	$('#lon').text(x);
	$('#lat').text(y);
	$('#estateLongitude').val(x);
	$('#estateLatitude').val(y);
	lnglatXY = new AMap.LngLat(x,y);
	geocoder();
}

//查询地点  
var mar;
var marker = new Array();  
var windowsArr = new Array(); 
function Search() {  
    var MSearch;  
    mapObj.plugin(["AMap.PlaceSearch"],function() {          
        MSearch = new AMap.PlaceSearch({ //构造地点查询类  
            pageSize:5,  
            pageIndex:1,  
            city:"北京" //城市  
        });
        AMap.event.addListener(MSearch, "complete", keywordSearch_CallBack);//返回地点查询结果  
        var searchName = document.all.searchText.value;//查询关键字
  		MSearch.search(searchName); //关键字查询  
    });
    mapObj.clearMap();//清空地图
    //cloudDataLayer.setMap(null);//清空地图
}  
//添加marker&infowindow      
function addmarker(i,d) {
    var lngX = d.lnglat.getLng();  
    var latY = d.lnglat.getLat();
    
    var markerOption = {  
        map:mapObj, 
        icon:"http://webapi.amap.com/images/" + (i + 1) + ".png",  
        position:new AMap.LngLat(lngX,latY)    
    }; 
    
    mar = new AMap.Marker(markerOption);           
    marker.push(new AMap.LngLat(lngX,latY));  
    
    var infoWindow = new AMap.InfoWindow({  
        content:"<h3><font color=\"#00a6ac\">&nbsp;&nbsp;" + (i + 1) + ". " + d.name + "</font></h3>" + TipContents(d.type,d.address,d.tel),  
        size:new AMap.Size(300,0),   
        autoMove:true,    
        offset:new AMap.Pixel(0-30)  
    });  
    windowsArr.push(infoWindow);   
    var aa = function (e) {infoWindow.open(mapObj, mar.getPosition());};  
    AMap.event.addListener(mar, "click", aa);  
}  
//回调函数  
function keywordSearch_CallBack(data) {  
    var resultStr = "";  
    var poiArr = data.poiList.pois;  
    var resultCount = poiArr.length;  
    for (var i = 0; i < resultCount; i++) {  
        resultStr += "<div id='divid" + (i + 1) + "' onclick='openMarkerTipById1(" + i + "this)' onmouseout='onmouseout_MarkerStyle(" + (i + 1) + "this)' style=\"font-size: 12px;cursor:pointer;padding:0px 0 4px 2px; border-bottom:1px solid #C1FFC1;\"><table><tr><td><img src=\"http://webapi.amap.com/images/" + (i + 1) + ".png\"></td>" + "<td><h3><font color=\"#00a6ac\">名称: " + poiArr.name + "</font></h3>";  
            resultStr += TipContents(poiArr.type, poiArr.address, poiArr.tel) + "</td></tr></table></div>";  
            addmarker(i, poiArr);  
    }  
    mapObj.setFitView();  
    document.getElementById("result").innerHTML = resultStr;  

}  
function TipContents(type, address, tel) {  //窗体内容  
    if (type == "" || type == "undefined" || type == null || type == " undefined" || typeof type == "undefined") {  
        type = "暂无";  
    }  
    if (address == "" || address == "undefined" || address == null || address == " undefined" || typeof address == "undefined") {  
        address = "暂无";  
    }  
    if (tel == "" || tel == "undefined" || tel == null || tel == " undefined" || typeof address == "tel") {  
        tel = "暂无";  
    }  
    var str = "&nbsp;&nbsp;地址：" + address + "<br />&nbsp;&nbsp;电话：" + tel + " <br />&nbsp;&nbsp;类型：" + type;  
    return str;  
}  
function openMarkerTipById1(pointid, thiss) {  //根据id 打开搜索结果点tip  
    thiss.style.background = '#CAE1FF';  
    windowsArr[pointid].open(mapObj, marker[pointid]); 
  
}  
function onmouseout_MarkerStyle(pointid, thiss) { //鼠标移开后点样式恢复  
    thiss.style.background = "";  
}  
</script>



