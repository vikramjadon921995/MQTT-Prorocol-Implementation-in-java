<%@page import="threeT.Extractdata"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.*;"%>
<jsp:useBean id="tvldt" scope="page" class="threeT.UpdateDatabase" />
<jsp:setProperty name="tvldt"  property="*"/>
<!DOCTYPE html>
<html style = "background-color:lavender">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
        <table>
            <tr>
                <td>
         <h1 style="
    margin-left: 510px;
    font-family: cursive;
    font-size: 43px;
    margin-top: 0px;
">Patient Information</h1>
        <h2 style = "font-family: cursive;
margin-top: 100px;
font-size: 37px;">Region : <%=request.getParameter("reg")%></h2>
        <h2 style="
    font-family: cursive;
    font-size: 38px;
    margin-left: 131px;
">Patient's ID : <%=request.getParameter("pid")%></h2>
        <h2 style= "margin-left: 131px;
font-family: cursive;
font-size: 35px;">Patient's Name : <%=request.getParameter("pname")%></h2>
<h1>&nbsp;</h1>
</td>
<td>
<div>
       <%
       Extractdata ed = new Extractdata();
       ed.ConnectDatabase();
       System.out.println("In PatientInfo!!");
       double temp = ed.gettemp(request.getParameter("pid").trim(), request.getParameter("reg").trim());
       double hb = ed.gethb(request.getParameter("pid").trim(), request.getParameter("reg").trim());
       String pph = ed.getpphoto(request.getParameter("pid").trim(), request.getParameter("reg").trim());
       String ecgph = ed.getecgphoto(request.getParameter("pid").trim(), request.getParameter("reg").trim());
       pph = pph.trim();
       ecgph = ecgph.trim();
       ed.CloseConnection();
       System.out.println(temp + " " + hb + " " + pph + " " + ecgph);
       //out.println("<img src = \"img/"+pph+"\" width = \"250px\" height = \"250px\" alt=\"patient's photo\"");
       //out.println("<table border=1><tr><td>Anuj</tr></td></table>");
       out.println("<img src = \""+pph+"\" width = \"250px\" height = \"250px\" alt = \"Patient's Photo\">");
       //System.out.println("<img src = \"img/"+pph+"\" width = \"250px\" height = \"250px\" alt = \"Patient's Photo\">");
       %>
</div> 
</td>
            </tr>
            <tr>
                <td>
                    <h2 style="
    font-family: cursive;
    font-size: 38px;
    margin-left: 131px;
">Patient's Temperature : <%out.println(temp);%></h2>
<h2 style="
    font-family: cursive;
    font-size: 38px;
    margin-left: 131px;
">Patient's Heart Rate : <%out.println(hb);%></h2>
                </td>
                <td>
                    <%out.println("<img src = \""+ecgph+"\" width = \"250px\" height = \"250px\" alt = \"Patient's ECG\">");%>
                </td>
            </tr>
        </table>
    </div>
        <h1 style = "font-family: cursive;
font-size: 29px;">Send Prescription Details</h1>
        <form name="f1" method="post" action="sentmsg.jsp">
            <table>
                <tr>
                    <td style = "font-family: cursive;">Enter Details       </td>
                    <td><textarea name = "mes" rows="5" cols="50" type="text" style=" font-family: cursive;  font-size: smaller; border-radius: 7px;
    "></textarea></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><input type="hidden" name = "reg" value = <%=request.getParameter("reg")%>/></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><input type="submit" name = "bttnSubmit" value = "Send"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>