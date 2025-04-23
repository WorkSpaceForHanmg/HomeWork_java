package workshop.student;

public class Student {
	private int studentId;
	private String name;
	private String major;
	private int grade;
	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
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
	 // 학생 정보 출력 메소드 (선택적)
    public void printStudentInfo() {
        System.out.println(name + " / " + major + " / " + grade + "학년");
    }
    
    public static void main(String[] args) {
        // 학생 객체 생성
        Student student = new Student();
        
        // 필드 값 설정
        student.setName("김민수");
        student.setMajor("컴퓨터공학");
        student.setGrade(3);
        
        // 학생 정보 출력
        student.printStudentInfo();
        
        // 학년 변경 시도 (5학년 - 유효하지 않음)
        System.out.println("5학년으로 변경");
        student.setGrade(5);
    }
	
}
