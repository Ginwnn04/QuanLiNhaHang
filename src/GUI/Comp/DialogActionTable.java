package GUI.Comp;

import BUS.TableBUS;
import DAO.TableDAO;
import DTO.TableDTO;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class DialogActionTable extends javax.swing.JDialog {
    private TableDTO table  = new TableDTO();
    private TableBUS tableBUS  = new TableBUS();
    private boolean isUpdate;
    
    public DialogActionTable(java.awt.Frame parent, boolean modal, boolean enable) {
        
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
       
        cbxTrangThai.setEnabled(enable);
        
        
        // Set visible phai de cuoi cung
        
      
        
    }
    
    public void setAction(boolean isUpdate) {
        this.isUpdate = isUpdate;
        if (isUpdate) {
            jLabel5.setText("SỦA THÔNG TIN BÀN");
            btnThem.setText("SỬA");
            
        }
        else {
            setIDTable(table.createID(), false);
        }
        
    }
    
    public void setIDTable(long id, boolean isUpdate) {
        if (isUpdate) {
            table = tableBUS.findTableByID(id);
        }
        txtIDTable.setText(id + "");
        setVisible(true);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackground1 = new GUI.Comp.Swing.PanelBackground();
        txtIDTable = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNameTable = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDesTable = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxTrangThai = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelBackground1.setBackground(new java.awt.Color(30, 30, 30));

        txtIDTable.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtIDTable.setForeground(new java.awt.Color(255, 255, 255));
        txtIDTable.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID bàn");

        txtNameTable.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtNameTable.setForeground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tên bàn");

        txtDesTable.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtDesTable.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mô tả bàn");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Trạng thái");

        cbxTrangThai.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cbxTrangThai.setForeground(new java.awt.Color(255, 255, 255));
        cbxTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BANTRONG", "DANGSUDUNG", "DANGSUACHUA" }));

        btnThem.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("THÊM BÀN");

        javax.swing.GroupLayout panelBackground1Layout = new javax.swing.GroupLayout(panelBackground1);
        panelBackground1.setLayout(panelBackground1Layout);
        panelBackground1Layout.setHorizontalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBackground1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBackground1Layout.createSequentialGroup()
                                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panelBackground1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(txtDesTable, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelBackground1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(cbxTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelBackground1Layout.createSequentialGroup()
                                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(35, 35, 35)
                                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIDTable)
                                    .addComponent(txtNameTable, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panelBackground1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );
        panelBackground1Layout.setVerticalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackground1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel5)
                .addGap(35, 35, 35)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtIDTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNameTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDesTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        Date currentDate = new Date();
        
        table.setName(txtNameTable.getText());
        table.setDes(txtDesTable.getText());
        table.setStatus((String)cbxTrangThai.getSelectedItem());
        table.setCreateTime(currentDate);
        table.setUpdateTime(currentDate);
        
        
        if (isUpdate) {
            boolean check = tableBUS.updateTable(table);
            if (check) {
                JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Sửa thất bại");
            }
        }
        else {
            boolean check = tableBUS.insertTable(table);
            if (check) {
                JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại");
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

 
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogActionTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogActionTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogActionTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogActionTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogActionTable dialog = new DialogActionTable(new javax.swing.JFrame(), true, false);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbxTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private GUI.Comp.Swing.PanelBackground panelBackground1;
    private javax.swing.JTextField txtDesTable;
    private javax.swing.JTextField txtIDTable;
    private javax.swing.JTextField txtNameTable;
    // End of variables declaration//GEN-END:variables
}
