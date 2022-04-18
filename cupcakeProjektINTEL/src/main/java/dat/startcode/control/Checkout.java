package dat.startcode.control;

import com.mysql.cj.Session;
import dat.startcode.model.DTOs.OrderDTO;
import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.OrderLine;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.OrderMapper;
import dat.startcode.model.persistence.UserMapper;
import org.junit.jupiter.api.Assertions;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "Checkout", value = "/Checkout")
public class Checkout extends HttpServlet {

    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        OrderDTO basket = ((OrderDTO) session.getAttribute("basket"));
        response.setContentType("text/html");

        OrderMapper orderMapper = new OrderMapper(connectionPool);
        try {
            orderMapper.insertOrder(user,basket.getBasket(),basket.totalPrice());
        } catch (DatabaseException e) {
            e.printStackTrace();
            System.out.println("if this doesnt work I am going to yeet you out of the window");
        }

        session.setAttribute("basket", new OrderDTO());
        request.getRequestDispatcher("checkout.jsp").forward(request, response);

    }
}




/*
            try (PreparedStatement ps1 = connection.prepareStatement(sql0, Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = ps1.getGeneratedKeys();
                int idKey = generatedKeys.getInt(1);


                String sql1 = "insert into orderline(idTopping, idBottom, quantity, idOrder) values (2 ,2, 2, ?)";

                PreparedStatement ps2 = connection.prepareStatement(sql1);
                ps2.setInt(1, idKey);


            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("AOSFH#HR)(HLAFHA");
            }
            Assertions.assertNotNull(connection);
            if (connection != null) {
                connection.close();

            }


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("¤HO!#OUHOUASFOIAJSIFJAOISFOIAOIJFOAIJOIJ");
        }
    }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}*/
