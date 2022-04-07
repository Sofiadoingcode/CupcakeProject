<%--
  Created by IntelliJ IDEA.
  User: sofia
  Date: 07-04-2022
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>


<t:pagetemplate>

    <jsp:attribute name="footer">
                Customer site
    </jsp:attribute>
    <jsp:body>

    <div class="orders-header-box">
        <h1 class="orders-header">Customer List</h1>
    </div>

    <table class="orders-table">
        <thead class="orders-th">
            <td>ID</td>
            <td>USERNAME</td>
            <td>EMAIL</td>
            <td>BALANCE</td>
            <td>REMOVE</td>

        </thead>
        <c:forEach var="customer" items="${requestScope.customerlist}">
            <tr class="orders-tr">

                <td>${customer.userId}</td>
                <td>${customer.username}</td>
                <td>${customer.email}</td>
                <td>${customer.balance}</td>
                <td>
                    <form method="post">

                        <button type="submit" name="delete" value="${customer.userId}" formaction="deleteUser" formmethod="post" class="orders-btn orders-delete"  >
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x" viewBox="0 0 16 16">
                                <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
                            </svg>
                        </button>
                    </form>

                </td>

            </tr>
        </c:forEach>


    </table>

    </jsp:body>


</t:pagetemplate>
