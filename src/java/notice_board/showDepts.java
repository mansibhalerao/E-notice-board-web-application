/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notice_board;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.paint.Color.color;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class showDepts extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board?useSSL=false","root","qwerty");
                PreparedStatement ps1 = con.prepareStatement("select Hod_id,hod_department from hod where Hod_id in(select uid from notices)");
                ResultSet rs = ps1.executeQuery();
                   out.println("<!DOCTYPE html>");
                   out.println("<html>");
                   out.println("<body>");
                   out.println("<center><h3 style=\"background-color:powderblue;\">Vellore Institute of Technology , vellore</h3><hr><br></center>");
 
                   out.println("<center><div align =\"center\" style=\"width:1600px; height:400px; border-radius:20px; background-color:ivory;\">");
                   out.println("<br><h4>Select the Department</h4>");
                  
                while(rs.next())
                {
                   String s1 = rs.getString(1);
                   String s2 = rs.getString(2);
                   
                   out.println("<br>");
                   out.println("<a href = NoticeBoard?id="+s1+"><button type=\"button\" style=\"background-color: lightgray; border-radius: 10px; width: 200px; height:30px;\">");
                   out.println(s2 + "  -  "+ s1);
                   out.println("</button></a");
                   out.println("<br><br>");
                    
                }
                  
                   out.println("</body>");
                   out.println("</div></center>");
                   out.println("</html>");
                   out.println("<br><br>");
                   out.println("<h4><a href=\"student_home.jsp\"><a href=\"index.jsp\"><button type=\"button\" style=\"background-color: aquamarine; border-radius: 10px;width: 100px;height:30px;\">Home</button></a><h4>");
            
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(showDepts.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(showDepts.class.getName()).log(Level.SEVERE, null, ex);
        }
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
