/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.TableDTO;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author quang
 */
public class TableDAO {
    
    public ArrayList<TableDTO> readAllData() {
        ArrayList<TableDTO> list = new ArrayList<>();
        String query = "SELECT * FROM tb_tables";
        try (Connection con = Helper.ConnectDB.openConnect(); PreparedStatement pstm = con.prepareStatement(query);){
            ResultSet rs = pstm.executeQuery();
            while(rs.next()) {
                TableDTO table = new TableDTO();
                table.setId(rs.getLong("id"));
                table.setName(rs.getString("name"));
                table.setDes(rs.getString("des"));
                table.setCustomerCode(rs.getString("customer_code"));
                table.setStatus(rs.getString("statusid"));
                table.setCreateTime(rs.getString("createTime"));
                table.setUpdateTime(rs.getString("updateTime"));
                table.setIsDelete(rs.getBoolean("isdeleted"));
                list.add(table);
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return list;
        
    }
}
