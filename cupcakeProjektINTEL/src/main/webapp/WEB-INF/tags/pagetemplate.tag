<%@tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<!DOCTYPE html>
<html lang="da">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>
        <jsp:invoke fragment="header"/>
    </title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/SF-Style.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/SR-Style.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/K-Style.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/M-Style.css">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<header>
    <div class="cupcakeImgBox">
        <a href="index.jsp">
            <img src="${pageContext.request.contextPath}/images/olskercupcakesImprovedHEADER.png" class="cupcakeImg"/>
        </a>
    </div>

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/index.jsp">Home</a>
                    </li>
                    <c:if test="${sessionScope.user.role == 'admin'}">
                        <li class="nav-item">

                            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/orderlist">Orders</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/customersservlet">Customers</a>
                        </li>
                    </c:if>
                </ul>
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <c:if test="${sessionScope.user != null}">
                            <a href="profilepage.jsp" class="nav-item nav-link">${sessionScope.user.email}</a>
                        </c:if>
                    </li>
                    <li class="nav-item">
                        <a class="nav-item nav-link" href="${pageContext.request.contextPath}/aboutus.jsp">About us</a>
                    </li>
                    <li class="nav-item">
                        <c:if test="${sessionScope.user == null }">
                            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/login.jsp">Login</a>
                        </c:if>
                    </li>
                    <li class="nav-item">
                        <c:if test="${sessionScope.user != null }">
                            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/logout">Log out</a>
                        </c:if>
                    </li>
                    <li class="nav-item">
                        <c:if test="${sessionScope.user.role == 'customer'}">
                            <a href="${pageContext.request.contextPath}/order">
                                <svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="black"
                                     class="bi bi-cart" viewBox="0 0 16 16">
                                    <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                                </svg>
                            </a>
                        </c:if>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<div id="body" class="container mt-4" style="min-height: 400px;">
    <h1>
        <jsp:invoke fragment="header"/>
    </h1>
    <jsp:doBody/>
</div>

<!-- Footer -->
<div class="container mt-3">
    <hr/>
    <div class="row mt-4">
        <div class="col">
            <p>CRAZY GOOD CUPCAKES</p>
        </div>
        <div class="col">
            <jsp:invoke fragment="footer"/>
            <br/>
        </div>
        <div class="col">

        </div>
    </div>

</div>

</div>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>
