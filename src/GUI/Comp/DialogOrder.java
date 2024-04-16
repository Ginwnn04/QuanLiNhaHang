package GUI.Comp;

import BUS.MenuItemBUS;
import BUS.OrderBUS;
import BUS.TableBUS;
import DAO.InvoicesDAO;
import DAO.TableDAO;
import DTO.DetailOrderDTO;
import DTO.InvoicesDTO;
import DTO.MenuItemDTO;
import DTO.OrderDTO;
import DTO.TableDTO;
import Helper.MyListener;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class DialogOrder extends javax.swing.JDialog implements PropertyChangeListener {
    private long totalPrice = 0;
    // bao nhiêu bàn được chọn để gọi món
    private int totalSelected = 0;
    // Trạng thái của bàn,bàn đầu tiên đc chọn là bàn trống thì chỉ đuọc selected các bàn khác là trống => ngược lại
    private boolean isValidSelected = true;
    // Danh sách hiển thị
    private ArrayList<MenuItemDTO> listMenuItem = new ArrayList<>();
    private ArrayList<DetailOrderDTO> listDetailOrder = new ArrayList<>();
    private ArrayList<TableDTO> listTable = new ArrayList<>();
    
    // danh sách những bàn đã chọn
    private ArrayList<TableDTO> listTableSelected = new ArrayList<>();
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("AddItem")) {
            int index = (int) evt.getNewValue();
            test(index);
        }
        if (evt.getPropertyName().equals("Quantity0")) {
            String nameProduct = (String) evt.getNewValue();
            check(nameProduct);
            lbShowTien.setText(totalPrice + " đ");
        }
        if (evt.getPropertyName().equals("Order")) {            
            totalPrice += (Long)evt.getNewValue();
            lbShowTien.setText(totalPrice + " đ");
        }
        if (evt.getPropertyName().equals("SelectedTable")) {
            TableDTO table = listTable.get(getTable((String)evt.getOldValue()));
            PanelTableBooking pnTable = table.getPnTableBooking();
            if (listTableSelected.size() == 0) {
                totalSelected += 1;
                pnTable.setSelected(true);
                listTableSelected.add(table);
            } 
            else {
                TableDTO tableTailList = listTableSelected.get(0);
                PanelTableBooking pnTableHead = tableTailList.getPnTableBooking();
                if (pnTableHead.isIsEmpty() == pnTable.isIsEmpty()) {
                    if (findTableselected(table.getName())) {
                        totalSelected -= 1;
                        pnTable.setSelected(false);
                        listTableSelected.remove(table);
                    }
                    else {
                        totalSelected += 1;
                        pnTable.setSelected(true);
                        listTableSelected.add(table);
                    }
                }
                else {
                    int choice = JOptionPane.showOptionDialog(rootPane, "Bạn có chắc chắn không ? Có thể sẽ mất hết những bàn đang chọn", "Xác nhận", JOptionPane.OK_CANCEL_OPTION, HEIGHT, null, null, null);
                    if (choice == 0) {
                        for(TableDTO x : listTable) {
                            x.getPnTableBooking().setSelected(false);
                        }
                        listTableSelected.removeAll(listTableSelected);
                        totalSelected += 1;
                        pnTable.setSelected(true);
                        listTableSelected.add(table);
                    }
                }
            }

            lbTotalSelected.setText(listTableSelected.size() + "");
        }
        
    }
    
    public boolean findTableselected(String nameTable) {
        for (TableDTO x : listTableSelected) {
            if (x.getName().equals(nameTable)) {
                return true;
            }
        }
        return false;
    }

   
    public DialogOrder(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        addMenuItem();
        addTable();
        MyListener.getInstance().addPropertyChangeListener(this);
        
        

    }
    public void addTable() {
        listTable = new TableBUS().getAllData();
        int height = 100 * listTable.size();
        int width = pnContainerTable.getWidth();
        pnContainerTable.setPreferredSize(new Dimension(width, height));
        for (int i = 0; i < listTable.size(); i++) {
            TableDTO item = listTable.get(i);
            pnContainerTable.add(item.createTableBooking());
        }
    }
    public void addMenuItem() {
        listMenuItem = new MenuItemBUS().getAllData();
        int height = 125 * listMenuItem.size();
        int width = pnOrder.getWidth();
        pnOrder.setPreferredSize(new Dimension(width, height));
        for (int i = 0; i < listMenuItem.size(); i++) {
            MenuItemDTO item = listMenuItem.get(i);
            pnOrder.add(item.createCart(i));
        }
    }

    public void updatePrice() {
        long total = 0;
        for (int i = 0; i < listDetailOrder.size(); i++) {
            DetailOrderDTO detailOrderDTO = listDetailOrder.get(i);
            detailOrderDTO.rerender();
            total += detailOrderDTO.getTotal();
        }
        lbShowTien.setText(total + " đ");
    }

    //===================================================================//
    // Nếu panel món ăn đã tồn tại ở checkout thì không thêm vào 
    // Ngược lại thì thêm vào
    // chức năng khác => render lại panel
    public void addCheckoutItem() {
        pnCheckout.removeAll();
        int height = 90 * listDetailOrder.size();
        int width = pnCheckout.getWidth();
        pnCheckout.setPreferredSize(new Dimension(width, height));
        for (int i = 0; i < listDetailOrder.size(); i++) {
            DetailOrderDTO detailOrderDTO = listDetailOrder.get(i);
            if (detailOrderDTO.getQuantity() != 0) {
                pnCheckout.add(detailOrderDTO.createCartOrder());
                System.out.println(detailOrderDTO.getItemID() + " zzzz");
            }
        }
        pnCheckout.revalidate();
        pnCheckout.repaint();
    }

    public void check(String name) {
        for (int i = listDetailOrder.size() - 1; i >= 0; i--) {
            DetailOrderDTO detailOrderDTO = listDetailOrder.get(i);
            detailOrderDTO.rerender();
            if (detailOrderDTO.getName().equals(name)) {
                totalPrice -= detailOrderDTO.getPrice();
                listDetailOrder.remove(i);
            }
        }
        addCheckoutItem();
    }

    public void test(int index) {
        boolean isExists = false;
        MenuItemDTO item = listMenuItem.get(index);

        for (DetailOrderDTO x : listDetailOrder) {
            x.rerender();
            if (x.getName().equals(item.getName())) {
                x.setQuantity(x.getQuantity() + 1);
                totalPrice += x.getPrice();
                lbShowTien.setText(totalPrice + " đ");
                isExists = true;
                
            }
        }

        if (!isExists) {
            DetailOrderDTO detailOrderDTO = new DetailOrderDTO(item.getPrice(), item.getProfit(), item.getId(), 1, item.getName(), false);
            listDetailOrder.add(detailOrderDTO);
            totalPrice += detailOrderDTO.getPrice();
            lbShowTien.setText(totalPrice + " đ");
        }
        addCheckoutItem();
    }
 
    public int getTable(String nameTable) {
        int i = 0;
        for(TableDTO x : listTable) {
            if (x.getName().equals(nameTable)) {
                return i;
            }
            i++;
        }
        return -1;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMapData = new javax.swing.JTextField();
        txtNote = new javax.swing.JTextField();
        lbCategory = new javax.swing.JLabel();
        cbxCategory = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnOrder = new GUI.Comp.Swing.PanelBackground();
        lbSort = new javax.swing.JLabel();
        cbxSort = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelBackground1 = new GUI.Comp.Swing.PanelBackground();
        jScrollPane3 = new javax.swing.JScrollPane();
        pnCheckout = new GUI.Comp.Swing.PanelBackground();
        btnOrder = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lbShowTien = new javax.swing.JLabel();
        lbTitleTongTien = new javax.swing.JLabel();
        panelBackground2 = new GUI.Comp.Swing.PanelBackground();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnContainerTable = new GUI.Comp.Swing.PanelBackground();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        lbTotalSelected = new javax.swing.JLabel();
        lbNote = new javax.swing.JLabel();

        txtMapData.setText("0");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(30, 30, 30));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        lbCategory.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbCategory.setForeground(new java.awt.Color(102, 102, 102));
        lbCategory.setText("Category");

        cbxCategory.setBackground(new java.awt.Color(242, 242, 242));
        cbxCategory.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        cbxCategory.setForeground(new java.awt.Color(79, 79, 79));
        cbxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bò", "Gà", "Hải sản", "Cá đồng", "Mì" }));
        cbxCategory.setBorder(null);

        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(400, 700));

        pnOrder.setBackground(new java.awt.Color(35, 35, 35));
        pnOrder.setPreferredSize(new java.awt.Dimension(400, 580));
        pnOrder.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));
        jScrollPane2.setViewportView(pnOrder);

        lbSort.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbSort.setForeground(new java.awt.Color(102, 102, 102));
        lbSort.setText("Sort by");

        cbxSort.setBackground(new java.awt.Color(242, 242, 242));
        cbxSort.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        cbxSort.setForeground(new java.awt.Color(79, 79, 79));
        cbxSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Best seller", "Món Á", "Món Âu", "..." }));
        cbxSort.setBorder(null);

        jTabbedPane1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N

        panelBackground1.setBackground(new java.awt.Color(35, 35, 35));

        jScrollPane3.setBackground(new java.awt.Color(255, 153, 153));
        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnCheckout.setBackground(new java.awt.Color(35, 35, 35));
        pnCheckout.setPreferredSize(new java.awt.Dimension(345, 420));
        pnCheckout.setRound(0);
        java.awt.FlowLayout flowLayout2 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10);
        flowLayout2.setAlignOnBaseline(true);
        pnCheckout.setLayout(flowLayout2);
        jScrollPane3.setViewportView(pnCheckout);

        btnOrder.setBackground(new java.awt.Color(242, 242, 242));
        btnOrder.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnOrder.setForeground(new java.awt.Color(102, 102, 102));
        btnOrder.setText("ĐẶT MÓN");
        btnOrder.setBorderPainted(false);
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });

        lbShowTien.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lbShowTien.setForeground(new java.awt.Color(255, 255, 255));
        lbShowTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbShowTien.setText("0 đ");

        lbTitleTongTien.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lbTitleTongTien.setForeground(new java.awt.Color(255, 255, 255));
        lbTitleTongTien.setText("Tổng tiền");

        javax.swing.GroupLayout panelBackground1Layout = new javax.swing.GroupLayout(panelBackground1);
        panelBackground1.setLayout(panelBackground1Layout);
        panelBackground1Layout.setHorizontalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackground1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBackground1Layout.createSequentialGroup()
                        .addComponent(jSeparator1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackground1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackground1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbTitleTongTien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbShowTien, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        panelBackground1Layout.setVerticalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbShowTien)
                    .addComponent(lbTitleTongTien))
                .addGap(18, 18, 18)
                .addComponent(btnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Giỏ hàng", panelBackground1);

        panelBackground2.setBackground(new java.awt.Color(35, 35, 35));

        jScrollPane1.setBackground(new java.awt.Color(35, 35, 35));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMinimumSize(new java.awt.Dimension(370, 585));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(370, 585));

        pnContainerTable.setBackground(new java.awt.Color(35, 35, 35));
        pnContainerTable.setMinimumSize(new java.awt.Dimension(370, 95));
        pnContainerTable.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 15));
        jScrollPane1.setViewportView(pnContainerTable);

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Đã chọn");

        lbTotalSelected.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbTotalSelected.setForeground(new java.awt.Color(255, 255, 255));
        lbTotalSelected.setText("0");

        lbNote.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        lbNote.setForeground(new java.awt.Color(255, 255, 255));
        lbNote.setText("Thêm ghi chú");
        lbNote.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 102, 255)));
        lbNote.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbNote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNoteMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelBackground2Layout = new javax.swing.GroupLayout(panelBackground2);
        panelBackground2.setLayout(panelBackground2Layout);
        panelBackground2Layout.setHorizontalGroup(
            panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBackground2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lbTotalSelected)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbNote)
                        .addGap(32, 32, 32)))
                .addContainerGap())
        );
        panelBackground2Layout.setVerticalGroup(
            panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelBackground2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbTotalSelected)
                    .addComponent(lbNote))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bàn", panelBackground2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbSort)
                        .addGap(10, 10, 10)
                        .addComponent(cbxSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(lbCategory)
                        .addGap(10, 10, 10)
                        .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbSort)
                                .addComponent(cbxSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbCategory)
                                .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
