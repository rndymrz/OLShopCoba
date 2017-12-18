<%-- 
    Document   : carts
    Created on : Dec 18, 2017, 2:27:54 PM
    Author     : user
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carts</title>
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
            
            <div class="table-responsive">  
            
            <table id="produk">
                <thead>
                    <tr>
                        <th>Nama Produk</th>
                        <th>Harga</th>
                        <th></th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="d" items="${cart.carts}">
                        <tr>

                            <td>${d.value.namaproduct}</td>
                            <td>${d.value.harga}</td>
                            <td><a href="${pageContext.request.contextPath}/cart/${d.value.id}/${d.key}"><i class="fa d-inline fa-lg fa-shopping-cart"></i> Hapus dari Cart </a></td>

                        </tr>
                    </c:forEach>

                

                </tbody>
            </table>
            
            <h1>Total Belanjaan : Rp ${carts}</h1>
            
        </div>

            <button href="${pageContext.request.contextPath}/product" class="btn btn-danger">Bayar</button>
            
        </div>

            
    </body>
</html>
