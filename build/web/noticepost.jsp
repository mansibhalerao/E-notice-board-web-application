<%-- 
    Document   : noticepost
    Created on : 18 Oct, 2019, 8:28:31 PM
    Author     : mansi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
   String id = (String)session.getAttribute("hodid");
   if(id==null)//the user is accessing the page without logging in
   {
       response.sendRedirect("index.jsp");
   }
   String dept = (String)session.getAttribute("hoddept");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Post Notice</title>
    </head>
    <body>
        <center>
        <h3 style="background-color:powderblue;">Vellore Institute of Technology , vellore</h3>
        <hr><br>
        </center>
        
        <h3>Department : <%=dept%></h3><br><hr>
        <center>
            <br>
        <div align ="center" style="width:600px; height:350px; border:3px solid powderblue; background-color:ivory; border-radius:30px;">
            <h4>Post Notice</h4><br>
        <form action ="saveNotice" method="post">
            <pre>
Title    <input type="text" name ="title"/><br></br>
Message     <textarea name="message" rows ="5" cols="40"></textarea><br></br>
<br><input type="submit" value ="post notice" style="background-color: lightsteelblue; width:100px; height:30px; border-radius: 10px"/>
            </pre>
        </form>
        </div>
        </center>
        <a href="hod_home.jsp"><button type="button" style="background-color: aquamarine; border-radius: 10px;width: 100px;height:30px;">Back</button></a>
    </body>
    
</html>
