package dat.startcode.model.entities;

public class OrderLine {
    private String toppingName;
    private String bottomName;
    private int toppingPrice;
    private int bottomPrice;
    private int quantity;
    private int idOrder;
    private int bottomId;
    private int toppingId;

    public OrderLine(String toppingName, String bottomName, int toppingPrice, int bottomPrice, int quantity, int bottomId){
    this.toppingName=toppingName;
    this.bottomName=bottomName;
        this.toppingPrice = toppingPrice;
        this.bottomPrice = bottomPrice;
        this.quantity=quantity;
        this.bottomId = bottomId;
    }
    public OrderLine(String toppingName, String bottomName, int toppingPrice, int bottomPrice, int quantity){
        this.toppingName=toppingName;
        this.bottomName=bottomName;
        this.toppingPrice = toppingPrice;
        this.bottomPrice = bottomPrice;
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





    @Override
    public String toString() {
        return "OrderLine{" +
                "topping='" + toppingName + '\'' +
                ", bottom='" + bottomName + '\'' +
                ", quantity=" + quantity +
                ", idOrder=" + idOrder +
                '}';
    }

    public int getBottomPrice() {
        return bottomPrice;
    }

    public void setBottomPrice(int bottomPrice) {
        this.bottomPrice = bottomPrice;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(int toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    public void setBottomName(String bottomName) {
        this.bottomName = bottomName;
    }
    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }
    public String getToppingName() {
        return toppingName;
    }
    public String getBottomName() {
        return bottomName;
    }

    public int getBottomId() {
        return bottomId;
    }

    public void setBottomId(int bottomId) {
        this.bottomId = bottomId;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }
}

