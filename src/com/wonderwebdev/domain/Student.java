package com.wonderwebdev.domain;

public class Student {

	private String id;
	private String name;
	private String course;
	private int grade;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Student(String id, String name, String course, int grade) {
		super();
		this.id = id;
		this.name = name;
		this.course = course;
		this.grade = grade;
	}
}
