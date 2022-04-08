package dat.startcode.model.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime now;
    private int orderId;
    private int userId;
    private int totalPrice;
    private boolean isCompleted;
    private ArrayList<OrderLine> OrderLines;

    public Order(int orderId, int userId, int totalPrice, boolean isCompleted, ArrayList<OrderLine> OrderLines) {
        this.orderId = orderId;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.isCompleted = isCompleted;
        this.OrderLines = OrderLines;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
