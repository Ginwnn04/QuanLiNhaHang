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
        String query = "SELECT item.id, item.name, item.price, item.profit, item.description, item.ingredients, item.isdeleted, item.\"image_path\", item.\"create_time\", item.\"update_time\", status.name AS status, cate.name AS category FROM tb_menu_item_status AS status JOIN tb_menu_item AS item ON status.id = item.statusid JOIN tb_categories AS cate ON item.categoryid = cate.id";
        try(Connection con = Helper.ConnectDB.openConnect(); PreparedStatement pstm = con.prepareStatement(query);) {
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
                menuItem.setUpdateTime(rs.getString("update_time"));
                menuItem.setCreateTime(rs.getString("create_time"));
                menuItem.setStatus(rs.getString("status"));
                menuItem.setCategory(rs.getString("category"));
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
