package lab.student.control;

import lab.student.entity.Student;

public class Control{
	public static void main(String[] args) {
		
		Student student = new Student("김민수 ","컴퓨터공학 ",3);
		System.out.println(student.getName() + " / " + student.getMajor() + " / " + student.getGrade() + "학년");
		
		System.out.println("5학년으로 변경");
        student.setGrade(5); 
	}
}
