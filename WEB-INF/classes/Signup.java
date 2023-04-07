import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class Signup extends HttpServlet {
  
 
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
    

	PrintWriter out = response.getWriter();

    String name=request.getParameter("username");
    String email=request.getParameter("email");
    String password=request.getParameter("password");

    out.println("<html>");
    out.println("<head><title>Response</title></head>");
    out.println("<body bgcolor=\"#dddddd\">");


    try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/class_test";

    Connection con=DriverManager.getConnection(url, "root", "root");

    Statement st=con.createStatement();

      String Resultsetquery="Select * from info ";

            ResultSet rs = st.executeQuery( Resultsetquery );

     String Insertquery = "INSERT INTO info(username,email,password)VALUES('"+ name + "','" + email+ "','"+password+"')";

     System.out.println(Resultsetquery);
     System.out.println(Insertquery);
      int check=0;
     while(rs.next()){

                String demail = rs.getString("email");
                String dpassword = rs.getString("password");
                if(email.equals(demail))
                {
                  
                        out.println("<h1>alraedy used email</h1>");
                        out.println("<a href=\"./signup.html\">Retry</a>");
                        check=1;
                          break;
                    

                }
                if(password.equals(dpassword))
                {
                  
                        out.println("<h1>alraedy used password</h1>");
                        out.println("<a href=\"./signup.html\">Retry</a>");
                        check=1;
                          break;
                    

                }
            }
       if(check==0){
      int r = st.executeUpdate( Insertquery );
 

     if(r==1){	out.println("<h1>Account has been Created</h1>"); 
     String str = "type";
     HttpSession session = request.getSession(true);
     session.setAttribute(str, "user");
     session.setAttribute("password",password);;
     response.sendRedirect("./SimpleHome.jsp");
                 }
	else{	out.println("<h1>Account cannot be created</h1>"); 		}

     out.println("</body></html>");
}

           st.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }

  }

}
