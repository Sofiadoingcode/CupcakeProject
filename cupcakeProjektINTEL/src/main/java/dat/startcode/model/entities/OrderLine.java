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
    private int orderLinePrice;
    private int idOrderLine;

    public OrderLine(String toppingName, String bottomName, int toppingPrice, int bottomPrice, int quantity, int orderLinePrice) {
        this.toppingName = toppingName;
        this.bottomName = bottomName;
        this.toppingPrice = toppingPrice;
        this.bottomPrice = bottomPrice;
        this.quantity = quantity;
        this.orderLinePrice = orderLinePrice;
    }

    public OrderLine(String toppingName, String bottomName, int toppingPrice, int bottomPrice, int quantity, int bottomId, int toppingId, int orderLinePrice) {
        this.toppingName = toppingName;
        this.bottomName = bottomName;
        this.toppingPrice = toppingPrice;
        this.bottomPrice = bottomPrice;
        this.quantity = quantity;
        this.bottomId = bottomId;
        this.toppingId = toppingId;
        this.orderLinePrice = orderLinePrice;
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

    public void setIdOrderLine(int idOrderLine) {
        this.idOrderLine = idOrderLine;
    }

    public int getIdOrderLine() {
        return idOrderLine;
    }

    /*
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
        */


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

    public int getOrderLinePrice() {
        return (toppingPrice + bottomPrice) * quantity;
    }

    public void setOrderLinePrice(int orderLinePrice) {
        this.orderLinePrice = orderLinePrice;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "toppingName='" + toppingName + '\'' +
                ", bottomName='" + bottomName + '\'' +
                ", toppingPrice=" + toppingPrice +
                ", bottomPrice=" + bottomPrice +
                ", quantity=" + quantity +
                ", idOrder=" + idOrder +
                ", bottomId=" + bottomId +
                ", toppingId=" + toppingId +
                ", orderLinePrice=" + orderLinePrice +
                ", idOrderLine=" + idOrderLine +
                '}';
    }
}

