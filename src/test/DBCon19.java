package test;
import java.sql.*;
import javax.sql.rowset.*;
import javax.sql.*;
public class DBCon19 {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
         	Connection con = DriverManager.getConnection
         			("jdbc:oracle:thin:@localhost:1522:XE","c##sai","1606");
         	
         	DatabaseMetaData dmd=con.getMetaData();
         	System.out.println("DriverVersion:"+dmd.getDriverVersion());
         	System.out.println(+dmd.getDatabaseMajorVersion());
         	
         	
         	PreparedStatement ps=con.prepareStatement
         			("select * from book where bcode=?");
         	ps.setString(1,"");
         	ParameterMetaData pmd=ps.getParameterMetaData();
         	System.out.println("Parameter Count"+pmd.getParameterCount());
         	
         	
         	ResultSet rs=ps.executeQuery();
         	ResultSetMetaData rmd=rs.getMetaData();
         	System.out.println("column count"+rmd.getColumnCount());
         	
         	JdbcRowSet jrs=RowSetProvider.newFactory().createJdbcRowSet();
         	jrs.setUrl("jdbc:oracle:thin:@localhost:1522:XE");
         	jrs.setUsername("c##sai");
         	jrs.setPassword("1606");
         	jrs.setCommand("select * from product");
         	jrs.execute();
         	RowSetMetaData rmd1=(RowSetMetaData)jrs.getMetaData();
         	System.out.println(rmd1.getColumnCount());
         	con.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
