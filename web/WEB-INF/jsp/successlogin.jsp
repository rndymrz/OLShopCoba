<%-- 
    Document   : success
    Created on : Oct 18, 2017, 3:09:38 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ASDASD Shop</title>
        <link rel="icon" href="https://www.bluematrixmedia.com/wp-content/uploads/2015/12/Retail-eCommerce-Icon.png">
        <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    </head>
    <body>
        <jsp:include page="head.jsp"/> 
        <div class="container">
            <h1>${user.username}, We've Got Some New Stuffs Coming In!! Check it Out!!!</h1>
            
            <p><h1 align="center"><a href="${pageContext.request.contextPath}/product/all">CLICK HERE!!!!</a></h1></p>
        </div>
    </body>
</html>
