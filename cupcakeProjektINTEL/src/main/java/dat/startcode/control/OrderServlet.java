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
    int orderLinePrice=0;
    int orderPrice=0;

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
        int idBottom = Integer.parseInt(request.getParameter("bottom"));
        int idTopping = Integer.parseInt(request.getParameter("topping"));
        OrderLineDTO orderLineDTO;
        try {
            orderLineDTO = cupcakeMapper.getOrderLine(idTopping,idBottom);
            String toppingName=orderLineDTO.getToppingName();
            String bottomName=orderLineDTO.getBottomName();
            int toppingPrice=orderLineDTO.getToppingPrice();
            int bottomPrice=orderLineDTO.getBottomPrice();
            orderLinePrice=(toppingPrice+bottomPrice)*Integer.parseInt(request.getParameter("quantity"));
            basket.add(new OrderLine(toppingName, bottomName, toppingPrice, bottomPrice, Integer.parseInt(request.getParameter("quantity")),idBottom, idTopping, orderLinePrice) );
            orderPrice=0;
            for(int i=0; i<basket.size(); i++){
               orderPrice+=basket.get(i).getOrderLinePrice();
            }
            session.setAttribute("orderPrice",orderPrice);
            session.setAttribute("basket",basket);
            request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        session.setAttribute("basket",basket);
        request.getRequestDispatcher("order.jsp").forward(request, response);

    }
}
