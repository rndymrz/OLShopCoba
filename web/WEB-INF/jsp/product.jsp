<%-- 
    Document   : product
    Created on : Dec 14, 2017, 10:20:14 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product</title>
        <link rel="icon" href="https://www.bluematrixmedia.com/wp-content/uploads/2015/12/Retail-eCommerce-Icon.png">
        <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="head.jsp"/> 
        <div class="container">
            <h1>${dftrprdk}</h1>
        </div>
        
    </body>
</html>
