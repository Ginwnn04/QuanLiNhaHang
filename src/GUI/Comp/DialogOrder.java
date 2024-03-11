package GUI.Comp;

import BUS.MenuItemBUS;
import DTO.CartOrderItem;
import DTO.DetailOrderDTO;
import DTO.MenuItemDTO;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import GUI.Comp.PanelConfirmOrder;
import GUI.Main.List;

public class DialogOrder extends javax.swing.JDialog {

    private ArrayList<MenuItemDTO> listMenuItem = new ArrayList<>();
    private ArrayList<DetailOrderDTO> listDetailOrder = new ArrayList<>();

    public DialogOrder(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        listMenuItem = new MenuItemBUS().getAllData();
        addMenuItem();

    }

    public void addMenuItem(int index, String nameProduct, double price, String status, String image) {
        PanelProductOrder pnProductOrder = new PanelProductOrder();
        pnProductOrder.insertData(index, nameProduct, price, status, image);
        pnProductOrder.btnSelection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                test(index);
            }
            
        });
        pnOrder.add(pnProductOrder);
        
    }

    public void addMenuItem() {
        int height = 125 * listMenuItem.size();
        int width = pnOrder.getWidth();
        pnOrder.setPreferredSize(new Dimension(width, height));
        for (int i = 0; i < listMenuItem.size(); i++) {
            MenuItemDTO item = listMenuItem.get(i);
            addMenuItem(i, item.getName(), item.getPrice(), item.getStatus(), item.getImage());
//            System.out.println(listMenuItem.get(i).getName() + " " + listMenuItem.get(i).getPrice()+ " " + listMenuItem.get(i).getStatus());
        }

//        jScrollPane2.setSize(width, 300);
    }

    // Nếu panel món ăn đã tồn tại ở checkout thì không thêm vào 
    // Ngược lại thì thêm vào
    public void addCheckoutItem() {
        pnCheckout.removeAll();
//        check();
        
        int height = 90 * listDetailOrder.size();
        int width = pnCheckout.getWidth();
        pnCheckout.setPreferredSize(new Dimension(width, height));
        check();
        for (int i = 0; i < listDetailOrder.size(); i++) {
            DetailOrderDTO detailOrderDTO = listDetailOrder.get(i);
//            System.out.println(detailOrderDTO.getName() + " " + detailOrderDTO.getQuantity());
            pnCheckout.add(detailOrderDTO.createCartOrder());
        }
            
    }
    
    
    public void check() {
        ArrayList<DetailOrderDTO> tmp = new ArrayList<>();
        for (int i = 0; i < listDetailOrder.size(); i++) {
            DetailOrderDTO detailOrderDTO = listDetailOrder.get(i);
            detailOrderDTO.rerender();
            if (detailOrderDTO.getQuantity() != 0) {
                tmp.add(detailOrderDTO);
            }
        }
        listDetailOrder = tmp;
    }
    
    public void test(int index) {
        boolean isExists = false;
        MenuItemDTO item = listMenuItem.get(index);
        for (DetailOrderDTO x : listDetailOrder) {
            if (x.getName().equals(item.getName())) {
           
               x.setQuantity(x.getQuantity() + 1);
                System.out.println(x.getQuantity());
               isExists = true;
               System.out.print(x.getName() + " " + x.getQuantity() + " ");
                System.out.println(isExists + "");
               break;
            }
        }
        if (!isExists) {
            System.out.println("zzzz");
            DetailOrderDTO detailOrderDTO = new DetailOrderDTO(item.getName(), item.getPrice(), 1);
            listDetailOrder.add(detailOrderDTO);
        }
        addCheckoutItem();
        revalidate();
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMapData = new javax.swing.JTextField();
        lbSort = new javax.swing.JLabel();
        cbxCatelory = new javax.swing.JComboBox<>();
        panelBackground1 = new GUI.Comp.Swing.PanelBackground();
        jScrollPane3 = new javax.swing.JScrollPane();
        pnCheckout = new GUI.Comp.Swing.PanelBackground();
        btnOrder = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        pnOrder = new GUI.Comp.Swing.PanelBackground();

        txtMapData.setText("0");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });

        lbSort.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbSort.setForeground(new java.awt.Color(102, 102, 102));
        lbSort.setText("Sort by");

        cbxCatelory.setBackground(new java.awt.Color(242, 242, 242));
        cbxCatelory.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        cbxCatelory.setForeground(new java.awt.Color(79, 79, 79));
        cbxCatelory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bò", "Gà", "Hải sản", "Cá đồng", "Mì" }));
        cbxCatelory.setBorder(null);

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jScrollPane3MouseEntered(evt);
            }
        });

        pnCheckout.setPreferredSize(new java.awt.Dimension(345, 420));
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

        javax.swing.GroupLayout panelBackground1Layout = new javax.swing.GroupLayout(panelBackground1);
        panelBackground1.setLayout(panelBackground1Layout);
        panelBackground1Layout.setHorizontalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackground1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBackground1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        panelBackground1Layout.setVerticalGroup(
            panelBackground1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackground1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane2.setBorder(null);

        pnOrder.setBackground(new java.awt.Color(242, 242, 242));
        pnOrder.setPreferredSize(new java.awt.Dimension(400, 580));
        pnOrder.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));
        jScrollPane2.setViewportView(pnOrder);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(lbSort)
                        .addGap(10, 10, 10)
                        .addComponent(cbxCatelory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(panelBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbSort)
                            .addComponent(cbxCatelory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Cập nhật lại khi các checkout có số lượng là 0 (Xoá)
    private void jScrollPane3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane3MouseEntered
        pnCheckout.repaint();
    }//GEN-LAST:event_jScrollPane3MouseEntered

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
//        pnCheckout.repaint();
    }//GEN-LAST:event_formMouseEntered

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        for (int i = 0; i < listDetailOrder.size(); i++) {
            DetailOrderDTO detailOrderDTO = listDetailOrder.get(i);
            detailOrderDTO.rerender();
            System.out.println(detailOrderDTO.getName() + " " + detailOrderDTO.getQuantity());

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
    private javax.swing.JComboBox<String> cbxCatelory;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbSort;
    private GUI.Comp.Swing.PanelBackground panelBackground1;
    private GUI.Comp.Swing.PanelBackground pnCheckout;
    private GUI.Comp.Swing.PanelBackground pnOrder;
    private javax.swing.JTextField txtMapData;
    // End of variables declaration//GEN-END:variables
}
