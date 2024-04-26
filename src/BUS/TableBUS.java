/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import Criteria.TableCriteria;
import DAO.TableDAO;
import DTO.TableDTO;
import java.util.ArrayList;

/**
 *
 * @author quang
 */
public class TableBUS {
    private TableDAO tableDAO;
    
    
    public TableBUS() {
        tableDAO = new TableDAO();
    }
    
    public ArrayList<TableDTO> getAllData() {
        TableCriteria criteria = new TableCriteria();
        tableDAO.read(criteria);
        return tableDAO.read(criteria);
    }
    
    
    
    public boolean insertTable(TableDTO table) {
        return tableDAO.insert(table);
    }
    
//    public ArrayList<TableDTO> sortNameTable(String name) {
//        list = tableDAO.sortName(name);
//        return list;
//    }
    
    public boolean deleteTable(String listTableDelete) {
        return tableDAO.deleteData(listTableDelete);
    }
    
    public boolean updateTable(TableDTO table) {
        return tableDAO.updateData(table);
    }
    
    public boolean updateNote(TableDTO table) {
        return tableDAO.updateNote(table);
    }
    
     public boolean updateCustomerCode(String listTableID, String customerCode) {
        return tableDAO.updateCustomerCode(listTableID, customerCode);
    }
     
    public ArrayList<TableDTO> findTableByCustomerCode(String customerCode) {
        TableCriteria criteria = new TableCriteria();
        criteria.setCustomerCode(customerCode);
        return tableDAO.read(criteria);
         
    }
    
    public TableDTO findTableByName(String nameTable) {
        TableCriteria criteria = new TableCriteria();
        criteria.setName(nameTable);
        return tableDAO.read(criteria).size() == 0 ? null : tableDAO.read(criteria).get(0);
    }
    
    public TableDTO findTableByID(long idTable) {
        TableCriteria criteria = new TableCriteria();
        criteria.setId(idTable);
        
        return tableDAO.read(criteria).size() == 0 ? null : tableDAO.read(criteria).get(0);
    }
     
    public boolean cancelTable(String listTabeID) {
        return tableDAO.cancelTable(listTabeID);
    }
    
}
