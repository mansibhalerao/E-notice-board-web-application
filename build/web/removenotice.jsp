
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
        <title>notice delete</title>
    </head>
    <body>
        <center>
        <h3 style="background-color:powderblue;">Vellore Institute of Technology , vellore</h3>
        <hr><br>
        </center>
        
        <h3>Department : <%=dept%></h3><br><hr>
        <center>
     
        <h4 style="color: blue">Remove Notice</h4>
        
        <%
        Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board?useSSL=false","root","qwerty");
                PreparedStatement ps1 = con.prepareStatement("select notice_id,title,message,postdate from notices where uid=?");
                ps1.setString(1,id);
                ResultSet rs = ps1.executeQuery();
        %>
        <table  width="800" height="150" cellpadding="10" bgcolor="whitesmoke">
            <tr bgcolor="pink">
            <th>Id</th>
            <th>Title</th>
            <th>message</th>
            <th>Post Date</th>
            <th>Delete</th>
            </tr>
         <%
            while(rs.next())
            {
         %>
         <tr>
             <%
                   String s1 = rs.getString(1);//id
                   String s2 = rs.getString(2);//title
                   String s3 = rs.getString(3);//message
                   String s4 = rs.getString(4);//post date
             %>
             <td><%=s1%></td>
             <td><%=s2%></td>
             <td><%=s3%></td>
             <td><%=s4%></td>
             <td><a href="deleteRecord?id=<%=s1%>"><button type="button" style="background-color: azure; border-radius: 10px; width: 150px; height:30px;">Remove notice</button></a></td>
             </tr>
             <%
            }  
             %>
        </table>
        </center><br><br><br><br><br>
        <a href="hod_home.jsp"><button type="button" style="background-color: aquamarine; border-radius: 10px;width: 100px;height:30px;">Go Back</button></a>

    </body>
    
</html>
