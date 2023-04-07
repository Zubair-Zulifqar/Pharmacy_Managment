<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Medicine</title>
<link rel="stylesheet" type="text/css" href="./stylesHome.css">
<script>
  function validate(){
 
name = document.getElementById("medicine_name").value;
Amount = document.getElementById("amount").value;
if(parseInt(Amount) <=0){
    alert("give amount larger then 0");
    return false;
}

if(Amount == ""){
        alert("amount of medicine is required");
       return false;
    }
else if(username == ""){
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
 <h2>Add Medicine</h2>
    <form action="AddMedicine" method="post" id="AddMedicines">
      <label for="medicine_name">Medicine Name:</label>
      <input type="text" id="medicine_name" name="medicine_name" required>
      <br><br>
      <label for="amount">Amount:</label>
       <input id="amount" name="amount" type="text" >
      <br><br>
      <input type="submit" value="Add Medicine" onclick="return validate()">
    </form>
    <hr>
</body>
</html>
<%
}
%>
