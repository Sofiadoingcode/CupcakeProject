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

@WebServlet(name = "orderlist", urlPatterns = {"/orderlist"} )
public class orderlist extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");
        OrderMapper orderMapper = new OrderMapper(connectionPool);
        List<OrderListDTO> orderListDTOList = null;

        try
        {
            orderListDTOList = orderMapper.getAllNoneCompletedOrders();
        }
        catch (DatabaseException e)
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
        }

        request.setAttribute("orderlist", orderListDTOList);
        request.getRequestDispatcher("orderlist.jsp").forward(request, response);
    }

    public void destroy()
    {

    }


}
