/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Main;

import GUI.Comp.DialogOrder;

import GUI.Comp.PanelDashbroad;
import Helper.MyListener;

import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;

import javax.swing.UIManager;

/**
 *
 * @author quang
 */
public class Main extends javax.swing.JFrame implements PropertyChangeListener {

    private PanelDashbroad a = new PanelDashbroad();

    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        setBackground(new Color(0, 0, 0, 0));
//        System.out.println(body.getSize());
        header.actionHeader(this);
        navBar.setInformation("Nguyễn Nhật Quang", "Nhân viên");

        MyListener.getInstance().addPropertyChangeListener(this);
        test(this);

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("ItemMenu")) {
            System.out.println(evt.getOldValue() + " " + evt.getNewValue());
            int index = (int) evt.getNewValue();
            
            switch (index) {
                case 0:
                    
                    break;
                case 1:
                    showForm(a);
                    break;
                case 2:
                    showForm(new QuanLiBan());
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
    }

    public void test(Frame frame) {
        a.btnDatBan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogOrder a = new DialogOrder(frame, true);
                a.setVisible(true);
            }
        });
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

        panelBackground = new GUI.Comp.Swing.PanelBackground();
        header = new GUI.Comp.Header();
        navBar = new GUI.Main.NavBar();
        body = new GUI.Comp.Swing.PanelBackground();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        panelBackground.setBackground(new java.awt.Color(35, 35, 35));

        body.setBackground(new java.awt.Color(30, 30, 30));
        body.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout panelBackgroundLayout = new javax.swing.GroupLayout(panelBackground);
        panelBackground.setLayout(panelBackgroundLayout);
        panelBackgroundLayout.setHorizontalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLayout.createSequentialGroup()
                .addComponent(navBar, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, 1077, Short.MAX_VALUE)
                    .addGroup(panelBackgroundLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelBackgroundLayout.setVerticalGroup(
            panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackgroundLayout.createSequentialGroup()
                .addGroup(panelBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelBackgroundLayout.createSequentialGroup()
                        .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(navBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    private GUI.Comp.Header header;
    private GUI.Main.NavBar navBar;
    private GUI.Comp.Swing.PanelBackground panelBackground;
    // End of variables declaration//GEN-END:variables

}