//        pnCheckout.repaint();
    }//GEN-LAST:event_formMouseEntered

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        
        boolean isSingle = listTableSelected.size() == 1 ? true : false;
        // Lay 1 ban dai dien de fill order vao
        OrderDTO order = new OrderDTO(isSingle, 638471313653138161L, listTableSelected.get(0).getId(), txtNote.getText(),false, date, date);
        txtNote.setText("");
        String customerCode = order.getCustomerCode();
             
        TableDAO tableDAO = new TableDAO();
        for (TableDTO x : listTableSelected) {
            x.setCustomerCode(customerCode);
            x.setStatus("DANGSUDUNG");
            x.setUpdateTime(date);
            tableDAO.updateData(x);
        }

        for (DetailOrderDTO x : listDetailOrder) {
            order.insertDetailOrder(x); 
        }
        
        OrderBUS orderBUS = new OrderBUS();
        orderBUS.insertOrder(order);
        
        JOptionPane.showMessageDialog(rootPane, "Gọi món thành công !!");
        // Sau khi goi mon xong thi close dialog order
        dispose();
    }//GEN-LAST:event_btnOrderActionPerformed

    private void lbNoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNoteMouseClicked
        txtNote.setText(JOptionPane.showInputDialog(rootPane, "Nhập ghi chú"));
        
    }//GEN-LAST:event_lbNoteMouseClicked

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
            java.util.logging.Logger.getLogger(DialogOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogOrder dialog = new DialogOrder(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnOrder;
    private javax.swing.JComboBox<String> cbxCategory;
    private javax.swing.JComboBox<String> cbxSort;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbCategory;
    private javax.swing.JLabel lbNote;
    private javax.swing.JLabel lbShowTien;
    private javax.swing.JLabel lbSort;
    private javax.swing.JLabel lbTitleTongTien;
    private javax.swing.JLabel lbTotalSelected;
    private GUI.Comp.Swing.PanelBackground panelBackground1;
    private GUI.Comp.Swing.PanelBackground panelBackground2;
    private GUI.Comp.Swing.PanelBackground pnCheckout;
    private GUI.Comp.Swing.PanelBackground pnContainerTable;
    private GUI.Comp.Swing.PanelBackground pnOrder;
    private javax.swing.JTextField txtMapData;
    private javax.swing.JTextField txtNote;
    // End of variables declaration//GEN-END:variables
}
