<%--
  Created by IntelliJ IDEA.
  User: 欧阳俊豪
  Date: 2020/12/13
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>申通物流后台系统</title>

    <!--Favicon -->
    <link rel="icon" href="assets/img/favicon.ico" type="image/x-icon"/>

    <!--Bootstrap.min css-->
    <link rel="stylesheet" href="assets/plugins/bootstrap/css/bootstrap.min.css">

    <!--Icons css-->
    <link rel="stylesheet" href="assets/css/icons.css">

    <!--Style css-->
    <link rel="stylesheet" href="assets/css/style.css">

    <!--mCustomScrollbar css-->
    <link rel="stylesheet" href="assets/plugins/scroll-bar/jquery.mCustomScrollbar.css">

    <!--Sidemenu css-->
    <link rel="stylesheet" href="assets/plugins/toggle-menu/sidemenu.css">

    <!--Chartist css-->
    <link rel="stylesheet" href="assets/plugins/chartist/chartist.css">
    <link rel="stylesheet" href="assets/plugins/chartist/chartist-plugin-tooltip.css">

    <!--Full calendar css-->
    <link rel="stylesheet" href="assets/plugins/fullcalendar/stylesheet1.css">

    <!--morris css-->
    <link rel="stylesheet" href="assets/plugins/morris/morris.css">


</head>

<body class="app ">

<div id="spinner"></div>

