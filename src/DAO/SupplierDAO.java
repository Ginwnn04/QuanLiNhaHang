/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Tai
 */
import DTO.SupplierDTO;
import BUS.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDAO {
    // Method to get all suppliers from database
    public ArrayList<SupplierDTO> getAllSuppliers() throws SQLException, Exception {
        String query = "SELECT id, name, address, phone FROM tb_supplier";
        try (Connection con = ConnectDB.openConnect();
             PreparedStatement pstm = con.prepareStatement(query);
             ResultSet rs = pstm.executeQuery()) {
            ArrayList<SupplierDTO> list = new ArrayList<>();
            while (rs.next()) {
                SupplierDTO supplier = new SupplierDTO(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone")
                );
                list.add(supplier);
            }
            return list;
        }
    }
}
