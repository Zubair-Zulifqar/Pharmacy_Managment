<%@page import="java.util.*" %> 
<%@page import="MyPack.*" %>
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
<title>View My Orders</title>
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

<html> 
<body> 
<center> 
<h2> Your Orders</h2> 

<table border="1" > 

<tr> 
<th>Medicine Name</th> 
<th>Purchased Amount</th> 

</tr>
 
<% 
String pass=(String)session.getAttribute("password");
MedicineControler mc = new MedicineControler(); 
ArrayList medicinelist =mc.retrieveOrderList(pass); 
%>


<%
MedicineData mBean = null; 

for(int i=0; i<medicinelist.size(); i++){ 
 mBean = (MedicineData)medicinelist.get(i); 
%> 

<tr> 
<td> <%= mBean.getMname()%> </td> 
<td> <%= mBean.getAmount()%> </td> 
</tr> 

<%
} 
}
%> 

</table>
</center> 
</body>
</html>