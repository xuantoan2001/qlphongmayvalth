
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="ThemeBucket">
        <link rel="shortcut icon" href="public/web/images/logo-truong-250.png">
        <title>Quản Lý Phòng Máy Và LTH</title>
        <!--Core CSS -->
        <link href="public/web/bs3/css/bootstrap.min.css" rel="stylesheet">
        <link href="public/web/js/jquery-ui/jquery-ui-1.10.1.custom.min.css" rel="stylesheet">
        <link href="public/web/css/bootstrap-reset.css" rel="stylesheet">
        <link href="public/web/font-awesome/css/font-awesome.css" rel="stylesheet">
        <link href="public/web/js/jvector-map/jquery-jvectormap-1.2.2.css" rel="stylesheet">
        <link href="public/web/css/clndr.css" rel="stylesheet">
        <!--clock css-->
        <link href="public/web/js/css3clock/css/style.css" rel="stylesheet">
        <!--Morris Chart CSS -->
        <link rel="stylesheet" href="public/web/js/morris-chart/morris.css">
        <!-- Custom styles for this template -->
        <link href="public/web/css/style.css" rel="stylesheet">
        <link href="public/web/css/style-responsive.css" rel="stylesheet"/>
        <!-- Just for debugging purposes. Don't actually copy this line! -->
        <!--[if lt IE 9]>
        <script src="public/web/js/ie8-responsive-file-warning.js"></script><![endif]-->
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src="public/web/https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="public/web/https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <section id="container">
            <!--header start-->
            <jsp:include page="/views/_header.jsp"></jsp:include>
                <!--header end-->
                <!--sidebar start-->
            <jsp:include page="/views/_menu.jsp"></jsp:include>
                <!--sidebar end-->
                <!--main content start-->
                <section id="main-content">
                    <section class="wrapper">
                        
                    <jsp:include page="/Pages/${page}.jsp"></jsp:include>
                </section>
            </section>
        </section>
        <!-- Placed js at the end of the document so the pages load faster -->
        <!--Core js-->
        <script src="public/web/js/jquery.js"></script>
        <script src="public/web/js/jquery-ui/jquery-ui-1.10.1.custom.min.js"></script>
        <script src="public/web/bs3/js/bootstrap.min.js"></script>
        <script src="public/web/js/jquery.dcjqaccordion.2.7.js"></script>
        <script src="public/web/js/jquery.scrollTo.min.js"></script>
        <script src="public/web/js/jQuery-slimScroll-1.3.0/jquery.slimscroll.js"></script>
        <script src="public/web/js/jquery.nicescroll.js"></script>
        <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="public/web/js/flot-chart/excanvas.min.js"></script><![endif]-->
        <script src="public/web/js/skycons/skycons.js"></script>
        <script src="public/web/js/jquery.scrollTo/jquery.scrollTo.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
        <script src="public/web/js/calendar/clndr.js"></script>
        <script src="http://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.5.2/underscore-min.js"></script>
        <script src="public/web/js/calendar/moment-2.2.1.js"></script>
        <script src="public/web/js/evnt.calendar.init.js"></script>
        <script src="public/web/js/jvector-map/jquery-jvectormap-1.2.2.min.js"></script>
        <script src="public/web/js/jvector-map/jquery-jvectormap-us-lcc-en.js"></script>
        <script src="public/web/js/gauge/gauge.js"></script>
        <!--clock init-->
        <script src="public/web/js/css3clock/js/css3clock.js"></script>
        <!--Easy Pie Chart-->
        <script src="public/web/js/easypiechart/jquery.easypiechart.js"></script>
        <!--Sparkline Chart-->
        <script src="public/web/js/sparkline/jquery.sparkline.js"></script>
        <!--Morris Chart-->
        <script src="public/web/js/morris-chart/morris.js"></script>
        <script src="public/web/js/morris-chart/raphael-min.js"></script>
        <!--jQuery Flot Chart-->
        <script src="public/web/js/flot-chart/jquery.flot.js"></script>
        <script src="public/web/js/flot-chart/jquery.flot.tooltip.min.js"></script>
        <script src="public/web/js/flot-chart/jquery.flot.resize.js"></script>
        <script src="public/web/js/flot-chart/jquery.flot.pie.resize.js"></script>
        <script src="public/web/js/flot-chart/jquery.flot.animator.min.js"></script>
        <script src="public/web/js/flot-chart/jquery.flot.growraf.js"></script>
        <script src="public/web/js/dashboard.js"></script>
        <script src="public/web/js/jquery.customSelect.min.js" ></script>
        <!--common script init for all pages-->
        <script src="public/web/js/scripts.js"></script>
        <script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
        <!--script for this page-->
        <script >
            $('#add_pm').click(function (e) {
                e.preventDefault();
                var count = $('.new-pm').size();
                if (count > 4)
                    alert("Tối đa 5 phần mềm trong 1 lần yêu cầu!");
                else
                    $("#pm1").after($(".pm").html());

            });
        </script>
        <script>
            $(document).ready(function () {
                $("#AlertBox").removeClass("hide");
                $("#AlertBox").delay(1000).slideUp(1000);
            });
        </script>
    </body>
</html>