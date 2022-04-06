package dat.startcode.model.persistence;

import dat.startcode.model.DTOs.OrderListDTO;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderMapper implements IOrderMapper{

    private ConnectionPool connectionPool;

    public OrderMapper(ConnectionPool connectionPool) {

        this.connectionPool = connectionPool;
    }

    public List<OrderListDTO> getAllOrders() throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        List<OrderListDTO> orderListDTOList = new ArrayList<>();

        String sql = "SELECT idOrder, totalPrice, u.idUser, u.username, u.email FROM `order` INNER JOIN user u USING(idUser)";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int orderId = rs.getInt("idOrder");
                    int totalPrice = rs.getInt("totalPrice");

                    int userId = rs.getInt("idUser");
                    String username = rs.getString("username");
                    String email = rs.getString("email");
                    OrderListDTO dto = new OrderListDTO(orderId, totalPrice, userId, username, email);
                    orderListDTOList.add(dto);
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Fejl under indlæsning af bøger og forfattere fra databasen");
        }
        return orderListDTOList;
    }

    @Override
    public List<OrderListDTO> getAllNoneCompletedOrders() throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        List<OrderListDTO> orderListDTOList = new ArrayList<>();

        String sql = "SELECT idOrder, totalPrice, u.idUser, u.username, u.email FROM `order` INNER JOIN user u USING(idUser) where isCompleted='0'";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int orderId = rs.getInt("idOrder");
                    int totalPrice = rs.getInt("totalPrice");

                    int userId = rs.getInt("idUser");
                    String username = rs.getString("username");
                    String email = rs.getString("email");
                    OrderListDTO dto = new OrderListDTO(orderId, totalPrice, userId, username, email);
                    orderListDTOList.add(dto);
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Fejl under indlæsning af bøger og forfattere fra databasen");
        }
        return orderListDTOList;
    }


    @Override
    public List<OrderListDTO> getAllCompletedOrders() throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        List<OrderListDTO> orderListDTOList = new ArrayList<>();

        String sql = "SELECT idOrder, totalPrice, u.idUser, u.username, u.email FROM `order` INNER JOIN user u USING(idUser) where isCompleted='1'";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    int orderId = rs.getInt("idOrder");
                    int totalPrice = rs.getInt("totalPrice");

                    int userId = rs.getInt("idUser");
                    String username = rs.getString("username");
                    String email = rs.getString("email");
                    OrderListDTO dto = new OrderListDTO(orderId, totalPrice, userId, username, email);
                    orderListDTOList.add(dto);
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Fejl under indlæsning af bøger og forfattere fra databasen");
        }
        return orderListDTOList;
    }

}
