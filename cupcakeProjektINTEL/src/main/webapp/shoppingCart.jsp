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

                <td>${orders.toppingName}</td>
                <td>${orders.bottomName}</td>
                <td>

                    <button class="btn-add" type="button" name="button">
                        <img src="https://cdn0.iconfinder.com/data/icons/ui-16px-perfect-megapack-line/16/82_Add-512.png" alt="" />
                    </button>
                    <input type="text" name="amount" id="quantity" value="${orders.quantity}">
                    <button class="btn-minus" type="button" name="button">
                        <img src="https://www.svgrepo.com/show/25409/minus-sign-of-a-line-in-horizontal-position.svg" alt="" />
                    </button>

                </td>
                <td>
                    (${orders.toppingPrice}+${orders.bottomPrice})*${orders.quantity})
                </td>

                <td>
                    <button type="button" class="orders-btn orders-delete" formaction="#">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x" viewBox="0 0 16 16">
                            <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
                        </svg>
                    </button>

                </td>

            </tr>
        </c:forEach>
    </table>

    </div>
<div class="checkout-btn-div">
    <div class="checkout-btn" id="leftHeader">
        <a class="btn-index btn-index--full" id="checkout-btn" href="${pageContext.request.contextPath}/checkout.jsp">Checkout</a>
    </div>
</div>

</body>
</html>
    </jsp:body>
</t:pagetemplate>