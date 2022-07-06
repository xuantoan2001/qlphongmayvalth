<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!--header start-->
<header class="header fixed-top clearfix">
<!--logo start-->
<div class="brand" style="background-color: #fff;">
    
    <a href="index.html" class="logo" style="text-align: center;display: block;margin: 0px;margin: 20px 5px 10px 25px;">
        <img src="public/web/images/logo-truong-250.png" alt="" style="max-width: 50px;max-height: 50px;display: block;">
        
    </a>
    
    <span style="font-size: 13px;text-align: justify;display: block;color: black;margin: 0px;margin: 25px 0px 10px 20px;">Trường Đại Học Sư Phạm Kỹ Thuật Đà Nẵng</span>
    
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
                <img alt="" src="public/web/images/Untitled.png">
                <span class="username"><c:set var="tenTK" value="${taikhoan.tenTK}"  />${taikhoan.tenTK} </span>
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu extended logout">
                <li><a href="#"><i class=" fa fa-suitcase"></i>Thông tin cá nhân</a></li>
                <li><a href="./dang-xuat"><i class="fa fa-key"></i> Đăng xuất</a></li>
            </ul>
        </li>
        <!-- user login dropdown end -->
        
    </ul>
    <!--search & user info end-->
</div>
</header>
<!--header end-->
