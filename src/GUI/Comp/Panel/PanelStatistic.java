/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Comp.Panel;

import GUI.Comp.chart.*;
import DTO.InvoicesDTO;
import BUS.InvoicesBUS;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class PanelStatistic extends javax.swing.JPanel {

    public List<InvoicesDTO> listInvoice = new ArrayList<>();
    public InvoicesBUS invoicesBUS = new InvoicesBUS();
    public long[] arrLine = new long[7];

    public boolean isDateInWeek(String date1Str, String date2Str) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date1 = dateFormat.parse(date1Str);
            Date date2 = dateFormat.parse(date2Str);

            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(date1);
            calendar1.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(date2);
            boolean res = true;
            if (calendar2.before(calendar1)) {
                res = false;
            }
            calendar1.add(Calendar.DAY_OF_WEEK, 6);
            if (calendar2.after(calendar1)) {
                res = false;
            }
            return res;
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public PanelStatistic() {
        initComponents();
        initData();
        initInvoice();
    }

    private void initInvoice() {
        invoicesBUS = new InvoicesBUS();
        listInvoice = invoicesBUS.getInvoice();
    }

    private void initData() {
        // Add data combobox
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        for (int i = 1; i <= 52; i++) {
            Calendar weekCalendar = calendar.getInstance();
            weekCalendar.set(Calendar.YEAR, year);
            weekCalendar.set(Calendar.WEEK_OF_YEAR, i);
            weekCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
            Date startDate = weekCalendar.getTime();
            weekCalendar.add(Calendar.DAY_OF_YEAR, 6);
            Date endDate = weekCalendar.getTime();

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String weekText = "Tuần " + i + " (" + formatter.format(startDate) + " - " + formatter.format(endDate) + ")";
            comboBoxWeek.addItem(weekText);
        }
        comboBoxWeek.setSelectedIndex(-1);

        tableInvoices.fixTable(jScrollPane1);
        // Test data chart pie
        List<ModelChartPie> list1 = new ArrayList<>();
        /*list1.add(new ModelChartPie("Lemon juce", 10, new Color(4, 174, 243)));
                list1.add(new ModelChartPie("A5", 150, new Color(215, 39, 250)));
                list1.add(new ModelChartPie("BeefSteak", 80, new Color(44, 88, 236)));
                list1.add(new ModelChartPie("Thursday", 100, new Color(21, 202, 87)));
                list1.add(new ModelChartPie("Friday", 125, new Color(127, 63, 255)));
                list1.add(new ModelChartPie("Saturday", 80, new Color(238, 167, 35)));
                list1.add(new ModelChartPie("Sunday", 200, new Color(245, 79, 99)));*/
        chartPie.setModel(list1);
        // Test data chart line
        //List<ModelChartLine> list = new ArrayList<>();
        /*list.add(new ModelChartLine("Monday", 10));
                list.add(new ModelChartLine("Tuesday", 150));
                list.add(new ModelChartLine("Wednesday", 80));
                list.add(new ModelChartLine("Thursday", 100));
                list.add(new ModelChartLine("Friday", 125));
                list.add(new ModelChartLine("Saturday", 80));
                list.add(new ModelChartLine("Sunday", 200));*/
        //chartLine1.setModel(list);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chartPie = new GUI.Comp.chart.ChartPie();
        chartLine1 = new GUI.Comp.chart.ChartLine();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableInvoices = new GUI.Comp.chart.Table();
        comboBoxWeek = new javax.swing.JComboBox<>();

        tableInvoices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "ID", "Price", "Discount", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableInvoices);

        comboBoxWeek.setMaximumRowCount(10);
        comboBoxWeek.setToolTipText("");
        comboBoxWeek.setRenderer(null);
        comboBoxWeek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxWeekActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chartLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chartPie, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(comboBoxWeek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chartPie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chartLine1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(comboBoxWeek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxWeekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxWeekActionPerformed
        //Get the time selected and load data that match to the table
        if (comboBoxWeek.getSelectedIndex() != -1) {
            DefaultTableModel model = (DefaultTableModel) tableInvoices.getModel();
            if (model.getRowCount() > 0) {
                for (int i = model.getRowCount() - 1; i >= 0; i--) {
                    model.removeRow(i);
                }
            }
            for (int i = 0; i < 7; i++) {
                arrLine[i] = 0;
            }
            model.fireTableDataChanged();
            chartLine1.repaint();
            String str = comboBoxWeek.getSelectedItem().toString();
            String date = str.substring(str.indexOf('(') + 1, str.indexOf('-') - 1);
            List<ModelChartPie> listPie = new ArrayList<>();
            List<ModelChartLine> listLine = new ArrayList<>();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            for (var i : listInvoice) {
                String createTime = dateFormat.format(i.getCreateTime());
                if (isDateInWeek(date, createTime)) {
                    model.addRow(new ModelInvoices(i.getCreateTime(), i.getId(), i.getAmount(), i.getDiscount(), i.getTotal()).toDataTable());
                    int dayInWeek = Integer.valueOf(createTime.substring(0, createTime.indexOf('/') - 1)) - Integer.valueOf(date.substring(0, date.indexOf('/') - 1));
                    arrLine[dayInWeek] += i.getTotal();
                }
            }
            listLine.add(new ModelChartLine("Monday", arrLine[0]));
            listLine.add(new ModelChartLine("Tuesday", arrLine[1]));
            listLine.add(new ModelChartLine("Wednesday", arrLine[2]));
            listLine.add(new ModelChartLine("Thursday", arrLine[3]));
            listLine.add(new ModelChartLine("Friday", arrLine[4]));
            listLine.add(new ModelChartLine("Saturday", arrLine[5]));
            listLine.add(new ModelChartLine("Sunday", arrLine[6]));
            chartLine1.setModel(listLine);
        }
    }//GEN-LAST:event_comboBoxWeekActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.Comp.chart.ChartLine chartLine1;
    private GUI.Comp.chart.ChartPie chartPie;
    private javax.swing.JComboBox<String> comboBoxWeek;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.Comp.chart.Table tableInvoices;
    // End of variables declaration//GEN-END:variables
}
