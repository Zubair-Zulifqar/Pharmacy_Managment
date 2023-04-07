import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class AddMedicine extends HttpServlet {
  
 
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
	response.setContentType("text/html");
    

	PrintWriter out = response.getWriter();

    String name=request.getParameter("medicine_name");
    int amount=Integer.parseInt(request.getParameter("amount"));


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
     

     String Insertquery = "INSERT INTO medicine(Mname,Amount)VALUES('"+ name + "','" + amount+ "')";

    
     System.out.println(Insertquery);
      int check=0;
     while(rs.next()){
                String rsname = rs.getString("Mname");
               int rsamount=Integer.parseInt(rs.getString("Amount"));
                if(rsname.equals(name))
                {
                  rsamount+=amount;
                 
                  rs.updateString("Mname",rsname);
                  rs.updateString("Amount", Integer.toString(rsamount));
                 
              	  rs.updateRow();
              	out.println("<h1>medicine has been enter </h1>"); 
                	  check=1;
                      break;

                }
               
            }
       if(check==0){
      int r = st.executeUpdate( Insertquery );
 

     if(r==1){	out.println("<h1>medicine has been entered </h1>"); 
                 }
	else{	out.println("<h1>medicne not enteerd</h1>"); 		}

    
}
       out.println("</body></html>");

           st.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }

  }

}
