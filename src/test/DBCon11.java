package test;

import java.sql.*;
import java.util.*;

public class DBCon11 {

	public static void main(String[] args) {
		try {
			Scanner s=new Scanner(System.in);

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1522:XE","c##sai","1606");
			System.out.println("enter the empid value");
			String empid=s.nextLine();
			System.out.println("enter the empname");
			String empname=s.nextLine();
			System.out.println("enter the empdesg");
			String empdesg=s.nextLine();
			System.out.println("enter the empAddress");
			String empaddress=s.nextLine();
			System.out.println("enter the phoneno");
			long phno=Long.parseLong(s.nextLine());
			System.out.println("enter the mailid");
			String mid=s.nextLine();
			System.out.println("enter the bsal");
			int bsal=Integer.parseInt(s.nextLine());
			float totsal=bsal+(0.93f*bsal)+(0.63f*bsal);
			CallableStatement cs=con.prepareCall
					("{call empdetails(?,?,?,?,?,?,?,?)}");
			cs.setString(1,empid);
			cs.setString(2, empname);
			cs.setString(3, empdesg);
			cs.setString(4, empaddress);
			cs.setLong(5, phno);
			cs.setString(6, mid);
			cs.setInt(7, bsal);
			cs.setFloat(8, totsal);
			cs.execute();
			System.out.println("empdetails inserted successfully");
			s.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
