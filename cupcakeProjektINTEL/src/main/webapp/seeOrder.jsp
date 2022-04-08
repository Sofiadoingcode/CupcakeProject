<%--
  Created by IntelliJ IDEA.
  User: sofia
  Date: 08-04-2022
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:body>
        <h1>ORDER</h1>

        <section class="orderlist-tablesection">
            <div class="orderlist-tablediv">
                <table class="orders-table">
                    <thead class="orders-th">

                        <td>ID</td>
                        <td>TOPPING</td>
                        <td>BOTTOM</td>
                        <td>PRICE</td>
                        <td>QUANTITY</td>
                        <td>ACTION</td>

                    </thead>
                    <c:forEach var="orderline" items="${requestScope.orderlines}">
                        <tr class="orders-tr">

                            <td>${orderline.orderlineId}</td>
                            <td>${orderline.toppingName}</td>
                            <td>${orderline.bottomName}</td>
                            <td>${orderline.unitPrice}</td>
                            <td>${orderline.quantity}</td>
                            <td>
                                <form method="post">

                                    <button type="submit" name="delete" value="${orderline.orderlineId}" formaction="deleteOrderLine" formmethod="post" class="orders-btn orders-delete"  >
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


        <div class="gobackButton">
            <form>
                <button type="submit" name="goback" formaction="orderlist" class="seeOrder-btn seeOrder-back">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-return-left" viewBox="0 0 16 16">
                        <path fill-rule="evenodd" d="M14.5 1.5a.5.5 0 0 1 .5.5v4.8a2.5 2.5 0 0 1-2.5 2.5H2.707l3.347 3.346a.5.5 0 0 1-.708.708l-4.2-4.2a.5.5 0 0 1 0-.708l4-4a.5.5 0 1 1 .708.708L2.707 8.3H12.5A1.5 1.5 0 0 0 14 6.8V2a.5.5 0 0 1 .5-.5z"/>
                    </svg> Go Back
                </button>
            </form>


        </div>




    </jsp:body>

</t:pagetemplate>