package test;
import java.sql.*;
import java.util.*;
public class DBCon12 {

	public static void main(String[] args) {

		try {
			Scanner s=new Scanner(System.in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1522:XE","c##sai","1606");
			System.out.println("enter the empid");
			String empid=s.nextLine();
			CallableStatement cs=con.prepareCall
					("{call empretrieve(?,?,?,?,?,?,?,?)}");
			cs.setString(1, empid);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.BIGINT);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.registerOutParameter(8, Types.FLOAT);
			cs.execute();
			System.out.println("emId:"+empid);
			System.out.println("empName:"+cs.getString(2));
			System.out.println("emDesg:"+cs.getString(3));
			System.out.println("empAddress:"+cs.getString(4));
			System.out.println("empPhno:"+cs.getLong(5));
			System.out.println("empMid:"+cs.getString(6));
			System.out.println("empBsal:"+cs.getInt(7));
			System.out.println("empTotsal:"+cs.getFloat(8));
			con.close();
			s.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
