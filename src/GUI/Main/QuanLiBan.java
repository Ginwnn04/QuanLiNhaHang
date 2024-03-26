/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Main;

import DAO.TableDAO;
import DTO.TableDTO;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatPropertiesLaf;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author pc
 */
public class QuanLiBan extends javax.swing.JPanel {
    private ArrayList<TableDTO> listTable;
    private DefaultTableModel model;
    private TableDAO tableDAO = new TableDAO();
    private boolean isSelectAll = false;
    public QuanLiBan() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        tbBan.setRowHeight(35);
        listTable = tableDAO.readData();
        // header table nam ben trai
        DefaultTableCellRenderer  renderer = (DefaultTableCellRenderer) tbBan.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.LEFT);
        txtTimKiem.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nhập bàn cần tìm");
        render(isSelectAll);
        
    }

    public void render(boolean isSelectAll) {
        model = (DefaultTableModel)tbBan.getModel();
        model.setRowCount(0);
        for (TableDTO x : listTable) {
            model.addRow(new Object[] {isSelectAll, x.getId(), x.getName(), x.getStatus(), x.getCustomerCode(), x.getCreateTime()});
        }
        model.fireTableDataChanged();
        tbBan.setModel(model);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnContainer = new GUI.Comp.Swing.PanelBackground();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbBan = new javax.swing.JTable();
        pnSelectAll = new GUI.Comp.Swing.PanelBackground();
        chbSelectAll = new javax.swing.JCheckBox();
        txtTimKiem = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1077, 730));

        pnContainer.setBackground(new java.awt.Color(30, 30, 30));

        tbBan.setAutoCreateRowSorter(true);
        tbBan.setBackground(new java.awt.Color(35, 35, 35));
        tbBan.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tbBan.setForeground(new java.awt.Color(255, 255, 255));
        tbBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "aaaaaaaaaa", "ádasdasd", "aaaaaaaaaa", "aaaaaaaaaa", "aaaaaaaaaa"},
                {null, "aaaaaaaaaa", "ádasd", "aaaaaaaaaa", "aaaaaaaaaa", "aaaaaaaaaa"},
                {null, "aaaaaaaaaa", "ádasd", "aaaaaaaaaa", "aaaaaaaaaa", "aaaaaaaaaa"},
                {null, "aaaaaaaaaa", "ádasda", "aaaaaaaaaa", "aaaaaaaaaa", "aaaaaaaaaa"}
            },
            new String [] {
                "", "Mã bàn", "Tên bàn", "Trạng thái", "Mã khách hàng", "Ngày"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbBan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbBan.getTableHeader().setResizingAllowed(false);
        tbBan.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbBan);
        if (tbBan.getColumnModel().getColumnCount() > 0) {
            tbBan.getColumnModel().getColumn(0).setPreferredWidth(20);
            tbBan.getColumnModel().getColumn(0).setMaxWidth(20);
            tbBan.getColumnModel().getColumn(2).setPreferredWidth(100);
            tbBan.getColumnModel().getColumn(2).setMaxWidth(100);
            tbBan.getColumnModel().getColumn(3).setPreferredWidth(150);
            tbBan.getColumnModel().getColumn(3).setMaxWidth(150);
            tbBan.getColumnModel().getColumn(4).setPreferredWidth(200);
            tbBan.getColumnModel().getColumn(4).setMaxWidth(200);
        }

        pnSelectAll.setBackground(new java.awt.Color(35, 35, 35));

        chbSelectAll.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        chbSelectAll.setForeground(new java.awt.Color(255, 255, 255));
        chbSelectAll.setText("Select All");
        chbSelectAll.setPreferredSize(new java.awt.Dimension(85, 21));
        chbSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbSelectAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnSelectAllLayout = new javax.swing.GroupLayout(pnSelectAll);
        pnSelectAll.setLayout(pnSelectAllLayout);
        pnSelectAllLayout.setHorizontalGroup(
            pnSelectAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSelectAllLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chbSelectAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnSelectAllLayout.setVerticalGroup(
            pnSelectAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnSelectAllLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chbSelectAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        txtTimKiem.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtTimKiem.setPreferredSize(new java.awt.Dimension(64, 30));
        txtTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTimKiemMouseEntered(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setPreferredSize(new java.awt.Dimension(72, 30));

        btnSua.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setPreferredSize(new java.awt.Dimension(72, 30));

        btnXoa.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.setPreferredSize(new java.awt.Dimension(72, 30));

        javax.swing.GroupLayout pnContainerLayout = new javax.swing.GroupLayout(pnContainer);
        pnContainer.setLayout(pnContainerLayout);
        pnContainerLayout.setHorizontalGroup(
            pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContainerLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 985, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnContainerLayout.createSequentialGroup()
                        .addComponent(pnSelectAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        pnContainerLayout.setVerticalGroup(
            pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnContainerLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnSelectAll, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void chbSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbSelectAllActionPerformed
        render(!isSelectAll);
        isSelectAll = !isSelectAll;
    }//GEN-LAST:event_chbSelectAllActionPerformed

    public void textSorting() {
        txtTimKiem.putClientProperty(FlatClientProperties.TEXT_FIELD_SHOW_CLEAR_BUTTON, true);
        TableRowSorter tableRowSorter = new TableRowSorter(tbBan.getModel());
        String find = txtTimKiem.getText().toUpperCase().trim();
        if (!find.isEmpty()) {
//          Indices 2 => Sort theo cột 2 (Name)
            tableRowSorter.setRowFilter(RowFilter.regexFilter(find, 2));
            
        }
        
        tbBan.setRowSorter(tableRowSorter);
    }
    
    
    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        textSorting();
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void txtTimKiemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseEntered
        textSorting();
    }//GEN-LAST:event_txtTimKiemMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JCheckBox chbSelectAll;
    private javax.swing.JScrollPane jScrollPane2;
    private GUI.Comp.Swing.PanelBackground pnContainer;
    private GUI.Comp.Swing.PanelBackground pnSelectAll;
    private javax.swing.JTable tbBan;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
