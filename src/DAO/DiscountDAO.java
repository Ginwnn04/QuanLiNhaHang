/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DiscountDTO;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.Timestamp;


/**
 *
 * @author quang
 */
public class DiscountDAO {
    
    public ArrayList<DiscountDTO> read() {
        ArrayList<DiscountDTO> list = new ArrayList<>();
        String query = "SELECT * FROM tb_discounts WHERE isdeleted = FALSE";
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
    
    public boolean insert(DiscountDTO discount) {
        String query = "INSERT INTO tb_discounts VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setString(1, discount.getId());
            pstm.setString(2, discount.getName());
            pstm.setString(3, discount.getDes());
            pstm.setLong(4, discount.getMinimum());
            pstm.setInt(5, discount.getRemaining());
            pstm.setLong(6, discount.getValue());
            pstm.setString(7, discount.getType());
            pstm.setTimestamp(8, new Timestamp(discount.getExpiredTime().getTime()));
            pstm.setBoolean(9, discount.isIsDelete());
            pstm.setTimestamp(10, new Timestamp(discount.getCreateTime().getTime()));
            pstm.setTimestamp(11, new Timestamp(discount.getUpdateTime().getTime()));
            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return false;
    }
    
    public boolean update(DiscountDTO discount) {
        String query = "UPDATE tb_discounts SET name = ?, description = ?, minimum = ?, remaining = ?, value = ?, type = ?, expired_time = ?, create_time = ?, update_time = ?, isdeleted = ? WHERE id = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setString(1, discount.getName());
            pstm.setString(2, discount.getDes());
            pstm.setLong(3, discount.getMinimum());
            pstm.setInt(4, discount.getRemaining());
            pstm.setLong(5, discount.getValue());
            pstm.setString(6, discount.getType());
            pstm.setTimestamp(7, new Timestamp(discount.getExpiredTime().getTime()));
            pstm.setTimestamp(8, new Timestamp(discount.getCreateTime().getTime()));
            pstm.setTimestamp(9, new Timestamp(discount.getUpdateTime().getTime()));
            pstm.setBoolean(10, discount.isIsDelete());
            pstm.setString(11, discount.getId());
            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
            e.printStackTrace();
        } 
        return false;
    }
}
