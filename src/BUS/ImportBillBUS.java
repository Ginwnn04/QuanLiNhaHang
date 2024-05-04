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
import Helper.FormatNumber;
import java.util.ArrayList;
import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JTable;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableColumnModel;
public class ImportBillBUS {
    private ImportBillDAO importBillDAO = new ImportBillDAO();
    private ArrayList<ImportBillDTO> listImportBills = new ArrayList<>();

        public void loadImportBills(DefaultTableModel model) throws Exception {
        try {
            ArrayList<Object[]> importBillData = importBillDAO.getImportBills();

            // Xóa dữ liệu cũ trong bảng
            model.setRowCount(0);

            // Thêm dữ liệu mới vào bảng
            for (Object[] row : importBillData) {
                model.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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