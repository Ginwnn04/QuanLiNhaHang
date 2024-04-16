/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DELL
 */
public class DataProvider {
    String connectionUrl = "jdbc:postgresql://dpg-co1flb6ct0pc73dbnh5g-a.singapore-postgres.render.com:5432/restaurant_management_a76y?ssl=true&user=nam&password=ii7c7AQD68CDzEpUgfU7rERpBfReKfHs";
    private static DataProvider instance = null;
    private Connection con;
    
    public static DataProvider getInstance() {
        if (instance == null) {
            instance = new DataProvider();
        }
        return instance;
    }
    
    public Connection GetConnect(){
        return con;
    }
    
    public void Open(){
        try{
            con = DriverManager.getConnection(connectionUrl);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void Close(){
        try{
            con = DriverManager.getConnection(connectionUrl);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
}
