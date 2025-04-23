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
			System.out.println("�г��� 1~4 ���̿��� �մϴ�.");
		}
		
	}
	 // �л� ���� ��� �޼ҵ� (������)
    public void printStudentInfo() {
        System.out.println(name + " / " + major + " / " + grade + "�г�");
    }
    
    public static void main(String[] args) {
        // �л� ��ü ����
        Student student = new Student();
        
        // �ʵ� �� ����
        student.setName("��μ�");
        student.setMajor("��ǻ�Ͱ���");
        student.setGrade(3);
        
        // �л� ���� ���
        student.printStudentInfo();
        
        // �г� ���� �õ� (5�г� - ��ȿ���� ����)
        System.out.println("5�г����� ����");
        student.setGrade(5);
    }
	
}
