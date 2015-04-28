<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.*;"%>
<jsp:useBean id="tdvldt" scope="page" class="threeT.DatabaseConnect" />
<jsp:setProperty name="tdvldt"  property="*"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style = "background-color: lavender">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
            <td>
        <%
        PrintWriter outer = response.getWriter();
        outer.println("<h1 style = \"font-family: cursive; font-size: 69px; margin-left: 414px;\">Doctor's Home </h1>");
        outer.println("<h1></h1>");
        String dr_id = request.getParameter("uid");
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
           ResultSet rs;
           sql = "SELECT * from doctor where dr_id = \'"+dr_id+"\'";
           rs = stmt.executeQuery(sql);
           String name = "", region = "", password = "", id = "";
           while(rs.next()){
                id = rs.getString(1);
                name = rs.getString(2);
                region = rs.getString(3);
                password = rs.getString(4);
           }
           outer.println("<table>"
                   + "<tr>"
                   + "<td style = \"font-family: cursive; font-size: 50px;\">Welcome Dr. " + name + "</td>"
                   + "</tr>"
                   + "</table>");
           outer.println("<h1 style = \"font-family: cursive; font-size: 40px;\">Patients From " + region + "</h1>");
           outer.println("<h1></h1>");
           
           sql = "SELECT * from "+region;
           rs = stmt.executeQuery(sql);
           
           while(rs.next()){
               outer.println("<h3 style = \"font-family: cursive; font-size: 30px;\"><a href = \"patientinfo.jsp?reg=" + region + " &pid= " + rs.getString("p_id") + " &pname= " + rs.getString("p_name") + " \">" + rs.getString("p_id")+ "       " + rs.getString("p_name") + "</a> </h3>" );
           }
           stmt.close();
           conn.close();
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
        %>
        </td>
        </tr>
        </table>
    </body>
</html>