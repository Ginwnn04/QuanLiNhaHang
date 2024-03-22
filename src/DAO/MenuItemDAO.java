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
    
    public ArrayList<MenuItemDTO> readMenuItem() {
//        String query = "SELECT item.id, item.name, item.price, item.profit, item.isdeleted, item.\"imagePath\", item.\"createTime\", item.\"updateTime\", status.name, cate.name \n" +
//                        "FROM tb_menu_item_status AS status \n" +
//                        "JOIN tb_menu_item AS item ON status.id = item.statusid \n" +
//                        "JOIN tb_categories AS cate ON item.categoryid = cate.id";

        String query = "SELECT item.id, item.name, item.price, item.profit, item.isdeleted, item.\"imagePath\", item.\"createTime\", item.\"updateTime\", status.name AS status, cate.name AS category FROM tb_menu_item_status AS status JOIN tb_menu_item AS item ON status.id = item.statusid JOIN tb_categories AS cate ON item.categoryid = cate.id";
        try(Connection con = Helper.ConnectDB.openConnect(); PreparedStatement pstm = con.prepareStatement(query);) {
            ResultSet rs = pstm.executeQuery();
            ArrayList<MenuItemDTO> list = new ArrayList<>();
            while(rs.next()) {
                MenuItemDTO menuItem = new MenuItemDTO();
                menuItem.setId(rs.getString("id"));
                menuItem.setName(rs.getString("name"));
                menuItem.setPrice(rs.getDouble("price"));
                menuItem.setProfit(rs.getDouble("profit"));
                menuItem.setImage(rs.getString("imagePath"));
                menuItem.setIsDelete(rs.getBoolean("isdeleted"));
                menuItem.setUpdateTime(rs.getString("updateTime"));
                menuItem.setCreateTime(rs.getString("createTime"));
                menuItem.setStatus(rs.getString("status"));
                menuItem.setCategory(rs.getString("category"));
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
