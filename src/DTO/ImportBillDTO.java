/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Tai
 */
import java.sql.Date;

public class ImportBillDTO {
    private int id;
    private int quantity;
    private float total;
    private Date import_date;
    private int userId;
    private int supplierID;

    // Constructor
    public ImportBillDTO(int id, int quantity, float total, Date import_date, int userId, int supplierID) {
        this.id = id;
        this.quantity = quantity;
        this.total = total;
        this.import_date = import_date;
        this.userId = userId;
        this.supplierID = supplierID;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getImport_date() {
        return import_date;
    }

    public void setImport_date(Date import_date) {
        this.import_date = import_date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }
}

