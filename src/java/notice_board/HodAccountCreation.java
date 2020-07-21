package notice_board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
 

public class HodAccountCreation extends HttpServlet {
        Connection con;
        PreparedStatement ps;
        //now only once connection is setup when servlet is loaded to servlet container
        public void init()
        {
            
            try{String query = "insert into hod values (?,?,?,?,'activate')";
             Class.forName("com.mysql.jdbc.Driver");
             con=DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board?useSSL=false","root","qwerty");
             ps = con.prepareStatement(query);
            }catch(Exception e){e.printStackTrace();}
         }
        public void destroy()
        {
            try{con.close();}catch(Exception e){e.printStackTrace();}  
        }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        
        //reading the parameters from the form
        String uid = request.getParameter("uid");
        String pw = request.getParameter("pw");
        String name = request.getParameter("name");
        String dept = request.getParameter("dept");
        
        //save them to the database using jdbc
        
        
        try{
        
            ps.setString(1,uid);
            ps.setString(2,pw);
            ps.setString(3,name);
            ps.setString(4,dept);
           
            ps.executeUpdate();
            
            out.println("<html>");
            out.println("<body>");
            out.println("<center><h3 style=\"background-color:powderblue;\">Vellore Institute of Technology , vellore</h3><hr><br></center>");
            out.println("<center>");
            out.println("<h2>Account Created for the HOD "+name+" of the department "+dept+"</h2><br><br><br>");
            out.println("<a href=HodRegi.jsp>Create another account</a><br><br>");
            out.println("<a href=admin_home.jsp><a href=\"index.jsp\"><button type=\"button\" style=\"background-color: aquamarine; border-radius: 10px;width: 100px;height:30px;\">Home<a>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
         
        }catch(Exception e)
        { out.println(e);}
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
