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
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>


<t:pagetemplate>

    <jsp:attribute name="footer">
                Order site
    </jsp:attribute>
    <jsp:body>

            <div class="orders-header-box">
                <h1 class="orders-header">Order List</h1>
            </div>

            <section class="orderlist-tablesection">
                <div class="orderlist-tablediv">
                    <table class="orders-table">
                            <thead class="orders-th">
                                <td>ID</td>
                                <td>USERNAME</td>
                                <td>EMAIL</td>
                                <td>ORDER</td>
                                <td>PRICE</td>
                                <td>ACTION</td>

                            </thead>
                            <c:forEach var="order" items="${requestScope.orders}">
                                <tr class="orders-tr">

                                        <td>${order.orderId}</td>
                                        <td>${order.userUsername}</td>
                                        <td>${order.userEmail}</td>
                                        <td>
                                            <button type="button" class="btn-seeorder" data-toggle="modal" data-target="#orderModal">
                                                See Order
                                            </button>
                                        </td>
                                        <td>${order.totalPrice}</td>
                                        <td>
                                            <form method="post">
                                                <button type="submit" name="complete" value="${order.orderId}" formaction="completeorder" formmethod="post" class="orders-btn orders-complete orders-btn--right-margin"  >
                                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-check" viewBox="0 0 16 16">
                                                        <path d="M10.97 4.97a.75.75 0 0 1 1.07 1.05l-3.99 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.267.267 0 0 1 .02-.022z"/>
                                                    </svg>
                                                </button>

                                                <button type="submit" name="delete" value="${order.orderId}" formaction="deleteOrder" formmethod="post" class="orders-btn orders-delete"  >
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
            </section>



            <section class="orderlist-collapsablesection">

                <button type="button" class="orderlist-collapsible">Completed Orders</button>
                <div class="orderlist-content">
                    <table class="orders-table">
                        <thead class="orders-th">
                        <td>ID</td>
                        <td>USERNAME</td>
                        <td>EMAIL</td>
                        <td>ORDER</td>
                        <td>PRICE</td>
                        <td>ACTION</td>

                        </thead>
                        <c:forEach var="completedorder" items="${requestScope.completedorders}">
                            <tr class="orders-tr">

                                <td>${completedorder.orderId}</td>
                                <td>${completedorder.userUsername}</td>
                                <td>${completedorder.userEmail}</td>
                                <td>
                                    <button type="button" class="btn-seeorder" data-toggle="modal" data-target="#orderModal">
                                        See Order
                                    </button>
                                </td>
                                <td>${completedorder.totalPrice}</td>
                                <td>
                                    <form method="post">
                                        <button type="submit" name="complete" value="${completedorder.orderId}" formaction="completeorder" formmethod="post" class="orders-btn orderlist-btn--uncomplete orders-btn--right-margin"  >
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-up" viewBox="0 0 16 16">
                                                <path fill-rule="evenodd" d="M8 15a.5.5 0 0 0 .5-.5V2.707l3.146 3.147a.5.5 0 0 0 .708-.708l-4-4a.5.5 0 0 0-.708 0l-4 4a.5.5 0 1 0 .708.708L7.5 2.707V14.5a.5.5 0 0 0 .5.5z"/>
                                            </svg>
                                        </button>

                                        <button type="submit" name="delete" value="${completedorder.orderId}" formaction="deleteOrder" formmethod="post" class="orders-btn orders-delete"  >
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x" viewBox="0 0 16 16">
                                                <path d="M4.646 4.646xa.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
                                            </svg>
                                        </button>
                                    </form>

                                </td>

                            </tr>
                        </c:forEach>


                    </table>

                </div>
                <script>
                    var coll = document.getElementsByClassName("orderlist-collapsible");
                    var i;

                    for (i = 0; i < coll.length; i++) {
                        coll[i].addEventListener("click", function() {
                            this.classList.toggle("orderlist-active");
                            var content = this.nextElementSibling;
                            if (content.style.display === "block") {
                            content.style.display = "none";
                            } else {
                            content.style.display = "block";
                            }
                        });
                    }
                </script>


            </section>



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