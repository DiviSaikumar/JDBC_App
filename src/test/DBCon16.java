package test;
import java.sql.*;

public class DBCon16 {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1522:XE","c##sai","1606");
			Statement stm=con.createStatement();
			stm.addBatch("insert into book values('A127','node-js','vikram',987,18)");
			stm.addBatch("insert into product values('A125','web-cam',2678,5)");
			stm.addBatch("update product set pprice=12675 where pcode='A124'");
			int k[]=stm.executeBatch();//batch is executed
			for(int i=0;i<k.length;i++)
			{
				System.out.println("Execution completed....!!!!");
			}
			stm.clearBatch();
			con.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
