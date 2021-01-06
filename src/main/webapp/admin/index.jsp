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
    <link rel="icon" href="../assets/img/favicon.ico" type="image/x-icon"/>

    <!--Bootstrap.min css-->
    <link rel="stylesheet" href="../assets/plugins/bootstrap/css/bootstrap.min.css">

    <!--Icons css-->
    <link rel="stylesheet" href="../assets/css/icons.css">

    <!--Style css-->
    <link rel="stylesheet" href="../assets/css/style.css">

    <!--mCustomScrollbar css-->
    <link rel="stylesheet" href="../assets/plugins/scroll-bar/jquery.mCustomScrollbar.css">

    <!--Sidemenu css-->
    <link rel="stylesheet" href="../assets/plugins/toggle-menu/sidemenu.css">

    <!--Chartist css-->
    <link rel="stylesheet" href="../assets/plugins/chartist/chartist.css">
    <link rel="stylesheet" href="../assets/plugins/chartist/chartist-plugin-tooltip.css">

    <!--Full calendar css-->
    <link rel="stylesheet" href="../assets/plugins/fullcalendar/stylesheet1.css">

    <!--morris css-->
    <link rel="stylesheet" href="../assets/plugins/morris/morris.css">

    <%--layui--%>
    <link rel="stylesheet" href="../assets/plugins/layui/css/layui.css" />

    <style>
        .layui-nav{
            width: 100% !important;
            background-color:white !important;

        }

        .layui-nav .layui-nav-mored, .layui-nav-itemed>a .layui-nav-more {
            margin-top: -9px;
            border-style: dashed dashed solid;
            border-color: transparent transparent black !important;
        }

        .layui-nav-more{
            border-top-color: black !important;
        }

        .layui-nav-item a{
            color: black !important;
        }

        .layui-nav-item a:hover{
            color: white !important;
        }

        .tab-close {
            position: absolute;
            right: -2px;
            top: 0;
            display: inline;
            opacity: 0.2;
        }
        .tab-close:hover {
            opacity: 1;
        }

        a:hover{
            text-decoration: none;
        }

        .wh100 {
            width: 100%;
        }
    </style>
</head>

<body class="app " onresize="iframesize()">

<div id="spinner"></div>

