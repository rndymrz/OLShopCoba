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

        <style>
            #produk {
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            #produk td, #produk th {
                border: 1px solid #ddd;
                padding: 8px;
            }

            #produk tr:nth-child(even){background-color: #f2f2f2;}

            #produk tr:hover {background-color: #ddd;}

            #produk th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: left;
                background-color: #6495ed;
                color: white;
            }
        </style>

    </head>
    <body>
        <jsp:include page="head.jsp"/> 
        <div class="container">
            <table id="produk">
                <tr>
                    <th>Nama Produk</th>
                    <th>Harga</th>
                    <th>Gambar</th>
                    <th>Aksi</th>

                    <c:forEach var="d" items="${product}">
                    </tr>
                    <tr>
                        <td>${d.namaproduct}</td>
                        <td>Rp ${d.harga}</td>
                        <td><img src="<c:url value="/resources/mawar/${d.gambar}" />" width="100" height="100"/> </td>
                        <td> 
                            <c:if test="${empty sessionScope.user}">
                        <li><a href="${pageContext.request.contextPath}/login"><button class="btn btn-primary" >Add to cart</button></a></li>


                    </c:if>
                    <c:if test="${not empty sessionScope.user}">
                        <a href="${pageContext.request.contextPath}/cart/add/${d.id}" ><button class="btn btn-primary">Add to cart</button> </a>

                    </c:if> 
                    </td>   
                    </tr>
                </c:forEach>
            </table>


        </div>





    </body>
</html>
