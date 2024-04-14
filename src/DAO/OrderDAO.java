package DAO;

import DTO.OrderDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class OrderDAO {
    
    
    public boolean insertData(OrderDTO order) {
        String query = "INSERT INTO tb_orders VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = Helper.ConnectDB.openConnect(); PreparedStatement pstm = con.prepareStatement(query)) {
            pstm.setLong(1, order.getId());
            pstm.setString(2, order.getCustomerCode());
            pstm.setLong(3, order.getTotal());
            pstm.setBoolean(4, order.isIsDelete());
            pstm.setString(5, order.getNote());
            pstm.setLong(6, order.getStaffID());
            pstm.setLong(7, order.getTableID());
            
            Date sqlDateUpdate = new Date(order.getUpdateTime().getTime());
            Date sqlDateCreate = new Date(order.getCreateTime().getTime());
            pstm.setDate(8, sqlDateCreate);
            pstm.setDate(9, sqlDateUpdate);
            
            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
                e.printStackTrace();
            }
        return false;
    }
}
