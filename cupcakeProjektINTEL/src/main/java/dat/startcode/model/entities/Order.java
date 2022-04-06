package dat.startcode.model.entities;

public class Order {
    private int orderId;
    private int userId;
    private int totalPrice;
    private boolean isCompleted;

    public Order(int orderId, int userId, int totalPrice, boolean isCompleted) {
        this.orderId = orderId;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.isCompleted = isCompleted;
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
