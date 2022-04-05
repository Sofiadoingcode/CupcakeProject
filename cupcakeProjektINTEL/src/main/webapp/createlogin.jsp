<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Create Log In
    </jsp:attribute>

    <jsp:attribute name="footer">
            Login Page
    </jsp:attribute>

    <jsp:body>

        <form action="login" method="post">
                <%--<label for="username">Username: </label>--%>
            <input type="text" class="InputFields" id="username" name="username" placeholder="Username"/>
            <br>


                <%--<label for="password">Password: </label>--%>
            <input type="password" class="InputFields" id="password" name="password" placeholder="Password"/>
            <br>
            <input type="text" class="InputFields" id="email" name="email" placeholder="Email"/>

            <br>

            <p>Already have a user? <a href="login.jsp">Log in!</a></p>

            <br>

            <a href="#" class="btn btn--createandlogin--full">Create User Here</a>
        </form>

    </jsp:body>
</t:pagetemplate>