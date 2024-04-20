/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DiscountDTO;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author quang
 */
public class DiscountDAO {
    
    public ArrayList<DiscountDTO> readData() {
        ArrayList<DiscountDTO> list = new ArrayList<>();
        String query = "SELECT * FROM tb_discounts";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                DiscountDTO discount = new DiscountDTO();
                discount.setId(rs.getString("id"));
                discount.setName(rs.getString("name"));
                discount.setDes(rs.getString("description"));
                discount.setMinimum(rs.getLong("minimum"));
                discount.setRemaining(rs.getInt("remaining"));
                discount.setValue(rs.getLong("value"));
                discount.setType(rs.getString("type"));
                discount.setExpiredTime(rs.getTimestamp("expired_time"));
                discount.setCreateTime(rs.getTimestamp("create_time"));
                discount.setUpdateTime(rs.getTimestamp("update_time"));
                discount.setIsDelete(rs.getBoolean("isdeleted"));
                list.add(discount);
            }
            return list;
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return list;
    }
}
