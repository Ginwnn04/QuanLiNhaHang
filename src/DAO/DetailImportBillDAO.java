/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Tai
 */
import DTO.DetailImportBillDTO;
import BUS.ConnectDB;
import DTO.SupplierDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DetailImportBillDAO {

    Connection con;

    public ArrayList<DetailImportBillDTO> getAllDetailImportBills() throws Exception {
        String query = "SELECT id, quantity, price, total, billid, ingredientid FROM tb_detail_import_bill";
        try (Connection con = ConnectDB.openConnect(); PreparedStatement pstm = con.prepareStatement(query); ResultSet rs = pstm.executeQuery()) {
            ArrayList<DetailImportBillDTO> list = new ArrayList<>();
            while (rs.next()) {
                DetailImportBillDTO detail = new DetailImportBillDTO();
                detail.setId(rs.getInt("id"));
                detail.setQuantity(rs.getInt("quantity"));
                detail.setPrice(rs.getDouble("price"));
                detail.setTotal(rs.getDouble("total"));
                detail.setBillid(rs.getInt("billid"));
                detail.setIngredientid(rs.getInt("ingredientid"));
                list.add(detail);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<DetailImportBillDTO> getDetailImportBillByBillId(long billId) throws SQLException, Exception {
        ArrayList<DetailImportBillDTO> detailImportBillList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectDB.openConnect();
            ps = con.prepareStatement("SELECT * FROM tb_detail_import_bill WHERE billid = ?");
            ps.setLong(1, billId);
            rs = ps.executeQuery();

            while (rs.next()) {
                DetailImportBillDTO detailImportBill = new DetailImportBillDTO();
                detailImportBill.setId(rs.getInt("id"));
                detailImportBill.setQuantity(rs.getInt("quantity"));
                detailImportBill.setPrice(rs.getDouble("price"));
                detailImportBill.setTotal(rs.getDouble("total"));
                detailImportBill.setBillid(rs.getInt("billid"));
                detailImportBill.setIngredientid(rs.getInt("ingredientid"));
                detailImportBillList.add(detailImportBill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }

        return detailImportBillList;
    }

    // Phương thức để lấy thông tin chi tiết nhà cung cấp theo ID nhà cung cấp
    public SupplierDTO getSupplierById(long supplierId) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        SupplierDTO supplier = null;

        try {
            con = ConnectDB.openConnect();
            ps = con.prepareStatement("SELECT * FROM tb_supplier WHERE id = ?");
            ps.setLong(1, supplierId);
            rs = ps.executeQuery();
            if (rs.next()) {
                supplier = new SupplierDTO();
                supplier.setId(rs.getInt("id"));
                supplier.setName(rs.getString("name"));
                supplier.setAddress(rs.getString("address"));
                supplier.setPhone(rs.getString("phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }

        return supplier;
    }

    public String getIngredientNameById(long ingredientId) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String ingredientName = null;

        try {
            con = ConnectDB.openConnect();
            ps = con.prepareStatement("SELECT name FROM tb_ingredients WHERE id = ?");
            ps.setLong(1, ingredientId);
            rs = ps.executeQuery();
            if (rs.next()) {
                ingredientName = rs.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (con != null) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (rs != null) {
                rs.close();
            }
        }

        return ingredientName;
    }
    
    public void addDetailImportBill(Connection con, long detailId, int quantity, double price, double total, int billId, int ingredientId) throws SQLException {
        String sql = "INSERT INTO tb_detail_import_bill (id, quantity, price, total, billid, ingredientid) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setLong(1, detailId);
            pstmt.setInt(2, quantity);
            pstmt.setDouble(3, price);
            pstmt.setDouble(4, total);
            pstmt.setInt(5, billId);
            pstmt.setInt(6, ingredientId);
            pstmt.executeUpdate();
        }
    }
    public static void deleteDetailImportBill(Long importBillId) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectDB.openConnect();
            ps = con.prepareStatement("UPDATE tb_detail_import_bill SET isdeleted = true WHERE billid = ?");
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
