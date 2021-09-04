<%@page import="java.sql.ResultSet"%>
<%@page import="com.mysql.cj.protocol.Resultset"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%
String query = "select * from student";
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board?useSSL=false","root","qwerty");
PreparedStatement ps = con.prepareStatement(query);
ResultSet rs = ps.executeQuery();             
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
        <center>
        <h2>Students List</h2>
        <table  width="30" cellspacing="10" cellpadding="10" bgcolor="honeydew">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>password</th>
                    <th>Name</th>
                    <th>Branch</th>
                    <th>semester</th>
                    <th>Account Status</th>
                </tr>
            </thead>
            <tbody>
                
<%
             while(rs.next())
             {
                  String s1 =  rs.getString(1);
                  String s2 =  rs.getString(2);
                  String s3 =  rs.getString(3);
                  String s4 =  rs.getString(4);
                  String s5 =  rs.getString(5);
                  String s6 =  rs.getString(6);
     
%>
                
                <tr>
                    <td><% out.println(s1); %></td>
                    <td><% out.println(s2); %></td>
                    <td><% out.println(s3); %></td>
                    <td><% out.println(s4); %></td>
                    <td><% out.println(s5); %></td>
                    <td><% out.println(s6); %></td>
                </tr>
                
<%
            }
             con.close();
%>
                
            </tbody>
        </table>
        </center>
<br><br>
<h3><a href="admin_home.jsp"><button type="button" style="background-color: aquamarine; border-radius: 10px;width: 100px;height:30px;">Back</a></button></h3>
    </body>
</html>
