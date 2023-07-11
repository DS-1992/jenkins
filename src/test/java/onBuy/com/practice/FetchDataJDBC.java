package onBuy.com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class FetchDataJDBC {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			conn=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			Statement st = conn.createStatement();
			String Query="Select * from project where created_by='dharmendra'";
			ResultSet res = st.executeQuery(Query);
			while(res.next())
			{
				String data = res.getString(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4)+" "+res.getString(5)+" "+res.getInt(6);
			System.out.println(data);
			}
		}
		finally {
			conn.close();
		}
	}

}
