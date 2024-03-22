package Helper;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectDB {
    
    public static Connection openConnect() throws Exception{
        String connectionUrl = "jdbc:postgresql://dpg-cms55red3nmc73ep4ll0-a.singapore-postgres.render.com:5432/restaurant_management?ssl=true&user=nam&password=3PDAIRLZYl80z7qtZhyIKQvxegtAAXPL";
        Connection con = DriverManager.getConnection(connectionUrl);
        return con;
    }
}
