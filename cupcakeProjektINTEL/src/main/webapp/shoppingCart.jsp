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

        <c:forEach var="orders" items="${sessionScope.basket.basket}">
            <tr class="orders-tr">

                <td>${orders.toppingName}</td>
                <td>${orders.bottomName}</td>
                <td>
                <form>
                    <button formaction="editBasket" class="btn-add" type="submit" name="button" value="1 ${orders.idOrderLine}">
                        <img src="https://cdn0.iconfinder.com/data/icons/ui-16px-perfect-megapack-line/16/82_Add-512.png" alt="" />
                    </button>
                    <input type="text" name="amount" id="quantity" value="${orders.quantity}">
                    <button formaction="editBasket" class="btn-minus" type="submit" name="button" value="-1 ${orders.idOrderLine}">
                        <img src="https://www.svgrepo.com/show/25409/minus-sign-of-a-line-in-horizontal-position.svg" alt="" />
                    </button>
                </form>
                </td>

                <td>
                    ${orders.orderLinePrice}
                </td>


                <td>
                    <form>
                    <button type="submit" name="delete" class="orders-btn orders-delete" value="${orders.idOrderLine}" formaction="editBasket">
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x" viewBox="0 0 16 16">
                            <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
                        </svg>
                    </button>
                    </form>
                </td>

            </tr>
        </c:forEach>
    </table>

    </div>
<section class="checkout-total-price">
    <div class="total-price">
        <p id="total-price-text">Total: ${sessionScope.basket.totalPrice()} kr.</p>
    </div>
    <div class="checkout-btn-div">


    <div>
        <form action="Checkout" method="post">


            <input  type="submit" class="checkout-btn shoppingCartText btn-index btn-index--full" value="checkout">
        </form>



</div>
        </div>

</section>
</body>
</html>
    </jsp:body>
</t:pagetemplate>