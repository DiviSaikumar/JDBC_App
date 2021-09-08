package test;
import java.util.*;
import java.sql.*;
public class DBCon7 {
	public static void main(String [] args)
	{
		try {
			Scanner s=new Scanner(System.in);
			System.out.println("enter the user name");
			String uname=s.nextLine();
			System.out.println("enter the password");
			String pword=s.nextLine();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1522:XE","c##sai","1606");
			PreparedStatement ps=con.prepareStatement
					("select * from UserReg where uname=? and pword=?");
			ps.setString(1, uname);
			ps.setString(2, pword);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) 
			{
				System.out.println("Login Successfull...!!!");
				System.out.println("welcome.."+rs.getString(4));
			}
			else
			{
				System.out.println("invalid username...!!!");
			}
			con.close();
			s.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
