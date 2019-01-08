package com.anirudh.Student.pojo;

public class Student {
	
	public Student() {}
	
	public String name;
	public String rollno;
	public int physics;
	public int math;
	public int chemistry;
	public String dob;
	public String photo;
	public String grade;
	public String status;
	
	public Student(String name, String rollno, int physics, int math, int chemistry, String dob, String photo) {
		super();
		this.name = name;
		this.rollno = rollno;
		this.physics = physics;
		this.math = math;
		this.chemistry= chemistry;
		this.dob= dob;
		this.photo=photo;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public int getPhysics() {
		return physics;
	}

	public void setPhysics(int physics) {
		this.physics = physics;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getChemistry() {
		return chemistry;
	}

	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollno=" + rollno + ", physics=" + physics + ", math=" + math
				+ ", chemistry=" + chemistry + ", dob=" + dob + ", photo=" + photo + ", grade=" + grade + ", status="
				+ status + "]";
	}

	
	
	

}
