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
    <div class="cartHeaders">
        <span>Topping</span>
        <span>Bottom</span>
        <span>Amount</span>
        <span>Price</span>
        <span></span>
    </div>
    <div class="cupcakeOrder">
        <div class="cartButtons">
            <span class="btn-remove"></span>
        </div>
        <div class="topping">
            <span>Strawberry</span>
        </div>
        <div class="bottom">
            <span>Chocolate</span>
        </div>
        <div class="amount">
            <button class="btn-add" type="button" name="button">
                <img src="https://icon-library.com/images/plus-icon-transparent/plus-icon-transparent-5.jpg" alt="" />
            </button>
            <input type="text" name="amount" value="1">
            <button class="btn-minus" type="button" name="button">
                <img src="/images/minus.png" alt="" />
            </button>
        </div>
        <div class="total-price">20kr</div>
    </div>



    <div class="shoppingCartHeaders">
    <div class="shoppingCartHeader" id="leftHeader">
        <a class="shoppingCartText btn-index btn-index--full" href="${pageContext.request.contextPath}/checkout.jsp">Checkout</a>
    </div>
</div>
</div>

</body>
</html>
    </jsp:body>
</t:pagetemplate>