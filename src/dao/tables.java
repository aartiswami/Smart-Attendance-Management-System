/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class tables {
    
     public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {
            // Get the connection
            con = ConnectionProvider.getCon();
            st = con.createStatement();
            
            // Check if 'userdetails' table exists, if not, create it
            if (!tableExists(st, "userdetails")) {
                String createUserDetailsTable = "CREATE TABLE userdetails ("
                        + "id INT AUTO_INCREMENT PRIMARY KEY, "
                        + "name VARCHAR(255) NOT NULL, "
                        + "gender VARCHAR(50) NOT NULL, "
                        + "email VARCHAR(255) NOT NULL, "
                        + "contact VARCHAR(20) NOT NULL, "
                        + "address VARCHAR(500), "
                        + "state VARCHAR(100), "
                        + "country VARCHAR(100), "
                        + "uniqueregid VARCHAR(100) NOT NULL, "
                        + "imagename VARCHAR(100))";
                st.executeUpdate(createUserDetailsTable);
            }
            if (!tableExists(st, "userattendance")) {
                    st.executeUpdate("CREATE TABLE userattendance (" +
                     "userid INT NOT NULL, " +
                     "date DATE NOT NULL, " +
                     "checkin DATETIME, " +
                     "checkout DATETIME, " +
                     "workduration VARCHAR(100), " +
                     "PRIMARY KEY (userid, date));");
}

            JOptionPane.showMessageDialog(null, "Tables Checked/Created Successfully");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    // Method to check if a table exists in the database
    private static boolean tableExists(Statement st, String tableName) throws Exception {
        ResultSet resultSet = st.executeQuery("SHOW TABLES LIKE '" + tableName + "'");
        return resultSet.next();  // Returns true if the table exists
    }
}