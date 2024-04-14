/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.DetailOrderDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

/**
 *
 * @author quang
 */
public class DetailOrderDAO {
    
    public boolean insertData(DetailOrderDTO detailOrder) {
        String query = "INSERT INTO tb_detail_order VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = Helper.ConnectDB.openConnect(); PreparedStatement pstm = con.prepareStatement(query)) {
            pstm.setLong(1, detailOrder.getId());
            pstm.setLong(2, detailOrder.getPrice());
            pstm.setLong(3, detailOrder.getProfit());
            pstm.setInt(4, detailOrder.getQuantity());
            pstm.setLong(5, detailOrder.getTotal());
            pstm.setBoolean(6, detailOrder.isIsDelete());
            pstm.setLong(7, detailOrder.getItemID());
            pstm.setLong(8, detailOrder.getOrderID());
            pstm.setLong(9, detailOrder.getInvoiceID());
            
            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
                e.printStackTrace();
            }
        return false;
    }
}
