package threeT;
import java.sql.*;

public class DatabaseConnect  
{

    public DatabaseConnect() 
    {
        //connect
    }
    
    public String getPassword(String uid)
    {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
       //String DB_URL = "jdbc:mysql://localhost:3306/broker";
       String DB_URL = "jdbc:derby://localhost:1527/broker";
       String USER = "root";
       String PASS = "vikramjadon95";
       Connection conn = null;
       Statement stmt = null;
       try {
           Class.forName("com.mysql.jdbc.Driver");

           System.out.println("Connecting to database...");
           conn = DriverManager.getConnection(DB_URL, USER, PASS);

           System.out.println("Creating statement...");
           stmt = conn.createStatement();
           String sql;
           sql = "SELECT password from doctor where dr_id = \'"+uid +"\'";
           ResultSet rs = stmt.executeQuery(sql);
           String mem = "";
           while(rs.next()){
                mem = rs.getString(1);
           }
           stmt.close();
           conn.close();
           return mem;
       } catch (SQLException se) {
           se.printStackTrace();
       } catch (Exception e) {
           e.printStackTrace();
       } finally {
           try {
               if (stmt != null) {
                   stmt.close();
               }
           } catch (SQLException se2) {
           }
           try {
               if (conn != null) {
                   conn.close();
               }
           } catch (SQLException se) {
               se.printStackTrace();
           }
       }
       System.out.println("Goodbye!");
       return null;
       
    }
}