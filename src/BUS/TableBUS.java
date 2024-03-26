/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.TableDAO;
import DTO.TableDTO;
import java.util.ArrayList;

/**
 *
 * @author quang
 */
public class TableBUS {
    private ArrayList<TableDTO> list;
    private TableDAO tableDAO;
    public TableBUS() {
        list = new ArrayList<>();
        tableDAO = new TableDAO();
    }
    
    public ArrayList<TableDTO> getAllData() {
        list = tableDAO.readData();
        return list;
    }
    
}
