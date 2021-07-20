/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class DBConnection {

    private static Connection conn;

    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@//Yogesh:1521/Xe", "myproject", "java");
            JOptionPane.showMessageDialog(null, "Connection Opened successfully", "Sucess", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error in Loading Driver", "DriverError!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(1);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in Opening connection", "DBError!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(1);
        }
    }
    public static Connection getConnection()
    {
        return conn;
    }



  public static void closeConnection() {
        try {
            conn.close();
            JOptionPane.showMessageDialog(null, "Connection close successfully");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in closing connection", "DBError!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
}
}
    

