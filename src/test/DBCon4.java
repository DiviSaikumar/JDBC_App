//retrieving values based on bcode
package test;
import java.sql.*;
import java.util.*;


public class DBCon4 {
	public static void main(String [] args)
	{
		try {
			Scanner s=new Scanner(System.in);
			System.out.println("enter the book code");
			String bcode=s.nextLine();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1522:XE","c##sai","1606");
			PreparedStatement ps=con.prepareStatement("select * from book where bcode=?");
			ps.setString(1, bcode);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
			}
			else
			{
				System.out.println("selected query is invalid");
			}
			s.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
