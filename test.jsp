<%@ page language="java" contentType="text/html; charset=UTF-8" import = "java.sql.*"
    pageEncoding="UTF-8" session="true" %>
    
    
    <!DOCTYPE html>
<html>
  <head>
    <title>Pharmacy Admin Homepage</title>
 <link rel="stylesheet" type="text/css" href="./stylesHome.css">
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
    <header>
 <img src="logo.png" alt="My Pharmacy logo">
 <div class="container">
      <nav>
        <ul>
          <li><a href="./AdminHome.jsp">Home</a></li>
          <li><a href="./AddMedicine.jsp">Add Medicine</a></li>
          <li><a href="./DeleteMedicine.jsp">Delete Medicine</a></li>
          <li><a href="./SearchMedicine.jsp">Search Medicine</a></li>
          <li><a href="./UpdateMedicine.jsp">Update Medicine</a></li>
          <li><a href="./ViewAllMedicine.jsp">View All Medicine</a></li>
           <li><a href="./ViewAllOrders.jsp">View All Orders</a></li>
            <form action="Logout" method="get" id="Logout">
            <input type="submit" value="Logout" ">
    </form>
        </ul>
      </nav>
</div>
    </header>
    <main>
      <h1>Welcome to the Pharmacy Admin Dashboard</h1>
      <p>Here you can manage orders, update inventory, and more.</p>
    </main>
    <footer>
      <p>2023 Pharmacy. All rights reserved.</p>
    </footer>
  </body>
</html>
</body>
</html>
<%
}
%>