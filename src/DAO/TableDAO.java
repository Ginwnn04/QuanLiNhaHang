/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Criteria.TableCriteria;
import DTO.TableDTO;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author quang
 */
public class TableDAO {


    public ArrayList<TableDTO> read(TableCriteria criteria) {
        boolean isSelectAll = true;
        ArrayList<TableDTO> list = new ArrayList<>();
        String query = "SELECT * FROM tb_tables";
        if (criteria.toString() == null) {
            return null;
        }
        if (!criteria.toString().isEmpty()) {
            query += " WHERE " + criteria.toString();
            isSelectAll = false;
        }

        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)){
            if (!isSelectAll) {
                int i = 1;
                if (criteria.getId() != null) {
                    pstm.setLong(i++, criteria.getId());
                }
                if (criteria.getName() != null) {
                    pstm.setString(i++, criteria.getName());
                }
                if (criteria.getDes() != null) {
                    pstm.setString(i++, criteria.getDes());
                }
                if (criteria.isIsDelete() != null) {
                    pstm.setBoolean(i++, criteria.isIsDelete());
                }
                if (criteria.getCustomerCode()!= null) {
                    pstm.setString(i++, criteria.getCustomerCode());
                }
                if (criteria.getStatus()!= null) {
                    pstm.setString(i++, criteria.getStatus());
                }
                if (criteria.getUpdateTime()!= null) {
                    pstm.setTimestamp(i++, new Timestamp(criteria.getUpdateTime().getTime()));
                }
                if (criteria.getCreateTime()!= null) {
                    pstm.setTimestamp(i++, new Timestamp(criteria.getCreateTime().getTime()));
                }
                if (criteria.getNote()!= null) {
                    pstm.setString(i++, criteria.getNote());
                }
            }
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                TableDTO table = new TableDTO();
                table.setId(rs.getLong("id"));
                table.setName(rs.getString("name"));
                table.setDes(rs.getString("des"));
                table.setCustomerCode(rs.getString("customer_code"));
                table.setStatus(rs.getString("statusid"));
                table.setCreateTime(rs.getTimestamp("create_time"));
                table.setUpdateTime(rs.getTimestamp("update_time"));
                table.setIsDelete(rs.getBoolean("isdeleted"));
                table.setNote(rs.getString("note"));
                list.add(table);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return list;  
    }


    public boolean insert(TableDTO table) {
        String query = "INSERT INTO tb_tables VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, table.getId());
            pstm.setString(2, table.getName());
            pstm.setString(3, table.getDes());
            pstm.setBoolean(4, false);
            pstm.setString(5, "");
            pstm.setString(6, table.getStatus());
            

            

            pstm.setTimestamp(7, new Timestamp(table.getUpdateTime().getTime()));
            pstm.setTimestamp(8, new Timestamp(table.getCreateTime().getTime()));
            pstm.setString(9, table.getNote());
            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean update(TableCriteria criteria ,TableDTO table) {
        return true;
    }

    public boolean delete(TableDTO obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
//    public TableDTO readData(long idTable) {
//        
//        String query = "SELECT * FROM tb_tables WHERE id = ?";
//        try ( PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)){
//            pstm.setLong(1, idTable);
//            ResultSet rs = pstm.executeQuery();
//            while(rs.next()) {
//                TableDTO table = new TableDTO();
//                table.setId(rs.getLong("id"));
//                table.setName(rs.getString("name"));
//                table.setDes(rs.getString("des"));
//                table.setCustomerCode(rs.getString("customer_code"));
//                table.setStatus(rs.getString("statusid"));
//                table.setCreateTime(rs.getTimestamp("create_time"));
//                table.setUpdateTime(rs.getTimestamp("update_time"));
//                table.setIsDelete(rs.getBoolean("isdeleted"));
//                table.setNote(rs.getString("note"));
//                return table;
//            }
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//        }
//        return null;  
//    }
    
//    public boolean insertData(TableDTO table) {
//        String query = "INSERT INTO tb_tables VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
//            pstm.setLong(1, table.getId());
//            pstm.setString(2, table.getName());
//            pstm.setString(3, table.getDes());
//            pstm.setBoolean(4, false);
//            pstm.setString(5, "");
//            pstm.setString(6, table.getStatus());
//            
//            // Date này là sql.Date chứ không phải util.Date
//            Timestamp sqlDateUpdate = new Timestamp(table.getUpdateTime().getTime());
//            Timestamp sqlDateCreate = new Timestamp(table.getCreateTime().getTime());
//            
//
//            pstm.setTimestamp(7, sqlDateUpdate);
//            pstm.setTimestamp(8, sqlDateCreate);
//            pstm.setString(9, table.getNote());
//            return pstm.executeUpdate() > 0;
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
    
    

    
    public boolean deleteData(String listTableDelete) {
        String query = "DELETE FROM tb_tables WHERE id IN (SELECT unnest(string_to_array(?, ','))::bigint)";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
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
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setString(1, table.getName());
            pstm.setString(2, table.getDes());
            pstm.setBoolean(3, table.isIsDelete());
            pstm.setString(4, table.getCustomerCode());
            pstm.setString(5, table.getStatus());
            
            
            Timestamp sqlDateUpdate = new Timestamp(table.getUpdateTime().getTime());
            
            pstm.setTimestamp(6, sqlDateUpdate);
            pstm.setLong(7, table.getId());
            System.out.println(table.getId());
            int a = pstm.executeUpdate();
            System.out.println(a);
            return a > 0;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateNote(TableDTO table) {
        String query = "UPDATE tb_tables SET note = ?, update_time = ? WHERE id = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setString(1, table.getNote());

            
            
            Timestamp sqlDateUpdate = new Timestamp(table.getUpdateTime().getTime());
            
            pstm.setTimestamp(2, sqlDateUpdate);
            pstm.setLong(3, table.getId());
            
            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateCustomerCode(String listTableID, String customerCode) {
        String query = "UPDATE tb_tables SET customer_code = ?, update_time = ? WHERE id IN ";
        query += "(" + listTableID + ")";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
             pstm.setString(1, customerCode);

            Timestamp sqlDateUpdate = new Timestamp(new Date().getTime());
            
            pstm.setTimestamp(2, sqlDateUpdate);
 
            
            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    

//    
//    public ArrayList<TableDTO> findTableByCustomerCode(String customerCode) {
//        ArrayList<TableDTO> list = new ArrayList<>();
//        String query = "SELECT * FROM tb_tables WHERE customer_code = ?";
//        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query);) {
//            pstm.setString(1, customerCode);
//            ResultSet rs = pstm.executeQuery();
//            while(rs.next()) {
//                TableDTO table = new TableDTO();
//                table.setId(rs.getLong("id"));
//                table.setName(rs.getString("name"));
//                table.setDes(rs.getString("des"));
//                table.setCustomerCode(rs.getString("customer_code"));
//                table.setStatus(rs.getString("statusid"));
//                table.setCreateTime(rs.getTimestamp("create_time"));
//                table.setUpdateTime(rs.getTimestamp("update_time"));
//                table.setIsDelete(rs.getBoolean("isdeleted"));
//                table.setNote(rs.getString("note"));
//                list.add(table);
//            }
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
    
//    public TableDTO findTableByName(String nameTable) {
//        String query = "SELECT * FROM tb_tables WHERE name = ?";
//        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query);) {
//            pstm.setString(1, nameTable);
//            ResultSet rs = pstm.executeQuery();
//            if(rs.next()) {
//                TableDTO table = new TableDTO();
//                table.setId(rs.getLong("id"));
//                table.setName(rs.getString("name"));
//                table.setDes(rs.getString("des"));
//                table.setCustomerCode(rs.getString("customer_code"));
//                table.setStatus(rs.getString("statusid"));
//                table.setCreateTime(rs.getTimestamp("create_time"));
//                table.setUpdateTime(rs.getTimestamp("update_time"));
//                table.setIsDelete(rs.getBoolean("isdeleted"));
//                table.setNote(rs.getString("note"));
//                
//                return table;
//            }
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
    
    public boolean cancelTable(String listTableID) {
        String query = "UPDATE tb_tables SET customer_code = ?, statusid = ?, update_time = ? WHERE id IN ";
        query += "(" + listTableID + ")";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
             pstm.setString(1, "");
             pstm.setString(2, "BANTRONG");

            Timestamp sqlDateUpdate = new Timestamp(new Date().getTime());
            
            pstm.setTimestamp(3, sqlDateUpdate);
 
            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
