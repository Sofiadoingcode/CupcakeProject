package dat.startcode.control;

import dat.startcode.model.DTOs.OrderLineDTO;
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


    @WebServlet(name = "seeOrderlineServlet", urlPatterns = {"/seeOrderlineServlet"})
    public class SeeOrderlineServlet extends HttpServlet {

        ConnectionPool connectionPool;

        @Override
        public void init() throws ServletException {
            connectionPool = ApplicationStart.getConnectionPool();

        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doGet(req, resp);
        }

        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            OrderMapper orderMapper = new OrderMapper(connectionPool);

            String idOrder = request.getParameter("seeOrder");
            int orderId = Integer.parseInt(idOrder);

            try {

                List<OrderLineDTO> orderLineDTOS = orderMapper.getSingleOrderOrderlines(orderId);

                request.setAttribute("orderlines", orderLineDTOS);

                System.out.println("bbb");

                request.getRequestDispatcher("seeOrder.jsp").forward(request, response);


            } catch (DatabaseException e) {



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
