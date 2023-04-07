import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.swing.*;


public class PlaceOrder extends HttpServlet {
  
 
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
	response.setContentType("text/html");
    HttpSession sess=request.getSession(false);

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
    PreparedStatement pst=con.prepareStatement("Select * from medicine",  ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
    PreparedStatement ost=con.prepareStatement( "Select * from orders",   ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
  	ResultSet rs = pst.executeQuery(); 
     
  	 String mid=null;
     String pid=null;
     String orderamount=null;
     String customerpass=(String)sess.getAttribute("password");
     String Infoquery = "Select * FROM info WHERE password='"+ customerpass + "'";
    
     
     
      int check1=0,check2=0;
     while(rs.next()){
                String rsname = rs.getString("Mname");
               int rsamount=Integer.parseInt(rs.getString("Amount"));
                if(rsname.equals(name))
                {
                	if(rsamount>=amount) {
                  rsamount-=amount;
                	
                   mid=rs.getString("Mid");
                   orderamount=Integer.toString(amount);
                   rs.updateString("Amount", Integer.toString(rsamount));
               	  rs.updateRow();
                	  check1=1;
                      break;
                	}
                	else {
                		out.println("<h1>Out Of Stock error </h1>"); 
                	 check2=1;
                     break;
                	}
                }
               
            }
       if(check1==0 && check2==0){
    	   out.println("<h1>Medicine not found </h1>"); 
       }
       else {
       
      ResultSet r = st.executeQuery( Infoquery );
 
if(r.next() && check2==0 ) {
	pid=r.getString("ID");
	ResultSet ors = ost.executeQuery();
	ors.moveToInsertRow();
	 ors.updateString("Mid",mid);
	 ors.updateString("Pid",pid);
	 ors.updateString("PurchaseAmount",orderamount);
		ors.insertRow();

	 out.println("<h1>Order Placed </h1>"); 
}
else {
	 out.println("<h1>Invalid Data </h1>"); 
}
    
       }
       out.println("</body></html>");

           st.close();
           con.close();

    }catch(Exception e){

      out.println(e);
    }

  }

}
