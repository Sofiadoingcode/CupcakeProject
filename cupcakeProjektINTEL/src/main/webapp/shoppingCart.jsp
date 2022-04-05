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
<body>
<div class="shoppingCartHeaders">
<div class="shoppingCartHeader" id="leftHeader">
    <p class="shoppingCartText">Topping</p>
</div>
<div class="shoppingCartHeader">
    <p class="shoppingCartText">Bottom</p>
</div>
    <div class="shoppingCartHeader">
        <p class="shoppingCartText">Amount</p>
    </div>
    <div class="shoppingCartHeader">
        <p class="shoppingCartText">Price</p>
    </div>
    <div class="shoppingCartHeader">
        <p class="shoppingCartText"></p>
    </div>
</div>
    <div class="shoppingCartHeaders">
    <div class="shoppingCartHeader" id="leftHeader2">
        <a class="shoppingCartText" href="${pageContext.request.contextPath}/checkout.jsp">Checkout</a>
    </div>
</div>
</div>
</div>
</body>
</html>
    </jsp:body>
</t:pagetemplate>