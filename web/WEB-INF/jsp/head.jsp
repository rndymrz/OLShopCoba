<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <div class="jumbotron"  style="background-image: url(http://www.truthmedia.gr/sites/default/files/online-shopping-ecommerce-ss-1920_1.png); background-size: 100%;">
        <h1>ASDASD Online Shop</h1> 
        <p>A New OLShop in Town</p> 
        <div><a href="${pageContext.request.contextPath}">Home</a></div>
        <c:if test="${not empty sessionScope.user}">
            <div><a href="${pageContext.request.contextPath}/logout">Logout</a></div>
        </c:if>

    </div>

</div>