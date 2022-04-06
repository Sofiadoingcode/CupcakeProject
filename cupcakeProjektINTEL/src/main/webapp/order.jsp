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
            <div class="custom-select" style="width: 200px">
                <label for="bottom">Choose a topping:</label>
                <select id="bottom" name=bottom>

                    <option value="Chocolate">Chocolate 5kr</option>
                    <option value="Chocolate">Chocolate 5kr</option>
                    <option value="Vanilla">Vanilla 5kr</option>
                    <option value="Nutmeg">Nutmeg 5kr</option>
                    <option value="Pistacio">Pistacio 6kr</option>
                    <option value="Almond">Almond 7kr</option>
                </select>
            </div>
            <div class="custom-select" style="width: 200px">
                <label for="topping">choose a topping:</label>
                <select class="btn-index" id="topping" name="topping">

                    <option value="Chocolate">Chocolate 5kr</option>
                    <option value="Chocolate">Chocolate 5kr</option>
                    <option value="Blueberry">Blueberry 5kr</option>
                    <option value="Rasberry">Rasberry 5kr</option>
                    <option value="Crispy">Crispy 6kr</option>
                    <option value="Strawberry">Strawberry 7kr</option>
                    <option value="Rum/Raisin"> Rum/Raisin 7kr</option>
                    <option value="Orange"> Orange 8kr</option>
                    <option value="Lemon"> Lemon 8kr</option>
                    <option value="BlueCheese"> Bluecheese 9kr</option>

                </select></div>

            <label for="quantity">quantity:</label><br>
            <input type="number"  style="width: 10rem" class="InputFields" id="quantity" name="quantity" placeholder="1">


            <input type="submit" class="btn--createandlogin btn--createandlogin--full" value="add to cart">
        </form>

        <script>
            var x, i, j, l, ll, selElmnt, a, b, c;
            /*look for any elements with the class "custom-select":*/
            x = document.getElementsByClassName("custom-select");
            l = x.length;
            for (i = 0; i < l; i++) {
                selElmnt = x[i].getElementsByTagName("select")[0];
                ll = selElmnt.length;
                /*for each element, create a new DIV that will act as the selected item:*/
                a = document.createElement("DIV");
                a.setAttribute("class", "select-selected");
                a.innerHTML = selElmnt.options[selElmnt.selectedIndex].innerHTML;
                x[i].appendChild(a);
                /*for each element, create a new DIV that will contain the option list:*/
                b = document.createElement("DIV");
                b.setAttribute("class", "select-items select-hide");
                for (j = 1; j < ll; j++) {
                    /*for each option in the original select element,
                    create a new DIV that will act as an option item:*/
                    c = document.createElement("DIV");
                    c.innerHTML = selElmnt.options[j].innerHTML;
                    c.addEventListener("click", function (e) {
                        /*when an item is clicked, update the original select box,
                        and the selected item:*/
                        var y, i, k, s, h, sl, yl;
                        s = this.parentNode.parentNode.getElementsByTagName("select")[0];
                        sl = s.length;
                        h = this.parentNode.previousSibling;
                        for (i = 0; i < sl; i++) {
                            if (s.options[i].innerHTML == this.innerHTML) {
                                s.selectedIndex = i;
                                h.innerHTML = this.innerHTML;
                                y = this.parentNode.getElementsByClassName("same-as-selected");
                                yl = y.length;
                                for (k = 0; k < yl; k++) {
                                    y[k].removeAttribute("class");
                                }
                                this.setAttribute("class", "same-as-selected");
                                break;
                            }
                        }
                        h.click();
                    });
                    b.appendChild(c);
                }
                x[i].appendChild(b);
                a.addEventListener("click", function (e) {
                    /*when the select box is clicked, close any other select boxes,
                    and open/close the current select box:*/
                    e.stopPropagation();
                    closeAllSelect(this);
                    this.nextSibling.classList.toggle("select-hide");
                    this.classList.toggle("select-arrow-active");
                });
            }

            function closeAllSelect(elmnt) {
                /*a function that will close all select boxes in the document,
                except the current select box:*/
                var x, y, i, xl, yl, arrNo = [];
                x = document.getElementsByClassName("select-items");
                y = document.getElementsByClassName("select-selected");
                xl = x.length;
                yl = y.length;
                for (i = 0; i < yl; i++) {
                    if (elmnt == y[i]) {
                        arrNo.push(i)
                    } else {
                        y[i].classList.remove("select-arrow-active");
                    }
                }
                for (i = 0; i < xl; i++) {
                    if (arrNo.indexOf(i)) {
                        x[i].classList.add("select-hide");
                    }
                }
            }

            /*if the user clicks anywhere outside the select box,
            then close all select boxes:*/
            document.addEventListener("click", closeAllSelect);
        </script>
    </jsp:body>
</t:pagetemplate>