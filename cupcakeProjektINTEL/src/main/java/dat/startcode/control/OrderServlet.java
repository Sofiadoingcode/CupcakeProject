package dat.startcode.control;

import dat.startcode.model.DTOs.OrderDTO;
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
    int orderLinePrice = 0;
    int orderPrice = 0;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
        cupcakeMapper = new CupcakeMapper(connectionPool);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        HttpSession session = request.getSession();

        //basket.add(new OrderLine(request.getParameter("topping"),request.getParameter("bottom"), toppingPrice, bottomPrice, Integer.parseInt(request.getParameter("quantity") )));
        //session.setAttribute("basket",basket);
        request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        OrderDTO basket = (OrderDTO) session.getAttribute("basket");

        int idBottom = Integer.parseInt(request.getParameter("bottom"));
        int idTopping = Integer.parseInt(request.getParameter("topping"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        OrderLine orderLine = null;
        try {
            orderLine = getOrderline(quantity, idBottom, idTopping);
            basket.addToBasket(orderLine);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }


        session.setAttribute("basket", basket);
        request.getRequestDispatcher("dropdown").forward(request, response);


        request.getRequestDispatcher("order.jsp").forward(request, response);

    }

    private OrderLine getOrderline(int quantity, int idBottom, int idTopping) throws DatabaseException {
        OrderLineDTO orderLineDTO;
        OrderLine orderLine = null;
        orderLineDTO = cupcakeMapper.getOrderLine(idTopping, idBottom);
        String toppingName = orderLineDTO.getToppingName();
        String bottomName = orderLineDTO.getBottomName();
        int toppingPrice = orderLineDTO.getToppingPrice();
        int bottomPrice = orderLineDTO.getBottomPrice();
        orderLinePrice = (toppingPrice + bottomPrice) * quantity;
        orderLine = new OrderLine(toppingName, bottomName, toppingPrice, bottomPrice, quantity, idBottom, idTopping, orderLinePrice);

        return orderLine;
    }
}
