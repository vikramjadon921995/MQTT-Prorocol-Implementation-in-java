<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style = "
    margin-left: 505px;
margin-top: 200px;
background-color:lavender;">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .main
            {
                font-family: cursive;
                font-size: 30px;
                background-color: activecaption;
                background-position: center;
            }
            .vikram
            {
                background-position: center;
            }
         </style>
    </head>
    <body>
        <h1 style="
    font-family: cursive;
    font-style: oblique;
    font-size: 33px;
">Touching a Million Lives</h1>
        <%
            int flag = 0;
        if(flag == 0)
        {
        %>
        <h1 style="
    margin-left: 64px;
    margin-bottom: 35px;
    font-family: cursive;
">Doctor's Login</h1>
        <div class = "vikram">
        <form name="f" method="post" action="validate.jsp">
            <table class="main">
                <tr>
                    <td>Uid</td>
                    <td><input type="text" name="uid" style="
    width: 167px;
    height: 31px;
    font-family: cursive;
    font-size: smaller;
    border-radius: 7px;
"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="pass" style="
    width: 167px;  height: 31px;  font-family: cursive;  font-size: smaller; border-radius: 7px;
"></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><input type="submit" name = "bttnSubmit" value = "Login"/></td>
                </tr>
            </table>
        </form>
        </div>
        <%
        }//if(flag == 0)
        %>
    </body>
</html>
