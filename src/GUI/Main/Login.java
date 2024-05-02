/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI.Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Helper.ConnectDB;

/**
 *
 * @author vuled
 */
public class Login extends javax.swing.JFrame {
	private ConnectDB connectDB;
    /**
     * Creates new form LogIn
     */
    public Login() {
        initComponents();
        LoginLayout();
        connectDB = ConnectDB.getInstance(); 
        connectDB.openConnect();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    private void LoginLayout() {
        setSize(900, 500);
        setLayout(new BorderLayout());
        JPanel background = new JPanel(new GridLayout(1, 2));
        add(background);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
//        getContentPane().setLayout(new GridLayout(1, 2));

        JPanel panel_left = new JPanel();
        JPanel panel_right = new JPanel(new BorderLayout());
        
        background.add(panel_left);
        background.add(panel_right);
        
        panel_right.setBackground(new Color(35,35,35));
        
        ImageIcon image = new ImageIcon(getClass().getResource("/GUI/Comp/Icon/log.png"));
        JLabel lbImage = new JLabel(image) {
            public void paintComponent(Graphics g){
                Dimension size = getSize();
                g.drawImage(image.getImage(), 0, 0, size.width, size.height, null);
            }
        };
        panel_right.add(lbImage);
        
        panel_left.setBackground(new Color(35,35,35));
        
        panel_left.setLayout(new BorderLayout());
        
        JPanel panel_north = new JPanel();
        panel_north.setPreferredSize(new Dimension(400, 50));
        panel_north.setBackground(new Color(35,35,35));
        
        JPanel panel_center = new JPanel();
        
        JPanel panel_south = new JPanel();
        panel_south.setBackground(new Color(35,35,35));
        panel_south.setPreferredSize(new Dimension(400, 50));
        
        JPanel panel_east = new JPanel();
        panel_east.setBackground(new Color(35,35,35));
        panel_east.setPreferredSize(new Dimension(25, 400));
        
        JPanel panel_west = new JPanel();
        panel_west.setBackground(new Color(35,35,35));
        panel_west.setPreferredSize(new Dimension(25, 400));
        
        panel_left.add(panel_north, BorderLayout.NORTH);
        panel_left.add(panel_center, BorderLayout.CENTER);
        panel_left.add(panel_south, BorderLayout.SOUTH);
        panel_left.add(panel_east, BorderLayout.EAST);
        panel_left.add(panel_west, BorderLayout.WEST);
        
        JPanel logSection_panel_top = new JPanel();
        logSection_panel_top.setPreferredSize(new Dimension(350,100));
        JPanel logSection_panel_mid = new JPanel();
        logSection_panel_mid.setBackground(new Color(35,35,35));
        JPanel logSection_panel_bot = new JPanel();
        logSection_panel_bot.setPreferredSize(new Dimension(200,170));
        logSection_panel_bot.setBackground(new Color(35,35,35));
        
        panel_center.setLayout(new BorderLayout());
        panel_center.add(logSection_panel_bot, BorderLayout.SOUTH);
        panel_center.add(logSection_panel_mid, BorderLayout.CENTER);
        panel_center.add(logSection_panel_top, BorderLayout.NORTH);
        
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameLabel.setForeground(Color.WHITE);
        passwordLabel.setForeground(Color.WHITE);
        JTextField usernameField = new JTextField("Username", 20); // 20 là độ rộng ước lượng của username field
        usernameField.setBackground(new Color(35,35,35));
        JTextField passwordField = new JTextField("Password", 20); // 20 là độ rộng ước lượng của password field
        passwordField.setBackground(new Color(35,35,35));
        usernameField.setForeground(Color.WHITE);
        passwordField.setForeground(Color.WHITE);

        
        usernameField.setPreferredSize(new Dimension(300, 35));
        passwordField.setPreferredSize(new Dimension(300, 35));

                logSection_panel_mid.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Đặt khoảng cách giữa các thành phần


        gbc.gridx = 0;
        gbc.gridy = 0;
        logSection_panel_mid.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        logSection_panel_mid.add(usernameField, gbc);


        gbc.gridx = 0;
        gbc.gridy = 1;
        logSection_panel_mid.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        logSection_panel_mid.add(passwordField, gbc);
        
        //Login Btn
        JButton loginBtn = new JButton("ĐĂNG NHẬP");
        loginBtn.setPreferredSize(new Dimension(280, 35));
        loginBtn.setBackground(new Color(50, 168, 82));
        loginBtn.setForeground(Color.white);
        logSection_panel_bot.add(loginBtn);
        
        logSection_panel_top.setLayout(new BorderLayout());
        
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginButtonActionPerformed(usernameField, passwordField);
            }
        });

        // Tạo một JLabel cho label "Đăng nhập"
        JLabel login_lbl = new JLabel("Đăng nhập", SwingConstants.CENTER);
        login_lbl.setFont(new Font("Roboto", Font.BOLD, 40));
        login_lbl.setForeground(new Color(50, 168, 82));

        logSection_panel_top.add(login_lbl, BorderLayout.SOUTH);
        logSection_panel_top.setBackground(new Color(35,35,35));
    }
    
    private void loginButtonActionPerformed(JTextField usernameField, JTextField passwordField) {
        String username = usernameField.getText(); 
        String password = passwordField.getText(); 
        

        String sql = "SELECT * FROM tb_users WHERE username = ? AND password = ?";
        
        try {
            PreparedStatement statement = connectDB.getConnection().prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            
            ResultSet resultSet = statement.executeQuery();
            

            if (resultSet.next()) {
                Main main = new Main();
                main.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc mật khẩu không chính xác!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Lỗi khi đăng nhập: " + ex.getMessage());
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    private JPanel JPanel(GridLayout gridLayout) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
