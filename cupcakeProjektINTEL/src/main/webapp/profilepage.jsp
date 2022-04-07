<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Your Profile
    </jsp:attribute>

    <jsp:attribute name="footer">
            Profile Page
    </jsp:attribute>

    <jsp:body>

        <section>

            <div>
                <h1>Welcome, ${sessionScope.user.username}</h1>

                <p>You have ${sessionScope.user.balance} kr.- on your account!</p>

                <p>Your email is: ${sessionScope.user.email}</p>

                <c:if test="${sessionScope.typedCorrectPassword == false || sessionScope.typedCorrectPassword == null}">
                <form action="changePassword" method="post">
                <div>
                    <input type="text" class="PasswordInputField" id="password" name="password" placeholder=" Type your current password to change it">
                    <input type="submit" class="btn--createandlogin btn--createandlogin--full" value=" Confirm">
                </div>
                </c:if>
                    <c:if test="${sessionScope.typedCorrectPassword == true}">

                <form action="changePassword" method="post">
                    <input type="password" class="PasswordInputField" id="newPassword" name="newPassword" placeholder="New password">
                    <input type="submit" class="btn--createandlogin btn--createandlogin--full" value="Confirm">
                    </c:if>
                </form>

                <c:if test="${sessionScope.typedCorrectPassword == false}">
                    <div>
                        <p>You typed an incorrect password!</p>
                    </div>
                </c:if>


                <p></p>

            </div>
        </section>





    </jsp:body>
</t:pagetemplate>