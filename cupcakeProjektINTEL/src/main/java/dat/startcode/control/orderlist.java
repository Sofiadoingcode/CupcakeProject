package dat.startcode.control;

import dat.startcode.model.DTOs.OrderListDTO;
import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.OrderMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "orderlist", urlPatterns = {"/orderlist"})
public class orderlist extends HttpServlet {

    private OrderMapper orderMapper;
    ConnectionPool connectionPool;
    @Override
    public void init() throws ServletException
    {
        connectionPool = ApplicationStart.getConnectionPool();
        orderMapper = new OrderMapper(connectionPool);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        try
        {

            List<OrderListDTO> orderListDTOList = orderMapper.getAllNoneCompletedOrders();
            List<OrderListDTO> completedOrders = orderMapper.getAllCompletedOrders();

            request.setAttribute("orders", orderListDTOList);
            request.setAttribute("completedorders", completedOrders);
            request.getRequestDispatcher("orderlist.jsp").forward(request, response);
        }
        catch (DatabaseException e)
        {

            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
            request.setAttribute("fejlbesked", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);

        }

        //check if we are actually getting something from the database

    }



//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doDelete(req, resp);
//
//
//    }

    public void destroy()
    {

    }


}
