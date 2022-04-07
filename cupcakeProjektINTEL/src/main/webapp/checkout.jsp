<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
        <h1 id="congratulations">Congratulations!</h1>
    </jsp:attribute>

    <jsp:attribute name="footer">
        Checkout
    </jsp:attribute>

    <jsp:body>

        <html>
        <head>
            <title>Checkout</title>
        </head>
        <body>
        <p class="checkoutText">You have successfully ordered some cupcakes. </p>
        <br>
        <a class="checkoutText" href="${pageContext.request.contextPath}/index.jsp">Back to Frontpage</a>
        </body>
        </html>

    </jsp:body>

</t:pagetemplate>