<div id="app">
    <div class="main-wrapper" >
        <nav class="navbar navbar-expand-lg main-navbar">
            <a class="header-brand" href="../index.html">
                <!-- logo图片 -->
                <img src="../assets/img/brand/website_logo.png" class="header-brand-img" alt="Kharna-Admin  logo">
            </a>
            <form class="form-inline mr-auto">
                <ul class="navbar-nav mr-3">
                    <li><a href="../index.html#" data-toggle="sidebar" class="nav-link nav-link-lg"><i class="ion ion-navicon-round"></i></a></li>
                    <li><a href="../index.html#" data-toggle="search" class="nav-link nav-link-lg d-md-none navsearch"><i class="ion ion-search"></i></a></li>
                </ul>
                <!-- 搜索 -->
                <div class="search-element">
                    <input class="form-control" type="search" placeholder="搜索" aria-label="Search">
                    <button class="btn btn-primary" type="submit"><i class="ion ion-search"></i></button>
                </div>
            </form>
            <ul class="navbar-nav navbar-right">
                <li class="dropdown dropdown-list-toggle"><a href="../index.html#" data-toggle="dropdown" class="nav-link notification-toggle nav-link-lg beep"><i class="ion-ios-email-outline"></i></a>
                    <div class="dropdown-menu dropdown-list dropdown-menu-right">
                        <div class="dropdown-header">Messages
                            <div class="float-right">
                                <a href="../index.html#">View All</a>
                            </div>
                        </div>
                        <div class="dropdown-list-content">
                            <a href="../index.html#" class="dropdown-item dropdown-item-unread">
                                <img alt="image" src="../assets/img/avatar/avatar-1.jpeg.jpg" class="rounded-circle dropdown-item-img">
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
                            <a href="../index.html#" class="dropdown-item dropdown-item-unread">
                                <img alt="image" src="../assets/img/avatar/avatar-2.jpeg.jpg" class="rounded-circle dropdown-item-img">
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
                            <a href="../index.html#" class="dropdown-item">
                                <img alt="image" src="../assets/img/avatar/avatar-4.jpeg.jpg" class="rounded-circle dropdown-item-img">
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
                            <a href="../index.html#" class="dropdown-item">
                                <img alt="image" src="../assets/img/avatar/avatar-3.jpeg.jpg" class="rounded-circle dropdown-item-img">
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
                            <a href="../index.html#" class="dropdown-item">
                                <img alt="image" src="../assets/img/avatar/avatar-5.jpeg.jpg" class="rounded-circle dropdown-item-img">
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
                <li class="dropdown dropdown-list-toggle"><a href="../index.html#" data-toggle="dropdown" class="nav-link  nav-link-lg beep"><i class="ion-ios-bell-outline"></i></a>
                    <div class="dropdown-menu dropdown-list dropdown-menu-right">
                        <div class="dropdown-header">Notifications
                            <div class="float-right">
                                <a href="../index.html#">View All</a>
                            </div>
                        </div>
                        <div class="dropdown-list-content">
                            <a href="../index.html#" class="dropdown-item">
                                <i class="fa fa-users text-primary"></i>
                                <div class="dropdown-item-desc">
                                    <b>So many Users Visit your template</b>
                                </div>
                            </a>
                            <a href="../index.html#" class="dropdown-item">
                                <i class="fa fa-exclamation-triangle text-danger"></i>
                                <div class="dropdown-item-desc">
                                    <b>Error message occurred....</b>
                                </div>
                            </a>
                            <a href="../index.html#" class="dropdown-item">
                                <i class="fa fa-users text-warning"></i>
                                <div class="dropdown-item-desc">
                                    <b> Adding new people</b>
                                </div>
                            </a>
                            <a href="../index.html#" class="dropdown-item">
                                <i class="fa fa-shopping-cart text-success"></i>
                                <div class="dropdown-item-desc">
                                    <b>Your items Arrived</b>
                                </div>
                            </a>
                            <a href="../index.html#" class="dropdown-item">
                                <i class="fa fa-comment text-primary"></i>
                                <div class="dropdown-item-desc">
                                    <b>New Message received</b> <div class="float-right"><span class="badge badge-pill badge-danger badge-sm">67</span></div>
                                </div>
                            </a>
                            <a href="../index.html#" class="dropdown-item">
                                <i class="fa fa-users text-primary"></i>
                                <div class="dropdown-item-desc">
                                    <b>So many Users Visit your template</b>
                                </div>
                            </a>
                        </div>
                    </div>
                </li>
                <li class="dropdown dropdown-list-toggle">
                    <a href="../index.html#" class="nav-link nav-link-lg full-screen-link">
                        <i class="ion-arrow-expand"  id="fullscreen-button"></i>
                    </a>
                </li>
                <li class="dropdown"><a href="../index.html#" data-toggle="dropdown" class="nav-link dropdown-toggle nav-link-lg">
                    <!-- 用户头像 -->
                    <img src="../assets/img/avatar/${admin.adminimg}" alt="profile-user" class="rounded-circle w-32">
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
                        <a href="../index.html#" class="dropdown-item has-icon">
                            <i class="ion-ios-redo"></i>登出
                        </a>
                    </div>
                </li>
            </ul>
        </nav>

        <aside class="app-sidebar">
            <div class="app-sidebar__user">
                <div class="dropdown">
                    <a class="nav-link pl-2 pr-2 leading-none d-flex" data-toggle="dropdown" href="../index.html#">
                        <!-- 用户头像 -->
                        <img alt="image" src="../assets/img/avatar/${admin.adminimg}" class=" avatar-md rounded-circle">
                        <span class="ml-2 d-lg-block">
                                        <!-- 用户名称 -->
                                        <span class="text-white app-sidebar__user-name mt-5">${admin.adminname}</span><br>
                                        <span class="text-muted app-sidebar__user-name text-sm">${admin.compellation}</span>
                                    </span>
                    </a>
                </div>
            </div>
            <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="demo" style="margin-right: 10px;">
                <c:forEach items="${menulist}" var="menuinfo">
                    <li class="layui-nav-item">
                        <a href="javascript:void(0);">${menuinfo.title}</a>
                        <dl class="layui-nav-child">
                            <c:forEach items="${menuinfo.menulist}" var="menuinfos">
                                <dd><a href="javascript:;" class="tab-active" title="${menuinfos.title}" lay-id="${menuinfos.menuid}" lay-url="${menuinfos.url}">${menuinfos.title}</a></dd>
                            </c:forEach>
                        </dl>
                    </li>
                </c:forEach>
            </ul>
        </aside>

        <div class="app-content">
            <div class="layui-tab layui-tab-brief" lay-filter="tab">
                <ul class="layui-tab-title">
                    <li class="layui-this" lay-id="0">首页</li>
                </ul>
                <div class="layui-tab-content" style="min-height: 500px;">
                    <div class="layui-tab-item layui-show">
                        <section class="section">
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
                </div>
            </div>
        </div>



    </div>
