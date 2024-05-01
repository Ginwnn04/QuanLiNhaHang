/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Tai
 */
import DTO.ImportBillDTO;
import BUS.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class ImportBillDAO {
    // Method to get all import bills from database
    public ArrayList<ImportBillDTO> getAllImportBills() throws Exception {
        String query = "SELECT id, quantity, total, import_date, userid, supplierID FROM tb_import_bill";
        try (Connection con = ConnectDB.openConnect();
             PreparedStatement pstm = con.prepareStatement(query);
             ResultSet rs = pstm.executeQuery()) {
            ArrayList<ImportBillDTO> list = new ArrayList<>();
            while (rs.next()) {
                ImportBillDTO importBill = new ImportBillDTO(
                        rs.getInt("id"),
                        rs.getInt("quantity"),
                        rs.getFloat("total"),
                        rs.getDate("import_date"),
                        rs.getInt("userid"),
                        rs.getInt("supplierID")
                );
                list.add(importBill);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void addImportBill(Connection con, int billId, int quantity, double total, Date importDate, long userId, int supplierId) throws SQLException {
        String sql = "INSERT INTO tb_import_bill (id, quantity, total, import_date, userid, supplierid) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, billId);
            pstmt.setInt(2, quantity);
            pstmt.setDouble(3, total);
            pstmt.setDate(4, new java.sql.Date(importDate.getTime()));
            pstmt.setLong(5, userId);
            pstmt.setInt(6, supplierId);
            pstmt.executeUpdate();
        }
    }
        public static void deleteImportBill(Long importBillId) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectDB.openConnect();
            ps = con.prepareStatement("UPDATE tb_import_bill SET isdeleted = true WHERE id = ?");
            ps.setLong(1, importBillId);
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
