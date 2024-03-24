package GUI.Comp;

import BUS.MenuItemBUS;
import DTO.DetailOrderDTO;
import DTO.MenuItemDTO;
import Helper.MyListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class DialogOrder extends javax.swing.JDialog implements PropertyChangeListener {
    private double total = 0;
    private ArrayList<MenuItemDTO> listMenuItem = new ArrayList<>();
    private ArrayList<DetailOrderDTO> listDetailOrder = new ArrayList<>();

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("AddItem")) {
            int index = (int) evt.getNewValue();
            test(index);
        }
        if (evt.getPropertyName().equals("Quantity0")) {
            String nameProduct = (String) evt.getNewValue();
            check(nameProduct);
            lbShowTien.setText(total + " đ");
        }
        if (evt.getPropertyName().equals("Order")) {
//            System.out.println((Double)evt.getNewValue());
            
            total += (Double)evt.getNewValue();
            

        }
        lbShowTien.setText(total + " đ");
    }

    public void addMenuItemCart(int index, String nameProduct, double price, String status, String image) {
        PanelProductOrder pnProductOrder = new PanelProductOrder();
        pnProductOrder.insertData(index, nameProduct, price, status, image);

        pnOrder.add(pnProductOrder);
    }

    public DialogOrder(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        listMenuItem = new MenuItemBUS().getAllData();
        addMenuItem();
        MyListener.getInstance().addPropertyChangeListener(this);
        

    }

    public void addMenuItem() {
        int height = 125 * listMenuItem.size();
        int width = pnOrder.getWidth();
        pnOrder.setPreferredSize(new Dimension(width, height));
        for (int i = 0; i < listMenuItem.size(); i++) {
            MenuItemDTO item = listMenuItem.get(i);
            item.createCart(i);
            addMenuItemCart(i, item.getName(), item.getPrice(), item.getStatus(), item.getImage());
//            System.out.println(listMenuItem.get(i).getName() + " " + listMenuItem.get(i).getPrice()+ " " + listMenuItem.get(i).getStatus());
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
                total -= detailOrderDTO.getPrice();
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
                total += x.getPrice();
                lbShowTien.setText(total + " đ");
                isExists = true;
                
            }
        }

        if (!isExists) {
            DetailOrderDTO detailOrderDTO = new DetailOrderDTO(item.getName(), item.getPrice(), 1);
            listDetailOrder.add(detailOrderDTO);
            total += detailOrderDTO.getPrice();
            lbShowTien.setText(total + " đ");
        }
        addCheckoutItem();

    }

    public void showDescription(MenuItemDTO item) {
        ImageIcon icon = new ImageIcon();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMapData = new javax.swing.JTextField();
        lbCategory = new javax.swing.JLabel();
        cbxCategory = new javax.swing.JComboBox<>();
        panelBackground1 = new GUI.Comp.Swing.PanelBackground();
        jScrollPane3 = new javax.swing.JScrollPane();
        pnCheckout = new GUI.Comp.Swing.PanelBackground();
        btnOrder = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lbShowTien = new javax.swing.JLabel();
        lbTitleTongTien = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnOrder = new GUI.Comp.Swing.PanelBackground();
        lbSort = new javax.swing.JLabel();
        cbxSort = new javax.swing.JComboBox<>();

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

        panelBackground1.setBackground(new java.awt.Color(35, 35, 35));

        jScrollPane3.setBackground(new java.awt.Color(255, 153, 153));
        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jScrollPane3MouseEntered(evt);
            }
        });

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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbShowTien)
                    .addComponent(lbTitleTongTien))
                .addGap(18, 18, 18)
                .addComponent(btnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbSort)
                        .addGap(10, 10, 10)
                        .addComponent(cbxSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(108, 108, 108)
                        .addComponent(lbCategory)
                        .addGap(10, 10, 10)
                        .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addComponent(panelBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbSort)
                        .addComponent(cbxSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbCategory)
                        .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBackground1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Cập nhật lại khi các checkout có số lượng là 0 (Xoá)
    private void jScrollPane3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane3MouseEntered
//        pnCheckout.repaint();
    }//GEN-LAST:event_jScrollPane3MouseEntered

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
//        pnCheckout.repaint();
    }//GEN-LAST:event_formMouseEntered

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        System.out.println(listDetailOrder.size());
        for (int i = 0; i < listDetailOrder.size(); i++) {
            DetailOrderDTO detailOrderDTO = listDetailOrder.get(i);
            detailOrderDTO.rerender();
            System.out.println(detailOrderDTO.getName() + " " + detailOrderDTO.getQuantity() + " " + detailOrderDTO.getTotal());
        }

    }//GEN-LAST:event_btnOrderActionPerformed

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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbCategory;
    private javax.swing.JLabel lbShowTien;
    private javax.swing.JLabel lbSort;
    private javax.swing.JLabel lbTitleTongTien;
    private GUI.Comp.Swing.PanelBackground panelBackground1;
    private GUI.Comp.Swing.PanelBackground pnCheckout;
    private GUI.Comp.Swing.PanelBackground pnOrder;
    private javax.swing.JTextField txtMapData;
    // End of variables declaration//GEN-END:variables
}
