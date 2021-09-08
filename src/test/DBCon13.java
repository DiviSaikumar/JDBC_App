//program on scrollable objects
package test;
import java.sql.*;
public class DBCon13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1522:XE","c##sai","1606");
			Statement stm=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs1=stm.executeQuery("select * from emp");
			System.out.println("display table data in reverse...!!!");
			rs1.afterLast();//moving the cursor after the last-row
			while(rs1.previous())
			{
				System.out.println(rs1.getInt(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+rs1.getString(4));
			}
			PreparedStatement ps=con.prepareStatement("select * from book",1004,1007);
			ResultSet rs2=ps.executeQuery();
			System.out.println("==============book details at row number 3===============");
			rs2.absolute(3);
			
				System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t"+rs2.getInt(4)+"\t"+rs2.getInt(5));
				System.out.println("=============printing book details in middle===============");
				rs2.relative(-2);
				
				System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t"+rs2.getInt(4)+"\t"+rs2.getInt(5));

			con.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
