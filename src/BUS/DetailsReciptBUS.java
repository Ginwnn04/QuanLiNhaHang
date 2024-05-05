/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DetailsRecipeDAO;
import DTO.DetailsRecipeDTO;
import java.util.ArrayList;

/**
 *
 * @author quang
 */
public class DetailsReciptBUS {
    private DetailsRecipeDAO detailsRecipeDAO = new DetailsRecipeDAO();
    
    public ArrayList<DetailsRecipeDTO> readByIDItem(long itemid) {
        return detailsRecipeDAO.readByIDItem(itemid);
    }
    
    public boolean updateDetails(DetailsRecipeDTO x) {
        return detailsRecipeDAO.update(x);
    }
    
    
}
