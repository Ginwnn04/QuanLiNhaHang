/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Tai
 */
import DTO.RecipesDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.ArrayList;
import BUS.ConnectDB;
public class RecipesDAO {
    private static final String URL = "jdbc:postgresql://dpg-co1flb6ct0pc73dbnh5g-a.singapore-postgres.render.com:5432/restaurant_management_a76y?ssl=true";
    private static final String USERNAME = "nam";
    private static final String PASSWORD = "ii7c7AQD68CDzEpUgfU7rERpBfReKfHs";

    public ArrayList<RecipesDTO> readData() {
        String query = "SELECT id, name FROM tb_recipes";
        ArrayList<RecipesDTO> list = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstm = con.prepareStatement(query);
             ResultSet rs = pstm.executeQuery()) {
            while (rs.next()) {
                RecipesDTO recipe = new RecipesDTO();
                recipe.setId(rs.getInt("id"));
                recipe.setName(rs.getString("name"));
                list.add(recipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void insertData(int id, String name) {
        String query = "INSERT INTO tb_recipes (id, name) VALUES (?, ?)";
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstm = con.prepareStatement(query)) {
            pstm.setInt(1, id);
            pstm.setString(2, name);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteData(int id) {
        String query = "DELETE FROM tb_recipes WHERE id = ?";
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstm = con.prepareStatement(query)) {
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateData(int id, String newName) {
        String query = "UPDATE tb_recipes SET name = ? WHERE id = ?";
        try (Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement pstm = con.prepareStatement(query)) {
            pstm.setString(1, newName);
            pstm.setInt(2, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<RecipesDTO> getAllData() throws Exception {
        String query = "SELECT id, name FROM tb_recipes";
        ArrayList<RecipesDTO> list = new ArrayList<>();
        
        try (Connection con = BUS.ConnectDB.openConnect();
             PreparedStatement pstm = con.prepareStatement(query);
             ResultSet rs = pstm.executeQuery()) {
            
            while (rs.next()) {
                RecipesDTO recipe = new RecipesDTO();
                recipe.setId(rs.getInt("id"));
                recipe.setName(rs.getString("name"));
                list.add(recipe);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
}

