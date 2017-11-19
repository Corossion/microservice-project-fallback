package de.hftl.dozentproducer;

public class Dozent {
	private int employeeId;
	private String name;
	private String subject;
	
	public Dozent(int employeeId, String name, String subject) {
		this.setEmployeeId(employeeId);
		this.setName(name);
		this.setSubject(subject);
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
