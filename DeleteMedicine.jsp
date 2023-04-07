<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Medicine</title>
<link rel="stylesheet" type="text/css" href="./stylesHome.css">
<script>
  function validate(){
 
name = document.getElementById("Name").value;
 if(name == ""){
        alert(" name of medicine is required");
       return false;
    }


 }

</script>
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
 <h2>Delete Medicine</h2>
    <form action="DeleteMedicine" method="post" id="DeleteMedicine">
      <label for="Name">Medicine Name:</label>
      <input type="text" id="Name" name="Name" required>
      <br><br>
      <input type="submit" value="Delete Medicine" onclick="return validate()">
    </form>
    <hr>
</body>
<%
}
%>
</html>