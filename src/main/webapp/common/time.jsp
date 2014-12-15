<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2014/7/31
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <script src="<%=request.getContextPath()%>/js/jquery-1.7.2.min.js" type="text/javascript" ></script>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/date/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/date/bootstrap-datepicker/css/datepicker.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/js/date/bootstrap-timepicker/compiled/timepicker.css" />

    <script type="text/javascript" src="<%=request.getContextPath()%>/js/date/bootstrap-datepicker/js/locales/bootstrap-datepicker.zh-CN.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/date/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/date/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/date/bootstrap-timepicker/js/bootstrap-timepicker.js"></script>
    <script type="text/javascript">
        $(function() {
            //计划日期
            $('#plan_date').datepicker({
                format: 'yyyy-mm-dd',
                autoclose: true
            });
            //计划时间
            $('#plan_time').timepicker({
                minuteStep: 5,
                //template: 'modal',
                showSeconds: false,
                showMeridian: false
            });
        })
    </script>
</head>
<body>
<%--<input class="span3 m-ctrl-medium" id="plan_date" name="plan_date" type="text" value=""/>
<input class="span3 input-small" id="plan_time" name="plan_time" type="text" value=""/>--%>
</body>
</html>
