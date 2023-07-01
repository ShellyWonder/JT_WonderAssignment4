package com.wonderwebdev.domain;

public class Student {
	
private int id;	
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
public Student(int id, String name, String grade, String course) {
	super();
	this.id = id;
	this.name = name;
	this.grade = grade;
	this.course = course;
}
private String name;
private String grade;
private String course;
}
