package DAO;

import DTO.InvoicesDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import GUI.Comp.chart.ModelChartPie;
import java.awt.Color;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.IsoFields;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class InvoicesDAO {

    public boolean insertData(InvoicesDTO invoices) {
        String query = "INSERT INTO tb_invoices VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, invoices.getId());
            pstm.setLong(2, invoices.getAmount());
            pstm.setLong(3, invoices.getDiscount());
            pstm.setLong(4, invoices.getTotal());
            pstm.setBoolean(5, invoices.isIsDelete());
            Timestamp dateSQL = new Timestamp(invoices.getCreateTime().getTime());
            pstm.setTimestamp(6, dateSQL);
            pstm.setString(7, invoices.getDiscountID());
            return pstm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public InvoicesDTO readData(long idInvoice) {
        String query = "SELECT * FROM tb_invoices WHERE id = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setLong(1, idInvoice);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                InvoicesDTO invoice = new InvoicesDTO();
                invoice.setId(rs.getLong("id"));
                invoice.setAmount(rs.getLong("amount"));
                invoice.setDiscount(rs.getLong("discount_price"));
                invoice.setTotal(rs.getLong("total"));
                invoice.setIsDelete(rs.getBoolean("isdeleted"));
                invoice.setCreateTime(rs.getTimestamp("time"));
                invoice.setDiscountID(rs.getString("discountid"));
                return invoice;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<InvoicesDTO> readData() {
        String query;
        query = "SELECT * FROM tb_invoices";
        List<InvoicesDTO> res = new ArrayList<>();
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                InvoicesDTO invoice = new InvoicesDTO();
                invoice.setId(rs.getLong("id"));
                invoice.setAmount(rs.getLong("amount"));
                invoice.setDiscount(rs.getLong("discount_price"));
                invoice.setTotal(rs.getLong("total"));
                invoice.setIsDelete(rs.getBoolean("isdeleted"));
                invoice.setCreateTime(rs.getTimestamp("time"));
                invoice.setDiscountID(rs.getString("discountid"));
                res.add(invoice);
            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<ModelChartPie> readDetail(int index) {
        String query;
        Random rand = new Random();
        LocalDate firstDay = LocalDate.of(2024, 1, 1);
        LocalDate startOfWeek = firstDay.with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, index).with(DayOfWeek.MONDAY);
        LocalDate endOfWeek = startOfWeek.plusDays(6);
        java.sql.Date convertedStart = java.sql.Date.valueOf(startOfWeek);
        java.sql.Date convertedEnd = java.sql.Date.valueOf(endOfWeek.plusDays(1));
        query = """
                SELECT tb_menu_item.name as name, SUM(tb_detail_order.total) as total
                FROM tb_invoices
                JOIN tb_detail_order ON tb_invoices.id = tb_detail_order.invoiceid
                JOIN tb_menu_item ON tb_detail_order.itemid = tb_menu_item.id
                WHERE tb_invoices.time >= ? AND tb_invoices.time <= ?
                GROUP BY tb_menu_item.name""";
        List<ModelChartPie> res = new ArrayList<>();
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setDate(1, convertedStart);
            pstm.setDate(2, convertedEnd);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                ModelChartPie pie = new ModelChartPie();
                pie.setName(rs.getString("name"));
                pie.setValue(rs.getLong("total"));
                pie.setColor(new Color(rand.nextInt(250), rand.nextInt(250), rand.nextInt(250)));
                res.add(pie);
            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean removeInvoice(String listID){
        String query = "UPDATE tb_invoices SET isdeleted = true WHERE id IN (" + listID + ")";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)){
            return pstm.executeUpdate() > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

   
}
