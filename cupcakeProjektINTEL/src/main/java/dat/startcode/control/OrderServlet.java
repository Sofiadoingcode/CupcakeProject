package dat.startcode.control;

import dat.startcode.model.DTOs.OrderLineDTO;
import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.OrderLine;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.CupcakeMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "order", value = "/order")
public class OrderServlet extends HttpServlet {
    ConnectionPool connectionPool;
    private CupcakeMapper cupcakeMapper;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
        cupcakeMapper=new CupcakeMapper(connectionPool);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        HttpSession session = request.getSession();




        List<OrderLine> basket = (List<OrderLine>) session.getAttribute("basket");

        //basket.add(new OrderLine(request.getParameter("topping"),request.getParameter("bottom"), toppingPrice, bottomPrice, Integer.parseInt(request.getParameter("quantity") )));

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
        List<OrderLine> basket = (List<OrderLine>) session.getAttribute("basket");


        OrderLineDTO orderLineDTO;
        try {
            orderLineDTO = cupcakeMapper.getOrderLine(Integer.parseInt(request.getParameter("topping")),Integer.parseInt(request.getParameter("bottom")));
            String toppingName=orderLineDTO.getToppingName();
            String bottomName=orderLineDTO.getBottomName();
            int toppingPrice=orderLineDTO.getToppingPrice();
            int bottomPrice=orderLineDTO.getBottomPrice();
            basket.add(new OrderLine(toppingName, bottomName, toppingPrice, bottomPrice, Integer.parseInt(request.getParameter("quantity"))) );
            session.setAttribute("basket",basket);
            request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

    }
}
