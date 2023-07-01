package com.wonderwebdev.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.wonderwebdev.domain.Student;
import com.wonderwebdev.interfaces.StudentService;


public class StudentServiceImpl implements StudentService {

	
	public List<Student> parseMasterList(String masterListFile) throws IOException {
		List<Student> students = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(masterListFile))) {
			//Check for BOM and skip it if present;
			if(br.markSupported()) {
				br.mark(1);
				if(br.read()!= '\uFEFF') {
					br.reset();
				}
			}
			//skip header
			br.readLine();
		}
		return students;
	}

	
	public List<Student> filterStudentsByCourse(List<Student> students, String course) {
		// TODO Auto-generated method stub
		return null;
	}

	public void sortStudentsByGradeDescending(List<Student> students) {
		// TODO Auto-generated method stub

	}

	public void saveStudentsToCSV(List<Student> students, String outputFile) throws IOException {
		// TODO Auto-generated method stub

	}

}
