package MyPack;
import java.io.*; 
import java.sql.*; 
import java.util.*;

import javax.servlet.http.HttpSession; 

public class MedicineControler implements Serializable{ 

private Connection con; 

public MedicineControler() { 
establishConnection(); 
} 


private void establishConnection(){ 

try{ 
	
Class.forName("com.mysql.jdbc.Driver");

String url = "jdbc:mysql://127.0.0.1/class_test";

 con=DriverManager.getConnection(url, "root", "root");

}catch(Exception ex){ 
System.out.println(ex); 
} 

} 


public ArrayList retrieveOrderList(String Password){ 

ArrayList MedicineList = new ArrayList(); 

try{ 
String sql = "SELECT *  FROM info  INNER JOIN orders ON info.ID = orders.Pid  INNER JOIN medicine ON orders.Mid = medicine.Mid WHERE info.password='"+Password+"'"; 
Statement St = con.createStatement(); 
ResultSet rs=St.executeQuery(sql);

int amount; 
String name; 

 
while ( rs.next() ) { 
amount = rs.getInt("PurchaseAmount"); 
name = rs.getString("Mname"); 

System.out.println(amount+name);

MedicineData mBean = new MedicineData(); 
mBean.setAmount(amount); 
mBean.setMname(name);
 


MedicineList.add(mBean); 
} 

con.close();

}catch(Exception ex){ 
System.out.println(ex); 
}


return MedicineList; 

} 

}

