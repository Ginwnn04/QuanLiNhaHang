/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Comp;

import BUS.OrderBUS;
import BUS.TableBUS;
import DAO.OrderDAO;
import DAO.TableDAO;
import DTO.OrderDTO;
import DTO.TableDTO;
import Helper.MyListener;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class PanelDashbroad extends javax.swing.JPanel implements PropertyChangeListener {
    private ArrayList<TableDTO> listTable = new ArrayList<>();
    private List<PanelTable> listPanelTable = new ArrayList<>();
    private OrderBUS orderBUS = new OrderBUS();
    private TableBUS tableBUS = new TableBUS();
    private int totalTable = 1;

    public PanelDashbroad() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        addTable();
        MyListener.getInstance().addPropertyChangeListener(this); 
//        pnService1.setColor(new Color(53,53,53));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("Selected")) {
//            jTextField1.setText(evt.getNewValue() + "");
            txtSaveTable.setText(evt.getNewValue() + "");
            System.out.println(evt.getNewValue());
            for (PanelTable x : listPanelTable) {
                if (x.getNameTable().equals(evt.getNewValue())) {
                    boolean check = x.isSelected();
                    for (PanelTable y : listPanelTable) {
                        y.setIsSelected(false);
                        y.update();
                    }
                    if (!check) {
                        x.setIsSelected(true);
                        x.update();
                        break;
                    }
                }
            }

            // Kiem tra co ban` nao duoc chon ko => (Yes) => Enable button DatBan
            boolean isValid = false;
            for (PanelTable x : listPanelTable) {
                if (x.isSelected()) {
                    isValid = true;
                }
            }
//            btnDatBan.setEnabled(isValid);
        }
