package test;
import java.sql.*;
import java.util.*;
public class DBCon2 {
	public static void main(String [] args)
	{
		try {
			Scanner s=new Scanner(System.in);
			System.out.println("enter the book code");
			String bcode=s.nextLine();
			System.out.println("enter the book name");
			String bname=s.nextLine();
			System.out.println("enter the author name");
			String bauthor=s.nextLine();
			System.out.println("enter the book price");
			int bprice=Integer.parseInt(s.nextLine());
			System.out.println("enter the book quantity");
			int bqty=Integer.parseInt(s.nextLine());
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1522:XE","c##sai","1606");
			PreparedStatement ps=con.prepareStatement
					("insert into book values(?,?,?,?,?)");
			ps.setString(1, bcode);
			ps.setString(2, bname);
			ps.setString(3, bauthor);
			ps.setInt(4, bprice);
			ps.setInt(5, bqty);
			int k=ps.executeUpdate();
			if(k>0)
			{
				System.out.println("Book details inserted successfuly");
			}
			s.close();
			con.close();
			}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
