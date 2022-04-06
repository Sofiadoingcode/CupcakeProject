package dat.startcode.control;

import dat.startcode.model.DTOs.OrderListDTO;
import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.orderLine;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.OrderMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "orderline", value={"/orderline"})
public class OrderLine extends HttpServlet {

   private orderLine orderline =new orderLine("Strawberry", "Chocolate", 1);
   private ArrayList<orderLine> orderLines= new ArrayList<>();



    @Override
    public void init() throws ServletException
    {
        ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        orderLines.add(orderline);
        orderLines.add(orderline);
        orderLines.add(orderline);

        request.setAttribute("orders", orderLines);
        request.getRequestDispatcher("shoppingCart.jsp").forward(request, response);

        //check if we are actually getting something from the database


    }

    public void destroy()
    {

    }


}
