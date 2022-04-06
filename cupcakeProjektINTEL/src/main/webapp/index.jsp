<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:attribute name="footer">
                Frontpage
    </jsp:attribute>
    <jsp:body>
        <section class="index-section">
            <div class="index-box">
                <div class="index-text-box">
                    <h1 class="index-heading-primary">WELCOME TO OLSKER CUPCAKES</h1>
                    <p class="index-description"> Assemble your cupcakes and we will make them exactly how you want!</p>


                        <c:if test="${sessionScope.user != null}">
                            <p>You are logged in with the role of "${sessionScope.user.role}".</p>
                        </c:if>

                        <c:if test="${sessionScope.user == null}">
                            <a href="${pageContext.request.contextPath}/createlogin.jsp" class="btn-index btn-index--full">Create User Here</a>
                            <a href="${pageContext.request.contextPath}/login.jsp" class="btn-index btn-index--login">Log In</a>
                        </c:if>

                    <c:if test="${sessionScope.user != null && sessionScope.user.role == 'customer' }">
                        <a href="${pageContext.request.contextPath}/order.jsp" class="btn-index btn-index--full">Order</a>

                    </c:if>


                </div>
                <div class="index-image-box">
                    <img src="${pageContext.request.contextPath}/images/3Cupcakes-IMG.png" class="cupcakeImg3"/>

                </div>
            </div>
        </section>
    </jsp:body>

</t:pagetemplate>