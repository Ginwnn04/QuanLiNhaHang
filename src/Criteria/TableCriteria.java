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

    
    // true => update
    // false => select
    public String createClause(boolean isUpdate) {
        String clause = "";
        
        if (isUpdate) {
            if (name != null) {
                clause += "name = ?, ";
            }
            if (des != null) {
                clause += "des = ?, ";
            }
            if (isDelete != null) {
                clause += "isdeleted = ?, ";
            }
            if (customerCode != null) {
                clause += "customer_code = ?, ";
            }
            if (status != null) {
                clause += "statusid = ?, ";
            }
            if (updateTime != null) {
                clause += "update_time = ?, ";
            }
            if (note != null) {
                clause += "note = ?, ";
            }
            if (!clause.isEmpty()) {
                clause = clause.substring(0, clause.length() - 2);
            }
        }
        
        else {
            if (id != null) {
                clause += "id = ? AND ";
            }
            if (name != null) {
                clause += "name = ? AND ";
            }
            if (des != null) {
                clause += "des = ? AND ";
            }
            if (isDelete != null) {
                clause += "isdeleted = ? AND ";
            }
            if (customerCode != null) {
                clause += "customer_code = ? AND ";
            }
            if (status != null) {
                clause += "statusid = ? AND ";
            }
            if (updateTime != null) {
                clause += "update_time = ? AND ";
            }
            if (createTime != null) {
                clause += "create_time = ? AND ";
            }
            if (note != null) {
                clause += "note = ? AND ";
            }
            
            if (!clause.isEmpty()) {
                clause = clause.substring(0, clause.length() - 5);
            }
        }
        
        
        
        return clause;
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
