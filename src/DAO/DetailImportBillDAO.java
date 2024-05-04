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
import DTO.SupplierDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DetailImportBillDAO {

    public ArrayList<DetailImportBillDTO> getDetailImportBillByBillId(long billId)  {
        ArrayList<DetailImportBillDTO> detailImportBillList = new ArrayList<>();
        String query = "SELECT * FROM tb_detail_import_bill WHERE billid = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, billId);
            ResultSet rs = pstm.executeQuery();

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
        } 
        catch (Exception e) {
            e.printStackTrace(); 
        }
        return detailImportBillList;
    }

    // Phương thức để lấy thông tin chi tiết nhà cung cấp theo ID nhà cung cấp
    public SupplierDTO getSupplierById(long supplierId) {
        String query = "SELECT * FROM tb_supplier WHERE id = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, supplierId);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    SupplierDTO supplier = new SupplierDTO();
                    supplier.setId(rs.getInt("id"));
                    supplier.setName(rs.getString("name"));
                    supplier.setAddress(rs.getString("address"));
                    supplier.setPhone(rs.getString("phone"));
                    return supplier;
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return null;
    }

    public String getIngredientNameById(long ingredientId) {
        String query = "SELECT name FROM tb_ingredients WHERE id = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, ingredientId);
            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("name");
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }
        return null;
    }

    public void addDetailImportBill(long detailId, int quantity, double price, double total, int billId, int ingredientId) {
        String sql = "INSERT INTO tb_detail_import_bill (id, quantity, price, total, billid, ingredientid, isdeleted) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = Helper.ConnectDB.getInstance().getConnection().prepareStatement(sql)) {
            pstmt.setLong(1, detailId);
            pstmt.setInt(2, quantity);
            pstmt.setDouble(3, price);
            pstmt.setDouble(4, total);
            pstmt.setInt(5, billId);
            pstmt.setInt(6, ingredientId);
            pstmt.setBoolean(7, false);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
    public static void deleteDetailImportBill(Long importBillId)  {
        String query = "UPDATE tb_detail_import_bill SET isdeleted = true WHERE billid = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, importBillId);
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }
}
