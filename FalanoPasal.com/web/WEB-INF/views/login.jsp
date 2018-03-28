<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}" />
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FalanoPasal.com</title>

        <!-- Bootstrap core CSS -->
        <link href="${SITE_URL}/static/css/bootstrap.min.css" rel="stylesheet" type="text/css" />

    </head>
    <body style="background-color: #f9f9f9;">

        <div class="container" style="padding-top: 15px;">
        <h1 style="text-align: center;margin: 40px 0px 30px 0px;">Sign in to FalanoPasal</h1>

            <!-- Login form message -->
            <h3 style="text-align: center;"><c:out value="${message}"></c:out></h3>
            
                <div class="panel panel-primary" style="width:400px;margin:0px auto;padding:10px;">
                    <div class="panel-heading">Login</div>
                    <div class="panel-body">
                        <spring:url value="/checkLogin" var="loginURL" />            
                        <form:form method="post" action="${loginURL}" modelAttribute="login">
                        <div class="form-group">
                            <label class="control-label" for="inputUsername">Username</label>
                            <form:input class="form-control" path="username" id="inputUsername" placeholder="Username"  type="text" required="required" />                            
                        </div>
                        <div class="form-group">
                            <label class="control-label" for="inputPassword">Password</label>
                            <form:input class="form-control" path="password" id="inputPassword" placeholder="Password"  type="password" required="required" />                            
                        </div>
                        <div class="checkbox">
                            <label id="inputRememberMe">
                                <form:checkbox id="inputRememberMe" path="rememberme" value="rememberme"/><b> Remember me</b>
                                <!--<input id="inputRememberMe" type="checkbox" name="rememberme" value="rememberme"/><b> Remember me</b>-->
                            </label>
                        </div>
                        <div class="form-group">
                            <div class="row">
                                <button class="btn btn-primary" type="submit" style="margin-left: 13px;">
                                    Submit
                                </button>
                                <a href="${SITE_URL}/" class="btn btn-danger">
                                    Back
                                </a>
                            </div>
                        </div>
                                    <div>
                                        <p>New to FalanoPasal? <a href="${SITE_URL}/register">Create an account</a>.</p>
                                    </div>
                    </form:form>

                </div>
            </div>
        </div>
    </body>
</html>
