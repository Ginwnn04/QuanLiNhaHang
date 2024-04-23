/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Main;

import GUI.Comp.QuanLiBan;
import GUI.Comp.DialogOrder;

import GUI.Comp.PanelDashbroad;
import GUI.Comp.QuanLiDatMon;
import Helper.MyListener;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;

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
import javax.swing.JPanel;

import javax.swing.UIManager;
import javax.swing.border.Border;

/**
 *
 * @author quang
 */
public class Main extends javax.swing.JFrame implements PropertyChangeListener {

    private PanelDashbroad a = new PanelDashbroad();

    public Main() {
        initComponents();
        setLocationRelativeTo(null);
//        setBackground(new Color(0, 0, 0, 0));
//        System.out.println(body.getSize());
//        header.actionHeader(this);
        navBar.setInformation("Nguyễn Nhật Quang", "Nhân viên");
        MyListener.getInstance().addPropertyChangeListener(this);
        setTitle("PHẦN MỀM QUẢN LÍ NHÀ HÀNG");
        showForm(a);
        
        

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("ItemMenu")) {
            System.out.println(evt.getOldValue() + " " + evt.getNewValue());
            int index = (int) evt.getNewValue();
            
            switch (index) {
                case 0:
                    showForm(a);
                    break;
                case 1:
                    showForm(new QuanLiBan());
                    break;
                case 2:
                    showForm(new QuanLiDatMon());
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:
                    
                    break;
                
            }
        }
//        if (evt.getPropertyName().equals(ABORT))
    }

    public void showForm(JPanel com) {
        body.removeAll();
        body.add(com);
        body.revalidate();
        body.repaint();
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
    public static void main(String args[]) {
        Helper.ConnectDB.getInstance().openConnect();
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
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private GUI.Comp.Swing.PanelBackground body;
    private GUI.Comp.Swing.PanelBackground body1;
    private GUI.Comp.NavBar navBar;
    private GUI.Comp.Swing.PanelBackground panelBackground;
    // End of variables declaration//GEN-END:variables

}
