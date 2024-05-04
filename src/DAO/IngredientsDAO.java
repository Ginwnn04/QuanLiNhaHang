/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Tai
 */
import DTO.IngredientsDTO;
import BUS.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class IngredientsDAO {

    
public IngredientsDTO getIngredientById(int id) {
    String query = "SELECT id, name, des, quantity, unit, isDeleted FROM tb_ingredients WHERE id=?";
    try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
        pstm.setInt(1, id);
        try (ResultSet rs = pstm.executeQuery()) {
            if (rs.next()) {
                IngredientsDTO ingredient = new IngredientsDTO();
                ingredient.setId(rs.getInt("id"));
                ingredient.setName(rs.getString("name"));
                ingredient.setDes(rs.getString("des"));
                ingredient.setQuantity(rs.getInt("quantity"));
                ingredient.setUnit(rs.getString("unit"));
                ingredient.setIsDeleted(rs.getBoolean("isDeleted"));
                return ingredient;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}
    
public boolean addIngredient(IngredientsDTO ingredient) throws Exception {
    String query = "INSERT INTO tb_ingredients (id, name, des, quantity, unit, isDeleted) VALUES (?, ?, ?, ?, ?, ?)";
    try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
        pstm.setInt(1, ingredient.getId());
        pstm.setString(2, ingredient.getName());
        pstm.setString(3, ingredient.getDes());
        pstm.setInt(4, ingredient.getQuantity());
        pstm.setString(5, ingredient.getUnit());
        pstm.setBoolean(6, ingredient.isDeleted());
        int affectedRows = pstm.executeUpdate();
        return affectedRows > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
    
public boolean updateIngredient(IngredientsDTO ingredient) throws Exception {
    String query = "UPDATE tb_ingredients SET name = ?, des = ?, quantity = ?, unit = ?, isDeleted = ? WHERE id = ?";
    try (PreparedStatement pstm = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
        pstm.setString(1, ingredient.getName());
        pstm.setString(2, ingredient.getDes());
        pstm.setInt(3, ingredient.getQuantity());
        pstm.setString(4, ingredient.getUnit());
        pstm.setBoolean(5, ingredient.isDeleted());
        pstm.setInt(6, ingredient.getId());

        int rowsAffected = pstm.executeUpdate();
        return rowsAffected > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}
    

public boolean setIngredientAsDeleted(int id) throws Exception {
    String query = "UPDATE tb_ingredients SET isDeleted = true WHERE id = ?";
    try (PreparedStatement preparedStatement = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query)) {
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

public ArrayList<IngredientsDTO> getAllActiveIngredients() throws Exception {
    ArrayList<IngredientsDTO> ingredientsList = new ArrayList<>();
    String query = "SELECT * FROM tb_ingredients WHERE isDeleted = false";
    try (PreparedStatement preparedStatement = Helper.ConnectDB.getInstance().getConnection().prepareStatement(query);
         ResultSet resultSet = preparedStatement.executeQuery()) {
        while (resultSet.next()) {
            IngredientsDTO ingredient = new IngredientsDTO();
            ingredient.setId(resultSet.getInt("id"));
            ingredient.setName(resultSet.getString("name"));
            ingredient.setDes(resultSet.getString("des"));
            ingredient.setQuantity(resultSet.getInt("quantity"));
            ingredient.setUnit(resultSet.getString("unit"));
            ingredientsList.add(ingredient);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return ingredientsList;
}
        public boolean checkIngredientExistence(Connection con, int ingredientId) throws SQLException {
        String sql = "SELECT COUNT(*) AS count FROM tb_ingredients WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, ingredientId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt("count");
                    return count > 0;
                }
            }
        }
        return false;
    }

    public int getIngredientQuantity(Connection con, int ingredientId) throws SQLException {
        String sql = "SELECT quantity FROM tb_ingredients WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, ingredientId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("quantity");
                }
            }
        }
        return 0;
    }

    public void updateIngredientQuantity(Connection con, int ingredientId, int newQuantity) throws SQLException {
        String sql = "UPDATE tb_ingredients SET quantity = ? WHERE id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setInt(1, newQuantity);
            pstmt.setInt(2, ingredientId);
            pstmt.executeUpdate();
        }
    }
}