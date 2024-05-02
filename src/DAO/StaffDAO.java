package DAO;

import DTO.StaffDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class StaffDAO {
    
    public ArrayList<StaffDTO> readAllStaffData() {
        ArrayList<StaffDTO> list = new ArrayList<>();
        String query = "SELECT * FROM tb_users WHERE isdeleted = false";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                StaffDTO staff = new StaffDTO();
                staff.setId(rs.getLong("id"));
                staff.setUsername(rs.getString("username"));
                staff.setPassword(rs.getString("password"));
                staff.setEmail(rs.getString("email"));
                staff.setPhone(rs.getString("phone"));
                staff.setAddress(rs.getString("address"));
                staff.setisDeleted(rs.getBoolean("isdeleted"));
                staff.setRoleId(rs.getString("roleid"));
                staff.setCreateTime(rs.getDate("create_time"));
                staff.setUpdateTime(rs.getDate("update_time"));
                list.add(staff);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean insertStaffData(StaffDTO staff) {
        
        String query = "INSERT INTO tb_users (id, username, password, email, phone, address, isdeleted, roleid, create_time, update_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
        	pstm.setLong(1, staff.createId());
        	pstm.setString(2, staff.getUsername());
            pstm.setString(3, staff.getPassword());
            pstm.setString(4, staff.getEmail());
            pstm.setString(5, staff.getPhone());
            pstm.setString(6, staff.getAddress());
            pstm.setBoolean(7, false);
            pstm.setString(8, staff.getRoleId());
            
            Timestamp sqlDateUpdate = new Timestamp(staff.getUpdateTime().getTime());
            Timestamp sqlDateCreate = new Timestamp(staff.getCreateTime().getTime());
            
            pstm.setTimestamp(9, sqlDateUpdate);
            pstm.setTimestamp(10, sqlDateCreate);
            
            return pstm.executeUpdate() > 0;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isUsernameExists(String username) {
        String query = "SELECT COUNT(*) AS count FROM tb_users WHERE username = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setString(1, username);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isEmailExists(String email) {
        String query = "SELECT COUNT(*) AS count FROM tb_users WHERE email = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setString(1, email);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean updateStaffData(StaffDTO staff) {
        String query = "UPDATE tb_users SET username = ?, password = ?, email = ?, phone = ?, address = ?, isdeleted = ?, roleid = ?, update_time = ? WHERE id = ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setString(1, staff.getUsername());
            pstm.setString(2, staff.getPassword());
            pstm.setString(3, staff.getEmail());
            pstm.setString(4, staff.getPhone());
            pstm.setString(5, staff.getAddress());
            pstm.setBoolean(6, staff.getisDeleted());
            pstm.setString(7, staff.getRoleId());
            Timestamp sqlDateUpdate = new Timestamp(staff.getUpdateTime().getTime());
            pstm.setTimestamp(8, sqlDateUpdate);
            pstm.setLong(9, staff.getId());
            
            return pstm.executeUpdate() > 0;
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    

    private boolean isUsernameExistsForUpdate(String username, long currentStaffId) {
        String query = "SELECT COUNT(*) AS count FROM tb_users WHERE username = ? AND id != ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setString(1, username);
            pstm.setLong(2, currentStaffId);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean isEmailExistsForUpdate(String email, long currentStaffId) {
        String query = "SELECT COUNT(*) AS count FROM tb_users WHERE email = ? AND id != ?";
        try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
            pstm.setString(1, email);
            pstm.setLong(2, currentStaffId);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private GUI.Comp.Swing.PanelBackground pnContainer;
    // Add other CRUD methods as needed
}
