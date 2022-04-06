package dat.startcode.model.DTOs;

public class OrderListDTO {
    private int orderId;
    private int totalPrice;
//    private boolean isCompleted;
    private int userID;
    private String userUsername;
    private String userEmail;

    public OrderListDTO(int orderId, int totalPrice, int userID, String userUsername, String userEmail) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.userID = userID;
        this.userUsername = userUsername;
        this.userEmail = userEmail;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
}
