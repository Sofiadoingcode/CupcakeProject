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

public int getToppingId(){

        switch (topping) {
            case "Chocolate":
                return 1;
            case "Blueberry":
                return 2;
            case "Rasberry":
                return 3;
            case "Crispy":
                return 4;
            case "Strawberry":
                return 5;
            case "Rum/Raisin":
                return 6;
            case "Orange":
                return 7;
            case "Lemon":
                return 8;
            case "Bluecheese":
                return 9;

        }
        return 0;
}

    public int getBottomID(){

        switch (bottom) {
            case "Chocolate":
                return 1;
            case "Vanilla":
                return 2;
            case "Nutmeg":
                return 3;
            case "Pistacio":
                return 4;
            case "Almond":
                return 5;

        }
        return 0;
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
