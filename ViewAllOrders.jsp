<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*, java.sql.*, javax.swing.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="./stylesHome.css">
 <style>
         table {
            border: 1px solid black;
         }
         th, td {
            border: 1px solid black;
            padding: 8px;
         }
      </style>
<meta charset="UTF-8">
<title>View All orders</title>
</head>
<%
String str = "type";
String type= (String)session.getAttribute(str);

if(type==null)
response.sendRedirect("./login.html");

if(type=="user")
response.sendRedirect("./SimpleHome.jsp");
else
{
%>
 <body>
 <h2>View Medicines</h2>
  <table>
  <tr>
  <th>Customer Name</th>
    <th>Email-of-customer</th>
    <th>Medicine Name</th>
    <th>Amount</th>
    
  </tr>
<%
try{

Class.forName("com.mysql.jdbc.Driver");

String url = "jdbc:mysql://127.0.0.1/class_test";

Connection con=DriverManager.getConnection(url, "root", "root");


PreparedStatement pst=con.prepareStatement("SELECT *FROM info INNER JOIN orders ON info.ID = orders.Pid INNER JOIN medicine ON orders.Mid = medicine.Mid;",			ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE); 
ResultSet rs = pst.executeQuery(); 
	
  int check=0;
 while(rs.next()){
            String rsname = rs.getString("username");
          String rsamount=rs.getString("PurchaseAmount");
          String rsemail=rs.getString("email");
          String rsmname=rs.getString("Mname");
          %>
          
  <tr>
    <td><%= rsname %></td>
    <td><%= rsemail %></td>
    <td><%= rsmname %></td>
    <td><%= rsamount %></td>
  </tr>

        <%
        }
 %>    
            </table>
           
      <% 

       pst.close();
       con.close();

}catch(Exception e){

  out.println(e);
}

}
%>

</body>
</html>