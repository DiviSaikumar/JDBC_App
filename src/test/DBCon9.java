package test;
import java.util.*;
import java.sql.*;


public class DBCon9 {
	public static void main(String [] args)
	{
		try {
		Scanner s=new Scanner(System.in);
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection
				("jdbc:oracle:thin:@localhost:1522:XE","c##sai","1606");
		Statement stm=con.createStatement();
		System.out.println("enter the number of customers");
		int n=Integer.parseInt(s.nextLine());
		for(int i=1;i<=n;i++)
		{
			System.out.println("enter the cusId");
			String cusId=s.nextLine();
			System.out.println("enter the cusName");
			String cusName=s.nextLine();
			System.out.println("enter the cusAddr");
			String cusAddr=s.nextLine();
			int k=stm.executeUpdate
					("insert into customer values('"+cusId+"','"+cusName+"','"+cusAddr+"')");
			if(k>0)
			{
				System.out.println("inserting is completed");
				
			}
			else
			{
				System.out.println("entered details are wrong");
				
			}
		}
		s.close();
		con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
