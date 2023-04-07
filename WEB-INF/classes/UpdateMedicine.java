import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class UpdateMedicine extends HttpServlet {
  
 
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
	response.setContentType("text/html");
    

	PrintWriter out = response.getWriter();

    String name=request.getParameter("medicine_name");
    String amount=request.getParameter("amount");


    out.println("<html>");
    out.println("<head><title>Response</title></head>");
    out.println("<body bgcolor=\"#dddddd\">");


    try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/class_test";

    Connection con=DriverManager.getConnection(url, "root", "root");

    Statement st=con.createStatement();
    PreparedStatement pst=con.prepareStatement("Select * from medicine",			ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
  	ResultSet rs = pst.executeQuery(); 
     
      int check=0;
     while(rs.next()){
                String rsname = rs.getString("Mname");
               int rsamount=Integer.parseInt(rs.getString("Amount"));
                if(rsname.equals(name))
                {
                 
                  rs.updateString("Amount",amount);
                 
              	  rs.updateRow();
              	out.println("<h1>medicine has been updated </h1>"); 
                	  check=1;
                      break;

                }
               
            }
       if(check==0){
 	out.println("<h1>medicine not exist </h1>"); 

}
       out.println("</body></html>");

           st.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }

  }

}
