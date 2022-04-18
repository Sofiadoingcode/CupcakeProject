package dat.startcode.model.DTOs;

import dat.startcode.model.entities.OrderLine;

import java.util.ArrayList;

public class OrderDTO {
    private int id;
    private ArrayList<OrderLine> basket = new ArrayList<>();

    public ArrayList<OrderLine> addToBasket(OrderLine orderLine) {
        //checks if quantity is less than 0, then doe
        if (orderLine.getQuantity() <= 0) {
            return basket;
        }
        //adds to the quantity of an already existing orderline if item is already in the basket.
        for (int i = 0; i < basket.size(); i++) {
            OrderLine item = basket.get(i);
            if (orderLine.getBottomId() == item.getBottomId() && orderLine.getToppingId() == item.getToppingId()) {
                item.setQuantity(item.getQuantity() + orderLine.getQuantity());
                return basket;
            }

        }


        basket.add(orderLine);
        return basket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<OrderLine> getBasket() {
        return basket;
    }

    public void setBasket(ArrayList<OrderLine> basket) {
        this.basket = basket;
    }

    public int totalPrice() {
        int price = 0;
        for (OrderLine item :
                basket) {
            price = +item.getOrderLinePrice();

        }


        return price;
    }
}
