package DAO;

import DTO.OrderDTO;
import DTO.TableDTO;
import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class OrderDAO {
    
    public ArrayList<OrderDTO> getAllData() {
        ArrayList<OrderDTO> list = new ArrayList<>();
        String query = "SELECT tb_orders.*, name FROM tb_orders JOIN tb_tables ON tableid = tb_tables.id WHERE tb_orders.isdeleted = FALSE";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query);) {
            
            ResultSet rs = pstm.executeQuery();
           
            while (rs.next()) {
                OrderDTO order = new OrderDTO();
                order.setId(rs.getLong("id"));
                order.setCustomerCode(rs.getString("customer_code"));
                order.setTotal(rs.getLong("total"));
                order.setIsDelete(rs.getBoolean("isdeleted"));
                order.setStaffID(rs.getLong("staffid"));
                order.setTableID(rs.getLong("tableid"));
                order.setUpdateTime(rs.getTimestamp("update_time"));
                order.setCreateTime(rs.getTimestamp("create_time"));
                TableDTO table = new TableDTO();
                table.setName(rs.getString("name"));
                order.setTable(table);
                list.add(order);
            }
            return list;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public boolean insertData(OrderDTO order) {
        String query = "INSERT INTO tb_orders VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, order.getId());
            pstm.setString(2, order.getCustomerCode());
            pstm.setLong(3, order.getTotal());
            pstm.setBoolean(4, order.isIsDelete());
            pstm.setLong(5, order.getStaffID());
            pstm.setLong(6, order.getTableID());
            
            Timestamp sqlDateUpdate = new Timestamp(order.getUpdateTime().getTime());
            Timestamp sqlDateCreate = new Timestamp(order.getCreateTime().getTime());
            pstm.setTimestamp(7, sqlDateCreate);
            pstm.setTimestamp(8, sqlDateUpdate);
            
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
                order.setUpdateTime(rs.getTimestamp("update_time"));
                order.setCreateTime(rs.getTimestamp("create_time"));
                list.add(order);
            }
            return list;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public OrderDTO findOrderByTableID(long idTable) {
        String query = "SELECT * FROM tb_orders WHERE tableid = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query);) {
            pstm.setLong(1, idTable);
            ResultSet rs = pstm.executeQuery();
           
            if (rs.next()) {
                OrderDTO order = new OrderDTO();
                order.setId(rs.getLong("id"));
                order.setCustomerCode(rs.getString("customer_code"));
                order.setTotal(rs.getLong("total"));
                order.setIsDelete(rs.getBoolean("isdeleted"));
                order.setStaffID(rs.getLong("staffid"));
                order.setTableID(rs.getLong("tableid"));
                order.setUpdateTime(rs.getTimestamp("update_time"));
                order.setCreateTime(rs.getTimestamp("create_time"));
                return order;
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean updateCustomerCode(String listTableID, String customerCode) {
        String query = "UPDATE tb_orders SET customer_code = ?, update_time = ? WHERE tableid IN ";
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
    
    public boolean deleteOrder(String listOrderID) {
        String query = "UPDATE tb_orders SET isdeleted = TRUE, update_time = ? WHERE id IN ";
        query += "(" + listOrderID + ")";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            Timestamp sqlDateUpdate = new Timestamp(new Date().getTime());
            pstm.setTimestamp(1, sqlDateUpdate);
            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
