<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page errorPage="error.jsp" isErrorPage="false" %>

<t:pagetemplate>
    <jsp:attribute name="header">

    </jsp:attribute>

    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>

        <form action="">
            <label for="topping">Choose a topping:</label>
            <select  id="topping" name = bottom>

                <option value="Chocolate">Chocolate 5kr</option>
                <option value="Vanilla">Vanilla 5kr</option>
                <option value="Nutmeg">Nutmeg 5kr</option>
                <option value="Pistacio">Pistacio 6kr</option>
                <option value="Almond">Almond 7kr</option>


            </select>
            <label for="bottom">choose a bottom:</label>
            <select  id="bottom" name = "bottom">

                <option value="Chocolate">Chocolate 5kr</option>
                <option value="Blueberry">Blueberryr 5kr</option>
                <option value="Rasberry">Rasberry 5kr</option>
                <option value="Crispy">Crispy 6kr</option>
                <option value="Strawberry">Strawberry 7kr</option>
                <option value="Rum/Raisin"> Rum/Raisin 7kr</option>
                <option value="Rum/Raisin"> Orange 8kr </option>
                <option value="Lemon"> Lemon 8kr </option>
                <option value= "BlueCheese"> Bluecheese 9kr </option>


            </select>
            <label for="quantity">quantity:</label><br>
            <input type="number" id="quantity" name="quantity" placeholder= "1">



        </form>


        <br>
        <br>
        <br>




    </jsp:body>
</t:pagetemplate>