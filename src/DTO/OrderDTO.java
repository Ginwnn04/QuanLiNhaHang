/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author pc
 */
public class OrderDTO {
    private long id;
    private long staffID;
    private long tableID;
    private long total;
    private String customerCode;
    private boolean isDelete;
    private Date updateTime;
    private Date createTime;
    private ArrayList<DetailOrderDTO> listDetailOrder = new ArrayList<>();
    private TableDTO table;
    private boolean isSelected;
    
    // Luc create Order
    public OrderDTO(boolean isSingle, long staffID, long tableID, String note,boolean isDelete, Date updateTime, Date createTime) {
        createID();
        this.customerCode = createCustomerCode(isSingle);
        this.staffID = staffID;
        this.tableID = tableID;
        this.isDelete = isDelete;
        this.updateTime = updateTime;
        this.createTime = createTime;
        
    }

    // Luc read tu db len

    public OrderDTO(long id, long staffID, long tableID, long total, String customerCode, boolean isDelete, Date updateTime, Date createTime, TableDTO table) {
        this.id = id;
        this.staffID = staffID;
        this.tableID = tableID;
        this.total = total;
        this.customerCode = customerCode;
        this.isDelete = isDelete;
        this.updateTime = updateTime;
        this.createTime = createTime;
        this.table = table;
    }

 

    public OrderDTO() {
    }

    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    
    
    
    public void insertDetailOrder(DetailOrderDTO x) {
        listDetailOrder.add(x);
        this.total += x.getTotal();
    }
    
    public long createID() {
        this.id = System.currentTimeMillis();
        return id;
    }
    
    public String createCustomerCode(boolean isSingle) {
        Random rand = new Random();
        String code = "";
        if (isSingle) {
            code = "S-";
        }
        else {
            code = "M-";
        }
        code += rand.nextLong(100000, 999999);
        return code;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStaffID() {
        return staffID;
    }

    public void setStaffID(long staffID) {
        this.staffID = staffID;
    }

    public long getTableID() {
        return tableID;
    }

    public void setTableID(long tableID) {
        this.tableID = tableID;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public ArrayList<DetailOrderDTO> getListDetailOrder() {
        return listDetailOrder;
    }

    public TableDTO getTable() {
        return table;
    }

    public void setTable(TableDTO table) {
        this.table = table;
    }
    
    
    
}
