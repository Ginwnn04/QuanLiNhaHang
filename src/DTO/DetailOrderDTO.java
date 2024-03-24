package DTO;

import GUI.Comp.PanelConfirmOrder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class DetailOrderDTO {
    private int id;
    private String name;
    private double price;
    private double profit;
    private int quantity;
    private double total;
    private boolean isDelete;
    private int itemID;
    private int orderID;
    private int invoiceID;
    private PanelConfirmOrder cartOder;
    
    
    
    
    public DetailOrderDTO(String name, double price, int quantity) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }
    
    
    
    
}
