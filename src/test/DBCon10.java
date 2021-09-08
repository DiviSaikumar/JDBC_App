package test;
import java.util.*;
import java.sql.*;

public class DBCon10 {

	public static void main(String[] args) {
		try {
			Scanner s=new Scanner(System.in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1522:XE","c##sai","1606");
			PreparedStatement ps=con.prepareStatement("insert into customer values(?,?,?)");
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
				ps.setString(1, cusId);
				ps.setString(2, cusName);
				ps.setString(3, cusAddr);
				int k=ps.executeUpdate();
				if(k>0)
				{
					System.out.println("inserting is completed");
					
				}

			}
			s.close();
			con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}

	}

}
