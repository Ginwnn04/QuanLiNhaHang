package DAO;

import DTO.OrderDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class OrderDAO {
    
    
    public boolean insertData(OrderDTO order) {
        String query = "INSERT INTO tb_orders VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, order.getId());
            pstm.setString(2, order.getCustomerCode());
            pstm.setLong(3, order.getTotal());
            pstm.setBoolean(4, order.isIsDelete());
            pstm.setLong(5, order.getStaffID());
            pstm.setLong(6, order.getTableID());
            
            Date sqlDateUpdate = new Date(order.getUpdateTime().getTime());
            Date sqlDateCreate = new Date(order.getCreateTime().getTime());
            pstm.setDate(7, sqlDateCreate);
            pstm.setDate(8, sqlDateUpdate);
            
            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
                e.printStackTrace();
            }
        return false;
    }
    
    
    public ArrayList<OrderDTO> findOrderByCustomerCode(String customerCode) {
        ArrayList<OrderDTO> list = new ArrayList<>();
        String query = "SELECT * FROM tb_orders WHERE customer_code = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query);) {
            pstm.setString(1, customerCode);
            ResultSet rs = pstm.executeQuery();
           
            while (rs.next()) {
                OrderDTO order = new OrderDTO();
                order.setId(rs.getLong("id"));
                order.setCustomerCode(rs.getString("customer_code"));
                order.setTotal(rs.getLong("total"));
                order.setIsDelete(rs.getBoolean("isdeleted"));
                order.setStaffID(rs.getLong("staffid"));
                order.setTableID(rs.getLong("tableid"));
                order.setUpdateTime(rs.getDate("update_time"));
                
                list.add(order);
            }
            return list;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public boolean updateCustomerCode(String listTableID, String customerCode) {
        String query = "UPDATE tb_orders SET customer_code = ?, update_time = ? WHERE tableid IN ";
        query += "(" + listTableID + ")";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
             pstm.setString(1, customerCode);

            Date sqlDateUpdate = new Date(new java.util.Date().getTime());
            
            pstm.setDate(2, sqlDateUpdate);
 
            
            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
