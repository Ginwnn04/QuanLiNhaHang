package GUI.Comp;

import java.awt.Color;
import javax.swing.ImageIcon;

public class PanelTableBooking extends javax.swing.JPanel {
    private String nameTable;
    private boolean isSelected = false;
    private boolean isEmpty = true;
    
    
    public PanelTableBooking() {
        initComponents();
        init();
        panelBackground1.setColor(new Color(53, 53, 53));
    }
    
    

    public void init() {
        if (!isSelected) {
            btnSelected.setBackground(new Color(152, 188, 138));
            btnSelected.setText("+");
        } else {
            btnSelected.setBackground(new Color(53, 53, 53));
            btnSelected.setText("-");
        }
    }

    
    
    public boolean isIsEmpty() {
        return isEmpty;
    }

    public void setStatus(boolean isEmpty) {
        this.isEmpty = isEmpty;
        update();
    }
    
    public void update() {
        String status = "";
        if (isEmpty) {
            status = "Bàn trống";
        }
        else {
           status = "Đang sử dụng";

        }
        lbTrangThai.setText(status);
        lbTenBan.setText(nameTable);
    }

    
    
    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
        init();
    }

    public String getNameTable() {
        return nameTable;
    }

    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
        update();
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground1 = new GUI.Comp.Swing.PanelBackground();
        lbTenBan = new javax.swing.JLabel();
        lbTrangThai = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSelected = new javax.swing.JButton();

        panelBackground1.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground1.setPreferredSize(new java.awt.Dimension(260, 85));

        lbTenBan.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbTenBan.setForeground(new java.awt.Color(255, 255, 255));
        lbTenBan.setText("Tên bàn");

        lbTrangThai.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbTrangThai.setForeground(new java.awt.Color(255, 255, 255));
        lbTrangThai.setText("Đang sử dụng");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Trạng thái");

        btnSelected.setBackground(new java.awt.Color(52, 188, 137));
        btnSelected.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnSelected.setForeground(new java.awt.Color(255, 255, 255));
        btnSelected.setText("+");
        btnSelected.setBorderPainted(false);
        btnSelected.setPreferredSize(new java.awt.Dimension(25, 25));
        btnSelected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBackground1Layout = new javax.swing.GroupLayout(panelBackground1);
        panelBackground1.setLayout(panelBackground1Layout);
        panelBackground1Layout.setHorizontalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBackground1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(15, 15, 15)
                        .addComponent(lbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbTenBan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(btnSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        panelBackground1Layout.setVerticalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBackground1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lbTenBan)
                        .addGap(15, 15, 15)
                        .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTrangThai)
                            .addComponent(jLabel3)))
                    .addGroup(panelBackground1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectedActionPerformed
        isSelected = !isSelected;
        init();
    }//GEN-LAST:event_btnSelectedActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelected;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbTenBan;
    private javax.swing.JLabel lbTrangThai;
    private GUI.Comp.Swing.PanelBackground panelBackground1;
    // End of variables declaration//GEN-END:variables
}
