package test;

import javax.sql.rowset.*;

public class DBCon14 {
	public static void main(String [] args)
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			JdbcRowSet jrs=RowSetProvider.newFactory().createJdbcRowSet();
			jrs.setUrl("jdbc:oracle:thin:@localhost:1522:XE");
			jrs.setUsername("c##sai");
			jrs.setPassword("1606");
			jrs.setCommand("select * from product");
			jrs.execute();//executing the query
			System.out.println("========display db table in reverse order");
			jrs.afterLast();
			while(jrs.previous())
		    {
				System.out.println(jrs.getString(1)+"\t"+jrs.getString(2)+"\t"+jrs.getString(3)+"\t"+jrs.getInt(4)+"\t"+jrs.getInt(5));
		    }
			jrs.close();
			}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
