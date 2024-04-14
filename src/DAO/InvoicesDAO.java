package DAO;

import DTO.InvoicesDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
public class InvoicesDAO {
    
    public boolean insertData(InvoicesDTO invoices) {
        String query = "INSERT INTO tb_invoices VALUES(?, ?, ?, ?, ?, ?, ?)";
        try(Connection con = Helper.ConnectDB.openConnect(); PreparedStatement pstm = con.prepareStatement(query)) {
            pstm.setLong(1, invoices.getId());
            pstm.setLong(2, invoices.getAmount());
            pstm.setLong(3, invoices.getDiscount());
            pstm.setLong(4, invoices.getTotal());
            pstm.setBoolean(5, invoices.isIsDelete());
            Date dateSQL = new Date(invoices.getCreateTime().getTime());
            pstm.setDate(6, dateSQL);
            pstm.setString(7, invoices.getDiscountID());
            return pstm.executeUpdate() > 0;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
