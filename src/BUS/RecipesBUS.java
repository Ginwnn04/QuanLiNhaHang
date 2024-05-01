/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.RecipesDAO;
import DTO.RecipesDTO;
import java.util.ArrayList;

public class RecipesBUS {
    private RecipesDAO recipesDAO = new RecipesDAO();
    private ArrayList<RecipesDTO> listRecipes = new ArrayList<>();
    
    public ArrayList<RecipesDTO> getAllData() {
        listRecipes = recipesDAO.readData();
        return listRecipes;
    }

    public void insertData(int id, String name) {
        recipesDAO.insertData(id, name);
    }

    public void deleteData(int id) {
        try {
            recipesDAO.deleteData(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateData(int id, String newName) {
        recipesDAO.updateData(id, newName);
    }
    public boolean isIdExist(int id) throws Exception {
        ArrayList<RecipesDTO> listRecipes = recipesDAO.getAllData();
        for (RecipesDTO recipe : listRecipes) {
            if (recipe.getId() == id) {
                return true; // ID đã tồn tại
            }
        }
        return false; // ID không tồn tại
    }
public ArrayList<RecipesDTO> getAllActiveRecipes() {
    RecipesDAO recipesDAO = new RecipesDAO();
    return recipesDAO.getAllActiveRecipes();
}
}