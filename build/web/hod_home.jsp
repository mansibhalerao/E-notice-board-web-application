 <%-- 
    Document   : hod_home
    Created on : 23 Jul, 2019, 10:50:34 PM
    Author     : mansi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
    //jsp has session as an implicit object so, can directly call it.
     String id = (String)session.getAttribute("hodid");
     if(id==null)
     {
         response.sendRedirect("index.jsp");
     }
     String dept=(String)session.getAttribute("hoddept");
     
%>


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
        <h3>Name: <%=id%><br> Department : <%=dept%></h3>
        <hr>
        <center>
        <div align ="center" style="width:500px; height:300px; border-radius: 20px; background-color:gainsboro;">
        <pre><br><br>
    <a href = "noticepost.jsp"><button type="button" style="background-color: lightcyan; border-radius: 10px; width: 200px; height:30px;">Post Notice</button></a><br>
    <a href = "removenotice.jsp"><button type="button" style="background-color: lightcyan; border-radius: 10px; width: 200px; height:30px;">Remove Notice</button></a><br>
    <a href =" NoticeBoard?id=<%=id%>"><button type="button" style="background-color: lightcyan; border-radius: 10px; width: 200px; height:30px;">view all notices</button></a><br>
    <a href = ""><button type="button" style="background-color: lightcyan; border-radius: 10px; width: 200px; height:30px;">change profile</button></a><br>

        </pre>
        </div>
        </center>
      <br><br><br>
<h3><a href="index.jsp"><button type="button" style="background-color: aquamarine; border-radius: 10px;width: 100px;height:30px;">Back</button></a><h3>
        </hr>
    </body>
</html>
