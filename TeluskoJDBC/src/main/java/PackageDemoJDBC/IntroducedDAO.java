package PackageDemoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class IntroducedDAO {

	public static void main(String[] args) {
		StudentDAO dao = new StudentDAO();

		System.out.println("from DB roll no. 5 is...");
		Student s1 = dao.getStudent(5);
		System.out.println(s1.student_name);

		System.out.println("from DB roll no. 8 is...");
		Student s2 = dao.getStudent(8);
		System.out.println(s2.student_name);
	}

}

class StudentDAO {
	public Student getStudent(int roll) {
		try {
			String query = "SELECT name FROM student WHERE enroll=" + roll;
			Student s = new Student();
			s.enrollment = roll;

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/demo", "root", "root");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);

			rs.next();
			String name = rs.getString(1);
			s.student_name = name;
			return s;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

class Student {
	int enrollment;
	String student_name;
	String department_name;
}