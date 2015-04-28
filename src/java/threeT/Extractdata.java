package threeT;

import java.sql.*;
import java.io.*;
import java.net.*;

public class Extractdata {
    public Extractdata()
    {
        System.out.println("In Extractor!!");
    }
    
    Connection conn = null;
    Statement stmt = null;
    
    public void ConnectDatabase()
    {
        String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   //if(topic == "region1"){
       String DB_URL = "jdbc:derby://localhost:1527/broker";
       //  Database credentials
       String USER = "root";
       String PASS = "vikramjadon95";
       try {
           //STEP 2: Register JDBC driver
           Class.forName("com.mysql.jdbc.Driver");

           //STEP 3: Open a connection
           System.out.println("Connecting to database...");
           conn = DriverManager.getConnection(DB_URL, USER, PASS);
           System.out.println(conn);
        }
        catch(Exception ex)
        {
            System.out.println("Error in Connecting to Database !!");
        }
    }
    
    public void CloseConnection()
    {
        try {
               if (stmt != null) {
                   stmt.close();
               }
           } catch (SQLException se2) {
           }// nothing we can do
           try {
               if (conn != null) {
                   conn.close();
               }
           } catch (SQLException se) {
               se.printStackTrace();
           }
    }
    
    public double gettemp(String p_id, String region)
    {
        double tempe = 0;
        try{
            String sql;
            sql = "SELECT TEMP FROM " + region + " WHERE P_ID = \'"+p_id+"\'";
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next())
                tempe = rs.getDouble("TEMP");
        }
        catch(Exception ex)
        {
            System.out.println("Error !! -- " + ex);
        }
        return tempe;
    }
    
    public double gethb(String p_id, String region)
    {
        double tempe = 0;
        try{
            String sql;
            sql = "SELECT HEART_B FROM " + region + " WHERE P_ID = \'" + p_id + "\'";;
            PreparedStatement St = conn.prepareStatement(sql);
            ResultSet r = St.executeQuery();
            while(r.next())
                tempe = r.getDouble(1);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return tempe;
    }
    
    public String getpphoto(String p_id, String region)
    {
        String tempe = "p1photo.jpg";
        try{
            String sql;
            sql = "SELECT P_PHOTO FROM " + region + " WHERE P_ID = \'" + p_id + "\'";
            PreparedStatement St = conn.prepareStatement(sql);
            ResultSet r = St.executeQuery();
            while(r.next())
                tempe = r.getString(1);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return tempe;
    }
    
    public String getecgphoto(String p_id, String region)
    {
        String tempe = "p1ecg.jpg";
        try{
            String sql;
            sql = "SELECT P_ECG FROM " + region + " WHERE P_ID = \'" + p_id + "\'";
            PreparedStatement St = conn.prepareStatement(sql);
            ResultSet r = St.executeQuery();
            while(r.next())
                tempe = r.getString(1);
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return tempe;
    }
}