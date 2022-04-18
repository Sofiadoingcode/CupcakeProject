package dat.startcode.control;

import com.mysql.cj.Session;
import dat.startcode.model.DTOs.OrderDTO;
import dat.startcode.model.entities.OrderLine;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "editBasket", value = "/editBasket")
public class EditBasket extends HttpServlet {
    ArrayList<OrderLine> basket;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        HttpSession session = request.getSession();
        OrderDTO order = (OrderDTO) session.getAttribute("basket");
        basket = order.getBasket();

        order.deleteOrderLine(request);
        order.changeQuantity(request);

        session.setAttribute("basket", order);
        request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);
    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
