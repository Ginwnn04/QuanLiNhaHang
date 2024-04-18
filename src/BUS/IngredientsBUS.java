/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author Tai
 */
import DAO.IngredientsDAO;
import DTO.IngredientsDTO;
import java.util.ArrayList;

public class IngredientsBUS {
    private IngredientsDAO ingredientsDAO = new IngredientsDAO();
    private ArrayList<IngredientsDTO> listIngredients = new ArrayList<>();
    
    public ArrayList<IngredientsDTO> getAllIngredients() throws Exception {
        listIngredients = ingredientsDAO.getAllIngredients();
        return listIngredients;
    }
    public IngredientsDTO getIngredientById(int id) throws Exception {
        return ingredientsDAO.getIngredientById(id);
    }
    
    public boolean addIngredient(IngredientsDTO ingredient) throws Exception {
        return ingredientsDAO.addIngredient(ingredient);
    }
    
    public boolean updateIngredient(IngredientsDTO ingredient) throws Exception {
        return ingredientsDAO.updateIngredient(ingredient);
    }
    public boolean deleteIngredient(int id) throws Exception {
        return ingredientsDAO.deleteIngredient(id);
    }
    public boolean setIngredientAsDeleted(int id) throws Exception {
        return ingredientsDAO.setIngredientAsDeleted(id);
    }

    public ArrayList<IngredientsDTO> getAllActiveIngredients() throws Exception {
        return ingredientsDAO.getAllActiveIngredients();
    }
}
