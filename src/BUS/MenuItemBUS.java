/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.MenuItemDAO;
import DTO.MenuItemDTO;
import java.util.ArrayList;

/**
 *
 * @author quang
 */
public class MenuItemBUS {
    private MenuItemDAO menuItemDAO = new MenuItemDAO();
    private ArrayList<MenuItemDTO> listMenuItem = new ArrayList<>();
    
    public ArrayList<MenuItemDTO> getAllData() {
        listMenuItem = menuItemDAO.readMenuItem();
        return listMenuItem;
    }
}
