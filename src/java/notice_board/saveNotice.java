
package notice_board;

import com.mysql.cj.protocol.Resultset;
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
import javax.servlet.http.HttpSession;

public class saveNotice extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("hodid");
        
        String title = request.getParameter("title");
        String msg = request.getParameter("message");
        java.util.Date dt = new java.util.Date();
        long ts = dt.getTime();
        java.sql.Date postDate = new java.sql.Date(ts);
        
        try(PrintWriter out = response.getWriter();){
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/notice_board?useSSL=false","root","qwerty");
                PreparedStatement ps1 = con.prepareCall("select max(notice_id) from notices");
                ResultSet rs = ps1.executeQuery();
                rs.next();
                int lastId = rs.getInt(1);
                int newId = 1;
                if(lastId!=0)
                {
                    newId=lastId+1;
                }
                
                PreparedStatement ps2 = con.prepareStatement("insert into notices values(?,?,?,?,?)");
                ps2.setInt(1,newId);
                ps2.setString(2,title);
                ps2.setString(3, msg);
                ps2.setString(4,id);
                ps2.setDate(5,postDate);
                
                ps2.executeUpdate();
                
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>notice post </title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<center><h3 style=\"background-color:powderblue;\">Vellore Institute of Technology , vellore</h3><hr><br></center>");
                out.println("<center><h3>Notice posted successully </h3><br>");
                out.println("<h4><a href=noticepost.jsp><button type=\"button\" style=\"background-color: lightcyan; border-radius: 10px;width: 200px;height:30px;\">Post another notice</button></a></h4></center><br>");
                out.println("<br><br><br><h4><a href=hod_home.jsp><button type=\"button\" style=\"background-color: aquamarine; border-radius: 10px;width: 100px;height:30px;\">Home</button></a></h4>");
                out.println("</body>");
                out.println("</html>");
                
                con.close();
            }catch(Exception e)
            {e.printStackTrace();}
        
          /* TODO output your page here. You may use following sample code.*/
            
            
        
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
