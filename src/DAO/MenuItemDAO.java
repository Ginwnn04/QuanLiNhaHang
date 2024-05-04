/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.MenuItemDTO;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author quang
 */
public class MenuItemDAO {
    
    public ArrayList<MenuItemDTO> readData() {
        String query = "SELECT * FROM tb_menu_item WHERE isdeleted = FALSE";
        try(PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query);) {
            ResultSet rs = pstm.executeQuery();
            ArrayList<MenuItemDTO> list = new ArrayList<>();
            while(rs.next()) {
                MenuItemDTO menuItem = new MenuItemDTO();
                menuItem.setId(rs.getLong("id"));
                menuItem.setName(rs.getString("name"));
                menuItem.setPrice(rs.getLong("price"));
                menuItem.setProfit(rs.getLong("profit"));
                menuItem.setImage(rs.getString("image_path"));
                menuItem.setIsDelete(rs.getBoolean("isdeleted"));
                menuItem.setUpdateTime(rs.getDate("update_time"));
                menuItem.setCreateTime(rs.getDate("create_time"));
                menuItem.setStatusID(rs.getString("statusid"));
                menuItem.setCategoryID(rs.getLong("categoryid"));
                menuItem.setDescription(rs.getString("description"));
                menuItem.setIngredient(rs.getString("ingredients"));
                list.add(menuItem);
            }
            return list;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
    
}
