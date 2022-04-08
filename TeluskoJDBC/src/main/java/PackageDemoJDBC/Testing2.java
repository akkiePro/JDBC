package PackageDemoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Testing2 {
	int enrollment;
	String student_name;
	String department_name;

	public static void main(String[] args) {
//		StudentDAOTest dao = new StudentDAOTest();
		Testing2 t = new Testing2();

		System.out.println("from DB roll no. 5 is...");
		Testing2 t1 = t.getStudent(5);
		System.out.println(t1.student_name);

		System.out.println("from DB roll no. 8 is...");
		Testing2 t2 = t.getStudent(8);
		System.out.println(t2.student_name);
	}

	public Testing2 getStudent(int roll) {
		try {
			String query = "SELECT name FROM student WHERE enroll=" + roll;
			Testing2 obj = new Testing2();
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
 * class StudentDAOTest { public Testing getStudent(int roll) { try { String
 * query = "SELECT name FROM student WHERE enroll=" + roll; Testing obj = new
 * Testing(); obj.enrollment = roll;
 * 
 * Class.forName("com.mysql.jdbc.Driver"); Connection conn =
 * DriverManager.getConnection("jdbc:mysql://localhost/demo", "root", "root");
 * Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(query);
 * 
 * rs.next(); String name = rs.getString(1); obj.student_name = name; return
 * obj; } catch (Exception e) { e.printStackTrace(); } return null; } }
 */