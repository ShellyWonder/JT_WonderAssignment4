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
			// Use an index to track the current course number
		    int courseIndex = 1;
			List<String> courseNames = List.of("APMTH", "COMPSCI", "STAT");

			for (String courseName : courseNames) {
				// separate the data into 3 separate CSV files
				List<Student> courseStudents = studentService.filterStudentsByCourse(allStudents, courseName);
				// sort the data by grade in descending order
				studentService.sortStudentsByGradeDescending(courseStudents);
				// output the data to the 3 separate CSV files
				studentService.saveStudentsToCSV(courseStudents, "course" + courseIndex + ".csv");
				System.out.println("course" + courseIndex + ".csv file generated successfully!");
				// Increment the course index for the next file name
		        courseIndex++;
			}

			/*
			 * NOTE: This method utilizes the "Try-with-resources" construct with
			 * bufferedReader and bufferedWriter. As such, these classes implement
			 * "AutoClosable" and close automatically when the try block is existed
			 */
		} catch (IOException e) {
			System.err.println("Error occurred while saving the CSV file: " + e.getMessage());

		}

	}

}
