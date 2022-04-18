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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "dropdown", value = "/dropdown")
public class DropdownServlet extends HttpServlet {
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
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        List<OrderLineDTO> dropdownListBottom;
        List<OrderLineDTO> dropdownListTopping;



        try {
            dropdownListBottom=cupcakeMapper.getBottomLine();
            dropdownListTopping=cupcakeMapper.getToppingLine();


            session.setAttribute("dropdownListBottom",dropdownListBottom);
            session.setAttribute("dropdownListTopping",dropdownListTopping);
            request.getRequestDispatcher("order.jsp").forward(request, response);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }


    }
}
