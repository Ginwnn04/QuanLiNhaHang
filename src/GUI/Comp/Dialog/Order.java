/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Comp.Dialog;

import DAO.*;
import BUS.*;
import DTO.OrderDTO;
import DTO.TableDTO;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class Order extends javax.swing.JFrame {

    private ArrayList<OrderDTO> listOrder;
    private OrderBUS orderBUS = new OrderBUS();
    private TableBUS tableBUS = new TableBUS();
    private String listOrderIDSelected = "";
    private DefaultTableModel model;
    private int cntOrderSelected;
    private boolean isSelectAll = false;
    private long id;

    /**
     * Creates new form Order
     *
     */
    public Order() {

        initComponents();
        setLocationRelativeTo(null);
        tbDatMon.setRowHeight(25);
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tbDatMon.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalAlignment(JLabel.LEFT);
        render(isSelectAll);

    }

    public void insertInvoiceID(long id) {
        this.id = id;
    }

    public void render(boolean isSelectAll) {
        listOrder = orderBUS.getOrderByID(id);
        model = (DefaultTableModel) tbDatMon.getModel();
        model.setRowCount(0);
        for (OrderDTO x : listOrder) {
            x.setIsSelected(isSelectAll);
            TableDTO table = tableBUS.findTableByID(x.getTableID());
            model.addRow(new Object[]{x.getId(), table.getName(), x.getCustomerCode(), Helper.FormatNumber.getInstance().getFormat().format(x.getTotal()), Helper.FormatDate.getInstance().getFormat().format(x.getCreateTime())});
        }
        model.fireTableDataChanged();
        tbDatMon.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tbDatMon = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbDatMon.setAutoCreateRowSorter(true);
        tbDatMon.setBackground(new java.awt.Color(35, 35, 35));
        tbDatMon.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        tbDatMon.setForeground(new java.awt.Color(255, 255, 255));
        tbDatMon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"aaaaaaaaaa", "aaaaaaaaaa", "ádasdasd", null, "aaaaaaaaaa"},
                {"aaaaaaaaaa", "aaaaaaaaaa", "ádasd", null, "aaaaaaaaaa"},
                {"aaaaaaaaaa", "aaaaaaaaaa", "ádasd", null, "aaaaaaaaaa"},
                {"aaaaaaaaaa", "aaaaaaaaaa", "ádasda", null, "aaaaaaaaaa"}
            },
            new String [] {
                "Mã đặt món", "Tên bàn", "Mã khách hàng", "Tổng tiền", "Ngày tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDatMon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tbDatMon.getTableHeader().setResizingAllowed(false);
        tbDatMon.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbDatMon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1037, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1037, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Order order = new Order();
                order.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        order.dispose();
                    }
                });
                order.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbDatMon;
    // End of variables declaration//GEN-END:variables
}
