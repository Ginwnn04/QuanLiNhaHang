/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Comp;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;

/**
 *
 * @author quang
 */
public class TableBook extends javax.swing.JPanel {
    private boolean isEmpty = true;
    private int numberTable;
    
    public void setStatus(boolean rq) {
        this.isEmpty = rq;
        init();
    }
    public boolean getStatus() {
        return isEmpty;
    }
    
    

    public TableBook() {
    }
    public TableBook(int numberTable) {
        this.numberTable = numberTable;
        initComponents();
        setBackground(new Color(0,0,0,0));
        init();
        lbNumberTable.setText("Bàn " + numberTable);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
    }
    public int getNumberTable() {
        return numberTable;
    }
    public void init() {
        if (isEmpty) {
            panelBackground.setBackground(new Color(103, 199, 143, 255));
            lbIcon.setIcon(new ImageIcon(getClass().getResource("/GUI/Comp/Icon/check.png")));
            lbStatus.setText("Bàn trống");
        }
        else {
            panelBackground.setBackground(new Color(0, 51, 51, 255));
            lbIcon.setIcon(new ImageIcon(getClass().getResource("/GUI/Comp/Icon/user.png")));
        
            lbStatus.setText("Đang sử dụng");
        }
    }
    
    /**
     * This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground = new GUI.Comp.Swing.PanelBackground();
        lbNumberTable = new javax.swing.JLabel();
        lbStatus = new javax.swing.JLabel();
        lbIcon = new javax.swing.JLabel();

        panelBackground.setBackground(new java.awt.Color(103, 199, 143));
        panelBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbNumberTable.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        lbNumberTable.setForeground(new java.awt.Color(255, 255, 255));
        lbNumberTable.setText("B.111");
        panelBackground.add(lbNumberTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lbStatus.setBackground(new java.awt.Color(255, 255, 255));
        lbStatus.setFont(new java.awt.Font("Roboto Condensed", 3, 24)); // NOI18N
        lbStatus.setForeground(new java.awt.Color(255, 255, 255));
        lbStatus.setText("Bàn trống");
        panelBackground.add(lbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Comp/Icon/check.png"))); // NOI18N
        panelBackground.add(lbIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbNumberTable;
    private javax.swing.JLabel lbStatus;
    private GUI.Comp.Swing.PanelBackground panelBackground;
    // End of variables declaration//GEN-END:variables
}
