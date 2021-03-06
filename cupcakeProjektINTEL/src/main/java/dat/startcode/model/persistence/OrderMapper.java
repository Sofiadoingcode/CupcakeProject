package dat.startcode.model.persistence;

import dat.startcode.model.DTOs.OrderLineDTOSOFIA;
import dat.startcode.model.DTOs.OrderListDTO;
import dat.startcode.model.entities.OrderLine;
import dat.startcode.model.entities.User;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderMapper implements IOrderMapper {

    private ConnectionPool connectionPool;

    public OrderMapper(ConnectionPool connectionPool) {

        this.connectionPool = connectionPool;
    }

    public List<OrderListDTO> getAllOrders() throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        List<OrderListDTO> orderListDTOList = new ArrayList<>();

        String sql = "SELECT idOrder, totalPrice, ordertime, u.idUser, u.username, u.email FROM `order` INNER JOIN user u USING(idUser)";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderId = rs.getInt("idOrder");
                    int totalPrice = rs.getInt("totalPrice");
                    int userId = rs.getInt("idUser");
                    String username = rs.getString("username");
                    String email = rs.getString("email");
                    OrderListDTO dto;
                    try {
                        String time = rs.getString("ordertime");
                        dto = new OrderListDTO(orderId, totalPrice, userId, username, email, time);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        dto = new OrderListDTO(orderId, totalPrice, userId, username, email);
                    }
                    orderListDTOList.add(dto);
                    System.out.println(dto);
                }

            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Fejl under indl??sning af b??ger og forfattere fra databasen");
        }
        return orderListDTOList;
    }

    @Override
    public List<OrderListDTO> getAllNoneCompletedOrders() throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        List<OrderListDTO> orderListDTOList = new ArrayList<>();
        String sql = "SELECT idOrder, totalPrice,ordertime, u.idUser, u.username, u.email FROM `order` INNER JOIN user u USING(idUser) where isCompleted='0'";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderId = rs.getInt("idOrder");
                    int totalPrice = rs.getInt("totalPrice");

                    int userId = rs.getInt("idUser");
                    String username = rs.getString("username");
                    String email = rs.getString("email");
                    OrderListDTO dto;
                    try {
                        String time = rs.getString("ordertime");
                        dto = new OrderListDTO(orderId, totalPrice, userId, username, email, time);
                    } catch (SQLException e) {
                        e.printStackTrace();
                        dto = new OrderListDTO(orderId, totalPrice, userId, username, email);
                    }
                    orderListDTOList.add(dto);
                    System.out.println(dto);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Fejl under indl??sning fra databasen");
        }
        return orderListDTOList;
    }


    @Override
    public List<OrderListDTO> getAllCompletedOrders() throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        List<OrderListDTO> orderListDTOList = new ArrayList<>();

        String sql = "SELECT idOrder, totalPrice, u.idUser, u.username, u.email FROM `order` INNER JOIN user u USING(idUser) where isCompleted='1'";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int orderId = rs.getInt("idOrder");
                    int totalPrice = rs.getInt("totalPrice");

                    int userId = rs.getInt("idUser");
                    String username = rs.getString("username");
                    String email = rs.getString("email");
                    OrderListDTO dto = new OrderListDTO(orderId, totalPrice, userId, username, email);
                    orderListDTOList.add(dto);
                }
            }
        } catch (SQLException ex) {
            throw new DatabaseException(ex, "Fejl under indl??sning fra databasen");
        }
        return orderListDTOList;
    }


    @Override
    public boolean deleteOrder(int orderId) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        boolean isDeleted = false;


        try (Connection connection = connectionPool.getConnection()) {

            String sql1 = "delete from orderline where idOrder= ?";
            try (PreparedStatement ps = connection.prepareStatement(sql1)) {
                ps.setInt(1, orderId);
                ps.executeUpdate();
            } catch (Exception E) {
                System.out.println(E);
            }

            String sql = "delete from `order` where idOrder = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    isDeleted = true;
                } else {
                    throw new DatabaseException("Elementet blev ikke fjernet 1");
                }
            } catch (SQLException e) {
                throw new DatabaseException("Elementet blev ikke fjernet 2");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Elementet blev ikke fjernet3 ");
        }
        return isDeleted;
    }

    @Override
    public boolean updateOrder(int orderId) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        boolean isCompleted = false;

        String sql = "";
        int setValue = getIsCompleteValue(orderId);

        if (setValue == 0) {
            sql = "UPDATE `order` SET isCompleted = '1' WHERE idOrder = ?";
        } else {
            sql = "UPDATE `order` SET isCompleted = '0' WHERE idOrder = ?";
        }

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected == 1) {
                    isCompleted = true;
                } else {
                    throw new DatabaseException("Elementet blev ikke fjernet");
                }
            } catch (SQLException e) {
                throw new DatabaseException("Elementet blev ikke fjernet");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Elementet blev ikke fjernet");
        }
        return isCompleted;
    }

    @Override
    public List<OrderLineDTOSOFIA> getSingleOrderOrderlines(int orderId) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");

        List<OrderLineDTOSOFIA> orderLines = new ArrayList<>();

        String sql = "SELECT idorderline, t.idtopping, t.name, b.idbottom, b.name, unitprice, quantity, idOrder FROM `orderline` INNER JOIN topping t USING(idtopping) INNER JOIN bottom b USING(idbottom) where idOrder = ?";



        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {

                ps.setInt(1,orderId);
                ResultSet rs = ps.executeQuery();

                while (rs.next())
                {

                    int idorderline = rs.getInt("idorderline");
                    int toppingId = rs.getInt("idtopping");
                    String toppingName= rs.getString(3);
                    int bottomId = rs.getInt("idbottom");
                    String bottomName = rs.getString(5);
                    int unitprice = rs.getInt("unitprice");
                    int quantity = rs.getInt("quantity");
                    int idOrder = rs.getInt("idOrder");



                    OrderLineDTOSOFIA orderLineDTOSOFIA;
                    orderLineDTOSOFIA = new OrderLineDTOSOFIA(idorderline, unitprice, quantity, toppingId, toppingName, bottomId, bottomName, idOrder);
                    orderLines.add(orderLineDTOSOFIA);
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Fejl under indl??sning fra databasen");
        }


        return orderLines;



    }

    private int getIsCompleteValue(int orderId) throws DatabaseException {
        int value;

        String sql = "SELECT `isCompleted` from `order` where idOrder=?";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, orderId);
                ResultSet rs = ps.executeQuery();
                int isCompleted = 0;
                while (rs.next()) {
                    isCompleted = rs.getInt("isCompleted");
                }
                value = isCompleted;

            } catch (SQLException e) {
                throw new DatabaseException("Elementet blev ikke fjernet");
            }
        } catch (SQLException e) {
            throw new DatabaseException("Elementet blev ikke fjernet");
        }

        return value;
    }


    public void insertOrder(User user, List<OrderLine> basket, int totalPrice) throws DatabaseException {

        int idKey = 0;
        Logger.getLogger("web").log(Level.INFO, "");


        try (Connection connection = connectionPool.getConnection()) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            String sql = "INSERT INTO `cupcakedatabase`.`order` ( idUser, isCompleted, ordertime,totalPrice) VALUES (?, 0,?,?) ";
            try (PreparedStatement ps1 = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps1.setInt(1, user.getUserId());
                ps1.setString(2, dtf.format(now));
                ps1.setInt(3, totalPrice);
                int rowsAffected = ps1.executeUpdate();


                //return the generated primary key from sql
                ResultSet generatedKeys = ps1.getGeneratedKeys();
                if (generatedKeys.next()) {
                    idKey = generatedKeys.getInt(1);
                }

            } catch (SQLException e) {
                System.out.println(e);
            }
            try {
                String sql2 = "insert into orderline(idTopping, idBottom, quantity, idOrder, unitPrice) values (?, ?,?, ?,?)";
                for (OrderLine item : basket) {

                    PreparedStatement ps2 = connection.prepareStatement(sql2);
                    ps2.setInt(1, item.getToppingId());
                    ps2.setInt(2, item.getBottomId());
                    ps2.setInt(3, item.getQuantity());
                    ps2.setInt(4, idKey);
                    ps2.setInt(5, item.getOrderLinePrice() / item.getQuantity());
                    ps2.executeUpdate();
                }
            } catch (Exception E) {
                System.out.println(E);
                System.out.println("dasohaofhasjoi FUCK ITS NOT WORKING AOH()y%`=(ij)?h#%");
            }

        } catch (SQLException ex) {
            System.out.println(ex + "error connecting to db");
            System.out.println("whydoes it not work");
        }
    }
}

