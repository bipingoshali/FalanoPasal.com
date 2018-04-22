<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!--fetching jstl tag library-->
<c:set var="SITE_URL" value="${pageContext.request.contextPath}" /> <!--access jsp file from different directories-->

<!--spring form tag libraries-->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FalanoPasal.com</title>
        
        <!-- Bootstrap core CSS -->
        <link href="${SITE_URL}/static/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!--Custom css-->
        <link href="${SITE_URL}/static/css/custom.css" rel="stylesheet" type="text/css" />
        <!--JQuery-->
        <script src="${SITE_URL}/static/js/jquery-3.2.1.min.js"></script>
        
    </head>
    
    <body>
    <!-- Fixed navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${SITE_URL}/user/home">FalanoPasal.com</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="${SITE_URL}/user/home">Home</a></li>
                    <li><a href="${SITE_URL}/user/orderHistory">Order History</a></li>
                    <li><a href="${SITE_URL}/user/offer">Offer</a></li>
                    <li><a href="${SITE_URL}/user/subscription">Subscription</a></li>
                    <li><a href="${SITE_URL}/user/package">Package</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${SITE_URL}/user/shoppingCart" ><span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart</a></li>
                    <li><a href="${SITE_URL}/user/profile">Hy ${username}</a></li>
                    <li><a href="${SITE_URL}/logout">Logout</a></li>
                    <!--<li class="active"><a href="abc.html">Welcome <span class="sr-only">(current)</span></a></li>-->
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </nav>    
<!--Page Content-->
<div class="container">

