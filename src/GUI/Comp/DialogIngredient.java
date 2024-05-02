/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Comp;

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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(null);

        jLabel1.setText("Nhập số lượng:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(70, 170, 160, 40);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(270, 240, 220, 40);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2);
        jTextField2.setBounds(270, 30, 220, 40);

        jLabel2.setText("Nhập đơn vị");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(70, 240, 160, 40);

        jLabel3.setText("Nhập mô tả:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(70, 100, 170, 40);

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3);
        jTextField3.setBounds(270, 100, 220, 40);

        jLabel4.setText("Nhập tên nguyên liệu:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 30, 180, 40);

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField4);
        jTextField4.setBounds(270, 170, 220, 40);

        jButton1.setText("Hủy");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(340, 320, 90, 50);

        jButton2.setText("Thêm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(210, 320, 90, 50);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

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
            return;}


    // Tạo một đối tượng IngredientsDTO để thêm vào cơ sở dữ liệu
    IngredientsDTO newIngredient = new IngredientsDTO();
    // Lấy thời gian hiện tại
    long currentTime = System.currentTimeMillis();
    // Lấy ba chữ số cuối cùng của thời gian hiện tại
    int id = (int) (currentTime % 1000);
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

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

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
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField2;
    public javax.swing.JTextField jTextField3;
    public javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
