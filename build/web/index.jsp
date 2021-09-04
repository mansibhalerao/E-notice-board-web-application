<!DOCTYPE html>

<%
   //scriplets to write java code
    String v1="",v2="";
   // fetch all th cookies 
    Cookie my_cookies[] = request.getCookies();
    if(my_cookies !=null)
    {
        for(Cookie c:my_cookies)
        {
            String s = c.getName();
            if(s.equals("id"))
            {
                v1 = c.getValue();
            }
            else if(s.equals("pw"))
            {
                v2 =c.getValue();
            }
        }
    }
%>

<html>
    <head>
        
        <style>
            h1{
    background-color: lightblue;
    font-family: sans-sarif;
    font-size: 10px;
    text-align: center;
}
input{
    border-radius: 4px;
    width:150px;
    height:20px;
}
input::hover{
    border-color: blue;
}
div{
    background-color: cornsilk;
    text-align: center;
}
        </style>
    </head>
    <body>
        <center>
        <h3 style="background-color:powderblue;">Vellore Institute of Technology , vellore</h3>
        <hr><br>
        </center>
        <center>
         <h3 style="color:blue;">NOTICE BOARD</h3>
        <hr>
        <div><br>
        <form action="verify_user" method="post">
               <pre>
    UserId       <input type="text" name="uid" value="<%=v1%>"/><br> 
    password     <input type="password" name="pw" value="<%=v2%>"/><br>
UserType        <select name="UserType">
                          <option>admin</option>
                          <option>HOD</option>
                          <option>student</option>
                          </select><br>
 SavePassword <input type="checkbox" name="save" value="yes"/><br><br>
            
         <input type="submit" value="login" style="width:100px; height:25px;background-color: azure;"/>     

  
        </form><br><br>
      New user?
      <a href="student_reg.jsp">register here</a>
              </pre>
        </div>
        </center>
        
        <hr>
    </body>
</html>

