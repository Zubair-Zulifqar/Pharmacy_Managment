<%@ page language="java" contentType="text/html; charset=UTF-8" import = "java.sql.*"
    pageEncoding="UTF-8" session="true" %>
    
    
    <!DOCTYPE html>
<html>
<head>
  
  <link rel="stylesheet" type="text/css" href="./stylesHome.css">
  <title>My Pharmacy</title>
</head>
  
  
<%
String str = "type";
String type= (String)session.getAttribute(str);

if(type==null)
response.sendRedirect("./login.html");


if(type=="admin")
response.sendRedirect("./AdminHome.jsp");
else
{
%>


 <body>
  <header>
   
      <img src="logo.png" alt="My Pharmacy logo">
 <div class="container">
      <nav>
        <ul>
        <li><a href="./SimpleHome.jsp">Home</a></li>
          <li><a href="./ViewAllMedicine.jsp">Veiw All Medicine</a></li>
           <li><a href="./SearchMedicine.jsp">Search Medicine</a></li>
             <li><a href="./PlaceOrder.jsp">Place Order</a></li>
          <li><a href="./ViewMyOrders.jsp">Veiw My Orders</a></li>
            <form action="Logout" method="get" id="Logout">
            <input type="submit" value="Logout" ">
    </form>
        </ul>
      </nav>
    </div>
  </header>
  <main>
    <section id="hero">
      <div class="container">
        <h1>Your Health, Our Priority</h1>
        <p>My Pharmacy is dedicated to providing high-quality and affordable healthcare to our community. Visit us today for all of your pharmaceutical needs.</p>
      </div>
    </section>
    <section id="services">
      <div class="container">
        <h2>Our Services</h2>
        <ul>
          <li>Prescription Medication</li>
          <li>Over-the-Counter Drugs</li>
          <li>Medical Supplies</li>
          <li>Vaccinations</li>
          <li>Health & Wellness Products</li>
        </ul>
        <p>Our knowledgeable staff is always here to answer any questions you may have and assist you in finding the best products for your health and wellness needs.</p>
      </div>
    </section>
    <section id="about">
      <div class="container">
        <h2>About Us</h2>
        <p>My Pharmacy is a locally-owned and operated business serving the community for over 20 years. We believe in putting our customers first and are committed to providing personalized and compassionate care.</p>
       
      </div>
    </section>
    <section id="contact">
      <div class="container">
        <h2>Contact Us</h2>
        <ul>
          <li>Address: 123 Main Street, Anytown, USA</li>
          <li>Phone: (555) 555-5555</li>
          <li>Email: info@mypharmacy.com</li>
        </ul>
        <p>We are open Monday through Friday from 9am to 6pm and Saturday from 9am to 1pm. Call us today to schedule an appointment or to speak with a member of our team.</p>
      </div>
    </section>
  </main>
  <footer>
    <div class="container">
      <p>Copyright &copy; 2023 My Pharmacy</p>
    </div>
  </footer>
 
<% 
}
%>