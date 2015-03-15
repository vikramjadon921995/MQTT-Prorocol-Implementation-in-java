<jsp:useBean id="pvldt" scope="page" class="threeT.PahoDemo" />
<jsp:setProperty name="pvldt"  property="*"/>
<%
    if(pvldt.doDemo())
    {
      %>
      <script>
          alert("The message has been sent!");
      </script>
      <%
    }
    else
    {
        //ideal place for session writing
        //Object temp = session.getAttribute("attempt");
        /*if(temp == null)
        {//atttribute not found
            session.setAttribute("attempt", "1");
        }
        else
        {//attribute exists
            int x = Integer.parseInt(temp.toString());
            x++;
            session.setAttribute("attempt", String.valueOf(x));
        }*/
%>
<script>
    alert("Message not sent!");
</script>
<%
    }
%>

