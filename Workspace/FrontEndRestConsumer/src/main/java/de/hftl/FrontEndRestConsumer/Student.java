package de.hftl.FrontEndRestConsumer;

public class Student {
	private int studentId;
    private String name;
    private String major;
    
    // default Constructor for Reflection(turns JSON into Object format to map the properties). See http://blogs.jbisht.com/blogs/2016/09/12/Deserialize-json-with-Java-parameterized-constructor
    public Student() {}
    
    public Student(int studentId, String name, String major) {
		this.studentId = studentId;
		this.name = name;
		this.major = major;
	}
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

}
