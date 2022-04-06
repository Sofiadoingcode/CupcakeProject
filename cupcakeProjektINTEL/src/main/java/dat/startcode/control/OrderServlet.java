package dat.startcode.control;

import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.OrderLine;
import dat.startcode.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "order", value = "/order")
public class OrderServlet extends HttpServlet {
ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        HttpSession session = request.getSession();





        ArrayList<OrderLine> basket = (ArrayList<OrderLine>) session.getAttribute("basket");

        basket.add(new OrderLine(request.getParameter("topping"),request.getParameter("bottom"),Integer.parseInt(request.getParameter("quantity") )));

        for (OrderLine item : basket) {
            System.out.println(item);
        }

        session.setAttribute("basket",basket);
        request.getRequestDispatcher("order.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        ArrayList<OrderLine> basket = (ArrayList<OrderLine>) session.getAttribute("basket");

        basket.add(new OrderLine(request.getParameter("topping"),request.getParameter("bottom"),Integer.parseInt(request.getParameter("quantity"))) );
       // basket.add(new OrderLine("strawberry","chocolate",2) );

        for (OrderLine item : basket) {
            System.out.println(item);
        }

        session.setAttribute("basket",basket);
        request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);

    }
}
