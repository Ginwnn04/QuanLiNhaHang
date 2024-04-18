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
}
