/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.MenuItem;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author quang
 */
public class MenuItemDAO {
    
    public ArrayList<MenuItem> readMenuItem() {
//        String query = "SELECT * FROM tb_menu_item WHERE \"imagePath\" != ''";
        String query = "SELECT * FROM tb_menu_item";
        try(Connection con = Helper.ConnectDB.openConnect(); PreparedStatement pstm = con.prepareStatement(query);) {
            ResultSet rs = pstm.executeQuery();
            ArrayList<MenuItem> list = new ArrayList<>();
            while(rs.next()) {
                MenuItem menuItem = new MenuItem();
                menuItem.setId(rs.getString("id"));
                menuItem.setCode(rs.getString("code"));
                menuItem.setName(rs.getString("name"));
                menuItem.setDescription(rs.getString("description"));
                menuItem.setIngredient(rs.getString("ingredients"));
                menuItem.setImage(rs.getString("imagePath"));
                menuItem.setPrice(rs.getInt("price"));
                menuItem.setProfit(rs.getInt("profit"));
                menuItem.setIsDelete(rs.getBoolean("isdeleted"));
                menuItem.setStatusID(rs.getString("statusid"));
                menuItem.setCategoryID(rs.getString("categoryid"));
                menuItem.setCreateTime(rs.getString("createtime"));
                menuItem.setUpdateTime(rs.getString("updatetime"));
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
