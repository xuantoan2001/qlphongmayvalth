<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>

	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="ThemeBucket">
    <link rel="shortcut icon" href="<c:url value='/template/web/images/logo-truong-250.png'/>">
    <title>Quản Lý Chi Tiêu</title>
    <!--Core CSS -->
    <link href="<c:url value='/template/web/bs3/css/bootstrap.min.css'/>" rel="stylesheet" >
    <link href="<c:url value='/template/web/js/jquery-ui/jquery-ui-1.10.1.custom.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/template/web/css/bootstrap-reset.css'/>" rel="stylesheet">
    <link href="<c:url value='/template/web/font-awesome/css/font-awesome.css'/>" rel="stylesheet">
    <link href="<c:url value='/template/web/js/jvector-map/jquery-jvectormap-1.2.2.css'/>" rel="stylesheet">
    <link href="<c:url value='/template/web/css/clndr.css'/>" rel="stylesheet">
    <!--clock css-->
    <link href="<c:url value='/template/web/js/css3clock/css/style.css'/>" rel="stylesheet">
    <!--Morris Chart CSS -->
    <link rel="<c:url value='/template/web/stylesheet" href="js/morris-chart/morris.css'/>">
    <!-- Custom styles for this template -->
    <link href="<c:url value='/template/web/css/style.css'/>" rel="stylesheet">
    <link href="<c:url value='/template/web/css/style-responsive.css'/>" rel="stylesheet"/>

</head>
<body>
	<!-- Navigation -->
	<%@ include file="/common/web/header.jsp" %>

	



<section id="container">
<!--header start-->
<header class="header fixed-top clearfix">
<!--logo start-->
<div class="brand" style="background-color: #fff;">
    
    <a href="index.html" class="logo" style="text-align: center;display: block;margin: 0px;margin: 20px 5px 10px 25px;">
        <img src="images/logo-truong-250.png" alt="" style="max-width: 50px;max-height: 50px;display: block;">
        
    </a>
    <span style="font-size: 13px;text-align: justify;display: block;color: black;margin: 0px;margin: 25px 0px 10px 20px;">Trường Đại Học Sư Phạm Kỹ Thuật Đà Nẵng</span>
    <div class="sidebar-toggle-box">
        <div class="fa fa-bars"></div>
    </div>
</div>
<!--logo end-->

<div class="nav notify-row" id="top_menu">
    <!--  notification start -->
    
    <!--  notification end -->
</div>
<div class="top-nav clearfix">
    <!--search & user info start-->
    <ul class="nav pull-right top-menu">
        <li>
            <input type="text" class="form-control search" placeholder=" Search">
        </li>
        <!-- user login dropdown start-->
        <li class="dropdown">
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                <img alt="" src="images/avatar1_small.jpg">
                <span class="username">Phạm Xuân Toán</span>
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu extended logout">
                <li><a href="#"><i class=" fa fa-suitcase"></i>Thông tin cá nhân</a></li>
                <li><a href="#"><i class="fa fa-cog"></i> Cài đặt</a></li>
                <li><a href="login.html"><i class="fa fa-key"></i> Đăng xuất</a></li>
            </ul>
        </li>
        <!-- user login dropdown end -->
        
    </ul>
    <!--search & user info end-->
</div>
</header>
<!--header end-->
<!--sidebar start-->

<!--sidebar end-->
<!--main content start-->
<section id="main-content">
	<section class="wrapper">
	
	<!--mini statistics start-->
	<div class="row">
	    <div class="col-md-3">
	        <section class="panel">
	            <div class="panel-body">
	                <div class="top-stats-panel">
	                    <div class="gauge-canvas">
	                        <h4 class="widget-h">Monthly Expense</h4>
	                        <canvas width=160 height=100 id="gauge"></canvas>
	                    </div>
	                    <ul class="gauge-meta clearfix">
	                        <li id="gauge-textfield" class="pull-left gauge-value"></li>
	                        <li class="pull-right gauge-title">Safe</li>
	                    </ul>
	                </div>
	            </div>
	        </section>
	    </div>
	    <div class="col-md-3">
	        <section class="panel">
	            <div class="panel-body">
	                <div class="top-stats-panel">
	                    <div class="daily-visit">
	                        <h4 class="widget-h">Daily Visitors</h4>
	                        <div id="daily-visit-chart" style="width:100%; height: 100px; display: block">
	
	                        </div>
	                        <ul class="chart-meta clearfix">
	                            <li class="pull-left visit-chart-value">3233</li>
	                            <li class="pull-right visit-chart-title"><i class="fa fa-arrow-up"></i> 15%</li>
	                        </ul>
	                    </div>
	                </div>
	            </div>
	        </section>
	    </div>
	    <div class="col-md-3">
	        <section class="panel">
	            <div class="panel-body">
	                <div class="top-stats-panel">
	                    <h4 class="widget-h">Top Advertise</h4>
	                    <div class="sm-pie">
	                    </div>
	                </div>
	            </div>
	        </section>
	    </div>
	    
	</div>
	<!--mini statistics end-->
	<div class="row">
	    <div class="col-md-8">
	        <!--earning graph start-->
	        <section class="panel">
	            <header class="panel-heading">
	                Earning Graph <span class="tools pull-right">
	            <a href="javascript:;" class="fa fa-chevron-down"></a>
	            <a href="javascript:;" class="fa fa-cog"></a>
	            <a href="javascript:;" class="fa fa-times"></a>
	            </span>
	            </header>
	            <div class="panel-body">
	
	                <div id="graph-area" class="main-chart">
	                </div>
	               
	            </div>
	        </section>
	        <!--earning graph end-->
	    </div>
	    
	</div>
	<!--mini statistics start-->
	
	<!--mini statistics end-->
	
	
	
	
	
	</section>
