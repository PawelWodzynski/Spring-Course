package com.OneToOne;

import com.OneToOne.dao.AppDAO;
import com.OneToOne.entity.Course;
import com.OneToOne.entity.Instructor;
import com.OneToOne.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OneToOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(com.OneToOne.OneToOneApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
//			createInstructor(appDAO);

//			findInstructor(appDAO);

//			deleteInstructor(appDAO);

//			findInstructorDetail(appDAO);

//			deleteInstructorDetail(appDAO);

//			createInstructorWithCourses(appDAO);

			findInstructorWithCourse(appDAO);
		};
	}

	private void findInstructorWithCourse(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor" + tempInstructor);
		System.out.println("the associated courses " + tempInstructor.getCourses());

		System.out.println("DONE");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		// create the instructor
		Instructor tempInstructor = new Instructor("pahmet","wodzabala","oilrafinery@turban.com");

		// create the Instructor Detail
		InstructorDetail tempInstructorDetail= new InstructorDetail("youtube.com/gaming","video games");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses
		Course tempCourse1 = new Course ("Java - The Ultimate Guide");
		Course temoCourse2 = new Course("Java - CRUD App");

		// add course to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(temoCourse2);

		// save the instructor
		//
		// NOTE: this will ALSO save the courses
		// because of CascadeType.PERSIST
		//
		System.out.println("Saving instructor: " + tempInstructor);
		System.out.println("The courses: " +  tempInstructor.getCourses());
		appDAO.save(tempInstructor);


		System.out.println("DONE");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
			int theId = 3;
		System.out.println("Deleting instructor detail id: " + theId);

		appDAO.deleteInstructorDetailById(theId);

		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		// get the instructor detail object
		int theId = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		// prints the instructor detail
		System.out.println("tempinstructorDetail: " + tempInstructorDetail);

		//print the associated instructor
		System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor() );
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Deleting instructor id: " + theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("done");
	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated instructorDetail only: " + tempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {


		// create the instructor
Instructor tempInstructor = new Instructor("pahmet","wodzabala","oilrafinery@turban.com");

		// create the Instructor Detail
		InstructorDetail tempInstructorDetail= new InstructorDetail("youtube.com/pandaisblackitiswhiteanditisasian","zoo");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		//
		// save the instructor
		//
		// NOTE: this will ALSO save details object because of CascadeType.ALL
		//
		System.out.println("Saving Instructor " + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done");

	}

}
