package com.practice.cruddemo;

import com.practice.cruddemo.dao.StudentDAO;
import com.practice.cruddemo.entities.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			System.out.println("Hello World!");
			// createStudent(studentDAO);
			// readStudent(studentDAO);
			// readAllStudents(studentDAO);
			readStudentByLastname(studentDAO);
		};
	}

	private void readStudentByLastname(StudentDAO studentDAO) {
		List<Student> students = studentDAO.getByLastname("Anjum");
		students.forEach(System.out::println);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create student object
		System.out.println("Creating new student object...");
		Student student = new Student("Talha", "Anjum", "talha@gmail.com");

		// save the student object
		studentDAO.save(student);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + student.getId());

	}

	private void readStudent(StudentDAO studentDAO) {

		// create student object
		System.out.println("Creating new student object...");
		Student student = new Student("Ariba", "Afroz", "ariba@gmail.com");

		// save the student object
		studentDAO.save(student);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + student.getId());

		// get saved student details
		System.out.println("Getting the saved student details");

		Student savedStudent = studentDAO.getById(student.getId());

		if (savedStudent != null) {
			System.out.println("Student details: " + savedStudent);
		} else {
			System.out.println("Student not found for id: " + student.getId());
		}

	}

	private void readAllStudents(StudentDAO studentDAO) {

		System.out.println("Getting all the students data...");

		List<Student> students = studentDAO.getAll();

		students.forEach(s -> System.out.println("Details: " + s));

	}

}
