package dat.startcode.control;

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
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "deleteOrder", urlPatterns = {"/deleteOrder"})
public class deleteOrder extends HttpServlet {

    ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        connectionPool = ApplicationStart.getConnectionPool();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("aa");
        OrderMapper orderMapper = new OrderMapper(connectionPool);;
        String idString = req.getParameter("delete");
        int orderId = Integer.parseInt(idString);
        try {
            System.out.println("bb");
            orderMapper.deleteOrder(orderId);
            req.getRequestDispatcher("orderlist").forward(req,resp);

        } catch (DatabaseException e) {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
            req.setAttribute("fejlbesked", e.getMessage());
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }

        System.out.println("cc");


    }
}
