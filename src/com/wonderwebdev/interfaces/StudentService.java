package com.wonderwebdev.interfaces;

import java.io.IOException;

import java.util.List;

import com.wonderwebdev.domain.*;

public interface StudentService {

	List<Student> parseMasterList(String masterListFile) throws IOException;

	List<Student> filterStudentsByCourse(List<Student> students, String course);

	void sortStudentsByGradeDescending(List<Student> students);

	void saveStudentsToCSV(List<Student> students, String outputFile) throws IOException;

}
