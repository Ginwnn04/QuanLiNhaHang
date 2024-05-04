/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Main;

import BUS.RoleBUS;
import GUI.Comp.QuanLiNhapKho;
import GUI.Comp.QuanLi_Staff;
import GUI.Comp.QuanLiNguyenLieu;
//import GUI.Comp.QuanLiBan;
//import GUI.Comp.DialogOrder;

import GUI.Comp.Panel.QuanLiBan;
import GUI.Comp.Dialog.DialogOrder;

import GUI.Comp.Panel.PanelDashbroad;
import GUI.Comp.Panel.QuanLiCongThuc;
import GUI.Comp.Panel.QuanLiGiamGia;
import GUI.Comp.Panel.QuanLiDatMon;
import GUI.Comp.Panel.QuanLiTheLoai;
import Helper.MyListener;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import BUS.StaffBUS;
import DTO.StaffDTO;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

import javax.swing.UIManager;
import javax.swing.border.Border;

/**
 *
 * @author quang
 */
public class Main extends javax.swing.JFrame implements PropertyChangeListener {

    public Main() {
        initComponents();
        setLocationRelativeTo(null);

        // Qua bên zalo coi cái ảnh á
        String fullName = StaffDTO.staffLogging.getLast_name() + " " + StaffDTO.staffLogging.getFirst_name();
        String role = new RoleBUS().getRoleByID(StaffDTO.staffLogging.getRoleId()).getName();
        navBar.setInformation(fullName, role);
        MyListener.getInstance().addPropertyChangeListener(this);

        setTitle("PHẦN MỀM QUẢN LÍ NHÀ HÀNG");
        Helper.ConnectDB.getInstance().openConnect();
        showForm(new PanelDashbroad());
        
        FlatMacDarkLaf.registerCustomDefaultsSource("style");
        UIManager.put("TextField.font", style.MyFont.fontText);
        UIManager.put("Label.font", style.MyFont.fontText);
        UIManager.put("Button.font", style.MyFont.fontText);
        UIManager.put("Table.font", style.MyFont.fontText);
        UIManager.put("TableHeader.font", new Font("Roboto", Font.BOLD, 14));
        UIManager.put("TableHeader.background", new Color(35, 35, 35));
        UIManager.put("TableHeader.hoverBackground", new Color(35, 35, 35));

//        UIManager.put("Table.alternateRowColor", new Color(53, 53, 53));        
        UIManager.put("TableHeader.separatorColor", new Color(0, 0, 0, 0));
        UIManager.put("TableHeader.pressedBackground", new Color(0, 0, 0, 0));
        UIManager.put("TableHeader.height", 30);
        UIManager.put("RootPane.background", new Color(35, 35, 35));
        UIManager.put("TitlePane.font", new Font("Roboto", Font.BOLD, 16));
        UIManager.put("TitlePane.centerTitle", true);

        FlatMacDarkLaf.setup();
        
        setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("ItemMenu")) {
            System.out.println(evt.getOldValue() + " " + evt.getNewValue());
            int index = (int) evt.getNewValue();

            switch (index) {
                case 0:
                    showForm(new PanelDashbroad());
                    break;
                case 1:
                    showForm(new QuanLiBan());
                    break;
                case 2:
                    showForm(new QuanLiDatMon());
                    break;
                case 3:

                    break;
                case 4: {
                    try {
                        showForm(new QuanLiNguyenLieu());
                    } catch (Exception ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case 5: {
                    try {
                        showForm(new QuanLiNhapKho());
                    } catch (Exception ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

                case 6:
                    showForm(new QuanLiCongThuc());
                    break;

                case 7:

                    showForm(new QuanLiTheLoai());

                    break;
                case 8:
                    showForm(new QuanLiGiamGia());
                    break;
                case 9:
//                    showForm(new QuanLiTheLoai());
                    break;
                case 10:
//                  showForm(new QuanLiTheLoai());
                    break;
                case 11:
//                    showForm(new QuanLiTheLoai());
                    break;
                case 12:
                    showForm(new QuanLi_Staff());
                    break;
                    

            }
        }
       
    }

    public void showForm(JPanel com) {
        body.removeAll();
        body.add(com);
        body.revalidate();
        body.repaint();
    }

    public void initProperty() {

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body1 = new GUI.Comp.Swing.PanelBackground();
        panelBackground = new GUI.Comp.Swing.PanelBackground();
        navBar = new GUI.Comp.NavBar();
        body = new GUI.Comp.Swing.PanelBackground();

        body1.setBackground(new java.awt.Color(30, 30, 30));
        body1.setLayout(new java.awt.BorderLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 0));

        panelBackground.setBackground(new java.awt.Color(35, 35, 35));
        panelBackground.setLayout(new java.awt.BorderLayout());
        panelBackground.add(navBar, java.awt.BorderLayout.LINE_START);

        body.setBackground(new java.awt.Color(35, 35, 35));
        body.setLayout(new java.awt.BorderLayout());
        panelBackground.add(body, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 1445, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.Comp.Swing.PanelBackground body;
    private GUI.Comp.Swing.PanelBackground body1;
    private GUI.Comp.NavBar navBar;
    private GUI.Comp.Swing.PanelBackground panelBackground;
    // End of variables declaration//GEN-END:variables

}
