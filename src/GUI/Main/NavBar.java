/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Main;

import GUI.Comp.Swing.MenuButton;
import Helper.MyListener;
import KentHipos.Kensoft;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.interpolation.PropertySetter;

/**
 *
 * @author quang
 */
public class NavBar extends javax.swing.JPanel {
    private Animator animator;
    int indexCurrent = 0;
    int indexSelected = 0;
    Sliding sliding = new Sliding();
    int xPanel = 6;
    // Button có height là 50 mà font size 20 thì mỗi top và bottom mỗi cạnh nó padding 15    
    // Vị trí y của thanh panel trượt
    int yPanel = 184 + 15;
    List<JButton> listButton = new ArrayList<>();

    public NavBar() {
        initComponents();
        initMenu();
        setBackground(new Color(0,0,0,0));
        int op = (int) (255 * 0.8);
        jSeparator2.setForeground(new Color(204, 204, 204, op));
        btnDangXuat.setIconTextGap(10);
        
    }

    public void initMenu() {
//        panelBackground1.setBackground(new Color(255, 107, 39, 30));
        addMenuItem("Trang chủ", new ImageIcon(getClass().getResource("/GUI/Main/noclick.png")));
        addMenuItem("Đặt bàn", new ImageIcon(getClass().getResource("/GUI/Main/noclick.png")));
        addMenuItem("Món ăn", new ImageIcon(getClass().getResource("/GUI/Main/noclick.png")));
        addMenuItem("Nguyên liệu", new ImageIcon(getClass().getResource("/GUI/Main/noclick.png")));
        addMenuItem("Hóa đơn", new ImageIcon(getClass().getResource("/GUI/Main/noclick.png")));
        addMenuItem("Giảm giá", new ImageIcon(getClass().getResource("/GUI/Main/noclick.png")));
        addMenuItem("Nhân viên", new ImageIcon(getClass().getResource("/GUI/Main/noclick.png")));
        sliding.setBounds(xPanel, yPanel, 15, 20);
        pnContainer.add(sliding);

    }

    public void addMenuItem(String title, ImageIcon icon) {
        JButton btn = new JButton(title, icon);
        btn.setIconTextGap(10);
        btn.setPreferredSize(new Dimension(205, 50));
        if (listButton.size() == 0) {
            btn.setForeground(new Color(255, 107, 39));
        } 
        else {
            btn.setForeground(new Color(255, 255, 255));
        }
        btn.setBackground(new Color(35, 35, 35));
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setBorderPainted(false);
        btn.setFont(style.MyFont.fontMenuBar);
        pnMenuItem.add(btn);
        btn.setActionCommand(listButton.size() + "");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indexSelected = Integer.parseInt(e.getActionCommand());
                if (indexSelected != indexCurrent) {
                    MyListener.getInstance().firePropertyChange("ItemMenu", indexCurrent, indexSelected);
                    clearSelected();
                    setSelectedMenu(indexSelected); 
                }
                
            }
        });
        listButton.add(btn);
    }

    
    
    public void clearSelected() {
        for (JButton btn : listButton) {
            btn.setBackground(new Color(35, 35, 35));
            btn.setForeground(new Color(255, 255, 255));
        }
    }

    public void setSelectedMenu(int indexSelected) {
        if (indexCurrent != indexSelected) {
            int yNew = (indexSelected - indexCurrent) * 50 + (indexSelected - indexCurrent) * 2;
            animator = PropertySetter.createAnimator(300, sliding, "location", new Point(xPanel, yPanel), new Point(xPanel, yPanel + yNew));
            yPanel += yNew;
            animator.addTarget(new TimingTargetAdapter() {
                @Override
                public void timingEvent(float fraction) {
                    repaint();
                }
            });
            animator.setResolution(5);
            animator.start();
           
            indexCurrent = indexSelected;
            JButton btnSelected = listButton.get(indexSelected);
            btnSelected.setForeground(new Color(255, 107, 39));

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnContainer = new GUI.Comp.Swing.PanelBackground();
        imageAvatar2 = new GUI.Comp.Menu.ImageAvatar();
        lbRole = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        btnDangXuat = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        pnMenuItem = new GUI.Comp.Swing.PanelBackground();

        setBackground(new java.awt.Color(35, 35, 35));

        pnContainer.setBackground(new java.awt.Color(35, 35, 35));
        pnContainer.setPreferredSize(new java.awt.Dimension(230, 765));

        imageAvatar2.setImage(new javax.swing.ImageIcon(getClass().getResource("/GUI/Comp/Icon/cross-circle.png"))); // NOI18N

        lbRole.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lbRole.setForeground(new java.awt.Color(154, 154, 154));
        lbRole.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRole.setText("Admin");

        lbName.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbName.setForeground(new java.awt.Color(117, 117, 117));
        lbName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbName.setText("Dashboard UI");

        btnDangXuat.setBackground(new java.awt.Color(35, 35, 35));
        btnDangXuat.setFont(new java.awt.Font("Roboto", 1, 20)); // NOI18N
        btnDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        btnDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Main/noclick.png"))); // NOI18N
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.setBorderPainted(false);
        btnDangXuat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDangXuat.setMargin(new java.awt.Insets(2, 5, 2, 14));
        btnDangXuat.setName(""); // NOI18N
        btnDangXuat.setPreferredSize(new java.awt.Dimension(205, 50));
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(102, 255, 51));
        jSeparator2.setForeground(new java.awt.Color(102, 255, 102));

        pnMenuItem.setBackground(new java.awt.Color(35, 35, 35));
        pnMenuItem.setMaximumSize(new java.awt.Dimension(211, 32767));
        pnMenuItem.setPreferredSize(new java.awt.Dimension(200, 482));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 3, 2);
        flowLayout1.setAlignOnBaseline(true);
        pnMenuItem.setLayout(flowLayout1);

        javax.swing.GroupLayout pnContainerLayout = new javax.swing.GroupLayout(pnContainer);
        pnContainer.setLayout(pnContainerLayout);
        pnContainerLayout.setHorizontalGroup(
            pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContainerLayout.createSequentialGroup()
                .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnContainerLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnMenuItem, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnContainerLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lbRole, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(lbName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnContainerLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(imageAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pnContainerLayout.setVerticalGroup(
            pnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imageAvatar2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnMenuItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDangXuatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat;
    private GUI.Comp.Menu.ImageAvatar imageAvatar2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbRole;
    private GUI.Comp.Swing.PanelBackground pnContainer;
    private GUI.Comp.Swing.PanelBackground pnMenuItem;
    // End of variables declaration//GEN-END:variables
}
