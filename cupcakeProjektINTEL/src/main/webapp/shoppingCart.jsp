<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>

<html>
<head>
    <title>ShoppingCart</title>
</head>
<body class="cartBody">
<p>Hello</p>


<div class="shoppingCart">



    <table class="orders-table">
        <thead class="orders-th">
        <td>Topping</td>
        <td>Bottom</td>
        <td>Quantity</td>
        <td>Price</td>
        <td></td>


        </thead>
        <c:forEach var="orders" items="${sessionScope.basket}">
            <tr class="orders-tr">

                <td>${orders.topping}</td>
                <td>${orders.bottom}</td>
                <td>

                    <button class="btn-add" type="button" name="button">
                        <img src="https://cdn0.iconfinder.com/data/icons/ui-16px-perfect-megapack-line/16/82_Add-512.png" alt="" />
                    </button>
                    <input type="text" name="amount" value="${orders.quantity}">
                    <button class="btn-minus" type="button" name="button">
                        <img src="https://www.svgrepo.com/show/25409/minus-sign-of-a-line-in-horizontal-position.svg" alt="" />
                    </button>

                </td>


                <td>
                    <div class="cartButtons">
                        <span class="btn-remove"></span>
                    </div>

                </td>

            </tr>
        </c:forEach>


    </table>




    </div>



    <div class="checkout-btn-div">
    <div class="checkout-btn" id="leftHeader">
        <a class="shoppingCartText btn-index btn-index--full" href="${pageContext.request.contextPath}/checkout.jsp">Checkout</a>
    </div>
</div>
</div>

</body>
</html>
    </jsp:body>
</t:pagetemplate>