<div id="app">
    <div class="main-wrapper" >
        <nav class="navbar navbar-expand-lg main-navbar">
            <a class="header-brand" href="index.html">
                <!-- logo图片 -->
                <img src="assets/img/brand/website_logo.png" class="header-brand-img" alt="Kharna-Admin  logo">
            </a>
            <form class="form-inline mr-auto">
                <ul class="navbar-nav mr-3">
                    <li><a href="index.html#" data-toggle="sidebar" class="nav-link nav-link-lg"><i class="ion ion-navicon-round"></i></a></li>
                    <li><a href="index.html#" data-toggle="search" class="nav-link nav-link-lg d-md-none navsearch"><i class="ion ion-search"></i></a></li>
                </ul>
                <!-- 搜索 -->
                <div class="search-element">
                    <input class="form-control" type="search" placeholder="搜索" aria-label="Search">
                    <button class="btn btn-primary" type="submit"><i class="ion ion-search"></i></button>
                </div>
            </form>
            <ul class="navbar-nav navbar-right">
                <li class="dropdown dropdown-list-toggle"><a href="index.html#" data-toggle="dropdown" class="nav-link notification-toggle nav-link-lg beep"><i class="ion-ios-email-outline"></i></a>
                    <div class="dropdown-menu dropdown-list dropdown-menu-right">
                        <div class="dropdown-header">Messages
                            <div class="float-right">
                                <a href="index.html#">View All</a>
                            </div>
                        </div>
                        <div class="dropdown-list-content">
                            <a href="index.html#" class="dropdown-item dropdown-item-unread">
                                <img alt="image" src="assets/img/avatar/avatar-1.jpeg.jpg" class="rounded-circle dropdown-item-img">
                                <div class="dropdown-item-desc">
                                    <div class="dropdownmsg d-flex">
                                        <div class="">
                                            <b>Stewart Ball</b>
                                            <p>Your template awesome</p>
                                        </div>
                                        <div class="time">6 hours ago</div>
                                    </div>

                                </div>
                            </a>
                            <a href="index.html#" class="dropdown-item dropdown-item-unread">
                                <img alt="image" src="assets/img/avatar/avatar-2.jpeg.jpg" class="rounded-circle dropdown-item-img">
                                <div class="dropdown-item-desc">
                                    <div class="dropdownmsg d-flex">
                                        <div class="">
                                            <b>Jonathan North</b>
                                            <p>Your Order Shipped.....</p>
                                        </div>
                                        <div class="time">45 mins ago</div>
                                    </div>
                                </div>
                            </a>
                            <a href="index.html#" class="dropdown-item">
                                <img alt="image" src="assets/img/avatar/avatar-4.jpeg.jpg" class="rounded-circle dropdown-item-img">
                                <div class="dropdown-item-desc">
                                    <div class="dropdownmsg d-flex">
                                        <div class="">
                                            <b>Victor Taylor</b>
                                            <p>Hi!, I' am web developer</p>
                                        </div>
                                        <div class="time"> 8 hours ago</div>
                                    </div>
                                </div>
                            </a>
                            <a href="index.html#" class="dropdown-item">
                                <img alt="image" src="assets/img/avatar/avatar-3.jpeg.jpg" class="rounded-circle dropdown-item-img">
                                <div class="dropdown-item-desc">
                                    <div class="dropdownmsg d-flex">
                                        <div class="">
                                            <b>Ruth	Arnold</b>
                                            <p>Hi!, I' am web designer</p>
                                        </div>
                                        <div class="time"> 3 hours ago</div>
                                    </div>
                                </div>
                            </a>
                            <a href="index.html#" class="dropdown-item">
                                <img alt="image" src="assets/img/avatar/avatar-5.jpeg.jpg" class="rounded-circle dropdown-item-img">
                                <div class="dropdown-item-desc">
                                    <div class="dropdownmsg d-flex">
                                        <div class="">
                                            <b>Sam	Lyman</b>
                                            <p>Hi!, I' am java developer</p>
                                        </div>
                                        <div class="time"> 15 mintues ago</div>
                                    </div>
                                </div>
                            </a>
                        </div>
                    </div>
                </li>
                <li class="dropdown dropdown-list-toggle"><a href="index.html#" data-toggle="dropdown" class="nav-link  nav-link-lg beep"><i class="ion-ios-bell-outline"></i></a>
                    <div class="dropdown-menu dropdown-list dropdown-menu-right">
                        <div class="dropdown-header">Notifications
                            <div class="float-right">
                                <a href="index.html#">View All</a>
                            </div>
                        </div>
                        <div class="dropdown-list-content">
                            <a href="index.html#" class="dropdown-item">
                                <i class="fa fa-users text-primary"></i>
                                <div class="dropdown-item-desc">
                                    <b>So many Users Visit your template</b>
                                </div>
                            </a>
                            <a href="index.html#" class="dropdown-item">
                                <i class="fa fa-exclamation-triangle text-danger"></i>
                                <div class="dropdown-item-desc">
                                    <b>Error message occurred....</b>
                                </div>
                            </a>
                            <a href="index.html#" class="dropdown-item">
                                <i class="fa fa-users text-warning"></i>
                                <div class="dropdown-item-desc">
                                    <b> Adding new people</b>
                                </div>
                            </a>
                            <a href="index.html#" class="dropdown-item">
                                <i class="fa fa-shopping-cart text-success"></i>
                                <div class="dropdown-item-desc">
                                    <b>Your items Arrived</b>
                                </div>
                            </a>
                            <a href="index.html#" class="dropdown-item">
                                <i class="fa fa-comment text-primary"></i>
                                <div class="dropdown-item-desc">
                                    <b>New Message received</b> <div class="float-right"><span class="badge badge-pill badge-danger badge-sm">67</span></div>
                                </div>
                            </a>
                            <a href="index.html#" class="dropdown-item">
                                <i class="fa fa-users text-primary"></i>
                                <div class="dropdown-item-desc">
                                    <b>So many Users Visit your template</b>
                                </div>
                            </a>
                        </div>
                    </div>
                </li>
                <li class="dropdown dropdown-list-toggle">
                    <a href="index.html#" class="nav-link nav-link-lg full-screen-link">
                        <i class="ion-arrow-expand"  id="fullscreen-button"></i>
                    </a>
                </li>
                <li class="dropdown"><a href="index.html#" data-toggle="dropdown" class="nav-link dropdown-toggle nav-link-lg">
                    <!-- 用户头像 -->
                    <img src="assets/img/avatar/mifei.jpg" alt="profile-user" class="rounded-circle w-32">
                    <!-- 用户名称 -->
                    <div class="d-sm-none d-lg-inline-block">${admin.adminname}</div></a>
                    <div class="dropdown-menu dropdown-menu-right">
                        <a href="profile.html" class="dropdown-item has-icon">
                            <i class="ion ion-android-person"></i>个人信息
                        </a>
                        <a href="profile.html" class="dropdown-item has-icon">
                            <i class="ion-android-drafts"></i>消息
                        </a>
                        <a href="profile.html" class="dropdown-item has-icon">
                            <i class="ion ion-gear-a"></i>系统设置
                        </a>
                        <a href="index.html#" class="dropdown-item has-icon">
                            <i class="ion-ios-redo"></i>登出
                        </a>
                    </div>
                </li>
            </ul>
        </nav>

        <aside class="app-sidebar">
            <div class="app-sidebar__user">
                <div class="dropdown">
                    <a class="nav-link pl-2 pr-2 leading-none d-flex" data-toggle="dropdown" href="index.html#">
                        <!-- 用户头像 -->
                        <img alt="image" src="assets/img/avatar/mifei.jpg" class=" avatar-md rounded-circle">
                        <span class="ml-2 d-lg-block">
                                        <!-- 用户名称 -->
                                        <span class="text-white app-sidebar__user-name mt-5">米菲</span><br>
                                        <span class="text-muted app-sidebar__user-name text-sm">超级管理员</span>
                                    </span>
                    </a>
                </div>
            </div>
            <ul class="side-menu">
                <li class="slide">
                    <a class="side-menu__item"  data-toggle="slide" href="index.html#"><i class="side-menu__icon fa fa-desktop"></i><span class="side-menu__label">Dashboard</span><i class="angle fa fa-angle-right"></i></a>
                    <ul class="slide-menu">
                        <li><a class="slide-item"  href="index.html"><span>Dashboard 01</span></a></li>
                        <li><a class="slide-item" href="index2.html"><span>Dashboard 02</span></a></li>
                        <li><a class="slide-item" href="index3.html"><span>Dashboard 03</span></a></li>
                    </ul>
                </li>
                <li>
                    <a class="side-menu__item" href="widgets.html"><i class="side-menu__icon fa fa-flask"></i><span class="side-menu__label">Widgets</span></a>
                </li>
                <li class="slide">
                    <a class="side-menu__item" data-toggle="slide" href="index.html#"><i class="side-menu__icon fa fa-tasks"></i><span class="side-menu__label">UI Elements</span><i class="angle fa fa-angle-right"></i></a>
                    <ul class="slide-menu">
                        <li><a href="elements.html" class="slide-item"> Elements</a></li>
                        <li><a href="buttons.html" class="slide-item"> Buttons</a></li>
                        <li><a href="toastr.html" class="slide-item"> Toastr</a></li>
                        <li><a href="calender.html" class="slide-item"> Calendar</a></li>
                        <li><a href="rangesliders.html" class="slide-item"> Rangeslider</a></li>
                        <li><a href="modals.html" class="slide-item"> Modals</a></li>
                        <li><a href="timeline.html" class="slide-item"> Timeline</a></li>
                        <li><a href="invoice.html" class="slide-item"> Invoice</a></li>
                        <li><a href="users.html" class="slide-item"> Users List</a></li>
                        <li><a href="mailinbox.html" class="slide-item"> Mail-inbox</a></li>
                        <li><a href="mail-compose.html" class="slide-item"> Mail-Compose</a></li>
                    </ul>
                </li>
                <li class="slide">
                    <a class="side-menu__item" data-toggle="slide" href="index.html#"><i class="side-menu__icon fa fa-paw"></i><span class="side-menu__label">Icons</span><i class="angle fa fa-angle-right"></i></a>
                    <ul class="slide-menu">
                        <li><a href="icons-ion.html" class="slide-item"> Ion Icons</a></li>
                        <li><a href="icons-fontawesome.html" class="slide-item"> Font Awesome</a></li>
                        <li><a href="icons-feather.html" class="slide-item"> Feather Awesome</a></li>
                        <li><a href="icons-materialdesign.html" class="slide-item"> Material Design</a></li>
                        <li><a href="icons-themify.html" class="slide-item"> Themify</a></li>
                        <li><a href="icons-simpleline.html" class="slide-item"> Simple line</a></li>
                        <li><a href="icons-pe7.html" class="slide-item"> pe7</a></li>
                        <li><a href="icons-flag.html" class="slide-item"> Flag Icons</a></li>
                        <li><a href="icons-weather.html" class="slide-item"> Weather Icons</a></li>
                        <li><a href="icons-typicons.html" class="slide-item"> Typicons</a></li>
                    </ul>
                </li>
                <li class="slide">
                    <a class="side-menu__item" data-toggle="slide" href="index.html#"><i class="side-menu__icon fa fa-table"></i><span class="side-menu__label">Tables</span><i class="angle fa fa-angle-right"></i></a>
                    <ul class="slide-menu">
                        <li><a href="table.html" class="slide-item">Basic Tables</a></li>
                        <li><a href="datatables.html" class="slide-item"> Data Tables</a></li>
                    </ul>
                </li>
                <li class="slide">
                    <a class="side-menu__item" data-toggle="slide" href="index.html#"><i class="side-menu__icon fa fa-file-text"></i><span class="side-menu__label">Forms</span><i class="angle fa fa-angle-right"></i></a>
                    <ul class="slide-menu">
                        <li><a href="formelements.html" class="slide-item"> Form Elements</a></li>
                        <li><a href="formadvanced.html" class="slide-item"> Advanced Form</a></li>
                        <li><a href="formeditor.html" class="slide-item"> Form Editor</a></li>
                    </ul>
                </li>
                <li class="slide">
                    <a class="side-menu__item" data-toggle="slide" href="index.html#"><i class="side-menu__icon fa fa-bar-chart"></i><span class="side-menu__label">Charts</span><i class="angle fa fa-angle-right"></i></a>
                    <ul class="slide-menu">
                        <li><a href="chartjs.html" class="slide-item">Chart Js</a></li>
                        <li><a href="flotcharts.html" class="slide-item"> Flot Charts</a></li>
                        <li><a href="barcharts.html" class="slide-item"> Bar Charts</a></li>
                        <li><a href="echart.html" class="slide-item"> ECharts</a></li>
                        <li><a href="chartist.html" class="slide-item"> Chartist</a></li>
                        <li><a href="morris.html" class="slide-item"> Morris Charts</a></li>
                        <li><a href="othercharts.html" class="slide-item"> Other Charts</a></li>
                    </ul>
                </li>
                <li class="slide">
                    <a class="side-menu__item" data-toggle="slide" href="index.html#"><i class="side-menu__icon fa fa-map"></i><span class="side-menu__label">Maps</span><i class="angle fa fa-angle-right"></i></a>
                    <ul class="slide-menu">
                        <li><a href="maps.html" class="slide-item"> Google Maps</a></li>
                        <li><a href="vector-map.html" class="slide-item">Vector Maps</a></li>
                    </ul>
                </li>
                <li class="slide">
                    <a class="side-menu__item" data-toggle="slide" href="index.html#"><i class="side-menu__icon fa fa-pie-chart"></i><span class="side-menu__label">Pages</span><i class="angle fa fa-angle-right"></i></a>
                    <ul class="slide-menu">
                        <li><a href="profile.html" class="slide-item"> Profile</a></li>
                        <li><a href="pricing-tables.html" class="slide-item"> Pricing Tables</a></li>
                        <li><a href="gallery.html" class="slide-item"> Gallery</a></li>
                        <li><a href="shop.html" class="slide-item"> Shop</a></li>
                        <li><a href="shop-cart.html" class="slide-item"> Shop Cart</a></li>
                        <li><a href="terms.html" class="slide-item"> Terms and Conditions</a></li>
                        <li><a href="register.html" class="slide-item"> Register</a></li>
                        <li><a href="login.html" class="slide-item"> Login</a></li>
                        <li><a href="forgot.html" class="slide-item"> Forgot Password</a></li>
                        <li><a href="reset.html" class="slide-item"> Reset Password</a></li>
                        <li><a href="under-construction.html" class="slide-item"> Under Construction</a></li>
                        <li><a href="lockscreen.html" class="slide-item"> Lock Screen</a></li>
                        <li><a href="404.html" class="slide-item"> 404</a></li>
                        <li><a href="505.html" class="slide-item"> 505</a></li>
                        <li><a href="emptypage.html" class="slide-item"> Empty  Page</a></li>
                    </ul>
                </li>
            </ul>
        </aside>

        <div class="app-content">
            <section class="section">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="index.html#" class="text-muted">Home</a></li>
                    <li class="breadcrumb-item active text-" aria-current="page">Dashboard 01</li>
                </ol>

                <div class="row">
                    <div class="col-lg-6 col-xl-3 col-md-6 col-sm-6 col-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-6">
                                        <div class="dash1">
                                            <h4 class="text-dark">675</h4>
                                            <small class="text-muted ">Posts</small>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div id="chart1" class="overflow-hidden"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-xl-3 col-md-6 col-sm-6 col-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-6">
                                        <div class="dash1">
                                            <h4 class="text-dark">875</h4>
                                            <small class="text-muted">Clicks</small>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div id="chart2" class="overflow-hidden"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-xl-3 col-md-6 col-sm-6 col-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-6">
                                        <div class="dash1">
                                            <h4 class="text-dark">976</h4>
                                            <small class="text-muted">Shares</small>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div id="chart3" class="overflow-hidden"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-xl-3 col-md-6 col-sm-6 col-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-6">
                                        <div class="dash1">
                                            <h4 class="text-dark">418</h4>
                                            <small class="text-muted">Remarks</small>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div id="chart4" class="overflow-hidden"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>



                <div class="row ">
                    <div class="col-lg-12 col-xl-6 col-md-12 col-12 col-sm-12">
                        <div class="card">
                            <div class="card-header">
                                <h4>Monthly Sales</h4>
                            </div>
                            <div class="card-body">
                                <div id="bar-chart" class="overflow-hidden" > </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12 col-xl-6 col-md-12 col-12 col-sm-12">
                        <div class="card">
                            <div class="card-header">
                                <h4>Yearly Template Sales</h4>
                            </div>
                            <div class="card-body">
                                <div id="sales-chart" class="overflow-hidden"> </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12 col-sm-12">
                        <div class="card">
                            <div class="card-header">
                                <h4>Account Retention</h4>
                            </div>
                            <div class="card-body">
                                <div id="index" class="overflow-hidden h-400 mx-auto text-center " ></div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-12 col-xl-8 col-md-12 col-12 col-sm-12">
                        <div class="card">
                            <div class="pt-0 pb-0 pl-3 pr-3 card-body">
                                <div class="row">
                                    <div class="col-xs-12 col-lg-5 cover-image weather-radius text-center position-relative transparent" data-image-src="assets/img/weather.jpg">
                                        <div class="weather-shade">
                                            <i class="wi wi-day-sleet text-white"></i>
                                        </div>
                                        <div class="card-body mt-5 pt-5">
                                            <i class="vl_weather-day-rain text-light  mt-5 pt-5 d-block"></i>
                                        </div>
                                        <div class="bg-transparent border-0 text-light  pt-4">
                                            <h3 class="weight300">Sunny Day</h3>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 col-lg-7 widgetb p-0">
                                        <div class="card-body p-4">
                                            <h4 class="mb-0">MONDAY <br/>
                                                <span class="text-muted h5"> 22  October</span>
                                            </h4>
                                            <div class="fs-45 text-primary pt-4 ">
                                                32<sup>o</sup>
                                                <span class="h3 ">Sunny</span>
                                            </div>
                                        </div>
                                        <div class="card-footer bg-white text-center ">
                                            <div class="row">
                                                <div class="col-sm-2 col-4 mt-2 pb-2">
                                                    <h6 class="text-muted mb-3">TUE</h6>
                                                    <i class="fe fe-cloud-rain"></i>
                                                    <p class="mb-0 text-muted">18<sup>o</sup>c</p>
                                                </div>
                                                <div class="col-sm-2 col-4 mt-2 pb-2">
                                                    <h6 class="text-muted mb-3">WED</h6>
                                                    <i class="fe fe-cloud"></i>
                                                    <p class="mb-0 text-muted">22<sup>o</sup>c</p>
                                                </div>
                                                <div class="col-sm-2 col-4 mt-2 pb-2">
                                                    <h6 class="text-muted mb-3">THU</h6>
                                                    <i class="fe fe-cloud-snow"></i>
                                                    <p class="mb-0 text-muted">15<sup>o</sup>c</p>
                                                </div>
                                                <div class="col-sm-2 col-4 mt-2 pb-2">
                                                    <h6 class="text-muted mb-3">FRI</h6>
                                                    <i class="fe fe-cloud-rain"></i>
                                                    <p class="mb-0 text-muted">19<sup>o</sup>c</p>
                                                </div>
                                                <div class="col-sm-2 col-4 mt-2 pb-2">
                                                    <h6 class="text-muted mb-3">SAT</h6>
                                                    <i class="fe fe-cloud"></i>
                                                    <p class="mb-0 text-muted">29<sup>o</sup>c</p>
                                                </div>
                                                <div class="col-sm-2 col-4 mt-2 pb-2">
                                                    <h6 class="text-muted mb-3">SUN</h6>
                                                    <i class="fe fe-cloud-snow"></i>
                                                    <p class="mb-0 text-muted">17<sup>o</sup>c</p>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-12 col-xl-4 col-md-12 col-12 col-sm-12">
                        <div class="card">
                            <div id="calendar-1"></div>
                        </div>
                    </div>
                </div>

            </section>
        </div>

        <footer class="main-footer">
            <div class="text-center">
                Copyright &copy;Kharna-Admin 2018. Design By更多模板：<a href="http://www.mycodes.net/" target="_blank">源码之家</a>
            </div>
        </footer>

    </div>
