<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <style>

        
        body {margin: 0;}

        ul.topnav {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #667387;
        }

        ul.topnav li {float: left;}

        ul.topnav li a {
            display: block;
            color: white;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        ul.topnav li a:hover:not(.active) {background-color: #5d7191;}

        ul.topnav li a.active {background-color: #276ddd;}

        ul.topnav li.right {
            float: right;
        }

        @media screen and (max-width: 600px){
            ul.topnav li.right, 
            ul.topnav li {float: none;}
        }
    </style>
   
    <ul class="topnav">
        <li><a class="active" href="${pageContext.request.contextPath}">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/product">Daftar Produk</a></li>
        <li><a href="${pageContext.request.contextPath}/detailproduk">Detail Produk</a></li>
        <li class="right" ><a href="${pageContext.request.contextPath}/cart">Cart</a></li>
    </ul>

    <div class="jumbotron"  style="background-image: url(http://www.truthmedia.gr/sites/default/files/online-shopping-ecommerce-ss-1920_1.png); background-size: 100%;">

        <h1 align = "center" >ASDASD Online Shop</h1> 
        <p>A New OLShop in Town</p> 
        
        <c:if test="${not empty sessionScope.user}">
            <div><a href="${pageContext.request.contextPath}/logout">Logout</a></div>
        </c:if>

    </div>

</div>