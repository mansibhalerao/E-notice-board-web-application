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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mansi
 */
public class NoticeBoard extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
                String id = request.getParameter("id");
             
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board?useSSL=false","root","qwerty");
                PreparedStatement ps1 = con.prepareStatement("select * from notices where uid=?");
                ps1.setString(1,id);
                
                ResultSet rs = ps1.executeQuery();
                   out.println("<!DOCTYPE html>");
                   out.println("<html>");
                   out.println("<body>");
                   out.println("<center><h3 style=\"background-color:powderblue;\">Vellore Institute of Technology , vellore</h3><hr><br></center>");
                   out.println("<center><h3>Notices</h3><br>");
                   out.println("<table  width=\"800\" height=\"150\" cellpadding=\"10\" bgcolor=\"whitesmoke\">");
                   out.println("<tr bgcolor=\"lightcyan\">");
                   out.println("<th>Id</th>");
                   out.println("<th>Title</th>");
                   out.println("<th>Message</th>");
                   out.println("<th>HOD</th>");
                   out.println("<th>Date Posted</th>");
                   out.println("<th>Reply</th>");
                   out.println("</tr>");
                while(rs.next())
                {
                   out.println("<tr>");
                   String s1 = rs.getString(1);//id
                   String s2 = rs.getString(2);//title
                   String s3 = rs.getString(3);//message
                   String s4 = rs.getString(4);//hod_id
                   String s5 = rs.getString(5);//date posted
                   
                   out.println("<td>"+s1+"</td>");
                   out.println("<td>"+s2+"</td>");
                   out.println("<td>"+s3+"</td>");
                   out.println("<td>"+s4+"</td>");
                   out.println("<td>"+s5+"</td>");
                   out.println("<td><a href=post_reply.jsp?id="+s1+"><button type=\"button\" style=\"background-color: aquamarine; border-radius: 10px;width: 100px;height:30px;\">Reply</button></a></td>");
                   out.println("</tr>"); 
                }
             
                   out.println("</table>");
                   out.println("</center>");
                   
                   out.println("<br><br>");
                   out.println("<hr>"); 
                   out.println("<h4><a href=showDepts><button type=\"button\" style=\"background-color: aquamarine; border-radius: 10px;width: 100px;height:30px;\">Back</button></a>");
                   out.println("<br><br>");
                   out.println("<a href=student_home.jsp><button type=\"button\" style=\"background-color: aquamarine; border-radius: 10px;width: 100px;height:30px;\">Home</button></a></h4>");
                   out.println("</body></html>"); 
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

