/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.MenuItemStatusDAO;
import DTO.MenuItemStatusDTO;

/**
 *
 * @author quang
 */
public class MenuItemStatusBUS {
    private MenuItemStatusDAO menuItemStatusDAO = new MenuItemStatusDAO();
    
     public MenuItemStatusDTO findItemStatusByID(String id) {
         return menuItemStatusDAO.findByID(id);
     }
    
}
