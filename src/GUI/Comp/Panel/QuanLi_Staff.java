/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI.Comp.Panel;

import GUI.Main.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author vuled
 */
public class QuanLi_Staff extends javax.swing.JPanel {

    
    /**
     * Creates new form QuanLi_Staff
     */
    public QuanLi_Staff() {
        initComponents();
        setLayout(new BorderLayout());
        
        JPanel panel_north = new JPanel();
        JPanel panel_center = new JPanel();
        JPanel panel_south = new JPanel();
        JPanel panel_west = new JPanel();
        JPanel panel_east = new JPanel();
        
        panel_north.setPreferredSize(new Dimension(25,25));
        panel_south.setPreferredSize(new Dimension(25,25));
        panel_west.setPreferredSize(new Dimension(25,25));
        panel_east.setPreferredSize(new Dimension(25,25));
        
        panel_west.setBackground(new Color(35,35,35));
        panel_east.setBackground(new Color(35,35,35));
        panel_north.setBackground(new Color(35,35,35));
        panel_south.setBackground(new Color(35,35,35));
        
        
        add(panel_center, BorderLayout.CENTER);
        add(panel_north, BorderLayout.NORTH);
        add(panel_south, BorderLayout.SOUTH);
        add(panel_east, BorderLayout.EAST);
        add(panel_west, BorderLayout.WEST);
        
        
        panel_center.setLayout(new BorderLayout());
        
        JPanel panel_top = new JPanel();
        JPanel panel_mid = new JPanel();
        JPanel panel_bot = new JPanel();
        
        panel_top.setPreferredSize(new Dimension(800, 50));
        panel_mid.setPreferredSize(new Dimension(800, 350));
        panel_bot.setPreferredSize(new Dimension(800, 200));
        
        panel_top.setBackground(new Color(35,35,35));
        panel_bot.setBackground(new Color(45,45,45));
        panel_center.add(panel_top, BorderLayout.NORTH);
        panel_center.add(panel_mid, BorderLayout.CENTER);
        panel_center.add(panel_bot, BorderLayout.SOUTH);
        
        //search panel
        JLabel searchLabel = new JLabel("Tìm kiếm:");
        searchLabel.setForeground(Color.white);
        JTextField searchField = new JTextField();
        searchField.setBackground(new Color(35,35,35));
        searchField.setForeground(Color.white);
        searchField.setPreferredSize(new Dimension(200, 25));

        // Tạo flow layout cho panel_top và thêm label và textfield vào
        panel_top.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel_top.add(searchLabel);
        panel_top.add(searchField);
        
        //Table
        String[] columns = {"StaffID", "Username", "Password", "Email", "SĐT", "RoleID(chứ vụ)", "Địa chỉ"};
        Object[][] data = {
                {"1", "user1", "pass1", "user1@example.com", "123456789", "1", "123 Street, City"},
                {"2", "user2", "pass2", "user2@example.com", "987654321", "2", "456 Avenue, Town"},
                {"3", "user3", "pass3", "user3@example.com", "111111111", "3", "789 Road, Village"}
        };

        // Create a table model
        DefaultTableModel model = new DefaultTableModel(data, columns);

        // Create a JTable with the model
        JTable table = new JTable(model);

        // Set table properties (similar to CSS)
        table.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 14));
        JTableHeader header = table.getTableHeader();
        header.setOpaque(true); // Ensure the header can display background color
        header.setBackground(Color.BLACK); // Set background color of the header to black
        header.setForeground(Color.WHITE); // Set foreground color of the header text to white
        table.setBackground(Color.BLACK); // Set background color of the table to black
        table.setForeground(Color.WHITE);
        table.setGridColor(Color.WHITE);
        table.setSelectionBackground(new Color(224, 86, 0));
        table.setSelectionForeground(Color.WHITE);
        table.setRowHeight(40);

        // Set column properties
        table.getColumnModel().getColumn(0).setPreferredWidth(100);
        table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(150);
        table.getColumnModel().getColumn(6).setPreferredWidth(250); // Width of the new column

        // Create a JScrollPane to hold the table
        JScrollPane scrollPane = new JScrollPane(table);

        // Create a JPanel to hold the table
        panel_mid.setLayout(new GridBagLayout());
        GridBagConstraints gbc1 = new GridBagConstraints();


        gbc1.gridx = 0;
        gbc1.gridy = 0;
        gbc1.weightx = 1.0;
        gbc1.weighty = 1.0;
        gbc1.fill = GridBagConstraints.BOTH;
        panel_mid.add(scrollPane, gbc1);
        
       
        
        //Update panel
        panel_bot.setLayout(new BorderLayout());
        
        JPanel staffInfo_panel_left = new JPanel();
        JPanel staffInfo_panel_center = new JPanel();
        JPanel staffInfo_panel_right = new JPanel();
        
        staffInfo_panel_center.setBackground(new Color(45,45,45));
        staffInfo_panel_left.setBackground(new Color(45,45,45));
        staffInfo_panel_right.setBackground(new Color(45,45,45));
        
        staffInfo_panel_center.setPreferredSize(new Dimension(350, 200));
        staffInfo_panel_left.setPreferredSize(new Dimension(350, 200));
        staffInfo_panel_right.setPreferredSize(new Dimension(150, 200));
        
        panel_bot.add(staffInfo_panel_center, BorderLayout.CENTER);
        panel_bot.add(staffInfo_panel_left, BorderLayout.WEST);
        panel_bot.add(staffInfo_panel_right, BorderLayout.EAST);
        
        
        //Btn panel
        JButton btnThem = new JButton("Thêm");
        btnThem.setBackground(new Color(146, 227, 118));
        JButton btnSua = new JButton("Sửa");
        btnSua.setBackground(new Color(112, 179, 230));
        JButton btnXoa = new JButton("Xóa");
        btnXoa.setBackground(new Color(235, 82, 82));
        
        btnThem.setForeground(Color.white);
        btnSua.setForeground(Color.white);
        btnXoa.setForeground(Color.white);

        Dimension buttonSize = new Dimension(100, 30);
        btnThem.setPreferredSize(buttonSize);
        btnSua.setPreferredSize(buttonSize);
        btnXoa.setPreferredSize(buttonSize);

        JPanel buttonPanel = new JPanel(new GridBagLayout());

        buttonPanel.setBackground(new Color(45,45,45));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        buttonPanel.add(btnThem, gbc);

        gbc.gridy = 1;
        buttonPanel.add(btnSua, gbc);
        
        gbc.gridy = 2;
        buttonPanel.add(btnXoa, gbc);

        staffInfo_panel_right.setBackground(new Color(45,45,45));
        staffInfo_panel_right.setLayout(new GridBagLayout());
        staffInfo_panel_right.add(buttonPanel, gbc);
        
        //Info left
        JLabel lblStaffID = new JLabel("StaffID:");
        lblStaffID.setForeground(Color.white);
        
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setForeground(Color.white);
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(Color.white);

        // Create textfields
        JTextField txtStaffID = new JTextField();
        JTextField txtUsername = new JTextField();
        JTextField txtPassword = new JTextField();

        // Set preferred size for textfields
        Dimension textFieldSize = new Dimension(200, 30);
        txtStaffID.setPreferredSize(textFieldSize);
        txtUsername.setPreferredSize(textFieldSize);
        txtPassword.setPreferredSize(textFieldSize);

        // Create GridBagConstraints for label and textfield alignment
        GridBagConstraints gbcLeft = new GridBagConstraints();
        gbcLeft.gridx = 0;
        gbcLeft.gridy = 0;
        gbcLeft.anchor = GridBagConstraints.WEST;
        gbcLeft.insets = new Insets(5, 5, 5, 5); // Add padding

        // Add labels and textfields to staffInfo_panel_left
        staffInfo_panel_left.setLayout(new GridBagLayout());
        staffInfo_panel_left.add(lblStaffID, gbcLeft);
        gbcLeft.gridx = 1; // Di chuyển sang cột tiếp theo
        staffInfo_panel_left.add(txtStaffID, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy++;
        staffInfo_panel_left.add(lblUsername, gbcLeft);
        gbcLeft.gridx = 1;
        staffInfo_panel_left.add(txtUsername, gbcLeft);

        gbcLeft.gridx = 0;
        gbcLeft.gridy++;
        staffInfo_panel_left.add(lblPassword, gbcLeft);
        gbcLeft.gridx = 1;
        staffInfo_panel_left.add(txtPassword, gbcLeft);
        
        //Info right
        GridBagConstraints gbcCenter = new GridBagConstraints();
        gbcCenter.gridx = 0;
        gbcCenter.gridy = 0;
        gbcCenter.anchor = GridBagConstraints.WEST;
        gbcCenter.insets = new Insets(5, 5, 5, 5); // Add padding

        // Add labels and textfields to staffInfo_panel_center
        staffInfo_panel_center.setLayout(new GridBagLayout());

        // Label và Textfield cho Email
        JLabel Email_lbl = new JLabel("Email:");
        Email_lbl.setForeground(Color.white);
        staffInfo_panel_center.add(Email_lbl, gbcCenter);
        gbcCenter.gridx = 1; // Di chuyển sang cột tiếp theo
        JTextField txtEmail = new JTextField(20); // Số lượng ký tự cho phép nhập vào
        staffInfo_panel_center.add(txtEmail, gbcCenter);

        // Label và Textfield cho SĐT
        gbcCenter.gridx = 0; // Quay lại cột đầu tiên
        gbcCenter.gridy++; // Di chuyển xuống dòng tiếp theo
        JLabel SDT_lbl = new JLabel("SDT:"); 
        SDT_lbl.setForeground(Color.white);
        staffInfo_panel_center.add(SDT_lbl, gbcCenter);
        gbcCenter.gridx = 1; // Di chuyển sang cột tiếp theo
        JTextField txtSDT = new JTextField(20); // Số lượng ký tự cho phép nhập vào
        staffInfo_panel_center.add(txtSDT, gbcCenter);

        // Label và Textfield cho RoleID
        gbcCenter.gridx = 0; // Quay lại cột đầu tiên
        gbcCenter.gridy++; // Di chuyển xuống dòng tiếp theo
        JLabel RoleID_lbl = new JLabel("RoleID:"); 
        RoleID_lbl.setForeground(Color.white);
        staffInfo_panel_center.add(RoleID_lbl, gbcCenter);
        gbcCenter.gridx = 1; // Di chuyển sang cột tiếp theo
        JTextField txtRoleID = new JTextField(20); // Số lượng ký tự cho phép nhập vào
        staffInfo_panel_center.add(txtRoleID, gbcCenter);

        // Label và Textfield cho địa chỉ
        gbcCenter.gridx = 0; // Quay lại cột đầu tiên
        gbcCenter.gridy++; // Di chuyển xuống dòng tiếp theo
        JLabel DiaChi_lbl = new JLabel("Địa chỉ:"); 
        DiaChi_lbl.setForeground(Color.white);
        staffInfo_panel_center.add(DiaChi_lbl, gbcCenter);
        gbcCenter.gridx = 1; // Di chuyển sang cột tiếp theo
        JTextField txtAddress = new JTextField(20); // Số lượng ký tự cho phép nhập vào
        staffInfo_panel_center.add(txtAddress, gbcCenter);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
