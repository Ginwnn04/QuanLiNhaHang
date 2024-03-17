/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Comp;

import Helper.MyListener;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PanelDashbroad extends javax.swing.JPanel implements PropertyChangeListener {

    private List<TableBook> listTable = new ArrayList<>();
    private int totalTable = 1;

    public PanelDashbroad() {
        initComponents();

        addTable(10);
        setStatusTable(4, false);
        setStatusTable(1, false);
        setStatusTable(6, false);
        setStatusTable(8, false);
        MyListener.getInstance().addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("Selected")) {
            jTextField1.setText((int) evt.getNewValue() + "");
            System.out.println((int) evt.getNewValue() + "");
            for (TableBook x : listTable) {
                if (x.getNumberTable() == (int) evt.getNewValue()) {
                    boolean check = x.isSelected();
                    for (TableBook y : listTable) {
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
            for (TableBook x : listTable) {
                if (x.isSelected()) {
                    isValid = true;
                }
            }
            btnDatBan.setEnabled(isValid);
        }
        revalidate();
        repaint();
    }

    public void addTable() {
        TableBook table = new TableBook(totalTable++);
        listTable.add(table);
        pnTableBook.add(table);
    }

    public void addTable(int totalTable) {
        int row = totalTable / 3;
        if (totalTable % 3 != 0) {
            row = (totalTable / 3) + 1;
        }
        int height = row * 125;
        pnTableBook.setPreferredSize(new Dimension(550, height));
        for (int i = 0; i < totalTable; i++) {
            addTable();
        }
    }

    public void setStatusTable(int numberTable, boolean isEmpty) {
        for (TableBook x : listTable) {
            if (x.getNumberTable() == numberTable) {
                x.setStatus(isEmpty);
            }
        }
    }

    public boolean isUsed(int numberTable) {

        for (TableBook x : listTable) {
            if (x.getNumberTable() == numberTable) {
                return x.getStatus();
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        pnTableBook = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnChuyenBan = new javax.swing.JButton();
        btnHuyBan = new javax.swing.JButton();
        btnKiemTra = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        btnDatBan = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(973, 666));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(550, 520));

        pnTableBook.setPreferredSize(new java.awt.Dimension(550, 510));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 12, 10);
        flowLayout1.setAlignOnBaseline(true);
        pnTableBook.setLayout(flowLayout1);
        jScrollPane2.setViewportView(pnTableBook);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thao tác", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 18))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(249, 340));

        btnChuyenBan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnChuyenBan.setText("CHUYỂN BÀN");

        btnHuyBan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnHuyBan.setText("HUỶ BÀN");
        btnHuyBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyBanActionPerformed(evt);
            }
        });

        btnKiemTra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnKiemTra.setText("KIỂM TRA");

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnThanhToan.setText("THANH TOÁN");

        btnDatBan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnDatBan.setText("ĐẶT BÀN");
        btnDatBan.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKiemTra, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuyBan, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChuyenBan, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnDatBan, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(btnChuyenBan, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(btnHuyBan, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(btnKiemTra, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );

        getAccessibleContext().setAccessibleName("");
        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyBanActionPerformed
        if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(jScrollPane2, "Chưa chọn bàn để huỷ");
            return;
        }
        int numberTable = Integer.parseInt(jTextField1.getText());
        if (!isUsed(numberTable)) {
            setStatusTable(numberTable, true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel pnTableBook;
    // End of variables declaration//GEN-END:variables
}
