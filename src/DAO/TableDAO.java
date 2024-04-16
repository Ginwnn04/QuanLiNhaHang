/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TableDTO;
import Helper.DataProvider;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author quang
 */
public class TableDAO {
    
    public ArrayList<TableDTO> readAllData() {
        ArrayList<TableDTO> list = new ArrayList<>();
        String query = "SELECT * FROM tb_tables";
        try{
            PreparedStatement pstm = DataProvider.getInstance().GetConnect().prepareStatement(query);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                TableDTO table = new TableDTO();
                table.setId(rs.getLong("id"));
                table.setName(rs.getString("name"));
                table.setDes(rs.getString("des"));
                table.setCustomerCode(rs.getString("customer_code"));
                table.setStatus(rs.getString("statusid"));
                table.setCreateTime(rs.getDate("create_time"));
                table.setUpdateTime(rs.getDate("update_time"));
                table.setIsDelete(rs.getBoolean("isdeleted"));
                list.add(table);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return list;  
    }
    
    public boolean insertData(TableDTO table) {
        String query = "INSERT INTO tb_tables VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = Helper.ConnectDB.openConnect(); PreparedStatement pstm = con.prepareStatement(query)) {
            pstm.setLong(1, table.getId());
            pstm.setString(2, table.getName());
            pstm.setString(3, table.getDes());
            pstm.setBoolean(4, false);
            pstm.setString(5, "");
            pstm.setString(6, table.getStatus());
            
            // Date này là sql.Date chứ không phải util.Date
            Date sqlDateUpdate = new Date(table.getUpdateTime().getTime());
            Date sqlDateCreate = new Date(table.getCreateTime().getTime());
            


            pstm.setDate(7, sqlDateUpdate);
            pstm.setDate(8, sqlDateCreate);
            pstm.setString(9, table.getNote());
            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    

    
    public boolean deleteData(String listTableDelete) {
        String query = "DELETE FROM tb_tables WHERE id IN (SELECT unnest(string_to_array(?, ','))::bigint)";
        try{
            PreparedStatement pstm = DataProvider.getInstance().GetConnect().prepareStatement(query);
            pstm.setString(1, listTableDelete);
            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateData(TableDTO table) {
        String query = "UPDATE tb_tables SET name = ?, des = ?, isdeleted = ?, customer_code = ?, statusid = ?, update_time = ? WHERE id = ?";
        try {
            PreparedStatement pstm = DataProvider.getInstance().GetConnect().prepareStatement(query);
            pstm.setString(1, table.getName());
            pstm.setString(2, table.getDes());
            pstm.setBoolean(3, table.isIsDelete());
            pstm.setString(4, table.getCustomerCode());
            pstm.setString(5, table.getStatus());
            
            
            Date sqlDateUpdate = new Date(table.getUpdateTime().getTime());
            
            pstm.setDate(6, sqlDateUpdate);
            pstm.setLong(7, table.getId());
            
            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public long findIDByCustomerCode(String customerCode) {
        String query = "SELECT id FROM tb_tables WHERE customer_code = ?";
        try (Connection con = Helper.ConnectDB.openConnect(); PreparedStatement pstm = con.prepareStatement(query);) {
            pstm.setString(1, customerCode);
            ResultSet rs = pstm.executeQuery();
            return rs.getLong("id");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
