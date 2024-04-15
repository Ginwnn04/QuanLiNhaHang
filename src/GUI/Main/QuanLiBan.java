/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Main;

import BUS.TableBUS;

import DTO.TableDTO;
import com.formdev.flatlaf.FlatClientProperties;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.JCheckBox;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import javax.swing.RowFilter;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author pc
 */
public class QuanLiBan extends javax.swing.JPanel {
    private ArrayList<TableDTO> listTable;
    int cntTableSelected = 0;
    private DefaultTableModel model;
    private boolean isSelectAll = false;
    public QuanLiBan() {
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        tbBan.setRowHeight(35);
        
        listTable = new TableBUS().getAllData();
        // header table nam ben trai
        DefaultTableCellRenderer  renderer = (DefaultTableCellRenderer) tbBan.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.LEFT);
        txtTimKiem.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nhập bàn cần tìm");
        render(isSelectAll);
        
        tbBan.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                if (e.getColumn() == 0) { // Check if the event is from the first column
                    // Lay row cua table hien tai
                    int row = tbBan.getSelectedRow();
                    // Lay row cua table ban dau
                    int row1 = e.getFirstRow();
//                    System.out.println(row + " " + row1);
//                    System.out.println(tbBan.getValueAt(row, 2));
                    // Your event handling code here
                    listTable.get(row1).setIsSelected(!listTable.get(row1).isIsSelected());
                    cntTableSelected += !listTable.get(row1).isIsSelected() ? -1 : 1;
                    if (cntTableSelected == 1) {
                        btnSua.setEnabled(true);
                    }
                    else {
                        btnSua.setEnabled(false);
                        
                    }
                }
            }
        });

    }

    public void render(boolean isSelectAll) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        model = (DefaultTableModel)tbBan.getModel();
        model.setRowCount(0);
        for (TableDTO x : listTable) {
            x.setIsSelected(isSelectAll);
            model.addRow(new Object[] {isSelectAll, x.getId(), x.getName(), x.getStatus(), x.getCustomerCode(), x.getUpdateTime(), x.getCreateTime()});
        }
        model.fireTableDataChanged();
        tbBan.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnContainer = new GUI.Comp.Swing.PanelBackground();
        panelBackground1 = new GUI.Comp.Swing.PanelBackground();
        panelBackground6 = new GUI.Comp.Swing.PanelBackground();
        pnSelectAll = new GUI.Comp.Swing.PanelBackground();
        chbSelectAll = new javax.swing.JCheckBox();
        panelBackground9 = new GUI.Comp.Swing.PanelBackground();
        txtTimKiem = new javax.swing.JTextField();
        panelBackground7 = new GUI.Comp.Swing.PanelBackground();
        btnThem = new javax.swing.JButton();
        panelBackground8 = new GUI.Comp.Swing.PanelBackground();
        btnSua = new javax.swing.JButton();
        panelBackground11 = new GUI.Comp.Swing.PanelBackground();
        btnXoa = new javax.swing.JButton();
        panelBackground2 = new GUI.Comp.Swing.PanelBackground();
        panelBackground3 = new GUI.Comp.Swing.PanelBackground();
        panelBackground4 = new GUI.Comp.Swing.PanelBackground();
        panelBackground5 = new GUI.Comp.Swing.PanelBackground();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbBan = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1077, 730));

        pnContainer.setBackground(new java.awt.Color(30, 30, 30));
        pnContainer.setLayout(new java.awt.BorderLayout());

        panelBackground1.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground1.setPreferredSize(new java.awt.Dimension(1077, 75));
        panelBackground1.setLayout(new javax.swing.BoxLayout(panelBackground1, javax.swing.BoxLayout.X_AXIS));

        panelBackground6.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground6.setMaximumSize(new java.awt.Dimension(20, 32767));
        panelBackground6.setPreferredSize(new java.awt.Dimension(30, 75));

        javax.swing.GroupLayout panelBackground6Layout = new javax.swing.GroupLayout(panelBackground6);
        panelBackground6.setLayout(panelBackground6Layout);
        panelBackground6Layout.setHorizontalGroup(
            panelBackground6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        panelBackground6Layout.setVerticalGroup(
            panelBackground6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        panelBackground1.add(panelBackground6);

        pnSelectAll.setBackground(new java.awt.Color(35, 35, 35));
        pnSelectAll.setMaximumSize(new java.awt.Dimension(100, 30));

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
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(pnSelectAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnSelectAllLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(chbSelectAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        pnSelectAllLayout.setVerticalGroup(
            pnSelectAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
            .addGroup(pnSelectAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnSelectAllLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(chbSelectAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panelBackground1.add(pnSelectAll);

        panelBackground9.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground9.setMaximumSize(new java.awt.Dimension(25, 32767));
        panelBackground9.setMinimumSize(new java.awt.Dimension(25, 100));

        javax.swing.GroupLayout panelBackground9Layout = new javax.swing.GroupLayout(panelBackground9);
        panelBackground9.setLayout(panelBackground9Layout);
        panelBackground9Layout.setHorizontalGroup(
            panelBackground9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        panelBackground9Layout.setVerticalGroup(
            panelBackground9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelBackground1.add(panelBackground9);

        txtTimKiem.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        txtTimKiem.setMaximumSize(new java.awt.Dimension(200, 30));
        txtTimKiem.setPreferredSize(new java.awt.Dimension(30, 30));
        txtTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTimKiemMouseEntered(evt);
            }
        });
        txtTimKiem.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtTimKiemPropertyChange(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });
        panelBackground1.add(txtTimKiem);

        panelBackground7.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground7.setMaximumSize(new java.awt.Dimension(445, 32767));
        panelBackground7.setPreferredSize(new java.awt.Dimension(445, 75));

        javax.swing.GroupLayout panelBackground7Layout = new javax.swing.GroupLayout(panelBackground7);
        panelBackground7.setLayout(panelBackground7Layout);
        panelBackground7Layout.setHorizontalGroup(
            panelBackground7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );
        panelBackground7Layout.setVerticalGroup(
            panelBackground7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 75, Short.MAX_VALUE)
        );

        panelBackground1.add(panelBackground7);

        btnThem.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setMaximumSize(new java.awt.Dimension(72, 35));
        btnThem.setPreferredSize(new java.awt.Dimension(72, 35));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        panelBackground1.add(btnThem);

        panelBackground8.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground8.setMaximumSize(new java.awt.Dimension(25, 32767));
        panelBackground8.setMinimumSize(new java.awt.Dimension(25, 100));
        panelBackground8.setPreferredSize(new java.awt.Dimension(25, 100));

        javax.swing.GroupLayout panelBackground8Layout = new javax.swing.GroupLayout(panelBackground8);
        panelBackground8.setLayout(panelBackground8Layout);
        panelBackground8Layout.setHorizontalGroup(
            panelBackground8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        panelBackground8Layout.setVerticalGroup(
            panelBackground8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        panelBackground1.add(panelBackground8);

        btnSua.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setEnabled(false);
        btnSua.setMaximumSize(new java.awt.Dimension(72, 35));
        btnSua.setPreferredSize(new java.awt.Dimension(72, 30));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        panelBackground1.add(btnSua);

        panelBackground11.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground11.setMaximumSize(new java.awt.Dimension(25, 32767));
        panelBackground11.setMinimumSize(new java.awt.Dimension(25, 100));

        javax.swing.GroupLayout panelBackground11Layout = new javax.swing.GroupLayout(panelBackground11);
        panelBackground11.setLayout(panelBackground11Layout);
        panelBackground11Layout.setHorizontalGroup(
            panelBackground11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );
        panelBackground11Layout.setVerticalGroup(
            panelBackground11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelBackground1.add(panelBackground11);

        btnXoa.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnXoa.setText("Xoá");
        btnXoa.setMaximumSize(new java.awt.Dimension(72, 35));
        btnXoa.setPreferredSize(new java.awt.Dimension(72, 30));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        panelBackground1.add(btnXoa);

        pnContainer.add(panelBackground1, java.awt.BorderLayout.PAGE_START);

        panelBackground2.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground2.setPreferredSize(new java.awt.Dimension(20, 690));

        javax.swing.GroupLayout panelBackground2Layout = new javax.swing.GroupLayout(panelBackground2);
        panelBackground2.setLayout(panelBackground2Layout);
        panelBackground2Layout.setHorizontalGroup(
            panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        panelBackground2Layout.setVerticalGroup(
            panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );

        pnContainer.add(panelBackground2, java.awt.BorderLayout.LINE_START);

        panelBackground3.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground3.setPreferredSize(new java.awt.Dimension(20, 690));

        javax.swing.GroupLayout panelBackground3Layout = new javax.swing.GroupLayout(panelBackground3);
        panelBackground3.setLayout(panelBackground3Layout);
        panelBackground3Layout.setHorizontalGroup(
            panelBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        panelBackground3Layout.setVerticalGroup(
            panelBackground3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );

        pnContainer.add(panelBackground3, java.awt.BorderLayout.LINE_END);

        panelBackground4.setBackground(new java.awt.Color(30, 30, 30));
        panelBackground4.setPreferredSize(new java.awt.Dimension(1077, 20));

        javax.swing.GroupLayout panelBackground4Layout = new javax.swing.GroupLayout(panelBackground4);
        panelBackground4.setLayout(panelBackground4Layout);
        panelBackground4Layout.setHorizontalGroup(
            panelBackground4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1077, Short.MAX_VALUE)
        );
        panelBackground4Layout.setVerticalGroup(
            panelBackground4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        pnContainer.add(panelBackground4, java.awt.BorderLayout.PAGE_END);

        panelBackground5.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground5.setLayout(new java.awt.BorderLayout());

        tbBan.setAutoCreateRowSorter(true);
        tbBan.setBackground(new java.awt.Color(35, 35, 35));
        tbBan.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tbBan.setForeground(new java.awt.Color(255, 255, 255));
        tbBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "aaaaaaaaaa", "ádasdasd", "aaaaaaaaaa", "aaaaaaaaaa", null, "aaaaaaaaaa"},
                {null, "aaaaaaaaaa", "ádasd", "aaaaaaaaaa", "aaaaaaaaaa", null, "aaaaaaaaaa"},
                {null, "aaaaaaaaaa", "ádasd", "aaaaaaaaaa", "aaaaaaaaaa", null, "aaaaaaaaaa"},
                {null, "aaaaaaaaaa", "ádasda", "aaaaaaaaaa", "aaaaaaaaaa", null, "aaaaaaaaaa"}
            },
            new String [] {
                "", "Mã bàn", "Tên bàn", "Trạng thái", "Mã khách hàng", "Ngày sửa", "Ngày tạo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
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
            tbBan.getColumnModel().getColumn(1).setPreferredWidth(180);
            tbBan.getColumnModel().getColumn(1).setMaxWidth(180);
            tbBan.getColumnModel().getColumn(2).setPreferredWidth(75);
            tbBan.getColumnModel().getColumn(2).setMaxWidth(75);
            tbBan.getColumnModel().getColumn(3).setPreferredWidth(120);
            tbBan.getColumnModel().getColumn(3).setMaxWidth(120);
            tbBan.getColumnModel().getColumn(4).setPreferredWidth(150);
            tbBan.getColumnModel().getColumn(4).setMaxWidth(150);
        }

        panelBackground5.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pnContainer.add(panelBackground5, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE)
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

    // Khi an vao button x de clear txtTimkiem
    private void txtTimKiemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemMouseEntered
        textSorting();
        
    }//GEN-LAST:event_txtTimKiemMouseEntered

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        DialogActionTable x = new DialogActionTable(null, true, false);
        x.setAction(false);
        listTable = new TableBUS().getAllData();
        render(false);
        
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        
        DialogActionTable x = new DialogActionTable(null, true, true);
        for (TableDTO table : listTable) {
            if (table.isIsSelected()) {
                x.setIDTable(table.getId());
                break;
            }
        }
        

    }//GEN-LAST:event_btnSuaActionPerformed

    private void txtTimKiemPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtTimKiemPropertyChange
        
    }//GEN-LAST:event_txtTimKiemPropertyChange

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int choice = JOptionPane.showConfirmDialog(pnContainer, "Bạn có chắc chắn xóa không ?", "Xác nhận", JOptionPane.YES_NO_OPTION);
        if (choice == 0) {
            String listIDDelete = "";
            for (TableDTO table : listTable) {
                if (table.isIsSelected()) {
                    listIDDelete += table.getId() + ", ";
                }
            }
            if (listIDDelete.isEmpty()) {
                System.out.println("Rỗng");
            }
            else {
                listIDDelete = listIDDelete.substring(0, listIDDelete.length() - 2);
                System.out.println(listIDDelete);
            }

            boolean check = new TableBUS().deleteTable(listIDDelete);
            if (check) {
                JOptionPane.showMessageDialog(pnContainer, "Xóa thành công");
                listTable = new TableBUS().getAllData();
                render(false);
            }
            else {
                JOptionPane.showMessageDialog(pnContainer, "Xóa thất bại");
            }   
        }
    }//GEN-LAST:event_btnXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JCheckBox chbSelectAll;
    private javax.swing.JScrollPane jScrollPane2;
    private GUI.Comp.Swing.PanelBackground panelBackground1;
    private GUI.Comp.Swing.PanelBackground panelBackground11;
    private GUI.Comp.Swing.PanelBackground panelBackground2;
    private GUI.Comp.Swing.PanelBackground panelBackground3;
    private GUI.Comp.Swing.PanelBackground panelBackground4;
    private GUI.Comp.Swing.PanelBackground panelBackground5;
    private GUI.Comp.Swing.PanelBackground panelBackground6;
    private GUI.Comp.Swing.PanelBackground panelBackground7;
    private GUI.Comp.Swing.PanelBackground panelBackground8;
    private GUI.Comp.Swing.PanelBackground panelBackground9;
    private GUI.Comp.Swing.PanelBackground pnContainer;
    private GUI.Comp.Swing.PanelBackground pnSelectAll;
    private javax.swing.JTable tbBan;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
