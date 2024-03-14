/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Comp;


import Helper.MyListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.ImageIcon;


/**
 *
 * @author quang
 */
public class PanelProductOrder extends javax.swing.JPanel {
    public static int indexProduct = -1;
    private int index = -1;
    
    
    public PanelProductOrder() {
        initComponents();
    }

    public void insertData(int index, String nameProduct, double price, String status, String imagePath) {
        this.index = index;
        lbNameProduct.setText(nameProduct);
        lbShowPrice.setText("đ" + price);
        lbShowActive.setText(status);
        
        ImageIcon image = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/ImageProduct/" + imagePath)).getImage().getScaledInstance(100, 100, 4));
        avatarProduct.setImage(image);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnDetailProduct = new GUI.Comp.Swing.PanelBackground();
        avatarProduct = new GUI.Comp.AvatarProduct();
        lbNameProduct = new javax.swing.JLabel();
        lbActiveProduct = new javax.swing.JLabel();
        lbPrice = new javax.swing.JLabel();
        btnSelection = new javax.swing.JButton();
        lbShowPrice = new javax.swing.JLabel();
        lbShowActive = new javax.swing.JLabel();

        lbNameProduct.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbNameProduct.setText("Tôm sốt Mayonese trái thơm");

        lbActiveProduct.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lbActiveProduct.setText("Trạng thái");

        lbPrice.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lbPrice.setText("Giá");

        btnSelection.setBackground(new java.awt.Color(52, 188, 137));
        btnSelection.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnSelection.setForeground(new java.awt.Color(255, 255, 255));
        btnSelection.setText("+");
        btnSelection.setBorderPainted(false);
        btnSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectionActionPerformed(evt);
            }
        });

        lbShowPrice.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbShowPrice.setText("đ50.000");

        lbShowActive.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbShowActive.setText("Món ăn sẵn sàng");

        javax.swing.GroupLayout pnDetailProductLayout = new javax.swing.GroupLayout(pnDetailProduct);
        pnDetailProduct.setLayout(pnDetailProductLayout);
        pnDetailProductLayout.setHorizontalGroup(
            pnDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailProductLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(avatarProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(pnDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDetailProductLayout.createSequentialGroup()
                        .addComponent(lbNameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(47, Short.MAX_VALUE))
                    .addGroup(pnDetailProductLayout.createSequentialGroup()
                        .addGroup(pnDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDetailProductLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lbPrice)
                                .addGap(59, 59, 59)
                                .addComponent(lbShowPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnDetailProductLayout.createSequentialGroup()
                                .addComponent(lbActiveProduct)
                                .addGap(18, 18, 18)
                                .addComponent(lbShowActive)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))))
        );
        pnDetailProductLayout.setVerticalGroup(
            pnDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(avatarProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnDetailProductLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lbPrice)
                        .addGap(10, 10, 10)
                        .addGroup(pnDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbActiveProduct)
                            .addComponent(lbShowActive)))
                    .addGroup(pnDetailProductLayout.createSequentialGroup()
                        .addComponent(lbNameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbShowPrice)
                            .addComponent(btnSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pnDetailProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(pnDetailProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectionActionPerformed
        MyListener.getInstance().firePropertyChange("AddItem", -1, index);
    }//GEN-LAST:event_btnSelectionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.Comp.AvatarProduct avatarProduct;
    public javax.swing.JButton btnSelection;
    private javax.swing.JLabel lbActiveProduct;
    private javax.swing.JLabel lbNameProduct;
    private javax.swing.JLabel lbPrice;
    private javax.swing.JLabel lbShowActive;
    private javax.swing.JLabel lbShowPrice;
    private GUI.Comp.Swing.PanelBackground pnDetailProduct;
    // End of variables declaration//GEN-END:variables

    
}
