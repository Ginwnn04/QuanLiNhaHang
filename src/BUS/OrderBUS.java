/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.OrderDAO;
import DTO.DetailOrderDTO;
import DTO.OrderDTO;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class OrderBUS {
    private OrderDAO orderDAO = new OrderDAO();
    private DetailOrderBUS detailOrderBUS = new DetailOrderBUS();
    private OrderDTO order;
    
    
    public ArrayList<OrderDTO> getAllOrder() {
        return orderDAO.getAllData();
    }
    
    
    public boolean insertOrder(OrderDTO order) {
        this.order = order;
        ArrayList<DetailOrderDTO> listDetailOrder = order.getListDetailOrder();
        boolean check = orderDAO.insertData(order);
        if (check) {
            for (DetailOrderDTO x : listDetailOrder) {
                x.setOrderID(order.getId());
                detailOrderBUS.insertDetailOrder(x);
            }
        }
        return check;
    }
    
    public ArrayList<OrderDTO> findOrderByCustomerCode(String customerCode) {
        return orderDAO.findOrderByCustomerCode(customerCode);
    }
    
    public OrderDTO findOrderByTableID(long tableID) {
        return orderDAO.findOrderByTableID(tableID);
    }
    
    public boolean updateCustomerCode(String listTableID, String customerCode) {
        return orderDAO.updateCustomerCode(listTableID, customerCode);
    }
}
