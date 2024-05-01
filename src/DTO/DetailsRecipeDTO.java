/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author quang
 */
public class DetailsRecipeDTO {
    private long id;
    private int quantity;
    private String unit;
    private long ingredientID;
    private long recipeID;

    public DetailsRecipeDTO() {
    }

    
    
    public DetailsRecipeDTO(long id, int quantity, String unit, long ingredientID, long recipeID) {
        this.id = id;
        this.quantity = quantity;
        this.unit = unit;
        this.ingredientID = ingredientID;
        this.recipeID = recipeID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public long getIngredientID() {
        return ingredientID;
    }

    public void setIngredientID(long ingredientID) {
        this.ingredientID = ingredientID;
    }

    public long getRecipeID() {
        return recipeID;
    }

    public void setRecipeID(long recipeID) {
        this.recipeID = recipeID;
    }
    
    
}
