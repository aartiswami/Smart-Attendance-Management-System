package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {

    private static final String DB_NAME = "attendanceJframebd";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/"; // Add additional options in URL
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "123456";
    
    public static Connection getCon() {
        Connection con = null;
        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Connect to MySQL server without specifying the database
            con = DriverManager.getConnection(DB_URL + "?useSSL=false&allowPublicKeyRetrieval=true", DB_USERNAME, DB_PASSWORD);
            
            // Check if the database exists; if not, create it
            if (!databaseExists(con, DB_NAME)) {
                createDatabase(con, DB_NAME);
            }
            
            // Re-establish the connection, now with the database
            con = DriverManager.getConnection(DB_URL + DB_NAME + "?useSSL=false&allowPublicKeyRetrieval=true", DB_USERNAME, DB_PASSWORD);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }
    
    private static boolean databaseExists(Connection con, String dbName) throws Exception {
        Statement stmt = con.createStatement();
        // Query to check if the database exists
        return stmt.executeQuery("SHOW DATABASES LIKE '" + dbName + "'").next();
    }
    
    private static void createDatabase(Connection con, String dbName) throws Exception {
        Statement stmt = con.createStatement();
        // Correct query to create the database
        stmt.executeUpdate("CREATE DATABASE " + dbName);
        System.out.println("Database '" + dbName + "' created successfully.");
    }
}
