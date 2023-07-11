package onBuy.com.practice;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class InsertJDBC {

	public static void main(String[] args) throws Throwable {
		Connection conn=null;
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			conn=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			Statement st = conn.createStatement();
			String Query="insert into project values('TY_PROJ_1133','Dharmendra','29/06/2023','Kshrugal 2.0','completed','6')";
			int result=st.executeUpdate(Query);
			if(result==1)
			{
				System.out.println("Data is Created");
			}
			else {
				System.out.println("Data is not created");
			}
		} finally {
			conn.close();
		}
	}

}
