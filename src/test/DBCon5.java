package test;
import java.sql.*;
import java.util.*;

public class DBCon5 {
	public static void main(String [] args)
	{
		try
		{
			Scanner s=new Scanner(System.in);
			System.out.println("enter the book code");
			String bcode=s.nextLine();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1522:XE","c##sai","1606");
			PreparedStatement ps=con.prepareStatement
					("select * from book where bcode=?");//only query compiling done
			ps.setString(1, bcode);
			ResultSet rs=ps.executeQuery();//Query Executed
			if(rs.next())
			{
				PreparedStatement ps1=con.prepareStatement("update book set bprice=? where bcode=?");
				System.out.println("old book price is:"+rs.getFloat(4));
				System.out.println("enter the new book price:");
				Float newBprice=s.nextFloat();
				ps1.setString(2, bcode);
				ps1.setFloat(1, newBprice);
				int k=ps1.executeUpdate();
				if(k>0)
				{
					System.out.println("Book Price updated successfully...!!!A");
				}
			}else
			{
				System.out.println("invalid Query....!!");
			}
			s.close();
			con.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