//        revalidate();
        repaint();
    }



    public void addTable() {
        listPanelTable.removeAll(listPanelTable);
        pnContainerTable.removeAll();
        listTable = tableBUS.getAllData();
        int totalTable = listTable.size();
        int row = totalTable / 5;
        if (totalTable % 5 != 0) {
            row = (totalTable / 5) + 1;
        }
        int height = row * 125;
        pnContainerTable.setPreferredSize(new Dimension(550, height));
        for (int i = 0; i < totalTable; i++) {
            PanelTable table = listTable.get(i).createTable();
            listPanelTable.add(table);
            pnContainerTable.add(table);
        }
    }

    public void setStatusTable(String nameTable, boolean isEmpty) {
        for (PanelTable x : listPanelTable) {
            if (x.getNameTable().equals(nameTable)) {
                x.setStatus(isEmpty);
            }
        }
    }

    public boolean isUsed(String nameTable) {

        for (PanelTable x : listPanelTable) {
            if (x.getNameTable().equals(nameTable)) {
                return x.getStatus();
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSaveTable = new javax.swing.JTextField();
        panelBackground1 = new GUI.Comp.Swing.PanelBackground();
        panelBackground2 = new GUI.Comp.Swing.PanelBackground();
        panelBackground4 = new GUI.Comp.Swing.PanelBackground();
        panelBackground5 = new GUI.Comp.Swing.PanelBackground();
        panelBackground15 = new GUI.Comp.Swing.PanelBackground();
        panelBackground16 = new GUI.Comp.Swing.PanelBackground();
        panelBackground3 = new GUI.Comp.Swing.PanelBackground();
        panelBackground10 = new GUI.Comp.Swing.PanelBackground();
        btnGoiMon = new javax.swing.JButton();
        btnDatBan = new javax.swing.JButton();
        btnChuyenBan = new javax.swing.JButton();
        btnGopBan = new javax.swing.JButton();
        btnTachBan = new javax.swing.JButton();
        btnKiemTra = new javax.swing.JButton();
        panelBackground9 = new GUI.Comp.Swing.PanelBackground();
        panelBackground6 = new GUI.Comp.Swing.PanelBackground();
        panelBackground7 = new GUI.Comp.Swing.PanelBackground();
        panelBackground8 = new GUI.Comp.Swing.PanelBackground();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnContainerTable = new GUI.Comp.Swing.PanelBackground();

        setBackground(new java.awt.Color(35, 35, 35));
        setPreferredSize(new java.awt.Dimension(1077, 730));

        panelBackground1.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground1.setPreferredSize(new java.awt.Dimension(1077, 730));
        panelBackground1.setLayout(new java.awt.BorderLayout());

        panelBackground2.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground2.setLayout(new java.awt.BorderLayout());

        panelBackground4.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground4.setLayout(new java.awt.BorderLayout());

        panelBackground5.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground5.setPreferredSize(new java.awt.Dimension(977, 120));
        panelBackground5.setLayout(new java.awt.BorderLayout());

        panelBackground15.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground15.setPreferredSize(new java.awt.Dimension(30, 100));

        javax.swing.GroupLayout panelBackground15Layout = new javax.swing.GroupLayout(panelBackground15);
        panelBackground15.setLayout(panelBackground15Layout);
        panelBackground15Layout.setHorizontalGroup(
            panelBackground15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panelBackground15Layout.setVerticalGroup(
            panelBackground15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelBackground5.add(panelBackground15, java.awt.BorderLayout.LINE_START);

        panelBackground16.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground16.setPreferredSize(new java.awt.Dimension(30, 100));

        javax.swing.GroupLayout panelBackground16Layout = new javax.swing.GroupLayout(panelBackground16);
        panelBackground16.setLayout(panelBackground16Layout);
        panelBackground16Layout.setHorizontalGroup(
            panelBackground16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        panelBackground16Layout.setVerticalGroup(
            panelBackground16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelBackground5.add(panelBackground16, java.awt.BorderLayout.LINE_END);

        panelBackground3.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground3.setPreferredSize(new java.awt.Dimension(1077, 25));

        javax.swing.GroupLayout panelBackground3Layout = new javax.swing.GroupLayout(panelBackground3);
        panelBackground3.setLayout(panelBackground3Layout);
        panelBackground3Layout.setHorizontalGroup(
            panelBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1322, Short.MAX_VALUE)
        );
        panelBackground3Layout.setVerticalGroup(
            panelBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        panelBackground5.add(panelBackground3, java.awt.BorderLayout.PAGE_END);

        panelBackground10.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground10.setLayout(new java.awt.GridLayout(1, 0, 50, 0));

        btnGoiMon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGoiMon.setText("GỌI MÓN");
        btnGoiMon.setPreferredSize(new java.awt.Dimension(150, 75));
        btnGoiMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoiMonActionPerformed(evt);
            }
        });
        panelBackground10.add(btnGoiMon);

        btnDatBan.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnDatBan.setText("ĐẶT/HỦY ");
        btnDatBan.setToolTipText("");
        panelBackground10.add(btnDatBan);

        btnChuyenBan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnChuyenBan.setText("CHUYỂN BÀN");
        btnChuyenBan.setPreferredSize(new java.awt.Dimension(150, 75));
        panelBackground10.add(btnChuyenBan);

        btnGopBan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGopBan.setText("GỘP BÀN");
        btnGopBan.setPreferredSize(new java.awt.Dimension(150, 75));
        btnGopBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGopBanActionPerformed(evt);
            }
        });
        panelBackground10.add(btnGopBan);

        btnTachBan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnTachBan.setText("TÁCH BÀN");
        btnTachBan.setPreferredSize(new java.awt.Dimension(150, 75));
        btnTachBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTachBanActionPerformed(evt);
            }
        });
        panelBackground10.add(btnTachBan);

        btnKiemTra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnKiemTra.setText("KIỂM TRA");
        btnKiemTra.setPreferredSize(new java.awt.Dimension(150, 75));
        btnKiemTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKiemTraActionPerformed(evt);
            }
        });
        panelBackground10.add(btnKiemTra);

        panelBackground5.add(panelBackground10, java.awt.BorderLayout.CENTER);

        panelBackground9.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground9.setPreferredSize(new java.awt.Dimension(1077, 25));

        javax.swing.GroupLayout panelBackground9Layout = new javax.swing.GroupLayout(panelBackground9);
        panelBackground9.setLayout(panelBackground9Layout);
        panelBackground9Layout.setHorizontalGroup(
            panelBackground9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1322, Short.MAX_VALUE)
        );
        panelBackground9Layout.setVerticalGroup(
            panelBackground9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        panelBackground5.add(panelBackground9, java.awt.BorderLayout.PAGE_START);

        panelBackground4.add(panelBackground5, java.awt.BorderLayout.PAGE_START);

        panelBackground6.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground6.setPreferredSize(new java.awt.Dimension(30, 600));

        javax.swing.GroupLayout panelBackground6Layout = new javax.swing.GroupLayout(panelBackground6);
        panelBackground6.setLayout(panelBackground6Layout);
        panelBackground6Layout.setHorizontalGroup(
            panelBackground6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        panelBackground6Layout.setVerticalGroup(
            panelBackground6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        panelBackground4.add(panelBackground6, java.awt.BorderLayout.LINE_START);

        panelBackground7.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground7.setPreferredSize(new java.awt.Dimension(30, 670));

        javax.swing.GroupLayout panelBackground7Layout = new javax.swing.GroupLayout(panelBackground7);
        panelBackground7.setLayout(panelBackground7Layout);
        panelBackground7Layout.setHorizontalGroup(
            panelBackground7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        panelBackground7Layout.setVerticalGroup(
            panelBackground7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        panelBackground4.add(panelBackground7, java.awt.BorderLayout.LINE_END);

        panelBackground8.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground8.setPreferredSize(new java.awt.Dimension(977, 30));

        javax.swing.GroupLayout panelBackground8Layout = new javax.swing.GroupLayout(panelBackground8);
        panelBackground8.setLayout(panelBackground8Layout);
        panelBackground8Layout.setHorizontalGroup(
            panelBackground8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1322, Short.MAX_VALUE)
        );
        panelBackground8Layout.setVerticalGroup(
            panelBackground8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        panelBackground4.add(panelBackground8, java.awt.BorderLayout.PAGE_END);

        jScrollPane1.setBackground(new java.awt.Color(30, 30, 30));
        jScrollPane1.setBorder(null);

        pnContainerTable.setBackground(new java.awt.Color(35, 35, 35));
        pnContainerTable.setPreferredSize(new java.awt.Dimension(500, 670));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 12);
        flowLayout1.setAlignOnBaseline(true);
        pnContainerTable.setLayout(flowLayout1);
        jScrollPane1.setViewportView(pnContainerTable);

        panelBackground4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panelBackground2.add(panelBackground4, java.awt.BorderLayout.CENTER);

        panelBackground1.add(panelBackground2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("");
        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void btnGoiMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoiMonActionPerformed
        DialogOrder a = new DialogOrder(null, true);
        a.setVisible(true);
        addTable();
        pnContainerTable.revalidate();
        pnContainerTable.repaint();

        
    }//GEN-LAST:event_btnGoiMonActionPerformed

    private void btnKiemTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKiemTraActionPerformed
        String customerCode = "";
        TableDTO table = new TableDTO();
//        listTable = new TableBUS().getAllData();
        for (TableDTO x : listTable) {
            if (x.getName().equals(txtSaveTable.getText())) {
                customerCode = x.getCustomerCode();
                table = x;
                System.out.println(x.getNote());
                break;
            }
        }
        ArrayList<OrderDTO> listOrder = orderBUS.findOrderByCustomerCode(customerCode);
        String listOrderId = "";
        for (OrderDTO x : listOrder) {
            listOrderId += x.getId() + ", ";
        }
        listOrderId = listOrderId.substring(0, listOrderId.length() - 2);
        if (listOrderId.isEmpty()) {
            JOptionPane.showMessageDialog(pnContainerTable, "Không tồn tại");
            return;
        }
        DialogKiemTra kt = new DialogKiemTra(null, true);
        kt.loadForm(listOrderId, table);
        kt.setVisible(true);
        
        addTable();
        pnContainerTable.revalidate();
        pnContainerTable.repaint();
    }//GEN-LAST:event_btnKiemTraActionPerformed

    private void btnGopBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGopBanActionPerformed
        // CustomerCode này là của table muốn gộp 
        String customerCode =  JOptionPane.showInputDialog(pnContainerTable, "Mã khách muốn gộp bàn");
        if (customerCode == null) {
            return;
        }
        ArrayList<OrderDTO> listOrderMerge = orderBUS.findOrderByCustomerCode(customerCode);
        ArrayList<TableDTO> listTableMerge  = tableBUS.findTableByCustomerCode(customerCode);
        
        String customerCodeNew = "";
        String listTableID = "";
        // Bàn muốn gộp đến đang là bàn Đơn => Tạo lại customer code để gán cho cả 2 table
        if (customerCode.substring(0, 1).equals("S")) {
            // Table chọn để gộp với bàn khác
            TableDTO tableSelected = tableBUS.findTableByName(txtSaveTable.getText());
            // Kiểm tra coi nó là bàn Đơn hay không ?
            if (tableSelected.getCustomerCode().substring(0, 1).equals("S")) {
                // Lúc này ta biết bàn này là bàn đơn => chắc chắn sẽ có duy nhất 1 obj order được trả ra
                OrderDTO order = listOrderMerge.get(0);
                customerCodeNew = order.createCustomerCode(false);
                TableDTO tableWillMove = listTableMerge.get(0);
                // Tạo lại customerCode là bàn Đôi
                order.createCustomerCode(false);
                listTableID = tableSelected.getId() + ", " + tableWillMove.getId();
            }
            else {
                customerCodeNew = tableSelected.getCustomerCode();
                TableDTO tableWillMove = listTableMerge.get(0);
                listTableID = tableWillMove.getId() + "";
            }
        }
        else {
            TableDTO tableSelected = tableBUS.findTableByName(txtSaveTable.getText());
            if (tableSelected.getCustomerCode().substring(0, 1).equals("S")) {
                TableDTO tableWillMove = listTableMerge.get(0);
                customerCodeNew = tableWillMove.getCustomerCode();
                listTableID = tableSelected.getId() + ""; 
            }
            else {
                 customerCodeNew = tableSelected.getCustomerCode();
                 for (TableDTO x : listTableMerge) {
                     listTableID += x.getId() + ", ";
                 }
                 listTableID = listTableID.substring(0, listTableID.length() - 2);
            }
        }
        orderBUS.updateCustomerCode(listTableID, customerCodeNew);
        tableBUS.updateCustomerCode(listTableID, customerCodeNew);
        addTable();
        pnContainerTable.revalidate();
        pnContainerTable.repaint();
//        System.out.println(txtSaveTable.getText());
//        System.out.println(customerCode);
    }//GEN-LAST:event_btnGopBanActionPerformed

    private void btnTachBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTachBanActionPerformed
        TableDTO tableSelected = tableBUS.findTableByName(txtSaveTable.getText());
        if (tableSelected == null) {
            JOptionPane.showMessageDialog(pnContainerTable, "Vui lòng chọn Bàn cần tách");
            return;
        }
        String customerCode = tableSelected.getCustomerCode();
        if (customerCode.isEmpty()) {
            JOptionPane.showMessageDialog(pnContainerTable, "Không thể tách vì là Bàn Trống");
            return;
        }
        if (customerCode.substring(0, 1).equals("M")) {
            OrderDTO order = new OrderDTO();
            String customerCodeNew = order.createCustomerCode(true);
            orderBUS.updateCustomerCode(tableSelected.getId() + "", customerCodeNew);
            tableBUS.updateCustomerCode(tableSelected.getId() + "", customerCodeNew);
            addTable();
            pnContainerTable.revalidate();
            pnContainerTable.repaint();           
        }
        else {
            JOptionPane.showMessageDialog(pnContainerTable, "Không thể tách vì đang là Bàn Đơn");
            return;
        }
    }//GEN-LAST:event_btnTachBanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChuyenBan;
    private javax.swing.JButton btnDatBan;
    public javax.swing.JButton btnGoiMon;
    private javax.swing.JButton btnGopBan;
    private javax.swing.JButton btnKiemTra;
    private javax.swing.JButton btnTachBan;
    private javax.swing.JScrollPane jScrollPane1;
    private GUI.Comp.Swing.PanelBackground panelBackground1;
    private GUI.Comp.Swing.PanelBackground panelBackground10;
    private GUI.Comp.Swing.PanelBackground panelBackground15;
    private GUI.Comp.Swing.PanelBackground panelBackground16;
    private GUI.Comp.Swing.PanelBackground panelBackground2;
    private GUI.Comp.Swing.PanelBackground panelBackground3;
    private GUI.Comp.Swing.PanelBackground panelBackground4;
    private GUI.Comp.Swing.PanelBackground panelBackground5;
    private GUI.Comp.Swing.PanelBackground panelBackground6;
    private GUI.Comp.Swing.PanelBackground panelBackground7;
    private GUI.Comp.Swing.PanelBackground panelBackground8;
    private GUI.Comp.Swing.PanelBackground panelBackground9;
    private GUI.Comp.Swing.PanelBackground pnContainerTable;
    private javax.swing.JTextField txtSaveTable;
    // End of variables declaration//GEN-END:variables
}
