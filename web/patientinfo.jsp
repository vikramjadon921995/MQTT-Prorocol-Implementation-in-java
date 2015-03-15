<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.*;"%>
<jsp:useBean id="tvldt" scope="page" class="threeT.temper" />
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
       if(request.getParameter("reg").toLowerCase().trim().equals("region1"))
       {
           %>
           <img src = "img/p1photo.jpg" width="250px" height = "250px" alt="vikram"> 
           <%
       }
       else{
           %>
           <img src = "img/p1photo.jpg" width="250px" height = "250px" alt="jadon"> 
           <%
       }
            %>
        </div>
            </td>
            </tr>
            <tr>
                <td style = "font-family: cursive;
font-size: 37px;">Patient's ECG : </td>
                 <td>
                <%
            if(request.getParameter("reg").toLowerCase().trim().equals("region1"))
       {
           %>
           <img src = "img/p1ecg.jpg" width="250px" height = "250px" alt="vikram"> 
           <%
       }
       else{
           %>
           <img src = "img/p1ecg.jpg" width="250px" height = "250px" alt="jadon"> 
           <%
       }
                %>
                 </td>
            </tr>
            <tr>
                <td style = "font-family: cursive;
font-size: 41px;">Patient's Temperature :            <%= tvldt.gettemp(request.getParameter("reg").trim(), request.getParameter("pid").trim())%> F<td>
                </tr>
                <tr>
                <td style = "font-family: cursive;
font-size: 41px;">Patient's HeartRate :            <%= tvldt.gethb(request.getParameter("reg").trim(), request.getParameter("pid").trim())%> /s<td>
                </tr>
        </table>
        </div>
        <h1 style = "font-family: cursive;
font-size: 29px;">Send Prescription Details</h1>
        <form name="f1" method="post" action="sentmsg.jsp">
            <table>
                <tr>
                    <td style = "font-family: cursive;">Enter Details</td>
                    <td><input style ="width: 285px;
height: 100px;" type="text" name = "msg" /></td>
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
