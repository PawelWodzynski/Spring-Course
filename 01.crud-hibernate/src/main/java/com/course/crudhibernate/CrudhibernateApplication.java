package com.course.crudhibernate;

import com.course.crudhibernate.dao.StudentDAO;
import com.course.crudhibernate.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudhibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudhibernateApplication.class, args);}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
//			createStudent(studentDAO);

			createMultipleStudents(studentDAO);

//			readStudent(studentDAO);

//			queryForStudents(studentDAO);

//			queryForStudentsByLastName(studentDAO);

//			updateStudent(studentDAO);

//			deleteStudent(studentDAO);

//			deleteAllStudents(studentDAO);
		};

	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted " +numRowsDeleted + " Students");

	}

	public void deleteStudent(StudentDAO studentDAO){
		int studentId = 3;
		System.out.println("Deleting student id " + studentId);
		studentDAO.delete(studentId);
	}
	private void updateStudent(StudentDAO studentDAO) {
		//retriev student based on the id: primary key
		int studentId = 1;
		System.out.println("getting student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

		//change first name to "Alabama"
		System.out.println("Updating student...");
		myStudent.setFirstName("Alabama");

		//update the student
		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated student " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO){

		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("King");
		//display list of students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}


	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student objecy
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Tomashingo","Kruszingo","fabryka@steropian.com");
		// save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// display id of the saved student
        int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id:" + theId);

		//retrive student based on the id: primary key
		System.out.println("Retrieving student with id " + theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("Found the student: "+myStudent);



	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		//create multiple students
		System.out.println("Creating 3 student objects");
		Student tempStudent1 = new Student("Pahmet","Wodzabala","oilrafinery@turban.com");
		Student tempStudent2 = new Student("Ahmad","Mudhib","oilrafinery@turban.com");
		Student tempStudent3 = new Student("Tobi","King","oilrafinery@turban.com");


		//save the student objects
		System.out.println("Saving the students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);



	}

	private void createStudent(StudentDAO studentDAO) {


		// create the student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Paul","Walker","fastman@ferrari.com");

		// save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}










}
