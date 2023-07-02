package com.wonderwebdev;

import com.wonderwebdev.interfaces.StudentService;
import com.wonderwebdev.domain.Student;
import com.wonderwebdev.services.StudentServiceImpl;

import java.util.List;
import java.io.IOException;

public class StudentEnrollmentApp {

	public static void main(String[] args) {

		// read the file
		String masterListFile = "student-master-list.csv";

		StudentService studentService = new StudentServiceImpl();
		try {
			// parse the file
			List<Student> allStudents = studentService.parseMasterList(masterListFile);
			List<String> courseNames = List.of("Course 1", "Course 2", "Course 3");

			for (String courseName : courseNames) {
				// separate the data into 3 separate CSV files
				List<Student> courseStudents = studentService.filterStudentsByCourse(allStudents, courseName);
				// sort the data by grade in descending order
				studentService.sortStudentsByGradeDescending(courseStudents);
				// output the data to the 3 separate CSV files
				studentService.saveStudentsToCSV(courseStudents, courseName.toLowerCase().trim() + ".csv");
				System.out.println("CSV files generated successfully!");
			}

			/*
			 * NOTE: This method utilizes the "Try-with-resources" construct with
			 * bufferedReader and bufferedReader. As such, these classes implement
			 * "AutoClosable" and close automatically when the try block is existed
			 */
		} catch (IOException e) {
			System.err.println("Error occurred while saving the CSV file: " + e.getMessage());

		}

	}

}
