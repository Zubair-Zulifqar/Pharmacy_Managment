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
<title>View all Medicine</title>
</head>
<%
String str = "type";
String type= (String)session.getAttribute(str);

if(type==null)
response.sendRedirect("./login.html");


else
{
%>
 <body>
 <h2>View Medicines</h2>
  <table>
  <tr>
    <th>Medicine Name</th>
    <th>Amount</th>
    
  </tr>
<%
try{

Class.forName("com.mysql.jdbc.Driver");

String url = "jdbc:mysql://127.0.0.1/class_test";

Connection con=DriverManager.getConnection(url, "root", "root");


PreparedStatement pst=con.prepareStatement("Select * from medicine",			ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	ResultSet rs = pst.executeQuery(); 
	
  int check=0;
 while(rs.next()){
            String rsname = rs.getString("Mname");
          String rsamount=rs.getString("Amount");
          %>
          
  <tr>
    <td><%= rsname %></td>
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