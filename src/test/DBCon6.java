package test;
import java.sql.*;
import java.util.*;

public class DBCon6 {
	public static void main(String [] args)
	{
		try {
			Scanner s=new Scanner(System.in);
			System.out.println("enter the user name");
			String uname=s.nextLine();
			System.out.println("enter the password");
			String pword=s.nextLine();
			System.out.println("enter the first name");
			String fname=s.nextLine();
			System.out.println("enter the last name");
			String lname=s.nextLine();
			System.out.println("enter the address");
			String addr=s.nextLine();
			System.out.println("enter the phone number");
			Long phno=Long.parseLong(s.nextLine());
			System.out.println("enter the email id");
			String mid=s.nextLine();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1522:XE","c##sai","1606");
			PreparedStatement ps=con.prepareStatement
					("insert into UserReg values(?,?,?,?,?,?,?)");
			ps.setString(1, uname);
			ps.setString(2, pword);
			ps.setString(3, fname);
			ps.setString(4, lname);
			ps.setString(5, addr);
			ps.setLong(6, phno);
			ps.setString(7, mid);
			int k=ps.executeUpdate();
			if(k>0)
			{
				System.out.println("insertion successfull...!!");
			}
			con.close();
			s.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
