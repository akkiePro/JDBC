package PackageDemoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertJDBC2 {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/demo";
		String uname = "root";
		String pwd = "root";

		int enrollment_no = 8;
		String student_name = "Nidhi";
		String department = "EC";
		String query = "INSERT INTO student VALUES('" + enrollment_no + "', '" + student_name + "', '" + department
				+ "')";

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, uname, pwd);
		Statement st = conn.createStatement();

		int count = st.executeUpdate(query);

		System.out.println(count + " row affected");
		st.close();
		conn.close();
	}

}
