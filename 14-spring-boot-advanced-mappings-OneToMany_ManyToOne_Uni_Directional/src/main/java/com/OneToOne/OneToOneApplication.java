package com.OneToOne;

import com.OneToOne.dao.AppDAO;
import com.OneToOne.entity.Course;
import com.OneToOne.entity.Instructor;
import com.OneToOne.entity.InstructorDetail;
import com.OneToOne.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class OneToOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(com.OneToOne.OneToOneApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
			createCourseAndReviews(appDAO);
		};
	}

	private void createCourseAndReviews(AppDAO appDAO) {

		// create a course
		Course tempCourse = new Course("Pacman - How To Score One Million Points");

		// add some reviews
		tempCourse.addReview(new Review("Great course .. loved it!!"));
		tempCourse.addReview(new Review("LOL!! You awesome"));
		tempCourse.addReview(new Review("GG dude"));
		tempCourse.addReview(new Review("What a dumb course, you are are an idiot"));


		// save the course and leverage the cascade all
		System.out.println("Saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

		appDAO.save(tempCourse);

		System.out.println("DONE");

	}

	private void deleteCourse(AppDAO appDAO) {
		int theId = 10;

		System.out.println("Deleting course id: " + theId);
		appDAO.deleteCourseById(theId);

		System.out.println("DONE");

	}

	private void updateCourse(AppDAO appDAO) {

		int theId = 10; // verify the course ID

		// find the course
		System.out.println("Finding course id: " + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		// update the course
		System.out.println("Updating Course id: " + theId);
		tempCourse.setTitle("TEST");

		appDAO.update(tempCourse);

		System.out.println("DONE");

	}

	private void updateInstructor(AppDAO appDAO) {

		int theId = 1;

		// find the instructor
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		// update the instuctor
		System.out.println("Updating instructor id: " + theId);
		tempInstructor.setLastName("TESTER");

		appDAO.update(tempInstructor);

		System.out.println("DONE!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int theId = 1;

		// find the instructor
		System.out.println("finding instructor ID: " + theId);
		Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("DONE");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId = 1;
		//find instructor
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor" + tempInstructor);

		// find course for instructor
		System.out.println("Finding courses for instructor id: " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		//associate the objects
		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("DONE");
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
