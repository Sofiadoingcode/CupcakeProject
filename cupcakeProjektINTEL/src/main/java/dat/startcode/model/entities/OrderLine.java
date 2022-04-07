package dat.startcode.model.entities;

public class OrderLine {
    private String topping;
    private String bottom;
    private int unitPrice;
    private int quantity;
    private int idOrder;

    public OrderLine(String topping, String bottom, int quantity){
    this.topping=topping;
    this.bottom=bottom;
    this.quantity=quantity;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public String getBottom() {
        return bottom;
    }

    public String getTopping() {
        return topping;
    }


    @Override
    public String toString() {
        return "OrderLine{" +
                "topping='" + topping + '\'' +
                ", bottom='" + bottom + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                ", idOrder=" + idOrder +
                '}';
    }
}
