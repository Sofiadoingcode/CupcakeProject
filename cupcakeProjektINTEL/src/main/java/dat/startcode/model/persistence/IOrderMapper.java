package dat.startcode.model.persistence;

import dat.startcode.model.DTOs.OrderLineDTO;
import dat.startcode.model.DTOs.OrderListDTO;
import dat.startcode.model.entities.Order;
import dat.startcode.model.entities.OrderLine;
import dat.startcode.model.exceptions.DatabaseException;

import java.sql.SQLException;
import java.util.List;

public interface IOrderMapper {

    public List<OrderListDTO> getAllOrders() throws DatabaseException;
    public List<OrderListDTO> getAllNoneCompletedOrders() throws DatabaseException;
    public List<OrderListDTO> getAllCompletedOrders() throws DatabaseException;
    public boolean deleteOrder(int orderId) throws DatabaseException;
    public boolean updateOrder(int orderId) throws DatabaseException;
    public List<OrderLineDTO> getSingleOrderOrderlines(int orderId) throws DatabaseException;

}
