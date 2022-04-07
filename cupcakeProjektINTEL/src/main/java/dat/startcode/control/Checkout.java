package dat.startcode.control;

import com.mysql.cj.Session;
import dat.startcode.model.config.ApplicationStart;
import dat.startcode.model.entities.OrderLine;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import org.junit.jupiter.api.Assertions;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
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

        System.out.println("First Sout");
        response.setContentType("text/html");
        int idKey =0;
        Logger.getLogger("web").log(Level.INFO, "");
        List<OrderLine> basket = (List<OrderLine>) session.getAttribute("basket");


        try (Connection connection = connectionPool.getConnection())
        {

            String sql = "INSERT INTO `cupcakedatabase`.`order` ( idUser, isCompleted) VALUES (3, 0) ";
            try(PreparedStatement ps1 = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
            {
                int rowsAffected = ps1.executeUpdate();


                //return the generated primary key from sql
                ResultSet generatedKeys = ps1.getGeneratedKeys();
                if (generatedKeys.next()) {
                    idKey = generatedKeys.getInt(1);
                }

                System.out.println("id key is there" + idKey );


            }catch (SQLException e){
                System.out.println(e);

            }

           try {

               String sql2 = "insert into orderline(idTopping, idBottom, quantity, idOrder) values (?, ?,?, ?)";
               for (OrderLine item : basket) {

                   PreparedStatement ps2 = connection.prepareStatement(sql2);


                   

                   ps2.setInt(3, item.getQuantity());
                   ps2.setInt(4, idKey);
                   ps2.executeUpdate();





               }
           }catch ( Exception E){

               System.out.println(E);
               System.out.println("dasohaofhasjoi");

           }

        } catch (SQLException ex) {
            System.out.println(ex + "error connecting to db");
            System.out.println("whydoes it not work");
        }


        request.getRequestDispatcher("index.jsp").forward(request, response);
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
