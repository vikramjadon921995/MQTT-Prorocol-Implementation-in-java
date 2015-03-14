package threeT;
import java.sql.*;

public class UpdateDatabase {
     public UpdateDatabase() 
    {
        //connect
    }
    
    public String gettemp(String region, String pid)
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
           sql = "select temp from " +region+ " where p_id = \'"+pid+"\'";
            String temp1 = "";
           ResultSet rs = stmt.executeQuery(sql);
       while(rs.next())
       {
            temp1 = rs.getString(1).trim();
       }
           stmt.close();
           conn.close();
           return temp1;
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
    
        public String gethb(String region, String pid)
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
           sql = "select heart_b from " +region+ " where p_id = \'"+pid+"\'";
            String hb = "";
           ResultSet rs = stmt.executeQuery(sql);
       while(rs.next())
       {
            hb = rs.getString(1).trim();
       }
           stmt.close();
           conn.close();
           return hb;
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
         public String getdrregion(String drid)
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
           sql = "select region from doctor where dr_id = \'"+drid+"\'";
            String hb = "";
           ResultSet rs = stmt.executeQuery(sql);
       while(rs.next())
       {
            hb = rs.getString(1).trim();
       }
           stmt.close();
           conn.close();
           return hb;
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
         
          public String getdrname(String drid)
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
           sql = "select name from doctor where dr_id = \'"+drid+"\'";
            String hb = "";
           ResultSet rs = stmt.executeQuery(sql);
       while(rs.next())
       {
            hb = rs.getString(1).trim();
       }
           stmt.close();
           conn.close();
           return hb;
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
