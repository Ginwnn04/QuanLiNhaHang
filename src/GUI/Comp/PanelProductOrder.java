/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Comp;


import Helper.MyListener;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 *
 * @author quang
 */
public class PanelProductOrder extends javax.swing.JPanel {
    public static int indexProduct = -1;
    private int index = -1;
    private String desc;
    private String ingredient;
    private ModalItem modal = new ModalItem();
    
    public PanelProductOrder() {
        initComponents();
        btnModal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,modal,"Your title here bro",JOptionPane.PLAIN_MESSAGE);

            }
        
        });
    }

    public void insertData(int index, String nameProduct, long price, String status, String imagePath, String desc, String ingredient) {
        this.index = index;
        this.desc = desc;
        this.ingredient = ingredient;
        
        lbNameProduct.setText(nameProduct);
        lbShowPrice.setText("đ" + price);
        lbShowActive.setText(status);
        
       
        
        ImageIcon image = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/ImageProduct/" + imagePath)).getImage().getScaledInstance(100, 100, 4));
        ImageIcon imageModal = new ImageIcon(new ImageIcon(getClass().getResource("/GUI/ImageProduct/" + imagePath)).getImage().getScaledInstance(408, 277, 4));

        avatarProduct.setImage(image);
      
        modal.insertData(imageModal, desc, ingredient);
        
        
        pnDetailProduct.setColor(new Color(53, 53, 53));
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
        btnModal = new javax.swing.JButton();

        pnDetailProduct.setBackground(new java.awt.Color(35, 35, 35));

        lbNameProduct.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbNameProduct.setForeground(new java.awt.Color(255, 255, 255));
        lbNameProduct.setText("Tôm sốt Mayonese trái thơm");

        lbActiveProduct.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lbActiveProduct.setForeground(new java.awt.Color(255, 255, 255));
        lbActiveProduct.setText("Trạng thái");

        lbPrice.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lbPrice.setForeground(new java.awt.Color(255, 255, 255));
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
        lbShowPrice.setForeground(new java.awt.Color(255, 255, 255));
        lbShowPrice.setText("đ50.000");

        lbShowActive.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbShowActive.setForeground(new java.awt.Color(255, 255, 255));
        lbShowActive.setText("Món ăn sẵn sàng");

        btnModal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Comp/Icon/eye.png"))); // NOI18N
        btnModal.setPreferredSize(new java.awt.Dimension(24, 24));

        javax.swing.GroupLayout pnDetailProductLayout = new javax.swing.GroupLayout(pnDetailProduct);
        pnDetailProduct.setLayout(pnDetailProductLayout);
        pnDetailProductLayout.setHorizontalGroup(
            pnDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDetailProductLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(avatarProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(pnDetailProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbNameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addGap(18, 18, 18)
                        .addComponent(btnModal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
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
                            .addComponent(btnSelection, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModal, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnDetailProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    private javax.swing.JButton btnModal;
    public javax.swing.JButton btnSelection;
    private javax.swing.JLabel lbActiveProduct;
    private javax.swing.JLabel lbNameProduct;
    private javax.swing.JLabel lbPrice;
    private javax.swing.JLabel lbShowActive;
    private javax.swing.JLabel lbShowPrice;
    private GUI.Comp.Swing.PanelBackground pnDetailProduct;
    // End of variables declaration//GEN-END:variables

    
}
