/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import BUS.MenuItemStatusBUS;
import GUI.Comp.Panel.PanelProductOrder;
import java.util.Date;

/**
 *
 * @author quang
 */
public class MenuItemDTO {
    private long id;
    private String name;
    private String description;
    private String ingredient;
    private String image;
    private long price;
    private long profit;
    private boolean isDelete;
    private String statusID;
    private long categoryID;
    private Date createTime;
    private Date updateTime;      
    
    
    private boolean isSelected;
    private int index;
    private PanelProductOrder panelProductOrder;
    
    
    public MenuItemDTO() {
        
    }

    
    
    public MenuItemDTO(long id, String name, String description, String ingredient, String image, long price, long profit, boolean isDelete, String statusID, long categoryID, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ingredient = ingredient;
        this.image = image;
        this.price = price;
        this.profit = profit;
        this.isDelete = isDelete;
        this.statusID = statusID;
        this.categoryID = categoryID;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public PanelProductOrder createCart(int index) {
        this.index = index;
        panelProductOrder = new PanelProductOrder();
        MenuItemStatusDTO menuItemStatusDTO = new MenuItemStatusBUS().findItemStatusByID(statusID);
        panelProductOrder.insertData(index, name, price, menuItemStatusDTO.getName(), image, description, ingredient);
//        System.out.println(description + " " + ingredient + " 1");
        
        return panelProductOrder;
    }

    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getStatusID() {
        return statusID;
    }

    public void setStatusID(String statusID) {
        this.statusID = statusID;
    }

    public long getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    
    
}
