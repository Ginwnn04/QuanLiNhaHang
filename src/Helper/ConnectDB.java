package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectDB {
    private static ConnectDB instance;
    private String connectionUrl = "jdbc:postgresql://dpg-co1flb6ct0pc73dbnh5g-a.singapore-postgres.render.com:5432/restaurant_management_a76y?ssl=true&user=nam&password=ii7c7AQD68CDzEpUgfU7rERpBfReKfHs";
    private Connection con;
    
    private ConnectDB() {
    }
    
    public static ConnectDB getInstance() {
        if (instance == null) {
            instance = new ConnectDB();
        }
        return instance;
    }
    
    public void openConnect() {
        try {
            this.con = DriverManager.getConnection(connectionUrl);
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return con;
    }
    
    
}
