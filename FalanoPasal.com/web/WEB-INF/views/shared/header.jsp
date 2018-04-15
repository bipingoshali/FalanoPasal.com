<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!--fetching jstl tag library-->
<c:set var="SITE_URL" value="${pageContext.request.contextPath}" /> <!--access jsp file from different directories-->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FalanoPasal.com</title>
        
        <!-- Bootstrap core CSS -->
        <link href="${SITE_URL}/static/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        
    </head>
    
    <body style="padding-top: 70px;">
        
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
                <a class="navbar-brand" href="${SITE_URL}/">FalanoPasal.com</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${SITE_URL}/">Home</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="${SITE_URL}/login">Login</a></li>
                    <li><a href="${SITE_URL}/register">Register</a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </nav>    



