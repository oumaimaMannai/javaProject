package ingapplication;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectBD {
    private static String servername = "localhost";
    private static String username = "root";
    private static String dbname = "bd_gstCompte?createDatabaseIfNotExist=true&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    private static Integer portnumber = 3306;
    private static String password = "";
    
    public static Connection connecterBD(){
        
        Connection cnx =null;
        
        MysqlDataSource datasource = new MysqlDataSource();
        
        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setPassword(password);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portnumber);
        
        try {
            cnx = datasource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(" Get connection -> " + ConnectBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cnx;
    }
}
