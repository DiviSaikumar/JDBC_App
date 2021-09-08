//JDBC app using addBatch method by prepared Statement
package test;
import java.sql.*;
public class DBCon17 {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1522:XE","c##sai","1606");
			PreparedStatement ps=con.prepareStatement
					("insert into product values(?,?,?,?)");//compilation is completed
			ps.setString(1, "A126");
			ps.setString(2, "cables");
			ps.setInt(3, 300);
			ps.setInt(4, 15);
			ps.addBatch();
			
			ps.setString(1, "A127");
			ps.setString(2, "hard-disk");
			ps.setInt(3, 5000);
			ps.setInt(4, 1);
			ps.addBatch();
			
			ps.setString(1, "A128");
			ps.setString(2, "cd-drive");
			ps.setInt(3, 3765);
			ps.setInt(4, 3);
			ps.addBatch();
			
			int k[]=ps.executeBatch();
			for(int i=0;i<k.length;i++)
			{
				System.out.println("Execution completed...!!!");
			}
			ps.clearBatch();
			con.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
