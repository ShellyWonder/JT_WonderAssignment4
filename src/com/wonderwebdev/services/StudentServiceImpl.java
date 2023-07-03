package com.wonderwebdev.services;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.wonderwebdev.domain.Student;
import com.wonderwebdev.interfaces.StudentService;

public class StudentServiceImpl implements StudentService {

	public List<Student> parseMasterList(String masterListFile) throws IOException {
		List<Student> students = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(masterListFile))) {
			/*
			 * Note: the following code was place here due to random characters interfering with the parse. 
			 * The "mark" code resolved the issue
			 * */
			// Check for byte order mark(BOM) and skip it if present;
			if (br.markSupported()) {
				br.mark(1);
				if (br.read() != '\uFEFF') {
					br.reset();
				}
			}
			// skip header
			br.readLine();
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");
				if (data.length >= 4) {
					String id = data[0].trim();
					String name = data[1].trim();
					String course = data[2].trim();
					int grade;
					try {
						grade = Integer.parseInt(data[3].trim());
					} catch (NumberFormatException e) {
						// Handle invalid grade value, e.g., skip the student
						System.err.println("Invalid grade value for student: " + name);
						continue;
					}
					students.add(new Student(id, name, course, grade));
				}
			}
		}

		return students;
	}

	public List<Student> filterStudentsByCourse(List<Student> students, String course) {
		List<Student> filteredStudents = new ArrayList<>();
		/*NOTE: I chose .startsWith over .equals because the course section numbers were interfering with the sort.
		 * --.startsWith eliminated that problem*/
		for (Student student : students) {
			if (student.getCourse().startsWith(course)) {
				filteredStudents.add(student);
			}
		}
		return filteredStudents;
	}

	
	public void sortStudentsByGradeDescending(List<Student> students) {
		Collections.sort(students, Comparator.comparingInt(Student::getGrade).reversed());//reversed denotes descending order

	}

	public void saveStudentsToCSV(List<Student> students, String outputFile) throws IOException {
    try (FileWriter writer = new FileWriter(outputFile)) {
        for (Student student : students) {
            writer.append(student.getId())
                    .append(',')
                    .append(student.getName())
                    .append(',')
                    .append(student.getCourse())
                    .append(',')
                    .append(String.valueOf(student.getGrade()))
                    .append('\n');
        }
        
    }
}

}
