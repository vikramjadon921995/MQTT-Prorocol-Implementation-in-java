<jsp:useBean id="vldt" scope="page" class="threeT.Validator" />
<jsp:setProperty name="vldt"  property="*"/>

<%
    if(vldt.validate())
    {
        //ideal place for session writing
%>

    <jsp:forward page="home.jsp"/>
<%
    }
    else
    {
        //ideal place for session writing
        //Object temp = session.getAttribute("attempt");
        //if(temp == null)
        /*{atttribute not found
            session.setAttribute("attempt", "1");
        }
        else
        {//attribute exists
            int x = Integer.parseInt(temp.toString());
            x++;
            session.setAttribute("attempt", String.valueOf(x));
        }*/
%>
    <jsp:forward page="loginFailed.jsp"/>
<%
    }
%>

