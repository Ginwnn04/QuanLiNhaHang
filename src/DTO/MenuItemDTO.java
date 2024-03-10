/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author quang
 */
public class MenuItemDTO {
    private String id;
    private String code;
    private String name;
    private String description;
    private String ingredient;
    private String image;
    private double price;
    private double profit;
    private boolean isDelete;
    private String status;
    private String category;
    private String createTime;
    private String updateTime;
    private String statusProduct;
    private String categories;      
            
    public MenuItemDTO() {
        
    }

    
    
    public MenuItemDTO(String id, String code, String name, String description, String ingredient, String image, double price, double profit, boolean isDelete, String status, String category, String createTime, String updateTime, String statusProduct, String categories) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.ingredient = ingredient;
        this.image = image;
        this.price = price;
        this.profit = profit;
        this.isDelete = isDelete;
        this.status = status;
        this.category = category;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.statusProduct = statusProduct;
        this.categories = categories;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getStatusProduct() {
        return statusProduct;
    }

    public void setStatusProduct(String statusProduct) {
        this.statusProduct = statusProduct;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
    
    
    
}