</section>
<!--main content end-->
<!--right sidebar start-->

<!--right sidebar end-->
</section>
<!-- Placed js at the end of the document so the pages load faster -->
<!--Core js-->
<script src="<c:url value='/template/web/js/jquery.js'/>"></script>
<script src="<c:url value='/template/web/js/jquery-ui/jquery-ui-1.10.1.custom.min.js'/>"></script>
<script src="<c:url value='/template/web/bs3/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='/template/web/js/jquery.dcjqaccordion.2.7.js'/>"></script>
<script src="<c:url value='/template/web/js/jquery.scrollTo.min.js'/>"></script>
<script src="<c:url value='/template/web/js/jQuery-slimScroll-1.3.0/jquery.slimscroll.js'/>"></script>
<script src="<c:url value='/template/web/js/jquery.nicescroll.js'/>"></script>
<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js'/>"></script><![endif]-->
<script src="<c:url value='/template/web/js/skycons/skycons.js'/>"></script>
<script src="<c:url value='/template/web/js/jquery.scrollTo/jquery.scrollTo.js'/>"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js'/>"></script>
<script src="<c:url value='/template/web/js/calendar/clndr.js'/>"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.5.2/underscore-min.js'/>"></script>
<script src="<c:url value='/template/web/js/calendar/moment-2.2.1.js'/>"></script>
<script src="<c:url value='/template/web/js/evnt.calendar.init.js'/>"></script>
<script src="<c:url value='/template/web/js/jvector-map/jquery-jvectormap-1.2.2.min.js'/>"></script>
<script src="<c:url value='/template/web/js/jvector-map/jquery-jvectormap-us-lcc-en.js'/>"></script>
<script src="<c:url value='/template/web/js/gauge/gauge.js'/>"></script>
<!--clock init-->
<script src="<c:url value='/template/web/js/css3clock/js/css3clock.js'/>"></script>
<!--Easy Pie Chart-->
<script src="<c:url value='/template/web/js/easypiechart/jquery.easypiechart.js'/>"></script>
<!--Sparkline Chart-->
<script src="<c:url value='/template/web/js/sparkline/jquery.sparkline.js'/>"></script>
<!--Morris Chart-->
<script src="<c:url value='/template/web/js/morris-chart/morris.js'/>"></script>
<script src="<c:url value='/template/web/js/morris-chart/raphael-min.js'/>"></script>
<!--jQuery Flot Chart-->
<script src="<c:url value='/template/web/js/flot-chart/jquery.flot.js'/>"></script>
<script src="<c:url value='/template/web/js/flot-chart/jquery.flot.tooltip.min.js'/>"></script>
<script src="<c:url value='/template/web/js/flot-chart/jquery.flot.resize.js'/>"></script>
<script src="<c:url value='/template/web/js/flot-chart/jquery.flot.pie.resize.js'/>"></script>
<script src="<c:url value='/template/web/js/flot-chart/jquery.flot.animator.min.js'/>"></script>
<script src="<c:url value='/template/web/js/flot-chart/jquery.flot.growraf.js'/>"></script>
<script src="<c:url value='/template/web/js/dashboard.js'/>"></script>
<script src="<c:url value='/template/web/js/jquery.customSelect.min.js'/>" ></script>
<!--common script init for all pages-->
<script src="<c:url value='/template/web/js/scripts.js'/>"></script>
<!--script for this page-->
</body>
</html>