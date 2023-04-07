package MyPack;
import java.io.*; 
public class MedicineData implements Serializable{ 

private int Amount; 
private String Mname; 


// no argument constructor 
public MedicineData() { 
Amount = 0; 
Mname = ""; 

} 

// setters 
public void setAmount(int p){ 
 Amount = p; 
} 

public void setMname(String c){ 
 Mname = c; 
} 


 
// getters 
public int getAmount( ){ 
 return Amount; 
} 

public String getMname( ){ 
 return Mname; 
} 


} // end class 

