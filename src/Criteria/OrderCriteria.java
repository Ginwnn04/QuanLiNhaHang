/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Criteria;

import java.util.Date;

/**
 *
 * @author quang
 */
public class OrderCriteria {
    private Long id;
    private Long staffID;
    private Long tableID;
    private Long total;
    private String customerCode;
    private Boolean isDelete;
    private Date updateTime;
    private Date createTime;

       public String createClause(boolean isUpdate) {
        String clause = "";
        
        if (isUpdate) {
            if (customerCode != null) {
                clause += "customer_code = ?, ";
            }
            if (total != null) {
                clause += "total = ?, ";
            }
            if (isDelete != null) {
                clause += "isdeleted = ?, ";
            }
            if (staffID != null) {
                clause += "staffid = ?, ";
            }
            if (tableID != null) {
                clause += "tableid = ?, ";
            }
            if (updateTime != null) {
                clause += "update_time = ?, ";
            }
            if (!clause.isEmpty()) {
            clause = clause.substring(0, clause.length() - 2);
            }
        }
        
        else {
            if (id != null) {
                clause += "id = ? AND ";
            }
            if (customerCode != null) {
                 clause += "customer_code = ? AND ";
            }
            if (total != null) {
                clause += "total = ? AND ";
            }
            if (isDelete != null) {
                clause += "isdeleted = ? AND ";
            }
            if (staffID != null) {
                clause += "staffid = ? AND ";
            }
            if (tableID != null) {
                clause += "tableid = ? AND ";
            }
            if (createTime != null) {
               clause += "create_time = ? AND ";
            }
            if (updateTime != null) {
                clause += "update_time = ? AND ";
            }
            if (!clause.isEmpty()) {
                clause = clause.substring(0, clause.length() - 5);
            }
        }
        return clause;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStaffID() {
        return staffID;
    }

    public void setStaffID(Long staffID) {
        this.staffID = staffID;
    }

    public Long getTableID() {
        return tableID;
    }

    public void setTableID(Long tableID) {
        this.tableID = tableID;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
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
    
    
}