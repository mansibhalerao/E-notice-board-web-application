   package notice_board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class verify_user extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
           //reading the request parameters comming from client.
           String uid=request.getParameter("uid");
           String pw=request.getParameter("pw");
           String UserType=request.getParameter("UserType");
           String save=request.getParameter("save");
           
           
           //processig the request
           String message = "welcome";
           if(UserType.equals("admin"))
           {
                if(uid.equals("admin") && pw.equals("admin"))
                {
                     //to save the pasword using cookies
                if(save!=null)
                    {
                        Cookie c1=new Cookie("id",uid);
                        Cookie c2=new Cookie("pw",pw);
                        c1.setMaxAge(1000);
                        c1.setMaxAge(1000);
                        response.addCookie(c1);
                        response.addCookie(c2);
                    }
           
                    response.sendRedirect("admin_home.jsp");
                }
                else 
                {
                    message="invalid admin username or password. ";
                }
           }
           if(UserType.equals("HOD"))
           {
               
               try{
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board?useSSL=false","root","qwerty");
                   String query = "select * from hod where hod_id=? and hod_password=?";
                   PreparedStatement ps = con.prepareStatement(query);
                   ps.setString(1,uid);
                   ps.setString(2,pw);
                  
                   ResultSet rs = ps.executeQuery();
                   boolean b=rs.next();
                   if(b)
                   {
                       
                       String status=rs.getString("hod_status");
                       
                       if(status.equals("activate"))
                       {
                       
                        //storing the id of hod/faculty to his/her session
                        HttpSession session = request.getSession();
                        session.setAttribute("hodid",uid);
                        
                        String dept = rs.getString("hod_department");
                        session.setAttribute("hoddept",dept);
                        
                        if(save!=null)
                    {
                        Cookie c1=new Cookie("id",uid);
                        Cookie c2=new Cookie("pw",pw);
                        c1.setMaxAge(1000);
                        c1.setMaxAge(1000);
                        response.addCookie(c1);
                        response.addCookie(c2);
                    }
                          
                        response.sendRedirect("hod_home.jsp");
                        
                       }
                       else{
                           message="Account is blocked.";   
                       }
                   }
                   else{
                       message="invalid credentials";
                   }
                   
                   
               }catch(Exception e){e.printStackTrace();}
           }
           if(UserType.equals("student"))
           {
               try{
                   Class.forName("com.mysql.jdbc.Driver");
                   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board?useSSL=false","root","qwerty");
                   String query = "select * from student where stu_id=? and stu_password=?";
                   PreparedStatement ps = con.prepareStatement(query);
                   ps.setString(1,uid);
                   ps.setString(2,pw);
                   ResultSet rs = ps.executeQuery();
                   boolean b=rs.next();
                   if(b)
                   {
                       String status=rs.getString("status");
                       if(status.equals("activated"))
                       {   
                        HttpSession session = request.getSession();
                        session.setAttribute("studentid",uid);
                        
                        String dept = rs.getString("stu_branch");
                        session.setAttribute("studentdept",dept);
                        
                        if(save!=null)
                    {
                        Cookie c1=new Cookie("id",uid);
                        Cookie c2=new Cookie("pw",pw);
                        c1.setMaxAge(1000);
                        c1.setMaxAge(1000);
                        response.addCookie(c1);
                        response.addCookie(c2);
                    }
                        
                        response.sendRedirect("student_home.jsp");
                       }
                       else{
                           message="Account is not yet activated, please wait for sometime.";   
                       }
                   }
                   else{
                       message="Please enter valid credentials";
                   }
                   
                   
               }catch(Exception e){e.printStackTrace();}
           }
           PrintWriter out = response.getWriter();
           out.println("<html><body>");
           out.println("<center><h3 style=\"background-color:powderblue;\">Vellore Institute of Technology , vellore</h3><hr><br>");
           out.println("<br><h3>"+message+"</h3></center><br>");
           out.println("<a href=index.jsp><a href=\"index.jsp\"><button type=\"button\" style=\"background-color: aquamarine; border-radius: 10px;width: 100px;height:30px;\">Home</button><a>");
           out.println("</body></html>");
           out.close();
        }
    

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
