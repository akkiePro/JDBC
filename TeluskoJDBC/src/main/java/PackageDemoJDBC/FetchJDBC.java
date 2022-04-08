package PackageDemoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class FetchJDBC {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://localhost:3306/demo";
		String uname = "root";
		String pwd = "root";
		String query = "SELECT * FROM student";

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, uname, pwd);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			String userdata_from_db = rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3);
			System.out.println(userdata_from_db);
		}
		st.close();
		conn.close();
	}

}
