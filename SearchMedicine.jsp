<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Medicine</title>
<link rel="stylesheet" type="text/css" href="./stylesHome.css">
<script>
  function validate(){
 
name = document.getElementById("medicine_name").value;

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


else
{
%>

<body>
 <h2>Search Medicine</h2>
    <form action="SearchMedicine" method="post" id="SearchMedicine">
      <label for="medicine_name">Medicine Name:</label>
      <input type="text" id="medicine_name" name="medicine_name">
      <br><br>
      <input type="submit" value="Search Medicine" onclick="return validate()">
    </form>
    <hr>

</body>
<%
}
%>
</html>