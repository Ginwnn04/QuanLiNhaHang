/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author Tai
 */
import java.sql.Connection;
import DAO.ImportBillDAO;
import DTO.ImportBillDTO;
import java.util.ArrayList;
import java.util.Date;
import java.sql.SQLException;
public class ImportBillBUS {
    private ImportBillDAO importBillDAO = new ImportBillDAO();
    private ArrayList<ImportBillDTO> listImportBills = new ArrayList<>();

    // Method to get all import bills
    public ArrayList<ImportBillDTO> getAllImportBills() throws Exception {
        listImportBills = importBillDAO.getAllImportBills();
        return listImportBills;
    }
    
    public ImportBillBUS() {
        this.importBillDAO = new ImportBillDAO();
    }

    public void addImportBill(Connection con, int billId, int quantity, double total, Date importDate, long userId, int supplierId) throws SQLException {
        importBillDAO.addImportBill((java.sql.Connection) con, billId, quantity, total, importDate, userId, supplierId);
    }
    public static void deleteImportBill(Long importBillId) throws SQLException, Exception {
        ImportBillDAO.deleteImportBill(importBillId);
    }
}