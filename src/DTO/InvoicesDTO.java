
package DTO;

import java.util.Date;
import java.util.Random;


public class InvoicesDTO {
    private long id;
    private long amount;
    private long discount;
    private long total;
    private Date createTime;
    private String discountID;
    private boolean isDelete;
 
    public InvoicesDTO(long amount, long total, Date createTime, boolean isDelete) {
        createID();
        this.amount = amount;
        this.total = total;
        this.createTime = createTime;
        this.isDelete = isDelete;
    }

    public InvoicesDTO(long id, long amount, long discount, long total, Date createTime, String discountID, boolean isDelete) {
        this.id = id;
        this.amount = amount;
        this.discount = discount;
        this.total = total;
        this.createTime = createTime;
        this.discountID = discountID;
        this.isDelete = isDelete;
    }
    

    public long createID() {
        this.id = System.currentTimeMillis();
        return id;
    }

    public void addDiscount(String discountID, long discount) {
        this.discountID = discountID;
        this.discount = discount;
        total = amount - discount;
    }
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getDiscount() {
        return discount;
    }

    public void setDiscount(long discount) {
        this.discount = discount;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    

    public String getDiscountID() {
        return discountID;
    }

    public void setDiscountID(String discountID) {
        this.discountID = discountID;
    }

    public boolean isIsDelete() {
        return isDelete;
    }

    public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }
    
    
}
