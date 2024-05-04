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
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.SQLException;
public class IngredientsBUS {
    private IngredientsDAO ingredientsDAO = new IngredientsDAO();
    private ArrayList<IngredientsDTO> listIngredients = new ArrayList<>();
    
    public IngredientsDTO getIngredientById(int id) {
        return ingredientsDAO.getIngredientById(id);
    }
    
    public boolean addIngredient(IngredientsDTO ingredient){
        return ingredientsDAO.addIngredient(ingredient);
    }
    
    public boolean updateIngredient(IngredientsDTO ingredient) {
        return ingredientsDAO.updateIngredient(ingredient);
    }

    public boolean setIngredientAsDeleted(int id) {
        return ingredientsDAO.setIngredientAsDeleted(id);
    }

    public ArrayList<IngredientsDTO> getAllActiveIngredients() {
        return ingredientsDAO.getAllActiveIngredients();
    }
    public boolean checkIngredientExistence(int ingredientId){
        return ingredientsDAO.checkIngredientExistence(ingredientId);
    }

    public int getIngredientQuantity(int ingredientId){
        return ingredientsDAO.getIngredientQuantity(ingredientId);
    }

    public void updateIngredientQuantity(int ingredientId, int newQuantity){
        ingredientsDAO.updateIngredientQuantity(ingredientId, newQuantity);
    }
}
