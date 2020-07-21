package notice_board;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;

/**
 *
 * @author mansi
 */
public class studentAccountCreation extends HttpServlet {
    
        Connection con;
        PreparedStatement ps;
        //now only once connection is setup when servlet is loaded to servlet container
        public void init()
        {
            
            try{String query = "insert into student values (?,?,?,?,?,'pending')";
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
        String branch = request.getParameter("branch");
        String sem=request.getParameter("sem");
        
        //save them to the database using jdbc
        
        
        try{
        
            //setting the values.
            ps.setString(1,uid);
            ps.setString(2,pw);
            ps.setString(3,name);
            ps.setString(4,branch);
            ps.setString(5,sem);
           
            ps.executeUpdate();
            //give the output
            out.println("<html>");
            out.println("<body>");
            out.println("<center><h3 style=\"background-color:powderblue;\">Vellore Institute of Technology , vellore</h3><hr><br></center>");
            out.println("<center>");
            out.println("<h2>Account Created for the student "+name+"</h2>");
            out.println("<h3>after verification your account will be activated.</h3>");
            out.println("<br><br><hr><br>");
            out.println("<a href=index.jsp><a href=\"index.jsp\"><button type=\"button\" style=\"background-color: aquamarine; border-radius: 10px;width: 100px;height:30px;\">Home</button><a>");
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
         
        }catch(Exception e){e.printStackTrace();}
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
