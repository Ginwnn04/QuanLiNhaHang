/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DiscountDAO;
import DTO.DiscountDTO;
import java.util.ArrayList;

/**
 *
 * @author quang
 */
public class DiscountBUS {
    private DiscountDAO discountDAO = new DiscountDAO();
    
    public ArrayList<DiscountDTO> getAllData() {
        return discountDAO.readData();
    }
}
