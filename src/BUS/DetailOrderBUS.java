/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.DetailOrderDAO;
import java.util.ArrayList;
import DTO.DetailOrderDTO;
/**
 *
 * @author quang
 */
public class DetailOrderBUS {
    private DetailOrderDAO detailOrderDAO = new DetailOrderDAO();
    private ArrayList<DetailOrderDTO> listDetailOrder = new ArrayList<>();
    
    public boolean insertDetailOrder(DetailOrderDTO x) {
        return detailOrderDAO.insertData(x);
    }
    
}
