/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package GUI.Comp;

import DTO.MenuItem;
import DAO.MenuItemDAO;
import java.awt.ComponentOrientation;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

/**
 *
 * @author quang
 */
public class NewJDialog extends javax.swing.JDialog {

    private ArrayList<MenuItem> listMenu = new ArrayList<>();
    private ArrayList<MenuItem> listDaChon = new ArrayList<>();

    /**
     * Creates new form NewJDialog
     */
    public NewJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        loadDataTableTimKiem();

    }

    public DefaultTableModel initTableTimKiem() {
        TableColumn col1 = tblTimKiem.getColumnModel().getColumn(0);
        col1.setPreferredWidth(200);
        TableColumn col2 = tblTimKiem.getColumnModel().getColumn(1);
        col2.setPreferredWidth(400);
        TableColumn col3 = tblTimKiem.getColumnModel().getColumn(2);
        col3.setPreferredWidth(100);
        TableColumn col4 = tblTimKiem.getColumnModel().getColumn(3);
        col4.setPreferredWidth(100);

        JTableHeader header = tblTimKiem.getTableHeader();
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);

        tblTimKiem.getColumnModel().getColumn(0).setCellRenderer(new ImageRendered());
        
        
        DefaultTableModel model = (DefaultTableModel) tblTimKiem.getModel();
        tblTimKiem.setModel(model);
        return model;
    }
    
    public DefaultTableModel initTableDaChon() {
        TableColumn col1 = tblMonChon.getColumnModel().getColumn(0);
        col1.setPreferredWidth(200);
        TableColumn col2 = tblMonChon.getColumnModel().getColumn(1);
        col2.setPreferredWidth(400);
        TableColumn col3 = tblMonChon.getColumnModel().getColumn(2);
        col3.setPreferredWidth(100);
        TableColumn col4 = tblMonChon.getColumnModel().getColumn(3);
        col4.setPreferredWidth(100);

        JTableHeader header = tblMonChon.getTableHeader();
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);

        tblMonChon.getColumnModel().getColumn(0).setCellRenderer(new ImageRendered());
        
        
        DefaultTableModel model = (DefaultTableModel) tblMonChon.getModel();
        tblMonChon.setModel(model);
        return model;
    }

    public void loadDataTableTimKiem() {
        DefaultTableModel model = initTableTimKiem();
        listMenu = new MenuItemDAO().readMenuItem();
        model.setRowCount(0);
        for (MenuItem x : listMenu) {

            model.addRow(new Object[]{x.getImage(), x.getName(), x.getPrice(), x.isIsDelete() == false ? "Còn" : "Hết"});
        }
        tblTimKiem.getColumnModel().getColumn(0).setCellRenderer(new ImageRendered());
        model.fireTableDataChanged();
    }

    public void loadDataTableDaChon(int sl) {
        DefaultTableModel model = initTableDaChon();
        listMenu = new MenuItemDAO().readMenuItem();
        model.setRowCount(0);
        for (MenuItem x : listDaChon) {
            model.addRow(new Object[]{x.getImage(), x.getName(), x.getPrice(), sl});
        }
        tblTimKiem.getColumnModel().getColumn(0).setCellRenderer(new ImageRendered());
        model.fireTableDataChanged();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTimMon = new javax.swing.JPanel();
        lbTenMon = new javax.swing.JLabel();
        tfTenMon = new javax.swing.JTextField();
        btnTimKiemMon = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTimKiem = new javax.swing.JTable();
        btnQuayLai = new javax.swing.JButton();
        pnChonMon = new javax.swing.JPanel();
        lbMonChon = new javax.swing.JLabel();
        tfMonChon = new javax.swing.JTextField();
        lbSoLuon = new javax.swing.JLabel();
        tfSoLuong = new javax.swing.JTextField();
        btnThemMon = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMonChon = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnTimMon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm món", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 0, 18))); // NOI18N

        lbTenMon.setText("Tên món");

        btnTimKiemMon.setText("Tìm kiếm");

        tblTimKiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Hình ảnh", "Tên món", "Giá", "Trạng trái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTimKiem.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblTimKiem.setRowHeight(100);
        tblTimKiem.setShowGrid(false);
        tblTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTimKiemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTimKiem);

        btnQuayLai.setText("Quay lại");

        javax.swing.GroupLayout pnTimMonLayout = new javax.swing.GroupLayout(pnTimMon);
        pnTimMon.setLayout(pnTimMonLayout);
        pnTimMonLayout.setHorizontalGroup(
            pnTimMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimMonLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnTimMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                    .addGroup(pnTimMonLayout.createSequentialGroup()
                        .addComponent(lbTenMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTenMon, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                        .addGap(161, 161, 161)
                        .addComponent(btnQuayLai, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTimKiemMon, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnTimMonLayout.setVerticalGroup(
            pnTimMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTimMonLayout.createSequentialGroup()
                .addGroup(pnTimMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiemMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTimMonLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnTimMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfTenMon)
                            .addGroup(pnTimMonLayout.createSequentialGroup()
                                .addComponent(lbTenMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(6, 6, 6))))
                    .addComponent(btnQuayLai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnChonMon.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đã chọn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        lbMonChon.setText("Tên món");

        lbSoLuon.setText("Số lượng");

        btnThemMon.setText("Thêm món");
        btnThemMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMonActionPerformed(evt);
            }
        });

        tblMonChon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Hình ảnh", "Tên món", "Giá", "Số lượng"
            }
        ));
        jScrollPane2.setViewportView(tblMonChon);

        javax.swing.GroupLayout pnChonMonLayout = new javax.swing.GroupLayout(pnChonMon);
        pnChonMon.setLayout(pnChonMonLayout);
        pnChonMonLayout.setHorizontalGroup(
            pnChonMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChonMonLayout.createSequentialGroup()
                .addGroup(pnChonMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnChonMonLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2))
                    .addGroup(pnChonMonLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lbMonChon)
                        .addGap(18, 18, 18)
                        .addComponent(tfMonChon, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                        .addGap(41, 41, 41)
                        .addComponent(lbSoLuon)
                        .addGap(18, 18, 18)
                        .addComponent(tfSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                        .addGap(108, 108, 108)
                        .addComponent(btnThemMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnChonMonLayout.setVerticalGroup(
            pnChonMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnChonMonLayout.createSequentialGroup()
                .addGroup(pnChonMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnChonMonLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(pnChonMonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbMonChon)
                            .addComponent(tfMonChon)
                            .addComponent(lbSoLuon)
                            .addComponent(tfSoLuong))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnChonMonLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnThemMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnTimMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnChonMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnTimMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnChonMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTimKiemMouseClicked
        int row = tblTimKiem.getSelectedRow();
        MenuItem menuItem = listMenu.get(row);
        tfMonChon.setText(menuItem.getName());
        
    }//GEN-LAST:event_tblTimKiemMouseClicked

    private void btnThemMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMonActionPerformed
        int row = tblTimKiem.getSelectedRow();
        listDaChon.add(listMenu.get(row));
//        loadDataTableDaChon(Integer.parseInt(tfSoLuong.getText("")));
    }//GEN-LAST:event_btnThemMonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(NewJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewJDialog dialog = new NewJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnQuayLai;
    private javax.swing.JButton btnThemMon;
    private javax.swing.JButton btnTimKiemMon;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbMonChon;
    private javax.swing.JLabel lbSoLuon;
    private javax.swing.JLabel lbTenMon;
    private javax.swing.JPanel pnChonMon;
    private javax.swing.JPanel pnTimMon;
    private javax.swing.JTable tblMonChon;
    private javax.swing.JTable tblTimKiem;
    private javax.swing.JTextField tfMonChon;
    private javax.swing.JTextField tfSoLuong;
    private javax.swing.JTextField tfTenMon;
    // End of variables declaration//GEN-END:variables
}
