package dat.startcode.model.persistence;

import dat.startcode.model.DTOs.OrderLineDTO;
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

public class CupcakeMapper {


    private ConnectionPool connectionPool;

    public CupcakeMapper(ConnectionPool connectionPool) {

        this.connectionPool = connectionPool;
    }

    public OrderLineDTO getOrderLine(int toppingId, int bottomId) throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String toppingName="";
        int toppingPrice=0;
        String bottomName="";
        int bottomPrice=0;
        System.out.println(bottomId);

        OrderLineDTO orderLineDTO;


        String sql = "SELECT name, price FROM `topping` WHERE idtopping=?";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1,toppingId);
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    toppingPrice = rs.getInt("price");

                    toppingName = rs.getString("name");
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Fejl under indlæsning fra databasen");
        }
        sql = "SELECT name , price FROM `bottom` WHERE idbottom=?";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1,bottomId);
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    bottomPrice = rs.getInt("price");

                    bottomName = rs.getString("name");

                }
                orderLineDTO=new OrderLineDTO(toppingName,bottomName, toppingPrice,bottomPrice);
                System.out.println(orderLineDTO);
            }

        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Fejl under indlæsning fra databasen");
        }

        return orderLineDTO;
    }


    public List<OrderLineDTO> getToppingLine() throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String toppingName;
        int toppingPrice;
        int toppingId;
        OrderLineDTO orderLineDTO;
        List<OrderLineDTO> orderLineDTOList=new ArrayList<>();


        String sql = "SELECT name , price, idtopping FROM `topping`";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    toppingPrice = rs.getInt("price");

                    toppingName = rs.getString("name");
                    toppingId = rs.getInt("idtopping");
                    orderLineDTO=new OrderLineDTO(toppingName,toppingPrice, toppingId);
                    orderLineDTOList.add(orderLineDTO);
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Fejl under indlæsning fra databasen");
        }
        return orderLineDTOList;
    }



    public List<OrderLineDTO> getBottomLine() throws DatabaseException {
        Logger.getLogger("web").log(Level.INFO, "");
        String bottomName;
        int bottomPrice;
        int bottomId;
        OrderLineDTO orderLineDTO;
        List<OrderLineDTO> orderLineDTOList=new ArrayList<>();


        String sql = "SELECT name , price, idbottom FROM `bottom`";

        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    bottomPrice = rs.getInt("price");
                    bottomId= rs.getInt("idbottom");

                    bottomName = rs.getString("name");
                    orderLineDTO=new OrderLineDTO(bottomName,bottomPrice, bottomId);
                    orderLineDTOList.add(orderLineDTO);
                }
            }
        }
        catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Fejl under indlæsning fra databasen");
        }
        return orderLineDTOList;
    }

}
