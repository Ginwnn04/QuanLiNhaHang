package BUS;

import DAO.StaffDAO;
import DTO.StaffDTO;
import java.util.ArrayList;

public class StaffBUS {
    private ArrayList<StaffDTO> list;
    private StaffDAO staffDAO;
    
    public StaffBUS() {
        list = new ArrayList<>();
        staffDAO = new StaffDAO();
    }
    
    public ArrayList<StaffDTO> getAllData() {
     
        return staffDAO.readAllStaffData();
    }
    
    public boolean insertStaff(StaffDTO staff) {
        return staffDAO.insertStaffData(staff);
    }
    
    public boolean updateStaff(StaffDTO staff) {
        return staffDAO.updateStaffData(staff);
    }
    
    public String[] getRoleIDs() {
        return staffDAO.getRoleIDs();
    }

}
