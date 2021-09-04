
<%-- 
    Document   : student_home
    Created on : 23 Jul, 2019, 10:36:33 PM
    Author     : mansi
--%>


<%
    //jsp has session as an implicit object so, can directly call it.
     String id = (String)session.getAttribute("studentid");
     if(id==null)
     {
         response.sendRedirect("index.jsp");
     } 
     
     String dept=(String)session.getAttribute("studentdept");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
        <h3 style="background-color:powderblue;">Vellore Institute of Technology , vellore</h3>
        <hr><br>
        </center>
        
        <h3> NAME : <%=id %><br> DEPARTMENT : <%=dept %> </h3>
        <hr>
        <center>
            <br>
        <div align ="center" style="width:1600px; height:250px; border-radius: 20px; background-color: aliceblue;"><br><br>
            
            <a href="showDepts"><button type="button" style="background-color: lightgray; border-radius: 10px; width: 200px; height:30px;">view notices</button></a><br><br>
            <a href=""><button type="button" style="background-color: lightgray; border-radius: 10px; width: 200px; height:30px;">change profile</button></a><br><br>
            <a href=""><button type="button" style="background-color: lightgray; border-radius: 10px; width: 200px; height:30px;">Logout</button></a><br><br>
             
        </div>
        </center><br><br>
        <a href="index.jsp"><button type="button" style="background-color: aquamarine; border-radius: 10px;width: 100px;height:30px;">home</button></a><br><br>
    </body>
</html>
