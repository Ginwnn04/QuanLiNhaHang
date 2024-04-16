package DAO;

import DTO.OrderDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class OrderDAO {
    
    
    public boolean insertData(OrderDTO order) {
        String query = "INSERT INTO tb_orders VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = Helper.ConnectDB.openConnect(); PreparedStatement pstm = con.prepareStatement(query)) {
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
    
    
    public OrderDTO findOrderByCustomerCode(String customerCode) {
        String query = "SELECT * FROM tb_orders WHERE customer_code = ?";
        try (Connection con = Helper.ConnectDB.openConnect(); PreparedStatement pstm = con.prepareStatement(query);) {
            pstm.setString(1, customerCode);
            ResultSet rs = pstm.executeQuery();
            // Kiem tra rs co ban? ghi nao khong
            if (rs.next()) {
                OrderDTO order = new OrderDTO();
                order.setId(rs.getLong("id"));
                order.setCustomerCode(rs.getString("customer_code"));
                order.setTotal(rs.getLong("total"));
                order.setIsDelete(rs.getBoolean("isdeleted"));
                order.setStaffID(rs.getLong("staffid"));
                order.setTableID(rs.getLong("tableid"));
                order.setUpdateTime(rs.getDate("update_time"));
                return order;
                
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    
}
