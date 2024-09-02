import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ODBCExample {
    public static void main(String[] args) {
        // URL of the ODBC Data Source
        String url = "jdbc:odbc:yourDSN";
        
        // Database credentials (if required)
        String user = "yourUsername";
        String password = "yourPassword";

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Load the JDBC-ODBC Bridge Driver
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            
            // Establish a connection to the database
            conn = DriverManager.getConnection(url, user, password);
            
            // Create a statement object
            stmt = conn.createStatement();
            
            // Execute a query
            String query = "SELECT * FROM yourTable";
            rs = stmt.executeQuery(query);
            
            // Process the results
            while (rs.next()) {
                System.out.println("Column1: " + rs.getString("Column1"));
                System.out.println("Column2: " + rs.getString("Column2"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Clean up resources
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
