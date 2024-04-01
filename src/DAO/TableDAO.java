/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TableDTO;
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
        try (Connection con = Helper.ConnectDB.openConnect(); PreparedStatement pstm = con.prepareStatement(query)){
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
        String query = "INSERT INTO tb_tables (id, name, des, isdeleted, customer_code, statusid, create_time, update_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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
            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
//    public ArrayList<TableDTO> sortName(String name) {
//        ArrayList<TableDTO> list = new ArrayList<>();
//        String query = "SELECT * FROM tb_tables WHERE LOWER(name) LIKE ?";
//        name = "%" + name.toLowerCase().trim() + "%";
//       
//        try (Connection con = Helper.ConnectDB.openConnect(); PreparedStatement pstm = con.prepareStatement(query)){
//            pstm.setString(1, name);
//            ResultSet rs = pstm.executeQuery();
//            while(rs.next()) {
//                TableDTO table = new TableDTO();
//                table.setId(rs.getLong("id"));
//                table.setName(rs.getString("name"));
//                table.setDes(rs.getString("des"));
//                table.setCustomerCode(rs.getString("customer_code"));
//                table.setStatus(rs.getString("statusid"));
//                table.setCreateTime(rs.getDate("create_time"));
//                table.setUpdateTime(rs.getDate("update_time"));
//                table.setIsDelete(rs.getBoolean("isdeleted"));
//                list.add(table);
//            }
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//        }
//        return list;  
//    }
    
    public boolean deleteData(TableDTO table) {
        String query = "DELETE FROM tb_tables WHERE id = ?";
        try (Connection con = Helper.ConnectDB.openConnect(); PreparedStatement pstm = con.prepareStatement(query)) {
            pstm.setLong(1, table.getId());
            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
