package GUI.Comp.chart;

import java.util.Date;

public class ModelInvoices {

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
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

    public ModelInvoices(Date date, long ID, long price, long discount, long total) {
        this.date = date;
        this.ID = ID;
        this.price = price;
        this.discount = discount;
        this.total = total;
    }

    public ModelInvoices() {
    }

    private Date date;
    private long ID;
    private long price;
    private long discount;
    private long total;

    public Object[] toDataTable() {
        return new Object[] { date, ID, price, discount, total };
    }
}
