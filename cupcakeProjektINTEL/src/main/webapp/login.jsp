<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
             Log in
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
            <input type="text" class="InputFields" id="password" name="password" placeholder="Password"/>
            <br>

        <p>Don't have a user? <a href="createlogin.jsp">Create one! </a></p>
                <br>
        <input  type="submit" class="btn--createandlogin btn--createandlogin--full" value="Log in">
        </form>

    </jsp:body>
</t:pagetemplate>