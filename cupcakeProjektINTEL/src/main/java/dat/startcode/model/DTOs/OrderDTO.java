package dat.startcode.model.DTOs;

import dat.startcode.model.entities.OrderLine;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class OrderDTO {
    private int id;
    private ArrayList<OrderLine> basket = new ArrayList<>();
    private int idOrderLine =0; //JUST A TEMP id. This will be replaced when saved in the DB.


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

        orderLine.setIdOrderLine(idOrderLine);
        idOrderLine++;
        basket.add(orderLine);
        for (OrderLine item:
             basket) {
        }
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

   public void deleteOrderLine(HttpServletRequest request) {
        int deleteId;
        try {
            deleteId = Integer.parseInt(request.getParameter("delete"));
            for (int i = 0; i < basket.size(); i++) {
                OrderLine item = basket.get(i);
                if (item.getIdOrderLine() == deleteId) {
                    basket.remove(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void changeQuantity(HttpServletRequest request) {
        int quantityMod;
        try {
            String s = request.getParameter("button");
            String[] arrOfStr = s.split(" ",2);
            quantityMod = Integer.parseInt(arrOfStr[0]);
            int id = Integer.parseInt(arrOfStr[1]);
            for (int i = 0; i < basket.size(); i++) {
                OrderLine item = basket.get(i);
                if (item.getIdOrderLine() == id) {
                    item.setQuantity(item.getQuantity()+quantityMod);
                }
                if (item.getQuantity() <=0){
                    basket.remove(i);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
