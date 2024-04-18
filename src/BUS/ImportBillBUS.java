/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author Tai
 */
import DAO.ImportBillDAO;
import DTO.ImportBillDTO;
import java.util.ArrayList;

public class ImportBillBUS {
    private ImportBillDAO importBillDAO = new ImportBillDAO();
    private ArrayList<ImportBillDTO> listImportBills = new ArrayList<>();

    // Method to get all import bills
    public ArrayList<ImportBillDTO> getAllImportBills() throws Exception {
        listImportBills = importBillDAO.getAllImportBills();
        return listImportBills;
    }
}