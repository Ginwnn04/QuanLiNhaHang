/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Comp.Dialog;

import BUS.IngredientsBUS;
import DTO.IngredientsDTO;
import java.awt.Dialog;
import java.awt.Window;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Tai
 */
public class DialogIngredient extends javax.swing.JPanel {

    /**
     * Creates new form DialogIngredient
     */
    public DialogIngredient() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnContainer = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        pnCenter = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(630, 430));
        setLayout(new java.awt.BorderLayout());

        pnContainer.setBackground(new java.awt.Color(35, 35, 35));
        pnContainer.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(35, 35, 35));
        jPanel1.setPreferredSize(new java.awt.Dimension(25, 100));
        pnContainer.add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel2.setBackground(new java.awt.Color(35, 35, 35));
        jPanel2.setPreferredSize(new java.awt.Dimension(25, 100));
        pnContainer.add(jPanel2, java.awt.BorderLayout.LINE_END);

        jPanel3.setBackground(new java.awt.Color(35, 35, 35));
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 25));
        pnContainer.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel4.setBackground(new java.awt.Color(35, 35, 35));
        jPanel4.setPreferredSize(new java.awt.Dimension(100, 25));
        pnContainer.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        pnCenter.setBackground(new java.awt.Color(35, 35, 35));
        pnCenter.setLayout(new java.awt.GridLayout(5, 1));

        jPanel5.setBackground(new java.awt.Color(35, 35, 35));
        jPanel5.setLayout(new java.awt.BorderLayout(30, 0));

        jPanel6.setBackground(new java.awt.Color(35, 35, 35));
        jPanel6.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel5.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel7.setBackground(new java.awt.Color(35, 35, 35));
        jPanel7.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel5.add(jPanel7, java.awt.BorderLayout.PAGE_END);

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tên nguyên liệu");
        jPanel5.add(jLabel5, java.awt.BorderLayout.LINE_START);

        jTextField2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jPanel5.add(jTextField2, java.awt.BorderLayout.CENTER);

        pnCenter.add(jPanel5);

        jPanel8.setBackground(new java.awt.Color(35, 35, 35));
        jPanel8.setLayout(new java.awt.BorderLayout(30, 0));

        jPanel9.setBackground(new java.awt.Color(35, 35, 35));
        jPanel9.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel8.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        jPanel10.setBackground(new java.awt.Color(35, 35, 35));
        jPanel10.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel8.add(jPanel10, java.awt.BorderLayout.PAGE_END);

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Mô tả");
        jLabel6.setPreferredSize(new java.awt.Dimension(96, 17));
        jPanel8.add(jLabel6, java.awt.BorderLayout.LINE_START);

        jTextField3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jPanel8.add(jTextField3, java.awt.BorderLayout.CENTER);

        pnCenter.add(jPanel8);

        jPanel11.setBackground(new java.awt.Color(35, 35, 35));
        jPanel11.setLayout(new java.awt.BorderLayout(30, 0));

        jPanel12.setBackground(new java.awt.Color(35, 35, 35));
        jPanel12.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel11.add(jPanel12, java.awt.BorderLayout.PAGE_START);

        jPanel13.setBackground(new java.awt.Color(35, 35, 35));
        jPanel13.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel11.add(jPanel13, java.awt.BorderLayout.PAGE_END);

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Số lượng");
        jLabel7.setPreferredSize(new java.awt.Dimension(96, 17));
        jPanel11.add(jLabel7, java.awt.BorderLayout.LINE_START);

        jTextField4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jPanel11.add(jTextField4, java.awt.BorderLayout.CENTER);

        pnCenter.add(jPanel11);

        jPanel14.setBackground(new java.awt.Color(35, 35, 35));
        jPanel14.setLayout(new java.awt.BorderLayout(30, 0));

        jPanel15.setBackground(new java.awt.Color(35, 35, 35));
        jPanel15.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel14.add(jPanel15, java.awt.BorderLayout.PAGE_START);

        jPanel16.setBackground(new java.awt.Color(35, 35, 35));
        jPanel16.setPreferredSize(new java.awt.Dimension(100, 20));
        jPanel14.add(jPanel16, java.awt.BorderLayout.PAGE_END);

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Đơn vị");
        jLabel8.setPreferredSize(new java.awt.Dimension(96, 17));
        jPanel14.add(jLabel8, java.awt.BorderLayout.LINE_START);

        jTextField1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jPanel14.add(jTextField1, java.awt.BorderLayout.CENTER);

        pnCenter.add(jPanel14);

        jPanel17.setBackground(new java.awt.Color(35, 35, 35));
        jPanel17.setLayout(new java.awt.BorderLayout(30, 0));

        jPanel18.setBackground(new java.awt.Color(35, 35, 35));
        jPanel18.setPreferredSize(new java.awt.Dimension(100, 5));
        jPanel17.add(jPanel18, java.awt.BorderLayout.PAGE_START);

        jPanel19.setBackground(new java.awt.Color(35, 35, 35));
        jPanel19.setPreferredSize(new java.awt.Dimension(100, 5));
        jPanel17.add(jPanel19, java.awt.BorderLayout.PAGE_END);

        jPanel20.setBackground(new java.awt.Color(35, 35, 35));

        jButton2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton2.setText("Thêm");
        jButton2.setPreferredSize(new java.awt.Dimension(85, 35));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel20.add(jButton2);

        jPanel21.setBackground(new java.awt.Color(35, 35, 35));
        jPanel21.setPreferredSize(new java.awt.Dimension(50, 15));
        jPanel20.add(jPanel21);

        jButton1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jButton1.setText("Hủy");
        jButton1.setPreferredSize(new java.awt.Dimension(85, 35));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel20.add(jButton1);

        jPanel17.add(jPanel20, java.awt.BorderLayout.CENTER);

        pnCenter.add(jPanel17);

        pnContainer.add(pnCenter, java.awt.BorderLayout.CENTER);

        add(pnContainer, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String name = jTextField2.getText().trim();
        String des = jTextField3.getText().trim();
        String quantityInput = jTextField4.getText().trim();
        String unit = jTextField1.getText().trim();

        // Kiểm tra các trường dữ liệu có bị bỏ trống hay không
        if (name.isEmpty() || des.isEmpty() || quantityInput.isEmpty() || unit.isEmpty()) {
            JOptionPane.showMessageDialog(DialogIngredient.this, "Vui lòng nhập đầy đủ thông tin.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Chuyển đổi và kiểm tra số lượng
        int quantity = Integer.parseInt(quantityInput);

        if (quantity < 0) {
            JOptionPane.showMessageDialog(DialogIngredient.this, "Số lượng không hợp lệ.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        // Tạo một đối tượng IngredientsDTO để thêm vào cơ sở dữ liệu
        IngredientsDTO newIngredient = new IngredientsDTO();
        // Lấy thời gian hiện tại
//        long currentTime = System.currentTimeMillis();
        // Lấy ba chữ số cuối cùng của thời gian hiện tại
        long id = System.currentTimeMillis();
        newIngredient.setId(id);
        newIngredient.setName(name);
        newIngredient.setDes(des);
        newIngredient.setQuantity(quantity);
        newIngredient.setUnit(unit);
        newIngredient.setIsDeleted(false);

        // Thực hiện thêm nguyên liệu vào cơ sở dữ liệu
        IngredientsBUS ingredientsBUS = new IngredientsBUS();
        boolean success = false;
        try {
            success = ingredientsBUS.addIngredient(newIngredient);
        } catch (Exception ex) {
            Logger.getLogger(DialogIngredient.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Hiển thị thông báo kết quả
        if (success) {
            JOptionPane.showMessageDialog(DialogIngredient.this, "Thêm nguyên liệu thành công!");
        } else {
            JOptionPane.showMessageDialog(DialogIngredient.this, "Thêm nguyên liệu không thành công!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }

        // Đóng JDialog sau khi thêm thành công hoặc thất bại
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

// Thêm phương thức dispose vào JDialog
    private void dispose() {
        Window window = SwingUtilities.getWindowAncestor(this);
        if (window instanceof Dialog) {
            Dialog dialog = (Dialog) window;
            dialog.dispose();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel10;
    public javax.swing.JPanel jPanel11;
    public javax.swing.JPanel jPanel12;
    public javax.swing.JPanel jPanel13;
    public javax.swing.JPanel jPanel14;
    public javax.swing.JPanel jPanel15;
    public javax.swing.JPanel jPanel16;
    public javax.swing.JPanel jPanel17;
    public javax.swing.JPanel jPanel18;
    public javax.swing.JPanel jPanel19;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel20;
    public javax.swing.JPanel jPanel21;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    public javax.swing.JPanel jPanel6;
    public javax.swing.JPanel jPanel7;
    public javax.swing.JPanel jPanel8;
    public javax.swing.JPanel jPanel9;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField2;
    public javax.swing.JTextField jTextField3;
    public javax.swing.JTextField jTextField4;
    public javax.swing.JPanel pnCenter;
    public javax.swing.JPanel pnContainer;
    // End of variables declaration//GEN-END:variables
}
