//JDBC app on transaction
package test;
import java.util.*;
import java.sql.*;
public class DBCon18 {
	public static void main(String[] args) {
         try {
        	 Scanner s = new Scanner(System.in);
        	 Class.forName("oracle.jdbc.driver.OracleDriver"); 
         	Connection con = DriverManager.getConnection
         			("jdbc:oracle:thin:@localhost:1522:XE","c##sai","1606");
         	PreparedStatement ps1 = con.prepareStatement
         			("select * from Bank where accno=?");
         	PreparedStatement ps2 = con.prepareStatement
         			("update Bank set bal=bal+? where accno=?");	
         	
         	con.setAutoCommit(false);//stopping Auto Commit operation
         	Savepoint sp = con.setSavepoint();//Save point for roll back
         	
         	System.out.println("Enter the HomeAccNo:");
         	long hAccNo = s.nextLong();
         	ps1.setLong(1, hAccNo);
         	ResultSet rs1 = ps1.executeQuery();
         	if(rs1.next()) {
         	float balance = rs1.getFloat(3);	
         	System.out.println("Enter the beneficery accNo:");
         	long bAccNo = s.nextLong();
         	ps1.setLong(1,bAccNo);
         	ResultSet rs2 = ps1.executeQuery();
         	if(rs2.next()) {
         		System.out.println("Enter the amount to be transferred:");
         		int amt = s.nextInt();
         		if(amt<=balance) {
         			
         			ps2.setFloat(1,-amt);
         			ps2.setLong(2,hAccNo);
         			int i = ps2.executeUpdate();
         		
         			ps2.setFloat(1,amt);
         			ps2.setLong(2,bAccNo);
         			int j = ps2.executeUpdate();
         			
         			if(i==1 && j==1) {
         				System.out.println("Transaction Completed...");
         				con.commit();
         			}else {
         				System.out.println("Transaction failed....");
         				con.rollback(sp);
         			}
         		
         		 }else {
         			 System.out.println("Insuffient fund...");
         		 }
            	}else {
         	        System.out.println("Invalid beneficery AccNo...");	
            	}
         	}else {
         		System.out.println("Invalid HomeAccNo....");
         	}
         	con.close();
        	 s.close();
         }catch(Exception e) {
        	 System.out.println(e.getMessage());
         }
	}

}
