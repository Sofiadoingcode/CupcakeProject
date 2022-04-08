package dat.startcode.model.DTOs;

public class OrderLineDTO {
    private int orderlineId;
    private int unitPrice;
    private int quantity;
    private int toppingId;
    private String toppingName;
    private int bottomId;
    private String bottomName;
    private int orderId;

    public OrderLineDTO(int orderlineId, int unitPrice, int quantity, int toppingId, String toppingName, int bottomId, String bottomName, int orderId) {
        this.orderlineId = orderlineId;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.toppingId = toppingId;
        this.toppingName = toppingName;
        this.bottomId = bottomId;
        this.bottomName = bottomName;
        this.orderId = orderId;
    }


    public int getOrderlineId() {
        return orderlineId;
    }

    public void setOrderlineId(int orderlineId) {
        this.orderlineId = orderlineId;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public int getBottomId() {
        return bottomId;
    }

    public void setBottomId(int bottomId) {
        this.bottomId = bottomId;
    }

    public String getBottomName() {
        return bottomName;
    }

    public void setBottomName(String bottomName) {
        this.bottomName = bottomName;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
