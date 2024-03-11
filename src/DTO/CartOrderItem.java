/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import GUI.Comp.PanelConfirmOrder;

/**
 *
 * @author pc
 */
public class CartOrderItem {
    private String nameItem;
    private double price;
    private double total;
    private int quantity;
    private PanelConfirmOrder panel;
    private boolean isDelete;
    public CartOrderItem(String nameItem, double price, int quantity) {
        this.nameItem = nameItem;
        this.price = price;
        this.quantity = quantity;
        this.total = quantity * price;
        panel = createPanel();
        isDelete = false;
    }

    public String getNameItem() {
        return nameItem;
    }

    public PanelConfirmOrder getPanel() {
        return panel;
    }
    
    public void reload() {
        quantity = panel.getQuantity();
        if (quantity == 0) {
            isDelete = true;
        }
    }
    
    public PanelConfirmOrder createPanel() {
        PanelConfirmOrder pn = new PanelConfirmOrder();
        pn.setName(nameItem);
        pn.insertData(nameItem, price, quantity);
        return pn;
    }
    
    public String nameItem() {
        return nameItem;
    }

    public void setItemID(String nameItem) {
        this.nameItem = nameItem;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    
    
}
