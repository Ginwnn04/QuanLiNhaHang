/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author Tai
 */
import static BUS.ConnectDB.openConnect;
import DAO.DetailImportBillDAO;
import DTO.DetailImportBillDTO;
import DTO.SupplierDTO;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.Connection;
public class DetailImportBillBUS {

    private DetailImportBillDAO detailImportBillDAO = new DetailImportBillDAO();
    private ArrayList<DetailImportBillDTO> listDetailImportBills = new ArrayList<>();

    public ArrayList<DetailImportBillDTO> getAllDetailImportBills() throws Exception {
        listDetailImportBills = detailImportBillDAO.getAllDetailImportBills();
        return listDetailImportBills;
    }

    public ArrayList<DetailImportBillDTO> getDetailImportBillByBillId(long billId) throws SQLException, Exception {
        return detailImportBillDAO.getDetailImportBillByBillId(billId);
    }

    // Phương thức để lấy thông tin chi tiết nhà cung cấp theo ID nhà cung cấp
    public SupplierDTO getSupplierById(long supplierId) throws SQLException, Exception {
        return detailImportBillDAO.getSupplierById(supplierId);
    }

    public String getIngredientNameById(long ingredientId) throws SQLException, Exception {
        DetailImportBillDAO detailImportBillDAO = new DetailImportBillDAO();
        return detailImportBillDAO.getIngredientNameById(ingredientId);
    }
    public DetailImportBillBUS() {
        this.detailImportBillDAO = new DetailImportBillDAO();
    }

    public void addDetailImportBill(Connection con, long detailId, int quantity, double price, double total, int billId, int ingredientId) throws SQLException {
        detailImportBillDAO.addDetailImportBill( con, detailId, quantity, price, total, billId, ingredientId);
    }
    public static void deleteDetailImportBill(Long importBillId) throws SQLException, Exception {
        DetailImportBillDAO.deleteDetailImportBill(importBillId);
    }

}
