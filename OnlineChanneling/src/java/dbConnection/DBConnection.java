/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Hasitha
 */
public class DBConnection {
    
    private static DBConnection instance;
    private Connection con;
    
    private DBConnection(){
        
        try {
               
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/ODC", "odc","odc");
            
        } catch (Exception e){
            e.printStackTrace();
        }
        //return con;
    }
    public static DBConnection getInstance() {
        if(instance == null)
        {
            instance = new DBConnection();
        }
        return instance;
    }
    
    public Connection getConnection() {
        return con;
    }
    
    public void close(AutoCloseable closeable) {
        
        try
        {
            if(closeable != null)
            {
                closeable.close();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
