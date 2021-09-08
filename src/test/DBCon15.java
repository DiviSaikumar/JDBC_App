//JDBC application using functions by Callable-statement
package test;
import java.util.*;
import java.sql.*;
public class DBCon15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner s=new Scanner(System.in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1522:XE","c##sai","1606");
			System.out.println("enter the bookcode");
			String bcode=s.nextLine();
			CallableStatement cs=con.prepareCall
					("{call ? := priceretrieve(?)}");
			cs.registerOutParameter(1, Types.FLOAT);
			cs.setString(2, bcode);
			cs.execute();
			System.out.println("bookprice = "+cs.getFloat(1));
			s.close();
			con.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
