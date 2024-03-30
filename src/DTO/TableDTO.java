package DTO;

import GUI.Comp.PanelTable;
import GUI.Comp.PanelTableBooking;

public class TableDTO {
    private long id;
    private String name;
    private String des;
    private String status;
    private String customerCode;
    private String createTime;
    private String updateTime;
    private boolean isDelete;

    private PanelTable pnTable;
    private PanelTableBooking pnTableBooking;
    public TableDTO() {
    }
    
    public TableDTO(long id, String name, String des, String status, String createTime, String updateTime, boolean isDelete) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
    }

    public PanelTableBooking createTableBooking() {
        pnTableBooking = new PanelTableBooking();
        pnTableBooking.setNameTable(name);
        if (status.equals("DANGSUDUNG")) {
            pnTableBooking.setStatus(false);
        }
        return pnTableBooking;
    }
    
    
    public PanelTable createTable() {
        pnTable = new PanelTable(name);
        if (status.equals("DANGSUDUNG")) {
            pnTable.setStatus(false);
        }
        
        return pnTable;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public PanelTableBooking getPnTableBooking() {
        return pnTableBooking;
    }
    
    
    
}
