package dat.startcode.control;

import dat.startcode.model.DTOs.OrderListDTO;
import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.OrderMapper;
import dat.startcode.model.persistence.UserMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "customersservlet", urlPatterns = {"/customersservlet"})
public class CustomersServlet extends HttpServlet {

    private UserMapper userMapper;
    ConnectionPool connectionPool;
    @Override
    public void init() throws ServletException
    {
        connectionPool = ApplicationStart.getConnectionPool();
        userMapper = new UserMapper(connectionPool);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {

        try
        {

            List<User> allCustomers = userMapper.getAllCustomers();

            request.setAttribute("customerlist", allCustomers);
            request.getRequestDispatcher("customers.jsp").forward(request, response);
        }
        catch (DatabaseException e)
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
            request.setAttribute("fejlbesked", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);

        }

        //check if we are actually getting something from the database

    }

    @Override
    public void destroy() {

    }
}
