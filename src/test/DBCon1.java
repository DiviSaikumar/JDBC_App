package test;
import java.sql.*;
import java.sql.DriverManager;

public class DBCon1 {
	public static void main(String [] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1522:XE","c##sai","1606");
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery("select * from book");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4));
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
