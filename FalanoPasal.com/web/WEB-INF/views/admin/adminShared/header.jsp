<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}" />
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin | FalanoPasal</title>
        <!-- Bootstrap core CSS -->
        <link href="${SITE_URL}/static/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

        <!-- admin custom CSS -->
        <link href="${SITE_URL}/static/css/adminCustom.css" rel="stylesheet" type="text/css" />

        <!--JQuery-->
        <script src="${SITE_URL}/static/js/jquery-3.2.1.min.js"></script>
        <!--Custom JQuery-->
        <script src="${SITE_URL}/static/js/custom.js"></script>        

    </head>

    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${SITE_URL}/admin/home">FalanoPasal.com</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">Dashboard</a></li>
                        <li><a href="#">Settings</a></li>
                        <li><a href="#">Hy ${username}</a></li>
                        <li><a href="${SITE_URL}/logout">Logout</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-3 col-md-2 sidebar">
                    <ul class="nav nav-sidebar">
                        <li><a href="#">Overview</a></li>
                        <li><a href="${SITE_URL}/admin/category">Category</a></li>
                        <li><a href="${SITE_URL}/admin/product">Product</a></li>
                        <li><a href="${SITE_URL}/admin/productImage">Product Image</a></li>
                    </ul>
                    <ul class="nav nav-sidebar">
                        <li><a href="${SITE_URL}/admin/order">Order</a></li>
                        <li><a href="${SITE_URL}/admin/customer">Customer</a></li>
                        <li><a href="${SITE_URL}/admin/offer">Offer and Discount</a></li>
                        <li><a href="${SITE_URL}/admin/package">Package</a></li>
                        <li><a href="">More navigation</a></li>
                    </ul>
                    <ul class="nav nav-sidebar">
                        <li><a href="">Nav item again</a></li>
                        <li><a href="">One more nav</a></li>
                        <li><a href="">Another nav item</a></li>
                    </ul>
                </div>  
                <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

