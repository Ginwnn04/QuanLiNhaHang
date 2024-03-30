package DTO;

import GUI.Comp.PanelConfirmOrder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class DetailOrderDTO {
    private long id;
    private String name;
    private long price;
    private long profit;
    private int quantity;
    private long total;
    private boolean isDelete;
    private long itemID;
    private long orderID;
    private long invoiceID;
    private PanelConfirmOrder cartOder;
    
    
    
    
    public DetailOrderDTO(String name, long price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity > 1 ? quantity : 1;
        this.total = price * quantity;
        createCartOrder();
        isDelete = false;
    }

    public PanelConfirmOrder createCartOrder() {
        if (quantity == 0) {
            isDelete = true;
            cartOder = null;
        }
        else {
            PanelConfirmOrder cartOder1 = new PanelConfirmOrder();
            cartOder1.insertData(name, price, quantity);
            cartOder = cartOder1;
            rerender();
        }
        return cartOder;
    }
    
    public void rerender() {
        if (cartOder != null) {
            quantity = cartOder.getQuantity();
            total = quantity * price;
        }
        else {
            quantity = 0;
        }
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getProfit() {
        return profit;
    }

    public void setProfit(long profit) {
        this.profit = profit;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public long getItemID() {
        return itemID;
    }

    public void setItemID(long itemID) {
        this.itemID = itemID;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public long getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }
    
    
    
    
}
