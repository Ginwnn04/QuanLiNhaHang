/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Comp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author quang
 */
public class PanelConfirmOrder extends javax.swing.JPanel {
    private String nameProduct;
    private int quantity = 1;
    private double price = 0;
    private double total = quantity * price;
    private boolean isDelete = false;
    
    public PanelConfirmOrder() {
        initComponents();
        serviceButton();
        
    }
    
    public void insertData(String nameProduct, double price, int quantity) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.total = price * quantity;
        update();
    }

    
    
    public void update() {
        if (quantity == 0) {
            this.getParent().remove(this);
            isDelete = true;
        }
        lbNameProduct.setText(nameProduct);
        lbTotal.setText("đ" + total);
    }
    
    public void serviceButton() {
        btnDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (quantity > 0) {
                    lbQuantity.setText(--quantity + "");
                    
                }
                update();
            }
        });
        btnUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbQuantity.setText(++quantity + "");
                
            }
            
        });
        
        
    }

    public int getQuantity() {
        return quantity;
    }
    
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground1 = new GUI.Comp.Swing.PanelBackground();
        lbNameProduct = new javax.swing.JLabel();
        lbTotal = new javax.swing.JLabel();
        pnSpinner = new GUI.Comp.Swing.PanelBackground();
        btnDown = new javax.swing.JButton();
        btnUp = new javax.swing.JButton();
        lbQuantity = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        panelBackground1.setBackground(new java.awt.Color(242, 242, 242));

        lbNameProduct.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbNameProduct.setText("Tôm sốt Mayonese trái thơm");

        lbTotal.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbTotal.setText("đ12.800.000");

        btnDown.setBackground(new java.awt.Color(204, 204, 204));
        btnDown.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnDown.setForeground(new java.awt.Color(102, 102, 102));
        btnDown.setText("-");
        btnDown.setBorderPainted(false);

        btnUp.setBackground(new java.awt.Color(52, 188, 137));
        btnUp.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnUp.setForeground(new java.awt.Color(255, 255, 255));
        btnUp.setText("+");
        btnUp.setBorderPainted(false);

        lbQuantity.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbQuantity.setText("1");

        javax.swing.GroupLayout pnSpinnerLayout = new javax.swing.GroupLayout(pnSpinner);
        pnSpinner.setLayout(pnSpinnerLayout);
        pnSpinnerLayout.setHorizontalGroup(
            pnSpinnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSpinnerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDown, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lbQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(btnUp, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnSpinnerLayout.setVerticalGroup(
            pnSpinnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnSpinnerLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(pnSpinnerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDown)
                    .addComponent(btnUp)
                    .addComponent(lbQuantity))
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout panelBackground1Layout = new javax.swing.GroupLayout(panelBackground1);
        panelBackground1.setLayout(panelBackground1Layout);
        panelBackground1Layout.setHorizontalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBackground1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbNameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelBackground1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        panelBackground1Layout.setVerticalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addComponent(lbNameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnSpinner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDown;
    private javax.swing.JButton btnUp;
    private javax.swing.JLabel lbNameProduct;
    private javax.swing.JLabel lbQuantity;
    private javax.swing.JLabel lbTotal;
    private GUI.Comp.Swing.PanelBackground panelBackground1;
    private GUI.Comp.Swing.PanelBackground pnSpinner;
    // End of variables declaration//GEN-END:variables
}
