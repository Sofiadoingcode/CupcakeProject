package dat.startcode.model.DTOs;

public class OrderLineDTO {
    private String toppingName;
    private String bottomName;
    private int toppingPrice;
    private int bottomPrice;
    private String name;
    private int price;
    private int toppingId;
    private int bottomId;


    public OrderLineDTO(String toppingName, String bottomName, int toppingPrice, int bottomPrice) {
        this.toppingName = toppingName;
        this.bottomName = bottomName;
        this.toppingPrice = toppingPrice;
        this.bottomPrice = bottomPrice;
    }
    public OrderLineDTO(String name, int price, int id){
        this.name=name;
        this.price=price;
        this.toppingId=id;
        this.bottomId=id;
    }

    @Override
    public String toString() {
        return "OrderLineDTO{" +
                "toppingName='" + toppingName + '\'' +
                ", bottomName='" + bottomName + '\'' +
                ", toppingPrice=" + toppingPrice +
                ", bottomPrice=" + bottomPrice +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", toppingId=" + toppingId +
                ", bottomId=" + bottomId +
                '}';
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public String getBottomName() {
        return bottomName;
    }

    public void setBottomName(String bottomName) {
        this.bottomName = bottomName;
    }

    public int getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(int toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    public int getBottomPrice() {
        return bottomPrice;
    }

    public void setBottomPrice(int bottomPrice) {
        this.bottomPrice = bottomPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getToppingId() {
        return toppingId;
    }

    public void setToppingId(int toppingId) {
        this.toppingId = toppingId;
    }

    public int getBottomId() {
        return bottomId;
    }

    public void setBottomId(int bottomId) {
        this.bottomId = bottomId;
    }
}
