<%-- 
    Document   : home
    Created on : Mar 28, 2018, 10:22:50 PM
    Author     : bipin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h3 style="text-align: center;"><c:out value="${message}"></c:out></h3>
        <a href="${SITE_URL}/logout"><button>Logout</button></a>
    </body>
</html>
