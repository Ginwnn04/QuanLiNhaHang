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
import Helper.FormatNumber;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
public class ImportBillDAO {
public static ArrayList<Object[]> getImportBills() throws SQLException, Exception {
    ArrayList<Object[]> importBillData = new ArrayList<>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");

    String query = "SELECT i.id, i.quantity, i.total, i.import_date, st.username AS username, s.name AS supplierName, staffid, supplierid FROM tb_import_bill AS i LEFT JOIN tb_staff AS st ON i.staffid = st.id LEFT JOIN tb_supplier AS s ON i.supplierID = s.id WHERE i.isdeleted = false";
    try (PreparedStatement ps = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            double total = rs.getDouble("total");
            String formattedTotal = FormatNumber.getInstance().getFormat().format(total);
            java.sql.Date importDate = rs.getDate("import_date");
            String formattedImportDate = (importDate != null) ? dateFormat.format(importDate) : "";
            Object[] row = {
                rs.getLong("id"),
                rs.getInt("quantity"),
                formattedTotal, // Format tổng tiền using FormatNumber
                formattedImportDate,
                rs.getLong("staffid"),
                rs.getLong("supplierid"),
                rs.getString("username"),
                rs.getString("supplierName")
            };
            importBillData.add(row);
        }
    }
    return importBillData;
}
    

    
    public void addImportBill(Connection con, int billId, int quantity, double total, Date importDate, long userId, int supplierId) throws SQLException {
        String sql = "INSERT INTO tb_import_bill (id, quantity, total, import_date, staffid, supplierid, isdeleted) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, billId);
            pstmt.setInt(2, quantity);
            pstmt.setDouble(3, total);
            pstmt.setDate(4, new java.sql.Date(importDate.getTime()));
            pstmt.setLong(5, userId);
            pstmt.setInt(6, supplierId);
            pstmt.setBoolean(7, false);
            pstmt.executeUpdate();
        }
    }
public static void deleteImportBill(Long importBillId) throws SQLException, Exception {
    String query = "UPDATE tb_import_bill SET isdeleted = true WHERE id = ?";
    try (PreparedStatement ps = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
        ps.setLong(1, importBillId);
        ps.executeUpdate();
    }
}
}
