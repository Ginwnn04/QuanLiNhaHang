package DAO;

import DTO.InvoicesDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
public class InvoicesDAO {
    
    public boolean insertData(InvoicesDTO invoices) {
        String query = "INSERT INTO tb_invoices VALUES(?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
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
    
    public InvoicesDTO readData(long idInvoice) {
        String query = "SELECT * FROM tb_invoices WHERE id = ?";
        try(PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, idInvoice);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                InvoicesDTO invoice = new InvoicesDTO();
                invoice.setId(rs.getLong("id"));
                invoice.setAmount(rs.getLong("amount"));
                invoice.setDiscount(rs.getLong("discount_price"));
                invoice.setTotal(rs.getLong("total"));
                invoice.setIsDelete(rs.getBoolean("isdeleted"));
                invoice.setCreateTime(rs.getDate("time"));
                invoice.setDiscountID(rs.getString("discountid"));
                return invoice;
            }
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
