/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.InvoicesDAO;
import DTO.InvoicesDTO;

/**
 *
 * @author pc
 */
public class InvoiesBUS {
    private InvoicesDAO invoicesDAO = new InvoicesDAO();
    
    public boolean  insertInvoices(InvoicesDTO invoices) {
        return invoicesDAO.insertData(invoices);
    }
    
    public InvoicesDTO getInvoiceByID(long id) {
        return invoicesDAO.readData(id);
    }
}
