package lab.student.entity;

public class Student extends Object {
	private String studentId;
	private String name;
	private String major;
	private int grade;
	
	public Student() {
		
	}
	public Student(String name,String major,int grade) {
		
		this.name = name;
		this.major = major;
		this.grade = grade;
	}
	
	public String getStudentId() {
		return studentId;
	}
	
	public String getName() {
		return name;
	}
	public String getMajor() {
		return major;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		if(grade >= 1 && grade <= 4) {
			this.grade = grade;
		}
		else {
			System.out.println("학년은 1~4 사이여야 합니다.");
		}
	}
//	@Override
//	public String toString() {
//		return "Student [name=" + name + ",major=" + major + ", grade=" + grade + "]";
//	}
}
