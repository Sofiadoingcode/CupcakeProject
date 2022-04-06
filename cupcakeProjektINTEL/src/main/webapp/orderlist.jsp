<%--
  Created by IntelliJ IDEA.
  User: sofia
  Date: 05-04-2022
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">
<%--         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
<%--        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
<%--        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
    </jsp:attribute>
    <jsp:attribute name="footer">
                Order site
    </jsp:attribute>
    <jsp:body>

            <div class="orders-header-box">
                <h1 class="orders-header">Order List</h1>
            </div>

            <table class="orders-table">
                    <thead class="orders-th">
                        <td>USERNAME</td>
                        <td>EMAIL</td>
                        <td>ORDER</td>
                        <td>PRICE</td>
                        <td>ACTION</td>

                    </thead>

                    <tr class="orders-tr">
                        <c:forEach var="order" items="${requestScope.orderlist}">
                            <td>${order.userUsername}</td>
                            <td>${order.userEmail}</td>
                            <td>
                                <button type="button" class="btn-seeorder" data-toggle="modal" data-target="#orderModal">
                                    See Order
                                </button>
                            </td>
                            <td>${order.totalPrice}</td>
                            <td>
                                    <button type="button" class="orders-btn orders-complete orders-btn--right-margin" formaction="#">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check" viewBox="0 0 16 16">
                                            <path d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.267.267 0 0 1 .02-.022z"/>
                                        </svg>
                                    </button>

                                    <button type="button" class="orders-btn orders-delete" formaction="#">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x" viewBox="0 0 16 16">
                                            <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
                                        </svg>
                                    </button>

                            </td>
                        </c:forEach>
                    </tr>


            </table>

<%--            <div class="modal fade" id="orderModal" tabindex="-1" role="dialog" aria-labelledby="orderModalLabel" aria-hidden="true">--%>
<%--                <div class="modal-dialog" role="document">--%>
<%--                    <div class="modal-content">--%>
<%--                        <div class="modal-header">--%>
<%--                            <h5 class="modal-title" id="orderModalLabel">Modal title</h5>--%>
<%--                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--                                <span aria-hidden="true">&times;</span>--%>
<%--                            </button>--%>
<%--                        </div>--%>
<%--                        <div class="modal-body">--%>
<%--                            <p>Hello</p>--%>
<%--                        </div>--%>
<%--                        <div class="modal-footer">--%>
<%--                            <button type="button" class="" data-dismiss="modal">Close</button>--%>
<%--                            <button type="button" class="">Save changes</button>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>






    </jsp:body>

</t:pagetemplate>