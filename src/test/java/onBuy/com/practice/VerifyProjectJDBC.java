package onBuy.com.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class VerifyProjectJDBC {

	public static void main(String[] args) throws SQLException {
		Connection conn=null;
		String Proj_Name="Kshrugal 2.0";
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			conn=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			Statement st = conn.createStatement();
			String Query="Select * from project";
			ResultSet res = st.executeQuery(Query);
			boolean flag = false;
			while(res.next())
			{
				String data = res.getString(4);
				if(data.equalsIgnoreCase(Proj_Name))
				{
					System.out.println("Project is Created");
					flag=true;
					break;
				}
			}
			if(!flag) {
				System.out.println("Project is not Ctreated");
			}
		}finally {
			conn.close();
		}
	}

}
