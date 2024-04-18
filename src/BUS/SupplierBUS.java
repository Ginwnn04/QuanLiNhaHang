/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author Tai
 */
import DAO.SupplierDAO;
import DTO.SupplierDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierBUS {
    private SupplierDAO supplierDAO = new SupplierDAO();

    // Method to get all suppliers
    public ArrayList<SupplierDTO> getAllSuppliers() throws Exception {
        try {
            return supplierDAO.getAllSuppliers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}