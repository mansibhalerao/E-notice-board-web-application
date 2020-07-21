
package notice_board;

import java.io.*;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class enable_student_account extends HttpServlet {

    Connection con;
        PreparedStatement ps;
        //now only once connection is setup when servlet is loaded to servlet container
        public void init()
        {
            
            try{String query = "update student set status='activated' where stu_id=?";
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
            try{
            /* TODO output your page here. You may use following sample code. */
            String id=request.getParameter("id");
            ps.setString(1,id);
            ps.executeUpdate();
            response.sendRedirect("ViewStudentReq");
        }catch(Exception e){out.println(e);}
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
