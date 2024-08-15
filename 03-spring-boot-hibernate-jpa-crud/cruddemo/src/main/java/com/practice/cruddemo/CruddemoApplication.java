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
			/*
			createStudent(studentDAO);
			readStudent(studentDAO);
			readAllStudents(studentDAO);
			readStudentByLastname(studentDAO);
			updateStudent(studentDAO);
			deleteStudent(studentDAO);
			 */
			deleteAllStudent(studentDAO);

		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Deleted rows: " + studentDAO.deleteAll());
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int id = 3;
		System.out.println("Deleting student with id: " + id);
		studentDAO.delete(id);
		System.out.println("Deleted");
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student by id
		int studentId = 2;
		System.out.println("Retrieving student object...");
		Student student = studentDAO.getById(studentId);

		// change firstname and lastname
		System.out.println("updating student object...");
		student.setFirstname("Mohammed");
		student.setLastname("Talha");

		// update the student
		System.out.println("Saving student object...");
		studentDAO.update(student);

		// display updated student
		System.out.println("Updated student object: " + studentDAO.getById(studentId));
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
