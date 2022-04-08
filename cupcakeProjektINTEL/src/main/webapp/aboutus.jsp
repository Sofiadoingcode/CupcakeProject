<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>

    <jsp:attribute name="footer">
            About us
    </jsp:attribute>

    <jsp:body>
        <section class="aboutUs-section">

            <div class="centerText">
                <h2 class="centerText">Olsker Cupcakes</h2>
                <div class="centerText" class="descriptionText">
                    <p> Text and more text Text and more text Text and more text Text and more textText and more
                        textText and more textText and more text<br>Text and more textText and more textText and
                        more
                        textText and more textText and more text</p>
                </div>
            </div>
            <section>
                <div class="positionCards">
                    <div class="card" class="middleCardSize">
                        <img src="images/AboutUs/CupcakeProject-Baker.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">This is not only our wonderful baker, but it is also his grandfather
                                who is
                                the
                                founder of the shop. This is the founder of Olsker Cupcakes. <br>He fought through tough
                                terrain
                                and wild animals to bring home the very recipe that makes our cupcakes, even to this
                                day!
                            </p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>
                    <div class="card" class="middleCardSize">
                        <img src="images/AboutUs/CashRegi.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>
                    <div class="card" class="middleCardSize">
                        <img src="images/AboutUs/CupcakeProject-Assistant.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Card title</h5>
                            <p class="card-text">Some quick example text to build on the card title and make up the bulk
                                of
                                the
                                card's content.</p>
                            <a href="#" class="btn btn-primary">Go somewhere</a>
                        </div>
                    </div>
                </div>
            </section>
        </section>
    </jsp:body>
</t:pagetemplate>