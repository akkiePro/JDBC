package PackageDemoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Testing {
	int enrollment;
	String student_name;
	String department_name;

	public static void main(String[] args) {
		StudentDAOTest dao = new StudentDAOTest();

		System.out.println("from DB roll no. 5 is...");
//		StudentTest s1 = dao.getStudent(5);
		Testing t1 = dao.getStudent(5);
		System.out.println(t1.student_name);

		System.out.println("from DB roll no. 8 is...");
//		StudentTest s2 = dao.getStudent(8);
		Testing t2 = dao.getStudent(8);
		System.out.println(t2.student_name);
	}

}

class StudentDAOTest {
	public Testing getStudent(int roll) {
		try {
			String query = "SELECT name FROM student WHERE enroll=" + roll;
//			StudentTest s = new StudentTest();
			Testing obj = new Testing();
			obj.enrollment = roll;

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/demo", "root", "root");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			rs.next();
			String name = rs.getString(1);
			obj.student_name = name;
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

/*
 * class StudentTest { int enrollment; String student_name; String
 * department_name; }
 */