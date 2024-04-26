/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Criteria;

import java.util.Date;


public class TableCriteria {
    private Long id;
    private String name;
    private String des;
    private String status;
    private String customerCode;
    private String note;
    private Date createTime;
    private Date updateTime;
    private Boolean isDelete;

    @Override
    public String toString() {
        String whereClause = "";
        
        if (id != null) {
            whereClause += "id = ? AND ";
        }
        if (name != null) {
            whereClause += "name = ? AND ";
        }
        if (des != null) {
            whereClause += "des = ? AND ";
        }
        if (status != null) {
            whereClause += "statusid = ? AND ";
        }
        if (customerCode != null) {
            whereClause += "customer_code = ? AND ";
        }
        if (note != null) {
            whereClause += "note = ? AND ";
        }
        if (createTime != null) {
            whereClause += "create_time = ? AND ";
        }
        if (updateTime != null) {
            whereClause += "update_time = ? AND ";
        }
        if (isDelete != null) {
            whereClause += "isdeleted = ? AND ";
        }
        
        
        if (!whereClause.isEmpty()) {
            whereClause = whereClause.substring(0, whereClause.length() - 5);
        }
        return whereClause;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }



    
    
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

    public String getStatus() {
        return status;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public String getNote() {
        return note;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public Boolean isIsDelete() {
        return isDelete;
    }
    
    
}
