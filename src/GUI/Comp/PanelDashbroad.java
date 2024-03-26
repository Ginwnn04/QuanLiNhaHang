/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Comp;

import BUS.TableBUS;
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
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class PanelDashbroad extends javax.swing.JPanel implements PropertyChangeListener {
    private ArrayList<TableDTO> listTable = new ArrayList<>();
    private List<TableBook> listPanelTable = new ArrayList<>();
    private int totalTable = 1;

    public PanelDashbroad() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        listTable = new TableBUS().getAllData();
        addTable(listTable.size());
        MyListener.getInstance().addPropertyChangeListener(this); 
        pnService.setColor(new Color(53,53,53));
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("Selected")) {
            jTextField1.setText(evt.getNewValue() + "");
            System.out.println(evt.getNewValue());
            for (TableBook x : listPanelTable) {
                if (x.getNameTable().equals(evt.getNewValue())) {
                    boolean check = x.isSelected();
                    for (TableBook y : listPanelTable) {
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
            for (TableBook x : listPanelTable) {
                if (x.isSelected()) {
                    isValid = true;
                }
            }
            btnDatBan.setEnabled(isValid);
        }
//        revalidate();
        repaint();
    }



    public void addTable(int totalTable) {
        int row = totalTable / 3;
        if (totalTable % 3 != 0) {
            row = (totalTable / 3) + 1;
        }
        int height = row * 125;
        pnContainerTable.setPreferredSize(new Dimension(550, height));
        for (int i = 0; i < totalTable; i++) {
            TableBook table = listTable.get(i).createTableBook();
            listPanelTable.add(table);
            pnContainerTable.add(table);
        }
    }

    public void setStatusTable(String nameTable, boolean isEmpty) {
        for (TableBook x : listPanelTable) {
            if (x.getNameTable().equals(nameTable)) {
                x.setStatus(isEmpty);
            }
        }
    }

    public boolean isUsed(String nameTable) {

        for (TableBook x : listPanelTable) {
            if (x.getNameTable().equals(nameTable)) {
                return x.getStatus();
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground1 = new GUI.Comp.Swing.PanelBackground();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnContainerTable = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        pnService = new GUI.Comp.Swing.PanelBackground();
        btnThanhToan = new javax.swing.JButton();
        btnHuyBan = new javax.swing.JButton();
        btnChuyenBan = new javax.swing.JButton();
        btnDatBan = new javax.swing.JButton();
        btnKiemTra = new javax.swing.JButton();

        setBackground(new java.awt.Color(35, 35, 35));
        setPreferredSize(new java.awt.Dimension(1077, 730));

        panelBackground1.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground1.setPreferredSize(new java.awt.Dimension(1077, 730));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(550, 520));

        pnContainerTable.setBackground(new java.awt.Color(35, 35, 35));
        pnContainerTable.setPreferredSize(new java.awt.Dimension(550, 510));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 12);
        flowLayout1.setAlignOnBaseline(true);
        pnContainerTable.setLayout(flowLayout1);
        jScrollPane2.setViewportView(pnContainerTable);

        pnService.setBackground(new java.awt.Color(35, 35, 35));

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnThanhToan.setText("THANH TOÁN");

        btnHuyBan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnHuyBan.setText("HUỶ BÀN");
        btnHuyBan.setPreferredSize(new java.awt.Dimension(105, 80));
        btnHuyBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyBanActionPerformed(evt);
            }
        });

        btnChuyenBan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnChuyenBan.setText("CHUYỂN BÀN");
        btnChuyenBan.setPreferredSize(new java.awt.Dimension(138, 80));

        btnDatBan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDatBan.setText("ĐẶT BÀN");
        btnDatBan.setEnabled(false);
        btnDatBan.setPreferredSize(new java.awt.Dimension(104, 80));

        btnKiemTra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnKiemTra.setText("KIỂM TRA");

        javax.swing.GroupLayout pnServiceLayout = new javax.swing.GroupLayout(pnService);
        pnService.setLayout(pnServiceLayout);
        pnServiceLayout.setHorizontalGroup(
            pnServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnServiceLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(pnServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(btnHuyBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnChuyenBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKiemTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46))
        );
        pnServiceLayout.setVerticalGroup(
            pnServiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnServiceLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnDatBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnHuyBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnChuyenBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnKiemTra, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelBackground1Layout = new javax.swing.GroupLayout(panelBackground1);
        panelBackground1.setLayout(panelBackground1Layout);
        panelBackground1Layout.setHorizontalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(pnService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBackground1Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(919, Short.MAX_VALUE)))
        );
        panelBackground1Layout.setVerticalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(88, Short.MAX_VALUE))
            .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelBackground1Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(733, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, 1071, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("");
        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyBanActionPerformed
        if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(jScrollPane2, "Chưa chọn bàn để huỷ");
            return;
        }
        String nameTable = jTextField1.getText();
        if (!isUsed(nameTable)) {
            setStatusTable(nameTable, true);
            jTextField1.setText("");
        } else {
            JOptionPane.showMessageDialog(jScrollPane2, "Không thể huỷ bàn");
        }
        return;
    }//GEN-LAST:event_btnHuyBanActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChuyenBan;
    public javax.swing.JButton btnDatBan;
    private javax.swing.JButton btnHuyBan;
    private javax.swing.JButton btnKiemTra;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private GUI.Comp.Swing.PanelBackground panelBackground1;
    private javax.swing.JPanel pnContainerTable;
    private GUI.Comp.Swing.PanelBackground pnService;
    // End of variables declaration//GEN-END:variables
}