</div>

<!--Jquery.min js-->
<script src="assets/js/jquery.min.js"></script>

<!--popper js-->
<script src="assets/js/popper.js"></script>

<!--Tooltip js-->
<script src="assets/js/tooltip.js"></script>

<!--Bootstrap.min js-->
<script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>

<!--Jquery.nicescroll.min js-->
<script src="assets/plugins/nicescroll/jquery.nicescroll.min.js"></script>

<!--Scroll-up-bar.min js-->
<script src="assets/plugins/scroll-up-bar/dist/scroll-up-bar.min.js"></script>

<!--Sidemenu js-->
<script src="assets/plugins/toggle-menu/sidemenu.js"></script>

<!--mCustomScrollbar js-->
<script src="assets/plugins/scroll-bar/jquery.mCustomScrollbar.concat.min.js"></script>

<!-- ECharts -->
<script src="assets/plugins/echarts/dist/echarts.js"></script>

<!--Min Calendar -->
<script src="assets/plugins/fullcalendar/calendar.min.js"></script>
<script src="assets/plugins/fullcalendar/custom_calendar.js"></script>

<!--Morris js-->
<script src="assets/plugins/morris/morris.min.js"></script>
<script src="assets/plugins/morris/raphael.min.js"></script>

<!--Scripts js-->
<script src="assets/js/scripts.js"></script>

<!--Dashboard js-->
<script src="assets/js/dashboard.js"></script>
<script src="assets/js/apexcharts.js"></script>
</body>
</html>
