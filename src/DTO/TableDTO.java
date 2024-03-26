/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import GUI.Comp.TableBook;

/**
 *
 * @author quang
 */
public class TableDTO {
    private String id;
    private String name;
    private String des;
    private String status;
    private String customerCode;
    private String createTime;
    private String updateTime;
    private boolean isDelete;

    private TableBook pnTableBook;
    public TableDTO() {
    }
    
    public TableDTO(String id, String name, String des, String status, String createTime, String updateTime, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
    }

    public TableBook createTableBook() {
        pnTableBook = new TableBook(name);
        if (status.equals("DANGSUDUNG")) {
            pnTableBook.setStatus(false);
            pnTableBook.update();
        }
        return pnTableBook;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    
}
