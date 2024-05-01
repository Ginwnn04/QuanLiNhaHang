/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;

/**
 *
 * @author quang
 */
public class RecipeDTO {
    private long id;
    private String name;
    private boolean isDelete;
    private ArrayList<DetailsRecipeDTO> listDetails  = new ArrayList<>();

    public RecipeDTO() {
    }

    public RecipeDTO(long id, String name, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.isDelete = isDelete;
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

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public ArrayList<DetailsRecipeDTO> getListDetails() {
        return listDetails;
    }

    public void setListDetails(ArrayList<DetailsRecipeDTO> listDetails) {
        this.listDetails = listDetails;
    }
    
    
}
