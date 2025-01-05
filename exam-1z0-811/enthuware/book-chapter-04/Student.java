import java.util.Date;

public class Student {

	private static int count = 0;

	private String studentId;

	static {
		System.out.println("Student class loaded");
	}

	{
		Student.count = Student.count +1;
		System.out.println("Student count incremented");
	}

	public Student(String id) {
		this.studentId = id;

		System.out.println(new Date() + " : Student instance created. Total students is " + count);
	}

	public String toString() {
		return "Student[studentId = " + studentId + "]";
	}

	public static void main(String[] args) {
		Student student = new Student("A1234");

		System.out.println(student.toString());
	}
}
