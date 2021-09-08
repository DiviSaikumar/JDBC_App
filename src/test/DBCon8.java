package test;
import java.sql.*;
import java.util.*;

public class DBCon8 {
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

				System.out.println("old number="+rs.getString(5));
				System.out.println("enter new address");
				String newAdd=s.nextLine();
				System.out.println("old phone number="+rs.getString(6));
				System.out.println("enter the new phone number");
				Long newPhno=Long.parseLong(s.nextLine());
				PreparedStatement ps1=con.prepareStatement
						("update UserReg set addr=?,phno=? where uname=? and  pword=? ");
				ps1.setString(1, newAdd);
				ps1.setLong(2, newPhno);
				ps1.setString(3, uname);
				ps1.setString(4, pword);
				int k=ps1.executeUpdate();
				if(k>0)
				{
					System.out.println("address and pone number has updated succcessfully....!!");
				}
			}
			else
			{
				System.out.println("invalid username/password");
			}
			con.close();
			s.close();
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}
}
