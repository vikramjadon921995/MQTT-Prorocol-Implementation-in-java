<jsp:useBean id="pvldt" scope="page" class="threeT.DoctorPublish" />
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
%>
<script>
    alert("Message not sent!");
</script>
<%
    }
%>

