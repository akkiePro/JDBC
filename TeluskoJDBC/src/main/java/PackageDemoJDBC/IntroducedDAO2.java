package PackageDemoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class IntroducedDAO2 {

	public static void main(String[] args) {
		StudentDAO2 dao = new StudentDAO2();

		Student2 s2 = new Student2();
		s2.enrollment = 11;
		s2.student_name = "Sahil";
		s2.department_name = "IT";
		dao.connect();
		dao.addStudent(s2);

	}

}

class StudentDAO2 {
	Connection conn = null;

	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/demo", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Student2 getStudent(int roll) {
		try {
			String query = "SELECT name FROM student WHERE enroll=" + roll;
			Student2 s = new Student2();
			s.enrollment = roll;

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

	public void addStudent(Student2 s) {
		String query = "INSERT INTO student VALUES (?, ?, ?)";
		PreparedStatement pst;
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, s.enrollment);
			pst.setString(2, s.student_name);
			pst.setString(3, s.department_name);
			int count = pst.executeUpdate();

			System.out.println(count + " row affected");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

class Student2 {
	int enrollment;
	String student_name;
	String department_name;
}