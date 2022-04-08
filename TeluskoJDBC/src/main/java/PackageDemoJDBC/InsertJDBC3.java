// for dynamic insertion
// for insertion of multiple records together

package PackageDemoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertJDBC3 {

	public static void main(String[] args) throws Exception {

		String url = "jdbc:mysql://localhost:3306/demo";
		String uname = "root";
		String pwd = "root";

		int enrollment_no = 17;
		String student_name = "Raj";
		String department = "Auto";
		String query = "INSERT INTO student VALUES(?, ?, ?)";

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, uname, pwd);
		PreparedStatement st = conn.prepareStatement(query);
		/* PreparedStatement for multiple records (where preparedStatement() used) */
		st.setInt(1, enrollment_no);
		st.setString(2, student_name);
		st.setString(3, department);
		int count = st.executeUpdate(); // no need to pass query here

		System.out.println(count + " row affected");
		st.close();
		conn.close();
	}

}
