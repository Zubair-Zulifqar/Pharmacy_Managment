import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class Logout extends HttpServlet {
  
 
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
	response.setContentType("text/html");
    
HttpSession sess=request.getSession(false);
sess.invalidate();
response.sendRedirect("login.html");
	


  }

}