</div>

<!--Jquery.min js-->
<script src="../assets/js/jquery.min.js"></script>

<!--popper js-->
<script src="../assets/js/popper.js"></script>

<!--Tooltip js-->
<script src="../assets/js/tooltip.js"></script>

<!--Bootstrap.min js-->
<script src="../assets/plugins/bootstrap/js/bootstrap.min.js"></script>

<!--Jquery.nicescroll.min js-->
<script src="../assets/plugins/nicescroll/jquery.nicescroll.min.js"></script>

<!--Scroll-up-bar.min js-->
<script src="../assets/plugins/scroll-up-bar/dist/scroll-up-bar.min.js"></script>

<!--Sidemenu js-->
<script src="../assets/plugins/toggle-menu/sidemenu.js"></script>

<!--mCustomScrollbar js-->
<script src="../assets/plugins/scroll-bar/jquery.mCustomScrollbar.concat.min.js"></script>

<!-- ECharts -->
<script src="../assets/plugins/echarts/dist/echarts.js"></script>

<!--Min Calendar -->
<script src="../assets/plugins/fullcalendar/calendar.min.js"></script>
<script src="../assets/plugins/fullcalendar/custom_calendar.js"></script>

<!--Morris js-->
<script src="../assets/plugins/morris/morris.min.js"></script>
<script src="../assets/plugins/morris/raphael.min.js"></script>

<!--Scripts js-->
<script src="../assets/js/scripts.js"></script>

<!--Dashboard js-->
<script src="../assets/js/dashboard.js"></script>
<script src="../assets/js/apexcharts.js"></script>


<%--layui js--%>
<script src="../assets/plugins/layui/layui.all.js" ></script>

<script>

    var element = layui.element;
    var method = {
        tabAdd:function (url,name,id) {
            element.tabAdd('tab',{
                title:name+'<a href="javascript:;" class="tab-close"><i class="layui-icon layui-icon-close"></i></a>',
                content:'<iframe class="wh100"  frameborder="0" src="' + url + '"></iframe>',
                id: id
            });
            //为关闭按钮绑定事件
            $('.tab-close').click(function () {
                method.tabDelete($(this).parent('li').attr('lay-id'));
            });
            //新增tab后，改变选中tab
            method.tabChange(id);
        }, tabChange: function (id) {
            element.tabChange('tab', id); // 'tab'为layui-tab所在div的lay-fiilter
        },
        tabDelete: function (id) {
            element.tabDelete('tab', id); // 'tab'为layui-tab所在div的lay-fiilter
        }
    };


    //绑定点击事件
    $('.tab-active').click(function(){
        //获取属性值
        var id = $(this).attr('lay-id'), name = $(this).attr('title'), url = $(this).attr('lay-url');
        console.log(id + "--" + name + "--" + url);
        //    判断是否已打开
        if (checkTab(id)) {
            method.tabChange(id);
        } else {
            method.tabAdd(url, name, id);
        }
        /*调整iframe高度*/
        iframesize();
    });

    function checkTab(id) {
        var lis = $('.layui-tab-title li:gt(0)'), //获取到除主页的tab
            open = false; //用于判断是否已打开
            layui.each(lis, function (index, li) {
                if ($(li).attr('lay-id') == id) {//说明已打开
                    open = true;  //此处不能直接return
                }
            })
        return open;
    }
    /*iframe自适应*/
    function iframesize() {
        var iframeheight =$(window).height()-200;
        $(".wh100").height(iframeheight);
    }
</script>
</body>
</html>
